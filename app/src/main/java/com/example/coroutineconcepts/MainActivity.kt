package com.example.coroutineconcepts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.time.ExperimentalTime


@ExperimentalTime
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text: TextView = findViewById<TextView>(R.id.txt)
        /* GlobalScope.launch {
             Log.d(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")
             Log.d(TAG, doNetworkCall())
         }
         GlobalScope.launch(Dispatchers.IO) {
             val answer =doNetworkCall()
             withContext(Dispatchers.Main){
                 text.text=answer
             }
         }
         Log.d(TAG, "hello from thread ${Thread.currentThread().name}")*/
        /* runBlocking {
             launch(Dispatchers.IO) {
                 delay(3000L)
                 Log.d(TAG, "runBlock Launch1")
             }
             launch(Dispatchers.IO) {
                 delay(3000L)
                 Log.d(TAG, "runBlock Launch2")
             }
             Log.d(TAG, "start run block 1")
             delay(5000L)
             Log.d(TAG, "end run block 1")
         }*/
        /*        val job =GlobalScope.launch(Dispatchers.Default){
                    repeat(5){
                        Log.d(TAG, "Coroutine is still working")
                        delay(1000L)
                    }
                }
                runBlocking {
                    job.join()
                    Log.d(TAG, "Main thread is continuing")
                    delay(2000L)
                    job.cancel()
                }*/
        /*        val job =GlobalScope.launch(Dispatchers.Default){
                        Log.d(TAG, "Starting calculation")
                    withTimeout(3000L){
                        for (i in 10..20){
                            if(isActive){
                                Log.d(TAG, "$i:${fib(i)} ")
                            }
                        }
                    }
                        delay(1000L)

                }
                runBlocking {
                    delay(2000L)
                    job.cancel()
                    Log.d(TAG, "Cancelled Job")
                }*/
        /* GlobalScope.launch(Dispatchers.IO) {
             val time = measureTime {
                 val answer1 = async { dbCall1() }
                 val answer2 = async { dbCall2() }
                 Log.d(TAG, answer1.await())
                 Log.d(TAG, answer2.await())
             }
             Log.d(TAG, "$time")
         }*/

    }
    private suspend fun doNetworkCall():String{
        delay(3000L)
        return "Network Calls"
    }
    private fun fib(n:Int):Long{
        return when (n) {
            0 -> 0
            1 -> 1
            else -> fib(n-1)+fib(n-2)
        }
    }
    private suspend fun dbCall1():String{
        delay(3000L)
        return "Answer 1"
    }
    private suspend fun dbCall2():String{
        delay(3000L)
        return "Answer 2"
    }

}