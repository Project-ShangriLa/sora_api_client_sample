# -*- coding: utf-8 -*-
import requests
import sys

def usage(flag):
    print ".client.py -y [year] -n [number]"
    if flag == 1 :
        print "renge of [year] is 2013 form 2015."
    if flag == 2 :
        print "renge of [number] is 1 form 4."
    exit(1)


if __name__ == '__main__':
    url='http://api.moemoe.tokyo/anime/v1/master/'
    param = sys.argv
    argc = len(param)
    flag=0

    options = [option for option in param if option.startswith('-')]

    if argc != 1 and argc != 3 and argc != 5 :
        usage(0)

    if '-h' in options or '--help' in options:
        usage()
    if '-y' in options :
        year = param[2]
        #if year < "2014" or year > "2015" : usage(1)
        get = year
        if '-n' in options :
            number = param[4]
            if number < "1" or number > "4" : usage(2)
            get =   year +"/" + number

    if argc == 1:
        get = "list"

    url = url + get
    r = requests.get(url)
    print r.text.encode('utf_8')
    exit(0)

    #print r.status_code
    #print r.encoding

