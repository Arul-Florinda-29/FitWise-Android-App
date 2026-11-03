# FitWise Android project (starter conversion)

This is a separate native Android Java project scaffold based on the uploaded FitWise desktop ZIP. The original desktop source is preserved in `original-desktop-project/`.

## Build without Android Studio
1. Upload the contents of this folder to the root of a new GitHub repository (or a separate branch/repository).
2. Open **Actions**.
3. Select **Build FitWise Android APK**.
4. Click **Run workflow**.
5. When successful, open the run and download the `FitWise-debug-apk` artifact.
6. Extract the artifact and install `app-debug.apk` on your Android phone. You may need to allow installation from your browser/files app.

## Current implementation
- Native Android Java Activity; no WebView.
- Local SQLite registration/login and profile storage.
- Email format and minimum 8-character password checks; duplicate email rejection.
- User-selected fitness goal (not automatically assigned from BMI).
- BMI, BMR, TDEE and calorie estimates.
- Basic diet/workout guidance, water/sleep/steps entry, progress overview and Smart Coach guidance.
- Daily tracker records stored locally.

## Important limitations — read before presenting as complete
This is a **starter Android conversion**, not a feature-for-feature completed port of the desktop app. The original project is preserved for reference, but its Swing panels cannot run on Android. The Android UI currently does not yet port the desktop adaptive learning engine, full food/exercise libraries, calendar, challenges, notifications, historical charts, allergies/preferences filtering, or REST backend synchronization. Passwords in this starter's local SQLite prototype are not securely hashed and this must be fixed before real-world deployment. The local SQLite login is for development demonstration only. No APK build was executed in this environment; use the GitHub Actions workflow to test the build and inspect its result.

## Project layout
- `app/` — Android application source and resources.
- `.github/workflows/build-apk.yml` — GitHub Actions APK build.
- `original-desktop-project/` — original uploaded Java Swing project, unchanged.
