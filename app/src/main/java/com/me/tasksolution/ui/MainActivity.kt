package com.me.tasksolution.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.me.tasksolution.ClinicApplication
import com.me.tasksolution.R
import com.me.tasksolution.ui.utils.ClinicListAdapter

@Suppress("DEPRECATION")
class MainActivity : Fragment() {

    private val clinicListViewModel: ClinicViewModel by viewModels {
        ClinicViewModelFactory((requireActivity().application as ClinicApplication).clinicRepository)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val rvClinicList = requireActivity().findViewById<RecyclerView>(R.id.rvClinicList)
        val adapter = ClinicListAdapter { clinic ->
            //TODO
        }
        rvClinicList.adapter = adapter
        clinicListViewModel.clinicList.observe(viewLifecycleOwner, { clinic ->
            adapter.submitList(clinic)
        })
        val refreshLayout = requireActivity().findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        refreshLayout.setOnRefreshListener {
            clinicListViewModel.refreshData() // Refresh Data
            Toast.makeText(requireContext(), " Data Updated ", Toast.LENGTH_LONG).show()
            refreshLayout.isRefreshing = false
        }
    }
}