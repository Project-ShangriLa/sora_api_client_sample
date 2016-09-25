# sora_api_client_groovy_sample

Sora APIの Kotlinサンプルコードです。
また、Javaのライブラリもいくつか利用しています。

# 使い方

前提となるソフトウェアをインストール後、実行の手順を実施してください。

## 前提

1. [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)をインストール。
2. [Gradle](https://docs.gradle.org/current/userguide/installation.html)をインストール。
3. [Kotlin](https://kotlinlang.org/docs/tutorials/command-line.html)をインストール。

## 実行

1. 本プロジェクトをローカルにクローンする。
2. sora_api_client_sample/kotlinディレクトリで以下のコマンドを実行。

```
gradle run
```

実行後は、以下のAPIのレスポンスを使って2016年4クール目のデータを取得、
タイトルと公式HPをコンソールに表示します。
- GET /anime/v1/master/:year/:n
