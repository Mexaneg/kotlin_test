package ru.korlin.mexaneg

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toCollection

class WrapperStringList : MutableCollection<String>, MutableIterable<String> {

    private val list = ArrayList<String>()

    suspend fun getStringsLongerOneSymbol(): WrapperStringList {
        return sequence {
            for (item in list) {
                Thread.sleep(100)
                yield(item)
            }
        }.filter { it.length > 1 }.toCollection(WrapperStringList())
    }


    suspend fun getStringsLongerTwoSymbol(): WrapperStringList {
        return flow {
            for (item in list) {
                delay(100)
                emit(item)
            }
        }.filter { it.length > 2 }.toCollection(WrapperStringList())
    }
    suspend fun getStringsLongerThreeSymbol(): WrapperStringList {
        return flow {
            for (item in list) {
                Thread.sleep(100)
                emit(item)
            }
        }.filter { it.length > 3 }.toCollection(WrapperStringList())
    }

    suspend fun <R> map(transform: (String) -> R): List<R> {
        delay(1000)
        val resultList = ArrayList<R>()
        for (item in list)
            resultList.add(transform(item))
        return resultList
    }

    fun filter(predicate: (String) -> Boolean): ArrayList<String> {
        Thread.sleep(1000)
        val resultList = ArrayList<String>()
        for (item in list)
            if (predicate(item))
                resultList.add(item)
        return resultList
    }

    override val size: Int
        get() = list.size

    override fun containsAll(elements: Collection<String>): Boolean {
        return list.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun iterator(): MutableIterator<String> {
        return list.iterator()
    }

    override fun addAll(elements: Collection<String>): Boolean {
        return list.addAll(elements)
    }

    override fun clear() {
        list.clear()
    }

    override fun remove(element: String): Boolean {
        return list.remove(element)
    }

    override fun removeAll(elements: Collection<String>): Boolean {
        return list.removeAll(elements)
    }

    override fun retainAll(elements: Collection<String>): Boolean {
        return retainAll(elements)
    }

    override fun contains(entity: String): Boolean {
        return list.contains(entity)
    }

    override fun add(entity: String): Boolean {
        return list.add(entity)
    }

    fun get(index: Int): String {
        return list[index]
    }
}