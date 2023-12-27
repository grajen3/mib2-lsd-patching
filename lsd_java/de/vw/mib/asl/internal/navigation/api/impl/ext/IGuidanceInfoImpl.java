/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INaviHelper;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;

public class IGuidanceInfoImpl
implements IGuidanceInfo {
    INavigationLocationImpl address;
    long distance;
    long rttMillis;
    int[] eta;
    int[] rtt;

    public IGuidanceInfoImpl(INavigationLocationImpl iNavigationLocationImpl, long l, long l2) {
        this.address = iNavigationLocationImpl;
        this.distance = l;
        this.rttMillis = l2;
        INaviHelper iNaviHelper = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper();
        this.eta = iNaviHelper.calculateEta(l2);
        this.rtt = new int[]{iNaviHelper.calculateRttHours((int)l2), iNaviHelper.calculateRttMinutes((int)l2), 0};
        while (this.rtt[0] >= 24) {
            this.rtt[0] = this.rtt[0] - 24;
            this.rtt[2] = this.rtt[2] + 1;
        }
    }

    @Override
    public INavigationLocation getLocation() {
        return this.address;
    }

    @Override
    public int getEtaDays() {
        return this.eta[2];
    }

    @Override
    public int getEtaHours() {
        return this.eta[0];
    }

    @Override
    public int getEtaMinutes() {
        return this.eta[1];
    }

    @Override
    public long getDistance() {
        return this.distance;
    }

    @Override
    public long getEtaMilliseconds() {
        return this.rttMillis;
    }

    @Override
    public long getRttMilliseconds() {
        return this.rttMillis;
    }

    @Override
    public int getRttDays() {
        return this.rtt[2];
    }

    @Override
    public int getRttHours() {
        return this.rtt[0];
    }

    @Override
    public int getRttMinutes() {
        return this.rtt[1];
    }
}

