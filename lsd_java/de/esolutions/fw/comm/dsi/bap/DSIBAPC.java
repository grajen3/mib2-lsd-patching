/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bap;

public interface DSIBAPC {
    default public void getBAPState(int n) {
    }

    default public void setHMIState(int n, int n2) {
    }

    default public void request(int n, int n2, int n3, int n4, int n5) {
    }

    default public void requestVoid(int n, int n2, int n3) {
    }

    default public void requestByteSequence(int n, int n2, int n3, byte[] byArray) {
    }

    default public void requestError(int n, int n2, int n3) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

