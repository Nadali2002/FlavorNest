# My Food App (FlavorNest) 🍕

A modern Android food ordering application built with Kotlin, featuring a beautiful UI and seamless user experience for browsing and ordering food items.

## 📱 Features

### Authentication & Onboarding
- **Logo Screen** - Splash screen with app branding
- **Onboarding Screens** - Three-step introduction to the app
- **User Registration** - Create new account with full name, email, and password
- **Login** - Secure user authentication
- **Forgot Password** - Password recovery functionality
- **Welcome Screen** - Entry point for new users

### Main Features
- **Home Screen** - Browse food items with horizontal and vertical scrolling
  - Food categories display
  - Product images, names, ratings, and prices
  - Operating hours display
- **Daily Meal** - Special meal offers and promotions
- **Shopping Cart** - Add items to cart and manage orders
  - View cart items
  - Calculate total price
  - Place orders
- **Navigation Drawer** - Easy navigation between sections
- **Logout** - Secure session termination

## 🛠️ Technology Stack

- **Language**: Kotlin
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 36
- **Build System**: Gradle with Kotlin DSL
- **Architecture**: MVVM (Model-View-ViewModel)

### Key Libraries & Dependencies

- **AndroidX Core KTX** - Kotlin extensions for Android
- **Material Design Components** - Modern UI components
- **Navigation Component** - Fragment navigation
- **Lifecycle Components** - ViewModel and LiveData
- **Constraint Layout** - Flexible layout system
- **Rounded ImageView** - Custom image views with rounded corners
- **View Binding** - Type-safe view references

## 📁 Project Structure

```
MyFoodApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/myfoodapp/
│   │   │   │   ├── activities/          # Activity classes
│   │   │   │   │   ├── LogoScreenActivity.kt
│   │   │   │   │   ├── OnboardingScreenActivity1.kt
│   │   │   │   │   ├── OnboardingScreenActivity2.kt
│   │   │   │   │   ├── OnboardingScreenActivity3.kt
│   │   │   │   │   ├── WelcomeActivity.kt
│   │   │   │   │   ├── LoginActivity.kt
│   │   │   │   │   ├── RegistrationActivity.kt
│   │   │   │   │   ├── ForgotPasswordActivity.kt
│   │   │   │   │   └── DetailedDailyMealActivity.kt
│   │   │   │   ├── adapters/            # RecyclerView adapters
│   │   │   │   │   ├── CartAdapter.kt
│   │   │   │   │   ├── DailyMealAdapter.kt
│   │   │   │   │   ├── HomeHorAdapter.kt
│   │   │   │   │   ├── HomeVerAdapter.kt
│   │   │   │   │   └── UpdateVerticalRec.kt
│   │   │   │   ├── models/              # Data models
│   │   │   │   │   ├── CartModel.kt
│   │   │   │   │   ├── DailyMealModel.kt
│   │   │   │   │   ├── HomeHorModel.kt
│   │   │   │   │   └── HomeVerModel.kt
│   │   │   │   ├── ui/                  # UI fragments
│   │   │   │   │   ├── home/
│   │   │   │   │   │   └── HomeFragment.kt
│   │   │   │   │   ├── dailymeal/
│   │   │   │   │   │   └── DailyMealFragment.kt
│   │   │   │   │   └── MyCartFragment.kt
│   │   │   │   └── MainActivity.kt      # Main activity
│   │   │   ├── res/                     # Resources
│   │   │   │   ├── layout/              # XML layouts
│   │   │   │   ├── drawable/            # Images and drawables
│   │   │   │   ├── values/              # Strings, colors, themes
│   │   │   │   └── navigation/          # Navigation graphs
│   │   │   └── AndroidManifest.xml
│   │   └── test/                        # Unit tests
│   └── build.gradle.kts                 # App-level build config
├── build.gradle.kts                     # Project-level build config
├── gradle/
│   └── libs.versions.toml               # Dependency versions
└── settings.gradle.kts                  # Project settings
```

## 🚀 Getting Started

### Prerequisites

- **Android Studio** - Hedgehog (2023.1.1) or later
- **JDK 11** or higher
- **Android SDK** - API level 24 or higher
- **Gradle** - 8.12.1 or compatible version

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd MyFoodApp
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the project directory

3. **Sync Gradle**
   - Android Studio will automatically sync Gradle dependencies
   - If not, click "Sync Now" when prompted

4. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`
   - Select your target device

### Building the APK

#### Debug APK
```bash
./gradlew assembleDebug
```
The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

#### Release APK
```bash
./gradlew assembleRelease
```
The APK will be generated at: `app/build/outputs/apk/release/app-release.apk`

## 📱 Screenshots

The app includes the following screens:
- Logo/Splash Screen
- Onboarding Screens (3 steps)
- Welcome Screen
- Login Screen
- Registration Screen
- Forgot Password Screen
- Home Screen with food items
- Daily Meal Screen
- Shopping Cart Screen
- Detailed Meal View

## 🎨 UI/UX Features

- **Material Design** - Follows Google's Material Design guidelines
- **Dark Theme Support** - Includes night mode resources
- **Responsive Layouts** - Supports different screen sizes (w600dp, w1240dp)
- **Landscape Support** - Optimized layouts for landscape orientation
- **Custom Fonts** - Preloaded custom fonts for better typography
- **Rounded Images** - Beautiful rounded image views for food items

## 🔧 Configuration

### Version Information
- **Version Code**: 1
- **Version Name**: 1.0
- **Package Name**: com.example.myfoodapp

### Build Configuration
- **Compile SDK**: 36
- **Min SDK**: 24
- **Target SDK**: 36
- **Java Version**: 11

## 📝 Code Style

- Follows Kotlin coding conventions
- Uses View Binding for type-safe view access
- Implements MVVM architecture pattern
- Uses data classes for models
- Follows Android best practices

## 🧪 Testing

The project includes test directories:
- **Unit Tests**: `app/src/test/java/`
- **Instrumented Tests**: `app/src/androidTest/java/`

Run tests using:
```bash
./gradlew test          # Unit tests
./gradlew connectedAndroidTest  # Instrumented tests
```

## 📦 Dependencies

All dependencies are managed through `gradle/libs.versions.toml`:

- AndroidX Core KTX: 1.16.0
- AndroidX AppCompat: 1.7.1
- Material Design: 1.12.0
- Constraint Layout: 2.2.1
- Lifecycle Components: 2.6.1
- Navigation Component: 2.6.0
- Activity: 1.10.1
- Rounded ImageView: 2.3.0

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.





## 🔮 Future Enhancements

Potential features for future versions:
- Backend integration for real-time data
- Payment gateway integration
- Order tracking
- Push notifications
- User profile management
- Favorites/Wishlist functionality
- Search functionality
- Reviews and ratings system



For issues, questions, or suggestions, please open an issue in the repository.

---

**Note**: This is a demo/learning project. For production use, ensure proper security measures, backend integration, and comprehensive testing.
