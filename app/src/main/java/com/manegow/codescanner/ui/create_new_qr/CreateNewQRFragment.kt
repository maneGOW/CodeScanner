package com.manegow.codescanner.ui.create_new_qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.manegow.codescanner.databinding.FragmentNewQrBinding
import com.manegow.codescanner.ui.scan.CreatedQRViewModel

class CreateNewQRFragment : Fragment() {

    private var _binding: FragmentNewQrBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val createdQRViewModel =
            ViewModelProvider(this).get(CreatedQRViewModel::class.java)

        _binding = FragmentNewQrBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        createdQRViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
