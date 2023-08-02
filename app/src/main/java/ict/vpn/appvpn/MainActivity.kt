package ict.vpn.appvpn

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ict.vpn.appvpn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.coin.setOnClickListener { view -> handleViewClick(view) }
        binding.menu.setOnClickListener { view -> handleViewClick(view) }
        binding.morecoin.setOnClickListener { view -> handleViewClick(view) }
    }
    private fun handleViewClick(view: View) {
        when (view.id) {
            R.id.menu->{
                binding.drawerLayout.openDrawer(binding.navigationView)
            }
            R.id.coin -> {
                showDailyCheckinDialog()
            }
            R.id.morecoin -> {
            }
        }
    }

    private fun showDailyCheckinDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_daily_checkin, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
        val dialog = dialogBuilder.create()
        val window = dialog.window
        window?.setBackgroundDrawableResource(android.R.color.transparent) // Đặt nền của dialog thành transparent

        dialog.show()
    }
}
