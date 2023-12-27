/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.control;

import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthenticationListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceAvailabilityListener;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.control.CoreServiceController$1;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.control.CoreServiceTransformer;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCarNetPinVerificationListener;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectObjectMultimap;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.configuration.FeatureFlagValueChangeReceiver;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import java.util.Iterator;

public class CoreServiceController
implements FeatureFlagValueChangeReceiver {
    private final String _classname = super.getClass().getName();
    private Device[] _currentDeviceList;
    private Service[] _completeServiceList;
    private User[] _completeUserList;
    private OnlineService[] _clientServiceList;
    private OnlineUser[] _userList;
    private CoreServiceTransformer _transformer;
    private boolean _isClientReady;
    private ObjectObjectMultimap _registeredServices;
    private ArrayList _listeners;
    private int _onlineServicesStatus = -1;
    private boolean _afterStartup;
    private int _statusbarStatus = -1;
    private CoreServiceCarNetPinVerificationListener _carNetPinListener;
    private int _carNetPinResult = -1;
    private OnlineUser _carNetPinUser;
    private IntArrayList _registeredDevices;
    private int _modListStateChange = 1;
    private ObjectArrayList _mainUserListener;
    private boolean _showPrimaryUserPopupIsPending;

    private CoreServiceTransformer getTransformer() {
        if (this._transformer == null) {
            this._transformer = new CoreServiceTransformer();
        }
        return this._transformer;
    }

    ObjectObjectMultimap getRegisteredServices() {
        if (this._registeredServices == null) {
            this._registeredServices = new ObjectObjectMultimap();
        }
        return this._registeredServices;
    }

    private ArrayList getListeners() {
        if (this._listeners == null) {
            this._listeners = new ArrayList();
        }
        return this._listeners;
    }

    private ObjectArrayList getMainUserListeners() {
        if (this._mainUserListener == null) {
            this._mainUserListener = new ObjectArrayList();
        }
        return this._mainUserListener;
    }

    private IntArrayList getRegisteredDevices() {
        if (this._registeredDevices == null) {
            this._registeredDevices = new IntArrayList();
        }
        return this._registeredDevices;
    }

    private boolean isMainDeviceRegistered() {
        if (!Util.isNullOrEmpty(this._currentDeviceList)) {
            int n = this._currentDeviceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._currentDeviceList[i2].isMainDevice()) continue;
                return true;
            }
        }
        return false;
    }

    private void syncLists(int n) {
        this._completeServiceList = this.getTransformer().extractServiceListFromDeviceList(this._currentDeviceList);
        this._completeUserList = this.getTransformer().extractUserListFromDeviceList(this._currentDeviceList);
        this._clientServiceList = this.getTransformer().transformToClientServiceList(this._completeServiceList, this._currentDeviceList, this._clientServiceList);
        this._userList = this.getTransformer().transformToClientUserList(this._completeUserList);
        CoreServiceImplFactory.getStatusBarHandler().updateClientServicelist(this._clientServiceList);
        this.sendServiceChangeNotifications();
        if (this._isClientReady) {
            this.clientReady();
            this._isClientReady = false;
        }
        if (this.isMainDeviceRegistered()) {
            switch (n) {
                case 1: 
                case 2: 
                case 3: 
                case 5: {
                    CoreServiceImplFactory.getCoreServiceNotifier().updateServiceList(this.getClientServiceList());
                    break;
                }
                case 4: {
                    CoreServiceImplFactory.getCoreServiceNotifier().updateUserList(this.getClientUserList());
                    if (Util.isNullOrEmpty(this.getClientUserList())) break;
                    this.updatePrimaryUserPopup();
                    break;
                }
            }
        }
    }

    private void sendServiceChangeNotifications() {
        if (!this.getRegisteredServices().isEmpty() && !Util.isNullOrEmpty(this.getServiceList())) {
            int n = this.getServiceList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.getServiceList()[i2].isServiceChanged() || !this.getRegisteredServices().containsKey(this.getServiceList()[i2].getServiceID())) continue;
                ObjectCollection objectCollection = this.getRegisteredServices().getAll(this.getServiceList()[i2].getServiceID());
                ObjectArrayList objectArrayList = new ObjectArrayList(objectCollection.size());
                objectArrayList.addAll(objectCollection);
                Iterator iterator = objectArrayList.iterator();
                while (iterator.hasNext()) {
                    ASLOnlineServiceListener aSLOnlineServiceListener = (ASLOnlineServiceListener)iterator.next();
                    aSLOnlineServiceListener.updateServiceStatusOnChange(this.getResultWithService(this.getServiceList()[i2]));
                }
                this.getServiceList()[i2].setServiceChanged(false);
            }
        }
    }

    private int getResultWithService(Service service) {
        int n = 0;
        if (service != null) {
            switch (service.getServiceState()) {
                case 0: {
                    n = 0;
                    break;
                }
                case 2: {
                    n = 4;
                    break;
                }
                case 3: {
                    n = 8;
                    break;
                }
                case 4: {
                    n = 7;
                    break;
                }
                case 5: {
                    n = 5;
                    break;
                }
                case 6: {
                    n = 3;
                    break;
                }
            }
            if (service.getEnabledState() == 2) {
                n = 3;
            }
        } else {
            n = 2;
        }
        return n;
    }

    private void sendCallBack(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".sendCallBack(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(")").toString()).log();
        }
        ServiceManager.aslThreadSwitch.enqueue(new CoreServiceController$1(this, string, aSLOnlineServiceListener));
    }

    private void updateAvailableListsOnStartup() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateAvailableListsOnStartup()").log();
        }
        if (!Util.isNullOrEmpty(this.getDeviceList())) {
            int n = this.getDeviceList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                CoreServiceImplFactory.getCoreServiceNotifier().updateDeviceReadyForUse(this.getDeviceList()[i2].getDeviceID());
            }
        }
        if (this.isMainDeviceRegistered()) {
            if (!Util.isNullOrEmpty(this.getClientUserList())) {
                CoreServiceImplFactory.getCoreServiceNotifier().updateRegistrationStatus(1);
                CoreServiceImplFactory.getCoreServiceNotifier().updateUserList(this.getClientUserList());
            }
            if (!Util.isNullOrEmpty(this.getClientServiceList())) {
                CoreServiceImplFactory.getCoreServiceNotifier().updateServiceList(this.getClientServiceList());
            }
            if (CoreServiceImplFactory.getPrivacyModeHandler().isPrivacyMode()) {
                CoreServiceImplFactory.getCoreServiceNotifier().updatePrivacyModeStatus(CoreServiceImplFactory.getPrivacyModeHandler().isPrivacyMode());
            }
        }
    }

    private void sendPinVerificationResponse(OnlineUser onlineUser, int n) {
        int n2 = CoreServiceMappingTable.convertToExternalOwnerVerificationResult(n);
        if (this._carNetPinListener != null) {
            this._carNetPinListener.verifyCarNetPinResponse(n2);
        } else {
            CoreServiceImplFactory.getCoreServiceNotifier().validatePinResponse(onlineUser, n2);
        }
        this._carNetPinListener = null;
        this._carNetPinResult = -1;
        this._carNetPinUser = null;
        this._modListStateChange = 1;
    }

    private void updatePrimaryUserPopup() {
        if (this._showPrimaryUserPopupIsPending) {
            int n = this._userList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (this._userList[i2].getUserType() != 1) continue;
                CoreServiceImplFactory.getCoreServiceNotifier().updatePrimaryUserPopupActivation(this._userList[i2]);
                break;
            }
            this._showPrimaryUserPopupIsPending = false;
        }
    }

    public void initPersistence() {
        ServiceManager.persistence.registerSharedPersistable(CoreServiceImplFactory.getPersistence());
        ServiceManager.persistence.loadPersistable(5022, 0, CoreServiceImplFactory.getPersistence());
    }

    public void clear() {
        this.getRegisteredDevices().clear();
    }

    public void resetToFactorySettings() {
        this.getRegisteredDevices().clear();
        this._userList = null;
        this._completeUserList = null;
        this._completeServiceList = null;
        this._currentDeviceList = null;
        this._showPrimaryUserPopupIsPending = false;
        CoreServiceImplFactory.getCoreServiceNotifier().updateServiceList(this._clientServiceList);
        CoreServiceImplFactory.getCoreServiceNotifier().updateRegistrationStatus(0);
    }

    public void checkServiceStatus(String string, String string2, OnlineUser onlineUser) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".checkServiceStatus(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(")").toString()).log();
        }
        object = null;
        if (!Util.isNullOrEmpty(string)) {
            object = this.getDeviceWithServiceID(string);
            Object object2 = object = object != null ? object : null;
            if (CoreServiceFactory.getAdapterRegister() != null && object != null) {
                CoreServiceAdapter coreServiceAdapter = CoreServiceFactory.getAdapterRegister().getAdapterWithID(object.getDeviceID());
                if (coreServiceAdapter != null) {
                    coreServiceAdapter.checkServiceStatus(string, this.getRealUserWithClientUser(onlineUser), CoreServiceImplFactory.getAdapterListener());
                }
            } else {
                CoreServiceImplFactory.getCoreServiceNotifier().checkAuthenticationResponse(!Util.isNullOrEmpty(string) ? string : "", 28);
            }
        }
    }

    public void clientReady() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".clientReady()").log();
        }
        if (!Util.isNullOrEmpty(this._currentDeviceList)) {
            if (CoreServiceFactory.getAdapterRegister().getMainAdapter() != null) {
                int n = CoreServiceFactory.getAdapterRegister().getMainAdapterID();
                Device device = this.getTransformer().getDeviceFromDeviceListWithDeviceID(n, this._currentDeviceList);
                if (device != null) {
                    Object[] objectArray;
                    int n2;
                    device.setDeviceType(1);
                    if (!Util.isNullOrEmpty(this.getDeviceList()) && this.getDeviceList().length > 1) {
                        int n3 = this.getDeviceList().length;
                        for (n2 = 0; n2 < n3; ++n2) {
                            if (this.getDeviceList()[n2].getDeviceID() == n) continue;
                            this.getDeviceList()[n2].setDeviceType(2);
                            if (Util.isNullOrEmpty(this.getUserList())) continue;
                            CoreServiceFactory.getAdapterRegister().getAdapterWithID(this.getDeviceList()[n2].getDeviceID()).forceOwnerValidation(true, null);
                        }
                    }
                    if (!Util.isNullOrEmpty(objectArray = CoreServiceFactory.getAdapterRegister().getAdapterList())) {
                        n2 = objectArray.length;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            objectArray[i2].setAsMainDevice(n);
                        }
                    }
                }
            }
            this.updateAvailableListsOnStartup();
        } else {
            this._isClientReady = true;
        }
    }

    public int getOnlineServicesStatus() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".getOnlineServicesStatus( Status = ").append(this._onlineServicesStatus).append(")").toString()).log();
        }
        return this._onlineServicesStatus;
    }

    public void handleOnlineServicesStatus() {
        if (!this._afterStartup) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".handleOnlineServicesStatus()").log();
            }
            this._onlineServicesStatus = ServiceManager.configManagerDiag.isFeatureFlagSet(392) ? -1 : (ServiceManager.configManagerDiag.isFeatureFlagSet(184) ? 0 : 1);
            ServiceManager.configManagerDiag.removeFeatureFlagValueChangeReceiver(this, 184);
            ServiceManager.configManagerDiag.removeFeatureFlagValueChangeReceiver(this, 392);
            ServiceManager.configManagerDiag.addFeatureFlagValueChangeReceiver(this, 184);
            ServiceManager.configManagerDiag.addFeatureFlagValueChangeReceiver(this, 392);
            this._afterStartup = true;
        }
    }

    @Override
    public void receiveFeatureFlagValue(int n, boolean bl) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".receiveFeatureFlagValue( featureFlag = ").append(n).append(", status = ").append(bl).append(")").toString()).log();
        }
        if (n == 184 || n == 392) {
            if (n == 392) {
                this._onlineServicesStatus = bl ? -1 : 1;
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(184)) {
                    this._onlineServicesStatus = 0;
                }
            } else if (n == 184) {
                this._onlineServicesStatus = bl ? 0 : 1;
            }
            if (!this.getListeners().isEmpty()) {
                object = this.getListeners().iterator();
                while (object.hasNext()) {
                    CoreServiceAvailabilityListener coreServiceAvailabilityListener = (CoreServiceAvailabilityListener)object.next();
                    coreServiceAvailabilityListener.updateOnlineServicesAvailabilityStatus(this._onlineServicesStatus);
                }
            }
        }
    }

    public void updateDeviceStatusAvailability(int n, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".updateDeviceStatusAvailability( Status = ").append(n).append(", DeviceID = ").append(n2).append(")").toString()).log();
        }
        switch (n) {
            case 0: {
                this._onlineServicesStatus = 0;
                ServiceManager.logger2.info(16384).append(n2 == 1 ? "**** OCU2 with CORE Services Available ****" : "**** MIB Services Available ****").log();
                break;
            }
            case 1: {
                this._onlineServicesStatus = 1;
                break;
            }
            case 2: {
                this._onlineServicesStatus = 1;
                object = CoreServiceFactory.getAdapterRegister().getAdapterList();
                if (Util.isNullOrEmpty((Object[])object)) break;
                int n3 = ((Object[])object).length;
                for (int i2 = 0; i2 < n3; ++i2) {
                    object[i2].setAsMainDevice(CoreServiceFactory.getAdapterRegister().getMainAdapterID());
                }
                this._onlineServicesStatus = 0;
                break;
            }
            default: {
                this._onlineServicesStatus = -1;
            }
        }
        if (!this.getListeners().isEmpty()) {
            object = this.getListeners().iterator();
            while (object.hasNext()) {
                CoreServiceAvailabilityListener coreServiceAvailabilityListener = (CoreServiceAvailabilityListener)object.next();
                coreServiceAvailabilityListener.updateOnlineServicesAvailabilityStatus(this._onlineServicesStatus);
            }
        }
    }

    public void updateRegisteredDeviceType(int n, int n2) {
        int n3;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateRegisteredDeviceType( Type = ").append(n).append(", DeviceID = ").append(n2).append(")").toString()).log();
        }
        if ((n3 = CoreServiceFactory.getAdapterRegister().getMainAdapterID()) != n2 && n == 2) {
            n = 3;
        }
        CoreServiceImplFactory.getCoreServiceNotifier().updateRegisteredDeviceType(n);
    }

    public void updateDeviceList(Device device, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".updateDeviceList( DeviceID = ").append(n).append(")").toString()).log();
        }
        if (device != null) {
            object = this.getTransformer().getDeviceFromDeviceListWithDeviceID(device.getDeviceID(), this._currentDeviceList);
            if (object == null) {
                this._isClientReady = true;
            }
            this._currentDeviceList = this.getTransformer().addOrUpdateDeviceToDeviceList(device, this._currentDeviceList, n);
            this.syncLists(1);
            if (this._carNetPinResult > -1 && this._modListStateChange > 1) {
                this.sendPinVerificationResponse(this._carNetPinUser, this._carNetPinResult);
            }
        }
    }

    public void updateServiceList(Service[] serviceArray, int n) {
        if (!Util.isNullOrEmpty(serviceArray)) {
            this._currentDeviceList = this.getTransformer().updateServiceListToDeviceList(serviceArray, this._currentDeviceList, n);
            this.syncLists(3);
        }
    }

    public void updateServiceListState(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateServiceListState( DeviceID = ").append(n2).append(", state = ").append(n).append(")").toString()).log();
        }
        this._modListStateChange = n;
    }

    public void updateService(Service service, int n) {
    }

    public void updateUserList(User[] userArray, int n) {
        if (!Util.isNullOrEmpty(this.getDeviceList()) && this.getDeviceList().length > 1) {
            for (int i2 = 0; i2 < this.getDeviceList().length; ++i2) {
                if (this.getDeviceList()[i2].isMainDevice()) continue;
                if (!Util.isNullOrEmpty(userArray) && Util.isNullOrEmpty(this.getUserList()) && this.hasMainUser(userArray)) {
                    CoreServiceFactory.getAdapterRegister().getAdapterWithID(this.getDeviceList()[i2].getDeviceID()).forceOwnerValidation(true, null);
                    continue;
                }
                if ((!Util.isNullOrEmpty(userArray) || Util.isNullOrEmpty(this.getUserList())) && this.hasMainUser(userArray)) continue;
                CoreServiceFactory.getAdapterRegister().getAdapterWithID(this.getDeviceList()[i2].getDeviceID()).forceOwnerValidation(false, null);
            }
        }
        this._currentDeviceList = this.getTransformer().updateUserListToDeviceList(userArray, this._currentDeviceList, n);
        this.syncLists(4);
        if (!this.getMainUserListeners().isEmpty()) {
            Iterator iterator = this.getMainUserListeners().iterator();
            while (iterator.hasNext()) {
                ((OnlineAuthenticationListener)iterator.next()).updateMainUserEnrolled(!Util.isNullOrEmpty(this.getMainUserEnrolled()), this.getMainUserEnrolled());
            }
        }
    }

    private boolean hasMainUser(User[] userArray) {
        if (!Util.isNullOrEmpty(userArray)) {
            int n = userArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!userArray[i2].isMainUser()) continue;
                return true;
            }
        }
        return false;
    }

    public void updatePrimaryUserInfo(boolean bl) {
        this._showPrimaryUserPopupIsPending = bl;
        if (!Util.isNullOrEmpty(this._userList)) {
            this.updatePrimaryUserPopup();
        }
    }

    public void updateCumulativeServiceListState(int n, int n2) {
        CoreServiceImplFactory.getCoreServiceNotifier().updateCumulativeServiceListState(n);
    }

    public OnlineService[] getClientServiceList() {
        return this._clientServiceList;
    }

    public OnlineUser[] getClientUserList() {
        return this._userList;
    }

    public Service[] getServiceList() {
        return this._completeServiceList;
    }

    public User[] getUserList() {
        return this._completeUserList;
    }

    public Device[] getDeviceList() {
        return this._currentDeviceList;
    }

    public Device getDeviceWithServiceID(String string) {
        if (!Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(this._currentDeviceList)) {
            int n = this._currentDeviceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                Object[] objectArray = this._currentDeviceList[i2].getServiceList();
                if (Util.isNullOrEmpty(objectArray)) continue;
                int n2 = objectArray.length;
                for (int i3 = 0; i3 < n2; ++i3) {
                    if (!objectArray[i3].getServiceID().equalsIgnoreCase(string)) continue;
                    return this._currentDeviceList[i2];
                }
            }
        }
        return null;
    }

    public Device getDeviceWithServiceName(String string) {
        if (!Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(this._currentDeviceList)) {
            int n = this._currentDeviceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                Service[] serviceArray = this._currentDeviceList[i2].getServiceList();
                int n2 = serviceArray.length;
                for (int i3 = 0; i3 < n2; ++i3) {
                    if (!serviceArray[i3].getServiceName().equalsIgnoreCase(string)) continue;
                    return this._currentDeviceList[i2];
                }
            }
        }
        return null;
    }

    public Device getDeviceWithUserID(int n) {
        if (n > -1 && !Util.isNullOrEmpty(this._currentDeviceList)) {
            int n2 = this._currentDeviceList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                User[] userArray = this._currentDeviceList[i2].getUserList();
                int n3 = userArray.length;
                for (int i3 = 0; i3 < n3; ++i3) {
                    if (userArray[i3].getUserID() != n) continue;
                    return this._currentDeviceList[i2];
                }
            }
        }
        return null;
    }

    public Device getDeviceWithLicenseID(String string) {
        return null;
    }

    public OnlineService[] getActiveTrackingServices(OnlineService[] onlineServiceArray) {
        if (!Util.isNullOrEmpty(onlineServiceArray)) {
            ArrayList arrayList = new ArrayList();
            int n = onlineServiceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!onlineServiceArray[i2].isTrackingService()) continue;
                arrayList.add(onlineServiceArray[i2]);
            }
            if (arrayList.size() > 0) {
                OnlineService[] onlineServiceArray2 = new OnlineService[arrayList.size()];
                onlineServiceArray2 = (OnlineService[])arrayList.toArray(new OnlineService[arrayList.size()]);
                return onlineServiceArray2;
            }
        }
        return null;
    }

    public OnlineService getClientServiceWithID(String string) {
        if (!Util.isNullOrEmpty(this.getClientServiceList()) && !Util.isNullOrEmpty(string)) {
            int n = this.getClientServiceList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.getClientServiceList()[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this.getClientServiceList()[i2];
            }
        }
        return null;
    }

    public OnlineUser getClientUserWithID(int n) {
        if (n > -1 && Util.isNullOrEmpty(this._userList)) {
            int n2 = this._userList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (n != this._userList[i2].getUserID()) continue;
                return this._userList[i2];
            }
        }
        return null;
    }

    public User getRealUserWithClientUser(OnlineUser onlineUser) {
        if (onlineUser != null && !Util.isNullOrEmpty(this._currentDeviceList)) {
            int n = this._currentDeviceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                User[] userArray = this._currentDeviceList[i2].getUserList();
                int n2 = userArray.length;
                for (int i3 = 0; i3 < n2; ++i3) {
                    if (onlineUser == null || userArray[i3].getUserID() != onlineUser.getUserID()) continue;
                    return userArray[i3];
                }
            }
        }
        return null;
    }

    public boolean isServiceAvailable(String string) {
        Object object;
        if (!Util.isNullOrEmpty(string) && (object = this.getClientServiceWithID(string)) != null) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".isServiceAvailable(").append(new StringBuffer().append("Service ID = ").append(string).toString()).append(" ) -> Available = TRUE").log();
            }
            return true;
        }
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".isServiceAvailable(").append(new StringBuffer().append("Service ID = ").append(string).toString()).append(" ) -> Available = FALSE").log();
        }
        return false;
    }

    public boolean isServiceInUsableState(String string) {
        Object object;
        if (!Util.isNullOrEmpty(string) && (object = this.getClientServiceWithID(string)) != null && ((OnlineService)object).getServiceState() == 0) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".isServiceInUsableState(").append(new StringBuffer().append("Service ID = ").append(string).toString()).append(" ) -> Usable = TRUE").log();
            }
            return true;
        }
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".isServiceInUsableState(").append(new StringBuffer().append("Service ID = ").append(string).toString()).append(" ) -> Usable = FALSE").log();
        }
        return false;
    }

    public boolean isOCUService(String string) {
        if (!Util.isNullOrEmpty(string)) {
            OnlineService onlineService = this.getClientServiceWithID(string);
            if (onlineService != null && onlineService.getDeviceID() == 1) {
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger2.trace(16384);
                    logMessage.append(this._classname).append(".isOCUService(").append(new StringBuffer().append("Service ID = ").append(string).toString()).append(" --> true)").log();
                }
                return true;
            }
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".isOCUService(").append(new StringBuffer().append("Service ID = ").append(string).toString()).append(" --> False)").log();
            }
        }
        return false;
    }

    public void registerListener(CoreServiceAvailabilityListener coreServiceAvailabilityListener) {
        if (coreServiceAvailabilityListener != null && !this.getListeners().contains(coreServiceAvailabilityListener)) {
            this.getListeners().add(coreServiceAvailabilityListener);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".registerListener(Either Listener is NULL or Listener already exists)").log();
        }
    }

    public boolean checkIfServiceRegistered(String string) {
        return !Util.isNullOrEmpty(string) && this.getRegisteredServices().containsKey(string);
    }

    public void addServiceForUpdate(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
        if (aSLOnlineServiceListener != null && !Util.isNullOrEmpty(string) && !this.getRegisteredServices().containsValue(aSLOnlineServiceListener)) {
            this.getRegisteredServices().put(string, aSLOnlineServiceListener);
            this.sendCallBack(string, aSLOnlineServiceListener);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".addServiceForUpdate(Either Listener is NULL or serviceID already exists)").log();
        }
    }

    public void removeServiceFromUpdate(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
        if (!Util.isNullOrEmpty(string) && aSLOnlineServiceListener != null) {
            this.getRegisteredServices().removeValue(string, aSLOnlineServiceListener);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".addServiceForUpdate(Either Listener is NULL or serviceID already exists)").log();
        }
    }

    public void handleCarNetPinVerification(String string, CoreServiceCarNetPinVerificationListener coreServiceCarNetPinVerificationListener) {
        if (coreServiceCarNetPinVerificationListener != null) {
            CoreServiceAdapter coreServiceAdapter = CoreServiceFactory.getAdapterRegister().getMainAdapter();
            if (coreServiceAdapter != null) {
                this._carNetPinListener = coreServiceCarNetPinVerificationListener;
                coreServiceAdapter.validateOwner(null, string, CoreServiceImplFactory.getAdapterListener());
            }
        } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".handleCarNetPinVerification(").append("Listener --> NULL)").log();
        }
    }

    public void CarNetPinVerificationResponse(OnlineUser onlineUser, int n) {
        if (n != 0 || !Util.isNullOrEmpty(CoreServiceFactory.getAdapterRegister().getAdapterList()) && CoreServiceFactory.getAdapterRegister().getAdapterList().length == 1 && CoreServiceFactory.getAdapterRegister().getMainAdapterID() == 1) {
            this.sendPinVerificationResponse(onlineUser, n);
        } else {
            this._carNetPinResult = n;
            this._carNetPinUser = onlineUser;
        }
    }

    public void registerForMainUserEnrollment(OnlineAuthenticationListener onlineAuthenticationListener) {
        if (onlineAuthenticationListener != null && !this.getMainUserListeners().contains(onlineAuthenticationListener)) {
            this.getMainUserListeners().add(onlineAuthenticationListener);
            onlineAuthenticationListener.updateMainUserEnrolled(!Util.isNullOrEmpty(this.getMainUserEnrolled()), this.getMainUserEnrolled());
        } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".registerForMainUserEnrollment(").append("Listener --> NULL or Listener is already registered)").log();
        }
    }

    public void unRegisterForMainUserEnrollment(OnlineAuthenticationListener onlineAuthenticationListener) {
        if (onlineAuthenticationListener != null && this.getMainUserListeners().contains(onlineAuthenticationListener)) {
            this.getMainUserListeners().remove(onlineAuthenticationListener);
        } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".unRegisterForMainUserEnrollment(").append("Listener --> NULL or Listener is not registered)").log();
        }
    }

    public String getMainUserEnrolled() {
        if (!Util.isNullOrEmpty(this.getUserList())) {
            int n = this.getUserList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.getUserList()[i2].isMainUser()) continue;
                return this.getUserList()[i2].getUserName();
            }
        }
        return "";
    }

    public void setStatusBarStatus(int n) {
        if (this._statusbarStatus != n) {
            this._statusbarStatus = n;
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".setStatusBarStatus()-->").append(this._statusbarStatus).toString()).log();
            }
            CoreServiceImplFactory.getServiceStatus().updateOnlineStatus(this._statusbarStatus);
        }
    }

    public int getStatusBarStatus() {
        return this._statusbarStatus;
    }

    public boolean isStatusValid() {
        return this._statusbarStatus == 4 || this._statusbarStatus == 0;
    }

    static /* synthetic */ int access$000(CoreServiceController coreServiceController, Service service) {
        return coreServiceController.getResultWithService(service);
    }
}

