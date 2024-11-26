package exercise1

import java.util.PriorityQueue
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers
import kotlin.system.measureTimeMillis

class Printer {

    private val pQueue = PriorityQueue<Document>()

    suspend fun addToQueue(vararg documents: Document) {
        runBlocking(Dispatchers.IO) {
            val queuePreparation: Deferred<Boolean> =
                async {
                    documents.forEach {
                        println("Adding ${it.name} to print queue...")
                        pQueue.add(it)
                        delay(2000)
                    }
                    true
                }

            if (queuePreparation.await()) {
                documents.forEach {
                    println("exercise1.Document: ${it.name} is ready to be printed")
                }
            }
        }
    }

    suspend fun printDocument() : Boolean {
        var status: Boolean = false
        runBlocking(Dispatchers.IO) {
            val timer = measureTimeMillis {
                val printProcess: Deferred<Boolean> = async<Boolean>(context = Dispatchers.IO) {
                    repeat(pQueue.size, {
                        try {
                            val document = pQueue.remove()
                            println("Printing ${document.name}")
                            println("Total pages: ${document.pages}")
                            var page = document.pages
                            repeat(document.pages){
                                println("${document.name} | page $page")
                                delay(5000)
                                page--
                            }

                        }catch (e: NoSuchElementException){
                            println("exercise1.Printer queue is empty")
                        }
                    })
                    true
                }
               status = printProcess.await()
            }
            println("Process time: $timer")
        }
        return status
    }
}