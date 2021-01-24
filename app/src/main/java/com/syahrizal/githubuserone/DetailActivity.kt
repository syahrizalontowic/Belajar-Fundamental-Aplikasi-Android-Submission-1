package com.syahrizal.githubuserone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_USER = "detail_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val users = intent.getParcelableExtra<User>(DETAIL_USER) as User

        detailAvatar.setImageResource(users.avatar)
        detailName.text = users.name.toString()
        detailUsername.text = "@${users.username.toString()}"
        detailCompany.text =  "Company : ${users.company.toString()}"
        location.text = "${users.location.toString()}"
        bt1.text = """
            ${users.repository.toString()}
            Repository
        """.trimIndent()
        bt2.text = """
            ${users.follower.toString()} 
            Follower
        """.trimIndent()
        bt3.text = """
            ${users.following.toString()} 
            Following
        """.trimIndent()
    }
}
