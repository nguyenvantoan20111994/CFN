package framgia.vn.cfn;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by toannguyen201194 on 02/11/2016.
 */
class SettingUtils implements Contanst {
    public static String getLanguage() {
        return SpManager.getInstance().getString(CONFIG_LANG, LANG_EN);
    }

    public static void setLanguage(String language) {
        SpManager.getInstance().putString(CONFIG_LANG, language);
    }

    static void setLocale(String lang, Resources resources) {
        Locale myLocale = new Locale(lang);
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration conf = resources.getConfiguration();
        conf.locale = myLocale;
        resources.updateConfiguration(conf, dm);
    }
}
