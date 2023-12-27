/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

public class TraceLevels {
    public static final short TRACE;
    public static final short DEBUG;
    public static final short INFO;
    public static final short WARN;
    public static final short ERROR;
    public static final short FATAL;
    public static final short OFF;
    public static final short NONE;
    public static final short DISABLED;
    public static final short _LAST;
    public static final short NUM_VISIBLE_MESSAGES;
    public static final String[] levelNames;

    public static boolean isValidLogLevel(short s) {
        return s >= 0 && s <= 5;
    }

    public static boolean isValidFilterLevel(short s) {
        return s >= 0 && s <= 7;
    }

    public static String getName(short s) {
        if (s >= 0 && s <= 8) {
            return levelNames[s];
        }
        return null;
    }

    static {
        levelNames = new String[]{"trace", "debug", "info", "warn", "ERROR", "FATAL", "OFF", "NONE", "Disabled"};
    }
}

