package com.me.tasksolution.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.me.tasksolution.R
import com.me.tasksolution.databinding.ItemListBinding
import com.me.tasksolution.model.Clinic

class ClinicListAdapter(private val clickCallBack:((Clinic) -> Unit)?):
    ListAdapter<Clinic,ClinicListAdapter.ClinicViewHolder>(ClinicCompare()) {

    class ClinicViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        private val txClinicName:TextView = itemView.findViewById(R.id.txClinicName)
        private val txCreatedFrom:TextView = itemView.findViewById(R.id.txCreatedFrom)
        private val txPrice:TextView = itemView.findViewById(R.id.txPrice)
        private val txDistance:TextView = itemView.findViewById(R.id.txDistance)
        private val txLocation:TextView = itemView.findViewById(R.id.txLocation)
        private val txRate:TextView = itemView.findViewById(R.id.txRate)
        fun bind(clinic: Clinic) {
            txClinicName.text = clinic.name
            txCreatedFrom.text = clinic.createdFrom
            txPrice.text = clinic.price
            txDistance.text = clinic.distance
            txLocation.text = clinic.location
            txRate.text = clinic.rate
        }
        companion object {
            fun create(parent: ViewGroup): ClinicViewHolder {
                return ClinicViewHolder(
                    ItemListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicViewHolder {
        return ClinicViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ClinicViewHolder, position: Int) {
        val clinic = getItem(position)
        holder.bind(clinic)
        holder.itemView.setOnClickListener { clickCallBack?.invoke(clinic) }
    }
}
class ClinicCompare : DiffUtil.ItemCallback<Clinic>() {
    override fun areItemsTheSame(
        oldItem: Clinic,
        newItem: Clinic
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Clinic,
        newItem: Clinic
    ): Boolean {
        return oldItem.name == newItem.name &&
                oldItem.price == newItem.price &&
                oldItem.location == newItem.location &&
                oldItem.rate == newItem.rate &&
                oldItem.createdFrom == newItem.createdFrom &&
                oldItem.distance == newItem.distance
    }
}