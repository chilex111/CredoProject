package errand.com.my.errands.child_fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.listener.FragmentListener

class CreateErrandsFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var errand_type: String? = null
    private var deliveryAddress: EditText? = null
    private var itemNames: EditText? = null
    private var itemValue: EditText? = null
    private var budgetAmt: EditText? = null
    private var transportAmt: EditText? = null
    private var spinnerUrgency: Spinner? = null
    private val buttonSend: Button? = null
    private var errandType: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            errand_type = arguments!!.getString(STRING_ERRAND)
        }
        fragmentListener!!.childListener(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_errands, container, false)
        deliveryAddress = view.findViewById(R.id.editAddress)
        errandType = view.findViewById(R.id.errandType)
        itemValue = view.findViewById(R.id.errandAmt)
        itemNames = view.findViewById(R.id.errandList)
        budgetAmt = view.findViewById(R.id.editBudget)
        transportAmt = view.findViewById(R.id.editTransportAmt)
        spinnerUrgency = view.findViewById(R.id.spinnerTime)

        if (errand_type == "drop") {
            view.findViewById<View>(R.id.linearPick).visibility = View.VISIBLE
            view.findViewById<View>(R.id.tableItem).visibility = View.GONE
        } else {
            view.findViewById<View>(R.id.linearPick).visibility = View.GONE
            view.findViewById<View>(R.id.tableItem).visibility = View.VISIBLE
        }

        errandType!!.text = errand_type

        view.findViewById<View>(R.id.buttonSend).setOnClickListener { sendErrand() }

        return view
    }

    private fun sendErrand() {

    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val STRING_ERRAND = "param1"
        var fragmentListener: FragmentListener? = null
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String): CreateErrandsFragment {
            val fragment = CreateErrandsFragment()
            val args = Bundle()
            args.putString(STRING_ERRAND, param1)
            fragment.arguments = args
            return fragment
        }
    }


}// Required empty public constructor
