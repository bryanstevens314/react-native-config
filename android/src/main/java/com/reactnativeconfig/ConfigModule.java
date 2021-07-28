package com.reactnativeconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = ConfigModule.NAME)
public class ConfigModule extends ReactContextBaseJavaModule {
    private Class buildConfigClass;
    public static final String NAME = "RNConfig";

    public ConfigModule(ReactApplicationContext reactContext, Class buildConfigClass) {
        super(reactContext);
      this.buildConfigClass = buildConfigClass;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
      final Map<String, Object> constants = new HashMap<>();
      Field[] fields = buildConfigClass.getDeclaredFields();
      for (Field f : fields) {
        try {
          constants.put(f.getName(), f.get(null));
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
      return constants;
    }
}
