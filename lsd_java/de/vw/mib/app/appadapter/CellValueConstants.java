/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter;

public final class CellValueConstants {
    public static final byte VOID_TYPE;
    public static final byte BOOLEAN_TYPE;
    static final byte CHAR_TYPE;
    public static final byte BYTE_TYPE;
    public static final byte SHORT_TYPE;
    public static final byte INT_TYPE;
    public static final byte LONG_TYPE;
    public static final byte FLOAT_TYPE;
    public static final byte DOUBLE_TYPE;
    public static final byte STRING_TYPE;
    public static final byte OBJECT_TYPE;
    static final String[] TYPE_NAMES;

    private CellValueConstants() {
    }

    static {
        TYPE_NAMES = new String[]{"void", "boolean", "char", "byte", "short", "int", "long", "float", "double", "String", "Object"};
    }
}

