/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence;

import de.esolutions.fw.comm.persistence.PartitionHandle;

public interface IPersistenceAC {
    default public void open(long l, String string) {
    }

    default public void open(String string, String string2) {
    }

    default public void close(PartitionHandle partitionHandle) {
    }

    default public void version(long l) {
    }

    default public void version(String string) {
    }

    default public void purge(long l) {
    }

    default public void purge(String string) {
    }

    default public void beginTransaction(PartitionHandle partitionHandle) {
    }

    default public void endTransaction(PartitionHandle partitionHandle, boolean bl) {
    }

    default public void endTransaction(PartitionHandle partitionHandle) {
    }

    default public void flush(PartitionHandle partitionHandle) {
    }

    default public void exists(PartitionHandle partitionHandle, long l) {
    }

    default public void remove(PartitionHandle partitionHandle, long l) {
    }

    default public void setInt(PartitionHandle partitionHandle, long l, long l2) {
    }

    default public void getInt(PartitionHandle partitionHandle, long l, int n) {
    }

    default public void getInt(PartitionHandle partitionHandle, long l) {
    }

    default public void getInts(PartitionHandle partitionHandle, long[] lArray, int n) {
    }

    default public void getInts(PartitionHandle partitionHandle, long[] lArray) {
    }

    default public void setString(PartitionHandle partitionHandle, long l, String string) {
    }

    default public void getString(PartitionHandle partitionHandle, long l, int n) {
    }

    default public void getString(PartitionHandle partitionHandle, long l) {
    }

    default public void getStrings(PartitionHandle partitionHandle, long[] lArray, int n) {
    }

    default public void getStrings(PartitionHandle partitionHandle, long[] lArray) {
    }

    default public void setBlob(PartitionHandle partitionHandle, long l, short[] sArray) {
    }

    default public void getBlob(PartitionHandle partitionHandle, long l, int n) {
    }

    default public void getBlob(PartitionHandle partitionHandle, long l) {
    }

    default public void getBlobs(PartitionHandle partitionHandle, long[] lArray, int n) {
    }

    default public void getBlobs(PartitionHandle partitionHandle, long[] lArray) {
    }

    default public void subscribe(PartitionHandle partitionHandle, long[] lArray, int n) {
    }

    default public void subscribe(PartitionHandle partitionHandle, long[] lArray) {
    }

    default public void unsubscribe(PartitionHandle partitionHandle, long[] lArray) {
    }

    default public void unsubscribeAll(PartitionHandle partitionHandle) {
    }

    default public void convert(long l, String string, String string2) {
    }

    default public void convert(String string, String string2, String string3) {
    }
}

