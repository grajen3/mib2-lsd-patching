/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkUser;
import de.vw.mib.asl.api.system.powerstate.ClampSignalAdapter;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.CoreServiceOCUFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control.CoreServiceOCUTransformer;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.states.CoreServiceOCUTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Application;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.util.Util;

public class CoreServiceOCUController
extends ClampSignalAdapter {
    private final String _classname = super.getClass().getName();
    private final CoreServiceOCUTarget _target;
    private Device _ocuDevice;
    private Application[] _applicationList;
    private Service[] _serviceList;
    private User[] _userList;
    private int _ocuAvailable = -1;
    private CoreServiceOCUTransformer _transformer;
    private OnlineNetworkServiceListEntry[] _ocuServiceList;
    private OnlineNetworkUser[] _ocuUserList;
    private int _registrationState = 0;
    private boolean _updateRequired;
    private boolean _privacyMode;

    public CoreServiceOCUController(CoreServiceOCUTarget coreServiceOCUTarget) {
        this._target = coreServiceOCUTarget;
    }

    private CoreServiceOCUTransformer getTransformer() {
        if (this._transformer == null) {
            this._transformer = new CoreServiceOCUTransformer();
        }
        return this._transformer;
    }

    private boolean isUserRegisteredAndValid() {
        if (this._target.getNetworkService().getOnlineNetworkUserList().getListState().value() == 3 && !Util.isNullOrEmpty(this.getUserList())) {
            int n = this.getUserList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (this.getUserList()[i2] == null || !this.getUserList()[i2].isMainUser()) continue;
                return true;
            }
        }
        return false;
    }

    private void syncAndUpdateInfo(OnlineNetworkServiceListEntry[] onlineNetworkServiceListEntryArray) {
        this.setOcuServiceList(onlineNetworkServiceListEntryArray);
        this._serviceList = this.getTransformer().transformToServices(onlineNetworkServiceListEntryArray, this._serviceList, this._target.getDeviceID(), this.isUserRegisteredAndValid());
        CoreServiceOCUFactory.getNotifier().updateDevice(this._ocuDevice, this._target.getDeviceID());
    }

    private void sendDeviceStatus(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".sendDeviceStatus(").append(n).append(")").toString()).log();
        }
        switch (n) {
            case 0: 
            case 1: {
                this._target.sendDeviceAvailability(0);
                break;
            }
            case 2: {
                this._target.sendDeviceAvailability(1);
                break;
            }
            case 3: {
                this._target.sendDeviceAvailability(2);
                break;
            }
            default: {
                this._target.sendDeviceAvailability(-1);
            }
        }
    }

    private int handleDeviceRegisteredStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkSupportedServices onlineNetworkSupportedServices) {
        int n = this.getNetworkAvailability();
        int n2 = 0;
        if (onlineNetworkService.getOnlineNetworkServiceStatus().isCommunicationAvailable()) {
            n2 = onlineNetworkSupportedServices.isNetworkOnlineServicesAccessible() ? 1 : 2;
        } else {
            n = 2;
        }
        if (n != this._ocuAvailable) {
            this._ocuAvailable = n;
            this._ocuDevice = this.getTransformer().updateDeviceConnectionStatus(this._ocuDevice, this._ocuAvailable, this.isUserRegisteredAndValid());
            CoreServiceOCUFactory.getNotifier().updateDevice(this._ocuDevice, this._target.getDeviceID());
            this.sendDeviceStatus(this._ocuAvailable);
        }
        this._target.sendRegisteredDeviceType(n2);
        return n2;
    }

    public void updateUserList(OnlineNetworkList onlineNetworkList) {
        if (onlineNetworkList != null && !onlineNetworkList.getListData().isEmpty() && onlineNetworkList.getListState().value() == 3) {
            this._target.info().append(this._classname).append(new StringBuffer().append(".updateUserList( ").append(onlineNetworkList.getListData().size()).append(")").toString()).log();
            OnlineNetworkUser[] onlineNetworkUserArray = new OnlineNetworkUser[onlineNetworkList.getListData().size()];
            System.arraycopy((Object)onlineNetworkList.getListData().toArray(), 0, (Object)onlineNetworkUserArray, 0, onlineNetworkList.getListData().size());
            this._userList = this.getTransformer().transformToUsers(onlineNetworkUserArray, this._userList);
            this.setRegistrationState(1);
        } else {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".updateUserList( EMPTY_LIST)").log();
            }
            this.setRegistrationState(onlineNetworkList != null && onlineNetworkList.getListState().value() == 3 ? 2 : 3);
            this._userList = null;
        }
        CoreServiceOCUFactory.getNotifier().updateRegistrationStatus(this.getRegistrationState(), this._target.getDeviceID());
        this._ocuDevice = this.getTransformer().transformToDeviceWithUserList(this._userList, this.getDevice());
        CoreServiceOCUFactory.getNotifier().updateUserList(this._userList, this._target.getDeviceID());
        this.syncAndUpdateInfo(this.getOcuServiceList());
    }

    public void updateServiceStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceStatus onlineNetworkServiceStatus) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateServiceStatus(").append(onlineNetworkServiceStatus.isServiceUserActionsBlocked()).append(")").toString()).log();
        }
        int n = this.getNetworkAvailability();
        int n2 = 0;
        if (onlineNetworkServiceStatus.isCommunicationAvailable()) {
            n2 = onlineNetworkService.getOnlineNetworkSupportedServices().isNetworkOnlineServicesAccessible() ? 1 : 2;
        } else {
            n = 2;
        }
        if (n != this._ocuAvailable) {
            this._ocuAvailable = n;
            this._ocuDevice = this.getTransformer().updateDeviceConnectionStatus(this._ocuDevice, this._ocuAvailable, this.isUserRegisteredAndValid());
            CoreServiceOCUFactory.getNotifier().updateDevice(this._ocuDevice, this._target.getDeviceID());
            this.sendDeviceStatus(this._ocuAvailable);
        }
        this._target.sendRegisteredDeviceType(n2);
    }

    public void updatePrivacyMode(boolean bl) {
        this.setPrivacyMode(bl);
        if (!CoreServiceOCUFactory.getNotifier().sendPrivacyModeStatusResponse(0, this._target.getDeviceID())) {
            CoreServiceOCUFactory.getNotifier().updatePrivacyModeStatus(bl, this._target.getDeviceID());
        }
    }

    public void updateServiceListState(int n) {
        if (n >= 1) {
            CoreServiceOCUFactory.getNotifier().updateServiceListState(n == 1 ? 2 : n, this._target.getDeviceID());
        }
    }

    public int verifyUser(User user) {
        int n = 30;
        if (user != null && user.isMainUser()) {
            n = 0;
        }
        return n;
    }

    public void checkServiceStatus(String string) {
        OnlineNetworkServiceListEntry onlineNetworkServiceListEntry;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".checkServiceStatus(").append(Util.isNullOrEmpty(string) ? string : "null").append(")").toString()).log();
        }
        int n = 0;
        if (!Util.isNullOrEmpty(string) && (onlineNetworkServiceListEntry = this.getServiceEntryWithServiceID(string)) == null) {
            n = 59;
        }
        CoreServiceOCUFactory.getNotifier().checkServiceStatusResponse(string, n);
    }

    public void setServiceStateResponse(String string) {
        CoreServiceOCUFactory.getNotifier().serviceStateResponse(this.getServiceWithServiceID(string));
    }

    public void forceOwnerValidation() {
        CoreServiceOCUFactory.getNotifier().forceValidationresponse(0);
    }

    public void checkForRegistrationStatus() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".checkForRegistrationStatus()").log();
        }
        int n = 0;
        if (this._target.getNetworkService().getOnlineNetworkServiceStatus().isCommunicationAvailable()) {
            if (this._target.getNetworkService().getOnlineNetworkSupportedServices().isNetworkOnlineServicesAccessible()) {
                n = 1;
                if (this.getRegistrationState() != 1) {
                    int n2 = 3;
                    if (Util.isNullOrEmpty(this.getUserList())) {
                        if (this._target.getNetworkService().getOnlineNetworkUserList().getListState().value() == 3 || this._target.getNetworkService().getOnlineNetworkUserList().getListState().value() == 2) {
                            OnlineNetworkServiceListEntry onlineNetworkServiceListEntry;
                            if (this._target.getNetworkService().getOnlineNetworkUserList().getListState().value() == 3 && this._target.getNetworkService().getOnlineNetworkUserList().getListData().size() > 0) {
                                this.updateUserList(this._target.getNetworkService().getOnlineNetworkUserList());
                                this._target.sendRegisteredDeviceType(n);
                                return;
                            }
                            n2 = this._target.getNetworkService().getOnlineNetworkServiceList().getListState().value() == 3 ? ((onlineNetworkServiceListEntry = this.getServiceEntryWithServiceID("owner_v1")) != null ? 2 : 3) : 2;
                        }
                    } else {
                        n2 = 1;
                    }
                    this.setRegistrationState(n2);
                    CoreServiceOCUFactory.getNotifier().updateRegistrationStatus(this.getRegistrationState(), this._target.getDeviceID());
                }
            } else {
                n = 2;
                this._target.sendDeviceAvailability(2);
            }
        } else {
            this._target.sendDeviceAvailability(1);
        }
        this._target.sendRegisteredDeviceType(n);
    }

    public void updateServiceList(OnlineNetworkList onlineNetworkList) {
        this._target.info().append(this._classname).append(new StringBuffer().append(".updateServiceList(").append(onlineNetworkList.getListData().size()).append(")").toString()).log();
        if (onlineNetworkList.getListData().isEmpty() && Util.isNullOrEmpty(this.getUserList())) {
            this.setRegistrationState(3);
            CoreServiceOCUFactory.getNotifier().updateRegistrationStatus(this.getRegistrationState(), this._target.getDeviceID());
        }
        this._ocuDevice = this.getTransformer().transformToDevice((OnlineNetworkServiceListEntry[])onlineNetworkList.getListData().toArray(new OnlineNetworkServiceListEntry[onlineNetworkList.getListData().size()]), this._ocuDevice, this.isUserRegisteredAndValid());
        this._ocuDevice = this.getTransformer().updateDeviceConnectionStatus(this._ocuDevice, this.getNetworkAvailability(), this.isUserRegisteredAndValid());
        this.syncAndUpdateInfo((OnlineNetworkServiceListEntry[])onlineNetworkList.getListData().toArray(new OnlineNetworkServiceListEntry[onlineNetworkList.getListData().size()]));
    }

    public void updateTrackingServices(OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        this._ocuDevice = CoreServiceOCUFactory.getTrackingServicesHandler().updateTrackingInfo(this._ocuDevice, onlineNetworkTrackingServices);
        this._ocuDevice = this.getTransformer().updateDeviceConnectionStatus(this._ocuDevice, this.getNetworkAvailability(), this.isUserRegisteredAndValid());
        if (!Util.isNullOrEmpty(this.getOcuServiceList())) {
            this.syncAndUpdateInfo(this.getOcuServiceList());
        }
    }

    public void setServiceStateResponse(OnlineNetworkServiceListEntry onlineNetworkServiceListEntry) {
        Service service = this.getTransformer().mapToInternalService(onlineNetworkServiceListEntry, null, this._target.getDeviceID(), this.isUserRegisteredAndValid());
        CoreServiceOCUFactory.getNotifier().serviceStateResponse(service);
    }

    public boolean isPrivacyMode() {
        return this._privacyMode;
    }

    public void setPrivacyMode(boolean bl) {
        this._privacyMode = bl;
    }

    public void setTrackingServicesUpdateRequired(boolean bl) {
        this._updateRequired = bl;
    }

    public boolean getTrackingServicesUpdateRequired() {
        return this._updateRequired;
    }

    public int getNetworkAvailability() {
        this._ocuAvailable = this._target.getNetworkService().getOnlineNetworkSupportedServices().isNetworkOnlineServicesAccessible() ? (this._target.getNetworkService().getOnlineNetworkServiceStatus().getConnectionToCellularNetworkState().value() == 2 ? 0 : 1) : 3;
        return this._ocuAvailable;
    }

    public int setNetworkAvailability(OnlineNetworkService onlineNetworkService) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setNetworkAvailability()").log();
        }
        if (this._ocuAvailable <= -1 || this._ocuAvailable == 3) {
            CoreServiceOCUFactory.getTrackingServicesHandler().setOnlineNetworkTrackingServices(onlineNetworkService.getOnlineNetworkTrackingServices());
            if (onlineNetworkService.getOnlineNetworkSupportedServices().isNetworkOnlineServicesAccessible() && this.getRegistrationState() != 1) {
                CoreServiceFactory.getAdapterRegister().isReady(this._target.getDeviceID());
                if (onlineNetworkService.getOnlineNetworkUserList().getListState().value() == 3) {
                    this.updateUserList(onlineNetworkService.getOnlineNetworkUserList());
                }
                int n = 3;
                if (Util.isNullOrEmpty(this.getUserList())) {
                    if (this._target.getNetworkService().getOnlineNetworkUserList().getListState().value() == 3 || this._target.getNetworkService().getOnlineNetworkUserList().getListState().value() == 2) {
                        OnlineNetworkServiceListEntry onlineNetworkServiceListEntry;
                        n = this._target.getNetworkService().getOnlineNetworkServiceList().getListState().value() == 3 ? ((onlineNetworkServiceListEntry = this.getServiceEntryWithServiceID("owner_v1")) != null ? 2 : 3) : 2;
                    }
                } else {
                    n = 1;
                }
                this.setRegistrationState(n);
                CoreServiceOCUFactory.getNotifier().updateRegistrationStatus(this.getRegistrationState(), this._target.getDeviceID());
            }
        }
        this.updateServiceListState(onlineNetworkService.getServiceListSynchronisationState() != null ? (onlineNetworkService.getServiceListSynchronisationState().value() < 3 ? 2 : onlineNetworkService.getServiceListSynchronisationState().value()) : 2);
        if (onlineNetworkService.getOnlineNetworkServiceList().getListState().value() == 3) {
            this.updateServiceList(onlineNetworkService.getOnlineNetworkServiceList());
        }
        this.updatePrivacyMode(onlineNetworkService.getPrivacyModeActive());
        return this.handleDeviceRegisteredStatus(onlineNetworkService, onlineNetworkService.getOnlineNetworkSupportedServices());
    }

    public void setServiceAvailability(OnlineNetworkSupportedServices onlineNetworkSupportedServices) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setServiceAvailability()").log();
        }
        if (onlineNetworkSupportedServices.isNetworkOnlineServicesAccessible() && CoreServiceFactory.getAdapterRegister().getAdapterWithID(1) == null) {
            CoreServiceFactory.getAdapterRegister().registerAdapter(1, 1, CoreServiceOCUFactory.getAdapter(this._target));
        }
        this._target.sendDeviceAvailability(0);
    }

    public void setRegistrationState(int n) {
        this._registrationState = n;
    }

    public int getRegistrationState() {
        return this._registrationState;
    }

    public OnlineNetworkServiceListEntry[] getOcuServiceList() {
        return this._ocuServiceList;
    }

    public void setOcuServiceList(OnlineNetworkServiceListEntry[] onlineNetworkServiceListEntryArray) {
        this._ocuServiceList = onlineNetworkServiceListEntryArray;
    }

    public OnlineNetworkServiceListEntry getServiceEntryWithServiceID(String string) {
        if (!Util.isNullOrEmpty(this._ocuServiceList) && !Util.isNullOrEmpty(string)) {
            int n = this._ocuServiceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._ocuServiceList[i2].getServiceId().equalsIgnoreCase(string)) continue;
                return this._ocuServiceList[i2];
            }
        }
        return null;
    }

    public OnlineNetworkServiceListEntry getServiceEntryFromServiceList(String string, OnlineNetworkServiceListEntry[] onlineNetworkServiceListEntryArray) {
        if (!Util.isNullOrEmpty(onlineNetworkServiceListEntryArray) && !Util.isNullOrEmpty(string)) {
            int n = onlineNetworkServiceListEntryArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!onlineNetworkServiceListEntryArray[i2].getServiceId().equalsIgnoreCase(string)) continue;
                return onlineNetworkServiceListEntryArray[i2];
            }
        }
        return null;
    }

    public OnlineNetworkServiceListEntry getServiceEntryWithServiceName(String string) {
        if (!Util.isNullOrEmpty(this._ocuServiceList) && !Util.isNullOrEmpty(string)) {
            int n = this._ocuServiceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._ocuServiceList[i2].getServiceName().equalsIgnoreCase(string)) continue;
                return this._ocuServiceList[i2];
            }
        }
        return null;
    }

    public Service getServiceWithServiceID(String string) {
        if (!Util.isNullOrEmpty(this._serviceList) && !Util.isNullOrEmpty(string)) {
            int n = this._serviceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._serviceList[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this._serviceList[i2];
            }
        }
        return null;
    }

    public OnlineNetworkUser[] getOcuUserList() {
        return this._ocuUserList;
    }

    public void setOcuUserList(OnlineNetworkUser[] onlineNetworkUserArray) {
        this._ocuUserList = onlineNetworkUserArray;
    }

    public OnlineNetworkUser getNetworkUserWithName(String string) {
        if (!Util.isNullOrEmpty(this._ocuUserList) && !Util.isNullOrEmpty(string)) {
            int n = this._ocuUserList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._ocuUserList[i2].getUserName().equalsIgnoreCase(string)) continue;
                return this._ocuUserList[i2];
            }
        }
        return null;
    }

    public User[] getUserList() {
        return this._userList;
    }

    public Application[] getApplicationList() {
        return this._applicationList;
    }

    public Service[] getServiceList() {
        return this._serviceList;
    }

    public Device getDevice() {
        return this._ocuDevice;
    }

    @Override
    public void onClamp15ValueChanged(boolean bl) {
    }
}

