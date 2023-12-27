/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.PersistedOverlaysSetup;

public class OverlaysDatapool {
    private final PersistedOverlaysSetup persistedOverlaysSetup = PersistedOverlaysSetup.getInstance();
    private final INavigationDP naviDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private boolean isHIGH = false;

    public void clear() {
        this.persistedOverlaysSetup.clear();
    }

    public boolean isRGActive() {
        return this.naviDP.getRGIsActive();
    }

    public boolean isKanbanActive() {
        return this.persistedOverlaysSetup.isKanban();
    }

    public boolean isManeuverDetailViewActive() {
        return this.persistedOverlaysSetup.isKDK();
    }

    public boolean isMotorwayInfoActive() {
        return this.persistedOverlaysSetup.isMotorwayInfo();
    }

    public boolean isSplitscreenActive() {
        if (this.isRGActive()) {
            return ASLNavigationMapFactory.getNavigationMapApi().isSplitScreenGuidance();
        }
        return ASLNavigationMapFactory.getNavigationMapApi().isSplitScreenNoGuidance();
    }

    public boolean isHIGH() {
        return this.isHIGH;
    }

    public void setKanban(boolean bl) {
        this.persistedOverlaysSetup.setKanban(bl);
    }

    public void setManeuverDetailView(boolean bl) {
        this.persistedOverlaysSetup.setKDK(bl);
    }

    public void setMotorwayInfoActive(boolean bl) {
        this.persistedOverlaysSetup.setMotorwayInfo(bl);
    }

    public void setIsHIGH(boolean bl) {
        this.isHIGH = bl;
    }

    public boolean isMapExternalConfigured() {
        return this.naviDP.isMapExternalConfigured();
    }
}

