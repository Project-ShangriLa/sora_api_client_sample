#!/usr/bin/php -q
<?php
/*
 * Copyright (c) Rirei Kuroshima
 */

function usage()
{
        $usage_string = <<<EOM
Name
    soraClient.php - ShangriLa APIを叩くPHPプログラム

Synopsis
    soraClient.php
    soraClient.php -y year
    soraClient.php -y year -n number

Description
    ShangriLa APIを叩くPHPプログラムです。オプション無しで実行すると、アニメ
    情報のクールごとの情報のリストを取得します。

    -yを指定すると、yearで指定したYYYY年のアニメ1クールから4クールまでの情報を
    全て取得します。

    -yと-nオプションを指定すると、yearで指定されたYYYY年アニメのnumberで指定
    されたクール情報を全て取得します。
EOM;
        echo $usage_string . "\n";
}

$options = getopt("y:n:");

/* Defines a named constant */
define("BASEURL", "http://api.moemoe.tokyo/");
define("SUBURL", "anime/v1/master/");

/* URL of ShangriLa Anime API Server (Sora). */
$url = BASEURL . SUBURL;
if(array_key_exists("y", $options)) {
        if(is_int($options["y"]) === false) {
                usage();
                exit(1);
        }
        $url .= $options["y"];

        if(array_key_exists("n", $options)) {
                if(is_int($options["n"]) === false) {
                        usage();
                        exit(1);
                }
                $url .= "/" . $options["n"];
        }
} else {
        $url .= "cours";
}

/* Decodes a JSON string. */
$json = file_get_contents($url);

print($json);
exit(0);

?>
