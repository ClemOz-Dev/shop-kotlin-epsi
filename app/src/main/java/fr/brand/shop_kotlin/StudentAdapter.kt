package fr.brand.shop_kotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class StudentAdapter (private val students: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val buttonStudent = view.findViewById<Button>(R.id.buttonStudent)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.button_student, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students.get(position)
        holder.buttonStudent.text=student.firstname
        //holder.textViewLastName.text=student.lastname
        //holder.textViewEmail.text=student.email
        //holder.textViewGroup.text=student.group
        //Picasso.get().load(student.imgUrl).into(holder.imageViewStudent)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}