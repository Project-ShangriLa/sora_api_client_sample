#!/usr/bin/php -q
<?php
/*
 * Copyright (c) Rirei Kuroshima
 */

/* Defines a named constant */
define("BASEURL", "http://api.moemoe.tokyo/");
define("SUBURL", "anime/v1/master/");

/* URL of ShangriLa Anime API Server (Sora). */
$url = BASEURL . SUBURL;
if(array_key_exists(1, $argv)) {
        $url .= $argv[1];
        if(array_key_exists(2, $argv)) {
                $url .= "/" . $argv[2];
        }
} else {
        $url .= "cours";
}

/* Decodes a JSON string. */
$json = file_get_contents($url);

print($json);

?>
