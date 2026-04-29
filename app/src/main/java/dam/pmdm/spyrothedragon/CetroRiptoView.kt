package dam.pmdm.spyrothedragon

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CetroRiptoView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // Configuración del pincel para el brillo del cetro de Ripto [cite: 61]
    private val paintBrillo = Paint().apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
        maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    }

    private var radioBrillo = 10f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Dibujamos el efecto visual [cite: 61]
        canvas.drawCircle(width / 2f, height / 2f, radioBrillo, paintBrillo)

        // Animación progresiva de intensidad y tamaño [cite: 61]
        if (radioBrillo < 150f) {
            radioBrillo += 5f
            invalidate() // Esto fuerza el redibujado continuo
        }
    }
}