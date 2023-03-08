package com.jaju.minecraftclone

import android.opengl.GLES32
import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class Core : GLSurfaceView.Renderer {
    override fun onSurfaceCreated(p0: GL10?, p1: EGLConfig?) {
        GLES32.glClearColor(0.5f, 0.5f, 0.5f, 1.0f)
    }

    override fun onSurfaceChanged(p0: GL10?, width: Int, height: Int) {
        GLES32.glViewport(0,0, width, height)
    }

    override fun onDrawFrame(p0: GL10?) {
        GLES32.glClear(GLES32.GL_COLOR_BUFFER_BIT)
    }
}