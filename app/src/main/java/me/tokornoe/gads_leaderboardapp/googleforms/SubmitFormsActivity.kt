package me.tokornoe.gads_leaderboardapp.googleforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.tokornoe.gads_leaderboardapp.R
import retrofit2.Call
import retrofit2.Callback
import java.lang.Exception

class SubmitFormsActivity : AppCompatActivity() {

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        postFormsData()
    }

    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var email: String
    private lateinit var githubLink: String


    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var githubLinkEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_forms)

        firstNameEditText = findViewById(R.id.first_name_edit)
        lastNameEditText = findViewById(R.id.last_name_edit)
        emailEditText = findViewById(R.id.email_edit)
        githubLinkEditText = findViewById(R.id.github_link_edit)

        firstName = firstNameEditText.text.toString()
        lastName = lastNameEditText.text.toString()
        email = emailEditText.text.toString()
        githubLink = githubLinkEditText.text.toString()
    }

    private fun postFormsData() {
        coroutineScope.launch {
            var post = GoogleWebFormsService.formsApiService.postValues(firstName, lastName, email, githubLink)
            try {
                post.execute().isSuccessful
            } catch (e: Exception) {
                Toast.makeText(this@SubmitFormsActivity,
                    "Submission Failed", Toast.LENGTH_LONG).show()
            }

        }
    }

}