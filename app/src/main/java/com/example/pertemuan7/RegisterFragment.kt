package com.example.pertemuan7

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.pertemuan7.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the click listener for the button
//        binding.btnToProfile.setOnClickListener {
//            val intentToDashboard = Intent(requireActivity(), DashboardActivity::class.java)
//            intentToDashboard.putExtra("EXTRA_USERNAME", binding.inputNama.text.toString())
//            intentToDashboard.putExtra("EXTRA_NIM", binding.inputNim.text.toString())
//            startActivity(intentToDashboard)
//        }
        with(binding) {
            btnToProfile.setOnClickListener {
                val loginArgs = Bundle().apply {
                    putString("EXTRA_USERNAME", inputNama.text.toString())
                    putString("EXTRA_NIM", inputNim.text.toString())

                }
                val secondPagerAdapter = SecondPagerAdapter(requireActivity()
                        as AppCompatActivity, loginArgs)
                val viewPager : ViewPager2 = requireActivity().findViewById(R.id.view_pager)
                viewPager.adapter = secondPagerAdapter
            }

            // Apply window insets
            ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}

