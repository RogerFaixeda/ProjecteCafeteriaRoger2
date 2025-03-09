package com.faixeda.projectecafeteriaroger2.home.postre

import androidx.lifecycle.ViewModel
import com.faixeda.projectecafeteriaroger2.home.DataSourceProductes
import com.faixeda.projectecafeteriaroger2.home.ProducteModel

class PostreViewModel : ViewModel() {
    private var _postres: List<ProducteModel> = emptyList()
    val postres: List<ProducteModel>
        get() = _postres

    fun generarProductes() {
        val productes = DataSourceProductes.obtenirProductes()
        _postres = productes.filter { producte ->
            producte.tipus == "postre"
        }
    }
}