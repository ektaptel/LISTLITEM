package com.list.listitemsearch.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.list.listitemsearch.data.User
import com.list.listitemsearch.data.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val users = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()
    val filteredUsers = MutableLiveData<List<User>>()

    fun fetchUsers(query: String = "") {
        viewModelScope.launch {
            try {

                val result = repository.searchUsers(query)
                users.postValue(result)
                filteredUsers.postValue(result)  // Initialize with all users
            } catch (e: Exception) {
                errorMessage.postValue("Error: ${e.message}")
            }
        }
    }


    fun filterUsers(searchText: String) {
        val allUsers = users.value ?: emptyList()

        if (searchText.isEmpty()) {
            // Show all users when the search box is empty
            filteredUsers.postValue(allUsers)
        } else {
            filteredUsers.postValue(
                allUsers.filter {
                    it.firstName.contains(searchText, ignoreCase = true) ||
                            it.lastName.contains(searchText, ignoreCase = true) ||
                            it.age.toString().contains(searchText) ||
                            it.phone.toString().contains(searchText)||
                            it.gender.contains(searchText, ignoreCase = true)||
                            it.email.contains(searchText, ignoreCase = true) ||
                            it.email.contains(searchText, ignoreCase = true)||
                            it.username.contains(searchText, ignoreCase = true)||
                            it.password.contains(searchText, ignoreCase = true)||
                            it.birthDate.contains(searchText, ignoreCase = true)||
                            it.bloodGroup.contains(searchText, ignoreCase = true)||
                            it.eyeColor.contains(searchText, ignoreCase = true)||
                            it.hair.type.contains(searchText, ignoreCase = true)||
                            it.hair.color.contains(searchText, ignoreCase = true) ||
                            it.eyeColor.contains(searchText, ignoreCase = true) ||
                            it.ip.contains(searchText, ignoreCase = true)||
                            it.address.address.contains(searchText, ignoreCase = true)||
                            it.address.city.contains(searchText, ignoreCase = true)||
                            it.address.state.contains(searchText, ignoreCase = true)||
                            it.address.stateCode.contains(searchText, ignoreCase = true)||
                            it.address.postalCode.contains(searchText, ignoreCase = true) ||
                            it.bank.cardExpire.contains(searchText, ignoreCase = true)||
                            it.bank.currency.contains(searchText, ignoreCase = true)||
                            it.bank.iban.contains(searchText, ignoreCase = true)||
                            it.bank.cardNumber.contains(searchText, ignoreCase = true)||
                            it.bank.cardType.contains(searchText, ignoreCase = true)||
                            it.company.department.contains(searchText, ignoreCase = true)||
                            it.company.name.contains(searchText, ignoreCase = true)||
                            it.company.title.contains(searchText, ignoreCase = true)||
                            it.company.address.address.contains(searchText, ignoreCase = true)||
                            it.company.address.city.contains(searchText, ignoreCase = true)||
                            it.company.address.state.contains(searchText, ignoreCase = true)||
                            it.company.address.stateCode.contains(searchText, ignoreCase = true)||
                            it.company.address.postalCode.contains(searchText, ignoreCase = true)||
                            it.company.address.country.contains(searchText, ignoreCase = true)||
                            it.ein.contains(searchText, ignoreCase = true)||
                            it.ssn.contains(searchText, ignoreCase = true)||
                            it.userAgent.contains(searchText, ignoreCase = true)||
                            it.crypto.coin.contains(searchText, ignoreCase = true)||
                            it.crypto.wallet.contains(searchText, ignoreCase = true)||
                            it.crypto.network.contains(searchText, ignoreCase = true)||
                            it.role.contains(searchText, ignoreCase = true)

                }
            )
        }
    }
}