# sora_api_client_groovy_sample

Sora APIの Groovyサンプルコード。

# 使い方

前提となるソフトウェアをインストール後、実行の手順を実施してください。

## 前提

1. [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)をインストール。
2. [Gradle](https://docs.gradle.org/current/userguide/installation.html)をインストール。

## 実行

1. 本プロジェクトをローカルにクローンする。
2. sora_api_client_sample/groovyディレクトリで以下のコマンドを実行。
```
gradle run
```

実行後は、以下のAPIのレスポンスを使った処理結果を、コンソールに表示します。

- GET /anime/v1/master/cours
- GET /anime/v1/master/:year
- GET /anime/v1/master/:year/:n
