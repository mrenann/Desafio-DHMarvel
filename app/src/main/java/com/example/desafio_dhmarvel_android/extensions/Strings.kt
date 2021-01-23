package com.example.desafio_dhmarvel_android.extensions

fun String.image():String{
    return "${this}.jpg"
}

fun String.getDate():String{
    return "${this.subSequence(0,10)}"
}