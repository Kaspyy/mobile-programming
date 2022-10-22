// 2. Funkcje lambda.
// Zdefiniuj funkcję lambda, która przyjmuje imię i aurę studenta jako argumenty.
// Funkcję powinna zostać zapisana w zmiennej studentStatus bez wyraźnego
// określania typu wyniku i wyświetlać komunikat o statusie ucznia w postaci „$name
// has a $auraColour face color”, na przykład „Mike has red face color”. Wywołaj funkcję
// studentStatus z przykładowymi argumentami.

fun main() {
    val studentStatus = { name: String, auraColor: String ->
        println("$name has a $auraColor face color")
    }
    studentStatus("Mike", "red")

    // val student = Student("Mike", "Politechnika Warszawska")
    // student.showStudent()
    val student = Student("mike")
    student.showStudent()
}

// 3. Klasy.
// Każdy student ma imię, zdefiniuj klasę Student, która to jednoznacznie opisze. Nie
// przekazuj imienia studenta przez konstruktor, przypisz wartość właściwości name
// bezpośrednio w ciele klasy. Z uwagi na to, że właściwość name zawiera imię
// studenta zadbaj o to, by jej wartość zawsze zaczynała się od dużej litery, skorzystaj
// do tego z nadpisania metody get.

// class Student {
//     var name: String = "mike"
//         get() = field.replaceFirstChar { transform -> transform.uppercase() }
// }

// 4. Konstruktory.
// Podobnie jak w punkcie 3, zdefiniuj klasę Student, tym razem użyj konstruktora do
// określenia wartości początkowych jej właściwości. W tym przypadku instancja klasy
// Student oprócz właściwości name powinna posiadać również właściwość university,
// której wartość należy ustawić domyślnie, jeśli nie zostanie przekazana w wywołaniu
// konstruktora.

// class Student {
//     var name: String
//         get() = field.replaceFirstChar { transform -> transform.uppercase() }
//     var university: String

//     constructor(name: String, university: String = "PK") {
//         this.name = name
//         this.university = university
//     }
// }

// 5. Enkapsulacja i funkcje klasowe.
// Oznacz wszystkie właściwości zdefiniowane w klasie Student jako prywatne. Dodaj
// publiczną funkcję lambda showStudent, która wyświetla imię studenta i jego uczelnię.
// Wywołaj metodę showStudent bez żadnych argumentów.

// class Student {
//     private var name: String
//         get() = field.replaceFirstChar { transform -> transform.uppercase() }
//     private var university: String

//     val showStudent = { name: String, university: String -> println("$name, $university") }

//     constructor(name: String, university: String = "PK") {
//         this.name = name
//         this.university = university
//     }

//     fun showStudent() {
//         showStudent(name, university)
//     }
// }

// 6. Dziedziczenie
// Imię jest charakterystyczne dla każdej osoby, nie tylko studenta. Zdefiniuj klasę
// bazową Person, w której umieścisz właściwość name. Klasa Student powinna być
// pochodną klasy Person i dodatkowo zawierać właściwość university. Klasy Person
// i Student powinny mieć zdefiniowane konstruktory podstawowe. Utwórz instancję
// klasy Student i za pomocą metody showStudent zaimplementowanej w ramach
// punktu 5 wyświetl imię studenta oraz nazwę jego uczelni.

// create an open class Person with a name property and base constructor
open class Person constructor(var name: String) {
    init {
        name = name.replaceFirstChar { transform -> transform.uppercase() }
    }
}

// create a class Student that inherits from Person and has a university property
class Student constructor(name: String, var university: String = "PK") : Person(name) {
    val showStudent = { name: String, university: String -> println("$name, $university") }

    fun showStudent() {
        showStudent(name, university)
    }
}
