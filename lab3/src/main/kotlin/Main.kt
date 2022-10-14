// uzbiera

// odpowiednią ilość punktów aby uzyskać wpis na kolejny semestr. Należy zdefiniować
// zmienną hasCredit, która pozwoli przechowywać informacje czy student zdobył
// zaliczenie jednego z tych przedmiotów czy nie. Zadeklaruj jawnie typ tej zmiennej
// i zadbaj o to aby jej początkowy stan określał, że student zaliczenia nie uzyskał.

// Student posiada również inne atrybuty, które go opisują. W ramach tego zadania poniżej
// zmiennej hasCredit, należy dodać zmienne, które pozwolą na zapisanie: nazwy uczelni,
// imienia studenta oraz jego numeru albumu (tylko cyfry), korzystając z mechanizmu
// wnioskowania typów, modyfikowanie wartości tych zmiennych nie powinno być możliwe.

// Student charakteryzuje się również aurą, która emanuje odpowiednim kolorem
// w zależności od jego poziomu zadowolenia. Poziom zadowolenia studenta jest wartością
// liczbową z zakresu od 0 do 20 i obliczą się ją zgodnie z poniższym wyrażeniem:
// val satisfactionLevel = (Math.pow(Math.random(), (110 - studentPoints) / 100.0) * 20).toInt()
// Wartość poziomu zadowolenia prezentuje się następująco:
// 0 - 5 - kolor aury: red
// 6 - 10 - kolor aury: orange
// 11 - 15 - kolor aury: purple
// 16 - 20 - kolor aury: green
// Wartość poziomu zadowolenia należy wyliczyć, używając wyrażenia podanego
// wcześniej, a następnie określić kolor aury, używając odpowiedniego wyrażenia
// warunkowego.

// Z kodu który powstał do realizacji punktów 2-4 wydziel logikę odpowiedzialną za
// obliczanie aury studenta. Kod ten zamknij w funkcji auraColor, do funkcji przekaż
// parameter studentPoints, który domyślnie jest ustawiony na 2. Funkcja powinna być taka
// przygotowana aby była typu Unit.

fun auraColor(studentPoints: Int = 2) {
    val satisfactionLevel = (Math.pow(Math.random(), (110 - studentPoints) / 100.0) * 20).toInt()
    val auraColor =
            when (satisfactionLevel) {
                in 0..5 -> "red"
                in 6..10 -> "orange"
                in 11..15 -> "purple"
                in 16..20 -> "green"
                else -> "unknown"
            }
    // print("$auraColor")
}

// Do kodu dodaj funkcje printStudentStatus, przyjmująca jako argumenty imię studenta
// oraz jego aurę. Funkcja ta powinna wyświetlać komunikat o statusie studenta w postaci
// "$name has a $auraColor face color", na przykład „Mike has a red face color”.
fun printStudentStatus(name: String, auraColor: Unit) {
    println("$name has a $auraColor face color")
}

fun main() {
    val hasCredit: Boolean = false
    val university = "AGH"
    val name = "Jan"
    val albumNumber = 123456

    val studentPoints = 0

    val auraColor = auraColor(studentPoints)
    printStudentStatus(auraColor = auraColor, name = name)
}
