package errand.com.my.credoshopper.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import errand.com.my.credoshopper.R
import errand.com.my.credoshopper.listener.FragmentListener
import errand.com.my.credoshopper.model.ErrandModel

class ErrandListAdapter
(private val bankModelList: List<ErrandModel>?, private val context: Context)
    : RecyclerView.Adapter<ErrandListAdapter.BankViewHolder>() {

    companion object {
        var cardPosition: Int? = -1
        var listener: FragmentListener ?= null
    }

    class BankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView? = null
        var errandType: TextView? = null
        var postTime: TextView? = null
        var location: TextView?= null
        var urgency: TextView ?= null
        var budget: TextView ?= null
        var sender: TextView ?= null
        var details: TextView ?= null

        init {
            cardView = itemView.findViewById(R.id.cardView)
            errandType = itemView.findViewById(R.id.textErrandType)
            postTime = itemView.findViewById(R.id.posted)
            location = itemView.findViewById(R.id.textDeliveryLocation)
            urgency = itemView.findViewById(R.id.textUrgency)
            budget = itemView.findViewById(R.id.textBudget)
            sender = itemView.findViewById(R.id.sender)
            details = itemView.findViewById(R.id.details)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.custom_errand_list, parent, false)

        return BankViewHolder(v)
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.details!!.setOnClickListener {
            listener!!.childListener(true)
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}

