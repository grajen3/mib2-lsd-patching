/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.modelocu;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.api.ocu.OCUServiceProvider;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListener;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationResult;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationStatus;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationType;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.ocu.common.api.modelocu.ModelOcuServiceProvider$InternalNavigationSplitscreenListener;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Calendar;
import java.util.Iterator;

public class ModelOcuServiceProvider
extends AbstractTarget
implements OnlineNetworkServiceListener,
OnlineNetworkServiceResponseListener,
INavServiceStateListener {
    private static final String MEC_SERVICE_SERVICE_ID;
    private boolean registeredToNaviService;
    private NavigationSplitscreenService navigationSplitscreenService;

    @Override
    public int getClassifier() {
        return 2;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1075141868: {
                this.confirmServiceExpiraryWarning();
                break;
            }
            case 107: {
                ASLNavigationFactory.getNavigationApi().unregisterNavServiceStateListener(this);
                if (this.isTraceEnabled()) {
                    this.getTextLogger().trace(this.getSubClassifier()).append("Unregister: ").append(this.navigationSplitscreenService.toString()).log();
                }
                this.navigationSplitscreenService = null;
                break;
            }
        }
    }

    public void register() {
        try {
            this.register(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), 1930041088, "hsmtask");
        }
        catch (Exception exception) {
            this.getTextLogger().error(this.getSubClassifier(), "Can't start ModelOcuServiceProvider target", exception);
        }
        OCUServiceProvider.getServiceProvider().getOnlineNetworkService(OCUServiceProvider.NETWORK_SERVICE_VERSION_1_0).registerOnlineNetworkServiceListener(this);
        this.updateModelWithServiceInformation(this.getOnlineNetworkService().getOnlineNetworkServiceList());
        this.addObserver(-329509568);
        this.registerForNavigationService();
    }

    private void registerForNavigationService() {
        ASLNavigationFactory.getNavigationApi().registerNavServiceStateListener(this);
    }

    private OnlineNetworkService getOnlineNetworkService() {
        return OCUServiceProvider.getServiceProvider().getOnlineNetworkService(OCUServiceProvider.NETWORK_SERVICE_VERSION_1_0).getOnlineNetworkService();
    }

    private OnlineNetworkServiceListEntry findMecService(OnlineNetworkList onlineNetworkList) {
        OnlineNetworkServiceListEntry onlineNetworkServiceListEntry = null;
        Iterator iterator = onlineNetworkList.getListData().iterator();
        while (iterator.hasNext()) {
            OnlineNetworkServiceListEntry onlineNetworkServiceListEntry2 = (OnlineNetworkServiceListEntry)iterator.next();
            if (onlineNetworkServiceListEntry2.getServiceId().compareTo("ecall_v1") != 0) continue;
            onlineNetworkServiceListEntry = onlineNetworkServiceListEntry2;
            break;
        }
        return onlineNetworkServiceListEntry;
    }

    private void updateModelWithServiceInformation(OnlineNetworkList onlineNetworkList) {
        OnlineNetworkServiceListEntry onlineNetworkServiceListEntry = this.findMecService(onlineNetworkList);
        if (onlineNetworkServiceListEntry != null) {
            this.updateModelWithServiceInformation(onlineNetworkServiceListEntry);
        }
    }

    private void updateModelWithServiceInformation(OnlineNetworkServiceListEntry onlineNetworkServiceListEntry) {
        if (onlineNetworkServiceListEntry.isServiceLicenseExpirationWarningActive()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(onlineNetworkServiceListEntry.getExpirationDate());
            ServiceManager.aslPropertyManager.valueChangedInteger(-58518272, calendar.get(5));
            ServiceManager.aslPropertyManager.valueChangedInteger(-41741056, calendar.get(2) + 1);
            ServiceManager.aslPropertyManager.valueChangedInteger(-24963840, calendar.get(1));
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-545057536);
        }
    }

    private void confirmServiceExpiraryWarning() {
        OnlineNetworkServiceListEntry onlineNetworkServiceListEntry = this.findMecService(this.getOnlineNetworkService().getOnlineNetworkServiceList());
        if (onlineNetworkServiceListEntry != null) {
            this.getOnlineNetworkService().confirmServiceExpiryWarning(onlineNetworkServiceListEntry, this);
        } else {
            this.error("confirmServiceExpiraryWarning failed, because the service to confirm can't be found in service list");
        }
    }

    @Override
    public void updateOnlineNetworkServiceList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
        if (onlineNetworkList.getListState().value() == 3) {
            this.updateModelWithServiceInformation(onlineNetworkList);
        }
    }

    @Override
    public void updateOnlineNetworkServiceStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceStatus onlineNetworkServiceStatus) {
    }

    @Override
    public void updateOnlineNetworkSupportedServices(OnlineNetworkService onlineNetworkService, OnlineNetworkSupportedServices onlineNetworkSupportedServices) {
    }

    @Override
    public void updateOnlineNetworkUserList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
    }

    @Override
    public void updatePrivacyModeActive(OnlineNetworkService onlineNetworkService, boolean bl) {
    }

    @Override
    public void updateServiceListSynchronisationState(OnlineNetworkService onlineNetworkService, ServiceListSynchronisationState serviceListSynchronisationState) {
    }

    @Override
    public void updateOnlineNetworkTrackingServices(OnlineNetworkService onlineNetworkService, OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
    }

    @Override
    public void updateOnlineNetworkServiceSetBlocking(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceListEntry onlineNetworkServiceListEntry) {
    }

    @Override
    public void operationStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceResponseListener$OperationStatus onlineNetworkServiceResponseListener$OperationStatus) {
        if (this.isTraceEnabled()) {
            this.trace("ModelOcuServiceProvider: new operation status=", onlineNetworkServiceResponseListener$OperationStatus.value());
        }
    }

    @Override
    public void operationResult(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceResponseListener$OperationType onlineNetworkServiceResponseListener$OperationType, OnlineNetworkServiceResponseListener$OperationResult onlineNetworkServiceResponseListener$OperationResult) {
        if (onlineNetworkServiceResponseListener$OperationResult.value() != 0) {
            this.error("ModelOcuServiceProvider: Failed confirm expirary warning error=", onlineNetworkServiceResponseListener$OperationResult.value());
        }
    }

    @Override
    public void navServiceStateChanged() {
        if (!this.registeredToNaviService && ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
            try {
                this.navigationSplitscreenService = ASLNavigationFactory.getNavigationApi().getNavigationSplitscreenService(new ModelOcuServiceProvider$InternalNavigationSplitscreenListener());
                this.registeredToNaviService = true;
            }
            catch (NavigationServiceException navigationServiceException) {
                this.getTextLogger().error(this.getSubClassifier(), "Can't start obtain getNavigationSplitscreenService", navigationServiceException);
            }
        }
    }
}

