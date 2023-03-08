package com.jaju.minecraftclone

import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glView = GLSurfaceView(this)
        glView.setEGLContextClientVersion(3)
        glView.setRenderer(Core())
        setContentView(glView)
    }
}