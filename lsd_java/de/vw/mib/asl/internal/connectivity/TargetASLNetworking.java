/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.connectivity.ASLConnectivityAPI;
import de.vw.mib.asl.api.connectivity.ASLConnectivityFactory;
import de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedService;
import de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedUpdate;
import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.connectivity.TargetASLNetworking$NadListener;
import de.vw.mib.asl.internal.connectivity.TargetASLNetworking$Reset;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityNetworkProviderListCollector;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.connectivity.transformer.ConnectivityCurrentConnectionDetailsCollector;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConfiguration;
import org.dsi.ifc.networking.DSIDataConnection;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;

public class TargetASLNetworking
extends TripleMobileEquipment
implements InternetConnectionUserBlockedService {
    private DSIDataConfiguration dsiDataConfiguration;
    private DSIDataConnection dsiDataConnection;
    private DSIListener dsiDataConfigurationListener;
    private DSIListener dsiDataConnectionListener;
    private int nadMode = 0;
    private boolean pukRequired = false;
    private boolean isDataRoamingActivated = false;
    private boolean isNetworkSearchRunning = false;
    private int selectedNetworkIndex = -1;
    protected final int CONNECTIVITY_TRAFFIC_ACTIVE_TIMER_INTERVAL;
    protected final int CONNECTIVITY_CONNECTION_NOT_FOUND_TIMER_INTERVAL;
    protected static final int EV_INTERNAL_CONNECTIVITY_TRAFFIC_ACTIVE_TIMER;
    protected static final int EV_INTERNAL_CONNECTIVITY_CONNECTION_NOT_FOUND_TIMER;
    private final int SPELLER_MODE_NONE;
    private final int SPELLER_MODE_AP;
    private final int SPELLER_MODE_USER;
    private final int SPELLER_MODE_PASS;
    private int spellerMode = 0;
    private ASLAPISpellerBinding speller;
    private int confAuthMechanism;
    private String confUserName;
    private String confAPName;
    private String confPass;
    CDataProfile dataProfile = null;
    private boolean isFactoryResetOngoing = false;
    private boolean shownConfirmInternetPopup = false;
    private boolean confirmInternetConnection = false;
    private int nadLockState = 0;
    private int connectionMode = 0;
    private String puk = "";
    private String newPinTemp = "";
    private int wlanRole = 0;
    private boolean connectedViaLocalNet = false;
    private int lastSetOnlineConnectionMode = -1;
    private boolean alreadyRegistered = false;
    private boolean wizardRunning;
    private int dsiAccessBehaviorWizardStarted;
    private int dsiAccessBehavior;
    private boolean wizardCompleted;
    private boolean connectionClear;
    private FactoryResetCallback factoryResetCallback;
    private final HashMap listeners = new HashMap();
    private boolean internetBlockedByUser = false;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConnection;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfigurationListener;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConnectionListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService;

    public TargetASLNetworking(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.CONNECTIVITY_TRAFFIC_ACTIVE_TIMER_INTERVAL = 2000;
        this.CONNECTIVITY_CONNECTION_NOT_FOUND_TIMER_INTERVAL = 2000;
        this.SPELLER_MODE_NONE = 0;
        this.SPELLER_MODE_AP = 1;
        this.SPELLER_MODE_USER = 2;
        this.SPELLER_MODE_PASS = 3;
    }

    @Override
    public int getDefaultTargetId() {
        return 7801;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiDataConfiguration = (DSIDataConfiguration)dSIProxy.getService(this, class$org$dsi$ifc$networking$DSIDataConfiguration == null ? (class$org$dsi$ifc$networking$DSIDataConfiguration = TargetASLNetworking.class$("org.dsi.ifc.networking.DSIDataConfiguration")) : class$org$dsi$ifc$networking$DSIDataConfiguration);
            this.dsiDataConnection = (DSIDataConnection)dSIProxy.getService(this, class$org$dsi$ifc$networking$DSIDataConnection == null ? (class$org$dsi$ifc$networking$DSIDataConnection = TargetASLNetworking.class$("org.dsi.ifc.networking.DSIDataConnection")) : class$org$dsi$ifc$networking$DSIDataConnection);
            this.dsiDataConfigurationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$networking$DSIDataConfigurationListener == null ? (class$org$dsi$ifc$networking$DSIDataConfigurationListener = TargetASLNetworking.class$("org.dsi.ifc.networking.DSIDataConfigurationListener")) : class$org$dsi$ifc$networking$DSIDataConfigurationListener);
            this.dsiDataConnectionListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$networking$DSIDataConnectionListener == null ? (class$org$dsi$ifc$networking$DSIDataConnectionListener = TargetASLNetworking.class$("org.dsi.ifc.networking.DSIDataConnectionListener")) : class$org$dsi$ifc$networking$DSIDataConnectionListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$networking$DSIDataConfigurationListener == null ? (class$org$dsi$ifc$networking$DSIDataConfigurationListener = TargetASLNetworking.class$("org.dsi.ifc.networking.DSIDataConfigurationListener")) : class$org$dsi$ifc$networking$DSIDataConfigurationListener, this.dsiDataConfigurationListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$networking$DSIDataConnectionListener == null ? (class$org$dsi$ifc$networking$DSIDataConnectionListener = TargetASLNetworking.class$("org.dsi.ifc.networking.DSIDataConnectionListener")) : class$org$dsi$ifc$networking$DSIDataConnectionListener, this.dsiDataConnectionListener);
            this.addObserver(536936512);
            this.addObserver(369164352);
            this.addObserver(83951680);
            this.addObserver(1544159296);
            this.addObserver(940179520);
            this.addObserver(956956736);
            this.addObserver(1007288384);
            this.addObserver(1024065600);
            this.addObserver(0x400A0040);
            this.addObserver(302055488);
            this.addObserver(0x10010040);
            this.addObserver(352387136);
            this.addObserver(554303552);
            this.addObserver(1275789376);
            this.addObserver(1175257920);
            this.addObserver(1192035136);
            this.addObserver(1208812352);
            this.addObserver(1225589568);
            this.addObserver(469827648);
            this.addObserver(-670433216);
            this.addObserver(453050432);
            this.addObserver(1477115968);
            this.addObserver(1963655232);
            this.addObserver(1074594624);
            this.addObserver(1124926272);
            this.addObserver(1091371840);
            this.addObserver(1242366784);
            this.addObserver(1275921216);
            this.addObserver(1292698432);
            this.addObserver(1494025024);
            this.addObserver(-930012928);
            this.addObserver(-1611778560);
            this.addObserver(1460470592);
            this.addObserver(1426916160);
            this.addObserver(1443693376);
            ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(new TargetASLNetworking$Reset(this, null), FactoryResetComponents.CONNECTIVITY);
            ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = new ConnectivityCurrentConnectionDetailsCollector();
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_conn_available = false;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_duration_hours = 0;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_duration_minutes = 0;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_name = "";
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_signal_strength = 0;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic = 0;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic__current_session = 0L;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic__since_last_reset = 0L;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic_downlink = 0L;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic_uplink = 0L;
            ListManager.getGenericASLList(365).updateList(new ConnectivityCurrentConnectionDetailsCollector[]{connectivityCurrentConnectionDetailsCollector});
            this.speller = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(3711, 469827648, 453050432, -670433216);
            ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
            aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService == null ? (class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService = TargetASLNetworking.class$("de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedService")) : class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService, this);
            TargetASLNetworking.writeIntegerToDatapool(1664353024, 5);
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    @Override
    protected int[] getMobileEquipmentNadOnlyNotification() {
        return new int[]{4, 33, 16, 22, 24, 27};
    }

    private void setNotification() {
        this.dsiDataConfiguration.setNotification(new int[]{3, 4, 1, 2, 12, 6}, this.dsiDataConfigurationListener);
        this.dsiDataConnection.setNotification(new int[]{4, 3}, this.dsiDataConnectionListener);
    }

    @Override
    protected void powerOn() {
        this.init();
        this.setNotification();
    }

    @Override
    protected void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742112: {
                this.isDataRoamingActivated = !this.isDataRoamingActivated;
                this.dsiDataConfiguration.setRoamingState(this.isDataRoamingActivated ? 0 : 1);
                TargetASLNetworking.writeBooleanToDatapool(349, this.isDataRoamingActivated);
                break;
            }
            case 0x40000110: {
                this.isFactoryResetOngoing = true;
                this.dsiDataConfiguration.restoreFactorySettings();
                break;
            }
            case 1073744757: {
                this.dsiDataConfiguration.resetPacketCounter();
                break;
            }
            case 1073742101: {
                int n = eventGeneric.getInt(0);
                CDataProfile cDataProfile = (CDataProfile)ListManager.getGenericASLList(367).getRowItem(n);
                cDataProfile.profileID = 0;
                this.dsiDataConfiguration.setDataProfile(cDataProfile);
                break;
            }
            case 1073941824: {
                this.shownConfirmInternetPopup = eventGeneric.getBoolean(0);
                break;
            }
            case 1073742085: {
                this.confirmInternetConnection = true;
                this.dsiDataConfiguration.acceptDataRequest(100, true);
                this.onInternetBlockedByUserChanged(false);
                break;
            }
            case 1073744476: {
                this.confirmInternetConnection = false;
                this.dsiDataConfiguration.acceptDataRequest(100, false);
                this.onInternetBlockedByUserChanged(true);
                break;
            }
            case 1073742102: {
                int n = eventGeneric.getInt(0);
                int n2 = -1;
                switch (n) {
                    case 0: {
                        n2 = 2;
                        break;
                    }
                    case 1: {
                        n2 = 1;
                        break;
                    }
                    case 2: {
                        n2 = 0;
                        break;
                    }
                }
                if (n2 == -1) break;
                this.dsiDataConfiguration.setConnectionMode(n2);
                TargetASLNetworking.writeIntegerToDatapool(351, n);
                break;
            }
            case 1073744441: {
                this.dsiDataConfiguration.automaticProfile(0);
                break;
            }
            case 100000: {
                TargetASLNetworking.writeBooleanToDatapool(3713, false);
                TargetASLNetworking.writeBooleanToDatapool(1597244160, false);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-980344576);
                eventGeneric2.setBoolean(0, false);
                this.triggerObserver(-980344576, eventGeneric2);
                break;
            }
            case 1073744444: {
                this.speller.initSpeller(this.confAPName);
                this.spellerMode = 1;
                break;
            }
            case 1073744445: {
                this.speller.initSpeller(this.confUserName);
                this.spellerMode = 2;
                break;
            }
            case 0x40000A40: {
                this.speller.initSpeller(this.confPass);
                this.spellerMode = 3;
                break;
            }
            case 1073744716: {
                this.speller.initSpeller("");
                break;
            }
            case 1073744728: {
                this.handlePinEntryFinished(this.pukRequired ? 2 : 0, true);
                break;
            }
            case 1073941830: {
                this.handlePinEntryFinished(0, false);
                break;
            }
            case 1073941831: {
                this.puk = this.speller.getSpellerData().getEnteredText();
                this.speller.initSpeller("");
                break;
            }
            case 1073941832: {
                this.newPinTemp = this.speller.getSpellerData().getEnteredText();
                this.speller.initSpeller("");
                break;
            }
            case 1073941833: {
                this.getNad().requestUnlockSIM(2, this.puk, this.speller.getSpellerData().getEnteredText());
                break;
            }
            case 1073744600: {
                this.speller.handleEvent(eventGeneric);
                break;
            }
            case 1073742107: 
            case 1073742108: {
                this.speller.handleEvent(eventGeneric);
                if (this.newPinTemp.equals(this.speller.getSpellerData().getEnteredText())) {
                    TargetASLNetworking.writeBooleanToDatapool(1496580864, true);
                    break;
                }
                TargetASLNetworking.writeBooleanToDatapool(1496580864, false);
                break;
            }
            case 1073744417: {
                int n = eventGeneric.getInt(0);
                this.confAuthMechanism = this.convertASLDataAuthenticationToDSI(n);
                TargetASLNetworking.writeIntegerToDatapool(3620, n);
                break;
            }
            case 1073742098: {
                switch (this.spellerMode) {
                    case 2: {
                        this.confUserName = this.speller.getSpellerData().getEnteredText();
                        TargetASLNetworking.writeStringToDatapool(3695, this.confUserName);
                        break;
                    }
                    case 1: {
                        this.confAPName = this.speller.getSpellerData().getEnteredText();
                        TargetASLNetworking.writeStringToDatapool(3694, this.confAPName);
                        break;
                    }
                    case 3: {
                        this.confPass = this.speller.getSpellerData().getEnteredText();
                        TargetASLNetworking.writeStringToDatapool(3696, this.confPass);
                        break;
                    }
                    default: {
                        this.trace("wrong speller Mode!");
                    }
                }
                this.spellerMode = 0;
                break;
            }
            case 1073744440: {
                this.dsiDataConfiguration.setDataProfile(new CDataProfile(this.dataProfile.getProfileID(), this.dataProfile.getDataProfileName(), this.confAPName, this.confUserName, this.confPass, this.confAuthMechanism, this.dataProfile.getProvider(), this.dataProfile.isIsAPNvisible(), this.dataProfile.getDataAPN2(), this.dataProfile.getDataUserName2(), this.dataProfile.getDataPassword2(), this.dataProfile.isIsAPN2visible()));
                break;
            }
            case 1073941834: {
                this.confAPName = this.dataProfile.getDataAPN();
                TargetASLNetworking.writeStringToDatapool(3694, this.confAPName);
                this.confUserName = this.dataProfile.getDataUserName();
                TargetASLNetworking.writeStringToDatapool(3695, this.confUserName);
                this.confPass = this.dataProfile.getDataPassword();
                TargetASLNetworking.writeStringToDatapool(3696, this.confPass);
                this.confAuthMechanism = this.dataProfile.getDataAuthentication();
                TargetASLNetworking.writeIntegerToDatapool(3620, this.convertDSIDataAuthenticationToASL(this.confAuthMechanism));
                break;
            }
            case 1073941849: {
                this.getNad().requestAbortNetworkSearch();
                break;
            }
            case 1073941827: 
            case 1073941837: {
                if (!this.isNetworkSearchRunning) {
                    this.getNad().requestNetworkSearch();
                    this.isNetworkSearchRunning = true;
                }
                TargetASLNetworking.writeBooleanToDatapool(1362363136, true);
                break;
            }
            case 1073941825: {
                this.selectedNetworkIndex = eventGeneric.getInt(0);
                ConnectivityNetworkProviderListCollector connectivityNetworkProviderListCollector = (ConnectivityNetworkProviderListCollector)ListManager.getGenericASLList(1379140352).getRowItem(this.selectedNetworkIndex);
                connectivityNetworkProviderListCollector.isLoading = true;
                ListManager.getGenericASLList(1379140352).updateListItem(this.selectedNetworkIndex, connectivityNetworkProviderListCollector);
                this.getNad().requestNetworkRegistration(connectivityNetworkProviderListCollector.networkProvider.telNumProviderName, 0);
                break;
            }
            case 2200008: {
                this.wlanRole = eventGeneric.getInt(0);
                this.setOnlineConnectionModeToModel();
                break;
            }
            case 1073941836: {
                if (!eventGeneric.getBoolean(0)) break;
                if (this.isNetworkSearchRunning) {
                    this.getNad().requestAbortNetworkSearch();
                }
                this.selectedNetworkIndex = -1;
                this.getNad().requestNetworkRegistration("", 1);
                break;
            }
            case 100001: {
                if (this.nadLockState != 2 || this.isFactoryResetOngoing || ASLPhoneFactory.getPhoneApi().isToggleOtherPINRequested()) break;
                TargetASLNetworking.writeBooleanToDatapool(3712, true);
                this.sendHMIEvent(530);
                break;
            }
            case 1073941847: {
                break;
            }
            case 1073941845: {
                this.wizardCompleted = eventGeneric.getBoolean(0);
                break;
            }
            case 1073941846: {
                this.wizardRunning = eventGeneric.getBoolean(0);
                if (this.wizardRunning) {
                    this.dsiAccessBehaviorWizardStarted = this.dsiAccessBehavior;
                    if (this.connectedViaLocalNet || !this.connectionClear || this.dsiAccessBehavior == 0) break;
                    this.dsiDataConfiguration.setConnectionMode(0);
                    break;
                }
                if (this.wizardCompleted || this.dsiAccessBehaviorWizardStarted == this.dsiAccessBehavior) break;
                this.dsiDataConfiguration.setConnectionMode(this.dsiAccessBehaviorWizardStarted);
                break;
            }
        }
    }

    private void handlePinEntryFinished(int n, boolean bl) {
        this.getNad().requestUnlockSIM(this.pukRequired ? 2 : 0, this.speller.getSpellerData().getEnteredText(), "");
        boolean bl2 = ASLPhoneData.getInstance().isAutomaticPinEntryCancelled = !bl;
        if (ASLPhoneData.getInstance().lockState == 2) {
            this.getNad().requestSetAutomaticPinEntryActive(bl);
            ASLPhoneData.getInstance().isAutomaticPinEntryPending = false;
        } else {
            ASLPhoneData.getInstance().isSimUnlockedByUserAfterInserting = true;
            ASLPhoneData.getInstance().isAutomaticPinEntryPending = true;
        }
    }

    private void onInternetBlockedByUserChanged(boolean bl) {
        this.internetBlockedByUser = bl;
        Iterator iterator = this.listeners.values().iterator();
        while (iterator.hasNext()) {
            InternetConnectionUserBlockedUpdate internetConnectionUserBlockedUpdate = (InternetConnectionUserBlockedUpdate)iterator.next();
            internetConnectionUserBlockedUpdate.onInternetBlockedByUserChanged(bl);
        }
    }

    private int convertASLDataAuthenticationToDSI(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("convertASLDataAuthenticationToDSI - illegal dataAuthentication: ").append(n).toString());
    }

    private int convertDSIDataAuthenticationToASL(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("convertDSIDataAuthenticationToASL - illegal dataAuthentication: ").append(n).toString());
    }

    private void setConfigurationDetails(CDataProfile cDataProfile) {
        this.dataProfile = cDataProfile;
        this.confUserName = this.dataProfile.getDataUserName();
        TargetASLNetworking.writeStringToDatapool(3695, this.confUserName);
        this.confAPName = this.dataProfile.getDataAPN();
        TargetASLNetworking.writeStringToDatapool(3694, this.confAPName);
        this.confPass = this.dataProfile.getDataPassword();
        TargetASLNetworking.writeStringToDatapool(3696, this.confPass);
        this.confAuthMechanism = this.dataProfile.getDataAuthentication();
        TargetASLNetworking.writeIntegerToDatapool(3620, this.convertDSIDataAuthenticationToASL(this.dataProfile.getDataAuthentication()));
        ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = (ConnectivityCurrentConnectionDetailsCollector)ListManager.getGenericASLList(365).getDSIObjects()[0];
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_name = Util.isNullOrEmpty(cDataProfile.getDataProfileName()) ? "" : cDataProfile.getDataProfileName();
        ListManager.getGenericASLList(365).updateListItem(0, connectivityCurrentConnectionDetailsCollector);
    }

    public void dsiDataConfigurationAutomaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
        Object[] objectArray = ListManager.getGenericASLList(367).getDSIObjects();
        if (!Util.isNullOrEmpty(objectArray) && objectArray.length == 1) {
            this.dsiDataConfiguration.setDataProfile((CDataProfile)objectArray[0]);
        }
    }

    public void dsiDataConfigurationUpdateRoamingState(int n, int n2) {
        this.isDataRoamingActivated = n == 0;
        TargetASLNetworking.writeBooleanToDatapool(349, this.isDataRoamingActivated);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-896458496);
        eventGeneric.setBoolean(0, this.isDataRoamingActivated);
        this.triggerObserver(-896458496, eventGeneric);
    }

    public void dsiDataConfigurationUpdateConnectionMode(int n, int n2) {
        this.dsiAccessBehavior = n;
        switch (n) {
            case 2: {
                TargetASLNetworking.writeIntegerToDatapool(351, 0);
                this.onInternetBlockedByUserChanged(true);
                break;
            }
            case 1: {
                TargetASLNetworking.writeIntegerToDatapool(351, 1);
                n = 1;
                this.onInternetBlockedByUserChanged(true);
                break;
            }
            case 0: {
                TargetASLNetworking.writeIntegerToDatapool(351, 2);
                this.onInternetBlockedByUserChanged(false);
                break;
            }
            default: {
                TargetASLNetworking.writeIntegerToDatapool(351, 2);
            }
        }
    }

    public void dsiDataConfigurationUpdateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
        this.stopTimer(-1585053440);
        TargetASLNetworking.writeBooleanToDatapool(3712, false);
        if (cDataProfileArray.length == 1) {
            ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = (ConnectivityCurrentConnectionDetailsCollector)ListManager.getGenericASLList(365).getDSIObjects()[0];
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_conn_available = true;
            connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_name = cDataProfileArray[0].getDataProfileName();
            ListManager.getGenericASLList(365).updateListItem(0, connectivityCurrentConnectionDetailsCollector);
            this.connectionClear = true;
            TargetASLNetworking.writeBooleanToDatapool(3657, this.connectionClear);
            this.setConfigurationDetails(cDataProfileArray[0]);
            if (this.wizardRunning && this.dsiAccessBehavior != 0) {
                this.dsiDataConfiguration.setConnectionMode(0);
            }
        } else {
            this.connectionClear = false;
            TargetASLNetworking.writeBooleanToDatapool(3657, this.connectionClear);
            this.resetConfigurationDetails();
            if (this.nadLockState == 2 && cDataProfileArray.length == 0 && !this.isFactoryResetOngoing && !ASLPhoneFactory.getPhoneApi().isToggleOtherPINRequested()) {
                this.startTimer(-1585053440, (long)0, false);
            }
            if (cDataProfileArray.length > 1) {
                this.sendHMIEvent(529);
            }
        }
        ListManager.getGenericASLList(367).updateList(cDataProfileArray);
    }

    private void resetConfigurationDetails() {
        CDataProfile cDataProfile = new CDataProfile(0, "", "", "", "", 0, "", false, "", "", "", false);
        this.setConfigurationDetails(cDataProfile);
    }

    public void dsiDataConfigurationUpdatePacketCounter(CPacketCounter cPacketCounter, int n) {
        ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = (ConnectivityCurrentConnectionDetailsCollector)ListManager.getGenericASLList(365).getDSIObjects()[0];
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_duration_hours = cPacketCounter.getConnectionDuration() / 3600;
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_duration_minutes = cPacketCounter.getConnectionDuration() / 60;
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic__current_session = (cPacketCounter.getTxBytes() + cPacketCounter.getRxBytes()) / 0;
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic = (int)((cPacketCounter.getTxBytes() + cPacketCounter.getRxBytes()) / 0);
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic__since_last_reset = (cPacketCounter.getTxBytesSinceReset() + cPacketCounter.getRxBytesSinceReset()) / 0;
        connectivityCurrentConnectionDetailsCollector.connectivity_connection_details_traffic_since_last_reset = (int)((cPacketCounter.getTxBytesSinceReset() + cPacketCounter.getRxBytesSinceReset()) / 0);
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic_uplink = cPacketCounter.getTxBytes();
        connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic_downlink = cPacketCounter.getRxBytes();
        ListManager.getGenericASLList(365).updateListItem(0, connectivityCurrentConnectionDetailsCollector);
        boolean bl = this.nadMode == 1 && this.isNadPrimary();
        TargetASLNetworking.writeBooleanToDatapool(3713, bl);
        TargetASLNetworking.writeBooleanToDatapool(1597244160, !bl);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-980344576);
        eventGeneric.setBoolean(0, true);
        this.triggerObserver(-980344576, eventGeneric);
        this.retriggerOrStartTimer(-1601830656, (long)0, false);
    }

    public void dsiDataConfigurationUpdateDataRequest(int n, int n2) {
        TargetASLNetworking.writeBooleanToDatapool(1429472000, true);
        if (!this.shownConfirmInternetPopup) {
            this.sendHMIEvent(15);
        } else {
            this.dsiDataConfiguration.acceptDataRequest(100, this.confirmInternetConnection);
        }
    }

    public void dsiDataConnectionUpdateConnectionStateInformation(ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
        if (connectionStateInformationStruct.getApplicationID() == 100) {
            this.connectedViaLocalNet = false;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1047453440);
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-1030676224);
            if (connectionStateInformationStruct.getConnectionState() == 22) {
                eventGeneric.setBoolean(0, true);
                if (this.nadLockState == 2) {
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
                        eventGeneric2.setInt(0, 1);
                    } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(30)) {
                        eventGeneric2.setInt(0, 2);
                    } else {
                        this.error("Lock state NO_LOCK but neither SIM nor surfstick is supported. Theremust be something wrong!");
                        eventGeneric2.setInt(0, 0);
                    }
                } else {
                    eventGeneric2.setInt(0, 3);
                }
                TargetASLNetworking.writeBooleanToDatapool(1429472000, true);
            } else if (connectionStateInformationStruct.getConnectionState() == 26) {
                eventGeneric.setBoolean(0, true);
                eventGeneric2.setInt(0, 4);
                TargetASLNetworking.writeBooleanToDatapool(1429472000, true);
                this.connectionClear = true;
                TargetASLNetworking.writeBooleanToDatapool(3657, this.connectionClear);
                TargetASLNetworking.writeIntegerToDatapool(351, 2);
                TargetASLNetworking.writeBooleanToDatapool(349, false);
                this.connectedViaLocalNet = true;
            } else {
                eventGeneric.setBoolean(0, false);
                eventGeneric2.setInt(0, 0);
                TargetASLNetworking.writeBooleanToDatapool(1429472000, false);
            }
            this.triggerObserver(-1047453440, eventGeneric);
            this.triggerObserver(-1030676224, eventGeneric2);
        }
        this.setOnlineConnectionModeToModel();
    }

    private void setOnlineConnectionModeToModel() {
        ASLConnectivityAPI aSLConnectivityAPI = ASLConnectivityFactory.getConnectivityApi();
        aSLConnectivityAPI.setSimOrSurfstickInserted(false);
        this.connectionMode = -1;
        if ((this.wlanRole == 2 || this.wlanRole == 3) && aSLConnectivityAPI.isWLANActivated()) {
            this.connectionMode = 3;
        } else if (this.nadLockState != 0) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
                aSLConnectivityAPI.setSimOrSurfstickInserted(true);
                this.connectionMode = 1;
            } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(30)) {
                aSLConnectivityAPI.setSimOrSurfstickInserted(true);
                this.connectionMode = 2;
            }
        } else {
            this.connectionMode = this.connectedViaLocalNet ? 4 : 0;
        }
        if (this.connectionMode != this.lastSetOnlineConnectionMode) {
            TargetASLNetworking.writeIntegerToDatapool(1479803648, this.connectionMode);
            this.lastSetOnlineConnectionMode = this.connectionMode;
        }
        TargetASLNetworking.writeBooleanToDatapool(1513358080, this.nadMode == 1 && this.nadLockState != 0 && this.isNadPrimary());
    }

    public void dsiDataConnectionUpdateRoamingState(int n, int n2) {
        boolean bl = n == 11;
        TargetASLNetworking.writeBooleanToDatapool(3929, bl);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-963567360);
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(-963567360, eventGeneric);
    }

    public void dsiDataConfigurationRestoreFactorySettingsResponse(int n) {
        this.isFactoryResetOngoing = false;
        this.dsiDataConfiguration.automaticProfile(0);
        if (this.factoryResetCallback != null) {
            this.factoryResetCallback.notifyResetDone();
        }
    }

    private void setStatusLinePinPuk() {
        if (this.nadMode == 2) {
            TargetASLNetworking.writeBooleanToDatapool(1580466944, this.nadLockState == 3);
            TargetASLNetworking.writeBooleanToDatapool(1563689728, this.nadLockState == 5);
        } else {
            TargetASLNetworking.writeBooleanToDatapool(1580466944, false);
            TargetASLNetworking.writeBooleanToDatapool(1563689728, false);
        }
    }

    private static int convertNetworkTypeDSI2ASLInternal(int n) {
        switch (n) {
            case 1: 
            case 2: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
        }
        return 0;
    }

    private static int convertNetworkTypeDSI2Model(int n) {
        switch (n) {
            case 1: 
            case 2: {
                return 3;
            }
            case 3: 
            case 4: {
                return 0;
            }
            case 5: {
                return 2;
            }
        }
        return 5;
    }

    private int convertSignalStrengthDSI2ASLInternal(int n) {
        if (n == 0 || n == 255) {
            return 0;
        }
        if (n < 21) {
            return 1;
        }
        if (n < 41) {
            return 2;
        }
        if (n < 61) {
            return 3;
        }
        if (n < 81) {
            return 4;
        }
        if (n < 101) {
            return 5;
        }
        return n;
    }

    @Override
    protected DSIMobileEquipmentListener createNadListener() {
        return new TargetASLNetworking$NadListener(this, null);
    }

    @Override
    public void register(InternetConnectionUserBlockedUpdate internetConnectionUserBlockedUpdate) {
        InternetConnectionUserBlockedUpdate internetConnectionUserBlockedUpdate2 = (InternetConnectionUserBlockedUpdate)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(internetConnectionUserBlockedUpdate);
        this.listeners.put(internetConnectionUserBlockedUpdate, internetConnectionUserBlockedUpdate2);
        internetConnectionUserBlockedUpdate.onInternetBlockedByUserChanged(this.internetBlockedByUser);
    }

    @Override
    public void unregister(InternetConnectionUserBlockedUpdate internetConnectionUserBlockedUpdate) {
        this.listeners.remove(internetConnectionUserBlockedUpdate);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ int access$100(int n) {
        return TargetASLNetworking.convertNetworkTypeDSI2ASLInternal(n);
    }

    static /* synthetic */ int access$200(int n) {
        return TargetASLNetworking.convertNetworkTypeDSI2Model(n);
    }

    static /* synthetic */ int access$300(TargetASLNetworking targetASLNetworking, int n) {
        return targetASLNetworking.convertSignalStrengthDSI2ASLInternal(n);
    }

    static /* synthetic */ boolean access$402(TargetASLNetworking targetASLNetworking, boolean bl) {
        targetASLNetworking.isNetworkSearchRunning = bl;
        return targetASLNetworking.isNetworkSearchRunning;
    }

    static /* synthetic */ int access$502(TargetASLNetworking targetASLNetworking, int n) {
        targetASLNetworking.nadMode = n;
        return targetASLNetworking.nadMode;
    }

    static /* synthetic */ void access$600(TargetASLNetworking targetASLNetworking) {
        targetASLNetworking.setOnlineConnectionModeToModel();
    }

    static /* synthetic */ void access$700(TargetASLNetworking targetASLNetworking) {
        targetASLNetworking.setStatusLinePinPuk();
    }

    static /* synthetic */ int access$802(TargetASLNetworking targetASLNetworking, int n) {
        targetASLNetworking.nadLockState = n;
        return targetASLNetworking.nadLockState;
    }

    static /* synthetic */ int access$800(TargetASLNetworking targetASLNetworking) {
        return targetASLNetworking.nadLockState;
    }

    static /* synthetic */ boolean access$902(TargetASLNetworking targetASLNetworking, boolean bl) {
        targetASLNetworking.pukRequired = bl;
        return targetASLNetworking.pukRequired;
    }

    static /* synthetic */ void access$1000(TargetASLNetworking targetASLNetworking) {
        targetASLNetworking.resetConfigurationDetails();
    }

    static /* synthetic */ FactoryResetCallback access$1202(TargetASLNetworking targetASLNetworking, FactoryResetCallback factoryResetCallback) {
        targetASLNetworking.factoryResetCallback = factoryResetCallback;
        return targetASLNetworking.factoryResetCallback;
    }

    static /* synthetic */ boolean access$1302(TargetASLNetworking targetASLNetworking, boolean bl) {
        targetASLNetworking.isFactoryResetOngoing = bl;
        return targetASLNetworking.isFactoryResetOngoing;
    }

    static /* synthetic */ DSIDataConfiguration access$1400(TargetASLNetworking targetASLNetworking) {
        return targetASLNetworking.dsiDataConfiguration;
    }
}

