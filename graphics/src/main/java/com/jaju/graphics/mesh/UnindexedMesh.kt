package com.jaju.graphics.mesh

import android.opengl.GLES32
import com.jaju.graphics.GLObject
import java.nio.ByteBuffer
import java.nio.ByteOrder

class UnindexedMesh(maxSize: Int) : GLObject(), Mesh {

    var position = VertexAttribute(maxSize * 3)
    var normal = VertexAttribute(maxSize * 3)
    var uv = VertexAttribute(maxSize * 2)
    var size = 0

    override fun init(): Int {
        val tmp = IntArray(1)
        GLES32.glGenVertexArrays(1, tmp, 0)
        GLES32.glBindVertexArray(tmp[0])
        bindVBO()
        GLES32.glBindVertexArray(0)
        return tmp[0]
    }

    protected fun bindVBO()
    {
        GLES32.glEnableVertexAttribArray(0)
        GLES32.glVertexAttribPointer(0, 3, GLES32.GL_FLOAT, false, 0, 0)
        position.bind()
        GLES32.glEnableVertexAttribArray(1)
        GLES32.glVertexAttribPointer(1, 3, GLES32.GL_FLOAT, false, 0, 0)
        normal.bind()
        GLES32.glEnableVertexAttribArray(2)
        GLES32.glVertexAttribPointer(2, 2, GLES32.GL_FLOAT, false, 0, 0)
        uv.bind()
    }

    fun bind()
    {
        GLES32.glBindVertexArray(glObject)
    }

    fun unbind()
    {
        GLES32.glBindVertexArray(0)
    }

    override fun draw() {
        bind()
        GLES32.glDrawArrays(GLES32.GL_TRIANGLES, 0, size)
        unbind()
    }
}