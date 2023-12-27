/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import org.dsi.ifc.navigation.RouteOptions;

public class PersistableDSIRouteOptions
extends RouteOptions {
    public PersistableDSIRouteOptions() {
        this.matchMembers(new RouteOptions());
    }

    public PersistableDSIRouteOptions(RouteOptions routeOptions) {
        this.matchMembers(routeOptions);
    }

    private void matchMembers(RouteOptions routeOptions) {
        this.routeType = routeOptions.getRouteType();
        this.weighting = routeOptions.getWeighting();
        this.hybridMode = routeOptions.getHybridMode();
        this.dynamic = routeOptions.getDynamic();
        this.dynamicSpeedFlow = routeOptions.getDynamicSpeedFlow();
        this.dynamicTrafficPattern = routeOptions.getDynamicTrafficPattern();
        this.dynamicTrafficPatternOnline = routeOptions.getDynamicTrafficPatternOnline();
        this.dynamicTrafficPatternRecorded = routeOptions.getDynamicTrafficPatternRecorded();
        this.motorways = routeOptions.getMotorways();
        this.ferries = routeOptions.getFerries();
        this.tollroads = routeOptions.getTollroads();
        this.tollroadsCostPenalty = routeOptions.getTollroadsCostPenalty();
        this.tunnels = routeOptions.getTunnels();
        this.leftRightTurn = routeOptions.getLeftRightTurn();
        this.slopes = routeOptions.getSlopes();
        this.slopesMaxFactor = routeOptions.getSlopesMaxFactor();
        this.vignette = routeOptions.getVignette();
        this.vignetteCountryList = routeOptions.getVignetteCountryList();
        this.cityMaut = routeOptions.getCityMaut();
        this.cityMautList = routeOptions.getCityMautList();
        this.cartrain = routeOptions.getCartrain();
        this.timeDomain = routeOptions.getTimeDomain();
        this.seasonalTimeDomain = routeOptions.getSeasonalTimeDomain();
        this.unpaved = routeOptions.getUnpaved();
        this.residentialAreaHandling = routeOptions.getResidentialAreaHandling();
        this.trailer = routeOptions.getTrailer();
        this.hovCarPoolsLane = routeOptions.getHovCarPoolsLane();
        this.border = routeOptions.getBorder();
        this.ipd = routeOptions.getIpd();
        this.trail = routeOptions.getTrail();
        this.waypointMode = routeOptions.getWaypointMode();
        this.economicTurns = routeOptions.getEconomicTurns();
    }

    public void readFromStream(PersistenceInputStream persistenceInputStream) {
        int n;
        this.routeType = persistenceInputStream.readInt();
        this.weighting = persistenceInputStream.readInt();
        this.hybridMode = persistenceInputStream.readInt();
        this.dynamic = persistenceInputStream.readInt();
        this.dynamicSpeedFlow = persistenceInputStream.readInt();
        this.dynamicTrafficPattern = persistenceInputStream.readInt();
        this.dynamicTrafficPatternOnline = persistenceInputStream.readInt();
        this.dynamicTrafficPatternRecorded = persistenceInputStream.readInt();
        this.motorways = persistenceInputStream.readInt();
        this.ferries = persistenceInputStream.readInt();
        this.tollroads = persistenceInputStream.readInt();
        this.tollroadsCostPenalty = persistenceInputStream.readInt();
        this.tunnels = persistenceInputStream.readInt();
        this.leftRightTurn = persistenceInputStream.readInt();
        this.slopes = persistenceInputStream.readInt();
        this.slopesMaxFactor = persistenceInputStream.readInt();
        this.vignette = persistenceInputStream.readInt();
        int n2 = persistenceInputStream.readInt();
        if (n2 > 0) {
            this.vignetteCountryList = new int[n2];
            for (n = 0; n < n2; ++n) {
                this.vignetteCountryList[n] = persistenceInputStream.readInt();
            }
        } else {
            this.vignetteCountryList = null;
        }
        this.cityMaut = persistenceInputStream.readInt();
        n2 = persistenceInputStream.readInt();
        if (n2 > 0) {
            this.cityMautList = new int[n2];
            for (n = 0; n < n2; ++n) {
                this.cityMautList[n] = persistenceInputStream.readInt();
            }
        } else {
            this.cityMautList = null;
        }
        this.cartrain = persistenceInputStream.readInt();
        this.timeDomain = persistenceInputStream.readInt();
        this.seasonalTimeDomain = persistenceInputStream.readInt();
        this.unpaved = persistenceInputStream.readInt();
        this.residentialAreaHandling = persistenceInputStream.readInt();
        this.trailer = persistenceInputStream.readInt();
        this.hovCarPoolsLane = persistenceInputStream.readInt();
        this.border = persistenceInputStream.readInt();
        this.ipd = persistenceInputStream.readInt();
        this.trail = persistenceInputStream.readInt();
        this.waypointMode = persistenceInputStream.readInt();
        this.economicTurns = persistenceInputStream.readInt();
    }

    public void writeToStream(PersistenceOutputStream persistenceOutputStream) {
        int n;
        persistenceOutputStream.writeInt(this.routeType);
        persistenceOutputStream.writeInt(this.weighting);
        persistenceOutputStream.writeInt(this.hybridMode);
        persistenceOutputStream.writeInt(this.dynamic);
        persistenceOutputStream.writeInt(this.dynamicSpeedFlow);
        persistenceOutputStream.writeInt(this.dynamicTrafficPattern);
        persistenceOutputStream.writeInt(this.dynamicTrafficPatternOnline);
        persistenceOutputStream.writeInt(this.dynamicTrafficPatternRecorded);
        persistenceOutputStream.writeInt(this.motorways);
        persistenceOutputStream.writeInt(this.ferries);
        persistenceOutputStream.writeInt(this.tollroads);
        persistenceOutputStream.writeInt(this.tollroadsCostPenalty);
        persistenceOutputStream.writeInt(this.tunnels);
        persistenceOutputStream.writeInt(this.leftRightTurn);
        persistenceOutputStream.writeInt(this.slopes);
        persistenceOutputStream.writeInt(this.slopesMaxFactor);
        persistenceOutputStream.writeInt(this.vignette);
        if (this.vignetteCountryList != null) {
            persistenceOutputStream.writeInt(this.vignetteCountryList.length);
            for (n = 0; n < this.vignetteCountryList.length; ++n) {
                persistenceOutputStream.writeInt(this.vignetteCountryList[n]);
            }
        } else {
            persistenceOutputStream.writeInt(0);
        }
        persistenceOutputStream.writeInt(this.cityMaut);
        if (this.cityMautList != null) {
            persistenceOutputStream.writeInt(this.cityMautList.length);
            for (n = 0; n < this.cityMautList.length; ++n) {
                persistenceOutputStream.writeInt(this.cityMautList[n]);
            }
        } else {
            persistenceOutputStream.writeInt(0);
        }
        persistenceOutputStream.writeInt(this.cartrain);
        persistenceOutputStream.writeInt(this.timeDomain);
        persistenceOutputStream.writeInt(this.seasonalTimeDomain);
        persistenceOutputStream.writeInt(this.unpaved);
        persistenceOutputStream.writeInt(this.residentialAreaHandling);
        persistenceOutputStream.writeInt(this.trailer);
        persistenceOutputStream.writeInt(this.hovCarPoolsLane);
        persistenceOutputStream.writeInt(this.border);
        persistenceOutputStream.writeInt(this.ipd);
        persistenceOutputStream.writeInt(this.trail);
        persistenceOutputStream.writeInt(this.waypointMode);
        persistenceOutputStream.writeInt(this.economicTurns);
    }
}

