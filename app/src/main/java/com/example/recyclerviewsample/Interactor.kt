package com.example.recyclerviewsample.entities

import com.example.recyclerviewsample.getCategories
import com.example.recyclerviewsample.getProducts
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun getAllProducts(id: String): Single<List<Product>> {
    return getCategories(id)
        .map { list -> list.map { subCategory -> subCategory.id }.toList() }
        .flatMap { getProducts(it) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

