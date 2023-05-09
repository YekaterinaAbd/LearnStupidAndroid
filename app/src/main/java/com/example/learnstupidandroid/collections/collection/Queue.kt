package com.example.learnstupidandroid.collections.collection

import java.util.*
import kotlin.collections.ArrayDeque

fun queueDocs() {
/*
    Queue (interface, extends Collection)
        first-in-first-out order

        1. PriorityQueue (implements Queue)
            based on a priority heap
            NOT THREAD SAFE
            natural order by default (1, 2, 3) (a, b, c)
            can add Comparator to define priority

            TIME COMPLEXITY:
            enqueuing and dequeuing methods (offer, poll, remove() and add) -  O(log(n))
            remove(Object), contains(Object) methods - O(n)
            retrieval methods (peek, element, and size) - O(1)

            DEFAULT_INITIAL_CAPACITY = 11

        2. PriorityBlockingQueue
            THREAD SAFE

        3. Dequeue (interface, extends Queue)
        double-ended queue
        used as a queue(first-in-first-out/FIFO) or as a stack(last-in-first-out/LIFO)
            1. ArrayDeque (implements Deque)
            NOT THREAD SAFE
            faster than Stack when used as a stack. faster than LinkedList when used as a queue.
 */
}

fun queue() {

    val queue: Queue<String> = PriorityQueue()
    //DEFAULT_INITIAL_CAPACITY = 11

    val queueCompared: Queue<String> = PriorityQueue(11, reverseOrder())

    val dequeue: ArrayDeque<String> = ArrayDeque()

}