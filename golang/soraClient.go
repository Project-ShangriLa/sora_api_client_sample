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
	"log"
)

func main() {
	const baseurl = "http://api.moemoe.tokyo/"
	const suburl = "anime/v1/master/"
	const minYear = 2014

	var year int
	var url string
	var y, n int

	flag.IntVar(&y, "y", 999, "指定された年のアニメの情報を取得する")
	flag.IntVar(&n, "n", 999, "アニメのクール")
	flag.Parse()

	url = baseurl + suburl
	if y != 999 {
		year, _ = strconv.Atoi(time.Now().Format("2006"))
		if y < minYear || year < y {
			fmt.Println("年を正しく入力してください")
			return
		}
		url += strconv.Itoa(y)

		if n != 999 {
			if n < 1 || 5 < n {
				fmt.Println("クールを正しく入力してください")
				return
			}
			url += "/" + strconv.Itoa(n)
		}
	} else {
		url = baseurl + suburl + "cours"
	}

	response, err := http.Get(url)
	if err != nil {
		log.Fatal(err)
	}
	defer response.Body.Close()

	body, err := ioutil.ReadAll(response.Body)
	if err != nil {
		log.Fatal(err)
	}
	result := string(body)

	fmt.Println(result)
}
