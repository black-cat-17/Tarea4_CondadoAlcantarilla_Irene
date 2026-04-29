package dam.pmdm.spyrothedragon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import dam.pmdm.spyrothedragon.ui.CetroRiptoView
import dam.pmdm.spyrothedragon.R
import dam.pmdm.spyrothedragon.models.Character

class CharactersAdapter(
    private val list: List<Character>
) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    private val characterImages = mapOf(
        "spyro" to R.drawable.spyro,
        "hunter" to R.drawable.hunter,
        "elora" to R.drawable.elora,
        "ripto" to R.drawable.ripto
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview, parent, false)
        return CharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = list[position]
        holder.nameTextView.text = character.name

        val drawableRes = characterImages[character.image] ?: R.drawable.placeholder
        holder.imageImageView.setImageResource(drawableRes)

        //------------------------------------------------------------------------------------------->>>
        // LÓGICA DEL EASTER EGG DE ANIMACIÓN
        // Comprobamos si el personaje es Ripto (ajusta "ripto" según tu modelo)
        if (character.image == "ripto") {
            holder.itemView.setOnLongClickListener {
                // 1. Creamos la vista personalizada de Canvas
                val animacionMagica = CetroRiptoView(holder.itemView.context)

                // 2. La añadimos al contenedor raíz de la pantalla [cite: 42, 61]
                // Buscamos el root de la Activity para que se vea por encima de todo [cite: 44]
                val rootLayout = holder.itemView.rootView.findViewById<ViewGroup>(android.R.id.content)

                // Opcional: Definir tamaño para que aparezca centrado sobre el cetro
                val params = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                animacionMagica.layoutParams = params

                rootLayout.addView(animacionMagica)

                true // Indica que el evento ha sido gestionado
            }
        } else {
            // Importante: Quitar el listener si no es Ripto para evitar errores al reciclar vistas
            holder.itemView.setOnLongClickListener(null)
        }
        //-------------------------------------------------------------------------------------------<<<
    }

    override fun getItemCount(): Int = list.size

    class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val imageImageView: ImageView = itemView.findViewById(R.id.image)
    }
}
