/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

public interface BAPServiceListener {
    default public boolean indication(int n, int n2, int n3, int n4) {
    }

    default public boolean indication(int n, int n2) {
    }

    default public boolean indication(int n, int n2, byte[] byArray) {
    }

    default public boolean indicationError(int n, int n2) {
    }

    default public boolean acknowledge(int n, int n2) {
    }
}

