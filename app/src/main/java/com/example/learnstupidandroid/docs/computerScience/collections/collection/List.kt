package com.example.learnstupidandroid.docs.computerScience.collections.collection

import java.util.ArrayList

/**
 * **List (interface, extends Collection)**
 * ```
 *    1. ArrayList (implements List)
 *          динамический массив объектов
 *          NOT SYNCRONIZED
 *          поиндексное обращение = O(1)
 *          поиск, вставка, удаление = O(n)
 *          избегать: частое удаление/добавление элементов в середину коллекции
 *          grow by 50%

 *    2. Vector (implements List)
 *          динамический массив объектов
 *          SYNCRONIZED
 *          поиндексное обращение = O(1)
 *          поиск, вставка, удаление = O(n)
 *          grow by 100%

 *    3. LinkedList (implements List implements Deque)
 *          двунаправленный связный список
 *          добавление/удаление из начала/конча O(1)
 *          доступ к элементу O(1)
 *          добавлени/удаление из середины О(1) + поиск куда добавить O(n)

 *    4. Stack (extends Vector)
 *          last-in-first-out (LIFO) stack of objects
 *          PREFER TO USE: Dequeue
 *      */
fun listDocs() {}


/**
СТРУКТУРА

list содержит свойства elementData и size

Если вызывается конструктор без параметров, то по умолчанию будет создан массив из 10-ти элементов - старая версия
```
val list = ArrayList<String>()

elementData = (E[]) new Object[10];
list(null, null, null, null, null, null, null, null, null, null)
```
 */
fun arrayList() {
    val list = ArrayList<String>()

    /** ДОБАВЛЕНИЕ ЭЛЕМЕНТА В КОНЕЦ
     *
     * list.add("0")
     * ```
     * 1. Проверка достаточно ли места в массиве - ensureCapacity(size + 1);
     *    Если места не достаточно, новый размер листа oldCapacity + (oldCapacity / 2)
     *    Было: 10
     *    Стало: 15
     *
     *    // newCapacity - новое значение емкости
     *    elementData = (E[])new Object[newCapacity];
     *
     *    // oldData - временное хранилище текущего массива с данными
     *    System.arraycopy(oldData, 0, elementData, 0, size);
     *
     * 2. Добавление элемента в конец - elementData[size++] = element;
     * ```
     *
     * for (i in 0..15) list.add("$i")
     * ```
     *     тут места будет не достаточно
     *     list(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
     *
     *     list.add(10) - создается новый массив, вызывается System.arraycopy
     *     list(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, null, null, null)
     * ```
     */
    fun listAdd() {
        list.add("0")
        for (i in 0..15) list.add("$i")
    }

    /**
     * ДОБАВЛЕНИЕ ЭЛЕМЕНТА В СЕРЕДИНУ
     *
     * list.add(5, "100")
     *
     * ```
     *     1. проверка достаточно ли места ensureCapacity
     *
     *     2. подготавливается место для нового элемента с помощью System.arraycopy()
     *        System.arraycopy(elementData, index, elementData, index + 1, size - index);
     *
     *        old: list(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, null, null, null)
     *        temp: list(0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, null, null, null, null)
     *
     *     3. перезаписывается элемент с указанным индексом
     *        new: list(0, 1, 2, 3, 4, 100, 5, 6, 7, 8, 9, 10, null, null, null, null)
     *```
     * ПОЧЕМУ ПЛОХО
     *
     * если места недостаточно System.arraycopy() случится дважды: ensureCapacity + пункт 2
     */
    fun listAddCenter() {
        list.add(5, "100")
    }

    /**
     * УДАЛЕНИЕ ЭЛЕМЕНТА
     *
     * list.removeAt(5)
     *
     * list.remove("5")
     * ```
     * 1. определяется какое количество элементов надо скопировать
     *    numMoved = size - index - 1
     *
     * 2. копирует нужные элементы
     *
     * 3. уменьшает размер массива elementData[--size] = null; // clear to let GC do its work
     * ```
     */
    fun listRemove() {
        list.removeAt(5)
        list.remove("5")
    }
}