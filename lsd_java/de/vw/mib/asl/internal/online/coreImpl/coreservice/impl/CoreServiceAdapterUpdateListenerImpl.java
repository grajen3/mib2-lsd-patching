/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.TrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.util.Util;

public class CoreServiceAdapterUpdateListenerImpl
implements CoreServiceAdapterUpdateListener {
    @Override
    public void updateDevice(Device device, int n) {
        if (device != null) {
            CoreServiceImplFactory.getCoreServiceController().updateDeviceList(device, n);
        }
    }

    @Override
    public void updateUserList(User[] userArray, int n) {
        CoreServiceImplFactory.getCoreServiceController().updateUserList(userArray, n);
        if (Util.isNullOrEmpty(userArray) || Util.isNullOrEmpty(CoreServiceImplFactory.getCoreServiceController().getMainUserEnrolled())) {
            CoreServiceImplFactory.getAuthentication().deleteMainUserName(true);
        } else {
            CoreServiceImplFactory.getAuthentication().setMainUserName(CoreServiceImplFactory.getCoreServiceController().getMainUserEnrolled());
        }
    }

    @Override
    public void updateServiceList(Service[] serviceArray, int n) {
        CoreServiceImplFactory.getCoreServiceController().updateServiceList(serviceArray, n);
    }

    @Override
    public void updateService(Service service, int n) {
        CoreServiceImplFactory.getCoreServiceController().updateService(service, n);
    }

    @Override
    public void updateRegistrationStatus(int n, int n2) {
        CoreServiceImplFactory.getCoreServiceNotifier().updateRegistrationStatus(n);
    }

    @Override
    public void updateDeviceStatus(int n, int n2) {
        CoreServiceImplFactory.getCoreServiceController().updateDeviceStatusAvailability(n, n2);
    }

    @Override
    public void updateTrackingServicesActivation(TrackingService[] trackingServiceArray, int n) {
    }

    @Override
    public void updatePrimaryUserDeviceStatus(boolean bl, int n) {
        CoreServiceImplFactory.getCoreServiceController().updatePrimaryUserInfo(bl);
    }

    @Override
    public void updatePrivacyModeStatus(boolean bl, int n) {
        CoreServiceImplFactory.getPrivacyModeHandler().updatePrivacyModeStatus(bl, n);
    }

    @Override
    public void updateServiceListState(int n, int n2) {
        CoreServiceImplFactory.getCoreServiceController().updateServiceListState(n, n2);
        CoreServiceImplFactory.getStatusBarHandler().updateStatusBarState(n, n2);
        CoreServiceImplFactory.getAuthentication().updateServiceListState(n, n2);
    }

    @Override
    public void updateCumulativeServiceListState(int n, int n2) {
        CoreServiceImplFactory.getCoreServiceController().updateCumulativeServiceListState(n, n2);
    }
}

