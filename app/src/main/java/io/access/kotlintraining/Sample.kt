package io.access.kotlintraining

import java.util.*

fun welcome() {
    println("welcome to ACCESS!")
}

fun hello() {
    println("Hello World!")
}

// Exercise1-1
fun fizzBuzz(num: Int): String {
    return when {
        num % 15 == 0 -> "FizzBuzz"
        num % 3 == 0 -> "Fizz"
        num % 5 == 0 -> "Buzz"
        else -> "$num"
    }
}

// Exercise1-2
fun isLeapYear(y: Int): Boolean {
    return if (y > 0) {
        when {
            y % 100 == 0 && y % 400 != 0 -> false
            y % 4 == 0 -> true
            else -> false
        }
    } else {
        println("inputs must be positive.")
        return false
    }
}

// Exercise1-3
fun power(a: Int, n: Int): Long {
    if (a < 0 || n < 0) {
        println("inputs must be positive. return 0")
        return 0
    }
    var result = a.toLong()
    for (i in 1 until n) {
        result *= a.toLong()
    }
    return result
}

// Exercise2-1
fun Int.isEven() = this % 2 == 0

fun Int.isOdd() = this % 2 != 0

// Exercise2-2
fun rollDice() {
    val d = Dice(16)
    for (i in 1..100) {
        println("Dice${i}: ${d.roll()}") // 1〜16 までの数字
    }
    println(d.roll()) // Exception
}

class Dice(private val n: Int) {
    private var counter: Int = 0

    fun roll(): Int {
        if (counter++ >= 100) throw Exception("I was broken.")
        val random = Random()
        return random.nextInt(n) + 1
    }
}

// Exercise2-3
fun customSetter() {
    val p = MyCustomClass()
    p.propertyWithCounter = 123
    p.propertyWithCounter = 456
    p.propertyWithCounter = 789
    println(p.counter) // 3
}

class MyCustomClass {
    var counter: Int = 0
    var propertyWithCounter: Int = 0
        set(value) {
            field = value
            counter++
        }
}

// Exercise2-4
fun runNabeatsu() {
    val n = NabeAtsu()
    for (i in 1..100) {
        println(n.next())
    }
}

class NabeAtsu {
    private var counter: Int = 0

    fun next(): String {
        counter++
        return if (counter % 3 == 0 || counter.toString().contains("3")) {
            "Aho"
        } else {
            counter.toString()
        }
    }
}


// Exercise3
class Client(val personalInfo: PersonalInfo?)

class PersonalInfo(val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}

class CosmosMailer : Mailer {
    override fun sendMessage(email: String, message: String) {
        println("To: $email\nmessage: $message")
    }
}

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    message ?: return
    client?.personalInfo?.email?.let {
        mailer.sendMessage(it, message)
    }
}

fun executeMail() {
    val personalInfo: PersonalInfo = PersonalInfo("antonio@abc-company.com")
    val client: Client = Client(personalInfo)
    val mailer: Mailer = CosmosMailer()
    sendMessageToClient(client, "Hello, Antonio!", mailer)
}