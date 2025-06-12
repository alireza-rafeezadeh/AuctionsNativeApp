# Auctions Native App

This is a Kotlin Multiplatform (KMP) project targeting **Android** and **iOS** showing a list of auctions and their details.

---

## ✨ Tech Stack

### ✅ Shared (KMP)

- [**Ktor**](https://ktor.io/): HTTP client for networking across platforms.
- [**kotlinx.serialization**](https://github.com/Kotlin/kotlinx.serialization): For parsing and generating JSON.
- [**Koin**](https://github.com/InsertKoinIO/koin): Dependency injection made easy and multiplatform.
- [**KMP-ObservableViewModel**](https://github.com/rickclephas/KMP-ObservableViewModel): Shared ViewModel architecture usable with SwiftUI and Jetpack Compose.
- [**KMP-NativeCoroutines**](https://github.com/rickclephas/KMP-NativeCoroutines): Enables Swift concurrency support for Kotlin coroutines.

---

### 📱 Android

- [**Jetpack Compose**](https://developer.android.com/jetpack/compose): Modern declarative UI toolkit for Android.
- [**Navigation component**](https://developer.android.com/jetpack/compose/navigation): Declarative navigation in Jetpack Compose.
- [**Coil**](https://github.com/coil-kt/coil): Image loading library optimized for Android and Jetpack Compose.

---

### 🍏 iOS

- [**Kingfisher**](https://github.com/onevcat/Kingfisher): Swift library for downloading and caching images in iOS.

---

## 🔐 API Key Configuration

To run the app, make sure to add your `AUCTIONS_API_KEY`:

- **Android**: Add to your `local.properties` file:
  ```properties
  AUCTIONS_API_KEY=your_api_key_here
- **iOS**: Add a line in `info.plist`:
  ```properties
  <key>AUCTIONS_API_KEY</key>
  <string>your_api_key_here</string>
  