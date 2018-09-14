package errand.com.my.credoshopper.activity.shopper

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageButton

import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.activity.DashBoardActivity
import errand.com.my.credoshopper.fragment.shoppers.ErrandListFragment
import errand.com.my.errands.fragment.ErrandKindsFragment
import errand.com.my.errands.fragment.MyErrandsFragment
import errand.com.my.errands.fragment.ProfileFragment
import errand.com.my.credoshopper.listener.FragmentListener

class ShopperActivity : AppCompatActivity(), FragmentListener {
    private var backButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopper)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, ErrandListFragment())
                .addToBackStack("tag of fragment")
                .commit()

        findViewById<View>(R.id.home).alpha = 1f
        findViewById<View>(R.id.errands).alpha = 0.3f
        findViewById<View>(R.id.profile).alpha = 0.3f

        backButton = findViewById(R.id.buttonBack)
        backButton!!.visibility = View.GONE

        backButton!!.setOnClickListener{
            backClicked()
        }
        findViewById<View>(R.id.signOut).setOnClickListener {
            signOutClicked()
        }
        findViewById<View>(R.id.home).setOnClickListener {
            homeClicked()
        }
        findViewById<View>(R.id.errands).setOnClickListener {
            errandsClicked()
        }
        findViewById<View>(R.id.profile).setOnClickListener {
            profileClicked()
        }

    }

    private fun homeClicked() {
        backButton!!.visibility = View.GONE

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ErrandListFragment())
                .addToBackStack("tag of fragment")
                .commit()
        findViewById<View>(R.id.home).alpha = 1f
        findViewById<View>(R.id.errands).alpha = 0.3f
        findViewById<View>(R.id.profile).alpha = 0.3f
    }

    private fun errandsClicked() {
        backButton!!.visibility = View.GONE

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyErrandsFragment())
                .addToBackStack("tag of fragment")
                .commit()

        findViewById<View>(R.id.home).alpha = 0.3f
        findViewById<View>(R.id.errands).alpha = 1f
        findViewById<View>(R.id.profile).alpha = 0.3f
    }

    private fun profileClicked() {
        backButton!!.visibility = View.GONE

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfileFragment())
                .addToBackStack("tag of fragment")
                .commit()

        findViewById<View>(R.id.home).alpha = 0.3f
        findViewById<View>(R.id.errands).alpha = 0.3f
        findViewById<View>(R.id.profile).alpha = 1f
    }

    private fun signOutClicked() {
        val builder = AlertDialog.Builder(this@ShopperActivity)
        builder.setMessage("Please confirm logout")
                .setPositiveButton("Logout") { _, _ ->
                    //new AppDatabase(MainActivity.this).clearAllData();
                    //prefs.clearSession();

                    startActivity(Intent(this@ShopperActivity, DashBoardActivity::class.java)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
                }
                .setNegativeButton("Cancel") { _, _ -> }
                .create().show()
    }

    private fun backClicked() {
        fragmentListener!!.childListener(true)
    }

    override fun childListener(value: Boolean) {
        backButton!!.visibility = View.VISIBLE
    }

    companion object {
        var fragmentListener: FragmentListener? = null
    }
}
