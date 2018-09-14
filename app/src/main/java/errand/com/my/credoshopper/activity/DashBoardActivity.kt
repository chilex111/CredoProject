package errand.com.my.credoshopper.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

import com.bumptech.glide.Glide

import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.activity.shopper.ShopperActivity

class DashBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        val gif = findViewById<ImageView>(R.id.imageGif)
        Glide.with(this).load(R.raw.rider).asGif().into(gif)
        findViewById<View>(R.id.buttonShopper)
                .setOnClickListener { startActivity(Intent(this, ShopperActivity::class.java))}

        findViewById<View>(R.id.buttonErrand)
                .setOnClickListener { startActivity(Intent(this@DashBoardActivity, HomeActivity::class.java)) }
    }
}
