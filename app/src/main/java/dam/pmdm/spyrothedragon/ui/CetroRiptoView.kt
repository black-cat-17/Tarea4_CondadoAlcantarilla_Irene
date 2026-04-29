package dam.pmdm.spyrothedragon.ui

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CetroRiptoView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paintBrillo = Paint().apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
        // Efecto de desenfoque para representar energía mágica [cite: 61]
        maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    }

    private var radioBrillo = 20f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Dibujamos el brillo en el centro de la vista [cite: 61]
        canvas.drawCircle(width / 2f, height / 2f, radioBrillo, paintBrillo)

        // Animación: aumentamos la intensidad de forma progresiva [cite: 61]
        if (radioBrillo < 200f) {
            radioBrillo += 5f
            invalidate() // Forzamos el redibujado [cite: 61]
        }
    }
}