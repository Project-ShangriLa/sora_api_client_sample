#pythonのテストコードです
穹さんから情報を取ってきます。

##実行環境
Python 2.7.6

###Usage
./client.py [-y year] [-n number]
	オプションを指定せずに実行すると、ShangriLa API Serverが持っている
	アニメ情報のクールごとの情報のリストを取得する。
	出力結果をパイプでjsonに渡すことで、整形もしてくれます。

Options:
	-y year
		yearで指定したYYYY年のアニメの1クールから4クールまでの情報を取得する。
	-n number
		numberで指定したクールの情報をすべて取得する。
		ただし、−yオプションと一緒に使用する必要があります。

####メモ
requests取ってくる必要があるかも。


