/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.common.DeviceASLExtended;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationHelper;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.smartphoneintegration.Device;

public class ASLEventHandler {
    private final String classname;
    private final HsmTarget target;

    public ASLEventHandler(HsmTarget hsmTarget) {
        this.classname = "SmartPhoneIntegration.ASLEventHandler";
        this.target = hsmTarget;
    }

    public HsmTarget getTarget() {
        return this.target;
    }

    public void gotEvent(EventGeneric eventGeneric) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".gotEvent( id = ").append(eventGeneric.getReceiverEventId()).append(")").log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".gotEvent(POWER_ON)").log();
                }
                this.getTarget().startup();
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".gotEvent(POWER_ON start subcontexts was send)").log();
                break;
            }
            case 4300062: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(RELOAD_PERSISTABLES)").log();
                break;
            }
            case 1200004: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(DIAG_MODE_PERSISTENT_VALUE_CHANGED)").log();
                }
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTarget().getTargetId(), -1585053440);
                break;
            }
            case 3000004: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASLMediaServiceIds.ASL_MEDIA_CURRENT_BTA_NAME)").log();
                break;
            }
            case 1076641839: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                int n3 = this.getGlobalProperties().getCurrentConnectionState();
                super.getClass();
                if (n3 != 5) {
                    SmartPhoneIntegrationGlobalProperyAccessor smartPhoneIntegrationGlobalProperyAccessor = this.getGlobalProperties();
                    super.getClass();
                    smartPhoneIntegrationGlobalProperyAccessor.setCurrentConnectionState(1);
                }
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(SELECT_DEVICE_LIST2").append(n).append(", ").append(n2).log();
                }
                if (!this.getGlobalProperties().isInternalHFPorOCUCallActive()) {
                    this.getTarget().getASLHandler().handleAslApiSelectDeviceList(n, n2);
                    break;
                }
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(SELECT_DEVICE_LIST2").append(" hfp call is active!!!!").log();
                }
                int n4 = SmartPhoneIntegrationHelper.convertModelToDsiConnectionmethod(n2);
                this.getGlobalProperties().handleConnectionRequestDuringOCUOrHfpCall(SmartPhoneIntegrationHelper.getDeviceFromListIndex(n).getDsiDevice(), n4, false);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1114057728);
                break;
            }
            case 1073743175: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASLSystemServiceConstants.LAST_MAIN_CONTEXT)").log();
                }
                if (null == this.getTarget().getAppConnectRequestHandler()) break;
                this.getTarget().getAppConnectRequestHandler().handleMainContextChange(eventGeneric);
                break;
            }
            case 1075841838: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASLSystemServiceConstants.REQUEST_CONTENT)").log();
                }
                if (null == this.getTarget().getAppConnectRequestHandler()) break;
                this.getTarget().getAppConnectRequestHandler().handleRequestContent(eventGeneric);
                break;
            }
            case 1076641840: {
                break;
            }
            case 1076641842: {
                boolean bl;
                boolean bl2 = bl = eventGeneric.getInt(0) == 1;
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(SET_NEW_CAR_PLAY_DEVICE_CONNECTION_USER_RESPONSE: ").append(eventGeneric.getInt(0) == 1).append(new StringBuffer().append(",").append(bl).append(" ) ").toString()).log();
                }
                if (bl) {
                    this.getTarget().getASLHandler().connectionHandlingNewDevice(this.getGlobalProperties().getCurrentSelectedDevice(), bl, true);
                    break;
                }
                this.getTarget().getPersistence().addDeviceToBlackList(this.getGlobalProperties().getCurrentSelectedDevice());
                this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentSelectedDevice().getDeviceID());
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".disconnect triggered by SET_NEW_CAR_PLAY_DEVICE_CONNECTION_USER_RESPONSE)").log();
                break;
            }
            case 1076641852: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(SET_NEW_APPLE_DEVICE_CONNECTION_USER_RESPONSE: ").append("userConfirmResult").append(new StringBuffer().append(",").append(n).append(" ) ").toString()).log();
                }
                if (n == 0) {
                    this.getTarget().getPersistence().addDeviceToBlackList(this.getGlobalProperties().getCurrentSelectedDevice());
                    this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentSelectedDevice().getDeviceID());
                    if (!this.getTarget().isTraceEnabled()) break;
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".disconnect triggered by SET_NEW_APPLE_DEVICE_CONNECTION_USER_RESPONSE)").log();
                    break;
                }
                if (n == 1) {
                    this.getGlobalProperties().getCurrentSelectedDevice().setSelectedConnectionMethod(2);
                } else {
                    this.getGlobalProperties().getCurrentSelectedDevice().setSelectedConnectionMethod(3);
                }
                this.getTarget().getASLHandler().connectionHandlingNewDevice(this.getGlobalProperties().getCurrentSelectedDevice(), true, true);
                break;
            }
            case 1076641837: {
                DeviceASLExtended deviceASLExtended;
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(DISCONNECT_CURRENT_DEVICE").log();
                }
                if ((deviceASLExtended = this.getGlobalProperties().getCurrentConnectedDevice()) != null) {
                    this.getTarget().getASLHandler().updateConnectionPopupPropertiesToModel(deviceASLExtended.getDsiDevice(), deviceASLExtended.getConnectionMethod());
                    this.getTarget().getDSISmartphoneIntegration().disconnectDevice(deviceASLExtended.getDsiDevice().getDeviceID());
                    this.getTarget().getPersistence().addDeviceToBlackList(deviceASLExtended);
                    if (this.getTarget().isTraceEnabled()) {
                        this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(DISCONNECT_CURRENT_DEVICE and add device to blacklist) ").log();
                    }
                }
                this.target.getASLHandler().setDeviceListAccessibility(false);
                break;
            }
            case 1076641843: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(MFL_EVENT").append(n).log();
                }
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(957635840);
                eventGeneric2.setInt(0, n);
                this.getTarget().sendSafe(eventGeneric2);
                break;
            }
            case 1076641838: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(SET_NEW_CARPLAY_DEVICE_FOUND_POPUP_VISIBLE").append(bl).log();
                }
                this.getGlobalProperties().setCarPlayConnectionConfirmPopupActive(bl);
                break;
            }
            case 1076641844: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(TA__ACTIVE").log();
                }
                this.getTarget().triggerObserver(991190272, null);
                break;
            }
            case 1076641845: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(SET_DIMMED_TRIGGER").log();
                }
                boolean bl = eventGeneric.getBoolean(0);
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(1007967488);
                eventGeneric3.setBoolean(0, bl);
                this.getTarget().sendSafe(eventGeneric3);
                break;
            }
            case 100008: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_DEVICELIST_ACCESSIBLE_TIMER)").log();
                }
                this.getTarget().getASLHandler().setDeviceListAccessibility(true);
                break;
            }
            case 100012: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_CONNECTION_STATE_RESET_TIMER)").log();
                }
                int n = this.getGlobalProperties().getCurrentConnectionState();
                super.getClass();
                if (n != 1) break;
                SmartPhoneIntegrationGlobalProperyAccessor smartPhoneIntegrationGlobalProperyAccessor = this.getGlobalProperties();
                super.getClass();
                smartPhoneIntegrationGlobalProperyAccessor.setCurrentConnectionState(0);
                break;
            }
            case 100009: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_UPDATE_DISCOVERED_DEVICES_BUS_RESET_WAIT_TIMER: (").append("7000ms) )").log();
                }
                if (this.getGlobalProperties().CONST_UPDATE_DISCOVERED_DEVICES_LOWPASS_ACTIVE) {
                    Device device = SmartPhoneIntegrationHelper.findFirstNewDevice(this.getGlobalProperties().getDsiDevicelistASLExtended(), this.getGlobalProperties().getTempDsiDevicelist());
                    if (device == null) {
                        if (this.getTarget().isTraceEnabled()) {
                            this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_UPDATE_DISCOVERED_DEVICES_BUS_RESET_WAIT_TIMER: (").append("no new device available after bus reset )").log();
                        }
                        this.getGlobalProperties().setDsiDevicelist(this.getGlobalProperties().getTempDsiDevicelist());
                        this.target.getDSIHandler().updateHmiDeviceList(this.getGlobalProperties().getTempDsiDevicelist());
                    } else {
                        if (this.getTarget().isTraceEnabled()) {
                            this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_UPDATE_DISCOVERED_DEVICES_BUS_RESET_WAIT_TIMER: (").append(new StringBuffer().append(device.getDeviceName()).append(" new device detected after bus reset )").toString()).log();
                        }
                        this.getTarget().getDSIHandler().handleDsiApiUpdateDiscoveredDevices(this.getGlobalProperties().getTempDsiDevicelist());
                    }
                    if (!this.getGlobalProperties().isInternalHFPorOCUCallActive()) {
                        this.target.getGlobalProperties().requestConnectionOnFinishedOCUOrHfpCall();
                    }
                    this.getTarget().getASLHandler().setDeviceListAccessibility(true);
                }
                if (!this.getGlobalProperties().isConnectionSwitchActive()) break;
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_DEVICELIST_ACCESSIBLE_TIMER).handleAslApiSelectDeviceListConnecting()").log();
                }
                this.getTarget().getASLHandler().handleAslApiSelectDeviceListConnecting();
                break;
            }
            case 100011: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_DEVICE_SWITCH_WAIT_TIMER: (").append("3000ms) )").log();
                }
                if (!this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1450835712) && !this.getGlobalProperties().isBusResetActive()) {
                    this.getTarget().getASLHandler().handleAslApiSelectDeviceListConnecting();
                    break;
                }
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_SMARTPHONEINTEGRATION_DEVICE_SWITCH_WAIT_TIMER: (").append("bus reset timer is runningms) )").log();
                break;
            }
            case 100001: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_DIAG_RECEIVE_CODING_DATA)").log();
                }
                if (eventGeneric.getResult() != 0 || eventGeneric.getLong(3) != 1L) break;
                break;
            }
            case 100002: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(EV_DIAG_RECEIVE_ADAPT_DATA)").log();
                }
                if (eventGeneric.getResult() != 0 || eventGeneric.getLong(3) != 0) break;
                Adaptation adaptation = (Adaptation)eventGeneric.getObject(1);
                boolean bl = adaptation.getBoolean(1142);
                boolean bl3 = adaptation.getValue(1169) == 1;
                boolean bl4 = adaptation.getBoolean(1143);
                boolean bl5 = adaptation.getBoolean(1194);
                boolean bl6 = adaptation.getBoolean(1238);
                this.getGlobalProperties().getFeatureSupport().setCoding(bl, bl3, bl4, bl5, bl6);
                break;
            }
            case 4300003: {
                this.getTarget().getASLHandler().handleClampSSwitch(eventGeneric);
                break;
            }
            case 6100007: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_LEFT_CARPLAY_WITH_OEM_BUTTON)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(979840000);
                break;
            }
            case 6100011: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_LEFT_GAL_WITH_OEM_BUTTON)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(996617216);
                break;
            }
            case 6100105: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_LEFT_CARLIFE_WITH_OEM_BUTTON)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1197943808);
                break;
            }
            case 6100008: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARPLAY_TRIGGERED_CONTEXTSWITCH_TO_CARPLAY)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1013394432);
                break;
            }
            case 6100012: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARPLAY_TRIGGERED_CONTEXTSWITCH_LEFT_CARPLAY)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1030171648);
                break;
            }
            case 6100018: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_GAL_TRIGGERED_CONTEXTSWITCH_TO_GAL)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1046948864);
                break;
            }
            case 6100019: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_GAL_TRIGGERED_CONTEXTSWITCH_LEFT_GAL)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1063726080);
                break;
            }
            case 6100106: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARLIFE_TRIGGERED_CONTEXTSWITCH_TO_CARLIFE)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1214721024);
                break;
            }
            case 6100107: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARLIFE_TRIGGERED_CONTEXTSWITCH_LEFT_CARLIFE)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1231498240);
                break;
            }
            case 6100023: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARPLAY_ENTERTAINMENT_SOURCE_ACTIVATED)").log();
                }
                this.getGlobalProperties().setEntertainmentActive(true);
                break;
            }
            case 6100024: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARPLAY_ENTERTAINMENT_SOURCEY_DEACTIVATED)").log();
                }
                this.getGlobalProperties().setEntertainmentActive(false);
                break;
            }
            case 3600033: {
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl && this.getGlobalProperties().isInternalHFPCallActive() && !this.getGlobalProperties().isInternalOCUCallActive()) {
                    this.getGlobalProperties().requestConnectionOnFinishedOCUOrHfpCall();
                }
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(new StringBuffer().append(".handle(ASL_PHONE_CALL_ACTIVE ").append(bl).toString()).append(")").log();
                }
                this.getGlobalProperties().setInternalHFPCallActive(bl);
                break;
            }
            case 6100026: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_DISCONNECT_ON_FATAL_ERROR)").log();
                }
                this.getTarget().getASLHandler().updateConnectionFailedPopupPropertiesToModel(this.getGlobalProperties().getCurrentConnectedDevice().getConnectionMethod());
                this.getTarget().getPersistence().addDeviceToBlackList(this.getGlobalProperties().getCurrentConnectedDevice());
                this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentConnectedDevice().getDsiDevice().getDeviceID());
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".disconnect triggered by ASL_SMARTPHONEINTEGRATION_DISCONNECT_ON_FATAL_ERROR)").log();
                break;
            }
            case 6100013: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_MIRRORLINK_USER_INITIATED_DISCONNECT)").log();
                }
                this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentConnectedDevice().getDsiDevice().getDeviceID());
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".disconnect triggered by ASL_SMARTPHONEINTEGRATION_MIRRORLINK_USER_INITIATED_DISCONNECT)").log();
                break;
            }
            case 6100037: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_MIRRORLINK_APP_INITIATED_CONTEXTSWITCH_TO_ML)").log();
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1080503296);
                break;
            }
            case 6100010: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_OCU_DISCONNECT_CURRENT_DEVICE)").log();
                }
                this.getTarget().triggerObserver(1142185216, null);
                break;
            }
            case 6100035: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARPLAY_TRIGGERED_DISCONNECT_CARPLAY)").log();
                }
                this.getGlobalProperties().setCurrentOCUDisconnectedDevice(this.getGlobalProperties().getCurrentConnectedDevice());
                this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentConnectedDevice().getDsiDevice().getDeviceID());
                break;
            }
            case 6100108: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_CARLIFE_TRIGGERED_DISCONNECT_CARLIFE)").log();
                }
                this.getGlobalProperties().setCurrentOCUDisconnectedDevice(this.getGlobalProperties().getCurrentConnectedDevice());
                this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentConnectedDevice().getDsiDevice().getDeviceID());
                break;
            }
            case 6100009: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SMARTPHONEINTEGRATION_OCU_RECONNECT_CURRENT_DEVICE)").log();
                }
                if (this.getGlobalProperties().getLastOCUDisconnectedDevice() == null) break;
                this.getTarget().getASLHandler().handleReconnectOCUDisconnectedDevice(this.getGlobalProperties().getLastOCUDisconnectedDevice());
                break;
            }
            case 4000024: {
                EventGeneric eventGeneric4;
                if (eventGeneric.getInt(0) == 226) {
                    if (this.getTarget().isTraceEnabled()) {
                        this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SOUND_AUDIO_CONNECTION_STARTED) OCU ECALL_LOW START").log();
                    }
                    eventGeneric4 = ServiceManager.mGenericEventFactory.newEvent(1108630784);
                    eventGeneric4.setInt(0, 1);
                    this.getTarget().sendSafe(eventGeneric4);
                    this.getGlobalProperties().setInternalOCUCallActive(true);
                }
                if (eventGeneric.getInt(0) != 227) break;
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SOUND_AUDIO_CONNECTION_STARTED) OCU ECALL_HIGH START").log();
                }
                eventGeneric4 = ServiceManager.mGenericEventFactory.newEvent(1108630784);
                eventGeneric4.setInt(0, 2);
                this.getTarget().sendSafe(eventGeneric4);
                this.getGlobalProperties().setInternalOCUCallActive(true);
                break;
            }
            case 4000015: {
                if (eventGeneric.getInt(0) != 226 && eventGeneric.getInt(0) != 227) break;
                EventGeneric eventGeneric5 = ServiceManager.mGenericEventFactory.newEvent(1108630784);
                eventGeneric5.setInt(0, 0);
                this.getTarget().sendSafe(eventGeneric5);
                if (this.getGlobalProperties().getLastOCUDisconnectedDevice() != null && this.getGlobalProperties().getLastOCUDisconnectedDevice().getDeviceID() != -1) {
                    this.getTarget().getASLHandler().handleReconnectOCUDisconnectedDevice(this.getGlobalProperties().getLastOCUDisconnectedDevice());
                } else {
                    this.getGlobalProperties().requestConnectionOnFinishedOCUOrHfpCall();
                }
                this.getGlobalProperties().setInternalOCUCallActive(false);
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".handle(ASL_SOUND_AUDIO_CONNECTION_RELEASED) OCU CALL STOPPED").log();
                break;
            }
            default: {
                this.getTarget().trace("Target SmartPhoneIntegration - got an unhandled event!");
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("SmartPhoneIntegration.ASLEventHandler").append(".gotEvent( unhandled id ").append(eventGeneric.getReceiverEventId()).append(")").log();
            }
        }
    }

    private SmartPhoneIntegrationGlobalProperyAccessor getGlobalProperties() {
        return SmartPhoneIntegrationGlobalProperyAccessor.getInstance();
    }
}

