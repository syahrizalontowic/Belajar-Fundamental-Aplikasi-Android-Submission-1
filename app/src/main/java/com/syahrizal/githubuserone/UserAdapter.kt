package com.syahrizal.githubuserone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var users = arrayListOf<User>()

    override fun getCount(): Int = users.size

    override fun getItem(i: Int): Any = users[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {

            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        private val txtUsername: TextView = view.findViewById(R.id.txt_name)
        private val txtName: TextView = view.findViewById(R.id.txt_description)
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(user: User) {
            txtUsername.text = user.username
            txtName.text = user.name
            imgAvatar.setImageResource(user.avatar)
        }
    }
}
