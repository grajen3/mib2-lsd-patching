/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence;

public interface AttributesReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void unsubscribeResults(long[] lArray, long[] lArray2, int[] nArray) {
    }

    default public void stringValues(long[] lArray, long[] lArray2, String[] stringArray, int[] nArray) {
    }

    default public void intValues(long[] lArray, long[] lArray2, int[] nArray, int[] nArray2) {
    }

    default public void blobValues(long[] lArray, long[] lArray2, short[][] sArray, int[] nArray) {
    }

    default public void putResults(long[] lArray, long[] lArray2, int[] nArray) {
    }
}

