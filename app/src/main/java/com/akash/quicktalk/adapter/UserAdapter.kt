package com.akash.quicktalk.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akash.quicktalk.ChatActivity
import com.akash.quicktalk.R
import com.akash.quicktalk.databinding.ItemProfileBinding
import com.akash.quicktalk.model.User
import com.squareup.picasso.Picasso

class UserAdapter (var context: Context, var userList:ArrayList<User>):
RecyclerView.Adapter<UserAdapter.UserViewHolder>()

{
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding : ItemProfileBinding = ItemProfileBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_profile,
        parent,false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.username.text = user.name

        Picasso.get()
            .load(user.profileImage)
            .placeholder(R.drawable.user_profile)
            .error(R.drawable.ic_error)
            .into(holder.binding.profile)

        holder.itemView.setOnClickListener{
                val intent = Intent(context, ChatActivity::class.java)
                intent.putExtra("name",user.name)
                intent.putExtra("image",user.profileImage)
                intent.putExtra("uid",user.uid)
                context.startActivity(intent)
            }


    }

    override fun getItemCount(): Int = userList.size
}