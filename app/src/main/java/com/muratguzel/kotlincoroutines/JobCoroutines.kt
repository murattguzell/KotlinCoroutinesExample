package com.muratguzel.kotlincoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //Job  -> launch calıstırdıgımız her yerde karsımıza bir job cıkabiliyor
    // ve bu döndurulen işleri biz sonradan kontrol edebiliyoruz ister iptal ederiz
    // ister bitiminde şunu yap deriz ve istersek iç içe  kullanabiliriz.

    runBlocking {
        val myJob = launch {
            delay(2000)
            println("job")
            val secondJob = launch {
                println("job 2")
            }
        }
        myJob.invokeOnCompletion {
            println("myJob end")
        }
        myJob.cancel()
    }

}