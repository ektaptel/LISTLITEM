package com.list.listitemsearch.adpater

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.list.listitemsearch.R
import com.list.listitemsearch.data.User

class UserAdapter(private var userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvfName)

        val email: TextView = itemView.findViewById(R.id.tvEmail)
        val age: TextView = itemView.findViewById(R.id.tvAge)
        val phone: TextView = itemView.findViewById(R.id.tvPhone)
        val image: ImageView = itemView.findViewById(R.id.ivProfile)
        val gender: TextView = itemView.findViewById(R.id.tvGender)
        val bloodGroup: TextView = itemView.findViewById(R.id.tvbloodGroup)
        val height: TextView = itemView.findViewById(R.id.tvHeight)
        val weight: TextView = itemView.findViewById(R.id.tvWeight)
        val username: TextView = itemView.findViewById(R.id.tvUsername)
        val password: TextView = itemView.findViewById(R.id.tvPassword)
        val birthdate: TextView = itemView.findViewById(R.id.tvBirthDate)
        val bloodgroup: TextView = itemView.findViewById(R.id.tvbloodGroup)
        val eyeColor: TextView = itemView.findViewById(R.id.tvEyeColor)
        val hair: TextView = itemView.findViewById(R.id.tvHair)
        val ip: TextView = itemView.findViewById(R.id.tvIp)
        val address: TextView = itemView.findViewById(R.id.tvAddress)
        val macAddress: TextView = itemView.findViewById(R.id.tvMacAddress)
        val university: TextView = itemView.findViewById(R.id.tvUniversity)
        val bank: TextView = itemView.findViewById(R.id.tvBank)
        val company: TextView = itemView.findViewById(R.id.tvCompany)
        val ein: TextView = itemView.findViewById(R.id.tvEin)
        val ssn: TextView = itemView.findViewById(R.id.tvSsn)
        val userAgent: TextView = itemView.findViewById(R.id.tvUserAgent)
        val crypto: TextView = itemView.findViewById(R.id.tvCrypto)
        val role: TextView = itemView.findViewById(R.id.tvRole)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.name.text = "Name : ${user.firstName} ${user.maidenName} ${user.lastName}"
        holder.email.text = "Email : ${user.email}"
        holder.age.text = "Age : ${user.age}"
        holder.phone.text = "Phone : ${user.phone}"
        holder.gender.text = "Gender : ${user.gender}"
        holder.bloodGroup.text = "Blood Group : ${user.bloodGroup}"
        holder.height.text = "Height : ${user.height} cm"
        holder.weight.text = "Weight : ${user.weight} kg"
        holder.username.text = "Username : ${user.username}"
        holder.password.text = "Password : ${user.password}"
         holder.birthdate.text = "BirthDate : ${user.birthDate}"
        holder.bloodgroup.text = "BloodGroup : ${user.bloodGroup}"
        holder.eyeColor.text = "EyeColor : ${user.eyeColor}"
        holder.hair.text = "Hair Color : ${user.hair.color}\nHair Type: ${user.hair.type} "
        holder.address.text = "Address : ${user.address.address},${user.address.city},${user.address.state},${user.address.stateCode},${user.address.postalCode}\nlat : ${user.address.coordinates.lat}\nlng : ${user.address.coordinates.lng}\nCountry : ${user.address.country} "
        holder.ip.text = "IP: ${user.ip}"
        holder.macAddress.text = "MacAddress : ${user.macAddress}"
        holder.university.text = "MacAddress : ${user.university}"
        holder.bank.text = "Bank Details :\nCardExpire : ${user.bank.cardExpire}\nCardNumber : ${user.bank.cardNumber}\nCardType : ${user.bank.cardType}\ncurrency : ${user.bank.currency}\niban : ${user.bank.iban}"
        holder.company.text = "Company Details :\nDepartment : ${user.company.department}\nName : ${user.company.name}\ntitle : ${user.company.title}\nAddress : ${user.company.address.address},${user.company.address.city},${user.company.address.state},${user.company.address.stateCode
        },${user.company.address.postalCode}\nlat : ${user.company.address.coordinates.lat} lng : ${user.company.address.coordinates.lng} Country : ${user.company.address.country} "
        holder.ip.text = "IP: ${user.ip}"
        holder.ein.text = "Ein: ${user.ein}"
        holder.ssn.text = "Ssn: ${user.ssn}"
        holder.userAgent.text = "UserAgent: ${user.userAgent}"
        holder.crypto.text = "Crypto Details:\nCoin : ${user.crypto.coin}\nwallet : ${user.crypto.wallet}\nnetwork : ${user.crypto.network}"
        holder.role.text = "Role: ${user.role}"

        Glide.with(holder.itemView.context).load(user.image).into(holder.image)
    }

    override fun getItemCount(): Int = userList.size

    fun updateList(newList: List<User>) {
        userList = newList
        notifyDataSetChanged()
    }
}