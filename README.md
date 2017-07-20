# KidsPOS4j
kidspos4j

# Use
root/build.gradle
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

root/app/build.gradle
```
dependencies {
  compile 'com.github.KidsPOSProject:KidsPOS4j:$latest_version'
}
```
