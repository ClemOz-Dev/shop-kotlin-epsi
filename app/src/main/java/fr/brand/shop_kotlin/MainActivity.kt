package fr.brand.shop_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonZone1: Button = findViewById(R.id.buttonZone1)
        val buttonZone2: Button = findViewById(R.id.buttonZone2)

        buttonZone1.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,StudentsActivity::class.java)
            newIntent.putExtra("title",getString(R.string.zone_1))
            startActivity(newIntent)
        })

        buttonZone2.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,ShopActivity::class.java)
            newIntent.putExtra("title",getString(R.string.zone_2))
            startActivity(newIntent)
        })

    }


}