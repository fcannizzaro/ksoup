package com.fcannizzaro.ksoup.sample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.fcannizzaro.ksoup.Ksoup
import com.fcannizzaro.ksoup.ksoup.sample.R
import com.fcannizzaro.ksoup.sample.model.NPM
import com.fcannizzaro.ksoup.sample.model.Package
import com.squareup.picasso.Picasso
import net.idik.lib.slimadapter.SlimAdapter
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {

    private val list by lazy { findViewById<RecyclerView>(R.id.list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager = LinearLayoutManager(this)

        async {

            val document = Jsoup.connect("https://www.npmjs.com/").get()
            val ksoup = Ksoup(document.body())

            val npm: NPM = ksoup.from(NPM())

            // or
            // val packages = ksoup.fromList<Package>(Package())

            ui {
                title = npm.title
                populate(npm.packages)
            }

        }
    }

    private fun populate(packages: List<Package>) {
        SlimAdapter
                .create()
                .updateData(packages)
                .register<Package>(R.layout.item_package) { data, inj ->
                    inj.text(R.id.name, data.name)
                    inj.text(R.id.description, data.description)
                    inj.text(R.id.version, data.info.version)
                    inj.text(R.id.author, data.info.author)
                    inj.with<ImageView>(R.id.icon) {
                        Picasso
                                .with(this)
                                .load(data.icon)
                                .noFade()
                                .placeholder(R.drawable.box)
                                .error(R.drawable.box)
                                .into(it)
                    }
                    inj.clicked(R.id.item, {
                        startActivity(
                                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.npmjs.com${data.link}"))
                        )
                    })
                }
                .attachTo(list)
    }

}
