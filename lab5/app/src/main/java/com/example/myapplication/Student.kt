package com.example.myapplication

data class Student(val name: String, val lastname: String) {
    override fun toString(): String {
        return "$name $lastname"
    }
}