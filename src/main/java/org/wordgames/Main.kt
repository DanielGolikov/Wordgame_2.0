package org.wordgames

import org.wordgames.PostgresSQLWordChecker.findAllWordsFromArray

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        Permutation.getAllPossibleValues("object", 3)
        val start = System.currentTimeMillis()
        findAllWordsFromArray()
        val finish = System.currentTimeMillis()
        val timeConsumedMillis = finish - start.toDouble()
        println(timeConsumedMillis / 1000)
        val ex = Exporter()
        ex.exportIntoCSV()
    }
}