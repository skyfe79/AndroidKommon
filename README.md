# AndroidKommon

Collection of Android utility extentions in Kotlin

## Setup Gradle

```groovy
repositories {

	maven { url 'https://dl.bintray.com/skyfe79/maven/' }
	
}

dependencies {


}
```


## RxComponents

 * RxAndroidActivity
 * RxAndroidAppCompatActivity
 * RxAndroidFragment

## DelegateExts

### notNullSingleValue

```kotlin
class AndroidApp : Application() {

    companion object {
        private var instance: AndroidApp by DelegateExts.notNullSingleValue()
        fun sharedInstance() = instance
    }
}
```

## AndroidVersion

```kotlin
if(AndroidVersion.current() >= AndroidVersion.lollipop()) {
	println(1) 
} else {
	println(2)
}
```
## Dependency moduls

```
compile 'com.github.medyo:dynamicbox:1.2@aar'
compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
compile 'com.trello:rxlifecycle:0.6.1'
compile 'com.trello:rxlifecycle-components:0.6.1'
```
