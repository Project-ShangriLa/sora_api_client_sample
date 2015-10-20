sora_api_client_sample - a script for sora-playframework-scala
===============================================================

ShangriLa Anime API Server Sora (穹) を叩くサンプルプログラムです.

サンプルプログラムは, golang, PHP, python の言語で実装されています. プログラム
の詳細は各ディレクトリを見てください.

`golang/`と`php/`の中にあるプログラムは, オプションをチェックする機能が
まだまだなので, 正しくオプションをつけた時のみしか動作を保証していません.

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

#### Note

URL の読込みに gcfg を使用します. 以下, gcfg のインストール方法です.

```
$ go get code.google.com/p/gcfg
```

gcfg をインストールしたくない場合は,
`c4318e2cc141544385c97f47d2dbe3f250494085`をチェックアウトしてください.

```
$ git checkout c4318e2cc141544385c97f47d2dbe3f250494085
```

ただし, 上記コマンドを実行すると, PHP と python のプログラムがない状態になりま
す.

なので, gcfg をインストールすることを推奨します.

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

### client.py

#### Usage

```
./client.py [-y year] [-n number] | jq .
```

goと同様です.

#### Options

goと同様です.

#### Note

環境：Python 2.7.6．

ライブラリ:requestsが必要です．

