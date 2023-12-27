/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence;

import de.esolutions.fw.comm.persistence.PartitionHandle;

public interface IPersistenceAReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void openResult(long l, String string, PartitionHandle partitionHandle, int n) {
    }

    default public void openResult(String string, String string2, PartitionHandle partitionHandle, int n) {
    }

    default public void closeResult(PartitionHandle partitionHandle, int n) {
    }

    default public void versionResult(long l, String string, int n) {
    }

    default public void versionResult(String string, String string2, int n) {
    }

    default public void purgeResult(long l, int n) {
    }

    default public void purgeResult(String string, int n) {
    }

    default public void beginTransactionResult(PartitionHandle partitionHandle, int n) {
    }

    default public void endTransactionResult(PartitionHandle partitionHandle, int n) {
    }

    default public void flushResult(PartitionHandle partitionHandle, int n) {
    }

    default public void existsResult(PartitionHandle partitionHandle, long l, int n) {
    }

    default public void removeResult(PartitionHandle partitionHandle, long l, int n) {
    }

    default public void getIntResult(PartitionHandle partitionHandle, long l, long l2, int n) {
    }

    default public void getIntsResult(PartitionHandle partitionHandle, long[] lArray, long[] lArray2, int[] nArray) {
    }

    default public void getStringResult(PartitionHandle partitionHandle, long l, String string, int n) {
    }

    default public void getStringsResult(PartitionHandle partitionHandle, long[] lArray, String[] stringArray, int[] nArray) {
    }

    default public void getBlobResult(PartitionHandle partitionHandle, long l, short[] sArray, int n) {
    }

    default public void getBlobsResult(PartitionHandle partitionHandle, long[] lArray, short[][] sArray, int[] nArray) {
    }

    default public void setResult(PartitionHandle partitionHandle, long l, int n) {
    }

    default public void unsubscribeResult(PartitionHandle partitionHandle, long[] lArray, int[] nArray) {
    }

    default public void stringValues(PartitionHandle partitionHandle, long[] lArray, String[] stringArray, int[] nArray) {
    }

    default public void intValues(PartitionHandle partitionHandle, long[] lArray, long[] lArray2, int[] nArray) {
    }

    default public void blobValues(PartitionHandle partitionHandle, long[] lArray, short[][] sArray, int[] nArray) {
    }

    default public void convertResult(long l, String string, String string2, PartitionHandle partitionHandle, int n) {
    }

    default public void convertResult(String string, String string2, String string3, PartitionHandle partitionHandle, int n) {
    }
}

