# Implementation Plan - Fix Gradle Sync Error "Value is null"

The user is experiencing a Gradle sync error in `android/build.gradle` at line 17. The error `Value is null` is caused by an incorrect attempt to access the `appPackageName` property via `subprojects`.

## Proposed Changes

### Android Module

#### [MODIFY] [android/build.gradle](file:///C:/Users/Вадим/StudioProjects/Delta-Pixel-Dungeon/android/build.gradle)

- Change `applicationId subprojects.appPackageName` to `applicationId appPackageName`.
- The `appPackageName` property is defined in the root `build.gradle` within an `allprojects { ext { ... } }` block, making it directly accessible to all subprojects.

## Verification Plan

### Automated Tests
- Run Gradle sync to ensure the error is resolved.
- Run `./gradlew :android:assembleDebug` to verify the project builds correctly.
