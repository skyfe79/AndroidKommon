# AndroidKommon

Collection of Android utility extentions in Kotlin

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
