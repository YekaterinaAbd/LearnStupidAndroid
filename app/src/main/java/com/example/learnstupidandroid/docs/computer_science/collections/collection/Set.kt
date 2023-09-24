package com.example.learnstupidandroid.docs.computer_science.collections.collection

fun setDocs() {
/**
    Set (interface, extends Collection)
        no duplicate values

        1. HashSet (implements Set)
            uses a hash table for storage - HashMap
            key = element, value = объект-пустышка (new Object())
            order is not guaranteed

            1. LinkedHashSet (implements Set, extends HashSet)
                uses LinkedHashMap
                порядок элементов при обходе коллекции является идентичным порядку добавления элементов

        2. SortedSet (interface, extends Set)
            arranged in the increasing (ascending) order
            1. TreeSet (implements SortedSet)
                управляет порядком элементов при помощи Comparator
                uses a tree for storage
                access and retrieval time is quite fast
 */
}