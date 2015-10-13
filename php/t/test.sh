#!/bin/bash
#
# Copyright (c) 2015 Rirei Kuroshima <rirekuroshima@icloud.com>
#

echo "*** test.sh ***"
csvfile=testdata.csv

for line in `cat ${csvfile} | grep -v ^#`
do    
    total_start_time=`date +%s`
    
    program=`echo ${line} | cut -d ',' -f 1`
    opt1=`echo ${line} | cut -d ',' -f 2`
    opt1arg=`echo ${line} | cut -d ',' -f 3`
    opt2=`echo ${line} | cut -d ',' -f 4`
    opt2arg=`echo ${line} | cut -d ',' -f 5`
    expected=`echo ${line} | cut -d ',' -f 6`

    # Test
    cd .. >/dev/null 2>&1
    $program $opt1 $opt1arg $opt2 $opt2arg >/dev/null 2>&1
    actual=`echo $?`
    cd - >/dev/null 2>&1

    if [ ${expected} == ${actual} ]; then
        total_end_time=`date +%s`  # 終了時間を取得
        s=$((total_end_time - total_start_time))  # 計測時間を計算し表示
        now=`date "+%Y:%m:%d"`
        echo -e "[${now}] ${API} ............... ok\t${s} s"
    else
        echo "-------------------------"
        echo -e "$program $opt1 $opt1arg $opt2 $opt2arg"
        echo -e "expected: ${expected}"
        echo -e "actual: ${actual}"
    fi
done
