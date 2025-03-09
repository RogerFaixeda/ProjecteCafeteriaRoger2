package com.faixeda.projectecafeteriaroger2.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigator
import com.faixeda.projectecafeteriaroger2.R
import com.faixeda.projectecafeteriaroger2.databinding.ActivityMainBinding
import com.faixeda.projectecafeteriaroger2.registre.RegistreActivity
import com.faixeda.projectecafeteriaroger2.data.DatasourceUsers
import com.faixeda.projectecafeteriaroger2.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Thread.sleep(1000)
        installSplashScreen()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonLogin.setOnClickListener{
            if (binding.editTextNom.text.isNotEmpty() && binding.editTextPassword.text.isNotEmpty()){
                val nom = binding.editTextNom.text.toString()
                val contrasenya = binding.editTextPassword.text.toString()
                val users = DatasourceUsers.returnUsers()
                var userLogged = false
                for (user in users){
                    if (user.nom == nom && user.contrasenya == contrasenya){
                        userLogged = true
                    }
                }
                if (!userLogged){
                    Toast.makeText(this, "Usuari o contrasenya incorrectes", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "S'ha realitzat el login correctement", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                }
            } else {
                Toast.makeText(this, "No poden haver-hi camps buits", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textViewRegistre.setOnClickListener{
            startActivity(Intent(applicationContext, RegistreActivity::class.java))
        }
    }
}