/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.CommonContact;
import de.vw.mib.asl.api.phone.services.calls.CallService;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.api.impl.PhoneServiceImpl;
import de.vw.mib.asl.internal.phone.call.CallHandling$MobileEquipmentListener;
import de.vw.mib.asl.internal.phone.call.CallInformations;
import de.vw.mib.asl.internal.phone.call.HsmPhoneCallHandling;
import de.vw.mib.asl.internal.phone.call.StateCallHandlingCallHandling;
import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialCollector;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import de.vw.mib.asl.internal.phone.presets.transformer.PhonePresetCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.call.transformer.PhoneCallIncomingCallInformationsCollector;
import generated.de.vw.mib.asl.internal.phonetiles.call.transformer.PhoneTileSCallCallInformationsCollector;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class CallHandling
extends TripleMobileEquipment
implements CallService {
    DSIPowerManagement dsiPowerManagement;
    DSIListener dsiPowerManagementListener;
    private static final Integer[] AUDIOMODE_HFP = new Integer[]{new Integer(0), new Integer(2)};
    private static final Integer[] AUDIOMODE_NONE = new Integer[0];
    private int popupSeconds;
    static final int EV_PHONE_CALL_DIAL_UPDATECALLLIST_TIMER;
    private static final int EV_DIAG_RECEIVE_CODING_DATA;
    private static final int EV_ASL_INT_SOUND_SET_CONNECTION_RESULT;
    private static final int EV_HANDSFREEMODE_TIMER;
    static final int PHONE_CALL_DIAL_UPDATECALLLIST_TIMEOUT;
    private static final int HANDSFREEMODE_TIMEOUT;
    public static final int ROLE_PRIMARY;
    public static final int ROLE_ASSOCIATED;
    private boolean isHandsfreeModeTimerRunning = false;
    private final CallInformations callInformations;
    private boolean lastWidebandSpeechSet;
    private final CallHandling$MobileEquipmentListener[] mobileEquipmentListeners;
    private boolean callListModified;
    private int callCount;
    private CallHandling$MobileEquipmentListener currentDsiListener;
    private int handsFreeAudioMode;
    private boolean isMuted;
    private int primaryTelMode;
    private int primaryActivationState;
    private boolean emergencyCallAvailable;
    private boolean alreadyRegistered;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$services$calls$CallService;

    public CallHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.callInformations = ASLPhoneData.getInstance().callInformationCollectors;
        this.lastWidebandSpeechSet = false;
        this.callCount = 0;
        this.isMuted = false;
        this.alreadyRegistered = false;
        this.mobileEquipmentListeners = new CallHandling$MobileEquipmentListener[]{new CallHandling$MobileEquipmentListener(this, 0), new CallHandling$MobileEquipmentListener(this, 1)};
    }

    @Override
    public int getDefaultTargetId() {
        return 1922634752;
    }

    @Override
    protected void powerOn() {
        this.init();
        this.setNotification();
    }

    private void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = CallHandling.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
            this.dsiPowerManagementListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = CallHandling.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
            this.addObserver(352926976);
            this.addObserver(1745027136);
            this.addObserver(-348428736);
            this.addObserver(1728249920);
            this.addObserver(-365205952);
            this.addObserver(-363064000);
            this.addObserver(-197433792);
            this.addObserver(0x24040040);
            try {
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1585053440);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
            PhoneCallInformationCollector phoneCallInformationCollector = new PhoneCallInformationCollector();
            phoneCallInformationCollector.callDuration = new CallDuration();
            phoneCallInformationCollector.callInformation = new CallInformation();
            phoneCallInformationCollector.callInformation.telCallState = 0;
            phoneCallInformationCollector.callInformation.telCallID = 0;
            ListManager.getGenericASLList(1158).updateList(new PhoneCallInformationCollector[]{phoneCallInformationCollector, phoneCallInformationCollector, phoneCallInformationCollector});
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$phone$services$calls$CallService == null ? (class$de$vw$mib$asl$api$phone$services$calls$CallService = CallHandling.class$("de.vw.mib.asl.api.phone.services.calls.CallService")) : class$de$vw$mib$asl$api$phone$services$calls$CallService, this);
            PhoneServiceImpl.getInstance().callServiceReady(this);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiPowerManagement.setNotification(8, this.dsiPowerManagementListener);
    }

    private CallHandling$MobileEquipmentListener other(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        return this.mobileEquipmentListeners[1 - CallHandling$MobileEquipmentListener.access$000(callHandling$MobileEquipmentListener)];
    }

    @Override
    protected void handleEvent(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 3600010: {
                --this.popupSeconds;
                CallHandling.writeStringToDatapool(1147, Integer.toString(this.popupSeconds));
                if (this.popupSeconds != 0) break;
                ServiceManager.eventMain.getTimerServer().stopTimedEvent(1922634752, -1964100096);
                break;
            }
            case 100003: {
                this.isHandsfreeModeTimerRunning = false;
                CallHandling.writeIntegerToDatapool(293868800, this.handsFreeAudioMode);
                break;
            }
            case 100000: {
                this.sendHMIEvent(170);
                break;
            }
            case 100001: {
                if (eventGeneric.getResult() != 0 || eventGeneric.getInt(2) != -687821311 || eventGeneric.getLong(3) != 1L) break;
                this.checkEmergencyCallEnabled((Coding)eventGeneric.getObject(1));
                break;
            }
            case 3600012: {
                this.updateShortDialList();
                break;
            }
            case 1073742752: {
                this.callInformations.getFillingInstance().accept();
                break;
            }
            case 1073744551: 
            case 1080441837: {
                CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).acceptCall(0);
                ASLPhoneData.getInstance().isCallRespHold = false;
                break;
            }
            case 1073744552: 
            case 1080441842: {
                CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).acceptCall(3);
                ASLPhoneData.getInstance().isCallRespHold = true;
                break;
            }
            case 1073742764: {
                int n = eventGeneric.getInt(0);
                PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)ListManager.getGenericASLList(1160).getRowItem(n);
                CallHandling$MobileEquipmentListener.access$200(phoneCallInformationCollector.mobileEquipment, phoneCallInformationCollector.callInformation.telCallID);
                break;
            }
            case 3600026: {
                CallHandling$MobileEquipmentListener.access$200(this.mobileEquipmentListeners[0], 255);
                CallHandling$MobileEquipmentListener.access$200(this.mobileEquipmentListeners[1], 255);
                break;
            }
            case 1080441838: {
                CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).hangupCall(this.callInformations.getCurrentMainCallCollector().callInformation.getTelCallID());
                ASLPhoneData.getInstance().isCallRespHold = false;
                break;
            }
            case 1073742755: {
                int n = eventGeneric.getInt(0);
                PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)ListManager.getGenericASLList(1158).getRowItem(n);
                CallHandling$MobileEquipmentListener.access$200(phoneCallInformationCollector.mobileEquipment, phoneCallInformationCollector.callInformation.telCallID);
                ASLPhoneData.getInstance().isCallRespHold = false;
                break;
            }
            case 1075141827: {
                CallHandling$MobileEquipmentListener.access$200(this.other(this.callInformations.getFillingInstance()), 255);
                break;
            }
            case 1075141824: {
                this.sendHMIEvent(164);
                if (Util.isNullOrEmpty(ASLPhoneData.getInstance().emergencyNumbers.mainEmergencyNumber)) {
                    this.sendHMIEvent(166);
                    this.sendHMIEvent(188);
                } else {
                    this.sendHMIEvent(167);
                    this.dialTrimmedNumber(HsmPhoneCallHandling.selectNumberHappenedBeforeDial ? StateCallHandlingCallHandling.selectedNumber : ASLPhoneData.getInstance().emergencyNumbers.mainEmergencyNumber);
                }
                HsmPhoneCallHandling.selectNumberHappenedBeforeDial = false;
                break;
            }
            case 1073742778: {
                String string = eventGeneric.getString(0);
                CallHandling$MobileEquipmentListener.access$100(this.callInformations.getActive().mobileEquipment).sendDTMF(string);
                break;
            }
            case 1075141862: {
                HsmPhoneCallHandling.selectNumberHappenedBeforeDial = false;
                ServiceManager.aslPropertyManager.valueChangedInteger(1152, 0);
                int n = eventGeneric.getInt(4);
                AdbEntry adbEntry = null;
                DataSet dataSet = null;
                int n2 = eventGeneric.getInt(3);
                PhonePresetCollector[] phonePresetCollectorArray = (PhonePresetCollector[])ListManager.getGenericASLList(1194).getDSIObjects();
                AdbEntry adbEntry2 = null;
                if (n >= 0) {
                    adbEntry2 = phonePresetCollectorArray[n].adbEntry;
                }
                if (adbEntry2 != null && !adbEntry2.getCombinedName().equals("") && !adbEntry2.getCombinedName().equals(adbEntry2.getPhoneData()[0].getNumber())) {
                    adbEntry = new AdbEntry(adbEntry2.getEntryId(), adbEntry2.getEntryType(), adbEntry2.getCombinedName(), adbEntry2.getPreferredNumberIdx(), adbEntry2.getVoiceTagId(), adbEntry2.getPhoneData(), adbEntry2.getAddressData(), adbEntry2.getEmailData(), adbEntry2.getUrlData(), adbEntry2.getPersonalData(), adbEntry2.getReferenceId());
                    adbEntry.entryId = 0L;
                    n2 = adbEntry2.getPhoneData()[0].getNumberType();
                } else if (adbEntry2 != null && (adbEntry2.getCombinedName().equals("") || adbEntry2.getCombinedName().equals(adbEntry2.getPhoneData()[0].getNumber()))) {
                    eventGeneric.setLong(0, 0L);
                } else {
                    long l = eventGeneric.getLong(0);
                    if (l != 0L) {
                        if (ASLPhoneData.getInstance().adbEntryCallstacksCached != null && ASLPhoneData.getInstance().adbEntryCallstacksCached.entryId == l) {
                            adbEntry = ASLPhoneData.getInstance().adbEntryCallstacksCached;
                            ASLPhoneData.getInstance().adbEntryCallstacksCached = null;
                        } else if (ASLPhoneData.getInstance().adbEntryContactsCached != null && ASLPhoneData.getInstance().adbEntryContactsCached.entryId == l) {
                            adbEntry = ASLPhoneData.getInstance().adbEntryContactsCached;
                            ASLPhoneData.getInstance().adbEntryContactsCached = null;
                        } else if (ASLPhoneData.getInstance().dataSetContactsCached != null && ASLPhoneData.getInstance().dataSetContactsCached.entryId == l) {
                            dataSet = ASLPhoneData.getInstance().dataSetContactsCached;
                            ASLPhoneData.getInstance().dataSetContactsCached = null;
                        }
                        if (adbEntry == null && dataSet == null && (dataSet = (DataSet)ListManager.getGenericASLList(1190).getListItemByIdCacheOnly(l)) == null) {
                            dataSet = (DataSet)ListManager.getGenericASLList(1169).getListItemByIdCacheOnly(l);
                        }
                    }
                }
                String string = eventGeneric.getString(1);
                if (this.isTraceEnabled()) {
                    this.trace().append("ASL_PHONE_CALL_DIAL_NUMBER received with number: ").append(string).log();
                }
                String string2 = PhoneUtil.trimNumber(string);
                if (adbEntry != null) {
                    this.dialNumberFromDB(string2, adbEntry, n2);
                } else if (dataSet != null) {
                    this.dialNumberFromDB(string2, dataSet, n2);
                } else {
                    this.dialTrimmedNumber(string2);
                }
                ASLPhoneData.getInstance().adbEntryCallstacksCached = null;
                ASLPhoneData.getInstance().adbEntryContactsCached = null;
                ASLPhoneData.getInstance().dataSetContactsCached = null;
                break;
            }
            case 1080441840: {
                CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).joinCalls();
                break;
            }
            case 1073742757: {
                int n = eventGeneric.getInt(0);
                this.getListenerFromCallInformationsList(n).joinCalls();
                break;
            }
            case 1073742766: {
                int n = eventGeneric.getInt(0);
                PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)ListManager.getGenericASLList(1160).getRowItem(n);
                phoneCallInformationCollector.mobileEquipment.splitCall(phoneCallInformationCollector);
                break;
            }
            case 1073742756: 
            case 1080441839: {
                int n = eventGeneric.getInt(0);
                this.getListenerFromCallInformationsList(n).swapCalls();
                break;
            }
            case 1073742759: 
            case 1080441843: {
                int n = eventGeneric.getInt(0);
                this.getListenerFromCallInformationsList(n).swapCalls();
                break;
            }
            case 1073742758: 
            case 1080441841: {
                this.callInformations.getFillingInstance().replace();
                break;
            }
            case 1073742695: 
            case 1080441834: {
                boolean bl = eventGeneric.getBoolean(0);
                int n = bl ? 0 : 1;
                PhoneUtil.setMicMuteState(CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()), n);
                break;
            }
            case 1073742696: 
            case 1080441835: {
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) {
                    this.send(ServiceManager.mGenericEventFactory.newEvent(-2031208960));
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(34159872);
                    eventGeneric2.setInt(0, 106);
                    this.send(eventGeneric2);
                    this.isMuted = true;
                    CallHandling.writeBooleanToDatapool(1096, true);
                    CallHandling.writeBooleanToDatapool(-60660224, true);
                    this.sendHMIEvent(161);
                    break;
                }
                this.demuteRingToneIfNecessary(true);
                break;
            }
            case 3600011: {
                this.demuteRingToneIfNecessary(false);
                break;
            }
            case 0x40000424: {
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) {
                    CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).requestSetHandsFreeMode(0);
                    break;
                }
                CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).requestSetHandsFreeMode(4);
                break;
            }
            case 1075141866: 
            case 1080441844: {
                int n = eventGeneric.getInt(0);
                if (n == 0) {
                    CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).requestSetHandsFreeMode(0);
                    break;
                }
                if (n != 2) break;
                CallHandling$MobileEquipmentListener.access$100(this.callInformations.getFillingInstance()).requestSetHandsFreeMode(4);
                break;
            }
            case 100002: {
                if (eventGeneric.getResult() != 0) break;
                this.send(ServiceManager.mGenericEventFactory.newEvent(-2047986176));
                break;
            }
            case 4000021: {
                this.callInformations.audioManagementStatus(this, eventGeneric.getInt(0));
                break;
            }
            case 3600024: {
                if (eventGeneric.getResult() != 0 || !this.callInformations.isAnyActive()) break;
                ASLPhoneData.getInstance().activePhoneAudioConnection = eventGeneric.getInt(0);
                if (ASLPhoneData.getInstance().activePhoneAudioConnection != 98) break;
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(-2047986176);
                this.sendSafe(eventGeneric3);
                break;
            }
            case 1073742694: {
                this.getPrimary().requestServiceCodeAbort();
                break;
            }
            case 1073742751: {
                this.sendHMIEvent(164);
                PhoneCallInformationCollector[] phoneCallInformationCollectorArray = (PhoneCallInformationCollector[])ListManager.getGenericASLList(1158).getDSIObjects();
                for (int i2 = 0; i2 < phoneCallInformationCollectorArray.length; ++i2) {
                    if (phoneCallInformationCollectorArray[i2].callInformation.telCallType != 3) continue;
                    CallHandling$MobileEquipmentListener.access$200(phoneCallInformationCollectorArray[i2].mobileEquipment, phoneCallInformationCollectorArray[i2].callInformation.telCallID);
                    break block0;
                }
                break;
            }
            case 1073742763: {
                ServiceManager.aslPropertyManager.valueChangedInteger(1152, 0);
                this.sendHMIEvent(165);
                break;
            }
            case 3600014: {
                this.callInformations.handleCallStates(this);
                break;
            }
            case 4000031: {
                int n = eventGeneric.getInt(0);
                if (n != 104 && n != 99) break;
                PhoneUtil.setActiveAudioConnection(n);
                if (!this.callInformations.isEmpty()) break;
                PhoneUtil.releaseAudioConnection(this, false);
                break;
            }
        }
    }

    private CallHandling$MobileEquipmentListener getListenerFromCallInformationsList(int n) {
        return ((PhoneCallInformationCollector)ListManager.getGenericASLList((int)1158).getRowItem((int)n)).mobileEquipment;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return new int[]{8, 9, 12, 25, 2, 26, 28, 38, 15, 4, 18};
        }
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    @Override
    protected int[] getMobileEquipmentHfpOnlyNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return ASLPhoneData.EMPTY_NOTIFICATION;
        }
        return new int[]{8, 9, 12, 25, 2, 26, 38, 15, 4, 18};
    }

    @Override
    protected void pendingTopologyChange(int[] nArray, int[] nArray2) {
        if (nArray != null && nArray[0] != nArray2[0] && this.callInformations.isAnyActive()) {
            this.callInformations.getFillingInstance().updateCallList(new CallInformation[0], 1);
            this.callInformations.getFillingInstance().updateCallDurationList(new CallDuration[0], 1);
        }
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        return this.mobileEquipmentListeners[0];
    }

    @Override
    protected DSIMobileEquipmentListener createAssociatedListener() {
        return this.mobileEquipmentListeners[1];
    }

    private void checkEmergencyCallEnabled(Coding coding) {
        this.emergencyCallAvailable = coding.getBoolean(103);
        CallHandling.writeBooleanToDatapool(1237, this.emergencyCallAvailable);
        this.updateShortDialList();
        if (ASLPhoneData.getInstance().emergencyNumbers != null) {
            PhoneServiceImpl.getInstance().getSpecialNumbersUpdater().updateEmergencyNumbers(ASLPhoneData.getInstance().emergencyNumbers, this.emergencyCallAvailable);
        }
    }

    private void updateShortDialList() {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        ArrayList arrayList = new ArrayList(5);
        if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().emergencyNumbers.mainEmergencyNumber) && this.emergencyCallAvailable) {
            bl3 = true;
            arrayList.add(new PhoneCallDialShortDialCollector(0));
        }
        if (!ASLPhoneData.getInstance().roaming) {
            if (ASLPhoneData.getInstance().serviceNumbers != null) {
                if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().serviceNumbers.breakdownNumber)) {
                    bl2 = true;
                    arrayList.add(new PhoneCallDialShortDialCollector(1));
                    CallHandling.writeStringToDatapool(1153, ASLPhoneData.getInstance().serviceNumbers.breakdownNumber);
                }
                if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().serviceNumbers.infonumber)) {
                    bl = true;
                    arrayList.add(new PhoneCallDialShortDialCollector(2));
                    CallHandling.writeStringToDatapool(1150, ASLPhoneData.getInstance().serviceNumbers.infonumber);
                }
            }
        } else if (ASLPhoneData.getInstance().serviceNumbers != null) {
            if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().serviceNumbers.breakdownNumberRoaming)) {
                bl2 = true;
                arrayList.add(new PhoneCallDialShortDialCollector(1));
                CallHandling.writeStringToDatapool(1153, ASLPhoneData.getInstance().serviceNumbers.breakdownNumberRoaming);
            }
            if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().serviceNumbers.infonumberRoaming)) {
                bl = true;
                arrayList.add(new PhoneCallDialShortDialCollector(2));
                CallHandling.writeStringToDatapool(1150, ASLPhoneData.getInstance().serviceNumbers.infonumberRoaming);
            }
        }
        ListManager.getGenericASLList(1167).updateList(arrayList.toArray(new PhoneCallDialShortDialCollector[arrayList.size()]));
        CallHandling.writeBooleanToDatapool(1166, bl2);
        CallHandling.writeBooleanToDatapool(1164, bl3);
        CallHandling.writeBooleanToDatapool(1165, bl);
    }

    private static boolean isCallForwarding(SuppServiceResponseStruct suppServiceResponseStruct) {
        if (suppServiceResponseStruct != null && !Util.isNullOrEmpty(suppServiceResponseStruct.getTelCFResponseData())) {
            for (int i2 = 0; i2 < suppServiceResponseStruct.telCFResponseData.length; ++i2) {
                CFResponseData cFResponseData = suppServiceResponseStruct.telCFResponseData[i2];
                if (cFResponseData.getTelCFStatus() != 1 || cFResponseData.getTelCFCondition() != 0) continue;
                return true;
            }
        }
        return false;
    }

    private void handleSupplementaryServiceStruct(SuppServiceResponseStruct suppServiceResponseStruct) {
        if (suppServiceResponseStruct != null) {
            if (!Util.isNullOrEmpty(suppServiceResponseStruct.telResponseText)) {
                CallHandling.writeIntegerToDatapool(1090, 3);
                CallHandling.writeStringToDatapool(1091, suppServiceResponseStruct.telResponseText);
            } else {
                if (suppServiceResponseStruct.getTelServiceState() == 2 || suppServiceResponseStruct.getTelServiceState() == 4 || suppServiceResponseStruct.getTelServiceState() == 5) {
                    CallHandling.writeIntegerToDatapool(1090, 2);
                    this.sendHMIEvent(195);
                } else {
                    CallHandling.writeIntegerToDatapool(1090, 1);
                    this.sendHMIEvent(197);
                }
                CallHandling.writeStringToDatapool(1091, "");
            }
            PhoneUtil.updateCWStatus(suppServiceResponseStruct.getTelCWStatus());
            PhoneUtil.updateCLIRStatus(suppServiceResponseStruct.getTelCLIRState(), suppServiceResponseStruct.telCLIRNWState);
            PhoneUtil.updateCFStatus(suppServiceResponseStruct.getTelCFResponseData());
        }
    }

    private void handleCallDurationList(CallDuration[] callDurationArray) {
        if (this.callInformations.isEmpty() && Util.isNullOrEmpty(callDurationArray)) {
            this.callInformations.distributeCallList();
            CallHandling.writeBooleanToDatapool(1096, false);
            CallHandling.writeBooleanToDatapool(1095, false);
            CallHandling.writeBooleanToDatapool(-60660224, false);
            CallHandling.writeBooleanToDatapool(-77437440, false);
            PhoneUtil.setMicMuteState(this.getPrimary(), 1);
        } else {
            this.callInformations.updateCallCollector(callDurationArray);
            if (this.callListModified) {
                this.callInformations.distributeCallList();
                this.callInformations.handleCallStates(this);
                this.callListModified = false;
            } else {
                ListManager.getGenericASLList(1158).updateList(ListManager.getGenericASLList(1158).getDSIObjects());
                if (this.callInformations.getCurrentMainCallCollector() != null) {
                    Object[] objectArray = (PhoneTileSCallCallInformationsCollector[])ListManager.getGenericASLList(-127769088).getDSIObjects();
                    CallDuration callDuration = this.callInformations.getCurrentMainCallCollector().callDuration;
                    objectArray[0].phonetiles_call_duration = callDuration != null ? callDuration.getTelElapsedTime() : 0;
                    ListManager.getGenericASLList(-127769088).updateList(objectArray);
                }
            }
        }
    }

    private void handleCallList(CallInformation[] callInformationArray, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        if (callInformationArray.length == 1 && ASLPhoneData.getInstance().isCallRespHold && callInformationArray[0].getTelCallState() == 6) {
            callInformationArray[0].telCallState = 8;
        }
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        this.sendHMIEvent(559);
        int n = 0;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        ASLPhoneData.getInstance().incomingOrOutgoingCallIDs.clear();
        for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
            intOptHashSet.add(callInformationArray[i2].getTelCallID());
            if (callInformationArray[i2].getTelMpty() == 0) {
                bl5 = true;
            } else if (callInformationArray[i2].getTelMpty() == 1) {
                bl4 = true;
            }
            if (callInformationArray[i2].getTelCallState() == 4) {
                bl = true;
            }
            if (callInformationArray[i2].getTelCallState() == 2) {
                bl2 = true;
            }
            if (callInformationArray[i2].getTelCallState() == 3) {
                bl3 = true;
            }
            if (callInformationArray[i2].getTelCallType() == 4 || callInformationArray[i2].getTelMpty() == 0) {
                ++n;
            }
            if (callInformationArray[i2].getTelCallType() == 4 && callInformationArray[i2].getTelCallState() == 6) {
                bl6 = true;
            }
            if (callInformationArray[i2].getTelCallState() != 3 && callInformationArray[i2].getTelCallState() != 1 && callInformationArray[i2].getTelCallState() != 2) continue;
            ASLPhoneData.getInstance().incomingOrOutgoingCallIDs.add(new Short(callInformationArray[i2].getTelCallID()));
        }
        if (this.allCallsDisconnecting(callInformationArray) && this.allCallsDisconnecting(this.other((CallHandling$MobileEquipmentListener)callHandling$MobileEquipmentListener).callList)) {
            if (this.isHandsfreeModeTimerRunning) {
                this.stopTimer(-1551499008);
                this.isHandsfreeModeTimerRunning = false;
            }
            PhoneUtil.releaseAudioConnection(this, true);
        }
        ASLPhoneData.getInstance().isConferenceOnHold = bl6;
        this.callInformations.notifyCallActive(bl);
        CallHandling.writeBooleanToDatapool(-427617024, bl || bl2 && ASLPhoneData.getInstance().isDTMFWithoutActiveCall);
        boolean bl7 = ASLPhoneData.getInstance().isMultiPartySplitAvailable = !bl4 || !bl5;
        if (!Util.isNullOrEmpty(callInformationArray)) {
            this.callInformations.updateCallCollector(callInformationArray, callHandling$MobileEquipmentListener);
            this.callInformations.distributeCallList();
            switch (n) {
                case 1: {
                    this.setCallCount(1, bl3);
                    break;
                }
                case 2: {
                    this.setCallCount(2, false);
                    break;
                }
                case 3: {
                    this.setCallCount(3, false);
                    break;
                }
            }
            PhoneCallIncomingCallInformationsCollector phoneCallIncomingCallInformationsCollector = new PhoneCallIncomingCallInformationsCollector();
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_name = callInformationArray[0].telRemName;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_number = callInformationArray[0].telRemNumber;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_picture = callInformationArray[0].telRemPictureId;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_picture_available = callInformationArray[0].telRemPictureId != null;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_type__1 = PhoneUtil.convertCallTypeDSI2ASL(callInformationArray[0]);
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_combined_number_type__1 = PhoneUtil.convertPhoneTypeDSI2ASLCombined(callInformationArray[0].getTelRemNumberType());
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_first_button_state = ASLPhoneData.getInstance().carPlayCallActive ? 1 : 0;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_first_button_available = true;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_second_button_available = !ASLPhoneData.getInstance().carPlayCallActive;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_second_button_state = Util.isBitSet(4, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) ? 1 : 0;
            phoneCallIncomingCallInformationsCollector.phone_call_carrier_state__1 = callHandling$MobileEquipmentListener.getRole() == 0 ? 0 : 1;
            phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_hang_up_button_available = ASLPhoneData.getInstance().getCurrentCallsTelMode() != 3 || callInformationArray[0].getTelCallState() != 6;
            ListManager.getGenericASLList(1159).updateList(new PhoneCallIncomingCallInformationsCollector[]{phoneCallIncomingCallInformationsCollector});
        } else {
            ASLPhoneData.getInstance().isCallRespHold = false;
            this.setCallCount(0, false);
            CallHandling.writeBooleanToDatapool(1156, false);
            this.callInformations.clear();
            this.handleCallDurationList(new CallDuration[0]);
        }
        if (!ASLPhoneData.getInstance().isCallsAvailable && callInformationArray.length != 0) {
            if (this.isTraceEnabled()) {
                this.trace().append("send PHONE_INIT_UPDATE from active call").log();
            }
            this.sendHMIEvent(452);
            this.sendHMIEvent(-245209600);
            if (this.callInformations.getFillingInstance().getTelMode() == 3) {
                ListManager.getGenericASLList(1245).updateList(AUDIOMODE_HFP);
            } else {
                ListManager.getGenericASLList(1245).updateList(AUDIOMODE_NONE);
                this.callInformations.getFillingInstance().updateHandsFreeMode(0, 1);
            }
        }
        IntOptHashSet intOptHashSet2 = new IntOptHashSet(CallHandling$MobileEquipmentListener.access$2300(callHandling$MobileEquipmentListener));
        intOptHashSet2.removeAll(intOptHashSet);
        CallHandling$MobileEquipmentListener.access$2300(callHandling$MobileEquipmentListener).removeAll(intOptHashSet2);
        ASLPhoneData.getInstance().isCallsAvailable = callInformationArray.length != 0;
    }

    private boolean allCallsDisconnecting(CallInformation[] callInformationArray) {
        for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
            if (callInformationArray[i2].getTelCallState() == 5) continue;
            return false;
        }
        return true;
    }

    private void setCallCount(int n, boolean bl) {
        if (n != this.callCount) {
            CallHandling.writeIntegerToDatapool(1148, n);
            this.callCount = n;
        }
        CallHandling.writeIntegerToDatapool(-144546304, bl ? 0 : n);
    }

    private void dialTrimmedNumber(String string) {
        if (Util.isNullOrEmpty(string)) {
            if (this.isTraceEnabled()) {
                this.trace().append("Phone dialing prevented by ASL because of empty number!").log();
            }
            this.sendHMIEvent(163);
        } else {
            string = PhoneUtil.filterWidgetMarkers(string);
            if (this.isTraceEnabled()) {
                this.trace().append("Phone number to dial: ").append(string).log();
            }
            if ((this.primaryActivationState == 5 || this.primaryActivationState == 2) && this.primaryTelMode == 3) {
                this.getPrimary().dialNumber(string);
            } else if (this.getNad() != null) {
                this.getNad().dialNumber(string);
            } else {
                this.error("Could not dial number due to no HFP phone connected and no NAD instance available!");
            }
            this.startTimer(-1601830656, (long)0, false);
        }
    }

    private void dialNumberFromDB(String string, AdbEntry adbEntry, int n) {
        string = PhoneUtil.filterWidgetMarkers(string);
        if (this.isTraceEnabled()) {
            this.trace().append("Phone number to dial: ").append(string).log();
        }
        this.getPrimary().dialNumberFromDBEntry(string, (int)adbEntry.entryId, adbEntry.combinedName, (short)n, (short)adbEntry.entryType, adbEntry.personalData.contactPicture, -1, adbEntry.phoneData.length);
        this.startTimer(-1601830656, (long)0, false);
    }

    private void dialNumberFromDB(String string, DataSet dataSet, int n) {
        string = PhoneUtil.filterWidgetMarkers(string);
        if (this.isTraceEnabled()) {
            this.trace().append("Phone number to dial: ").append(string).log();
        }
        this.getPrimary().dialNumberFromDBEntry(string, (int)dataSet.entryId, dataSet.generalDescription1, (short)n, (short)dataSet.entryType, dataSet.contactPicture, -1, dataSet.phoneCount);
        this.startTimer(-1601830656, (long)0, false);
    }

    private void checkWidebandSpeech(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        if (this.lastWidebandSpeechSet != CallHandling$MobileEquipmentListener.access$2400(callHandling$MobileEquipmentListener)) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(621362432);
            eventGeneric.setBoolean(0, CallHandling$MobileEquipmentListener.access$2400(callHandling$MobileEquipmentListener));
            this.sendSafe(eventGeneric);
            this.lastWidebandSpeechSet = CallHandling$MobileEquipmentListener.access$2400(callHandling$MobileEquipmentListener);
        }
    }

    private void demuteRingToneIfNecessary(boolean bl) {
        if (this.isMuted) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
            eventGeneric.setInt(0, 106);
            if (bl && this.callInformations.getFillingInstance().isOutband()) {
                eventGeneric.setSenderEventId(-1568276224);
            }
            this.send(eventGeneric);
            this.isMuted = false;
            CallHandling.writeBooleanToDatapool(1096, false);
            CallHandling.writeBooleanToDatapool(-60660224, false);
        }
    }

    @Override
    public void dialNumber(String string) {
        this.dialTrimmedNumber(PhoneUtil.trimNumber(string));
    }

    @Override
    public void dialNumber(PhoneNumber phoneNumber) {
        String string = PhoneUtil.trimNumber(phoneNumber.getNumber());
        CommonContact commonContact = phoneNumber.getCommonContact();
        if (commonContact != null) {
            this.getPrimary().dialNumberFromDBEntry(string, commonContact.getContactId(), commonContact.getCombinedName(), (short)phoneNumber.getTelPhoneType(), (short)commonContact.getTelEntryType(), commonContact.getImage(), -1, commonContact.getNumberCount());
        } else {
            this.getPrimary().dialNumber(string);
        }
        this.startTimer(-1601830656, (long)0, false);
    }

    public void dsiPowerManagementUpdateTelMaxPopup(boolean bl, int n) {
        if (bl) {
            this.popupSeconds = 180;
            CallHandling.writeStringToDatapool(1147, Integer.toString(this.popupSeconds));
            ServiceManager.eventMain.getTimerServer().sendTimedEvent(1922634752, -1964100096, 0, true);
            if (this.callInformations.getFillingInstance() != null && this.callInformations.getFillingInstance().getTelMode() == 3 && ASLPhoneData.getInstance().isCallsAvailable) {
                this.sendHMIEvent(158);
            } else {
                this.sendHMIEvent(159);
            }
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

    static /* synthetic */ void access$300(CallHandling callHandling) {
        callHandling.updateShortDialList();
    }

    static /* synthetic */ int access$400(CallHandling callHandling) {
        return callHandling.callCount;
    }

    static /* synthetic */ CallInformations access$500(CallHandling callHandling) {
        return callHandling.callInformations;
    }

    static /* synthetic */ boolean access$600(CallHandling callHandling) {
        return callHandling.emergencyCallAvailable;
    }

    static /* synthetic */ CallHandling$MobileEquipmentListener access$700(CallHandling callHandling) {
        return callHandling.currentDsiListener;
    }

    static /* synthetic */ void access$800(CallHandling callHandling, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        callHandling.checkWidebandSpeech(callHandling$MobileEquipmentListener);
    }

    static /* synthetic */ int access$902(CallHandling callHandling, int n) {
        callHandling.primaryActivationState = n;
        return callHandling.primaryActivationState;
    }

    static /* synthetic */ int access$1002(CallHandling callHandling, int n) {
        callHandling.primaryTelMode = n;
        return callHandling.primaryTelMode;
    }

    static /* synthetic */ CallHandling$MobileEquipmentListener[] access$1100(CallHandling callHandling) {
        return callHandling.mobileEquipmentListeners;
    }

    static /* synthetic */ boolean access$1200(CallHandling callHandling, CallInformation[] callInformationArray) {
        return callHandling.allCallsDisconnecting(callInformationArray);
    }

    static /* synthetic */ CallHandling$MobileEquipmentListener access$1300(CallHandling callHandling, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        return callHandling.other(callHandling$MobileEquipmentListener);
    }

    static /* synthetic */ boolean access$1400(CallHandling callHandling) {
        return callHandling.isHandsfreeModeTimerRunning;
    }

    static /* synthetic */ boolean access$1402(CallHandling callHandling, boolean bl) {
        callHandling.isHandsfreeModeTimerRunning = bl;
        return callHandling.isHandsfreeModeTimerRunning;
    }

    static /* synthetic */ Integer[] access$1500() {
        return AUDIOMODE_HFP;
    }

    static /* synthetic */ Integer[] access$1600() {
        return AUDIOMODE_NONE;
    }

    static /* synthetic */ CallHandling$MobileEquipmentListener access$702(CallHandling callHandling, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        callHandling.currentDsiListener = callHandling$MobileEquipmentListener;
        return callHandling.currentDsiListener;
    }

    static /* synthetic */ void access$1700(CallHandling callHandling, CallInformation[] callInformationArray, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        callHandling.handleCallList(callInformationArray, callHandling$MobileEquipmentListener);
    }

    static /* synthetic */ boolean access$1802(CallHandling callHandling, boolean bl) {
        callHandling.callListModified = bl;
        return callHandling.callListModified;
    }

    static /* synthetic */ void access$1900(CallHandling callHandling, CallDuration[] callDurationArray) {
        callHandling.handleCallDurationList(callDurationArray);
    }

    static /* synthetic */ boolean access$2000(SuppServiceResponseStruct suppServiceResponseStruct) {
        return CallHandling.isCallForwarding(suppServiceResponseStruct);
    }

    static /* synthetic */ void access$2100(CallHandling callHandling, SuppServiceResponseStruct suppServiceResponseStruct) {
        callHandling.handleSupplementaryServiceStruct(suppServiceResponseStruct);
    }

    static /* synthetic */ int access$2202(CallHandling callHandling, int n) {
        callHandling.handsFreeAudioMode = n;
        return callHandling.handsFreeAudioMode;
    }
}

