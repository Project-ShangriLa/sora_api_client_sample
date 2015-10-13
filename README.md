sora-test - a script for sora-playframework-scala
=================================================

This directory holds many test scripts and programs for
sora-palyframework-scala tools. The first part of this short document
describes how to run the tests and read their output.

soraClient.go
--------------

### Usage

```
./soraClient.go [-y year] [-n number] | jq .
```

取得したJSONをjqコマンド (Comannd-line JSON processor) で整形します。オプションを
指定せずに実行すると、ShangriLa API Serverが持っているアニメ情報のクールごとの情報の
リストを取得する。

### Options

#### -y year

`year`で指定したYYYY年のアニメの1クールから4クールまでの情報を取得する。

#### -n number

`number`で指定したクールの情報をすべて取得します。ただし、`-y`オプションを一緒に使用する
必要があります。

### Compile

```
$ go build soraClient.go
```

### Note
URLの読込みにgcfgを使用します。以下、gcfgのインストール方法です。

```
$ go get code.google.com/p/gcfg
```

gcfgをインストールしたくない場合は、
`c4318e2cc141544385c97f47d2dbe3f250494085`をチェックアウトしてください。

```
$ git checkout c4318e2cc141544385c97f47d2dbe3f250494085
```
