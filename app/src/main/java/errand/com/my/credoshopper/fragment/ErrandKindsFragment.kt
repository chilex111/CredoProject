package errand.com.my.errands.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.activity.HomeActivity
import errand.com.my.errands.child_fragment.CreateErrandsFragment
import errand.com.my.credoshopper.listener.FragmentListener

class ErrandKindsFragment : Fragment(), FragmentListener {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
        HomeActivity.fragmentListener = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_errand_create, container, false)

        view.findViewById<View>(R.id.grocery).setOnClickListener {
            childFragmentManager.beginTransaction()
                    .replace(R.id.container, CreateErrandsFragment.newInstance("grocery"))
                    .addToBackStack("tag of fragment")
                    .commit()
        }
        view.findViewById<View>(R.id.dress).setOnClickListener {
            childFragmentManager.beginTransaction()
                    .replace(R.id.container, CreateErrandsFragment.newInstance("dress"))
                    .addToBackStack("tag of fragment")
                    .commit()
        }
        view.findViewById<View>(R.id.laundry).setOnClickListener {
            childFragmentManager.beginTransaction()
                    .replace(R.id.container, CreateErrandsFragment.newInstance("laundry"))
                    .addToBackStack("tag of fragment")
                    .commit()
        }

        view.findViewById<View>(R.id.drops).setOnClickListener {
            childFragmentManager.beginTransaction()
                    .replace(R.id.container, CreateErrandsFragment.newInstance("drop"))
                    .addToBackStack("tag of fragment")
                    .commit()
        }

        return view
    }

    override fun childListener(value: Boolean) {
        if (value) {
            if (activity != null) {
                if (childFragmentManager.backStackEntryCount > 0)
                    childFragmentManager.popBackStackImmediate()
                else
                    activity!!.onBackPressed()
            }
        }
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ErrandCreateFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): ErrandKindsFragment {
            val fragment = ErrandKindsFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
