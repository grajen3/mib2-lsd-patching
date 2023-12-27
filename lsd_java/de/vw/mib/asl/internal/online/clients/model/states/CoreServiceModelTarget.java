/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListenerAdapter;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelParentState;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelStateActive;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelStateAppActivation;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelStateAuthentication;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelStateNonActive;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelStateSpeller;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget$1;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceListener;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceUpdateListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public class CoreServiceModelTarget
extends AbstractASLHsmTarget
implements CoreServiceListener,
CoreServiceUpdateListener {
    private final String _classname = super.getClass().getName();
    private HsmState _currentState;
    private HsmState _parentState;
    private HsmState _stateActive;
    private HsmState _stateNotActive;
    private HsmState _stateAppActive;
    private HsmState _stateAuthenticate;
    private HsmState _stateSpeller;
    private final NavigationOnlinePoiListenerAdapter navigationOnlinePoiListenerAdapter = new CoreServiceModelTarget$1(this);
    final int[] OBSERVED_EVENTS = new int[]{513622272, -1239079424, 1305875264, 1238766400, 1255543616, 1289098048, 1322652480, 1339429696, 886444864, 936776512, 903222080, 953553728, 957022272, 550900544, 1577779264, 919999296, -896458496, -963567360, -1047453440, 1523979072, 1054217024, 1087771456, 970330944, 987108160, 1003885376, 1561002048, 1326121024, 1342898240, 1359675456, 1376452672, 121522432, 171854080, 806035456, 188631296, 205408512, 222185728, 1540756288};

    public CoreServiceModelTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.setCurrentState(this.getParentState());
    }

    private void startUp() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startUp()").log();
        }
        CoreServiceFactory.getCoreService().addUpdateListener(this);
        this.addObservers(this.OBSERVED_EVENTS);
        CoreServiceModelFactory.getCoreServiceModelController(this).getModelHandler().setActivationListLoading(true);
        CoreServiceFactory.getCoreService().isReady();
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.addParticipant(CoreServiceModelFactory.getCoreServiceModelController(this), FactoryResetComponents.ONLINE);
        factoryResetService.addListener(CoreServiceModelFactory.getCoreServiceModelController(this));
        ASLSystemFactory.getSystemApi().getPowerStateService().addListener(CoreServiceModelFactory.getCoreServiceModelController(this));
    }

    private void shutDown() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".shutDown()").log();
        }
        CoreServiceFactory.getCoreService().removeUpdateListener(this);
        this.removeObservers(this.OBSERVED_EVENTS);
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.removeParticipant(CoreServiceModelFactory.getCoreServiceModelController(this), FactoryResetComponents.ONLINE);
        factoryResetService.removeListener(CoreServiceModelFactory.getCoreServiceModelController(this));
    }

    public void setCurrentState(HsmState hsmState) {
        this._currentState = hsmState;
    }

    public HsmState getCurrentState() {
        return this._currentState;
    }

    public HsmState getParentState() {
        if (this._parentState == null) {
            this._parentState = new CoreServiceModelParentState(this, this.hsm, "ParentState", this.getWorkStateParent());
        }
        return this._parentState;
    }

    public HsmState getActiveState() {
        if (this._stateActive == null) {
            this._stateActive = new CoreServiceModelStateActive(this, this.hsm, "StateActive", this._parentState);
        }
        return this._stateActive;
    }

    public HsmState getAppActiveState() {
        if (this._stateAppActive == null) {
            this._stateAppActive = new CoreServiceModelStateAppActivation(this, this.hsm, "StateAppActive", this.getActiveState());
        }
        return this._stateAppActive;
    }

    public HsmState getAuthenticationState() {
        if (this._stateAuthenticate == null) {
            this._stateAuthenticate = new CoreServiceModelStateAuthentication(this, this.hsm, "StateAuthentication", this.getActiveState());
        }
        return this._stateAuthenticate;
    }

    public HsmState getSpellerState() {
        if (this._stateSpeller == null) {
            this._stateSpeller = new CoreServiceModelStateSpeller(this, this.hsm, "StateSpeller", this.getActiveState());
        }
        return this._stateSpeller;
    }

    public HsmState getNotActiveState() {
        if (this._stateNotActive == null) {
            this._stateNotActive = new CoreServiceModelStateNonActive(this, this.hsm, "StateNotActive", this._parentState);
        }
        return this._stateNotActive;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
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
        }
        super.gotEvent(eventGeneric);
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
    protected HsmState getDefaultState() {
        return this._parentState;
    }

    @Override
    public int getDefaultTargetId() {
        return 963515904;
    }

    @Override
    public void updateRegisteredDeviceType(int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1350172416);
            eventGeneric.setInt(0, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updateUserList(OnlineUser[] onlineUserArray) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1568276224);
            eventGeneric.setObject(0, onlineUserArray);
            eventGeneric.setInt(1, -1);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updateServiceList(OnlineService[] onlineServiceArray) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1467612928);
            eventGeneric.setString(0, "");
            eventGeneric.setObject(1, onlineServiceArray);
            eventGeneric.setInt(2, -1);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void resetToFactorySettingsResponse(int n, String string, int n2) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1585053440);
            eventGeneric.setInt(0, n);
            eventGeneric.setString(2, string);
            eventGeneric.setInt(4, n2);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void getUserListResponse(OnlineUser[] onlineUserArray, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1568276224);
            eventGeneric.setObject(0, onlineUserArray);
            eventGeneric.setInt(1, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void setActiveUserResponse(OnlineUser onlineUser, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1417281280);
            eventGeneric.setObject(0, onlineUser);
            eventGeneric.setInt(1, n);
            eventGeneric.setBoolean(2, true);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void getActiveUserResponse(OnlineUser onlineUser, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1417281280);
            eventGeneric.setObject(0, onlineUser);
            eventGeneric.setInt(1, n);
            eventGeneric.setBoolean(2, false);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void validatePinResponse(OnlineUser onlineUser, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), 222185728);
            eventGeneric.setObject(0, onlineUser);
            eventGeneric.setInt(1, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void verifyUserResponse(int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1534721792);
            eventGeneric.setInt(0, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void checkServiceStatusResponse(String string, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1517944576);
            eventGeneric.setString(1, string);
            eventGeneric.setInt(3, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void getServiceResponse(String string, OnlineService onlineService, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1484390144);
            eventGeneric.setString(1, string);
            eventGeneric.setObject(4, onlineService);
            eventGeneric.setInt(5, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void getServiceURLResponse(String string, String string2, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1434058496);
            eventGeneric.setString(0, string);
            eventGeneric.setString(2, string2);
            eventGeneric.setInt(3, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void setStateResponse(String string, OnlineService onlineService) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1450835712);
            eventGeneric.setString(1, string);
            eventGeneric.setObject(4, onlineService);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void resetToFactorySettingsWithServiceNameResponse(int n, String string, int n2) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1585053440);
            eventGeneric.setInt(0, n);
            eventGeneric.setString(3, string);
            eventGeneric.setInt(4, n2);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void checkServiceStatusWithServiceNameResponse(String string, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1517944576);
            eventGeneric.setString(2, string);
            eventGeneric.setInt(3, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void getServiceWithServiceNameResponse(String string, OnlineService onlineService, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1484390144);
            eventGeneric.setString(2, string);
            eventGeneric.setObject(4, onlineService);
            eventGeneric.setInt(5, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void getServiceURLWithServiceNameResponse(String string, String string2, int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1434058496);
            eventGeneric.setString(1, string);
            eventGeneric.setString(2, string2);
            eventGeneric.setInt(3, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void setStateWithServiceNameResponse(String string, OnlineService onlineService) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1450835712);
            eventGeneric.setString(2, string);
            eventGeneric.setObject(4, onlineService);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updateRegistrationStatus(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(new StringBuffer().append(".updateRegistrationStatus(").append(n).append(")").toString()).log();
        }
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1400504064);
            eventGeneric.setInt(0, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updateDeviceReadyForUse(int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1383726848);
            eventGeneric.setInt(0, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updateTrackingServicesActivation(OnlineTrackingService[] onlineTrackingServiceArray) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1333395200);
            eventGeneric.setObject(1, onlineTrackingServiceArray);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updatePrimaryUserPopupActivation(OnlineUser onlineUser) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1316617984);
            eventGeneric.setObject(0, onlineUser);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updateService(OnlineService onlineService) {
    }

    @Override
    public void updatePrivacyModeStatus(boolean bl) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1283063552);
            eventGeneric.setBoolean(0, bl);
            eventGeneric.setInt(1, -1);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void updateCumulativeServiceListState(int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1249509120);
            eventGeneric.setInt(0, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void getOnlineServiceListResponse(OnlineService[] onlineServiceArray, int n) {
    }

    @Override
    public void sendPrivacyModeStatusResponse(int n) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getDefaultTargetId(), -1283063552);
            eventGeneric.setInt(1, n);
            this.sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    public NavigationOnlinePoiListenerAdapter getNavigationOnlinePoiListenerAdapter() {
        return this.navigationOnlinePoiListenerAdapter;
    }
}

