package com.example.recyclerviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewsample.entities.getAllProducts
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        val adapter = Adapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
        recyclerView.addItemDecoration(itemDecoration)
        val id = "Man"
        val disposable = getAllProducts(id).subscribe({
            adapter.items = it.map { it.name }
        }, {

        })
        compositeDisposable.add(disposable)

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}