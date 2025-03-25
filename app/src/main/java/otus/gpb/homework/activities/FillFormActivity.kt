package otus.gpb.homework.activities

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FillFormActivity : AppCompatActivity() {
    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_SURNAME = "key_surname"
        const val KEY_AGE = "key_age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fill_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.buttonApply).apply {
            setOnClickListener {
                val name = findViewById<EditText>(R.id.editTextName).text.toString()
                val surname = findViewById<EditText>(R.id.editTextSurname).text.toString()
                val age = findViewById<EditText>(R.id.editTextAge).text.toString()
                val result = if (name.isEmpty() || surname.isEmpty() || age.isEmpty())
                    RESULT_CANCELED else RESULT_OK

                val intent = Intent()
                    .putExtra(KEY_NAME, name)
                    .putExtra(KEY_SURNAME, surname)
                    .putExtra(KEY_AGE, age)
                setResult(result, intent)
                finish()
            }
        }
    }
}