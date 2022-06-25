package com.protel.medskin.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.protel.medskin.R
import androidx.lifecycle.ViewModelProvider
import com.protel.medskin.databinding.FragmentInfoBinding
import com.protel.medskin.databinding.ActivityDetailResultBinding
import com.protel.medskin.ui.info.InfoViewModel

class DetailFragment : Fragment()  {

    private lateinit var infoViewModel: InfoViewModel
    private var _binding: FragmentInfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        infoViewModel =
            ViewModelProvider(this).get(InfoViewModel::class.java)

        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}