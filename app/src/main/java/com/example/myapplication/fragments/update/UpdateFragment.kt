package com.example.myapplication.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.data.Contactuser
import com.example.myapplication.viewmodel.ContactuserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
private lateinit var mContactuserViewModel: ContactuserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_update, container, false)
        mContactuserViewModel =ViewModelProvider(this).get(ContactuserViewModel::class.java)
        view.updateFirstName_et.setText(args.currentContact.firstName)
        view.updateLastName_et.setText(args.currentContact.lastName)
        view.updateTextPhone.setText(args.currentContact.numero.toString())
        view.update_btn.setOnClickListener {
            updateItem()
        }


        //Add Menu
        setHasOptionsMenu(true)





        return view
    }
    private  fun updateItem(){
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val numero = updateTextPhone.text.toString()

        //val numero = Integer.parseInt(updateTextPhone.text.toString())
            //updateTextPhone.text.toString()

        if(inputCheck(firstName ,lastName ,numero)){

            // Create Contactuser object
            val updatedContactuser = Contactuser(args.currentContact.id,firstName,lastName,numero )


            // Update Current Contact user
            mContactuserViewModel.updateContactuser(updatedContactuser)


            // Navigate Back

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

            Toast.makeText(requireContext(), "Successfully updated!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }


    }
    private fun inputCheck(firstName: String, lastName: String, numero: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(numero))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId ==R.id.menu_delete){

            deleteContact()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteContact(){
    val builder =AlertDialog.Builder(requireContext())
    builder.setPositiveButton("Yes"){_,_->
        mContactuserViewModel.deleteContactuser(args.currentContact)
        Toast.makeText(requireContext(),"Successfully removed :${args.currentContact.firstName}",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }
    builder.setNegativeButton("No"){_,_->}
    builder.setTitle("Delete ${args.currentContact.firstName}?")
    builder.setMessage("Are you sure you want to delete ${args.currentContact.firstName}")
    builder.create().show()


    }
}