package fr.brand.shop_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ShopActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        setHeaderTitle("Rayons")
        showBtnBack()

        val categories = arrayListOf<Category>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoryAdapter(categories)
        recyclerView.adapter = categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
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
                    // Log.d("Data","${data}")
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")
                    for(i in 0 until jsArray.length()){
                        val jsCategory = jsArray.getJSONObject(i)
                        val title =jsCategory.optString("title","")
                        val category_id =jsCategory.optString("category_id","")
                        val products_url =jsCategory.optString("products_url","")
                        val category = Category(title = title, category_id = category_id, products_url = products_url)
                        categories.add(category)
                    }
                    runOnUiThread(Runnable {
                        categoryAdapter.notifyDataSetChanged()
                    })
                }
            }
        })




    }
}