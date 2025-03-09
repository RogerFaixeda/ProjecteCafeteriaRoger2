package com.faixeda.projectecafeteriaroger2.home.menjar

import androidx.lifecycle.ViewModel
import com.faixeda.projectecafeteriaroger2.home.DataSourceProductes
import com.faixeda.projectecafeteriaroger2.home.ProducteModel

class MenjarViewModel : ViewModel() {
    private var _menjars: List<ProducteModel> = emptyList()
    val menjars: List<ProducteModel>
        get() = _menjars

    fun generarProductes() {
        val productes = DataSourceProductes.obtenirProductes()
        _menjars = productes.filter { producte ->
            producte.tipus == "menjar"
        }
    }
}