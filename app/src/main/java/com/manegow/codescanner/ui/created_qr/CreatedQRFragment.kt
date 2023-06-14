package com.manegow.codescanner.ui.created_qr // ktlint-disable package-name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.manegow.codescanner.databinding.FragmentCreatedQrBinding
import com.manegow.codescanner.ui.scan.CreatedQRViewModel

class CreatedQRFragment : Fragment() {

    private var _binding: FragmentCreatedQrBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val createQRViewModel =
            ViewModelProvider(this).get(CreatedQRViewModel::class.java)

        _binding = FragmentCreatedQrBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        createQRViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
