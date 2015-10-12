#!/usr/bin/php -q
<?php
/*
 * Copyright (c) Rirei Kuroshima
 */

/* Defines a named constant */
define("BASEURL", "http://api.moemoe.tokyo/");
define("SUBURL", "anime/v1/master/");

/* URL of ShangriLa Anime API Server (Sora). */
$url = BASEURL . SUBURL . "cours";

/* Decodes a JSON string. */
$json = file_get_contents($url);

print($json);

?>
