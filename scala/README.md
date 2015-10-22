# sora_api_client_scala_sample

Sora APIの Scalaサンプルコード。

# 使い方

前提となるソフトウェアをインストール後、実行の手順を実施してください。

## 前提

1. [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)をインストール。
2. [Scala 2.11.7](http://www.scala-lang.org/download/)をインストール。
3. [sbt 0.13.9](http://www.scala-sbt.org/download.html)をインストール。

## 実行

1. 本プロジェクトをローカルにクローンする。
2. sora_api_client_scala_sampleディレクトリで以下のコマンドを実行。
```
sbt run
```

実行後は、以下のAPIのレスポンスを、コンソールに表示します。

- GET /anime/v1/master/cours
- GET /aime/v1/master/:year
- GET /anime/v1/master/:year/:n
