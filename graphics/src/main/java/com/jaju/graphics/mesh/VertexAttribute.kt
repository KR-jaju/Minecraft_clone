package com.jaju.graphics.mesh

import android.opengl.GLES32
import java.nio.ByteBuffer
import java.nio.ByteOrder

class VertexAttribute(capacity : Int) {
    val glVBO : Int by lazy {
        val tmp = IntArray(1)
        GLES32.glGenBuffers(1, tmp, 0)
        GLES32.glBindBuffer(GLES32.GL_ARRAY_BUFFER, glVBO)
        GLES32.glBufferData(GLES32.GL_ARRAY_BUFFER, capacity * 4, null, GLES32.GL_STATIC_DRAW)
        GLES32.glBindBuffer(GLES32.GL_ARRAY_BUFFER, 0)
        return@lazy tmp[0]
    }
    val buffer = ByteBuffer.allocateDirect(capacity * 4).order(ByteOrder.nativeOrder()).asFloatBuffer()

    fun bind()
    {
        GLES32.glBindBuffer(GLES32.GL_ARRAY_BUFFER, glVBO)
    }

    fun unbind()
    {
        GLES32.glBindBuffer(GLES32.GL_ARRAY_BUFFER, 0)
    }

    fun update()
    {
        bind()
        GLES32.glBufferSubData(GLES32.GL_ARRAY_BUFFER, 0, buffer.limit(), buffer)
        unbind()
    }
}