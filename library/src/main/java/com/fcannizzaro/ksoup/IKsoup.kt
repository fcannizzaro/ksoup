package com.fcannizzaro.ksoup

import org.jsoup.nodes.Element
import kotlin.properties.Delegates

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

open class IKsoup(var query: String = "") {

    var element by Delegates.notNull<Element>()

    open fun afterBind() {
        // called after element is bound.
    }

}

