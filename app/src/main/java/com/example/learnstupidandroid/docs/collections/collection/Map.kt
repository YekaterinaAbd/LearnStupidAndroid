package com.example.learnstupidandroid.docs.collections.collection

import java.util.HashMap

fun mapDocs() {
/**
    Map
    1. WeakHashMap (implements Map)
        uses week references for the keys

    2. HashMap (implements Map)
        NOT SYNCHRONIZED
        key and value can be null
        не упорядоченная, зависит от хеш функции, не дает гарантий относительно порядка элементов

            1. LinkedHashMap (extends HashMap)
                упорядоченная - по порядку добавления элементов
                двунаправленные связи
                недостаток — увеличение памяти, которое занимет коллекция

    3. SortedMap (interface, extends SortedMap)
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


fun hashMap() {

    val hashmap: HashMap<String?, String?> = HashMap()

    /**
    IMPORTANT:
    loadFactor - by default 75%. the measure that decides when to increase the capacity of the Map
    initialCapacity - by default 16 (2^4). is doubled each time it reaches the threshold
    threshold - the max number of elements, when hash-table doubles. capacity * loadFactor

    max capacity defined by user = INT/2

    internal structure:
    hashmap = array of nodes
    Node<K, V>:
    hash
    K key
    V value
    Node<K, V> next


    After Java 8:
    LinkedList for chaining - bucket size <= UNTREEIFY_THRESHOLD[6]
    Self Balancing BST - bucket size > TREEIFY_THRESHOLD[8]

    TIME COMPLEXITY
    get(key) & contains(key) & remove(key)
    LinkedList buckets - WORST CASE = O(n)
    BinaryTree buckets - WORST CASE = O(log n)

    put(key, value)
    LinkedList buckets - WORST CASE = O(n)
    BinaryTree buckets - WORST CASE = O(log n)
     */

    hashmap.put("0", "zero")
    /*
    ADDING ELEMENTS:
    1. check for key != null
    2. create key.hashCode() - generated hashCode will have the limited collisions - about 8
    3. определяется позиция в массиве куда будет помещен элемент: indexFor(hash, tableLength) = hash & (tableLength - 1)
    4. получаем цепочку элементов, привязанных к ячейке с данным индексом, сравниваются хеши и ключи, если совпадают, значение переписывается
    5. если нет совпадений, добавляется новый элемент в ячейку addEntry(hash, key, value, index)
     */

    hashmap.put(null, null)
    /*
    ADDING NULL ELEMENTS
    1. putForNullKey(value) - NO hash, NO index
       all null-keys go to cell table[0]
    2. all table[0] cells are iterated for searching key=null element. if found, the value is rewritten
    3. if not found, addEntry(0, null, value, 0)
     */

    hashmap.put("idx", "two")
    /*
    COLLISION
    1. key.hashCode()
    2. indexFor() == another indexFor() - several elements in one cell
    3. new entry in the beginning of the cell
    4. node.next = previous entry
     */

    /*
    RESIZE
    когда таблица заполнена до предельного занчения
    1. resize(capacity) = capacity << 1 (doubles)
    2. transfer(newTable) - перебирает все элементы, пересчитывает их индексы (с учетом нового размера) и перераспределяет элементы по новому массиву.
     */

    hashmap.remove("idx")
    /*
    REMOVING ELEMENTS
    same problem as with ArrayList - the capacity does not get less
     */
}