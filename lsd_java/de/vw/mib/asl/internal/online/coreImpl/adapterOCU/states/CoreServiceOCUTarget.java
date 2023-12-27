/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.states;

import de.vw.mib.asl.api.ocu.OCUServiceProvider;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListener;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceProvider;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.CoreServiceOCUFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl.OnlineNetworkServiceListenerImpl;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class CoreServiceOCUTarget
extends AbstractTarget
implements AdaptionResponse {
    private final String _classname = super.getClass().getName();
    private OnlineNetworkServiceListener _networkServiceListener;
    private final int _deviceID;
    private boolean _OCUWithCoreServices;

    public CoreServiceOCUTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this._deviceID = 1;
    }

    private void startUp() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startUp()").log();
        }
        this.info().append("**** OCU2 adapter Target started ****").log();
        int n = 0;
        this._networkServiceListener = new OnlineNetworkServiceListenerImpl(this);
        this.getNetworkServiceProvider().registerOnlineNetworkServiceListener(this._networkServiceListener);
        if (this.getNetworkService().getOnlineNetworkSupportedServices().isNetworkOnlineServicesAccessible()) {
            CoreServiceFactory.getAdapterRegister().registerAdapter(1, 1, CoreServiceOCUFactory.getAdapter(this));
            this.sendDeviceAvailability(0);
        } else {
            this.sendDeviceAvailability(2);
        }
        n = this.getNetworkService().getOnlineNetworkServiceStatus().isCommunicationAvailable() ? CoreServiceOCUFactory.getController(this).setNetworkAvailability(this.getNetworkService()) : 2;
        if (n != 1) {
            this.sendRegisteredDeviceType(n);
        }
    }

    private void shutDown() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".shutDown()").log();
        }
        CoreServiceFactory.getAdapterRegister().unRegisterAdapter(1);
        this.getNetworkServiceProvider().unRegisterOnlineNetworkServiceListener(this._networkServiceListener);
    }

    public OnlineNetworkServiceProvider getNetworkServiceProvider() {
        return OCUServiceProvider.getServiceProvider().getOnlineNetworkService(OCUServiceProvider.NETWORK_SERVICE_VERSION_1_0);
    }

    public OnlineNetworkService getNetworkService() {
        return this.getNetworkServiceProvider().getOnlineNetworkService();
    }

    public int getDeviceID() {
        return 1;
    }

    public void sendRegisteredDeviceType(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(new StringBuffer().append(".sendRegisteredDeviceType(").append(n).append(")").toString()).log();
        }
        CoreServiceFactory.getExternalUpdateListener().updateRegisteredDeviceType(n, this.getDeviceID());
    }

    public void sendDeviceAvailability(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(new StringBuffer().append(".sendDeviceAvailability(").append(n).append(")").toString()).log();
        }
        if (!this._OCUWithCoreServices) {
            CoreServiceFactory.getExternalUpdateListener().updateDeviceStatusAvailability(n, this.getDeviceID());
        }
        if (n == 0) {
            ClampSignalService clampSignalService = ASLSystemFactory.getSystemApi().getClampSignalService();
            CoreServiceOCUFactory.getController(this).onClamp15ValueChanged(clampSignalService.isCurrentClamp15Activated());
            clampSignalService.addListener(CoreServiceOCUFactory.getController(this));
            this._OCUWithCoreServices = true;
        }
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public int getDefaultTargetId() {
        return 913184256;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
                this.info().append("Tracking Service Adaptation registeration started").log();
                ServiceManager.adaptionApi.requestAdaptation(this);
                this.startUp();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_OFF)").log();
                }
                this.shutDown();
                break;
            }
            case 100002: {
                CoreServiceOCUFactory.getController(this).forceOwnerValidation();
                break;
            }
            case 100001: {
                String string = eventGeneric.getString(0);
                CoreServiceOCUFactory.getController(this).checkServiceStatus(string);
                break;
            }
            case 100003: {
                String string = eventGeneric.getString(0);
                CoreServiceOCUFactory.getController(this).setServiceStateResponse(string);
                break;
            }
        }
    }

    @Override
    public void onSuccess(Access access) {
        if (access != null && access.contains(1217)) {
            this.info().append(this._classname).append(".onSuccess(Adaptation.ID_ACTIVATION_DEACTIVATION_OF_POPUPS_FOR_ACTIVE_TRACKING_SERVICES)").log();
            byte[] byArray = access.getByteArray(1217);
            if (byArray != null && byArray.length > 0) {
                int[] nArray = new int[byArray.length];
                int n = 0;
                while (n < byArray.length) {
                    nArray[n] = byArray[n++];
                }
                CoreServiceOCUFactory.getTrackingServicesHandler().setTrackingServicesCoding(nArray);
                CoreServiceFactory.getExternalRegister().registerExternal(CoreServiceOCUFactory.getExternal(this));
            }
        }
    }

    @Override
    public void onError() {
    }
}

