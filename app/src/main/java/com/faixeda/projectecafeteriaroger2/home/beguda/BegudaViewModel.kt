package com.faixeda.projectecafeteriaroger2.home.beguda

import androidx.lifecycle.ViewModel
import com.faixeda.projectecafeteriaroger2.home.DataSourceProductes
import com.faixeda.projectecafeteriaroger2.home.ProducteModel

class BegudaViewModel : ViewModel() {
    private var _begudes: List<ProducteModel> = emptyList()
    val begudes: List<ProducteModel>
        get() = _begudes

    fun generarProductes() {
        val productes = DataSourceProductes.obtenirProductes()
        _begudes = productes.filter { producte ->
            producte.tipus == "beguda"
        }
    }
}