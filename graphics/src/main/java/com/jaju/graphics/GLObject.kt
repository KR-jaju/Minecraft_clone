package com.jaju.graphics

abstract class GLObject {
    val glObject: Int by lazy{ return@lazy init() }
    protected abstract fun init(): Int
}