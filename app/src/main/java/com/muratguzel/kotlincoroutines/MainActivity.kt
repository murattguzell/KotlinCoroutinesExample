package com.muratguzel.kotlincoroutines

import android.os.Bundle
import android.provider.Settings.Global
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //light Weightness
        /*GlobalScope.launch {
             repeat(100000) {
                 launch {
                     println("android")
                 }
             }
         }*/

        //scope
        //Global Scope , runBlocking , CoroutineScope

        /*//runBlocking
        runBlocking {
            launch {
                delay(2000)
                println("run blocking")
            }
        }*/
        /*println("global scope start")
        GlobalScope.launch {
            delay(5000)
            println("global scope")
        }

       println("global scope end")*/

       /* //CoroutineScope
        println("coroutine scope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("coroutine scope")
        }
        println("corotuine scope end")*/

        runBlocking  {

            launch(Dispatchers.Main) {
                println("Main Thread ${Thread.currentThread().name}")
            }

            launch(Dispatchers.IO) {
                println("IO Thread ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default Thread ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Unconfined) {
                println("Unconfined Thread ${Thread.currentThread().name}")
            }
        }
    }


}