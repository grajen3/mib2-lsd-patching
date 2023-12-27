/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.Route;

public final class ASLNavGuidanceDP {
    private static final ASLNavGuidanceDP DATAPOOL = new ASLNavGuidanceDP();
    private int guidanceState;
    private ASLCalculationState[] calculationState;
    private int errorState;
    private Route currentRoute;
    private int guidanceMode;
    private boolean voicePromptRequired = true;
    private Route tourBackup;
    private int pnavStatus;
    private NavRmRouteListArrayData navRmRouteList;

    public static ASLNavGuidanceDP getInstance() {
        return DATAPOOL;
    }

    private ASLNavGuidanceDP() {
    }

    public boolean isVoicePromptRequired() {
        return this.voicePromptRequired;
    }

    public int getPnavStatus() {
        return this.pnavStatus;
    }

    public void setPnavStatus(int n) {
        this.pnavStatus = n;
    }

    public void setVoicePromptRequired(boolean bl) {
        this.voicePromptRequired = bl;
    }

    public int getGuidanceState() {
        return this.guidanceState;
    }

    public void setGuidanceState(int n) {
        this.guidanceState = n;
    }

    public ASLCalculationState[] getCalculationState() {
        return this.calculationState;
    }

    public void setCalculationState(ASLCalculationState[] aSLCalculationStateArray) {
        this.calculationState = aSLCalculationStateArray;
    }

    public int getErrorState() {
        return this.errorState;
    }

    public void setErrorState(int n) {
        this.errorState = n;
    }

    public Route getCurrentRoute() {
        return this.currentRoute;
    }

    public void setCurrentRoute(Route route) {
        this.currentRoute = route;
    }

    public int getGuidanceMode() {
        return this.guidanceMode;
    }

    public void setGuidanceMode(int n) {
        this.guidanceMode = n;
    }

    public void setTourBackup(Route route) {
        this.tourBackup = route;
    }

    public Route getTourBackup() {
        return this.tourBackup;
    }

    public void setRmRouteList(NavRmRouteListArrayData navRmRouteListArrayData) {
        this.navRmRouteList = navRmRouteListArrayData;
    }

    public NavRmRouteListArrayData getNavRmRouteList() {
        return this.navRmRouteList;
    }
}

