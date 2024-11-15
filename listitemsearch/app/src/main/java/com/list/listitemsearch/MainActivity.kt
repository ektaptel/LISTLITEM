package com.list.listitemsearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.list.listitemsearch.adpater.UserAdapter
import com.list.listitemsearch.data.UserRepository
import com.list.listitemsearch.model.UserViewModel
import com.list.listitemsearch.model.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    private val userRepository = UserRepository()
    private val userViewModel: UserViewModel by viewModels { UserViewModelFactory(userRepository) }
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText = findViewById<EditText>(R.id.etSearch)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = UserAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Observe LiveData
        userViewModel.filteredUsers.observe(this) { users ->
            adapter.updateList(users)
        }


        userViewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
        userViewModel.fetchUsers(
            ""
        )
        // Search functionality
       searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userViewModel.filterUsers(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })





    }
}