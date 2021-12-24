package binary.search

fun List<Int>.binarySearch(item: Int) : Int? {
    var min = 0
    var max = lastIndex
    while (min <= max) {
        val mid = (min + max)/2
        val guess = this[mid]
        if (guess == item) return mid
        if (guess > item) max = mid -1
        else min = mid + 1
    }
    return null
}


val sortedArray = (1..6 step 1).toList()


fun main() {
    print(sortedArray.binarySearch(4))
}
