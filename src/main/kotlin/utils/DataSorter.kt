package utils

object DataSorter {
    fun <T : Comparable<T>> sortList(list: List<T>): List<T> {
        return list.sorted()
    }

    fun <T, R : Comparable<R>> sortListBy(list: List<T>, selector: (T) -> R): List<T> {
        return list.sortedBy(selector)
    }
}