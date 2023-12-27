/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.control;

import de.vw.mib.asl.api.connectivity.services.datavolume.DataTrafficService;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.api.system.powerstate.PowerStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.clients.model.common.OnlineServicePackage;
import de.vw.mib.asl.internal.online.clients.model.control.CoreServiceModelController$1;
import de.vw.mib.asl.internal.online.clients.model.control.CoreServiceModelHandler;
import de.vw.mib.asl.internal.online.clients.model.control.CoreServiceModelListHandler;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineServiceInfoCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CoreServiceModelController
extends AbstractFactoryResetParticipant
implements FactoryResetListener,
PowerStateListener {
    private final String _classname = super.getClass().getName();
    private final CoreServiceModelTarget _target;
    private CoreServiceModelListHandler _listHandler;
    private CoreServiceModelHandler _modelHandler;
    private FactoryResetCallback _resetCallback;
    private boolean _onlineReset;
    private ArrayList _serviceIds;
    private boolean _privacyMode;
    private boolean _privacyModeInProgress;
    private int _enabledState;
    private boolean _powerStateOn;
    static /* synthetic */ Class class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService;

    public CoreServiceModelController(CoreServiceModelTarget coreServiceModelTarget) {
        this._target = coreServiceModelTarget;
    }

    private CoreServiceModelListHandler getListHandler() {
        if (this._listHandler == null) {
            this._listHandler = new CoreServiceModelListHandler();
        }
        return this._listHandler;
    }

    private ArrayList getServicesForActivation() {
        if (this._serviceIds == null) {
            this._serviceIds = new ArrayList();
        }
        return this._serviceIds;
    }

    private void dispatchActiveApplicationList(boolean bl) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".dispatchActiveApplicationList(").append(bl).append(")").toString()).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this._target.triggerObserver(155076864, eventGeneric);
    }

    public CoreServiceModelHandler getModelHandler() {
        if (this._modelHandler == null) {
            this._modelHandler = new CoreServiceModelHandler();
        }
        return this._modelHandler;
    }

    public OnlineService getServiceWithServiceID(String string) {
        return this.getListHandler().getServiceWithServiceID(string);
    }

    public boolean isRemainingServicesForActivationEmpty() {
        return this.getServicesForActivation().isEmpty();
    }

    public void updateServiceList(OnlineService[] onlineServiceArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateServiceList()").log();
        }
        boolean bl = false;
        if (!Util.isNullOrEmpty(onlineServiceArray) && (Util.isNullOrEmpty(this.getListHandler().getServiceList()) || onlineServiceArray.length != this.getListHandler().getServiceList().length)) {
            bl = true;
        }
        this.getListHandler().setServiceList(onlineServiceArray);
        this.getModelHandler().setCategoryFilter(this.getListHandler().getCurrentCategoryFilter());
        this.getModelHandler().sendOnlineServiceGroupList(this.getListHandler().getPackageListWithCategory(this.getListHandler().getCurrentCategoryFilter()));
        if (this.getListHandler().getCurrentSelectedPackage() != null) {
            this.getModelHandler().sendOnlineServiceList(this.getListHandler().getServicesWithPackageID(this.getListHandler().getCurrentSelectedPackage().getPackageID()));
        }
        this.dispatchActiveApplicationList(bl);
        this.getModelHandler().setActivationListLoading(Util.isNullOrEmpty(onlineServiceArray));
    }

    public void updateUserList(OnlineUser[] onlineUserArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateUserList()").log();
        }
        this.getListHandler().setUserList(onlineUserArray);
        Object[] objectArray = this.getListHandler().getUserList();
        boolean bl = false;
        Object object = null;
        if (!Util.isNullOrEmpty(objectArray)) {
            int n = objectArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (((OnlineUser)objectArray[i2]).getUserType() != 1) continue;
                object = objectArray[i2];
                bl = true;
            }
        }
        this.getModelHandler().setMainUser((OnlineUser)object);
        this.getModelHandler().setAuthenticationSuccessful(bl);
    }

    public void updateAuthenticationStatus(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateAuthenticationStatus(").append(n).append(")").toString()).log();
        }
        CoreServiceModelFactory.getPropertyManager().setRegistrationState(n);
        switch (n) {
            case 1: {
                this.getModelHandler().setAuthenticationSuccessful(true);
                this.getModelHandler().setCarNetRegistrationState(1);
                break;
            }
            case 2: {
                this.getModelHandler().setAuthenticationSuccessful(false);
                this.getModelHandler().setCarNetRegistrationState(2);
                break;
            }
            case 3: {
                this.getModelHandler().setCarNetRegistrationState(0);
                break;
            }
            default: {
                this.getModelHandler().setCarNetRegistrationState(4);
            }
        }
    }

    public void serviceStatusResult(String string, int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".serviceStatusResult(").append(n).append(")").toString()).log();
        }
        if (string.equalsIgnoreCase(CoreServiceModelFactory.getPropertyManager().getPrecheckServiceID())) {
            int n2 = 1107104512;
            switch (n) {
                case 0: {
                    n2 = 1090327296;
                    break;
                }
                case 3: {
                    n2 = 1123881728;
                    break;
                }
                case 6: {
                    n2 = 1140658944;
                    break;
                }
                case 24: 
                case 55: {
                    n2 = 1157436160;
                    break;
                }
                case 13: 
                case 14: 
                case 16: 
                case 17: {
                    n2 = 1174213376;
                    break;
                }
                case 18: {
                    n2 = 1190990592;
                    break;
                }
                case 15: 
                case 59: {
                    n2 = 1258099456;
                    break;
                }
                case 50: {
                    n2 = 1274876672;
                    break;
                }
            }
            this.getModelHandler().sendSystemEvent(n2);
            CoreServiceModelFactory.getPropertyManager().resetPrecheckRequest();
        }
    }

    public OnlineService[] getServiceList() {
        return this.getListHandler().getServiceList();
    }

    public OnlineUser getMainUser() {
        return this.getListHandler().getMainUser();
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".FactoryReset() --> STARTED").log();
        }
        if (factoryResetCallback != null) {
            if (CoreServiceFactory.getAdapterRegister().getAdapterList() != null && CoreServiceFactory.getAdapterRegister().getAdapterList().length > 0 && CoreServiceFactory.getCoreService() != null) {
                CoreServiceFactory.getCoreService().resetToFactorySettings("", this._target);
                this._resetCallback = factoryResetCallback;
            } else {
                factoryResetCallback.notifyResetDone();
            }
        }
    }

    public void notifyResetDone(int n, int n2) {
        if (this._resetCallback != null) {
            this._resetCallback.notifyResetDone();
        }
        if (n2 == 1) {
            this.getModelHandler().sendSystemEvent(1241322240);
        } else {
            this.getModelHandler().sendSystemEvent(n2 == 0 ? 1056772864 : 1073550080);
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public void notifyResetDone(int n, boolean bl) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".notifyResetDone(DeviceID = ").append(n).append(", reset = ").append(bl).append(")").toString()).log();
        }
        if (this._resetCallback != null) {
            this._resetCallback.notifyResetDone();
            this.getModelHandler().sendSystemEvent(bl ? 1056772864 : 1073550080);
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(new StringBuffer().append(".FactoryReset() MOD --> ENDED with RESULT == ").append(bl).toString()).log();
            }
        } else if (n == CoreServiceFactory.getAdapterRegister().getMainAdapterID()) {
            this.getModelHandler().sendSystemEvent(bl ? 1056772864 : 1073550080);
            if (CoreServiceFactory.getAdapterRegister().getAdapterList().length > 1) {
                if (CoreServiceFactory.getCoreService() != null && this._resetCallback == null) {
                    CoreServiceFactory.getCoreService().resetToFactorySettingsWithServiceName("", this._target);
                }
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._resetCallback != null ? ".FactoryReset() OCU --> ENDED with RESULT == " : ".Delete Main User OCU --> ENDED with RESULT == ").append(bl).log();
                }
                this._resetCallback = null;
            } else if (this._target.isTraceEnabled()) {
                this._target.trace().append(new StringBuffer().append("Delete Main User MOD --> ENDED with RESULT == ").append(bl).toString()).log();
            }
        } else if (n != CoreServiceFactory.getAdapterRegister().getMainAdapterID()) {
            this.getModelHandler().sendSystemEvent(bl ? 1056772864 : 1073550080);
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(new StringBuffer().append("Delete Main User MOD --> ENDED with RESULT == ").append(bl).toString()).log();
            }
        }
    }

    @Override
    public void onFactoryResetStateChanged(int n) {
        if (n == 0 && this._onlineReset && this.getModelHandler().getOCURuntimeStatus() == 4) {
            this.getModelHandler().sendSystemEvent(1241322240);
            this._onlineReset = !this._onlineReset;
        }
    }

    public void handlePrivacyMode() {
        this._privacyModeInProgress = true;
        CoreServiceFactory.getCoreService().sendPrivacyModeStatus(!this._privacyMode, this._target);
    }

    public void handlePrivacyModeResult(int n, boolean bl) {
        if (n <= 0) {
            this._privacyMode = n == -1 ? bl : (n == 0 ? !this._privacyMode : this._privacyMode);
            this.getModelHandler().setPrivacyModeState(this._privacyMode);
        }
        this._privacyModeInProgress = false;
    }

    public void handleCategoryFilter(int n) {
        if (n != this.getListHandler().getCurrentCategoryFilter()) {
            this.getModelHandler().sendOnlineServiceList(new OnlineService[0]);
            this.getModelHandler().sendOnlineServiceGroupList(this.getListHandler().getPackageListWithCategory(n));
            this.getModelHandler().setCategoryFilter(n);
            this.getListHandler().setCurrentSelectedPackage(null);
            this.getListHandler().setCurrentCategoryFilter(n);
        }
    }

    public boolean handlePackageActivation(int n) {
        if (n > -1 && !this._privacyModeInProgress) {
            OnlineServicePackage onlineServicePackage;
            OnlineServicePackage onlineServicePackage2 = onlineServicePackage = this.getModelHandler().getOnlineServicePackageList() != null ? this.getModelHandler().getOnlineServicePackageWithIndex(n) : null;
            if (onlineServicePackage != null) {
                Object[] objectArray = this.getListHandler().getServicesWithPackageID(onlineServicePackage.getPackageID());
                if (!Util.isNullOrEmpty(objectArray)) {
                    boolean bl = false;
                    if (onlineServicePackage.getPackageState() == 2) {
                        bl = true;
                    }
                    return this.handleServicesActivation((OnlineService[])objectArray, bl);
                }
            } else {
                this._target.warn().append(this._classname).append("Package selected NOT FOUND").log();
            }
        } else {
            this._target.info().append(this._classname).append(".handlePackageActivation(Privacy Mode in progress)").log();
        }
        return false;
    }

    public boolean handleServicesActivation(OnlineService[] onlineServiceArray, boolean bl) {
        if (!Util.isNullOrEmpty(onlineServiceArray)) {
            boolean bl2 = true;
            int n = onlineServiceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (bl != onlineServiceArray[i2].isEnabledState() || onlineServiceArray[i2].isDeactivationBlocked()) continue;
                if (bl2) {
                    if (onlineServiceArray[i2] == null) continue;
                    int n2 = -1;
                    n2 = !bl ? 1 : 2;
                    if (n2 <= -1) continue;
                    CoreServiceFactory.getCoreService().setState(onlineServiceArray[i2].getServiceID(), n2, this._target);
                    if (n > 1) {
                        this._enabledState = n2;
                    }
                    bl2 = false;
                    continue;
                }
                this.getServicesForActivation().add(onlineServiceArray[i2].getServiceID());
            }
            if (!(bl2 || n != 1 && this.getServicesForActivation().isEmpty())) {
                return true;
            }
        }
        return false;
    }

    public void handleRemainingServicesActivation(OnlineService onlineService) {
        if (onlineService != null && !this.getServicesForActivation().isEmpty()) {
            CoreServiceFactory.getCoreService().setState(new String((String)this.getServicesForActivation().remove(0)), this._enabledState, this._target);
        } else {
            this._target.info().append(this._classname).append("->Either Service is not valid or List is empty").log();
            if (onlineService == null) {
                this._target.info().append(this._classname).append("->Service is not valid").log();
            }
            if (this.getServicesForActivation().isEmpty()) {
                this._target.info().append(this._classname).append("->List is empty").log();
            }
        }
    }

    public void openServiceListOfPackage(int n) {
        if (n > -1) {
            OnlineServicePackage onlineServicePackage;
            OnlineServicePackage onlineServicePackage2 = onlineServicePackage = this.getModelHandler().getOnlineServicePackageList() != null ? this.getModelHandler().getOnlineServicePackageWithIndex(n) : null;
            if (onlineServicePackage != null) {
                this.getModelHandler().sendOnlineServiceList(this.getListHandler().getServicesWithPackageID(onlineServicePackage.getPackageID()));
                this.getListHandler().setCurrentSelectedPackage(this.getListHandler().getPackageWithPackageID(onlineServicePackage.getPackageID()));
            } else {
                this._target.warn().append(this._classname).append("Package selected NOT FOUND").log();
            }
        }
    }

    public boolean handleServiceActivation(int n) {
        OnlineService onlineService = this.getModelHandler().getOnlineServiceWithSubIndex(n);
        if (onlineService != null) {
            OnlineService[] onlineServiceArray = new OnlineService[]{onlineService};
            return this.handleServicesActivation(onlineServiceArray, onlineService.isEnabledState());
        }
        return false;
    }

    public void handleServiceDetailView(int n) {
        if (n > -1) {
            OnlineService onlineService = this.getModelHandler().getOnlineServiceWithSubIndex(n);
            if (onlineService != null) {
                OnlineOnlineServiceInfoCollector[] onlineOnlineServiceInfoCollectorArray = new OnlineOnlineServiceInfoCollector[]{new OnlineOnlineServiceInfoCollector()};
                if (onlineService.getLicense() != null) {
                    Object object;
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_id = CoreServiceModelMap.getServiceIDInteger(onlineService.getLicense().getServiceID());
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_state = CoreServiceModelMap.getModelLicenseState(onlineService.getLicense().getLicenseState());
                    if (onlineService.getLicense().getExpiryDate() != null && onlineService.getLicense().getExpiryDate().getTime() > 0L) {
                        object = onlineService.getLicense().getExpiryDate();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime((Date)object);
                        int n2 = calendar.get(5);
                        int n3 = calendar.get(2) + 1;
                        int n4 = calendar.get(1);
                        onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_date_day = n2;
                        onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_date_month = n3;
                        onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_date_year = n4;
                    }
                    if (onlineService.getApn() == 2) {
                        object = (DataTrafficService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService == null ? (class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService = CoreServiceModelController.class$("de.vw.mib.asl.api.connectivity.services.datavolume.DataTrafficService")) : class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService);
                        if (object != null) {
                            object.requestDataVolume(new CoreServiceModelController$1(this, onlineService, onlineOnlineServiceInfoCollectorArray));
                        }
                    } else {
                        onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_data_usage = 0;
                    }
                } else {
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_id = CoreServiceModelMap.getServiceIDInteger(onlineService.getServiceID());
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_state = 2;
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_date_day = 0;
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_date_month = 0;
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_license_date_year = 0;
                    onlineOnlineServiceInfoCollectorArray[0].online_online_service_info_data_usage = 0;
                }
                this.getModelHandler().sendOnlineServiceDetailInfo(onlineOnlineServiceInfoCollectorArray);
                this.getModelHandler().setOnlineServiceConfiguredForAPN2(onlineService.getApn() == 2);
            } else {
                this._target.warn().append(this._classname).append("Service selected for detail view NOT FOUND").log();
            }
        }
    }

    public void submitCurrentServicesStateToBackend() {
        CoreServiceFactory.getCoreService().submitCurrentServicesStateToBackend();
        this.getListHandler().setCurrentSelectedPackage(null);
    }

    public int getPackageIndexWithPackageID(int n) {
        return this.getModelHandler().getPackageIndexWithPackageID(n);
    }

    @Override
    public void onNewPowerState(int n) {
        if (n == 2 || n == 0) {
            this.setPowerStateOn(n == 2);
        }
    }

    public boolean isPowerStateOn() {
        return this._powerStateOn;
    }

    public void setPowerStateOn(boolean bl) {
        this._powerStateOn = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ CoreServiceModelTarget access$000(CoreServiceModelController coreServiceModelController) {
        return coreServiceModelController._target;
    }
}

