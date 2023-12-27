/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.INavigationLocation;

public class ASLGuidanceInfo
implements IGuidanceInfo {
    private int etaDay = 0;
    private int etaHour = 0;
    private int etaMin = 0;
    private int rttHour = 0;
    private int rttMin = 0;
    private long rttMilliseconds = 0L;
    private long dtdMeter = 0L;
    private int destinationType = 1;
    private INavigationLocation location;

    @Override
    public int getEtaDays() {
        return this.etaDay;
    }

    public void setEtaDays(int n) {
        this.etaDay = n;
    }

    @Override
    public int getEtaHours() {
        return this.etaHour;
    }

    public void setEtaHours(int n) {
        this.etaHour = n;
    }

    @Override
    public int getEtaMinutes() {
        return this.etaMin;
    }

    public void setEtaMinutes(int n) {
        this.etaMin = n;
    }

    @Override
    public int getRttHours() {
        return this.rttHour;
    }

    public void setRttHours(int n) {
        this.rttHour = n;
    }

    @Override
    public int getRttMinutes() {
        return this.rttMin;
    }

    public void setRttMinutes(int n) {
        this.rttMin = n;
    }

    @Override
    public long getRttMilliseconds() {
        return this.rttMilliseconds;
    }

    public void setRttMilliseconds(long l) {
        this.rttMilliseconds = l;
    }

    @Override
    public long getDistance() {
        return this.dtdMeter;
    }

    public void setDistance(long l) {
        this.dtdMeter = l;
    }

    public int getDestinationType() {
        return this.destinationType;
    }

    public void setDestinationType(int n) {
        this.destinationType = n;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.destinationType;
        n2 = (int)((long)(31 * n2) + this.dtdMeter);
        n2 = 31 * n2 + this.etaDay;
        n2 = 31 * n2 + this.etaHour;
        n2 = 31 * n2 + this.etaMin;
        n2 = 31 * n2 + this.rttHour;
        n2 = (int)((long)(31 * n2) + this.rttMilliseconds);
        n2 = 31 * n2 + this.rttMin;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ASLGuidanceInfo aSLGuidanceInfo = (ASLGuidanceInfo)object;
        if (this.destinationType != aSLGuidanceInfo.destinationType) {
            return false;
        }
        if (this.dtdMeter != aSLGuidanceInfo.dtdMeter) {
            return false;
        }
        if (this.etaDay != aSLGuidanceInfo.etaDay) {
            return false;
        }
        if (this.etaHour != aSLGuidanceInfo.etaHour) {
            return false;
        }
        if (this.etaMin != aSLGuidanceInfo.etaMin) {
            return false;
        }
        if (this.rttHour != aSLGuidanceInfo.rttHour) {
            return false;
        }
        if (this.rttMilliseconds != aSLGuidanceInfo.rttMilliseconds) {
            return false;
        }
        return this.rttMin == aSLGuidanceInfo.rttMin;
    }

    @Override
    public INavigationLocation getLocation() {
        return this.location;
    }

    public void setLocation(INavigationLocation iNavigationLocation) {
        this.location = iNavigationLocation;
    }

    @Override
    public long getEtaMilliseconds() {
        return 0L;
    }

    @Override
    public int getRttDays() {
        return 0;
    }
}

