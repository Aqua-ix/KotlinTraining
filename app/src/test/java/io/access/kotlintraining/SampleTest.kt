package io.access.kotlintraining

import org.junit.Test
import kotlin.test.assertEquals

class SampleTest {
    @Test
    fun testWelcome() {
        welcome()

        // Example of test
        val expected = 1
        val actual = 1
        assertEquals(expected, actual, "[want] $expected [got] $actual")
    }

    @Test
    fun testHello() {
        hello()
    }

    @Test
    fun testFizzBuzz() {
        // assertEquals 等の assert 系 function を使おう
        // 以下の kotlin.test パッケージのリファレンスも参照のこと
        // https://kotlinlang.org/api/latest/kotlin.test/kotlin.test/index.html

        // 引数が3の倍数の時はFizzを出力
        assertEquals(expected = "Fizz", actual = fizzBuzz(3))
        // 引数が5の倍数の時はBuzzを出力
        assertEquals(expected = "Buzz", actual = fizzBuzz(5))
        // 引数が3の倍数かつ5の倍数のときはFizzBuzz出力
        assertEquals(expected = "FizzBuzz", actual = fizzBuzz(15))
        // どれでもない時は数字を出力
        assertEquals(expected = "7", actual = fizzBuzz(7))
    }

    @Test
    fun testLeapYear() {
        // 閏年
        assertEquals(expected = true, actual = isLeapYear(2000))
        // 閏年ではない(100で割り切れてかつ400で割り切れない)
        assertEquals(expected = false, actual = isLeapYear(1700))
        // 閏年ではない(その他)
        assertEquals(expected = false, actual = isLeapYear(2001))
    }

    @Test
    fun testPower() {
        assertEquals(expected = 1, actual = power(1, 1))
        assertEquals(expected = 4, actual = power(2, 2))
        assertEquals(expected = 27, actual = power(3, 3))
    }

    @Test
    fun testOddEven() {
        // 偶数
        assertEquals(expected = true, actual = 2.isEven())
        assertEquals(expected = false, actual = 2.isOdd())
        // 奇数
        assertEquals(expected = true, actual = 3.isOdd())
        assertEquals(expected = false, actual = 3.isEven())
    }

    @Test
    fun testDice() {
        rollDice()
    }

    @Test
    fun testCustomSetter() {
        customSetter()
    }

    @Test
    fun testNabeatsu() {
        runNabeatsu()
    }

    @Test
    fun testMail() {
        executeMail()
    }
}