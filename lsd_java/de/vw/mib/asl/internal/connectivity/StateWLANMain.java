/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.connectivity.ASLWLANData;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN;
import de.vw.mib.asl.internal.connectivity.StateWLANMain$1;
import de.vw.mib.asl.internal.connectivity.StateWLANMain$Reset;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWLANHotspotHotspotListCollector;
import de.vw.mib.asl.internal.connectivity.transformer.WlanTrustedNetworkCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;
import org.dsi.ifc.powermanagement.ClampSignal;

public class StateWLANMain
extends AbstractHsmState {
    public static final String ASCII_CHARS_LIMITED;
    private final HsmTargetWLAN myTarget;
    private String hotspotToConnectNetworkName = "";
    private String hotspotToConnectNetworkKey = "";
    private String connectedHotspotNetworkBSSID = "";
    private int hotspotToConnectSecurityLevel = 7;
    ValetParkingCallback valetParkingCallback;
    private ConnectivityWLANHotspotHotspotListCollector selectedHotspot;
    private WlanTrustedNetworkCollector[] trustedNetworks = new WlanTrustedNetworkCollector[0];
    private int wlanRole = 0;
    private boolean pendingHotspotState;
    private boolean pendingSetRole;
    private boolean pendingSetProfile;
    private boolean pendingClientActivate;
    private boolean pendingWLANActivate = false;
    private int connectedNodes = 0;
    private boolean noNetworkKeySet = false;
    private FactoryResetCallback factoryResetCallback;
    private final FactoryResetParticipant factoryResetParticipant = new StateWLANMain$Reset(this, null);
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLAN;

    public StateWLANMain(HsmTargetWLAN hsmTargetWLAN, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetWLAN;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered HSM_START.");
                this.myTarget.init();
                this.myTarget.setNotification();
                ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(this.factoryResetParticipant, FactoryResetComponents.WLAN);
                break;
            }
            case 4: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered HSM_EXIT.");
                HsmTargetWLAN.removeObservers(this.myTarget);
                ASLSystemFactory.getSystemApi().getFactoryResetService().removeParticipant(this.factoryResetParticipant, FactoryResetComponents.WLAN);
                break;
            }
            case 1073744678: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_ENTER_WLAN_KEY.");
                this.setSpellerData("", true);
                break;
            }
            case 1073744677: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_ENTER_WLANSSID.");
                this.setSpellerData(ASLWLANData.getPendingProfile().sSID, true);
                break;
            }
            case 0x40000111: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_RESET_WLAN_SETTINGS.");
                this.resetWLANSettings();
                break;
            }
            case 1073744683: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SAVE_WLAN_KEY.");
                this.setActiveKey(this.myTarget.spellerHsmConnectivity.getSpellerData().getEnteredText());
                break;
            }
            case 1073744682: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SAVE_WLANSSID.");
                String string = this.myTarget.spellerHsmConnectivity.getSpellerData().getEnteredText();
                this.setWLANSid(string);
                break;
            }
            case 1073744417: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SET_AUTHENTICATION_MECHANISM.");
                break;
            }
            case 1073742105: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SET_WLAN_ENCRYPTION_MODE.");
                break;
            }
            case 1073941856: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SET_WLAN_SECURITY_LEVEL5.");
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("[WLANMain] set securityLevel to: ").append(eventGeneric.getInt(0)).log();
                }
                this.setWLANSecurityLevel2(eventGeneric.getInt(0));
                break;
            }
            case 1073742111: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_TOGGLE_WLAN_ACTIVATED.");
                boolean bl = ASLWLANData.isWLANActivated();
                if (bl) {
                    if (this.wlanRole == 4) {
                        this.setRoleAP();
                        break;
                    }
                    if (this.wlanRole == 1) {
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(32)) {
                            this.setRoleCombined();
                            break;
                        }
                        this.setRoleClient();
                        break;
                    }
                    if (this.wlanRole != 2) break;
                    this.setWLANActivated(false);
                    break;
                }
                this.pendingClientActivate = true;
                this.setRoleClient();
                break;
            }
            case 1073941842: {
                if (!this.pendingHotspotState) {
                    this.pendingHotspotState = true;
                    AbstractASLHsmTarget.writeBooleanToDatapool(1798570752, true);
                } else if (this.pendingHotspotState) {
                    this.pendingHotspotState = false;
                    AbstractASLHsmTarget.writeBooleanToDatapool(1798570752, false);
                }
                this.pendingSetProfile = false;
                boolean bl = ASLWLANData.isWLANActivated();
                if (bl) {
                    if (this.wlanRole == 4) {
                        if (this.pendingHotspotState) break;
                        this.setRoleClient();
                        this.pendingSetProfile = true;
                        break;
                    }
                    if (this.wlanRole == 2) {
                        if (!this.pendingHotspotState) break;
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(32)) {
                            this.setRoleCombined();
                            break;
                        }
                        this.setRoleAP();
                        this.pendingSetProfile = true;
                        break;
                    }
                    if (this.wlanRole != 1 || this.pendingHotspotState) break;
                    this.setWLANActivated(false);
                    break;
                }
                if (!this.pendingHotspotState) break;
                this.setRoleAP();
                this.pendingWLANActivate = true;
                break;
            }
            case 1073742113: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_TOGGLE_WLAN_CONCEALED.");
                this.toggleWLANConcealed();
                break;
            }
            case 1073941843: {
                this.pendingSetProfile = false;
                this.pendingSetRole = false;
                this.myTarget.trace("[WLANHotspotMAin] Target WLAN entered ASL_CONNECTIVITY_TOGGLE_WLAN_HOTSPOT_ACTIVATED.");
                this.sendProfileData();
                break;
            }
            case 1073744567: {
                this.setSpellerData("", false);
                break;
            }
            case 1073744568: {
                this.setSpellerData("", false);
                break;
            }
            case 1073744681: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_ENTER_WLAN_CLIENT_SELECTED_HOTSPOT_NETWORKKEY.");
                this.setSpellerData("", false);
                break;
            }
            case 1073744686: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SAVE_WLAN_CLIENT_SELECTED_HOTSPOT_NETWORKKEY.");
                String string = this.myTarget.spellerHsmConnectivity.getSpellerData().getEnteredText();
                ConnectivityWLANHotspotHotspotListCollector[] connectivityWLANHotspotHotspotListCollectorArray = (ConnectivityWLANHotspotHotspotListCollector[])ListManager.getGenericASLList(4004).getDSIObjects();
                for (int i2 = 0; i2 < connectivityWLANHotspotHotspotListCollectorArray.length; ++i2) {
                    if (!connectivityWLANHotspotHotspotListCollectorArray[i2].discoveredNetwork.getBssidAddress().equals(this.selectedHotspot.discoveredNetwork.getBssidAddress())) continue;
                    AbstractASLHsmTarget.writeIntegerToDatapool(4002, i2);
                }
                this.noNetworkKeySet = false;
                this.connectWLAN(this.selectedHotspot.discoveredNetwork.getNetworkName(), this.selectedHotspot.discoveredNetwork.getBssidAddress(), string, this.selectedHotspot.discoveredNetwork.getEncryptionType());
                break;
            }
            case 1073744679: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_ENTER_WLAN_CLIENT_STATIC_HOTSPOT_NETWORKKEY.");
                this.setSpellerData(this.hotspotToConnectNetworkKey, false);
                break;
            }
            case 1073744684: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SAVE_WLAN_CLIENT_STATIC_HOTSPOTNETWORKKEY.");
                this.hotspotToConnectNetworkKey = this.myTarget.spellerHsmConnectivity.getSpellerData().getEnteredText();
                AbstractASLHsmTarget.writeStringToDatapool(4024, this.hotspotToConnectNetworkKey);
                break;
            }
            case 1073744680: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_ENTER_WLAN_CLIENT_STATIC_HOTSPOT_NETWORKNAME.");
                this.setSpellerData(this.hotspotToConnectNetworkName, false);
                break;
            }
            case 1073744685: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SAVE_WLAN_CLIENT_STATIC_HOTSPOTNETWORKNAME.");
                this.hotspotToConnectNetworkName = this.myTarget.spellerHsmConnectivity.getSpellerData().getEnteredText();
                AbstractASLHsmTarget.writeStringToDatapool(4025, this.hotspotToConnectNetworkName);
                break;
            }
            case 1073941855: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_SET_WLAN_CLIENT_SECURITY_LEVEL.");
                int n = eventGeneric.getInt(0);
                this.hotspotToConnectSecurityLevel = ASLWLANData.getDpWLANClientSecurityLevel2CryptoModel(n);
                AbstractASLHsmTarget.writeIntegerToDatapool(1999897344, ASLWLANData.getWLANClientSecurityLevel(this.hotspotToConnectSecurityLevel));
                break;
            }
            case 1073744655: {
                break;
            }
            case 1073941844: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered CANCEL_WLAN_HOTSPOT_SETTINGS.");
                this.restoreSettings();
                this.restoreWLANHotspotCheckbox();
                break;
            }
            case 1073744654: 
            case 1073744656: {
                this.myTarget.discoveredNetworks = new ConnectivityWLANHotspotHotspotListCollector[0];
                this.updateTrustedList();
                this.myTarget.dsiWLANService.requestNetworkSearch(0, 0);
                AbstractASLHsmTarget.writeBooleanToDatapool(4003, true);
                this.setWlanLoading(true);
                break;
            }
            case 1073744694: {
                this.noNetworkKeySet = true;
                this.connectWLAN(this.hotspotToConnectNetworkName, "", this.hotspotToConnectNetworkKey, this.hotspotToConnectSecurityLevel);
                break;
            }
            case 1073744657: {
                int n = eventGeneric.getInt(0);
                this.selectedHotspot = (ConnectivityWLANHotspotHotspotListCollector)ListManager.getGenericASLList(4004).getDSIObjects()[n];
                this.noNetworkKeySet = false;
                this.connectWLAN(this.selectedHotspot.discoveredNetwork.getNetworkName(), this.selectedHotspot.discoveredNetwork.getBssidAddress(), "", this.selectedHotspot.discoveredNetwork.getEncryptionType());
                break;
            }
            case 1073941848: {
                int n = eventGeneric.getInt(0);
                this.selectedHotspot = (ConnectivityWLANHotspotHotspotListCollector)ListManager.getGenericASLList(1899234048).getDSIObjects()[n];
                this.noNetworkKeySet = false;
                this.connectWLAN(this.selectedHotspot.discoveredNetwork.getNetworkName(), this.selectedHotspot.discoveredNetwork.getBssidAddress(), "", this.selectedHotspot.discoveredNetwork.getEncryptionType());
                break;
            }
            case 1073941826: {
                int n = eventGeneric.getInt(0);
                ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector = (ConnectivityWLANHotspotHotspotListCollector)ListManager.getGenericASLList(4004).getDSIObjects()[n];
                this.myTarget.dsiWLANService.requestDeleteTrustedNetwork(connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getNetworkName(), connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getBssidAddress());
                break;
            }
            case 1073744712: {
                int n = eventGeneric.getInt(0);
                WlanTrustedNetworkCollector wlanTrustedNetworkCollector = (WlanTrustedNetworkCollector)ListManager.getGenericASLList(4023).getDSIObjects()[n];
                this.noNetworkKeySet = false;
                this.connectWLAN(wlanTrustedNetworkCollector.trustedNetworkName, wlanTrustedNetworkCollector.trustedNetworkAddress, "", wlanTrustedNetworkCollector.encryptionMode);
                break;
            }
            case 4300049: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("[WLANMAin] Target WLAN entered IdService.ASL_SYSTEM_WLAN_CODED_AVAILABLE: ").append(bl).log();
                }
                ASLWLANData.setwLANActivatedViaDiagnosis(bl);
                break;
            }
            case 1073941835: {
                this.hotspotToConnectNetworkKey = "";
                this.hotspotToConnectNetworkName = "";
                this.hotspotToConnectSecurityLevel = 7;
                AbstractASLHsmTarget.writeStringToDatapool(4024, this.hotspotToConnectNetworkKey);
                AbstractASLHsmTarget.writeStringToDatapool(4025, this.hotspotToConnectNetworkName);
                AbstractASLHsmTarget.writeIntegerToDatapool(1999897344, ASLWLANData.getWLANClientSecurityLevel(this.hotspotToConnectSecurityLevel));
                break;
            }
            case 2200009: {
                if (this.wlanRole == 2) {
                    if (ASLWLANData.isWLANActivated()) {
                        this.pendingSetRole = true;
                        this.setWLANActivated(false);
                        break;
                    }
                    this.setRoleAP();
                    break;
                }
                if (this.wlanRole != 4) break;
                this.setRoleAP();
                break;
            }
            case 1073744569: 
            case 1073744570: 
            case 1073744598: {
                this.myTarget.spellerHsmConnectivity.handleEvent(eventGeneric);
                break;
            }
            case 1073941851: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_START_WPS_SEARCHING.");
                int n = eventGeneric.getInt(0);
                this.myTarget.dsiWLANService.requestActivateWps(-1059847936, n == 0 ? 2 : 1, 1);
                break;
            }
            case 1073941852: {
                this.myTarget.trace("[WLANMAin] Target WLAN entered ASL_CONNECTIVITY_ABORT_WPS_SEARCHING.");
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                dSIProxy.clearPendingResponses(class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = StateWLANMain.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN, "requestActivateWps");
                this.myTarget.dsiWLANService.requestCancelWPS();
                break;
            }
            default: {
                this.myTarget.trace(new StringBuffer().append("[WLANMAin] Target WLAN entered DEFAULT event with ID:").append(eventGeneric.getReceiverEventId()).toString());
            }
        }
        return hsmState;
    }

    private void setSpellerType(boolean bl) {
        if (bl) {
            this.myTarget.spellerHsmConnectivity.setAvailableCharacters("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!#%&()*+,'-./~:;<=>?@[]_\\ ");
            AbstractASLHsmTarget.writeIntegerToDatapool(1966342912, 0);
        } else {
            this.myTarget.spellerHsmConnectivity.setAvailableCharacters("");
            AbstractASLHsmTarget.writeIntegerToDatapool(1966342912, 1);
        }
    }

    private void restoreSettings() {
        this.dsiWLANUpdateProfile(ASLWLANData.getProfile(), 1);
    }

    private void restoreWLANHotspotCheckbox() {
        if (ASLWLANData.isWLANActivated()) {
            this.pendingHotspotState = this.wlanRole == 4 || this.wlanRole == 1;
            AbstractASLHsmTarget.writeBooleanToDatapool(1798570752, this.pendingHotspotState);
        } else {
            this.pendingHotspotState = false;
            AbstractASLHsmTarget.writeBooleanToDatapool(1798570752, false);
        }
    }

    private void setRoleClient() {
        this.wlanRole = 2;
        this.myTarget.dsiWLANService.setRole(2);
        this.setWlanLoading(true);
        AbstractASLHsmTarget.writeIntegerToDatapool(4001, 0);
    }

    private void setWlanLoading(boolean bl) {
        AbstractASLHsmTarget.writeBooleanToDatapool(1832125184, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(1412694784, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(1815347968, bl);
    }

    private void setRoleCombined() {
        this.wlanRole = 4;
        this.myTarget.dsiWLANService.setRole(4);
        this.setWlanLoading(true);
        AbstractASLHsmTarget.writeIntegerToDatapool(4001, 0);
    }

    private void setRoleAP() {
        this.wlanRole = 1;
        this.myTarget.dsiWLANService.setRole(1);
        this.setWlanLoading(true);
        AbstractASLHsmTarget.writeIntegerToDatapool(4001, 1);
    }

    private void connectWLAN(String string, String string2, String string3, int n) {
        this.myTarget.dsiWLANService.requestConnectNetwork(string, string2, string3, n);
        this.setWlanLoading(true);
        AbstractASLHsmTarget.writeIntegerToDatapool(4026, 1);
        AbstractASLHsmTarget.writeBooleanToDatapool(4003, true);
    }

    public void dsiWLANUpdateProfile(Profile profile, int n) {
        ASLWLANData.setProfile(profile);
        ASLWLANData.setPending2Profile();
        AbstractASLHsmTarget.writeStringToDatapool(357, ASLWLANData.getActiveKey());
        AbstractASLHsmTarget.writeIntegerToDatapool(2033451776, ASLWLANData.getWLANSecurityLevel2());
        AbstractASLHsmTarget.writeBooleanToDatapool(358, ASLWLANData.getWLANConcealed());
        AbstractASLHsmTarget.writeStringToDatapool(356, ASLWLANData.getProfile().getSSID());
    }

    public void dsiWLANResponseSetProfile(int n) {
        this.pendingSetProfile = false;
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[WLANMAin] Target WLAN entered dsiWLANResponseSetProfile: ").append(n);
        }
        if (this.pendingSetRole) {
            this.setRoleAP();
        } else if (this.pendingWLANActivate) {
            this.pendingWLANActivate = false;
            if (!ASLWLANData.isWLANActivated()) {
                this.setWLANActivated(true);
            } else {
                this.setWlanLoading(false);
            }
        } else {
            this.setWlanLoading(false);
        }
        this.setActiveKey(ASLWLANData.getActiveKey());
    }

    public void dsiWLANResponseSetRFActive(int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[WLANMAin] Target WLAN entered dsiWLANSetRFActive: ").append(n);
        }
        if (this.valetParkingCallback != null) {
            this.valetParkingCallback.notifyValetParkingTransitionFinished(true);
            this.valetParkingCallback = null;
        }
        if (this.pendingSetProfile) {
            this.sendProfileData();
        } else if (this.pendingSetRole) {
            this.setRoleAP();
        } else {
            this.setWlanLoading(false);
        }
    }

    public void dsiWLANResponseSetRole(int n) {
        this.pendingSetRole = false;
        if (this.pendingSetProfile) {
            this.sendProfileData();
        } else if (this.pendingWLANActivate) {
            if (!ASLWLANData.isWLANActivated()) {
                this.setWLANActivated(true);
            } else {
                this.setWlanLoading(false);
            }
            this.pendingWLANActivate = false;
        } else if (this.pendingClientActivate) {
            this.pendingClientActivate = false;
            if (!ASLWLANData.isWLANActivated()) {
                this.setWLANActivated(true);
            } else {
                this.setWlanLoading(false);
            }
            this.pendingWLANActivate = false;
        } else {
            this.setWlanLoading(false);
        }
    }

    public void dsiWLANResponseActivateWps(int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[WLANMAin] Target WLAN entered dsiWLANResponseActivateWps: ").append(n);
        }
        switch (n) {
            case 0: {
                this.myTarget.sendHMIEvent(1479803648);
                break;
            }
            case 8: {
                this.myTarget.sendHMIEvent(1513358080);
                break;
            }
            case 9: {
                this.myTarget.sendHMIEvent(1530135296);
                break;
            }
            default: {
                this.myTarget.sendHMIEvent(1496580864);
            }
        }
    }

    public void dsiWLANResponseCancelWps(int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[WLANMAin] Target WLAN entered dsiWLANResponseCancelWps: ").append(n);
        }
    }

    public void dsiWLANUpdateRFActive(int n, int n2) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[WLANMAin] Target WLAN entered dsiWLANUpdateRFActive: ").append(n).append(", Role: ").append(this.wlanRole).log();
        }
        if ((n == 1 || n == 0) && this.myTarget.valetParkingListener == null) {
            this.myTarget.initValetParking();
        }
        if (n == 1) {
            ASLWLANData.setWLANActivated(true);
        } else {
            ASLWLANData.setWLANActivated(false);
        }
        this.setWlanActivated();
        this.updateWlanStatusline();
    }

    private void setWlanActivated() {
        this.pendingHotspotState = false;
        if (this.wlanRole == 1) {
            AbstractASLHsmTarget.writeBooleanToDatapool(348, false);
            this.pendingHotspotState = ASLWLANData.isWLANActivated();
        } else if (this.wlanRole == 2) {
            AbstractASLHsmTarget.writeBooleanToDatapool(348, ASLWLANData.isWLANActivated());
            this.pendingHotspotState = false;
        } else if (this.wlanRole == 4) {
            AbstractASLHsmTarget.writeBooleanToDatapool(348, ASLWLANData.isWLANActivated());
            this.pendingHotspotState = ASLWLANData.isWLANActivated();
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(1798570752, this.pendingHotspotState);
    }

    public void dsiWLANUpdateStartupState(int n, int n2) {
    }

    public void dsiWLANUpdateWlanEnabled(boolean bl, int n) {
    }

    public void dsiWLANUpdateWPSRunning(int n, int n2) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1983120128, n);
    }

    public void dsiWLANUpdateWPSStoppedAndConnecting(String string, String string2, int n) {
        this.myTarget.trace("[WLANMAin] dsiWLANUpdateWPSStoppedAndConnecting");
        if (n == 1) {
            this.myTarget.sendHMIEvent(1546912512);
        }
    }

    public void dsiWLANUpdateRole(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-930012928);
        if (n == 2) {
            AbstractASLHsmTarget.writeIntegerToDatapool(4001, 0);
            eventGeneric.setInt(0, 2);
            if (ASLWLANData.isSimOrSurfstickInserted()) {
                this.setRoleAP();
            }
        } else if (n == 1) {
            AbstractASLHsmTarget.writeIntegerToDatapool(4001, 1);
            eventGeneric.setInt(0, 1);
        } else if (n == 4) {
            AbstractASLHsmTarget.writeIntegerToDatapool(4001, 1);
            eventGeneric.setInt(0, 3);
            if (ASLWLANData.isSimOrSurfstickInserted()) {
                this.setRoleAP();
            }
        } else {
            this.myTarget.error("invalid WLAN role delivered by DSI!");
            eventGeneric.setInt(0, 0);
        }
        this.myTarget.send(eventGeneric);
        this.wlanRole = n;
        this.setWlanActivated();
        this.updateWlanStatusline();
    }

    private void updateWlanStatusline() {
        AbstractASLHsmTarget.writeBooleanToDatapool(1546912512, this.isHotspot());
        AbstractASLHsmTarget.writeBooleanToDatapool(1530135296, this.isClient());
        this.updateWLANConnected();
    }

    private boolean isClient() {
        return ASLWLANData.isWLANActivated() && !Util.isNullOrEmpty(this.connectedHotspotNetworkBSSID) && (this.wlanRole == 2 || this.wlanRole == 4);
    }

    private boolean isHotspot() {
        return ASLWLANData.isWLANActivated() && (this.wlanRole == 1 || this.wlanRole == 4);
    }

    public void dsiWLANUpdateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.myTarget.discoveredNetworks.length; ++i2) {
            if (!this.myTarget.discoveredNetworks[i2].discoveredNetwork.getBssidAddress().equals(discoveredNetwork.getBssidAddress())) continue;
            n2 = i2;
        }
        if (n2 != -1) {
            ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector;
            this.myTarget.trace("Hotspot already known. Refreshed.");
            this.myTarget.discoveredNetworks[n2] = connectivityWLANHotspotHotspotListCollector = new ConnectivityWLANHotspotHotspotListCollector(discoveredNetwork, this.myTarget.discoveredNetworks[n2].isTrustedDevice, true);
        } else {
            ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector;
            Object[] objectArray = new ConnectivityWLANHotspotHotspotListCollector[this.myTarget.discoveredNetworks.length + 1];
            System.arraycopy((Object)this.myTarget.discoveredNetworks, 0, (Object)objectArray, 0, this.myTarget.discoveredNetworks.length);
            objectArray[objectArray.length - 1] = connectivityWLANHotspotHotspotListCollector = new ConnectivityWLANHotspotHotspotListCollector(discoveredNetwork, false, true);
            Arrays.sort(objectArray, new StateWLANMain$1(this));
            this.myTarget.trace("Hotspot not known. Added to list.");
            this.myTarget.discoveredNetworks = objectArray;
        }
        this.updateTrustedList();
    }

    public void dsiWLANUpdateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
        this.trustedNetworks = new WlanTrustedNetworkCollector[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.trustedNetworks[i2] = new WlanTrustedNetworkCollector(stringArray[i2], stringArray2[i2], nArray[i2]);
        }
        this.updateTrustedList();
    }

    private void updateTrustedList() {
        int n;
        ArrayList arrayList = new ArrayList();
        int n2 = -1;
        for (n = 0; n < this.myTarget.discoveredNetworks.length; ++n) {
            this.myTarget.discoveredNetworks[n].isTrustedDevice = false;
            if (!this.myTarget.discoveredNetworks[n].discoveredNetwork.getBssidAddress().equals(this.connectedHotspotNetworkBSSID)) continue;
            n2 = n;
        }
        if (n2 != -1) {
            AbstractASLHsmTarget.writeIntegerToDatapool(4002, n2);
        }
        for (n = 0; n < this.trustedNetworks.length; ++n) {
            ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector = new ConnectivityWLANHotspotHotspotListCollector(new DiscoveredNetwork(this.trustedNetworks[n].trustedNetworkName, this.trustedNetworks[n].trustedNetworkAddress, 0, this.trustedNetworks[n].encryptionMode, false), true, false);
            boolean bl = false;
            for (int i2 = 0; !bl && i2 < this.myTarget.discoveredNetworks.length; ++i2) {
                if (!connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getBssidAddress().equals(this.myTarget.discoveredNetworks[i2].discoveredNetwork.getBssidAddress())) continue;
                this.myTarget.discoveredNetworks[i2].isTrustedDevice = true;
                bl = true;
            }
            if (bl) continue;
            arrayList.add(connectivityWLANHotspotHotspotListCollector);
        }
        this.myTarget.unavailableTrustedNetworks = new ConnectivityWLANHotspotHotspotListCollector[arrayList.size()];
        for (n = 0; n < arrayList.size(); ++n) {
            this.myTarget.unavailableTrustedNetworks[n] = (ConnectivityWLANHotspotHotspotListCollector)arrayList.get(n);
        }
        this.updateHotspotList();
    }

    private void updateHotspotList() {
        int n;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int n2 = -1;
        for (n = 0; n < this.myTarget.discoveredNetworks.length; ++n) {
            if (this.myTarget.discoveredNetworks[n].discoveredNetwork.getBssidAddress().equals(this.connectedHotspotNetworkBSSID)) {
                n2 = 0;
                arrayList.add(0, this.myTarget.discoveredNetworks[n]);
                continue;
            }
            arrayList.add(this.myTarget.discoveredNetworks[n]);
        }
        for (n = 0; n < this.myTarget.unavailableTrustedNetworks.length; ++n) {
            if (this.myTarget.unavailableTrustedNetworks[n].discoveredNetwork.getBssidAddress().equals(this.connectedHotspotNetworkBSSID)) {
                n2 = 0;
                ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector = new ConnectivityWLANHotspotHotspotListCollector(this.myTarget.unavailableTrustedNetworks[n].discoveredNetwork, this.myTarget.unavailableTrustedNetworks[n].isTrustedDevice, true);
                arrayList.add(0, connectivityWLANHotspotHotspotListCollector);
                continue;
            }
            arrayList.add(this.myTarget.unavailableTrustedNetworks[n]);
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(4002, n2);
        ListManager.getGenericASLList(4004).updateList(arrayList.toArray(new ConnectivityWLANHotspotHotspotListCollector[arrayList.size()]));
        n = ListManager.getGenericASLList(4004).getSize();
        for (int i2 = 0; i2 < n; ++i2) {
            ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector = (ConnectivityWLANHotspotHotspotListCollector)ListManager.getGenericASLList(4004).getRowItemCacheOnly(i2);
            if (connectivityWLANHotspotHotspotListCollector.isTrustedDevice && !connectivityWLANHotspotHotspotListCollector.discoveredNetwork.getBssidAddress().equals(this.connectedHotspotNetworkBSSID)) continue;
            arrayList2.add(connectivityWLANHotspotHotspotListCollector);
        }
        ListManager.getGenericASLList(1899234048).updateList(arrayList2.toArray(new ConnectivityWLANHotspotHotspotListCollector[arrayList2.size()]));
    }

    public void dsiWLANUpdateConnectedNetwork(String string, String string2, int n, int n2) {
        this.connectedHotspotNetworkBSSID = string2;
        ConnectivityWLANHotspotHotspotListCollector[] connectivityWLANHotspotHotspotListCollectorArray = (ConnectivityWLANHotspotHotspotListCollector[])ListManager.getGenericASLList(4004).getDSIObjects();
        int n3 = -1;
        for (int i2 = 0; i2 < connectivityWLANHotspotHotspotListCollectorArray.length; ++i2) {
            if (!connectivityWLANHotspotHotspotListCollectorArray[i2].discoveredNetwork.getBssidAddress().equals(this.connectedHotspotNetworkBSSID)) continue;
            n3 = i2;
            break;
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(4002, n3);
        EventGeneric eventGeneric = this.myTarget.getEventFactory().newEvent(-946790144);
        eventGeneric.setInt(0, n);
        this.myTarget.triggerObserver(-946790144, eventGeneric);
        AbstractASLHsmTarget.writeIntegerToDatapool(1630798592, n);
        AbstractASLHsmTarget.writeStringToDatapool(1848902400, string);
        if (Util.isNullOrEmpty(string) || Util.isNullOrEmpty(string2)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(4026, 0);
        } else {
            AbstractASLHsmTarget.writeIntegerToDatapool(4026, 2);
        }
        this.updateWlanStatusline();
        this.updateHotspotList();
    }

    public void dsiWLANUpdateNodeList(Node[] nodeArray, int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1647575808, nodeArray.length);
        this.connectedNodes = nodeArray.length;
        this.updateWLANConnected();
    }

    private void updateWLANConnected() {
        boolean bl = this.isHotspot() && this.connectedNodes > 0 || this.isClient();
        EventGeneric eventGeneric = this.myTarget.getEventFactory().newEvent(-879681280);
        eventGeneric.setBoolean(0, bl);
        this.myTarget.triggerObserver(-879681280, eventGeneric);
    }

    public void dsiWLANResponseNetworkSearch(int n, int n2) {
        AbstractASLHsmTarget.writeBooleanToDatapool(4003, false);
        this.setWlanLoading(false);
    }

    public void dsiWLANResponseConnectNetwork(String string, String string2, int n) {
        this.setWlanLoading(false);
        AbstractASLHsmTarget.writeBooleanToDatapool(4003, false);
        if (n != 0) {
            if (n == 4) {
                this.myTarget.sendHMIEvent(572);
                AbstractASLHsmTarget.writeIntegerToDatapool(4002, -1);
            } else if (n == 7) {
                if (this.noNetworkKeySet) {
                    this.myTarget.sendHMIEvent(573);
                } else {
                    this.myTarget.sendHMIEvent(571);
                }
            } else {
                this.myTarget.sendHMIEvent(573);
                AbstractASLHsmTarget.writeIntegerToDatapool(4002, -1);
            }
        }
    }

    public void dsiPowerManagementUpdateBEMState(int n, int n2) {
        boolean bl = false;
        switch (n) {
            case 4: 
            case 5: {
                bl = true;
                this.myTarget.trace("[WLANMAin] dsiPowerManagementUpdateBEMState: system is in transport or production mode.");
                break;
            }
        }
        ASLWLANData.setSystemInTransportOrProductionMode(bl);
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        boolean bl = clampSignal.isClampS();
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[WLANMAin] dsiPowerManagementUpdateClampSignal: S-Contact is ").append(bl).log();
        }
        ASLWLANData.setSContactOn(bl);
    }

    private void setWLANSecurityLevel2(int n) {
        int n2 = ASLWLANData.getDpWLANSecurityLevel2CryptoModel(n);
        if (n2 != ASLWLANData.getPendingProfile().getCryptoModel()) {
            Profile profile = ASLWLANData.getPendingProfile();
            profile.cryptoModel = n2;
            profile.keys = new String[]{""};
            this.setSpellerData("", true);
            AbstractASLHsmTarget.writeStringToDatapool(357, "");
            AbstractASLHsmTarget.writeIntegerToDatapool(2033451776, n);
        }
    }

    private void toggleWLANConcealed() {
        AbstractASLHsmTarget.writeBooleanToDatapool(358, ASLWLANData.getPendingProfile().isSSIDBroadcast());
        ASLWLANData.getPendingProfile().sSIDBroadcast = !ASLWLANData.getPendingProfile().sSIDBroadcast;
    }

    private void sendProfileData() {
        this.setWlanLoading(true);
        this.myTarget.dsiWLANService.setProfile(ASLWLANData.getPendingProfile());
        AbstractASLHsmTarget.writeStringToDatapool(356, ASLWLANData.getPendingProfile().getSSID());
    }

    private boolean checkCanActivate() {
        return !ASLWLANData.isWLANActivated() && ASLWLANData.iswLANActivatedViaDiagnosis() && !ASLWLANData.isSystemInTransportOrProductionMode() && ASLWLANData.isSContactOn();
    }

    private void setWLANActivated(boolean bl) {
        if (this.checkCanActivate() || !bl) {
            this.myTarget.dsiWLANService.setRFActive(bl);
            this.setWlanLoading(true);
        } else if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[WLANMAin] WLAN activation preconditions not complied! isWLANActivated: ").append(ASLWLANData.isWLANActivated()).append(", iswLANActivatedViaDiagnosis: ").append(ASLWLANData.iswLANActivatedViaDiagnosis()).append(", isSystemInTransportOrProductionMode: ").append(ASLWLANData.isSystemInTransportOrProductionMode()).append(", isSContactOn: ").append(ASLWLANData.isSContactOn()).log();
        }
    }

    private void setWLANSid(String string) {
        Profile profile = ASLWLANData.getPendingProfile();
        profile.sSID = string;
        AbstractASLHsmTarget.writeStringToDatapool(356, string);
    }

    private void setActiveKey(String string) {
        Profile profile = ASLWLANData.getPendingProfile();
        short s = profile.getKeyNumber();
        if (profile.getKeys().length >= s) {
            profile.keys[s] = string;
        }
        AbstractASLHsmTarget.writeStringToDatapool(357, string);
    }

    public void switchWLANState(boolean bl) {
        if (bl) {
            if (ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingWiFiState() == -1) {
                ASLPhoneFactory.getPhoneApi().getPersistence().setPreValetParkingWiFiState(ASLWLANData.isWLANActivated() ? 1 : 0);
                if (ASLWLANData.isWLANActivated()) {
                    this.myTarget.dsiWLANService.setRFActive(false);
                    ASLWLANData.setWLANActivated(false);
                } else if (this.valetParkingCallback != null) {
                    this.valetParkingCallback.notifyValetParkingTransitionFinished(true);
                    this.valetParkingCallback = null;
                }
            } else if (this.valetParkingCallback != null) {
                this.valetParkingCallback.notifyValetParkingTransitionFinished(true);
                this.valetParkingCallback = null;
            }
        } else {
            if (ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingWiFiState() == 1) {
                this.myTarget.dsiWLANService.setRFActive(true);
                ASLWLANData.setWLANActivated(true);
            } else if (this.valetParkingCallback != null) {
                this.valetParkingCallback.notifyValetParkingTransitionFinished(true);
                this.valetParkingCallback = null;
            }
            ASLPhoneFactory.getPhoneApi().getPersistence().setPreValetParkingWiFiState(-1);
        }
    }

    private void resetWLANSettings() {
        this.pendingHotspotState = false;
        this.myTarget.discoveredNetworks = new ConnectivityWLANHotspotHotspotListCollector[0];
        this.myTarget.unavailableTrustedNetworks = new ConnectivityWLANHotspotHotspotListCollector[0];
        AbstractASLHsmTarget.writeIntegerToDatapool(4002, -1);
        AbstractASLHsmTarget.writeBooleanToDatapool(1798570752, this.pendingHotspotState);
        this.updateHotspotList();
        this.myTarget.dsiWLANService.factoryReset();
    }

    public void dsiWLANResponseFactoryReset(int n) {
        if (this.factoryResetCallback != null) {
            this.factoryResetCallback.notifyResetDone();
            this.factoryResetCallback = null;
        }
    }

    private void setSpellerData(String string, boolean bl) {
        this.myTarget.spellerHsmConnectivity.initSpeller(string);
        this.setSpellerType(bl);
    }

    public void dsiWLANAsyncException(int n, String string, int n2) {
        if (n2 == 1003 || n2 == 1013 || n2 == 1004) {
            this.setWlanLoading(false);
        } else if (n2 == 1009) {
            AbstractASLHsmTarget.writeIntegerToDatapool(4002, -1);
            AbstractASLHsmTarget.writeBooleanToDatapool(4003, false);
            this.setWlanLoading(false);
        } else if (n2 == 1007) {
            AbstractASLHsmTarget.writeBooleanToDatapool(4003, false);
            this.setWlanLoading(false);
        } else if (n2 == 1014) {
            this.myTarget.sendHMIEvent(1513358080);
        } else if (n2 == 1015) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1983120128, -1059847936);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ FactoryResetCallback access$102(StateWLANMain stateWLANMain, FactoryResetCallback factoryResetCallback) {
        stateWLANMain.factoryResetCallback = factoryResetCallback;
        return stateWLANMain.factoryResetCallback;
    }

    static /* synthetic */ void access$200(StateWLANMain stateWLANMain) {
        stateWLANMain.resetWLANSettings();
    }
}

