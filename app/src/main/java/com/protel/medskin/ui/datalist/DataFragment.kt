package com.protel.medskin.ui.datalist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.protel.medskin.data.source.local.entity.DataEntity
import com.protel.medskin.databinding.FragmentDataBinding
import com.protel.medskin.utils.ViewModelFactory

class DataFragment : Fragment() {

    private var _binding: FragmentDataBinding? = null
    private lateinit var adapter: DataAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDataBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val dataViewModel =
            ViewModelProvider(this, factory)[DataViewModel::class.java]

        adapter = DataAdapter()

        dataViewModel.resultData().observe(viewLifecycleOwner, { data ->
            adapter.setList(data)
            adapter.notifyDataSetChanged()
            adapter.setOnItemClickCallback(object : DataAdapter.OnItemClickCallback {
                override fun onItemClicked(data: DataEntity) {
                    showDetailFragment(data)
                }
            })
        })

        binding.apply {

            rvData.layoutManager = LinearLayoutManager(context)
            rvData.setHasFixedSize(true)
            rvData.adapter = adapter

        }
    }

    private fun showDetailFragment(data: DataEntity) {
        val intent = Intent(activity, DetailData::class.java)
        intent.putExtra(DetailData.EXTRA_DATA, data)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}