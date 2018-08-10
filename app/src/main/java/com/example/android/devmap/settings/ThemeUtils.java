package com.example.android.devmap.settings;

import android.app.Activity;

import com.example.android.devmap.R;

public class ThemeUtils {

    // Should take the strings to compare from the string resource files - change
    public static void changeTheme(Activity a, String s) {
        if (s.equals("dark")) {
            a.setTheme(R.style.DarkTheme);
        } else if (s.equals("light")) {
            a.setTheme(R.style.LightTheme);
        }
    }

}
