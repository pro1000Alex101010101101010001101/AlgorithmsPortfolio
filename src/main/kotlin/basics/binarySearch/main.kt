package basics.binarySearch

import benchmarkRepository.BenchmarkRepository
import utils.DataSorter
import kotlin.random.Random

private val dataSorter = DataSorter

fun main() {
    BenchmarkRepository.run("myBinarySearch", 10_000) { list ->
        val sortedList = list.sorted()
        val item = sortedList[Random.nextInt(sortedList.size)]
        myBinarySearch(sortedList, item)
    }
}

fun myBinarySearch(list: List<Int>, item: Int): Any? {
    var low = 0
    var high = list.size - 1
    while (high >= 0) {
        val mid = (low + high) / 2
        val guess = list[mid]
        if (guess == item) return mid
        else if (guess > item) high = mid - 1
        else low = mid + 1
    }
    return null
}