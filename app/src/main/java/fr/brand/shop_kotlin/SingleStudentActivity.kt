package fr.brand.shop_kotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class SingleStudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val i = intent
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_student)
        showBtnBack()
        i.getStringExtra("title")?.let { setHeaderTitle(it) }
        val currentStudent = i.getSerializableExtra("current_student") as Student?

        val imageViewStudent = findViewById<ImageView>(R.id.imageViewStudent)
        Picasso.get().load(currentStudent?.img_url).into(imageViewStudent)


        val textViewFirstName = findViewById<TextView>(R.id.textViewFirstName)
        textViewFirstName.text = currentStudent?.firstname

        val textViewLastName = findViewById<TextView>(R.id.textViewLastName)
        textViewLastName.text = currentStudent?.lastname

        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        textViewEmail.text = currentStudent?.email

        val textViewGroup = findViewById<TextView>(R.id.textViewGroup)
        textViewGroup.text = currentStudent?.group

    }
}