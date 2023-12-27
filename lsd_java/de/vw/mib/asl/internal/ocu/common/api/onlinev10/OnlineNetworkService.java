/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10;

import de.vw.mib.asl.api.ocu.eni.ENIServiceProvider;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListener;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.OnlineNetworkService$IteratorProvider;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.data.OnlineNetworkUser;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.CellularNetworkState;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.OnlineNetworkListState;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.ServiceListSynchronisationState;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.mapping.ServiceMapping;
import de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.EniApiServices;
import de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.OperationStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.UserList_Data;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class OnlineNetworkService
implements de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService,
UserListServiceListener,
ServiceListServiceListener,
RemoteProcessServiceListener,
OperationStateServiceListener,
FunctionSupportServiceListener,
de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener,
RegisterStateServiceListener,
ActiveMonitoringsServiceListener,
PrivacySetupServiceListener,
ConnectionStateServiceListener {
    private final OnlineNetworkService$IteratorProvider listenerIteratorProvider;
    private OnlineNetworkServiceResponseListener lastResponseListener;
    private OnlineNetworkServiceStatus onlineNetworkServiceStatus;
    private OnlineNetworkSupportedServices olineNetworkSupportedServices;
    private de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList userList;
    private de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList serviceList;
    private boolean ecallRegistered;
    private boolean ecallStarted;
    private boolean privacyModeActive;
    private OnlineNetworkTrackingServices onlineNetworkTrackingServices;
    private de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState serviceListSynchronisationState;

    OnlineNetworkService(OnlineNetworkService$IteratorProvider onlineNetworkService$IteratorProvider) {
        this.listenerIteratorProvider = onlineNetworkService$IteratorProvider;
    }

    private Iterator getListenerIterator() {
        return this.listenerIteratorProvider.getIterator();
    }

    private void setLastResponseListener(OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
        this.lastResponseListener = onlineNetworkServiceResponseListener;
    }

    private OnlineNetworkServiceResponseListener getLastResponseListener() {
        return this.lastResponseListener;
    }

    private void clearLastResponseListener() {
        this.setLastResponseListener(null);
    }

    private EniApiServices getEniApiServices() {
        return (EniApiServices)ENIServiceProvider.getENIService(ENIServiceProvider.ENI_SERVICE_VERSION_1_0).getEniApiServices();
    }

    @Override
    public void pairMainUser(String string, String string2, OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
        this.setLastResponseListener(onlineNetworkServiceResponseListener);
        this.getEniApiServices().pairMainUser(string, string2);
    }

    @Override
    public void restoreFactorySettings(OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
        this.setLastResponseListener(onlineNetworkServiceResponseListener);
        this.getEniApiServices().restoreFactorySettings();
    }

    @Override
    public void confirmServiceExpiryWarning(de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry onlineNetworkServiceListEntry, OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
        this.setLastResponseListener(onlineNetworkServiceResponseListener);
        this.getEniApiServices().confirmServiceExpiryWarning(onlineNetworkServiceListEntry.getServiceId());
    }

    @Override
    public void confirmServiceExpiryWarnings(OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
        this.setLastResponseListener(onlineNetworkServiceResponseListener);
        this.getEniApiServices().confirmServiceExpiryWarnings();
    }

    @Override
    public void setServicesBlocking(boolean bl) {
        throw new NullPointerException("Usage of deprecated function, please don't use this function. The definition of this function is not defined");
    }

    @Override
    public void setServiceBlocking(de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry onlineNetworkServiceListEntry, boolean bl) {
        this.getEniApiServices().blockService(onlineNetworkServiceListEntry.getServiceId(), bl);
    }

    @Override
    public boolean getPrivacyModeActive() {
        return this.privacyModeActive;
    }

    @Override
    public void setPrivacyMode(boolean bl) {
        this.getEniApiServices().setPrivacyModeActive(bl);
    }

    @Override
    public void synchronizeServiceListWithBackend(OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
        this.setLastResponseListener(onlineNetworkServiceResponseListener);
        this.getEniApiServices().sendLocalServiceStateListRequest();
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList getOnlineNetworkUserList() {
        if (this.userList == null) {
            this.userList = new OnlineNetworkList(OnlineNetworkListState.ENUM_NOT_INITIALIZED, new ArrayList());
        }
        return this.userList;
    }

    private void setOnlineNetworkUserList(int n, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            UserList_Data userList_Data = (UserList_Data)list.get(i2);
            arrayList.add(new OnlineNetworkUser(userList_Data));
        }
        this.userList = new OnlineNetworkList(ServiceMapping.mapEniUserListState(n), arrayList);
        Iterator iterator = this.getListenerIterator();
        while (iterator.hasNext()) {
            OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
            onlineNetworkServiceListener.updateOnlineNetworkUserList(this, this.userList);
        }
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList getOnlineNetworkServiceList() {
        if (this.serviceList == null) {
            this.serviceList = new OnlineNetworkList(OnlineNetworkListState.ENUM_NOT_INITIALIZED, new ArrayList());
        }
        return this.serviceList;
    }

    private void setOnlineNetworkServiceList(int n, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ServiceList_Data serviceList_Data = (ServiceList_Data)list.get(i2);
            arrayList.add(new OnlineNetworkServiceListEntry(serviceList_Data));
        }
        this.serviceList = new OnlineNetworkList(ServiceMapping.mapEniServiceListState(n), arrayList);
        Iterator iterator = this.getListenerIterator();
        while (iterator.hasNext()) {
            OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
            onlineNetworkServiceListener.updateOnlineNetworkServiceList(this, this.serviceList);
        }
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus getOnlineNetworkServiceStatus() {
        return this.getOnlineNetworkServiceStatusInternal();
    }

    public OnlineNetworkServiceStatus getOnlineNetworkServiceStatusInternal() {
        if (this.onlineNetworkServiceStatus == null) {
            this.onlineNetworkServiceStatus = new OnlineNetworkServiceStatus(false, false, CellularNetworkState.ENUM_UNKNOWN);
        }
        return this.onlineNetworkServiceStatus;
    }

    private void setOnlineNetworkServiceStatus(OnlineNetworkServiceStatus onlineNetworkServiceStatus) {
        if (!this.getOnlineNetworkServiceStatus().equals(onlineNetworkServiceStatus)) {
            this.onlineNetworkServiceStatus = onlineNetworkServiceStatus;
            Iterator iterator = this.getListenerIterator();
            while (iterator.hasNext()) {
                OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
                onlineNetworkServiceListener.updateOnlineNetworkServiceStatus(this, this.getOnlineNetworkServiceStatus());
            }
        }
    }

    private CellularNetworkState computeCellularNetworkState() {
        CellularNetworkState cellularNetworkState = this.ecallRegistered && this.ecallStarted ? CellularNetworkState.ENUM_CONNECTED : (this.ecallStarted ? CellularNetworkState.ENUM_NOT_CONNECTED : CellularNetworkState.ENUM_UNKNOWN);
        return cellularNetworkState;
    }

    public OnlineNetworkSupportedServices getOnlineNetworkSupportedServicesInternal() {
        if (this.olineNetworkSupportedServices == null) {
            this.olineNetworkSupportedServices = new OnlineNetworkSupportedServices(false, false, false, false);
        }
        return this.olineNetworkSupportedServices;
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices getOnlineNetworkSupportedServices() {
        return this.getOnlineNetworkSupportedServicesInternal();
    }

    private void setOnlineNetworkSupportedServices(OnlineNetworkSupportedServices onlineNetworkSupportedServices) {
        if (!this.getOnlineNetworkSupportedServices().equals(onlineNetworkSupportedServices)) {
            this.olineNetworkSupportedServices = onlineNetworkSupportedServices;
            Iterator iterator = this.getListenerIterator();
            while (iterator.hasNext()) {
                OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
                onlineNetworkServiceListener.updateOnlineNetworkSupportedServices(this, this.getOnlineNetworkSupportedServices());
            }
        }
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices getOnlineNetworkTrackingServices() {
        if (this.onlineNetworkTrackingServices == null) {
            this.onlineNetworkTrackingServices = new OnlineNetworkTrackingServices(false, false, false, false, false, false, false, false, false);
        }
        return this.onlineNetworkTrackingServices;
    }

    private void setOnlineNetworkTrackingServices(OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        if (!this.getOnlineNetworkTrackingServices().equals(onlineNetworkTrackingServices)) {
            this.onlineNetworkTrackingServices = onlineNetworkTrackingServices;
            Iterator iterator = this.getListenerIterator();
            while (iterator.hasNext()) {
                OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
                onlineNetworkServiceListener.updateOnlineNetworkTrackingServices(this, this.getOnlineNetworkTrackingServices());
            }
        }
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState getServiceListSynchronisationState() {
        if (this.serviceListSynchronisationState == null) {
            this.serviceListSynchronisationState = ServiceListSynchronisationState.ENUM_NOT_AVAILABLE;
        }
        return this.serviceListSynchronisationState;
    }

    private void setServiceListSynchronisationState(de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState serviceListSynchronisationState) {
        if (this.serviceListSynchronisationState != serviceListSynchronisationState) {
            this.serviceListSynchronisationState = serviceListSynchronisationState;
            Iterator iterator = this.getListenerIterator();
            while (iterator.hasNext()) {
                OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
                onlineNetworkServiceListener.updateServiceListSynchronisationState(this, serviceListSynchronisationState);
            }
        }
    }

    @Override
    public void updateUserListData(int n, List list) {
        this.setOnlineNetworkUserList(n, list);
    }

    @Override
    public void updateServiceListData(int n, List list) {
        this.setOnlineNetworkServiceList(n, list);
    }

    @Override
    public void updateBlockedService(BAPArrayElement bAPArrayElement) {
        ServiceList_Data serviceList_Data = (ServiceList_Data)bAPArrayElement;
        OnlineNetworkServiceListEntry onlineNetworkServiceListEntry = new OnlineNetworkServiceListEntry(serviceList_Data);
        Iterator iterator = this.getListenerIterator();
        while (iterator.hasNext()) {
            OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
            onlineNetworkServiceListener.updateOnlineNetworkServiceSetBlocking(this, onlineNetworkServiceListEntry);
        }
    }

    @Override
    public void operationStatus(int n) {
        this.setOnlineNetworkServiceStatus(this.getOnlineNetworkServiceStatusInternal().setServiceUserActionsBlocked(n != 1));
        if (this.getLastResponseListener() != null) {
            this.getLastResponseListener().operationStatus(this, ServiceMapping.mapEniOperationStatus(n));
        }
    }

    @Override
    public void operationResult(int n, int n2) {
        OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener = this.getLastResponseListener();
        if (onlineNetworkServiceResponseListener != null) {
            this.clearLastResponseListener();
            onlineNetworkServiceResponseListener.operationResult(this, ServiceMapping.mapEniOperationType(n), ServiceMapping.mapEniOperationResult(n2));
        }
    }

    @Override
    public void supportedOperations(boolean bl, boolean bl2, boolean bl3) {
        this.setOnlineNetworkSupportedServices(new OnlineNetworkSupportedServices(bl, bl2, bl3, this.getOnlineNetworkSupportedServices().isNetworkOnlineServicesAccessible()));
    }

    @Override
    public void updateEniOperationState(boolean bl) {
        this.setOnlineNetworkServiceStatus(this.getOnlineNetworkServiceStatusInternal().setCommunicationAvailable(bl));
    }

    @Override
    public void updateOnlineNetworkServicesSupported(boolean bl) {
        this.setOnlineNetworkSupportedServices(this.getOnlineNetworkSupportedServicesInternal().setNetworkOnlineServicesAccessible(bl));
    }

    @Override
    public void updateECallOperationState(boolean bl) {
        this.ecallStarted = bl;
        this.setOnlineNetworkServiceStatus(this.getOnlineNetworkServiceStatusInternal().setConnectionToCellularNetworkState(this.computeCellularNetworkState()));
    }

    @Override
    public void updateRegisterState(boolean bl) {
        this.ecallRegistered = bl;
        this.setOnlineNetworkServiceStatus(this.getOnlineNetworkServiceStatusInternal().setConnectionToCellularNetworkState(this.computeCellularNetworkState()));
    }

    @Override
    public void updateEniActiveMonitorings(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        this.setOnlineNetworkTrackingServices(new OnlineNetworkTrackingServices(bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8, bl9));
    }

    @Override
    public void updateEniPrivacySetup(boolean bl) {
        this.privacyModeActive = bl;
        Iterator iterator = this.getListenerIterator();
        while (iterator.hasNext()) {
            OnlineNetworkServiceListener onlineNetworkServiceListener = (OnlineNetworkServiceListener)iterator.next();
            onlineNetworkServiceListener.updatePrivacyModeActive(this, bl);
        }
    }

    @Override
    public void updateConnectionState(int n) {
        this.setServiceListSynchronisationState(ServiceMapping.mapEniConnectionState(n));
    }
}

