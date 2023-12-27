/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

public class TraceEntityType {
    public static final short TARGET;
    public static final short PROCESS;
    public static final short THREAD;
    public static final short CHANNEL;
    public static final short CALLBACK;
    public static final short PROBE;
    public static final short _LAST;
    public static final String[] names;

    public static String getName(short s) {
        if (s >= 0 && s < 6) {
            return names[s];
        }
        return null;
    }

    static {
        names = new String[]{"target", "process", "thread", "channel", "callback", "probe"};
    }
}

