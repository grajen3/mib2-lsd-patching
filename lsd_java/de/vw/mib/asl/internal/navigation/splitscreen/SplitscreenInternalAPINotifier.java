/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.splitscreen.ASLManeuverViewElement;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class SplitscreenInternalAPINotifier {
    private IExtLogger LOGGER = null;

    public void sendEvSplitScreenCompassDirectionUpdate(int n) {
        this.getLOGGER().trace("sendEvSplitScreenCompassDirectionUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1186712320);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void sendEvSplitScreenCompassStreetnameUpdate(String string) {
        this.getLOGGER().trace("sendEvSplitScreenCompassStreetnameUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1169935104);
        eventGeneric.setString(0, string);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void sendEvSplitScreenLocationUpdate(NavLocation navLocation) {
        this.getLOGGER().trace("sendEvSplitScreenLocationUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1153157888);
        eventGeneric.setObject(0, navLocation);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void sendEvSplitScreenPositionUpdate(PosPosition posPosition) {
        this.getLOGGER().trace("sendEvSplitScreenPositionUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1136380672);
        eventGeneric.setObject(0, posPosition);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void sendEvSplitScreen10Plus0ContentUpdate(ASLManeuverViewElement[] aSLManeuverViewElementArray) {
        this.getLOGGER().trace("sendEvSplitScreen10Plus0ContentUpdate");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1102826240);
        eventGeneric.setObject(0, aSLManeuverViewElementArray);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private IExtLogger getLOGGER() {
        if (this.LOGGER == null) {
            this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[SplitscreenInternalAPINotifier]");
        }
        return this.LOGGER;
    }
}

