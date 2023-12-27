/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.overlay;

import de.vw.mib.asl.api.navigation.IOverlayData;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.overlay.OverlayNotifierModel$1;

public class OverlayNotifierModel {
    public void updateOverlayData(IOverlayData iOverlayData) {
        if (iOverlayData != null) {
            ServiceManager.aslPropertyManager.valueChangedResourceLocator(221141504, iOverlayData.getColorIndicatorIcon());
            ServiceManager.aslPropertyManager.valueChangedInteger(204364288, iOverlayData.getDistanceToManeuver());
            ServiceManager.aslPropertyManager.valueChangedString(170809856, iOverlayData.getExitNumber());
            ServiceManager.aslPropertyManager.valueChangedBoolean(187587072, iOverlayData.getExitNumberVisibility());
            ServiceManager.aslPropertyManager.valueChangedResourceLocator(338582016, iOverlayData.getHeadlineIcon());
            ServiceManager.aslPropertyManager.valueChangedBoolean(355359232, iOverlayData.getHeadlineIconVisibility());
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(237918720, iOverlayData.getLaneDirections());
            ServiceManager.aslPropertyManager.valueChangedBoolean(321804800, iOverlayData.getLaneGuidanceAvailable());
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(254695936, iOverlayData.getLaneInfos());
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(271473152, iOverlayData.getLaneMarkingsLeft());
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(288250368, iOverlayData.getLaneMarkingsRight());
            ServiceManager.aslPropertyManager.valueChangedInteger(305027584, iOverlayData.getLaneNumber());
            ServiceManager.aslPropertyManager.valueChangedString(154032640, iOverlayData.getName());
            ServiceManager.aslPropertyManager.valueChangedString(372136448, iOverlayData.getSignPostInfo());
        }
    }

    public void setOverlayDataDefaults() {
        this.updateOverlayData(new OverlayNotifierModel$1(this));
    }

    public void updateOverlayIndex(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(137255424, n);
    }

    public void updateOverlayCount(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(120478208, n);
    }

    public void updateOverlayCurrentContent(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(103700992, n);
    }
}

