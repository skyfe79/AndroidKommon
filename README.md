# AndroidKommon

Collection of Android utility extentions in Kotlin

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
compile 'kr.pe.burt.android.lib:fragmentnavigationcontroller:0.0.1'
compile 'kr.pe.burt.android.lib:androidactivity:0.0.3'
compile 'kr.pe.burt.android.lib:androidchannel:0.0.4'
compile 'kr.pe.burt.android.lib:androidoperationqueue:0.0.2'
compile 'com.trello:rxlifecycle:0.6.1'
```