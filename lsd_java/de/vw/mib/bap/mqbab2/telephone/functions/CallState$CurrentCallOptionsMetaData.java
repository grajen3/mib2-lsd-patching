/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

final class CallState$CurrentCallOptionsMetaData {
    public int incomingCallID = -1;
    public boolean incomingCallPresent = false;
    public boolean activeCallPresent = false;
    public int activeCallID = -1;
    public boolean holdCallPresent = false;
    public int holdCallID = -1;
    public boolean conferenceCallPresent = false;
    public boolean conferenceCallActive = false;
    public boolean conferenceCallHold = false;
    public int[] conferenceCallIds = new int[7];

    public CallState$CurrentCallOptionsMetaData() {
        for (int i2 = 0; i2 < 7; ++i2) {
            this.conferenceCallIds[i2] = -1;
        }
    }
}

