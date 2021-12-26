package fr.brand.shop_kotlin
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.json.JSONObject
import studentData


class StudentsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val students = arrayListOf<Student>()
        val jsOb= JSONObject(studentData)
        val jsArray =jsOb.getJSONArray("items")
        for(i in 0 until jsArray.length()){
            val jsStudent = jsArray.getJSONObject(i)
            val firstname =jsStudent.optString("firstname","")
            val lastname =jsStudent.optString("lastname","")
            val email =jsStudent.optString("email","")
            val group =jsStudent.optString("group","")
            val pictureUrl =jsStudent.optString("picture_url","")
            val student = Student(firstname = firstname, lastname = lastname, email = email, img_url = pictureUrl, group = group)
            students.add(student)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        showBtnBack()
        setHeaderTitle("Infos")
        val buttonStudent1: Button = findViewById(R.id.buttonStudent1)
        val buttonStudent2: Button = findViewById(R.id.buttonStudent2)
        val buttonStudent3: Button = findViewById(R.id.buttonStudent3)

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,SingleStudentActivity::class.java)
            newIntent.putExtra("title",students[0].firstname)
            newIntent.putExtra("current_student", students[0]);
            startActivity(newIntent)
        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,SingleStudentActivity::class.java)
            newIntent.putExtra("title",students[1].firstname)
            newIntent.putExtra("current_student", students[1]);
            startActivity(newIntent)
        })

        buttonStudent3.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,SingleStudentActivity::class.java)
            newIntent.putExtra("title",students[2].firstname)
            newIntent.putExtra("current_student", students[2]);
            startActivity(newIntent)
        })

    }
}