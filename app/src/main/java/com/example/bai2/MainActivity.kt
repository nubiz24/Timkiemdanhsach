package com.example.bai2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextSearch = findViewById<EditText>(R.id.editTextSearch)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Khởi tạo danh sách sinh viên
        studentList = mutableListOf(
            Student("Trịnh Hữu An", "20225593"),
            Student("Mạch Ngọc Đức Anh", "20225595"),
            Student("Phạm Việt Anh", "20225599"),
            Student("Nguyễn Hà Bách", "20225691"),
            Student("Nguyễn Đức Bình", "20225791"),
            Student("Đặng Đình Cường", "20225795"),
            Student("Nguyễn Trí Dũng", "20225613"),
            Student("Phan Đức Duy", "20225831"),
            Student("Phạm Tùng Dương", "20225825"),
            Student("Phạm Tiến Đại", "20225799"),
            Student("Lê Thành Đạt", "20225804"),
            Student("Đỗ Hoàng Đông", "20225807"),
            Student("Lê Nguyễn Minh Đức", "20225611"),
            Student("Trương Anh Đức", "20225814"),
            Student("Quách Gia Được", "20225820"),
            Student("Chu Đình Hà", "20225712"),
            Student("Nguyễn Đức Hậu", "20225834"),
            Student("Mai Trung Hiếu", "20225838"),
            Student("Lê Bá Ngọc Hiểu", "20225627"),
            Student("Nguyễn Huy Hoàng", "20225845"),
            Student("Nguyễn Mạnh Hùng", "20225630"),
            Student("Đặng Quang Huy", "20225853"),
            Student("Lường Văn Huy", "20227124"),
            Student("Nguyễn Thanh Hưng", "20225633"),
            Student("Lê Quang Khải", "20225638"),
            Student("Nguyễn Duy Khánh", "20225865"),
            Student("Nguyễn Minh Khôi", "20225642"),
            Student("Tạ Duy Lâm", "20225729"),
            Student("Vũ Quyền Gia Linh", "20225734"),
            Student("Phạm Đức Long", "20225737")
        )


        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        // Thiết lập TextWatcher cho ô tìm kiếm
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterList(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // Hàm lọc danh sách dựa trên từ khóa
    private fun filterList(query: String) {
        if (query.length > 2) {
            val filteredList = studentList.filter {
                it.name.contains(query, ignoreCase = true) || it.mssv.contains(query)
            }
            studentAdapter.updateList(filteredList)
        } else {
            studentAdapter.updateList(studentList)
        }
    }
}