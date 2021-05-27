package com.example.recyclerviewsample

import com.example.recyclerviewsample.entities.Category
import com.example.recyclerviewsample.entities.Product
import com.example.recyclerviewsample.entities.SubCategory
import io.reactivex.Single

fun getProducts(idList: List<Int>): Single<List<Product>> {

    val clothes = listOf(
        Product(1, "Sneakers"),
        Product(1, "Pants"),
        Product(1, "T-Shirt")
    )
    val tech = listOf(
        Product(2, "Blender"),
        Product(2, "Laptop"),
        Product(2, "Kettle")
    )
    val groceries = listOf(
        Product(3, "Bread"),
        Product(3, "Pizza"),
        Product(3, "Tomatoes")
    )
    val clothesAndGroceries = listOf(
        Product(1, "Sneakers"),
        Product(1, "Pants"),
        Product(1, "T-Shirt"),
        Product(3, "Milk"),
        Product(3, "Bread"),
        Product(3, "Pizza"),
        Product(3, "Tomatoes")
    )
    val techAndGroceries = listOf(
        Product(2, "Blender"),
        Product(2, "Laptop"),
        Product(2, "Kettle"),
        Product(3, "Milk"),
        Product(3, "Bread"),
        Product(3, "Pizza"),
        Product(3, "Tomatoes")
    )
    val clothesAndTech = listOf(
        Product(1, "Sneakers"),
        Product(1, "Pants"),
        Product(1, "T-Shirt"),
        Product(2, "Blender"),
        Product(2, "Laptop"),
        Product(2, "Kettle")
    )
    val products = listOf(
        Product(1, "Sneakers"),
        Product(1, "Pants"),
        Product(1, "T-Shirt"),
        Product(2, "Blender"),
        Product(2, "Laptop"),
        Product(2, "Kettle"),
        Product(3, "Milk"),
        Product(3, "Bread"),
        Product(3, "Pizza"),
        Product(3, "Tomatoes")
    )
    return when {
        idList.containsAll(listOf(1, 2, 3)) -> {
            Single.just(products)
        }
        idList.contains(1) && idList.contains(2) -> {
            Single.just(clothesAndTech)
        }
        idList.contains(1) && idList.contains(3) -> {
            Single.just(clothesAndGroceries)
        }
        idList.contains(2) && idList.contains(3) -> {
            Single.just(techAndGroceries)
        }
        idList.contains(1) -> {
            Single.just(clothes)
        }
        idList.contains(2) -> {
            Single.just(tech)
        }
        idList.contains(3) -> {
            Single.just(groceries)
        }

        else -> Single.just(products)
    }
}

fun getCategories(id: String): Single<List<SubCategory>> {
    val subCategories = listOf(
        SubCategory(1, "Clothes"),
        SubCategory(2, "Tech"),
        SubCategory(3, "Groceries")
    )
   return Single.just(subCategories.takeIf { id=="Man" }.orEmpty())
}