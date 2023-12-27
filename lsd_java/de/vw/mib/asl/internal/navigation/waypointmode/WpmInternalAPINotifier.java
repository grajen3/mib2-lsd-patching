/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.genericevents.EventGeneric;

public class WpmInternalAPINotifier {
    void setCurrentWPMModeDefault() {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(945566976);
        eventGeneric.setInt(0, 0);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setCurrentWPMModeRecord() {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(945566976);
        eventGeneric.setInt(0, 1);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setCurrentWPMModeDrive() {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(945566976);
        eventGeneric.setInt(0, 2);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setDistanceToWP(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(962344192);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setDirectionToWP(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(979121408);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setRecordWithDestination(boolean bl) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(995898624);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setNumberOfFreePointsInMemory(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1012675840);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setNumberOfMaxWaypointsinMemory(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1029453056);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setNumberOfWaypointsinCurrentRecord(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1046230272);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }
}

