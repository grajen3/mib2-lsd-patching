/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

public final class TravelLinkSessionManager {
    private int[] sessionIds = new int[60];
    public static final int INVALID_SESSION_ID;

    TravelLinkSessionManager() {
        for (int i2 = 0; i2 < this.sessionIds.length; ++i2) {
            this.sessionIds[i2] = i2 * 100;
        }
    }

    public int getNewSessionId(int n) {
        if (n > -1 && n < this.sessionIds.length) {
            int n2 = n * 100;
            int n3 = n2 + 90;
            int n4 = n;
            this.sessionIds[n4] = this.sessionIds[n4] + 1;
            if (this.sessionIds[n] > n3 || this.sessionIds[n] < n2) {
                this.sessionIds[n] = n2;
            }
            return this.sessionIds[n];
        }
        return -1;
    }

    public int getCurrentSessionIdForRequest(int n) {
        if (n > -1 && n < this.sessionIds.length) {
            return this.sessionIds[n];
        }
        return -1;
    }

    public int[] getSubRequestTypes(int n) {
        switch (n) {
            case 0: {
                return new int[]{0};
            }
            case 1: {
                return new int[]{1};
            }
            case 2: {
                return new int[]{2, 45, 46, 53};
            }
            case 5: {
                return new int[]{5};
            }
            case 6: {
                return new int[]{6};
            }
            case 7: {
                return new int[]{7};
            }
            case 8: {
                return new int[]{8};
            }
            case 11: {
                return new int[]{11};
            }
            case 12: {
                return new int[]{12};
            }
            case 14: {
                return new int[]{14};
            }
            case 15: {
                return new int[]{15};
            }
            case 17: {
                return new int[]{17, 43, 44};
            }
            case 18: {
                return new int[]{18};
            }
            case 19: {
                return new int[]{19};
            }
            case 20: {
                return new int[]{20};
            }
            case 21: {
                return new int[]{21};
            }
            case 22: {
                return new int[]{22};
            }
            case 23: {
                return new int[]{23, 47, 48};
            }
            case 24: {
                return new int[]{24};
            }
            case 25: {
                return new int[]{25};
            }
            case 26: {
                return new int[]{26};
            }
            case 27: {
                return new int[]{27};
            }
            case 28: {
                return new int[]{28};
            }
            case 29: {
                return new int[]{29, 49};
            }
            case 30: {
                return new int[]{30};
            }
            case 31: {
                return new int[]{31, 55};
            }
            case 32: {
                return new int[]{32};
            }
            case 33: {
                return new int[]{33, 54};
            }
            case 35: {
                return new int[]{35, 50};
            }
            case 36: {
                return new int[]{36};
            }
            case 37: {
                return new int[]{37};
            }
            case 38: {
                return new int[]{38};
            }
            case 39: {
                return new int[]{39};
            }
            case 43: {
                return new int[]{43};
            }
            case 44: {
                return new int[]{44};
            }
            case 45: {
                return new int[]{45};
            }
            case 46: {
                return new int[]{46};
            }
            case 53: {
                return new int[]{53};
            }
            case 47: {
                return new int[]{47};
            }
            case 48: {
                return new int[]{48};
            }
            case 49: {
                return new int[]{49};
            }
            case 50: {
                return new int[]{50};
            }
            case 51: {
                return new int[]{51};
            }
            case 52: {
                return new int[]{52};
            }
            case 56: {
                return new int[]{56};
            }
            case 58: {
                return new int[]{58};
            }
            case 60: {
                return new int[]{60};
            }
        }
        return new int[0];
    }

    public boolean isSessionIdValid(int n, int n2) {
        int[] nArray = this.getSubRequestTypes(n);
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (this.getCurrentSessionIdForRequest(nArray[i2]) != n2) continue;
                return true;
            }
        }
        return false;
    }
}

