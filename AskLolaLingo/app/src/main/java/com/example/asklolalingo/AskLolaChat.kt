package com.example.asklolalingo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AskLolaChat : AppCompatActivity() {

    private lateinit var imageViewLola : ImageView ;
    private lateinit var imageFileNames : Array<String>;
    private val handler = Handler(Looper.getMainLooper());
    private val delayMillis: Long = 5000 ;
    private var currentIndex = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask_lola_chat)

        imageViewLola = findViewById(R.id.imageViewLola);

        val assetManager = assets ;
        imageFileNames = assetManager.list("imagesMain") ?: arrayOf()

        if (imageFileNames.isNotEmpty()) {
            startSlideshow()
        }

        private fun startSlideshow() {
            handler.postDelayed(object : Runnable {
                override fun run() {
                    if (currentIndex >= imageFileNames.size) {
                        currentIndex  = 0
                    }
                    val fileName = imageFileNames[currentIndex];
                    val assetManager = assets ;
                    val ims = assetManager.open("imagesMain/$fileName");

                    val drawable = Drawable.createFromStream(ims, null);
                    imageViewLola.setImageDrawable(drawable);

                    val fadeIn = ObjectAnimator.ofFloat(imageViewLola, "alpha", 0f, 1f);
                }
            })
        }


        }
    }