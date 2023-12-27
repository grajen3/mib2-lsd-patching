/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.CallForwardingsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.CallInformationsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.ConferenceCallInformationsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.DialedCallsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.MissedCallsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.MixedCallsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.PhonePresetsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl.ReceivedCallsASLDataPoolIterator;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.List;

public class PhoneASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements PhoneService {
    private APIFactoryInterface apiFactory;
    private static final int[] PHONE_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{3606, 1120, 3930, 1103, 1118, 1115, 1115, 1116, 1101, 1102, 1100, 1157, 2565, 1085, 1084, 1086, 1161, 1152, 1149, 1153, 1150, 1248, 3852, 2906, 2908, 1242, 1089, 1129, -545057536, 1081, 336, 337, 4032, 1148, 1238, 1082, 1095, 1096, 1174, 1099, -595389184, 1155, 1097, 1087, 1183, 1180, -991818496, 449, 456, 1207, -612166400, 1080};
    private static final int[] PHONE_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{1158, 1160, 1104, 1105, 1107, 1194, 1106, 1210};
    private static final int[] PHONE_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{467, 483, 164, 165, 468, 465, 464, 163, 452, 133, 130, 63};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$phone$PhoneService;

    public PhoneASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, PHONE_HMI_EVENT_IDS_TO_LISTEN_TO);
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$phone$PhoneService == null ? (class$de$vw$mib$bap$mqbab2$common$api$phone$PhoneService = PhoneASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.phone.PhoneService")) : class$de$vw$mib$bap$mqbab2$common$api$phone$PhoneService;
    }

    @Override
    public Iterator getCallInformations() {
        return new CallInformationsASLDataPoolIterator();
    }

    @Override
    public Iterator getConferenceCallInformations() {
        return new ConferenceCallInformationsASLDataPoolIterator();
    }

    @Override
    public String getBluetoothDeviceName() {
        return this.getDataPool().getString(3606, "");
    }

    @Override
    public final String getBluetoothExternalDeviceName() {
        return this.getDataPool().getString(1120, "");
    }

    @Override
    public boolean isBluetoothConnectedUserPopUpVisible() {
        return this.getDataPool().getBoolean(3930, false);
    }

    @Override
    public int getTelephoneFeatures() {
        return this.getDataPool().getInteger(1103, 0);
    }

    @Override
    public int getCurrentPhoneProfile() {
        return this.getDataPool().getInteger(1118, 0);
    }

    @Override
    public int getCurrentPhoneMediaProfile() {
        return this.getDataPool().getInteger(1115, 0);
    }

    @Override
    public int getCurrentPhoneOtherProfile() {
        return this.getDataPool().getInteger(1116, 0);
    }

    @Override
    public Iterator getMixedCalls() {
        return new MixedCallsASLDataPoolIterator();
    }

    @Override
    public int getDataVolumeState() {
        return this.getDataPool().getInteger(1101, 0);
    }

    @Override
    public int getDataVolumeUplink() {
        return this.getDataPool().getInteger(1102, 0);
    }

    @Override
    public int getDataVolumeDownlink() {
        return this.getDataPool().getInteger(1100, 0);
    }

    @Override
    public Iterator getDialedCalls() {
        return new DialedCallsASLDataPoolIterator();
    }

    @Override
    public boolean isPhoneLineFree() {
        return this.getDataPool().getBoolean(1157, true);
    }

    @Override
    public String getLastDialedNumber() {
        return PhoneASLDataAdapter.getStringListValue(2565, 3);
    }

    @Override
    public int getNetworkState() {
        return this.getDataPool().getInteger(1085, 0);
    }

    @Override
    public String getNetworkName() {
        return this.getDataPool().getString(1084, "");
    }

    @Override
    public int getNetworkType() {
        return this.getDataPool().getInteger(1086, 0);
    }

    @Override
    public int getDialingFailedReason() {
        return this.getDataPool().getInteger(1161, 0);
    }

    @Override
    public int getSelectedNumberType() {
        return this.getDataPool().getInteger(1152, 1);
    }

    @Override
    public String getEmergencyCallNumber() {
        return this.getDataPool().getString(1149, "");
    }

    @Override
    public String getServiceCallNumber() {
        return this.getDataPool().getString(1153, "");
    }

    @Override
    public String getInfoCallNumber() {
        return this.getDataPool().getString(1150, "");
    }

    @Override
    public String getMailboxCallNumber() {
        return this.getDataPool().getString(1248, "");
    }

    @Override
    public Iterator getPhonePresets() {
        return new PhonePresetsASLDataPoolIterator();
    }

    @Override
    public int getNetworkAccessDeviceState() {
        return this.getDataPool().getInteger(3852, 0);
    }

    @Override
    public int getPhoneActivationState() {
        return this.getDataPool().getInteger(2906, 0);
    }

    @Override
    public int getBluetoothState() {
        return this.getDataPool().getInteger(2908, 2);
    }

    @Override
    public int getBluetoothVisibility() {
        return this.getDataPool().getInteger(-612166400, 1);
    }

    @Override
    public boolean isPhonePrivacyModeActive() {
        return this.getDataPool().getBoolean(1242, false);
    }

    @Override
    public int getSimCardReaderType() {
        return this.getDataPool().getInteger(1089, 0);
    }

    @Override
    public int getBluetoothSoftwareDownloadState() {
        return this.getDataPool().getInteger(1129, 0);
    }

    @Override
    public boolean isRemoteSimAccessProfileSupported() {
        return this.getDataPool().getBoolean(-545057536, false);
    }

    @Override
    public int getSimCardState() {
        return this.getDataPool().getInteger(1081, 0);
    }

    @Override
    public boolean isExternalPhoneAvailable() {
        return this.getDataPool().getBoolean(336, false);
    }

    @Override
    public boolean isInternalPhoneAvailable() {
        return this.getDataPool().getBoolean(337, false);
    }

    @Override
    public boolean isNetworkingInternalSimDataModeOnly() {
        return this.getDataPool().getBoolean(4032, false);
    }

    @Override
    public int getCurrentPhoneCallCount() {
        return this.getDataPool().getInteger(1148, 0);
    }

    @Override
    public boolean isHandsfreeAudioEnabled() {
        return this.getDataPool().getBoolean(1238, false);
    }

    @Override
    public int getPhoneLockState() {
        return this.getDataPool().getInteger(1082, 2);
    }

    @Override
    public boolean isMicrophoneMuted() {
        return this.getDataPool().getBoolean(1095, false);
    }

    @Override
    public boolean isRingtoneMuted() {
        return this.getDataPool().getBoolean(1096, false);
    }

    @Override
    public int getCurrentMissedCallsCount() {
        return this.getDataPool().getInteger(1174, 0);
    }

    @Override
    public Iterator getMissedCalls() {
        return new MissedCallsASLDataPoolIterator();
    }

    @Override
    public int getPhoneBatteryLevelWarning() {
        return this.getDataPool().getInteger(1099, 0);
    }

    @Override
    public int getPhoneBatteryLevel() {
        return this.getDataPool().getInteger(-595389184, 0);
    }

    @Override
    public boolean isPhoneCallActive() {
        return this.getDataPool().getBoolean(1155, false);
    }

    @Override
    public boolean isSignalStrengthAvailable() {
        return this.getDataPool().getBoolean(1097, false);
    }

    @Override
    public int getSignalStrength() {
        return this.getDataPool().getInteger(1087, 0);
    }

    @Override
    public int getContactsDownloadStatus() {
        return this.getDataPool().getInteger(1180, 0);
    }

    @Override
    public Iterator getReceivedCalls() {
        return new ReceivedCallsASLDataPoolIterator();
    }

    @Override
    public boolean isMessagingAvailable() {
        return this.getDataPool().getBoolean(-991818496, false);
    }

    @Override
    public int getNumberOfNewMessages() {
        return this.getDataPool().getInteger(449, 0);
    }

    @Override
    public boolean isMessageStorageFull() {
        return this.getDataPool().getBoolean(456, false);
    }

    @Override
    public boolean isCallForwardingAvailable() {
        return this.getDataPool().getBoolean(1207, false);
    }

    @Override
    public Iterator getCallForwardings() {
        return new CallForwardingsASLDataPoolIterator();
    }

    @Override
    public int getPhoneDataConnectionType() {
        return this.getDataPool().getInteger(1080, 0);
    }

    @Override
    public void setMicrophoneMute(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1728249920, eventGeneric);
    }

    @Override
    public void setRingtoneMute(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1745027136, eventGeneric);
    }

    @Override
    public void clearNewMessageCounter() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1694564416);
    }

    @Override
    public void startEmergencyCall() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1067707072);
    }

    @Override
    public void startEmergencyCallInternal() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1425866688);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void abortEmergencyCall() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1627193280);
    }

    @Override
    public void acceptCall(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1610416064, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void acceptResponseAndHoldCall(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1492516800, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void joinCallToConference(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1526529984, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void splitCallFromConference(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1375535040, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void hangUpCall(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1560084416, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void replaceActiveWithIncomingCall() {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1509752768, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void removeCallFromConference(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1409089472, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void startCall(long l, String string) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        eventGeneric.setString(1, string);
        eventGeneric.setInt(2, 0);
        eventGeneric.setInt(4, -1);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-430172864, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void setNumberForDailing(String string) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setString(0, string);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1459421120, eventGeneric);
    }

    @Override
    public void setCallStateToHold(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1543307200, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void setCallStateToResponseAndHold(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1475739584, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void resumeCall(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1492975552, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(4);
    }

    @Override
    public void clearMissedCallsCounter() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1123876800);
    }

    @Override
    public void clearCallStack(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1107099584, eventGeneric);
    }

    @Override
    public void setHandsfreeAudioModeActive(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x24040040, eventGeneric);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                PhoneServiceListener phoneServiceListener = (PhoneServiceListener)iterator.next();
                phoneServiceListener.updatePhoneData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return PHONE_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return PHONE_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addPhoneServiceListener(PhoneServiceListener phoneServiceListener, int[] nArray) {
        this.registerServiceListener((Object)phoneServiceListener, nArray);
    }

    @Override
    public void removePhoneServiceListener(PhoneServiceListener phoneServiceListener, int[] nArray) {
        this.removeServiceListener(phoneServiceListener, nArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

