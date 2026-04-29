package dam.pmdm.spyrothedragon

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.video_player)

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