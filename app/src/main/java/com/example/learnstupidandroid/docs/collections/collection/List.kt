package com.example.learnstupidandroid.docs.collections.collection

import java.util.ArrayList

fun listDocs() {
/**
    List (interface, extends Collection)

        1. ArrayList (implements List)
            динамический массив объектов
            NOT SYNCRONIZED
            поиндексное обращение = O(1)
            поиск, вставка, удаление = O(n)
            избегать: частое удаление/добавление элементов в середину коллекции
            grow by 50%

        2. Vector (implements List)
            динамический массив объектов
            SYNCRONIZED
            поиндексное обращение = O(1)
            поиск, вставка, удаление = O(n)
            grow by 100%

        3. LinkedList (implements List implements Deque)
            двунаправленный связный список
            добавление/удаление из начала/конча O(1)
            доступ к элементу O(1)
            добавлени/удаление из середины О(1) + поиск куда добавить O(n)

        4. Stack (extends Vector)
            last-in-first-out (LIFO) stack of objects
            PREFER TO USE: Dequeue
 */
}

fun arrayList() {

    val list = ArrayList<String>()
    /*
    СТРУКТУРА
    list содержит свойства elementData и size
    Если вызывается конструктор без параметров, то по умолчанию будет создан массив из 10-ти элементов - старая версия
    elementData = (E[]) new Object[10];
    list(null, null, null, null, null, null, null, null, null, null)
     */


    list.add("0")
    /*
    ДОБАВЛЕНИЕ ЭЛЕМЕНТА В КОНЕЦ
    1. проверка достаточно ли места в массиве - ensureCapacity(size + 1);
        если места не достаточно, новый размер листа oldCapacity + (oldCapacity / 2)
        было: 10
        стало: 15
        // newCapacity - новое значение емкости
        elementData = (E[])new Object[newCapacity];

        // oldData - временное хранилище текущего массива с данными
        System.arraycopy(oldData, 0, elementData, 0, size);

    2. добавление элемента в конец - elementData[size++] = element;
     */

    for (i in 0..15) list.add("$i")
    /*
    тут места будет не достаточно
    list(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    list.add(10) - создается новый массив, вызывается System.arraycopy
    list(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, null, null, null)
     */


    list.add(5, "100")
    /*
    ДОБАВЛЕНИЕ ЭЛЕМЕНТА В СЕРЕДИНУ
    1. проверка достаточно ли места ensureCapacity
    2. подготавливается место для нового элемента с помощью System.arraycopy()
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        old: list(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, null, null, null)
        temp: list(0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, null, null, null, null)
    3. перезаписывается элемент с указанным индексом
        new: list(0, 1, 2, 3, 4, 100, 5, 6, 7, 8, 9, 10, null, null, null, null)

    ПОЧЕМУ ПЛОХО
    если места недостаточно System.arraycopy() случится дважды: ensureCapacity + пункт 2
     */


    list.removeAt(5)
    list.remove("5")
    /*
    УДАЛЕНИЕ ЭЛЕМЕНТА
    1. определяется какое количество элементов надо скопировать numMoved = size - index - 1
    2. копирует нужные элементы
    3. уменьшает размер массива elementData[--size] = null; // clear to let GC do its work
     */
}