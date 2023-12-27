/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeService;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotification;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotificationTimer;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingServiceImpl$1;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingTestmodeListener;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingTransitionDoneListener;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingVehicleListener;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

class ValetParkingServiceImpl
implements ValetParkingService {
    private final AsyncServiceFactory asyncServiceFactory;
    private boolean currentVehicleValetParkingState;
    private boolean lastValetParkingServiceStateNotified;
    private Map listenerProxyMap = new IdentityHashMap();
    private final Logger logger;
    private ValetParkingNotification notification;
    private final ValetParkingNotificationTimer timer;
    private final ValetParkingTransitionDoneListener transitionDoneListener;

    ValetParkingServiceImpl(SystemServices systemServices, ValetParkingNotificationTimer valetParkingNotificationTimer, boolean bl) {
        this.asyncServiceFactory = systemServices.getAsyncServiceFactory();
        this.logger = systemServices.getAsl1Logger();
        this.timer = valetParkingNotificationTimer;
        this.transitionDoneListener = this.createTransitionDoneListener();
        this.currentVehicleValetParkingState = bl;
        this.lastValetParkingServiceStateNotified = bl;
        this.addCarVehicleApiListener(systemServices.getAslCarVehicleApi());
        this.addTestmodeValetParkingListener(systemServices.getValetParkingTestmodeService());
    }

    @Override
    public void addListener(ValetParkingListener valetParkingListener) {
        if (valetParkingListener == null) {
            throw new IllegalArgumentException("A new listener must not be null.");
        }
        Object object = this.asyncServiceFactory.create(valetParkingListener);
        this.listenerProxyMap.put(valetParkingListener, object);
    }

    @Override
    public boolean getCurrentValetParkingState() {
        return this.lastValetParkingServiceStateNotified;
    }

    @Override
    public void removeListener(ValetParkingListener valetParkingListener) {
        this.listenerProxyMap.remove(valetParkingListener);
    }

    void notifyServiceOnValetParkingStateChanged(boolean bl) {
        this.currentVehicleValetParkingState = bl;
        this.makeValetParkingTransition();
    }

    void notifyTransitionDone() {
        this.notification = null;
        this.timer.stopTimer();
        this.makeValetParkingTransition();
    }

    private void addCarVehicleApiListener(ASLCarVehicleAPI aSLCarVehicleAPI) {
        aSLCarVehicleAPI.addVehicleServiceListener(new ValetParkingVehicleListener(this, aSLCarVehicleAPI));
    }

    private void addTestmodeValetParkingListener(ValetParkingTestmodeService valetParkingTestmodeService) {
        valetParkingTestmodeService.addListener(new ValetParkingTestmodeListener(this));
    }

    private void createNotification(boolean bl) {
        Map map = Collections.unmodifiableMap(this.listenerProxyMap);
        this.notification = new ValetParkingNotification(map, bl, this.transitionDoneListener, this.logger);
        this.timer.createTimeoutNotification(this.notification.getTimeoutListener());
    }

    private ValetParkingTransitionDoneListener createTransitionDoneListener() {
        return new ValetParkingServiceImpl$1(this);
    }

    private boolean isNotificationInProgress() {
        return this.notification != null;
    }

    private boolean isNotificationRequired() {
        return !this.listenerProxyMap.isEmpty();
    }

    private boolean isTransitionRequired() {
        return this.lastValetParkingServiceStateNotified != this.currentVehicleValetParkingState;
    }

    private void makeValetParkingStateChange() {
        this.lastValetParkingServiceStateNotified = this.currentVehicleValetParkingState;
    }

    private void makeValetParkingTransition() {
        if (!this.isNotificationInProgress() && this.isTransitionRequired()) {
            this.makeValetParkingStateChange();
            if (this.isNotificationRequired()) {
                this.createNotification(this.currentVehicleValetParkingState);
            }
        }
    }
}

