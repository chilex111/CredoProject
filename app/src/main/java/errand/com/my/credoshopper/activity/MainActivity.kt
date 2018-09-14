package errand.com.my.credoshopper.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import errand.com.my.credoshopper.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.buttonLogIn)
                .setOnClickListener { startActivity(Intent(this@MainActivity, LoginActivity::class.java)) }
        findViewById<View>(R.id.buttonSignUp)
                .setOnClickListener { startActivity(Intent(this@MainActivity, SignUpActivity::class.java)) }
    }

    fun infoCenterClicked(view: View) {

    }
}
