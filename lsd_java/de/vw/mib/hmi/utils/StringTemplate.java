/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.util.StringBuilder;

public class StringTemplate {
    public static String format(String string, Object[] objectArray) {
        Preconditions.checkNotNull(string, "template");
        Preconditions.checkNotNull(objectArray, "args");
        StringBuilder stringBuilder = new StringBuilder(string.length() + 16 * objectArray.length);
        int n = StringTemplate.substitutePlaceholders(stringBuilder, string, objectArray);
        StringTemplate.appendRemainingArgs(stringBuilder, objectArray, n);
        return stringBuilder.toString();
    }

    private static int substitutePlaceholders(StringBuilder stringBuilder, String string, Object[] objectArray) {
        int n;
        int n2 = 0;
        int n3 = 0;
        while (n3 < objectArray.length && (n = string.indexOf("%s", n2)) != -1) {
            stringBuilder.append(string.substring(n2, n));
            stringBuilder.append(objectArray[n3++]);
            n2 = n + 2;
        }
        stringBuilder.append(string.substring(n2));
        return n3;
    }

    private static void appendRemainingArgs(StringBuilder stringBuilder, Object[] objectArray, int n) {
        if (n < objectArray.length) {
            stringBuilder.append(" [");
            stringBuilder.append(objectArray[n++]);
            while (n < objectArray.length) {
                stringBuilder.append(", ");
                stringBuilder.append(objectArray[n++]);
            }
            stringBuilder.append(']');
        }
    }
}

