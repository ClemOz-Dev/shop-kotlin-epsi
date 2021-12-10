package fr.brand.shop_kotlin
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.json.JSONObject


class StudentsActivity : BaseActivity() {
    val data = "{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"picture_url\": \"https://www.numerama.com/content/uploads/2019/05/trou-noir-espace-univers-astronomie.jpg\",\n" +
            "      \"firstname\": \"Allan\",\n" +
            "      \"lastname\": \"bordeaux\",\n" +
            "      \"group\": \"33000\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"email\": \"allan@epsi.fr\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg\",\n" +
            "      \"firstname\": \"Arraud\",\n" +
            "      \"lastname\": \"bordeaux\",\n" +
            "      \"group\": \"33000\",\n" +
            "      \"email\": \"arraud@epsi.fr\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://media.gettyimages.com/photos/colorful-powder-explosion-in-all-directions-in-a-nice-composition-picture-id890147976?s=2048x2048\",\n" +
            "      \"firstname\": \"Nicolas\",\n" +
            "      \"lastname\": \"bordeaux\",\n" +
            "      \"group\": \"33000\",\n" +
            "      \"email\": \"nicolas@epsi.fr\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    override fun onCreate(savedInstanceState: Bundle?) {
        val students = arrayListOf<Student>()
        val jsOb= JSONObject(data)
        val jsArray =jsOb.getJSONArray("items")
        for(i in 0 until jsArray.length()){
            val jsStudent = jsArray.getJSONObject(i)
            val firstname =jsStudent.optString("firstname","")
            val lastname =jsStudent.optString("lastname","")
            val email =jsStudent.optString("email","")
            val group =jsStudent.optString("group","")
            val picture_url =jsStudent.optString("picture_url","")
            val student = Student(firstname = firstname, lastname = lastname, email = email, imgUrl = picture_url, group = group)
            students.add(student)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        val buttonStudent1: Button = findViewById(R.id.buttonStudent1)
        val buttonStudent2: Button = findViewById(R.id.buttonStudent2)
        val buttonStudent3: Button = findViewById(R.id.buttonStudent3)

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,SingleStudentActivity::class.java)
            newIntent.putExtra("title",getString(R.string.student_1))
            newIntent.putExtra("current_student", students[0]);
            startActivity(newIntent)
        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,SingleStudentActivity::class.java)
            newIntent.putExtra("title",getString(R.string.student_2))
            newIntent.putExtra("current_student", students[1]);
            startActivity(newIntent)
        })

        buttonStudent3.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,SingleStudentActivity::class.java)
            newIntent.putExtra("title",getString(R.string.student_3))
            newIntent.putExtra("current_student", students[2]);
            startActivity(newIntent)
        })

    }
}