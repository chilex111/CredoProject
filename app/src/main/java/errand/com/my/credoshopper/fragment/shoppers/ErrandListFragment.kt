package errand.com.my.credoshopper.fragment.shoppers

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.adapter.ErrandListAdapter
import errand.com.my.credoshopper.listener.FragmentListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ErrandListFragment : Fragment(), FragmentListener {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var textEmpty: TextView?= null
    private var recyclerView: RecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        ErrandListAdapter.listener = this

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_errand_list, container, false)
        textEmpty = v.findViewById(R.id.textEmpty)
        recyclerView = v.findViewById(R.id.recyclerView)

        val errandListAdapter = ErrandListAdapter(null, this.activity!!)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = errandListAdapter
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.requestFocus()
        return v
    }

    override fun childListener(value: Boolean) {
        if (value){
            childFragmentManager.beginTransaction()
                    .add(R.id.container, ErrandDetailFragment())
                    .addToBackStack("tag of fragment")
                    .commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ErrandListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ErrandListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
