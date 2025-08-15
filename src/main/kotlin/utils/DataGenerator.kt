package utils

import kotlin.random.Random

object DataGenerator {
    fun generateData(size: Int): List<Int> {
        return List(size) { Random.nextInt(0, 1_000_000) }
    }
}