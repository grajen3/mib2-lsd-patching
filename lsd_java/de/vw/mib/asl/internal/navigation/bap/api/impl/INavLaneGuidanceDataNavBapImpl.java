/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.api.impl;

import de.vw.mib.asl.api.navbap.INavLaneGuidanceDataNavBap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.navigation.NavLaneGuidanceData;

public class INavLaneGuidanceDataNavBapImpl
implements INavLaneGuidanceDataNavBap {
    private short laneDirection;
    private byte guidanceInfo;
    private byte laneDescription;
    private byte laneMarkingLeft;
    private byte laneMarkingRight;
    private short laneType;
    private byte[] laneSideStreets;

    public INavLaneGuidanceDataNavBapImpl(NavLaneGuidanceData navLaneGuidanceData) {
        if (navLaneGuidanceData != null) {
            this.laneDirection = navLaneGuidanceData.getLaneDirection();
            this.guidanceInfo = navLaneGuidanceData.getGuidanceInfo();
            this.laneDescription = navLaneGuidanceData.getLaneDescription();
            this.laneMarkingLeft = navLaneGuidanceData.getLaneMarkingLeft();
            this.laneMarkingRight = navLaneGuidanceData.getLaneMarkingRight();
            this.laneType = navLaneGuidanceData.getLaneType();
            this.laneSideStreets = navLaneGuidanceData.getLaneSideStreets();
        } else {
            ServiceManager.logger.error(16384, "[INavLaneGuidanceDataNavBapImpl] data was null");
        }
    }

    @Override
    public short getLaneDirection() {
        return this.laneDirection;
    }

    @Override
    public byte getGuidanceInfo() {
        return this.guidanceInfo;
    }

    @Override
    public byte getLaneDescription() {
        return this.laneDescription;
    }

    @Override
    public byte getLaneMarkingLeft() {
        return this.laneMarkingLeft;
    }

    @Override
    public byte getLaneMarkingRight() {
        return this.laneMarkingRight;
    }

    @Override
    public short getLaneType() {
        return this.laneType;
    }

    @Override
    public byte[] getLaneSideStreets() {
        return this.laneSideStreets;
    }
}

