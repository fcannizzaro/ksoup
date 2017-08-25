package com.fcannizzaro.ksoup.sample.model

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.delegates.bindClass
import com.fcannizzaro.ksoup.delegates.bindImage
import com.fcannizzaro.ksoup.delegates.bindLink
import com.fcannizzaro.ksoup.delegates.bindText

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class Package : IKsoup(".marginalia-container:has(img)") {

    class Info : IKsoup(".type-sm") {

        val version by bindText("a[href*='package']")

        val author by bindText("a[href*='~']")

    }

    val name by bindText("h3")

    val link by bindLink("h3 a")

    val description by bindText("p.type-ellipsis")

    val icon by bindImage("img.mts")

    val info: Info by bindClass(Info(), this)

}