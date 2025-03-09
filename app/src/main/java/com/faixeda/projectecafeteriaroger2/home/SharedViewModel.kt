package com.faixeda.projectecafeteriaroger2.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _menjar = MutableLiveData<MutableList<ProducteModel>>()
    val menjar: LiveData<MutableList<ProducteModel>> = _menjar

    private val _beguda = MutableLiveData<MutableList<ProducteModel>>()
    val beguda: LiveData<MutableList<ProducteModel>> = _beguda

    private val _postres = MutableLiveData<MutableList<ProducteModel>>()
    val postres: LiveData<MutableList<ProducteModel>> = _postres


    private val _preuTotalMenjar = MutableLiveData<Int>()
    val preuTotalMenjar: LiveData<Int> = _preuTotalMenjar

    private val _preuTotalBeguda = MutableLiveData<Int>()
    val preuTotalBeguda: LiveData<Int> = _preuTotalBeguda

    private val _preuTotalPostres = MutableLiveData<Int>()
    val preuTotalPostres: LiveData<Int> = _preuTotalPostres

    private val _preuTotal = MutableLiveData<Int>()
    val preuTotal: LiveData<Int> = _preuTotal


    fun afegirAlMenu(menuModel: ProducteModel) {
        val targetList = when (menuModel.tipus) {
            "menjar" -> _menjar
            "beguda" -> _beguda
            else -> _postres
        }

        val updatedList = targetList.value ?: mutableListOf()
        updatedList.add(menuModel)
        targetList.value = updatedList.toList().toMutableList()
        calcularPreuTotal()
    }


    fun calcularPreuTotal() {
        _preuTotalMenjar.value = _menjar.value?.sumOf { it.preuUnitari * it.quantitat } ?: 0

        _preuTotalBeguda.value = _beguda.value?.sumOf { it.preuUnitari * it.quantitat } ?: 0

        _preuTotalPostres.value = _postres.value?.sumOf { it.preuUnitari * it.quantitat } ?: 0

        _preuTotal.value = (_preuTotalMenjar.value ?: 0) + (_preuTotalBeguda.value ?: 0) + (_preuTotalPostres.value ?: 0)
    }

    fun comprar() {
        _menjar.value = mutableListOf()
        _beguda.value = mutableListOf()
        _postres.value = mutableListOf()

        _preuTotalMenjar.value = 0
        _preuTotalBeguda.value = 0
        _preuTotalPostres.value = 0
        _preuTotal.value = 0
    }
}