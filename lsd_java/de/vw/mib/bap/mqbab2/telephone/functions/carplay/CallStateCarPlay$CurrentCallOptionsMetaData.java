/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

final class CallStateCarPlay$CurrentCallOptionsMetaData {
    public int incomingCallID = -1;
    public boolean incomingCallPresent = false;
    public boolean activeCallPresent = false;
    public int activeCallID = -1;
    public int[] conferenceCallIds = new int[6];

    public CallStateCarPlay$CurrentCallOptionsMetaData() {
        for (int i2 = 0; i2 < 6; ++i2) {
            this.conferenceCallIds[i2] = -1;
        }
    }
}

