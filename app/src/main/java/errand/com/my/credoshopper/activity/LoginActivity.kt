package errand.com.my.credoshopper.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.views.PoppinsButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login = findViewById<PoppinsButton>(R.id.buttonLogIn)
        login.setOnClickListener { startActivity(Intent(this@LoginActivity, DashBoardActivity::class.java)) }
    }
}
