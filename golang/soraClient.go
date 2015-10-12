//
// Copyright (c) 2015 Rirei Kuroshima
//
package main

import (
	"fmt"
	"net/http"
	"io/ioutil"
	"flag"
	"strconv"
	"time"
	"code.google.com/p/gcfg"
)

type Config struct {
	Url struct {
		Baseurl string
		Suburl string
	}
}

func main() {
	var cfg Config
	gcfg.ReadFileInto(&cfg, "soraClient.gcfg")

	var year int
	var url string
	var y = flag.Int("y", 999, "指定された年のアニメの情報を取得する")
	var n = flag.Int("n", 999, "アニメのクール")
	flag.Parse()

	if *y != 999 {
		year, _ = strconv.Atoi(time.Now().Format("2006"))
		if *y > year {
			fmt.Println("年を正しく入力してください")
			return
		}

		if *n != 999 {
			if *n < 1 || 5 < *n {
				fmt.Println("クールを正しく入力してください")
				return
			}

			url = cfg.Url.Baseurl + cfg.Url.Suburl +
				strconv.Itoa(*y) + "/" + strconv.Itoa(*n)
		} else {
			url = cfg.Url.Baseurl + cfg.Url.Suburl +
				strconv.Itoa(*y)
		}
	} else {
		url = cfg.Url.Baseurl + cfg.Url.Suburl + "cours"
	}

	response, _ := http.Get(url)
	defer response.Body.Close()

	body, _ := ioutil.ReadAll(response.Body)
	result := string(body)

	fmt.Println(result)
}
