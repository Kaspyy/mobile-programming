package com.example.myapplication

//utwórz klasę Student z właściwościami: name i lastname oraz nadpisz metodę
//toString()
data class Student(val name: String, val lastname: String) {
    override fun toString(): String {
        return "$name $lastname"
    }
}