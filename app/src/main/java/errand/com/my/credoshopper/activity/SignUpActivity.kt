package errand.com.my.credoshopper.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.views.PoppinsButton

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signup = findViewById<PoppinsButton>(R.id.buttonSignUp)
        signup.setOnClickListener { startActivity(Intent(this@SignUpActivity, LoginActivity::class.java)) }
    }
}
