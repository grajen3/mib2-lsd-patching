/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.util;

import java.util.Vector;

public final class LogUtil {
    private static final String CHARS;

    private LogUtil() {
    }

    public static String toString(byte[] byArray) {
        return LogUtil.toString(byArray, -129, false);
    }

    public static String toString(byte[] byArray, int n, boolean bl) {
        int n2 = 0;
        if (byArray != null && byArray.length > 0) {
            String string;
            StringBuffer stringBuffer = new StringBuffer(byArray.length * 2 + 20);
            if (bl) {
                stringBuffer.append("len=");
                stringBuffer.append(byArray.length);
                stringBuffer.append(": ");
            }
            while (n2 < byArray.length) {
                if (n2 > 0) {
                    stringBuffer.append(" ");
                }
                LogUtil.byteToString(stringBuffer, byArray[n2]);
                ++n2;
                if (stringBuffer.length() < n) continue;
            }
            if ((string = stringBuffer.toString()).length() > n) {
                return string.substring(0, n);
            }
            return string;
        }
        return "";
    }

    public static String[] toStringArray(byte[] byArray, int n, int n2) {
        int n3 = 0;
        if (byArray != null && byArray.length > 0 && n2 > 0 && n > 0) {
            Vector vector = new Vector(byArray.length / n2 + 1);
            StringBuffer stringBuffer = new StringBuffer(n2 * 3 + 2);
            while (n3 < byArray.length) {
                for (int i2 = 0; n3 < byArray.length && i2 < n2; ++i2) {
                    if (i2 > 0) {
                        stringBuffer.append(" ");
                        if (i2 % 5 == 0) {
                            stringBuffer.append("- ");
                        }
                    }
                    LogUtil.byteToString(stringBuffer, byArray[n3]);
                    if (++n3 < n) continue;
                }
                vector.add(stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
            }
            Object[] objectArray = new String[vector.size()];
            vector.toArray(objectArray);
            return objectArray;
        }
        return new String[0];
    }

    public static void byteToString(StringBuffer stringBuffer, byte by) {
        byte by2 = 0;
        by2 = (byte)(by & 0xF0);
        by2 = (byte)(by2 >>> 4);
        by2 = (byte)(by2 & 0xF);
        stringBuffer.append("0123456789ABCDEF".charAt(by2));
        by2 = (byte)(by & 0xF);
        stringBuffer.append("0123456789ABCDEF".charAt(by2));
    }

    public static String toString(Object[] objectArray, int n, boolean bl) {
        String string;
        if (objectArray == null) {
            string = "null";
        } else {
            StringBuffer stringBuffer = new StringBuffer(n);
            if (bl) {
                stringBuffer.append("len=");
                stringBuffer.append(objectArray.length);
                stringBuffer.append(": ");
            }
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (i2 > 0) {
                    stringBuffer.append(';');
                }
                if (objectArray[i2] == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(objectArray[i2].toString());
                }
                if (stringBuffer.length() >= n) break;
            }
            string = stringBuffer.toString();
        }
        if (string.length() > n) {
            return string.substring(0, n);
        }
        return string;
    }

    public static String fixLength(String string, int n, boolean bl) {
        String string2;
        StringBuffer stringBuffer = new StringBuffer(n);
        String string3 = string2 = string == null ? "null" : string;
        if (string2.length() > n) {
            if (string2.length() > 3) {
                stringBuffer.append(string2.substring(0, n - 3));
                stringBuffer.append("...");
            } else {
                stringBuffer.append(string2.substring(0, n));
            }
        } else if (bl) {
            for (int i2 = string2.length(); i2 < n; ++i2) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(string2);
        } else {
            stringBuffer.append(string2);
            for (int i3 = string2.length(); i3 < n; ++i3) {
                stringBuffer.append(' ');
            }
        }
        return stringBuffer.toString();
    }

    public static void log(String string) {
    }
}

