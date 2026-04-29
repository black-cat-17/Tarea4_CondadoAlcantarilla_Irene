package dam.pmdm.spyrothedragon

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null

    //------------------------------------------------------------------------------------------->>>
    // Variables para la  Guía de inicio interactiva
    private var pasoActual = 1
    //-------------------------------------------------------------------------------------------<<<

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment: Fragment? =
            supportFragmentManager.findFragmentById(R.id.navHostFragment)

        navHostFragment?.let {
            navController = NavHostFragment.findNavController(it)
            NavigationUI.setupWithNavController(binding.navView, navController!!)
            NavigationUI.setupActionBarWithNavController(this, navController!!)
        }

        binding.navView.setOnItemSelectedListener { menuItem ->
            selectedBottomMenu(menuItem)
        }

        navController?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_characters,
                R.id.navigation_worlds,
                R.id.navigation_collectibles -> {
                    // En las pantallas de los tabs no mostramos la flecha atrás
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }
                else -> {
                    // En el resto de pantallas sí
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }
        }

        //--------------------------------------------------------------------------------------->>>
        // Lógica de la  Guía de inicio interactiva: Solo si es la primera vez
        val prefs = getSharedPreferences("SpyroPrefs", Context.MODE_PRIVATE)
        if (prefs.getBoolean("firstRun", true)) {
            iniciarGuia()

            // Guardar para que no vuelva a salir [cite: 49, 50]
            prefs.edit().putBoolean("firstRun", false).apply()
        }
        //---------------------------------------------------------------------------------------<<<
    }

    //------------------------------------------------------------------------------------------->>>
    private fun iniciarGuia() {
        // Inflamos el layout de la guía sobre el root de la activity
        val guiaView = layoutInflater.inflate(R.layout.guia, null)
        val rootLayout = findViewById<ViewGroup>(android.R.id.content)
        rootLayout.addView(guiaView)

        val tvInfo = guiaView.findViewById<TextView>(R.id.tvMensaje)
        val btnNext = guiaView.findViewById<Button>(R.id.btnSiguiente)
        val btnSkip = guiaView.findViewById<Button>(R.id.btnOmitir)
        val card = guiaView.findViewById<CardView>(R.id.cardGuia)

        // Animación (debes crear res/anim/pop_in.xml)
        val anim = AnimationUtils.loadAnimation(this, R.anim.pop_in)
        card.startAnimation(anim)

        btnNext.setOnClickListener {
            // Sonido (debes poner un mp3 en res/raw/clic.mp3)
            MediaPlayer.create(this, R.raw.clic).start()

            pasoActual++
            actualizarPaso(tvInfo, rootLayout, guiaView)
        }

        btnSkip.setOnClickListener {
            finalizarGuia(rootLayout, guiaView)
        }
    }
    //-------------------------------------------------------------------------------------------<<<

    //------------------------------------------------------------------------------------------->>>
    private fun actualizarPaso(tv: TextView, root: ViewGroup, view: View) {
        when (pasoActual) {
            2 -> tv.text = "En esta pestaña conocerás a Spyro y sus amigos."
            3 -> tv.text = "Aquí podrás explorar los mundos mágicos."
            4 -> tv.text = "No olvides revisar tus coleccionables."
            5 -> tv.text = "Pulsa el icono 'i' arriba para ver los créditos."
            6 -> {
                tv.text = "¡Eso es todo! Disfruta la aventura."
                view.findViewById<Button>(R.id.btnSiguiente).text = "Comenzar"
            }
            else -> finalizarGuia(root, view)
        }
    }
    //-------------------------------------------------------------------------------------------<<<
    //------------------------------------------------------------------------------------------->>>
    private fun finalizarGuia(root: ViewGroup, view: View) {
        root.removeView(view)
        getSharedPreferences("SpyroPrefs", Context.MODE_PRIVATE)
            .edit().putBoolean("firstRun", false).apply()
    }
    //-------------------------------------------------------------------------------------------<<<

    private fun selectedBottomMenu(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_characters ->
                navController?.navigate(R.id.navigation_characters)
            R.id.nav_worlds ->
                navController?.navigate(R.id.navigation_worlds)
            else ->
                navController?.navigate(R.id.navigation_collectibles)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_info) {
            showInfoDialog()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun showInfoDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.title_about)
            .setMessage(R.string.text_about)
            .setPositiveButton(R.string.accept, null)
            .show()
    }
}
