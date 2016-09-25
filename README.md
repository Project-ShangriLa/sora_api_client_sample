sora_api_client_sample - a script for sora-playframework-scala
===============================================================

ShangriLa Anime API Server Sora (穹) を叩くサンプルプログラムです.

サンプルプログラムは, 以下の言語実装があります.

- golang
- PHP
- python
- Scala
- Groovy
- Kotlin

プログラムの詳細は各ディレクトリを参照ください.

`golang/`と`php/`の中にあるプログラムは, オプションをチェックする機能が
未実装のため, 正しくオプションをつけた時のみしか動作を保証していません.

golang
-------

### soraClient.go

#### Usage

```
./soraClient.go [-y year] [-n number] | jq .
```

取得した JSON を jq コマンド (Comannd-line JSON processor) で整形します.
オプションを指定せずに実行すると, ShangriLa API Server が持っているアニメ情報
のクールごとの情報のリストを取得する.

#### Options

##### -y year

`year`で指定した YYYY 年のアニメの 1 クールから 4 クールまでの情報を取得する.

##### -n number

`number`で指定したクールの情報をすべて取得します. ただし, `-y`オプションを
一緒に使用する必要があります.

#### Compile

```
$ go build soraClient.go
```

php
------

### soraClient.php

#### Usage

```
./soraClient.php [-y year] [-n number] | jq .
```

取得した JSON を jq コマンド (Comannd-line JSON processor) で整形します.
オプションを指定せずに実行すると, ShangriLa API Server が持っているアニメ情報
のクールごとの情報のリストを取得する.

#### Options

##### -y year

`year`で指定した YYYY 年のアニメの 1 クールから 4 クールまでの情報を取得する.

##### -n number

`number`で指定したクールの情報をすべて取得します. ただし, `-y`オプションを
一緒に使用する必要があります.

#### Note

`t/`ディレクトリにテストスクリプトが入っていますが, テストケースが少なすぎる
ので, テストケースを生成するジェネレータを作成する必要がある.



python
-------

### soraClient.py
#### Requirements
 - Python3.x
 - Python libraries installed with pip
   - requests
   - argparse

```
$pip3 install requests  
$pip3 install argparse
```
#### Usage

```
$ python3.4 soraClient.py [-y year] [-n number] | jq .
```

goと同様です.

#### Options

goと同様です.
