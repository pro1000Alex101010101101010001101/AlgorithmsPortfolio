package benchmarkRepository


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class BenchmarkResult(
    @SerialName("algorithmName") val algorithmName: String,
    @SerialName("listSize") val listSize: Int,
    @SerialName("averageTimeMs") val averageTimeMs: Double
)
