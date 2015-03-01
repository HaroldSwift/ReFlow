package com.hfatih.reflow.Utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import com.hfatih.reflow.R;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by fatih on 1.3.2015.
 */
public final class SharedPrefsHelper {

    public static enum AppearanceTheme {
        DEFAULT, SOLARIZED_DARK, SOLARIZED_LIGHT, TOMORROW_NIGHT, TOMORROW_NIGHT_EIGHTIES, TOMORROW_NIGHT_BLUE, TOMORROW_NIGHT_BRIGHT
    }

    public static AppearanceTheme appearance_theme(final Context context, final SharedPreferences sharedPreferences) {
        return AppearanceTheme.valueOf(getString(R.string.pref_appearance_theme_key, "red", context, sharedPreferences).toUpperCase());
    }

    public static void applyTheme(Activity activity) {

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);

        final AppearanceTheme theme = appearance_theme(activity, prefs);

        switch(theme) {
            case DEFAULT:
                activity.setTheme(R.style.RF_DEFAULT);
                break;

            case SOLARIZED_DARK:
                activity.setTheme(R.style.RF_SOLARIZED_DARK);
                break;

            case SOLARIZED_LIGHT:
                activity.setTheme(R.style.RF_DEFAULT);
                break;

            case TOMORROW_NIGHT:
                activity.setTheme(R.style.RF_DEFAULT);
                break;

            case TOMORROW_NIGHT_EIGHTIES:
                activity.setTheme(R.style.RF_DEFAULT);
                break;

            case TOMORROW_NIGHT_BLUE:
                activity.setTheme(R.style.RF_DEFAULT);
                break;

            case TOMORROW_NIGHT_BRIGHT:
                activity.setTheme(R.style.RF_DEFAULT);
                break;
        }

        final String lang = getString(R.string.pref_appearance_langforce_key, "auto", activity, prefs);

        final Resources res = activity.getResources();
        final DisplayMetrics dm = res.getDisplayMetrics();
        final android.content.res.Configuration conf = res.getConfiguration();

        if(!lang.equals("auto")) {
            conf.locale = new Locale(lang);
        } else {
            conf.locale = Locale.getDefault();
        }

        res.updateConfiguration(conf, dm);
    }

    private static String getString(final int id, final String defaultValue, final Context context, final SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(context.getString(id), defaultValue);
    }

    public static Set<String> getStringSet(final int id, final int defaultArrayRes, final Context context, final SharedPreferences sharedPreferences) {
        return sharedPreferences.getStringSet(context.getString(id), setFromArray(context.getResources().getStringArray(defaultArrayRes)));
    }

    private static boolean getBoolean(final int id, final boolean defaultValue, final Context context, final SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(context.getString(id), defaultValue);
    }

    private static long getLong(final int id, final long defaultValue, final Context context, final SharedPreferences sharedPreferences) {
        return sharedPreferences.getLong(context.getString(id), defaultValue);
    }

    private static <E> Set<E> setFromArray(E[] data) {
        final HashSet<E> result = new HashSet<E>(data.length);
        Collections.addAll(result, data);
        return result;
    }

}
