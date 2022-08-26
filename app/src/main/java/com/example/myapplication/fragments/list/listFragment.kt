package com.example.myapplication.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.viewmodel.ContactuserViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class listFragment : Fragment() {

    private lateinit var  mContactuserViewModel: ContactuserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_list, container, false)


        //RecyclerView
        val adapter = ContactlistAdapter()
        val recyclerView=view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())


        // ContactuserViewModel

        mContactuserViewModel = ViewModelProvider(this).get(ContactuserViewModel::class.java)

        mContactuserViewModel.readAllData.observe(viewLifecycleOwner, Observer { contactuser->

            adapter.setData(contactuser)
        })
    view.floatingActionButton.setOnClickListener {


    findNavController().navigate(R.id.action_listFragment_to_addFragment)
}


        return view

    }


}