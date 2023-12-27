/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence;

import de.esolutions.fw.comm.asi.persistence.AttributesReply;

public interface AttributesS {
    default public void subscribe(long[] lArray, long[] lArray2, AttributesReply attributesReply) {
    }

    default public void unsubscribe(long[] lArray, long[] lArray2, AttributesReply attributesReply) {
    }

    default public void unsubscribeAll(AttributesReply attributesReply) {
    }

    default public void putInts(long[] lArray, long[] lArray2, int[] nArray, AttributesReply attributesReply) {
    }

    default public void putStrings(long[] lArray, long[] lArray2, String[] stringArray, AttributesReply attributesReply) {
    }

    default public void putBlobs(long[] lArray, long[] lArray2, short[][] sArray, AttributesReply attributesReply) {
    }
}

