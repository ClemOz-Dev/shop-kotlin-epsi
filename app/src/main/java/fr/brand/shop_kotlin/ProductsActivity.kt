package fr.brand.shop_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        showBtnBack()
        val i = intent
        i.getStringExtra("title")?.let { setHeaderTitle(it) }
        val productsUrl = i.getStringExtra("productsUrl")

        val products = arrayListOf<Product>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val productsAdapter = ProductAdapter(products)
        recyclerView.adapter = productsAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = productsUrl
        val request = Request.Builder()
            .url(mRequestURL.toString())
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented !")
            }


            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if(data !=null){
                    Log.d("Data","${data}")
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")
                    for(i in 0 until jsArray.length()){
                        val jsProducts = jsArray.getJSONObject(i)
                        val name =jsProducts.optString("name","")
                        val description =jsProducts.optString("description","")
                        val pictureUrl =jsProducts.optString("picture_url","")
                        val product = Product(name = name, description = description, picture_url = pictureUrl)
                        products.add(product)
                    }
                    runOnUiThread(Runnable {
                        productsAdapter.notifyDataSetChanged()
                    })
                }
            }
        })

    }
}