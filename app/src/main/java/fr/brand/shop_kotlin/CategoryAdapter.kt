package fr.brand.shop_kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CategoryAdapter  (private val categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewCategoryTitle = view.findViewById<TextView>(R.id.textViewCategoryTitle)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_category, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCategory = categories.get(position)

        holder.textViewCategoryTitle.text=currentCategory.title

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            // val newIntent= Intent(application,DetailActivity::class.java)
            // newIntent.putExtra("title",getString(R.string.txt_home_nature))
            //  intent.putExtra('category_url', currentCategory.products_url)
            //  startActivity(newIntent)
            Log.d("Clic :","${currentCategory.title}")
        })
        /*
        holder.contentLayout.setOnClickListener(View.OnClickListener {
            (holder.contentLayout.context.applicationContext as AppEpsi).showToast(student.name)
        })
        */
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}