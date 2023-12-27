/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServices;
import de.vw.mib.asl.internal.impl.gridmenu.AbstractGridMenuTarget;
import de.vw.mib.asl.internal.impl.gridmenu.GridMenuValetParking$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class GridMenuValetParking
extends AbstractGridMenuTarget {
    private final GridMenuServices gridMenuServices;
    private final UserInteractionLockService lockService;
    private final ValetParkingService valetParkingService;
    private final ASLPropertyManager propertyManager;

    public GridMenuValetParking(GridMenuServices gridMenuServices) {
        super(gridMenuServices.getGenericEvents(), gridMenuServices.getLogger(), -698017280);
        this.gridMenuServices = gridMenuServices;
        this.lockService = this.gridMenuServices.getSystemAPI().getUserInteractionLockService();
        this.valetParkingService = this.gridMenuServices.getSystemAPI().getValetParkingService();
        this.propertyManager = this.gridMenuServices.getASLPropertyManager();
    }

    public void run() {
        this.valetParkingService.addListener(this.createValetParkingListener());
        this.updateDataPool(this.valetParkingService.getCurrentValetParkingState());
        this.registerObservers(this.gridMenuServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1078541828: {
                this.lockService.onUserInteraction();
                break;
            }
        }
    }

    void updateDataPool(boolean bl) {
        this.propertyManager.valueChangedBoolean(325404928, bl);
    }

    private ValetParkingListener createValetParkingListener() {
        return new GridMenuValetParking$1(this);
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(71190848, this.getTargetId());
    }
}

