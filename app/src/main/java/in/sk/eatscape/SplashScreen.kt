package `in`.sk.eatscape

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Start rotating the wheel
        val rotatingWheel = findViewById<ImageView>(R.id.rotating_wheel)
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        rotatingWheel.startAnimation(rotateAnimation)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // Delay for 3 seconds (3000 milliseconds)
    }
}