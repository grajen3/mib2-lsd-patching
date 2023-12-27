/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import java.lang.reflect.Array;

public class Converter {
    private static final String SEPARATOR;
    private static final String NULL;

    public static String array2String(Object object) {
        if (object == null) {
            return "null";
        }
        Converter.checkObjectIsArray(object);
        Buffer buffer = new Buffer().append('[');
        int n = Array.getLength(object);
        for (int i2 = 0; i2 < n; ++i2) {
            Object object2 = Array.get(object, i2);
            if (Converter.isNonNullArray(object2)) {
                buffer.append(Converter.array2String(object2));
            } else {
                buffer.append(object2);
            }
            if (Converter.isLastItem(i2, n)) continue;
            buffer.append(", ");
        }
        buffer.append(']');
        return buffer.toString();
    }

    public static String intArrayToString(int[] nArray) {
        Buffer buffer = new Buffer();
        Formatter.formatIntArray(buffer, nArray);
        return buffer.toString();
    }

    public static String objectToString(Object object) {
        Buffer buffer = new Buffer();
        Formatter.formatObject(buffer, object);
        return buffer.toString();
    }

    public static String timestampToString(long l) {
        Buffer buffer = new Buffer();
        Formatter.formatTimestamp(buffer, l);
        return buffer.toString();
    }

    private static void checkObjectIsArray(Object object) {
        if (!object.getClass().isArray()) {
            throw new IllegalArgumentException("Object is not an array.");
        }
    }

    private static boolean isNonNullArray(Object object) {
        return object != null && object.getClass().isArray();
    }

    private static boolean isLastItem(int n, int n2) {
        return n == n2 - 1;
    }
}

