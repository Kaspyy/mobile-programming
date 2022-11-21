// 2. Deklarowanie zmiennych i interpolacja ciągu tekstowego.
// Student może zdobyć zaliczenie z informatyki lub matematyki, dzięki czemu uzbiera
// odpowiednią ilość punktów aby uzyskać wpis na kolejny semestr. Należy zdefiniować
// zmienną points, która pozwoli przechowywać informacje na temat ilości zdobytych
// przez studenta punktów. Skorzystaj z możliwości analizy tworzonych zmiennych
// i ustalenia typu tej zmiennej przez Swift i zadbaj o to aby zmienna była typu Double
// bez jawnego definiowania. Następnie za pomocą interpolacji ciągu tekstowego
// wyświetl informację na temat ilość punktów uzyskanych przez studenta np. „Student
// has 5.0 points.".

import Foundation
// zdefiniuj zmienną points
var points = 5.0

// wyświetl informację na temat ilości punktów
print("Student has \(points) points.")

// 3. Wyrażenie warunkowe.
// Student charakteryzuje się również aurą, która emanuje odpowiednim kolorem
// w zależności od jego poziomu zadowolenia. Poziom zadowolenia studenta jest
// wartością liczbową z zakresu od 0 do 20 i obliczą się ją zgodnie z poniższym
// wyrażeniem:
// var satisfactionLevel = round(pow(Double.random(in: 0...1), (110 - points) / 100) * 20)

var satisfactionLevel = round(pow(Double.random(in: 0...1), (110 - points) / 100) * 20)

// zdefiniuj funkcję, która przyjmuje jako argument wartość liczbową

func auraColor(satisfactionLevel: Double) -> String {
    // wykorzystaj wyrażenie warunkowe, aby ustalić kolor aury
    if satisfactionLevel < 5 {
        return "red"
    } else if satisfactionLevel < 10 {
        return "orange"
    } else if satisfactionLevel < 15 {
        return "yellow"
    } else {
        return "green"
    }
}

// wywołaj funkcję i wyświetl wynik
print(auraColor(satisfactionLevel: satisfactionLevel))

// 4. Klasy.
// Każdy student ma imię, nazwisko oraz posiada punkty, zdefiniuj klasę Student, która
// to jednoznacznie opisze. Użyj metody inicjalizacyjnej do określenia wartości
// początkowych jej właściwości.

class Student {
    var firstName: String
    var lastName: String
    var points: Double
    
    init(firstName: String, lastName: String, points: Double) {
        self.firstName = firstName
        self.lastName = lastName
        self.points = points
    }
}

// 5. Enkapsulacja i metody klasowe.
// Oznacz wszystkie właściwości zdefiniowane w klasie Student jako prywatne. Dodaj
// metodę showStudent, która wyświetli aurę studenta za pomocą wyrażenia
// warunkowego zdefiniowanego w punkcie 3, np. „Mike has a red face color” i będzie
// dostępna tylko w swoim module. Wywołaj metodę showStudent bez żadnych
// argumentów.

class Student {
    private var firstName: String
    private var lastName: String
    private var points: Double
    
    init(firstName: String, lastName: String, points: Double) {
        self.firstName = firstName
        self.lastName = lastName
        self.points = points
    }
    
    func showStudent() {
        print("\(firstName) has a \(auraColor(satisfactionLevel: satisfactionLevel)) face color")
    }
}

// 6. Dziedziczenie.
// Imię jest charakterystyczne dla każdej osoby, nie tylko studenta. Zdefiniuj klasę
// bazową Person, w której umieścisz właściwości name i lastname. Klasa Student
// powinna być potomną klasy nadrzędnej Person i zawierać tylko właściwość points.
// Klasy Person i Student powinny mieć zdefiniowane metody inicjalizacyjne. Utwórz
// instancję klasy Student i za pomocą metody showStudent zaimplementowanej
// w ramach punktu 5 wyświetl aurę studenta.

class Person {
    var firstName: String
    var lastName: String
    
    init(firstName: String, lastName: String) {
        self.firstName = firstName
        self.lastName = lastName
    }
}

class Student: Person {
    var points: Double
    
    init(firstName: String, lastName: String, points: Double) {
        self.points = points
        super.init(firstName: firstName, lastName: lastName)
    }
    func showStudent() {
        print("\(firstName) has a \(auraColor(satisfactionLevel: satisfactionLevel)) face color")
    }
}

let student = Student(firstName: "Mike", lastName: "Smith", points: 5.0)
student.showStudent()