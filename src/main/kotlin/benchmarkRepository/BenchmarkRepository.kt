package benchmarkRepository

import kotlinx.serialization.json.Json
import utils.DataGenerator
import java.io.File
import kotlin.system.measureNanoTime

object BenchmarkRepository {
    private const val FILE_NAME = "benchmark_results.json"
    private val json = Json {prettyPrint = true}
    private val results = mutableListOf<BenchmarkResult>()

    init {
        val file = File(FILE_NAME)
        if (file.exists()) {
            val text = file.readText()
            if (text.isNotBlank()) {
                results.addAll(json.decodeFromString<List<BenchmarkResult>>(text))
            }
        }
    }

    fun run(
        algorithmName: String,
        listSize: Int,
        repeatCount: Int = 30,
        block: (List<Int>) -> Unit
    ) {
        val times = mutableListOf<Long>()
        repeat(repeatCount) {
            val list = DataGenerator.generateData(listSize)
            val time = measureNanoTime { block(list) }
            times.add(time)
        }

        val averageMs = times.average() / 1_000_000.0
        results.add(BenchmarkResult(algorithmName, listSize, averageMs))
        saveResults()
    }

    private fun saveResults() {
        File(FILE_NAME).writeText(json.encodeToString(results))
    }
}