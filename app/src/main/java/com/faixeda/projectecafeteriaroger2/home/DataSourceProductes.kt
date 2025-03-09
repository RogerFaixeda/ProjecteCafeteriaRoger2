package com.faixeda.projectecafeteriaroger2.home

import com.faixeda.projectecafeteriaroger2.R

object DataSourceProductes {
    var productes: MutableList<ProducteModel> = mutableListOf (
        ProducteModel("menjar", R.drawable.baseline_dinner_dining_24, "Espaguetis", 1, 8),
        ProducteModel("menjar", R.drawable.baseline_lunch_dining_24, "Hamburguesa", 1, 10),
        ProducteModel("menjar", R.drawable.baseline_kebab_dining_24, "Kebab", 1, 6),
        ProducteModel("menjar", R.drawable.baseline_ramen_dining_24, "Ramen", 1, 7),
        ProducteModel("menjar", R.drawable.baseline_dinner_dining_24, "Pizza", 1, 4),
        ProducteModel("beguda", R.drawable.baseline_local_drink_24, "Aquarius", 1, 3),
        ProducteModel("beguda", R.drawable.baseline_local_drink_24, "CocaCola", 1, 3),
        ProducteModel("beguda", R.drawable.baseline_local_drink_24, "Pepsi", 1, 3),
        ProducteModel("beguda", R.drawable.baseline_local_drink_24, "Neste", 1, 3),
        ProducteModel("beguda", R.drawable.baseline_local_drink_24, "Aigua", 1, 2),
        ProducteModel("postre", R.drawable.baseline_bakery_dining_24, "Croasant", 1, 2),
        ProducteModel("postre", R.drawable.baseline_free_breakfast_24, "Cafe", 1, 2),
        ProducteModel("postre", R.drawable.baseline_cake_24, "Pastis de Formatge", 1, 4),
        ProducteModel("postre", R.drawable.baseline_cake_24, "Pastis de Xocolata", 1, 2),
        ProducteModel("postre", R.drawable.baseline_brunch_dining_24, "Coques amb batut de xocolata", 1, 2)
    )

    fun obtenirProductes(): MutableList<ProducteModel> {
        return productes
    }
}