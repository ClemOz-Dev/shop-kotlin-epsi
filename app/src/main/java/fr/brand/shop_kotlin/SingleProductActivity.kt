package fr.brand.shop_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class SingleProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val i = intent
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_product)
        showBtnBack()

        i.getStringExtra("name")?.let { setHeaderTitle(it) }

        val imageViewSingleProduct = findViewById<ImageView>(R.id.imageViewSingleProduct)
        Picasso.get().load(i.getStringExtra("picture_url")).into(imageViewSingleProduct)


        val textViewLastName = findViewById<TextView>(R.id.TextViewSingleProductDescription)
        textViewLastName.text = i.getStringExtra("description")



    }
}