package namtran.util;

import android.text.TextUtils;

import java.util.List;

public final class Checker {

    private Checker() {
    }

    public static String safeString(String value) {
        return TextUtils.isEmpty(value) ? Constant.EMPTY : value;
    }

    public static String getTrimmed(String value) {
        return safeString(value).trim();
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
