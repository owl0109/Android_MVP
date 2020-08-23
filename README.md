# Model/View/Presenterの役割と違い

## Model
* Modelはデータやビジネスロジックを格納する。
* UIに関するロジックを持たない
* データベースやAPIアクセスに関する処理が入る
* 直接Viewにアクセスしない。Presenterを中継する

## View
* View(androidのviewとは別)はデータの表示を行う。
* 直接Modelにアクセスしない。Presenterを中継する

## Presenter
* タップ時の処理等のアクションを実装する
* PresenterはModelとViewの中間に位置する。相互のやり取りを仲介する
* イベントに応じた処理を実装する

# MVPのメリット
* 役割を明確に分けることでどの処理がどこにあるのか明確になる(メンテナンス性の向上)。
* 役割を分離できるため、Activituyを小さくできる
* ViewとModelの間にPresenterが入るため、ViewとModelの依存関係がなくなる

# MVPのデメリット
* Presenterはインターフェースを通してアクセスする。よってそれぞれのインターフェースを定義する。これが冗長化する
* 設計上の難易度が高い
