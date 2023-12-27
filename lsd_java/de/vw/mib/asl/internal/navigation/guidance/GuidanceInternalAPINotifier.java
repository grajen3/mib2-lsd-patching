/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.genericevents.EventGeneric;

public class GuidanceInternalAPINotifier {
    private IExtLogger LOGGER = null;

    public void sendEvVZAVZEUpdate(ASLGuidanceVZAVZEIcons[] aSLGuidanceVZAVZEIconsArray) {
        this.getLOGGER().trace("sendEvVZAVZEUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1197225216);
        eventGeneric.setObject(0, aSLGuidanceVZAVZEIconsArray);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void sendEvLaneGuidanceUpdate(ASLGuidanceLaneGuidance[] aSLGuidanceLaneGuidanceArray) {
        this.getLOGGER().trace("sendEvLaneGuidanceUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1214002432);
        eventGeneric.setObject(0, aSLGuidanceLaneGuidanceArray);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void sendEvSpeedCameraIconUpdate(boolean bl) {
        this.getLOGGER().trace("sendEvSpeedCameraIconUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1230779648);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void sendEvSatelliteSystemUpdate(int n) {
        this.getLOGGER().trace("sendEvSatelliteSystemUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1247556864);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private IExtLogger getLOGGER() {
        if (this.LOGGER == null) {
            this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(32, "[GuidanceInternalAPINotifier]");
        }
        return this.LOGGER;
    }
}

