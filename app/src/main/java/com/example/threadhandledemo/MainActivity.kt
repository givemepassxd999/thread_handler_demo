package com.example.threadhandledemo

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var index = 0
        val handler = Handler {
            if (it.what == 1) {
                index++
                text_view.text = "number: $index"
            }
            true
        }

        show_msg.setOnClickListener {
            Thread {
                for (i in 1..10) {
                    val message = Message()
                    message.what = 1
                    handler.sendMessage(message)
                    Thread.sleep(1000)
                }
            }.start()
        }
    }
}
