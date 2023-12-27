/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.internal.system.input.UserInteractionLockServiceImpl$1;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;

public class UserInteractionLockServiceImpl
implements UserInteractionLockService {
    boolean isValetParkingActive;
    private final SystemEventDispatcher systemEventDispatcher;

    public UserInteractionLockServiceImpl(SystemEventDispatcher systemEventDispatcher, ValetParkingService valetParkingService) {
        Preconditions.checkArgumentNotNull(systemEventDispatcher);
        Preconditions.checkArgumentNotNull(valetParkingService);
        this.systemEventDispatcher = systemEventDispatcher;
        this.isValetParkingActive = valetParkingService.getCurrentValetParkingState();
        valetParkingService.addListener(this.createValetParkingListener());
    }

    @Override
    public void onUserInteraction() {
        if (this.isValetParkingActive) {
            this.systemEventDispatcher.createAndSubmitHMIEvent(1832001536);
        }
    }

    private ValetParkingListener createValetParkingListener() {
        return new UserInteractionLockServiceImpl$1(this);
    }
}

