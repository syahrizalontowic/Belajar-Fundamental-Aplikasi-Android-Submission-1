package com.syahrizal.githubuserone

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataLocation: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener =
                AdapterView.OnItemClickListener { _, _, position, _ ->
                    val moveUser = User(
                            users[position].avatar,
                            users[position].username,
                            users[position].name,
                            users[position].company,
                            users[position].location,
                            users[position].repository,
                            users[position].follower,
                            users[position].following
                    )

                    val moveIntentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                    moveIntentToDetail.putExtra(DetailActivity.DETAIL_USER, moveUser)
                    startActivity(moveIntentToDetail)
                }
    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.data_username)
        dataName = resources.getStringArray(R.array.data_name)
        dataAvatar = resources.obtainTypedArray(R.array.data_avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataUsername.indices) {
            val user = User(
                    dataAvatar.getResourceId(position, -1),
                    dataUsername[position],
                    dataName[position],
                    dataCompany[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataFollower[position],
                    dataFollowing[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}
