/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.miniser;

import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;

public interface IMiniIntDeserializer {
    default public short retrieveShort(byte[] byArray) {
    }

    default public short retrieveShort(byte[] byArray, int n) {
    }

    default public int retrieveUnsignedShort(byte[] byArray) {
    }

    default public int retrieveUnsignedShort(byte[] byArray, int n) {
    }

    default public int retrieveInt(byte[] byArray) {
    }

    default public int retrieveInt(byte[] byArray, int n) {
    }

    default public long retrieveUnsignedInt(byte[] byArray) {
    }

    default public long retrieveUnsignedInt(byte[] byArray, int n) {
    }

    default public long retrieveLong(byte[] byArray) {
    }

    default public long retrieveLong(byte[] byArray, int n) {
    }

    default public String getDescription() {
    }

    default public IMiniIntSerializer createCompatibleSerializer() {
    }

    default public IMiniIntDeserializer createCompatibleDeserializer() {
    }
}

