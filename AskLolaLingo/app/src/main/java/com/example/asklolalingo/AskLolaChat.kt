package com.example.asklolalingo

import android.animation.Animator
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.animation.ObjectAnimator ;
import androidx.appcompat.app.AppCompatActivity
import com.example.asklolalingo.fragments.AskLolaChatFragment


class AskLolaChat : AppCompatActivity() {

    private lateinit var imageViewLola : ImageView ;
    private lateinit var imageViewLola2 : ImageView ;
    private lateinit var imageFileNames : Array<String>;
    private val handler = Handler(Looper.getMainLooper());
    private val delayMillis: Long = 5000 ;
    private var currentIndex = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask_lola_chat)

        imageViewLola = findViewById(R.id.imageViewLola);

        val assetManager = assets;
        imageFileNames = assetManager.list("imagesMain") ?: arrayOf()

        if (imageFileNames.isNotEmpty()) {
            startSlideshow()
        } else {
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AskLolaChatFragment())
                .commit()
        }
    }

    private fun startSlideshow() {
        handler.postDelayed(object : Runnable {
            override fun run() {

                val fadeOut = ObjectAnimator.ofFloat(imageViewLola, "alpha",.9f,.3f);
                fadeOut.duration = 1000 ;
                fadeOut.start() ;

                fadeOut.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {}
                    override fun onAnimationEnd(animation: Animator) {


                        if (currentIndex >= imageFileNames.size) {
                            currentIndex  = 0
                        }
                        val fileName = imageFileNames[currentIndex];
                        val assetManager = assets ;
                        val ims = assetManager.open("imagesMain/$fileName");

                        val drawable = Drawable.createFromStream(ims, null);
                        imageViewLola.setImageDrawable(drawable);

                        ims.close()

                        val fadeIn = ObjectAnimator.ofFloat(imageViewLola, "alpha",.6f,.9f);
                        fadeIn.duration = 1000 ;
                        fadeIn.start() ;

                        currentIndex++
                    }

                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                })

                handler.postDelayed(this, delayMillis);
            }
        }, delayMillis);
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null);
    }
}