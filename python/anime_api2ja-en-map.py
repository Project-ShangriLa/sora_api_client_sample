import json
import urllib.request
import csv

url = 'http://api.moemoe.tokyo/anime/v1/master/2022/2'

master_list = []
req = urllib.request.Request(url)
with urllib.request.urlopen(req) as res:
    master_list_json = json.load(res)
    for master in master_list_json:
        #print(master['title'] + "," + master['title_en'])
        master_list.append([master['title'], master['title_en']])

with open('anime_list.csv', 'w', newline='') as f:
    writer = csv.writer(f)
    writer.writerows(master_list)