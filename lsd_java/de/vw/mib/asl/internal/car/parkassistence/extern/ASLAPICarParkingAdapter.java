/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.extern;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.parkassistence.extern.ParkingMainController;
import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationAdapter;
import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationDelegate;
import de.vw.mib.asl.internal.parking.service.ParkingServiceImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class ASLAPICarParkingAdapter
extends AbstractTarget {
    private ParkingMainController parkingMainController;
    private ParkingAdaptationAdapter parkingAdaptationAdapter;
    private ParkingServiceImpl parkingServiceImpl = new ParkingServiceImpl();

    public ASLAPICarParkingAdapter(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.parkingMainController = new ParkingMainController(this);
        this.parkingAdaptationAdapter = new ParkingAdaptationAdapter();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(7)) {
            this.parkingAdaptationAdapter.register();
            this.parkingAdaptationAdapter.registerServiceListener((Object)this.parkingMainController, ParkingAdaptationDelegate.ADAPTATION_PROPERTIES);
            this.parkingAdaptationAdapter.registerServiceListener((Object)this.parkingMainController, ParkingAdaptationDelegate.ADAPTATION_LISTS);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -1706094080;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        eventGeneric.setSenderTargetId(this.getDefaultTargetId());
        eventGeneric.setReceiverTargetId(-2142301696);
        switch (n) {
            case 8: {
                this.registerModelEvents();
                break;
            }
        }
        if (eventGeneric.getReceiverEventId() != n) {
            this.getEventDispatcher().send(eventGeneric);
        }
    }

    private void registerModelEvents() {
        this.addObservers(new int[]{352926976, 10008, 10026, 10009, 10020});
    }
}

