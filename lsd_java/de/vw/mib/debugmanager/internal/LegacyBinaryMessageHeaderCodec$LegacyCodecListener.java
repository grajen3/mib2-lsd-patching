/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

interface LegacyBinaryMessageHeaderCodec$LegacyCodecListener {
    default public void corruptedDataReceived(short s, String string) {
    }

    default public void messageDecoded(short s, byte[] byArray, int n, int n2) {
    }

    default public void messageEncoded(short s, byte[] byArray, int n) {
    }
}

