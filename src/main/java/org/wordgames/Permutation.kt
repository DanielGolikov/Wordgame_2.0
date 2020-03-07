package org.wordgames

import com.google.common.collect.Sets
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

internal object Permutation {
    fun getAllPossibleValues(inputString: String, targetLength: Int) {
        val length = inputString.length
        val indexes = IntStream.range(0, length).boxed().collect(Collectors.toSet())
        val allValues = ArrayList<String>()
        val uniqueValues: MutableSet<String> = HashSet()
        val bound = length + 1
        for (i in 1 until bound) {
            for (indicesSet in Sets.combinations(indexes, i)) {
                val sb = StringBuilder()
                for (integer in indicesSet) {
                    val charAt = inputString[integer!!]
                    val valueOf = charAt.toString()
                    sb.append(valueOf)
                }
                val str = sb.toString()
                for (s in GFG.GFGgetResult(str, targetLength)) {
                    if (uniqueValues.add(s)) {
                        allValues.add(s)
                    }
                }
            }
        }
        println("results generated")
        println("")
        File("all_permutations.csv")
        try {
            PrintWriter(FileWriter("all_permutations.csv")).use { csvWriter ->
                for (item in allValues) {
                    csvWriter.println(item)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}