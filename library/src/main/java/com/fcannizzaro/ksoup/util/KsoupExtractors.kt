@file:Suppress("UNCHECKED_CAST")

package com.fcannizzaro.ksoup.util

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.Ksoup
import com.fcannizzaro.ksoup.first
import com.fcannizzaro.ksoup.trim
import org.jsoup.nodes.Element

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

fun extractAttr(element: Element, query: String, attr: String, trim: Boolean = true): String? {
    element.first(query)?.let {
        return it.attr(attr).trim(trim)
    }
    return null
}

fun extractText(element: Element, query: String, trim: Boolean = true): String? {
    element.first(query)?.let {
        return it.text().trim(trim)
    }
    return null
}

fun <T> extractList(element: Element, clazz: IKsoup): List<T> {

    val list = mutableListOf<T>()

    element.select(clazz.query).forEach {
        val instance = clazz.javaClass.newInstance()
        Ksoup(it).from<T>(instance)
        list.add(instance as T)
    }

    return list

}

fun extractImage(element: Element, query: String, trim: Boolean): String? {
    return extractAttr(element, query, "src", trim)
}

fun extractLink(element: Element, query: String, trim: Boolean): String? {
    return extractAttr(element, query, "href", trim)
}