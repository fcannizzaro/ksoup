package com.fcannizzaro.ksoup.sample

import android.app.Activity

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

fun async(run: () -> Unit) = Thread(run).start()

fun Activity.ui(run: () -> Unit) = runOnUiThread(run)
