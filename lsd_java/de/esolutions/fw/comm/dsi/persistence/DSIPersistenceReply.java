/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.persistence;

public interface DSIPersistenceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateActiveSQLDatabaseMedium(int n, int n2) {
    }

    default public void writeInt(int n, long l, int n2) {
    }

    default public void readInt(int n, long l, int n2, int n3) {
    }

    default public void writeBuffer(int n, long l, int n2) {
    }

    default public void readBuffer(int n, long l, byte[] byArray, int n2) {
    }

    default public void writeString(int n, long l, int n2) {
    }

    default public void readString(int n, long l, String string, int n2) {
    }

    default public void writeArray(int n, long l, int n2) {
    }

    default public void readArray(int n, long l, int[] nArray, int n2) {
    }

    default public void writeStringArray(int n, long l, int n2) {
    }

    default public void readStringArray(int n, long l, String[] stringArray, int n2) {
    }

    default public void getVisibleSystemLanguages(String string) {
    }

    default public void flushSQLDatabase(int n) {
    }

    default public void beginTransaction(int n, int n2) {
    }

    default public void endTransaction(int n, int n2) {
    }

    default public void valueChangedInt(int n, long l, int n2, int n3) {
    }

    default public void valueChangedString(int n, long l, String string, int n2) {
    }

    default public void valueChangedArray(int n, long l, int[] nArray, int n2) {
    }

    default public void valueChangedStringArray(int n, long l, String[] stringArray, int n2) {
    }

    default public void valueChangedBuffer(int n, long l, byte[] byArray, int n2) {
    }

    default public void unsubscribe(int n, int[] nArray, long[] lArray, int[] nArray2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

