#!/usr/bin/php -q
<?php
/*
 * Copyright (c) Rirei Kuroshima
 */

$options = getopt("y:n:");

/* Defines a named constant */
define("BASEURL", "http://api.moemoe.tokyo/");
define("SUBURL", "anime/v1/master/");

/* URL of ShangriLa Anime API Server (Sora). */
$url = BASEURL . SUBURL;
if(array_key_exists("y", $options)) {
        $url .= $options["y"];
        if(array_key_exists("n", $options)) {
                $url .= "/" . $options["n"];
        }
} else {
        $url .= "cours";
}

/* Decodes a JSON string. */
$json = file_get_contents($url);

print($json);

?>
