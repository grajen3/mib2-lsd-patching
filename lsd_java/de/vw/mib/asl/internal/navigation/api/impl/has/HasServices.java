/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ImportGPXDataContainer;
import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.contexts.navigation.NavigationServicesAdapter;

public final class HasServices
extends NavigationServicesAdapter {
    private IExtLogger logger = null;

    @Override
    public void addStopOver(int n, AddressContainer addressContainer) {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("addStopOver()");
        }
    }

    @Override
    public void getGuidanceDestination() {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("getGuidanceDestination()");
        }
    }

    @Override
    public void getGuidanceState() {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("getGuidanceState()");
        }
    }

    @Override
    public void getLocation() {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("getLocation()");
        }
    }

    @Override
    public void saveDestination(int n, AddressContainer addressContainer) {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("saveDestination()");
        }
    }

    @Override
    public void startGuidance(int n, AddressContainer addressContainer) {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("startGuidance()");
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(75956480);
        eventGeneric.setInt(0, n);
        eventGeneric.setObject(1, addressContainer);
        ASLNavigationEventFactory.sendEventToTarget(1430983680, 1430983680, eventGeneric);
    }

    @Override
    public void stopGuidance(int n) {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("stopGuidance()");
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(92733696);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToTarget(1430983680, 1430983680, eventGeneric);
    }

    @Override
    public void getHeading() {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("getHeading()");
        }
    }

    @Override
    public void getGuidanceRemaining() {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("getGuidanceRemaining()");
        }
    }

    @Override
    public void resolveAddress(int n, AddressContainer addressContainer) {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("resolveAddress()");
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(109510912);
        eventGeneric.setInt(0, n);
        eventGeneric.setObject(1, addressContainer);
        ASLNavigationEventFactory.sendEventToTarget(1430983680, 1430983680, eventGeneric);
    }

    @Override
    public void resolveLastDestination(int n, LastDestinationContainer lastDestinationContainer) {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("resolveLastDestination()");
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(126288128);
        eventGeneric.setInt(0, n);
        eventGeneric.setObject(1, lastDestinationContainer);
        ASLNavigationEventFactory.sendEventToTarget(1430983680, 1430983680, eventGeneric);
    }

    @Override
    public void getLastDestinations() {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("getLastDestinations()");
        }
    }

    private IExtLogger getLogger() {
        if (this.logger == null) {
            this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "HasServices:");
        }
        return this.logger;
    }

    @Override
    public void importGPX(int n, ImportGPXDataContainer importGPXDataContainer) {
        if (this.getLogger().isTraceEnabled()) {
            this.getLogger().trace("importGPX()");
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(143065344);
        eventGeneric.setInt(0, n);
        eventGeneric.setObject(1, importGPXDataContainer);
        ASLNavigationEventFactory.sendEventToTarget(1430983680, 1430983680, eventGeneric);
    }
}

