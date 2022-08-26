package com.example.myapplication.fragments.list

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.ContactUser
import kotlinx.android.synthetic.main.contact_row.view.*

class ContactlistAdapter: RecyclerView.Adapter<ContactlistAdapter.MyViewHolder>() {


    private var contactList= emptyList<ContactUser>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = contactList[position]
        holder.itemView.t.text = currentItem.id.toString()
        holder.itemView.t2.text = currentItem.firstName
        holder.itemView.t3.text = currentItem.lastName
        //holder.itemView.phone.setText(currentItem.numero)
        //holder.itemView.editTextPhone.setText(currentItem.numero.toString())
        holder.itemView.phone.text = currentItem.number.toString()
        holder.itemView.rowLayout.setOnClickListener{

            val action = listFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }
    fun setData(contactuser : List<ContactUser>){
       this.contactList = contactuser
       notifyDataSetChanged()
    }


}