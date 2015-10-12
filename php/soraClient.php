<?php
/*
 * Copyright (c) Rirei Kuroshima
 */

/* URL of ShangriLa Anime API Server (Sora). */
$url = "http://api.moemoe.tokyo/anime/v1/master/cours";

/* Decodes a JSON string. */
$json = file_get_contents($url);

print($json);

?>
