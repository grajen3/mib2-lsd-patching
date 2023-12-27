/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.tracing;

public interface ITraceChannel {
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
    public static final String[] levelNames;

    default public boolean log(short s, short s2, short s3, byte[] byArray) {
    }

    default public boolean log(short s, short s2, byte[] byArray) {
    }

    default public boolean log(short s, String string) {
    }

    default public boolean log(short s, String string, Object object) {
    }

    default public boolean log(short s, String string, Object object, Object object2) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14) {
    }

    default public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15) {
    }

    default public boolean log(short s, String string, Object[] objectArray) {
    }

    default public boolean log(short s, short s2, String string) {
    }

    default public boolean log(short s, short s2, String string, Object object) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
    }

    default public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
    }

    default public boolean log(short s, short s2, String string, Object[] objectArray) {
    }

    static {
        levelNames = new String[]{"trace", "debug", "info", "warn", "ERROR", "FATAL", "OFF", "NONE", "Disabled"};
    }
}

