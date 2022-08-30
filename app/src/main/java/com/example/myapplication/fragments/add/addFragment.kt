package com.example.myapplication.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.Contactuser
import com.example.myapplication.viewmodel.ContactuserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class addFragment : Fragment() {


    private lateinit var mUserViewModel: ContactuserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(ContactuserViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }


    return view
    }
    private fun insertDataToDatabase() {
        val firstName = addFirstName_et.text.toString()
        val lastName = addLastName_et.text.toString()
        val numero = editTextPhone.text.toString()

        if(inputCheck(firstName, lastName, numero)){
            // Create User Object
            val contactuser = Contactuser(0, firstName, lastName, numero)
            // Add Data to Database
            mUserViewModel.addContactuser(contactuser)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, numero: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(numero))
    }

}