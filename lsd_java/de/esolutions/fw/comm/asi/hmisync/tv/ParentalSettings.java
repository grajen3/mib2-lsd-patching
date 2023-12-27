/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public class ParentalSettings {
    public boolean isParentalManagementRequired;
    public int parentalLevel;

    public boolean isIsParentalManagementRequired() {
        return this.isParentalManagementRequired;
    }

    public void setIsParentalManagementRequired(boolean bl) {
        this.isParentalManagementRequired = bl;
    }

    public int getParentalLevel() {
        return this.parentalLevel;
    }

    public void setParentalLevel(int n) {
        this.parentalLevel = n;
    }

    public ParentalSettings() {
    }

    public ParentalSettings(boolean bl, int n) {
        this.isParentalManagementRequired = bl;
        this.parentalLevel = n;
    }

    public String toString() {
        return new StringBuffer("ParentalSettings{").append("isParentalManagementRequired=").append(this.isParentalManagementRequired).append(", parentalLevel=").append(this.parentalLevel).append("}").toString();
    }
}

