/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

public class TrafficDualListViewConfiguration {
    private long[] messageIDs;
    private boolean adjustViewPort;
    private boolean adjustPins;

    public TrafficDualListViewConfiguration(long[] lArray, boolean bl, boolean bl2) {
        this.messageIDs = lArray;
        this.adjustViewPort = bl;
        this.adjustPins = bl2;
    }

    public long[] getMessageIDs() {
        return this.messageIDs;
    }

    public boolean isAdjustViewPort() {
        return this.adjustViewPort;
    }

    public boolean isAdjustPins() {
        return this.adjustPins;
    }
}

