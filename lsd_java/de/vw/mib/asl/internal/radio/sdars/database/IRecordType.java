/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

public interface IRecordType {
    public static final int TYPE_EMPTY;
    public static final int TYPE_INT;
    public static final int TYPE_BOOLEAN;
    public static final int TYPE_STRING;
    public static final int TYPE_SHORT;
    public static final int TYPE_RADIOTEXT;
    public static final int TYPE_CHANNEL;
    public static final int TYPE_CATEGORY;
    public static final int TYPE_LONG;
    public static final int TYPE_RESOURCELOCATOR;
    public static final int TYPE_OBJECT;
    public static final int TYPE_OBJECT_ARRAY;
    public static final int TYPE_EVENT;
    public static final String[] NAMES;

    static {
        NAMES = new String[]{"EMPTY", "INT", "BOOLEAN", "STRING", "SHORT", "RADIOTEXT", "CHANNEL", "CATEGORY", "LONG", "RESOURCELOCATOR", "OBJECT", "OBJECT[]", "EVENT"};
    }
}

