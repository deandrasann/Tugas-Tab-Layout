package com.example.pertemuan7

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.pertemuan7.databinding.ActivityDashboardBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    companion object {
        private val TAB_TITLES = intArrayOf(R.string.tab_text1, R.string.tab_text2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val sectionsPagerAdapter = SecondPagerAdapter(this)
//        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
//        viewPager.adapter = sectionsPagerAdapter
//
//        val tabs: TabLayout = findViewById(R.id.tab_layout)
//        TabLayoutMediator(tabs, viewPager) { tab, position ->
//            tab.text = resources.getString(TAB_TITLES[position])
//        }.attach()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboard_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_log_out -> {
                Toast.makeText(this, "Successfully logged out", Toast.LENGTH_SHORT).show()
                val intentToLoginFragment = Intent (this, LoginFragment::class.java)
                startActivity(intentToLoginFragment)
                true
            }
            R.id.action_profile -> {
                Toast.makeText(this, "Your profile", Toast.LENGTH_SHORT).show()
                val username = intent.getStringExtra("EXTRA_USERNAME")
                val nim = intent.getStringExtra("EXTRA_NIM")

                val intentToProfileActivity = Intent(this, ProfileActivity::class.java)
                intentToProfileActivity.putExtra("EXTRA_USERNAME", username)
                intentToProfileActivity.putExtra("EXTRA_NIM", nim)
                startActivity(intentToProfileActivity)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
