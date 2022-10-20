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
}

fun auraColorString(studentPoints: Int = 2): String {
    val satisfactionLevel = (Math.pow(Math.random(), (110 - studentPoints) / 100.0) * 20).toInt()
    val auraColor =
            when (satisfactionLevel) {
                in 0..5 -> "red"
                in 6..10 -> "orange"
                in 11..15 -> "purple"
                in 16..20 -> "green"
                else -> "unknown"
            }
    return auraColor
}

fun printStudentStatus(name: String, auraColor: String) {
    println("$name has a $auraColor face color")
}

fun main() {
    val hasCredit: Boolean = false
    val university = "AGH"
    val name = "Jan"
    val albumNumber = 123456

    val studentPoints = 0

    printStudentStatus(auraColor = auraColorString(), name = name)
}
