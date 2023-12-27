/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

public interface BAPService {
    default public void request(int n, int n2, int n3, int n4) {
    }

    default public void requestVoid(int n, int n2) {
    }

    default public void requestByteSequence(int n, int n2, byte[] byArray) {
    }

    default public void requestError(int n, int n2) {
    }
}

