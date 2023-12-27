/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.miniser;

import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;

public interface IMiniIntSerializer {
    default public void storeLong(long l, byte[] byArray) {
    }

    default public void storeInt(int n, byte[] byArray) {
    }

    default public void storeShort(short s, byte[] byArray) {
    }

    default public void storeLong(long l, byte[] byArray, int n) {
    }

    default public void storeInt(int n, byte[] byArray, int n2) {
    }

    default public void storeShort(short s, byte[] byArray, int n) {
    }

    default public String getDescription() {
    }

    default public IMiniIntSerializer createCompatibleSerializer() {
    }

    default public IMiniIntDeserializer createCompatibleDeserializer() {
    }
}

