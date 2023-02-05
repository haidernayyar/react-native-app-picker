package com.apppicker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.WritableArray;

import java.util.List;

@ReactModule(name = AppPickerModule.NAME)
public class AppPickerModule extends ReactContextBaseJavaModule {

  public static final String NAME = "AppPicker";
  Context context;

  public AppPickerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.context = reactContext.getApplicationContext();
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void pick(Promise promise) {
    final PackageManager pm = this.context.getPackageManager();

    List<ApplicationInfo> packages = pm.getInstalledApplications(
      PackageManager.GET_META_DATA
    );

    WritableArray packageList = Arguments.createArray();

   for (ApplicationInfo aPackage : packages) {
     packageList.pushString(aPackage.packageName);
   }

    promise.resolve(packageList);
  }
}
