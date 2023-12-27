/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weather;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.TravelLinkTarget;
import de.vw.mib.asl.internal.travellink.weather.StateTopWeather;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

public final class TargetWeather
extends TargetHsmImpl
implements TravelLinkTarget {
    private final HsmState stateTopWeather = new StateTopWeather(this.getHsm(), "stateTopWeather", null);

    public TargetWeather(GenericEvents genericEvents) {
        super(genericEvents);
        this.registerObservers();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1076041826: {
                int n = eventGeneric.getInt(0);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateSelectedWeatherTab(n);
                break;
            }
        }
    }

    @Override
    public void registerObservers() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("TargetWeather - registerObservers()").log();
        }
        this.addObserver(1645749056);
    }

    @Override
    public void registerDsiListeners() {
    }

    public HsmState getStateTopWeather() {
        return this.stateTopWeather;
    }
}

