package errand.com.my.credoshopper.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageButton

import errand.com.my.credoshopper.R
import errand.com.my.errands.child_fragment.CreateErrandsFragment
import errand.com.my.errands.fragment.ErrandKindsFragment
import errand.com.my.errands.fragment.MyErrandsFragment
import errand.com.my.errands.fragment.ProfileFragment
import errand.com.my.errands.fragment.ServiceFragment
import errand.com.my.credoshopper.listener.FragmentListener

class HomeActivity : AppCompatActivity(), FragmentListener {
    private var backButton: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        CreateErrandsFragment.fragmentListener = this

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction()
                .add(R.id.container, ErrandKindsFragment())
                .addToBackStack("tag of fragment")
                .commit()

        findViewById<View>(R.id.home).alpha = 1f
        findViewById<View>(R.id.errands).alpha = 0.3f
        findViewById<View>(R.id.profile).alpha = 0.3f
        findViewById<View>(R.id.service).alpha = 0.3f

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
        findViewById<View>(R.id.service).setOnClickListener {
            serviceClicked()
        }
    }

    fun homeClicked() {
        backButton!!.visibility = View.GONE

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ErrandKindsFragment())
                .addToBackStack("tag of fragment")
                .commit()
        findViewById<View>(R.id.home).alpha = 1f
        findViewById<View>(R.id.errands).alpha = 0.3f
        findViewById<View>(R.id.profile).alpha = 0.3f
        findViewById<View>(R.id.service).alpha = 0.3f
    }

    fun errandsClicked() {
        backButton!!.visibility = View.GONE

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyErrandsFragment())
                .addToBackStack("tag of fragment")
                .commit()

        findViewById<View>(R.id.home).alpha = 0.3f
        findViewById<View>(R.id.errands).alpha = 1f
        findViewById<View>(R.id.profile).alpha = 0.3f
        findViewById<View>(R.id.service).alpha = 0.3f
    }

    fun profileClicked() {
        backButton!!.visibility = View.GONE

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfileFragment())
                .addToBackStack("tag of fragment")
                .commit()

        findViewById<View>(R.id.home).alpha = 0.3f
        findViewById<View>(R.id.errands).alpha = 0.3f
        findViewById<View>(R.id.profile).alpha = 1f
        findViewById<View>(R.id.service).alpha = 0.3f
    }

    fun serviceClicked() {
        backButton!!.visibility = View.GONE

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ServiceFragment())
                .addToBackStack("tag of fragment")
                .commit()

        findViewById<View>(R.id.home).alpha = 0.3f
        findViewById<View>(R.id.errands).alpha = 0.3f
        findViewById<View>(R.id.profile).alpha = 0.3f
        findViewById<View>(R.id.service).alpha = 1f
    }

    fun signOutClicked() {
        val builder = AlertDialog.Builder(this@HomeActivity)
        builder.setMessage("Please confirm logout")
                .setPositiveButton("Logout") { dialog, which ->
                    //new AppDatabase(MainActivity.this).clearAllData();
                    //prefs.clearSession();

                    startActivity(Intent(this@HomeActivity, DashBoardActivity::class.java)
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
