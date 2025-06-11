/**
 * ──────────────────────────────────────────────────────────────────────────────
 *  IMPORTANT SETUP NOTICE FOR HEALTH CONNECT PERMISSIONS RATIONALE ACTIVITY
 * ──────────────────────────────────────────────────────────────────────────────
 *
 * This `PermissionsRationaleActivity` class must be copied into your **end-user app**
 * (typically at: `android/app/src/main/java/<your-app-package>/PermissionsRationaleActivity.kt`)
 * and registered in your app's `AndroidManifest.xml`.
 *
 * WHY THIS IS NECESSARY:
 * Health Connect requires this Activity to be declared in the final **merged manifest**.
 * Android will not recognize it if it's only inside a Capacitor plugin or library module.
 * If this class is not present in the main app project, the following issues will occur:
 *
 *   - `Health Connect rationale screen not found` warnings
 *   - The Health Connect permissions dialog may silently fail to appear
 *   - Permissions will never be granted, breaking health data access on Android
 *
 * ──────────────────────────────────────────────────────────────────────────────
 * TO FIX:
 * 1. Copy this file to your app's native Android directory.
 * 2. Add the `<activity>` and `<activity-alias>` declarations for this class
 *    into your AndroidManifest.xml file (in the app module). --> You can find an example manifest block in the plugin README.
 * 3. Rebuild and re-deploy your app.
 *
 */

package com.[YOUR_ORGANIZATION].[YOUR_APP...]

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class PermissionsRationaleActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val webView = WebView(this).apply {
      webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, request: android.webkit.WebResourceRequest) = false
      }
      loadUrl("https://flomentumsolutions.com/privacy-policy") // Replace with relevant URL
    }
    setContentView(webView)
  }
}