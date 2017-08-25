package com.fcannizzaro.ksoup.sample.model

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.delegates.bindList
import com.fcannizzaro.ksoup.delegates.bindText
import com.fcannizzaro.ksoup.sample.model.Package

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class NPM : IKsoup() {

    val title by bindText("head > title")

    val packages: List<Package> by bindList(Package())

}