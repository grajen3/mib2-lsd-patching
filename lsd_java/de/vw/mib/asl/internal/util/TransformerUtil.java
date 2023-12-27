/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.util;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.properties.values.FixFormatterFieldData;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public final class TransformerUtil {
    private static final String EMPTY_ARRAY_STRING;
    private static final String EMPTY_MAP_STRING;
    private static final String NULL_STRING;
    private static final String DEPRECATED_MARK;

    private TransformerUtil() {
    }

    public static String arrayToString(Object object) {
        if (null == object) {
            return NULL_STRING;
        }
        int n = Array.getLength(object);
        if (0 == n) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (int i2 = 0; i2 < n - 1; ++i2) {
            stringBuffer.append(Array.get(object, i2)).append(", ");
        }
        stringBuffer.append(Array.get(object, n - 1)).append(']');
        return stringBuffer.toString();
    }

    public static String fixFormatterFieldDataToString(FixFormatterFieldData fixFormatterFieldData) {
        if (null == fixFormatterFieldData) {
            return NULL_STRING;
        }
        Set set = fixFormatterFieldData.keySet();
        if (0 == set.size()) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        boolean bl = true;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            if (!bl) {
                stringBuffer.append(", ");
            } else {
                bl = false;
            }
            String string = (String)iterator.next();
            String string2 = fixFormatterFieldData.getString(string);
            stringBuffer.append(string).append('=').append(string2);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public static String getIntAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = String.valueOf(itemTransformer.getInt(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedIntAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(String.valueOf(itemTransformer.getInt(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getStringAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = String.valueOf(itemTransformer.getString(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedStringAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(String.valueOf(itemTransformer.getString(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getBooleanAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = String.valueOf(itemTransformer.getBoolean(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedBooleanAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(String.valueOf(itemTransformer.getBoolean(n, object))).append("{@deprecated}").toString();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getFlagVectorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = TransformerUtil.arrayToString(itemTransformer.getFlagVector(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedFlagVectorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(TransformerUtil.arrayToString(itemTransformer.getFlagVector(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getIntegerVectorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = TransformerUtil.arrayToString(itemTransformer.getIntegerVector(n, object));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = TransformerUtil.formatException(illegalArgumentException);
        }
        return string;
    }

    public static String getDeprecatedIntegerVectorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(TransformerUtil.arrayToString(itemTransformer.getIntegerVector(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getStringVectorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = TransformerUtil.arrayToString(itemTransformer.getStringVector(n, object));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = TransformerUtil.formatException(illegalArgumentException);
        }
        return string;
    }

    public static String getDeprecatedStringVectorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(TransformerUtil.arrayToString(itemTransformer.getStringVector(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getResourceLocatorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = String.valueOf(itemTransformer.getResourceLocator(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedResourceLocatorAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(String.valueOf(itemTransformer.getResourceLocator(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getLongAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = String.valueOf(itemTransformer.getLong(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedLongAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(String.valueOf(itemTransformer.getLong(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getLabeledIconValueAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = String.valueOf(itemTransformer.getLabeledIconValue(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedLabeledIconValueAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(String.valueOf(itemTransformer.getLabeledIconValue(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    public static String getFixFormatterFieldDataAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = TransformerUtil.fixFormatterFieldDataToString(itemTransformer.getFixFormatterFieldData(n, object));
        }
        catch (Exception exception) {
            string = TransformerUtil.formatException(exception);
        }
        return string;
    }

    public static String getDeprecatedFixFormatterFieldDataAsString(ItemTransformer itemTransformer, int n, Object object) {
        String string;
        try {
            string = new StringBuffer().append(TransformerUtil.fixFormatterFieldDataToString(itemTransformer.getFixFormatterFieldData(n, object))).append("{@deprecated}").toString();
        }
        catch (Exception exception) {
            string = "{@deprecated}";
        }
        return string;
    }

    private static String formatException(Exception exception) {
        return new StringBuffer().append("{@exception: ").append(String.valueOf(exception)).append("}").toString();
    }

    static {
        NULL_STRING = String.valueOf((Object)null);
    }
}

