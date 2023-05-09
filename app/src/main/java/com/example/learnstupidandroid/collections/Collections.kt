package com.example.learnstupidandroid.collections

import com.example.learnstupidandroid.collections.collection.*

/*
> Какие есть типы коллекций?
> Отличие и применение List, Map и Set
> Отличие LinkedList и ArrayList
> Сложность доступа/добавления/удаления элементов
> Понимание внутреннего устройства HashMap
> Знание о многопоточных коллекциях
> Во что превращаются 'setOf()', 'listOf()' в Kotlin
 */

object Collections {

    fun init() {
        shortenedDocs()

        listDocs()
        arrayList()

        queueDocs()
        queue()

        setDocs()

        mapDocs()
        hashMap()

        concurrentCollections()
        kotlinCollections()
    }

    private fun shortenedDocs() {
        /*
          JAVA

        Iterable
        Collection
    List   Queue   Set

    List (interface, extends Collection)
        1. ArrayList (implements List)
            NOT SYNCHRONIZED
        2. Vector (implements List)
            SYNCHRONIZED
        3. LinkedList (implements List implements Deque)
        4. Stack (extends Vector)
            last-in-first-out (LIFO) stack of objects
            PREFER TO USE: Dequeue


    Queue (interface, extends Collection)
        first-in-first-out order
        1. PriorityQueue (implements Queue)
            NOT THREAD SAFE
            priority with Comparator
        2. PriorityBlockingQueue
            THREAD SAFE
        3. Dequeue (interface, extends Queue)
        double-ended queue
        used as a queue (first-in-first-out/FIFO) or as a stack (last-in-first-out/LIFO)
            1. ArrayDeque (implements Deque)
            NOT THREAD SAFE


    Set (interface, extends Collection)
        no duplicate values
        1. HashSet (implements Set)
            uses a hash table for storage - HashMap
            order is not guaranteed
        2. LinkedHashSet (implements Set, extends HashSet)
            uses LinkedHashMap
            order as added
        3. SortedSet (interface, extends Set)
            arranged in the increasing (ascending) order
            1. TreeSet (implements SortedSet)
                Comparator for order
                uses a tree for storage
                access and retrieval time is quite fast


    Map
    1. WeakHashMap (implements Map)
        uses week references for the keys

    2. HashMap (implements Map)
        NOT SYNCHRONIZED
        key and value can be null
        не упорядоченная, зависит от хеш функции
            1. LinkedHashMap (extends HashMap)
                упорядоченная - по порядку добавления элементов
                двунаправленные связи
                недостаток — увеличение памяти, которое занимет коллекция

    3. SortedMap (interface, extends Map)
        1. NavigableMap (interface, extends SortedMap)
            1. TreeMap (implements NavigableMap)
                красно-чёрные деревья
                упорядоченная - default = natural ordering
                can use Comparator

    4. Hashtable
        not nullable
        SYNCHRONIZES - проблемы с производительностью, рекомендуется не использовать
        when need synchronization - ConcurrentHashMap
        when no need - HashMap

     */
    }

    private fun concurrentCollections() {
        /*
        Методы обрамления для получения синхронизированной (потокобезопасной) коллекции
        Collections.synchronizedList  (List)
        Collections.synchronizedSet   (Set)
        Collections.synchronizedMap (Map)

        ConcurrentHashMap 	    коллекция типа HashMap, реализующая интерфейс ConcurrentMap
        CopyOnWriteArrayList 	коллекция типа ArrayList с алгоритмом CopyOnWrite
        CopyOnWriteArraySet 	реализация интерфейса Set, использующая за основу CopyOnWriteArrayList
        ConcurrentNavigableMap 	расширяет интерфейс NavigableMap
        ConcurrentSkipListMap 	аналог коллекции TreeMap с сортировкой данных по ключу и с поддержкой многопоточности
        ConcurrentSkipListSet 	реализация интерфейса Set, выполненная на основе класса ConcurrentSkipListMap
        */
    }

    private fun kotlinCollections() {
        /*
        Iterable    ->  MutableIterable (extends Iterable)
        Collection      MutableCollection
        List Set        MutableList MutableSet                  Map MutableMap
        */

        //LIST
        val list = listOf<String>() // -> EmptyList -> List<Nothing>
        val listWithValue = listOf("one", "two") // -> Array<out T>.asList() -> List<T> ???

        val mutableArrayList = arrayListOf<String>() // -> ArrayList
        val mutableList = mutableListOf<String>() // -> ArrayList

        //SET
        val set = setOf<String>() // -> EmptySet -> Set<Nothing>
        val setWithValue = setOf("1", "2") // -> Array<out T>.toSet() -> Set<T> ???

        val mutableHashSet = hashSetOf<String>() // -> HashSet()
        val mutableSet = mutableSetOf<String>() // -> LinkedHashSet()

        //MAP
        val map = mapOf<String, String>() // -> EmptyMap as Map<K, V>
        val mapWithValue = mapOf("1" to "one") // -> SingletonMap(K key, V value)

        val mutableMap = mutableMapOf<String, String>() // -> LinkedHashMap()
    }

}

