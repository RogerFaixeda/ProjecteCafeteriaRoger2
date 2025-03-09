package com.faixeda.projectecafeteriaroger2.registre

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.faixeda.projectecafeteriaroger2.R
import com.faixeda.projectecafeteriaroger2.data.DatasourceUsers
import com.faixeda.projectecafeteriaroger2.databinding.ActivityMainBinding
import com.faixeda.projectecafeteriaroger2.databinding.ActivityRegistreBinding
import com.faixeda.projectecafeteriaroger2.home.HomeActivity
import com.faixeda.projectecafeteriaroger2.login.MainActivity

class RegistreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding : ActivityRegistreBinding = DataBindingUtil.setContentView(this, R.layout.activity_registre)

        binding.buttonRegistre.setOnClickListener{
            if (binding.editTextNom.text.isNotEmpty() && binding.editTextPassword.text.isNotEmpty()){
                val nom = binding.editTextNom.text.toString()
                val contrasenya = binding.editTextPassword.text.toString()
                val users = DatasourceUsers.returnUsers()
                for (user in users){
                    if (user.nom == nom && user.contrasenya == contrasenya){
                        Toast.makeText(this, "L'usuari ja existeix", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
                DatasourceUsers.addUser(nom, contrasenya)

                Toast.makeText(this, "Usuari registrat a la base de dades!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(applicationContext, HomeActivity::class.java))

            } else {
                Toast.makeText(this, "No poden haver-hi camps buits", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textViewLogin.setOnClickListener{
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}