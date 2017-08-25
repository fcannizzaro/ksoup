# ksoup
Kotlin Wrapper for **Jsoup** using Pojo and Delegated Properties

[![](https://jitpack.io/v/fcannizzaro/jsoup-annotations.svg)](https://jitpack.io/#fcannizzaro/ksoup)
[![Build Status](https://travis-ci.org/fcannizzaro/jsoup-annotations.svg?branch=master)](https://travis-ci.org/fcannizzaro/ksoup)
<!--[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-jsoup--annotations-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5713)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/32be39d73dea47fda520b7fa1814f33d)](https://www.codacy.com/app/francisthemoderator/jsoup-annotations?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=fcannizzaro/jsoup-annotations&amp;utm_campaign=Badge_Grade)-->

![](https://raw.githubusercontent.com/fcannizzaro/ksoup/master/icon.png)

# Gradle Dependency

## Step 1.
Add the JitPack repository to your build file
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

## Step 2.
Add the dependency
```gradle
dependencies {
  compile 'com.github.fcannizzaro:ksoup:1.0.0'
}
```

# Usage

```kotlin

val html = Jsoup.connect("https://www.npmjs.com/").get()
val ksoup = Ksoup(html)

/*
*  Scrape!
*/

val npm : NPM = ksoup.from(html, NPM())

// or

val packages: List<Package> = ksoup.fromList(html, Package())

```

See [Sample Code](https://github.com/fcannizzaro/ksoup/tree/master/app/src/main/java/com/fcannizzaro/ksoup/sample)

# POJO Model

## IKsoup([query: String])

### afterBind
method called after object binding is completed.

```kotlin
class Package : IKsoup(".item") {

  // properties

  override fun afterBind() {
    // called after object binding is completed.
  }

}
```

# Delegated Methods

**trim** param is always **true**

## bindText(query: String, [trim: Boolean]) : String?
```kotlin
val title by bindText("head > title")
```

## bindImage(query: String, [trim: Boolean]) : String?
```kotlin
val image by bindImage(".icon")
```

## bindLink(query: String, [trim: Boolean]) : String?
```kotlin
val link by bindLink("a")
```

## bindAttr(query: String, attr: String | KAttr, [trim: Boolean]) : String?
```kotlin
val checked by bindAttr("form > checkbox", KAttr.checked)
```

## <T> bindList(clazz: IKsoup) : List<T>
```kotlin
val items : List<Package> by bindList(Package())
```

## <T> bindClass(clazz: IKsoup, parent: IKsoup) : T
```kotlin
class Package : IKsoup(".item") {

  class Info : IKsoup(".subitem") {
    // Info properties
  }

  // Package properties

  val info: Info by bindClass(Info(), this)

}
```

# Author
Francesco Saverio Cannizzaro (**fcannizzaro**)

# License
```
Copyright 2017 Francesco Saverio Cannizzaro

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
