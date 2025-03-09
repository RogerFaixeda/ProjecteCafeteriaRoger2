package com.faixeda.projectecafeteriaroger2.data

object DatasourceUsers {
    var users:MutableList<UsersModel> = mutableListOf(
        UsersModel("Roger", "a"),
        UsersModel("a", "a"),
    )
    fun returnUsers(): MutableList<UsersModel> {
        return users
    }

    fun addUser(nom:String, contrasenya:String){
        users.add(UsersModel(nom, contrasenya))
    }
}