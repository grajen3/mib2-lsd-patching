/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.FecAppMMXReply;

public interface FecAppMMXS {
    default public void registerForFec(int n, FecAppMMXReply fecAppMMXReply) {
    }

    default public void checkPkgSignature(String string, short[] sArray, short[] sArray2, FecAppMMXReply fecAppMMXReply) {
    }
}

