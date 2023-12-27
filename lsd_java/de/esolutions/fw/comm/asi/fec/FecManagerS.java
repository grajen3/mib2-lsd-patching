/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.FecManagerReply;

public interface FecManagerS {
    default public void checkDataSignature(String string, short[] sArray, short[] sArray2, FecManagerReply fecManagerReply) {
    }

    default public void fecDetails(long l, long l2, FecManagerReply fecManagerReply) {
    }

    default public void importFecs(int n, FecManagerReply fecManagerReply) {
    }

    default public void exportCCD(int n, FecManagerReply fecManagerReply) {
    }

    default public void getHistory(FecManagerReply fecManagerReply) {
    }

    default public void encryptFile(String string, String string2, byte[] byArray, FecManagerReply fecManagerReply) {
    }

    default public void decryptFile(String string, String string2, byte[] byArray, FecManagerReply fecManagerReply) {
    }
}

