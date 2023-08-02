package ict.vpn.appvpn

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class serve_list : AppCompatActivity(), View.OnClickListener {

    private lateinit var usContent: LinearLayout
    private lateinit var ukContent: LinearLayout
    private lateinit var germanyContent: LinearLayout
    private lateinit var japanContent: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sever_list)

        usContent = findViewById(R.id.us_content)
        ukContent = findViewById(R.id.uk_content)
        germanyContent = findViewById(R.id.germany_content)
        japanContent = findViewById(R.id.japan_content)

        // Đăng ký bộ lắng nghe khi người dùng nhấp vào dấu mũi tên xuống tương ứng
        findViewById<View>(R.id.us_down).setOnClickListener(this)
        findViewById<View>(R.id.uk).setOnClickListener(this)
        findViewById<View>(R.id.germany).setOnClickListener(this)
        findViewById<View>(R.id.japan).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // Xử lý sự kiện khi người dùng nhấp vào dấu mũi tên xuống tương ứng
        when (v.id) {
            R.id.us_down -> {
                toggleVisibility(usContent)
                toggleArrowIcon(v as ImageView)
            }
            R.id.us_up -> {
                toggleVisibility(usContent)
                toggleArrowIcon(v as ImageView)
            }
            R.id.uk -> {
                toggleVisibility(ukContent)
                toggleArrowIcon(v as ImageView)
            }
            R.id.germany -> {
                toggleVisibility(germanyContent)
                toggleArrowIcon(v as ImageView)
            }
            R.id.japan -> {
                toggleVisibility(japanContent)
                toggleArrowIcon(v as ImageView)
            }
        }
    }

    // Phương thức để hiển thị/ẩn nội dung tương ứng
    private fun toggleVisibility(contentLayout: LinearLayout) {
        if (contentLayout.visibility == View.VISIBLE) {
            contentLayout.visibility = View.GONE
        } else {
            contentLayout.visibility = View.VISIBLE
        }
    }
    // Phương thức để xoay biểu tượng mũi tên xuống thành mũi tên lên và ngược lại
    private fun toggleArrowIcon(arrow: ImageView) {
        if (arrow.id == R.id.us_down) {
            arrow.setImageResource(R.drawable.arrow_up)
            arrow.id = R.id.us_up
        } else if (arrow.id == R.id.us_up) {
            arrow.setImageResource(R.drawable.arrow_down)
            arrow.id = R.id.us_down
        }
        // Các điều kiện tương tự cho các biểu tượng khác nếu cần
    }
}
