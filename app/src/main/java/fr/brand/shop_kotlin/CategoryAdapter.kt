package fr.brand.shop_kotlin


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class CategoryAdapter(private val categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){



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
            val activity = holder.itemView.context as Activity
            val newIntent= Intent(activity, ProductsActivity::class.java)
            newIntent.putExtra("title",currentCategory.title)
            newIntent.putExtra("productsUrl",currentCategory.products_url)
            activity.startActivity(newIntent)
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