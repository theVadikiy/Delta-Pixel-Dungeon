# Implementation Plan - Fix Gradle Sync Error "Value is null"

The user is experiencing a Gradle sync error in `android/build.gradle` at line 17. The error "Value is null" is caused by an incorrect property access: `subprojects.appPackageName`.

## Proposed Changes

### [android](file:///C:/Users/Вадим/StudioProjects/Delta-Pixel-Dungeon/android)

#### [MODIFY] [build.gradle](file:///C:/Users/Вадим/StudioProjects/Delta-Pixel-Dungeon/android/build.gradle)
- Change `applicationId subprojects.appPackageName` to `applicationId appPackageName`.
- The `appPackageName` property is defined in the root `build.gradle` within an `allprojects { ext { ... } }` block, making it available to all subprojects directly. Using `subprojects.` prefix is incorrect as `subprojects` is a collection of projects.

## Verification Plan

### Automated Tests
- Run Gradle Sync to ensure the project evaluates correctly.
- Run `gradle :android:assembleDebug` to verify the build process.

### Manual Verification
- None required beyond ensuring successful sync.
