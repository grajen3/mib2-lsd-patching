/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.NavAddress;

public class GuidanceInfo {
    NavAddress address;
    int etaDays;
    int etaHours;
    int etaMinutes;
    long distance;

    public GuidanceInfo(NavAddress navAddress, int n, int n2, int n3, long l) {
        this.address = navAddress;
        this.etaDays = n;
        this.etaHours = n2;
        this.etaMinutes = n3;
        this.distance = l;
    }

    public NavAddress getAddress() {
        return this.address;
    }

    public int getEtaDays() {
        return this.etaDays;
    }

    public int getEtaHours() {
        return this.etaHours;
    }

    public int getEtaMinutes() {
        return this.etaMinutes;
    }

    public long getDistance() {
        return this.distance;
    }
}

