/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence;

import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.PartitionHandle;

public interface IPersistenceAS {
    default public void open(long l, String string, IPersistenceAReply iPersistenceAReply) {
    }

    default public void open(String string, String string2, IPersistenceAReply iPersistenceAReply) {
    }

    default public void close(PartitionHandle partitionHandle, IPersistenceAReply iPersistenceAReply) {
    }

    default public void version(long l, IPersistenceAReply iPersistenceAReply) {
    }

    default public void version(String string, IPersistenceAReply iPersistenceAReply) {
    }

    default public void purge(long l, IPersistenceAReply iPersistenceAReply) {
    }

    default public void purge(String string, IPersistenceAReply iPersistenceAReply) {
    }

    default public void beginTransaction(PartitionHandle partitionHandle, IPersistenceAReply iPersistenceAReply) {
    }

    default public void endTransaction(PartitionHandle partitionHandle, boolean bl, IPersistenceAReply iPersistenceAReply) {
    }

    default public void endTransaction(PartitionHandle partitionHandle, IPersistenceAReply iPersistenceAReply) {
    }

    default public void flush(PartitionHandle partitionHandle, IPersistenceAReply iPersistenceAReply) {
    }

    default public void exists(PartitionHandle partitionHandle, long l, IPersistenceAReply iPersistenceAReply) {
    }

    default public void remove(PartitionHandle partitionHandle, long l, IPersistenceAReply iPersistenceAReply) {
    }

    default public void setInt(PartitionHandle partitionHandle, long l, long l2, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getInt(PartitionHandle partitionHandle, long l, int n, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getInt(PartitionHandle partitionHandle, long l, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getInts(PartitionHandle partitionHandle, long[] lArray, int n, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getInts(PartitionHandle partitionHandle, long[] lArray, IPersistenceAReply iPersistenceAReply) {
    }

    default public void setString(PartitionHandle partitionHandle, long l, String string, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getString(PartitionHandle partitionHandle, long l, int n, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getString(PartitionHandle partitionHandle, long l, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getStrings(PartitionHandle partitionHandle, long[] lArray, int n, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getStrings(PartitionHandle partitionHandle, long[] lArray, IPersistenceAReply iPersistenceAReply) {
    }

    default public void setBlob(PartitionHandle partitionHandle, long l, short[] sArray, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getBlob(PartitionHandle partitionHandle, long l, int n, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getBlob(PartitionHandle partitionHandle, long l, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getBlobs(PartitionHandle partitionHandle, long[] lArray, int n, IPersistenceAReply iPersistenceAReply) {
    }

    default public void getBlobs(PartitionHandle partitionHandle, long[] lArray, IPersistenceAReply iPersistenceAReply) {
    }

    default public void subscribe(PartitionHandle partitionHandle, long[] lArray, int n, IPersistenceAReply iPersistenceAReply) {
    }

    default public void subscribe(PartitionHandle partitionHandle, long[] lArray, IPersistenceAReply iPersistenceAReply) {
    }

    default public void unsubscribe(PartitionHandle partitionHandle, long[] lArray, IPersistenceAReply iPersistenceAReply) {
    }

    default public void unsubscribeAll(PartitionHandle partitionHandle, IPersistenceAReply iPersistenceAReply) {
    }

    default public void convert(long l, String string, String string2, IPersistenceAReply iPersistenceAReply) {
    }

    default public void convert(String string, String string2, String string3, IPersistenceAReply iPersistenceAReply) {
    }
}

