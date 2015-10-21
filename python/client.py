# -*- coding: utf-8 -*-
import argparse
import requests
import sys

if __name__ == '__main__':
    url='http://api.moemoe.tokyo/anime/v1/master/'
    param = sys.argv
    argc = len(param)

    parser = argparse.ArgumentParser()
    parser.add_argument('-y',type=int,choices=range(2013,2016),default=0)
    parser.add_argument('-n',type=int,choices=range(1,5),default=0)
    args=parser.parse_args()

    if argc != 1 and argc != 3 and argc != 5 :
        print ("arguments num is wrong.")
        exit(1)

    if args.y == 0:
        if args.n != 0 :
            print ("use [-n] with [-y].")
            exit(1)
        else :
            get = "cours"
    else :
        get = str(args.y)
        if args.n != 0 :
            get = get + "/" +str(args.n)

    url = url + get
    print url
    #r = requests.get(url)
    #print (r.text)
    exit(0)

