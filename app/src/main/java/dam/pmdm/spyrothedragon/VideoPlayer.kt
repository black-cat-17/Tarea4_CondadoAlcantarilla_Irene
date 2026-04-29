package dam.pmdm.spyrothedragon

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.video_player)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val videoView = findViewById<VideoView>(R.id.videoView)
        // El vídeo debe estar en res/raw/spyro_video.mp4
        val path = "android.resource://" + packageName + "/" + R.raw.spyro_video
        videoView.setVideoURI(Uri.parse(path))

        videoView.setOnCompletionListener {
            finish() // Cierra la actividad al terminar
        }

        videoView.start()
    }
    }
}