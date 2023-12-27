/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

public class RequestTracker {
    private static final int REQUEST_MAX_NUMBER;
    private int numberRepeatedRequests = 0;
    private int prevLcuId = -1;
    private int prevTaId = -1;
    private static final int INVALID_ID;

    public boolean checkReceivedRequest(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = n == this.prevLcuId && n2 == this.prevTaId;
        if (!bl || ++this.numberRepeatedRequests >= 4) {
            this.resetPreviousRequest();
        }
        return bl;
    }

    public boolean existsPreviousRequest() {
        return this.prevLcuId != -1 || this.prevTaId != -1;
    }

    public void trackRequest(int n, int n2) {
        this.numberRepeatedRequests = 0;
        this.prevLcuId = n;
        this.prevTaId = n2;
    }

    public void resetPreviousRequest() {
        this.numberRepeatedRequests = 0;
        this.prevLcuId = -1;
        this.prevTaId = -1;
    }
}

