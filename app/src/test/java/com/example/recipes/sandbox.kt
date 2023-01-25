package com.example.recipes

import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class Sandbox {
    @Test
    fun test() {
        val latch = CountDownLatch(3)
        val thread1 = Thread {
            // perform task
            Thread.sleep(56000)
            latch.countDown()
        }
        val thread2 = Thread {
            // perform task
            latch.countDown()
        }
        val thread3 = Thread {
            // perform task
            latch.countDown()
        }

        thread1.start()
        thread2.start()
        thread3.start()
        try{
            if (!latch.await(5, TimeUnit.SECONDS)) {
                throw TimeoutException("TIMEOUT")
            }
        }catch (e: Exception){
            println(e.message)
        }
        println("All tasks completed")
    }
}