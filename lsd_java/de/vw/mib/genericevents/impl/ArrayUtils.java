/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import java.lang.reflect.Array;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static String asString(Object object) {
        if (object == null) {
            return "null";
        }
        if (!object.getClass().isArray()) {
            throw new IllegalArgumentException("Parameter is not an array.");
        }
        int n = Array.getLength(object);
        if (n == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        ArrayUtils.appendItem(stringBuffer, object, 0);
        for (int i2 = 1; i2 < n; ++i2) {
            stringBuffer.append(", ");
            ArrayUtils.appendItem(stringBuffer, object, i2);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private static void appendItem(StringBuffer stringBuffer, Object object, int n) {
        Object object2 = Array.get(object, n);
        if (object2 != null && object2.getClass().isArray()) {
            stringBuffer.append(ArrayUtils.asString(object2));
        } else {
            stringBuffer.append(object2);
        }
    }
}

