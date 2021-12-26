package fr.brand.shop_kotlin

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ProductAdapter  (private val products: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewProductName = view.findViewById<TextView>(R.id.textViewProductCardName)
        val textViewProductCardDescription = view.findViewById<TextView>(R.id.textViewProductCardDescription)
        val imageViewProductCard = view.findViewById<ImageView>(R.id.imageViewProductCard)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_product, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = products.get(position)

        holder.textViewProductName.text=currentProduct.name
        holder.textViewProductCardDescription.text=(currentProduct.description).take(100) + "..."

        Picasso.get().load(currentProduct.picture_url).into(holder.imageViewProductCard)

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            val activity = holder.itemView.context as Activity
            val newIntent= Intent(activity, SingleProductActivity::class.java)
            newIntent.putExtra("name",currentProduct.name)
            newIntent.putExtra("description",currentProduct.description)
            newIntent.putExtra("picture_url", currentProduct.picture_url)
            activity.startActivity(newIntent)
        })
        /*
        holder.contentLayout.setOnClickListener(View.OnClickListener {
            (holder.contentLayout.context.applicationContext as AppEpsi).showToast(student.name)
        })
        */
    }

    override fun getItemCount(): Int {
        return products.size
    }
}