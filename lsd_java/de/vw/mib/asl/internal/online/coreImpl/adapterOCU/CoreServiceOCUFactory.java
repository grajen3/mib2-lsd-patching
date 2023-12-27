/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control.CoreServiceOCUController;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control.CoreServiceOCUNotifier;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control.CoreSeviceOCUTrackingServicesHandler;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl.CoreServiceOCUAdapterImpl;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl.CoreServiceOCUExternalImpl;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl.OnlineNetworkServiceResponseListenerImpl;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.states.CoreServiceOCUTarget;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternal;

public final class CoreServiceOCUFactory {
    private static CoreServiceAdapter _adapterImpl;
    private static CoreServiceOCUController _controller;
    private static CoreServiceOCUNotifier _notifier;
    private static Device _device;
    private static CoreServiceExternal _externalImpl;
    private static CoreSeviceOCUTrackingServicesHandler _trackingServicesHandler;

    public static OnlineNetworkServiceResponseListener getResponseListener() {
        return new OnlineNetworkServiceResponseListenerImpl();
    }

    public static CoreServiceAdapter getAdapter(CoreServiceOCUTarget coreServiceOCUTarget) {
        if (_adapterImpl == null && coreServiceOCUTarget != null) {
            _adapterImpl = new CoreServiceOCUAdapterImpl(coreServiceOCUTarget);
        }
        return _adapterImpl;
    }

    public static CoreServiceOCUController getController(CoreServiceOCUTarget coreServiceOCUTarget) {
        if (_controller == null && coreServiceOCUTarget != null) {
            _controller = new CoreServiceOCUController(coreServiceOCUTarget);
        }
        return _controller;
    }

    public static CoreServiceOCUNotifier getNotifier() {
        if (_notifier == null) {
            _notifier = new CoreServiceOCUNotifier();
        }
        return _notifier;
    }

    public static Device getOCUDevice() {
        if (_device == null) {
            _device = CoreServiceCommonFactory.getDeviceInstance(1, "OCU Device");
        }
        return _device;
    }

    public static CoreServiceExternal getExternal(CoreServiceOCUTarget coreServiceOCUTarget) {
        if (_externalImpl == null && coreServiceOCUTarget != null) {
            _externalImpl = new CoreServiceOCUExternalImpl(coreServiceOCUTarget);
        }
        return _externalImpl;
    }

    public static CoreSeviceOCUTrackingServicesHandler getTrackingServicesHandler() {
        if (_trackingServicesHandler == null) {
            _trackingServicesHandler = new CoreSeviceOCUTrackingServicesHandler();
            _trackingServicesHandler.createTrackingServices();
        }
        return _trackingServicesHandler;
    }
}

