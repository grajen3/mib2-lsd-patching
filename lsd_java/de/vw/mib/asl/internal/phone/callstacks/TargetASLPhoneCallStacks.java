/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.callstacks;

import de.vw.mib.asl.api.phone.services.callstack.CallstackService;
import de.vw.mib.asl.api.phone.services.callstack.CallstackUpdates;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.api.model.CallstackEntryImpl;
import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;
import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksNumbersCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialLastDialedNumberInformationsCollector;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.MissedCallIndicator;

public class TargetASLPhoneCallStacks
extends TripleMobileEquipment
implements CallstackService {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[135]};
    private static final int EV_ASL_INT_RESP_GET_ENTRY_RESULT;
    int callstackSortingType = -1;
    ArrayList answeredEntries = new ArrayList();
    ArrayList dialedEntries = new ArrayList();
    ArrayList missedEntries = new ArrayList();
    private ArrayList acceptedServiceEntries;
    private ArrayList dialedServiceEntries;
    private ArrayList missedServiceEntries;
    private ArrayList mixedServiceEntries;
    private boolean alreadyRegistered = false;
    private final ArrayList listeners = new ArrayList();
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$services$callstack$CallstackService;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;

    public TargetASLPhoneCallStacks(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        Object[] objectArray = new PhoneCallstacksCallstacksCollector[]{};
        ListManager.getGenericASLList(1170).updateList(objectArray);
        ListManager.getGenericASLList(1171).updateList(objectArray);
        ListManager.getGenericASLList(1172).updateList(objectArray);
        ListManager.getGenericASLList(1173).updateList(objectArray);
        ListManager.getGenericASLList(1170).setColumn4ObjectId(0);
        ListManager.getGenericASLList(1171).setColumn4ObjectId(0);
        ListManager.getGenericASLList(1172).setColumn4ObjectId(0);
        ListManager.getGenericASLList(1173).setColumn4ObjectId(0);
    }

    @Override
    public int getDefaultTargetId() {
        return 5255;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            this.addObserver(-1039990720);
            this.addObserver(-1107099584);
            this.addObserver(-1090322368);
            this.addObserver(-514058944);
            this.addObserver(-1123876800);
            this.addObserver(-83689408);
            this.addObserver(-1056767936);
            this.addObserver(-497281728);
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$phone$services$callstack$CallstackService == null ? (class$de$vw$mib$asl$api$phone$services$callstack$CallstackService = TargetASLPhoneCallStacks.class$("de.vw.mib.asl.api.phone.services.callstack.CallstackService")) : class$de$vw$mib$asl$api$phone$services$callstack$CallstackService, this);
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return new int[]{47, 48, 49, 51, 46};
        }
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    @Override
    protected int[] getMobileEquipmentHfpOnlyNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return ASLPhoneData.EMPTY_NOTIFICATION;
        }
        return new int[]{47, 48, 49, 51, 46};
    }

    @Override
    protected void powerOn() {
        this.init();
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742785: {
                if (StringUtil.equals(ASLPhoneData.getInstance().localizedUnknownCall, eventGeneric.getString(0)) && StringUtil.equals(ASLPhoneData.getInstance().localizedEmergencyCall, eventGeneric.getString(1)) && StringUtil.equals(ASLPhoneData.getInstance().localizedInfoCall, eventGeneric.getString(2)) && StringUtil.equals(ASLPhoneData.getInstance().localizedServiceCall, eventGeneric.getString(3)) && StringUtil.equals(ASLPhoneData.getInstance().localizedMailboxCall, eventGeneric.getString(6))) break;
                ASLPhoneData.getInstance().localizedUnknownCall = eventGeneric.getString(0);
                ASLPhoneData.getInstance().localizedEmergencyCall = eventGeneric.getString(1);
                ASLPhoneData.getInstance().localizedInfoCall = eventGeneric.getString(2);
                ASLPhoneData.getInstance().localizedServiceCall = eventGeneric.getString(3);
                ASLPhoneData.getInstance().localizedMailboxCall = eventGeneric.getString(6);
                this.updateAllLists();
                break;
            }
            case 1073742786: {
                this.callstackSortingType = eventGeneric.getInt(0);
                TargetASLPhoneCallStacks.writeIntegerToDatapool(1175, this.callstackSortingType);
                break;
            }
            case 1073742782: {
                int n = eventGeneric.getInt(0);
                this.getPrimary().deleteCallstacksAll(n);
                break;
            }
            case 1073742783: {
                int n;
                int n2 = eventGeneric.getInt(0);
                switch (this.callstackSortingType) {
                    case 0: {
                        n = 1171;
                        break;
                    }
                    case 1: {
                        n = 1170;
                        break;
                    }
                    case 2: {
                        n = 1172;
                        break;
                    }
                    case 3: {
                        n = 1173;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
                PhoneCallstacksCallstacksCollector[] phoneCallstacksCallstacksCollectorArray = (PhoneCallstacksCallstacksCollector[])ListManager.getGenericASLList(n).getDSIObjects();
                this.getPrimary().deleteCallstacksEntry(phoneCallstacksCallstacksCollectorArray[n2].callListEntry.getClEntryType(), phoneCallstacksCallstacksCollectorArray[n2].callListEntry.getClEntryID());
                break;
            }
            case 1075141858: {
                int n;
                long l = eventGeneric.getLong(0);
                switch (this.callstackSortingType) {
                    case 0: {
                        n = 1171;
                        break;
                    }
                    case 1: {
                        n = 1170;
                        break;
                    }
                    case 2: {
                        n = 1172;
                        break;
                    }
                    case 3: {
                        n = 1173;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
                PhoneCallstacksCallstacksCollector[] phoneCallstacksCallstacksCollectorArray = (PhoneCallstacksCallstacksCollector[])ListManager.getGenericASLList(n).getDSIObjects();
                for (int i2 = 0; i2 < phoneCallstacksCallstacksCollectorArray.length; ++i2) {
                    if ((long)phoneCallstacksCallstacksCollectorArray[i2].callListEntry.getClEntryID() != l) continue;
                    TargetASLPhoneCallStacks.writeIntegerToDatapool(-192736000, i2);
                }
                break;
            }
            case 1075141857: {
                PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector;
                int n = eventGeneric.getInt(0);
                long l = eventGeneric.getLong(1);
                Object object = ListManager.getGenericASLList(1173).getListItemByIdCacheOnly(l);
                if (ListManager.getGenericASLList(1173).isValidItem(object)) {
                    phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
                } else {
                    int n3;
                    switch (this.callstackSortingType) {
                        case 0: {
                            n3 = 1171;
                            break;
                        }
                        case 1: {
                            n3 = 1170;
                            break;
                        }
                        case 2: {
                            n3 = 1172;
                            break;
                        }
                        case 3: {
                            n3 = 1173;
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException();
                        }
                    }
                    phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)ListManager.getGenericASLList(n3).getDSIObjects()[n];
                }
                if (phoneCallstacksCallstacksCollector.callListEntry.adbEntryID == 0L) break;
                PhoneUtil.getContactsDetails(this, 5255, 1753678080, phoneCallstacksCallstacksCollector.callListEntry.adbEntryID, true);
                break;
            }
            case 100200: {
                AdbEntry adbEntry;
                if (eventGeneric.getResult() != 0) break;
                ASLPhoneData.getInstance().adbEntryCallstacksCached = adbEntry = (AdbEntry)eventGeneric.getObject(1);
                PhoneData[] phoneDataArray = PhoneUtil.ripADBPhoneData(adbEntry.phoneData);
                PhoneCallstacksNumbersCollector[] phoneCallstacksNumbersCollectorArray = new PhoneCallstacksNumbersCollector[phoneDataArray.length];
                for (int i3 = 0; i3 < phoneDataArray.length; ++i3) {
                    PhoneCallstacksNumbersCollector phoneCallstacksNumbersCollector = new PhoneCallstacksNumbersCollector();
                    phoneCallstacksNumbersCollector.phoneData = phoneDataArray[i3];
                    phoneCallstacksNumbersCollectorArray[i3] = phoneCallstacksNumbersCollector;
                }
                PhoneUtil.updateSelectedContactData(adbEntry, this);
                break;
            }
            case 1073742843: {
                ASLPhoneData.getInstance().isCallstacksInverted = eventGeneric.getBoolean(0);
                TargetASLPhoneCallStacks.writeBooleanToDatapool(1215, ASLPhoneData.getInstance().isCallstacksInverted);
                this.getPrimary().revertCallstacks(ASLPhoneData.getInstance().isCallstacksInverted);
                break;
            }
            case 1073742781: {
                this.getPrimary().resetMissedCallIndicator();
                break;
            }
            case 3600015: {
                this.updateAllLists();
                break;
            }
        }
    }

    private void updateMixedCalls() {
        ArrayList arrayList = PhoneUtil.sortCallStacks(this.dialedEntries, this.missedEntries, this.answeredEntries);
        ListManager.getGenericASLList(1173).updateList(arrayList.toArray(new PhoneCallstacksCallstacksCollector[arrayList.size()]));
        TargetASLPhoneCallStacks.writeBooleanToDatapool(1213, ASLPhoneData.getInstance().callStackDownloadSupported);
        TargetASLPhoneCallStacks.writeBooleanToDatapool(1176, true);
        this.updateMixed(arrayList);
    }

    private void updateAllLists() {
        try {
            int n;
            Object[] objectArray = (PhoneCallstacksCallstacksCollector[])ListManager.getGenericASLList(1170).getDSIObjects();
            for (n = objectArray.length - 1; n >= 0; --n) {
                PhoneUtil.checkForKnownNumber(objectArray[n]);
            }
            ListManager.getGenericASLList(1170).updateList(objectArray);
            this.updateAccepted((PhoneCallstacksCallstacksCollector[])objectArray);
            objectArray = (PhoneCallstacksCallstacksCollector[])ListManager.getGenericASLList(1171).getDSIObjects();
            for (n = objectArray.length - 1; n >= 0; --n) {
                PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[n]);
            }
            ListManager.getGenericASLList(1171).updateList(objectArray);
            this.updateDialed((PhoneCallstacksCallstacksCollector[])objectArray);
            objectArray = (PhoneCallstacksCallstacksCollector[])ListManager.getGenericASLList(1172).getDSIObjects();
            for (n = objectArray.length - 1; n >= 0; --n) {
                PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[n]);
            }
            ListManager.getGenericASLList(1172).updateList(objectArray);
            this.updateMissed((PhoneCallstacksCallstacksCollector[])objectArray);
            this.updateMixedCalls();
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    public void dsiMobileEquipmentUpdateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
        Object[] objectArray = new PhoneCallstacksCallstacksCollector[callStackEntryArray.length];
        for (int i2 = callStackEntryArray.length - 1; i2 >= 0; --i2) {
            objectArray[i2] = new PhoneCallstacksCallstacksCollector();
            ((PhoneCallstacksCallstacksCollector)objectArray[i2]).callListEntry = callStackEntryArray[i2];
            ((PhoneCallstacksCallstacksCollector)objectArray[i2]).entryType = PhoneUtil.convertEntryTypeDSI2ASLCallType(callStackEntryArray[i2].clEntryType);
            PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[i2]);
        }
        ListManager.getGenericASLList(1170).updateList(objectArray);
        this.updateAccepted((PhoneCallstacksCallstacksCollector[])objectArray);
        this.updateMixedCalls();
    }

    public void dsiMobileEquipmentUpdateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        int n2;
        Object[] objectArray = new PhoneCallstacksCallstacksCollector[callStackEntryArray.length];
        for (n2 = callStackEntryArray.length - 1; n2 >= 0; --n2) {
            objectArray[n2] = new PhoneCallstacksCallstacksCollector();
            ((PhoneCallstacksCallstacksCollector)objectArray[n2]).callListEntry = callStackEntryArray[n2];
            ((PhoneCallstacksCallstacksCollector)objectArray[n2]).entryType = PhoneUtil.convertEntryTypeDSI2ASLCallType(callStackEntryArray[n2].clEntryType);
            PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[n2]);
        }
        ListManager.getGenericASLList(1171).updateList(objectArray);
        this.updateDialed((PhoneCallstacksCallstacksCollector[])objectArray);
        this.updateMixedCalls();
        if (callStackEntryArray.length > 0) {
            n2 = !ASLPhoneData.getInstance().isCallstacksInverted ? 0 : callStackEntryArray.length - 1;
            if (!Util.isNullOrEmpty(callStackEntryArray[n2].getClNumber())) {
                PhoneCallDialLastDialedNumberInformationsCollector phoneCallDialLastDialedNumberInformationsCollector = new PhoneCallDialLastDialedNumberInformationsCollector();
                phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_combined_number_type = PhoneUtil.convertPhoneTypeDSI2ASLCombined(callStackEntryArray[n2].getAdbNumberType());
                phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_contact_entry_id = callStackEntryArray[n2].getAdbEntryID();
                phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_contact_name = !Util.isNullOrEmpty(callStackEntryArray[n2].getClName()) ? callStackEntryArray[n2].getClName() : "";
                phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_number__1 = !Util.isNullOrEmpty(callStackEntryArray[n2].getClNumber()) ? callStackEntryArray[n2].getClNumber() : "";
                ListManager.getGenericASLList(2565).updateList(new PhoneCallDialLastDialedNumberInformationsCollector[]{phoneCallDialLastDialedNumberInformationsCollector});
            }
        } else {
            PhoneCallDialLastDialedNumberInformationsCollector phoneCallDialLastDialedNumberInformationsCollector = new PhoneCallDialLastDialedNumberInformationsCollector();
            phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_combined_number_type = 0;
            phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_contact_entry_id = 0L;
            phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_contact_name = "";
            phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_number__1 = "";
            ListManager.getGenericASLList(2565).updateList(new PhoneCallDialLastDialedNumberInformationsCollector[]{phoneCallDialLastDialedNumberInformationsCollector});
        }
    }

    public void dsiMobileEquipmentUpdateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
        TargetASLPhoneCallStacks.writeIntegerToDatapool(1174, missedCallIndicator.missedCallCount);
    }

    public void dsiMobileEquipmentUpdateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        Object[] objectArray = new PhoneCallstacksCallstacksCollector[callStackEntryArray.length];
        for (int i2 = callStackEntryArray.length - 1; i2 >= 0; --i2) {
            objectArray[i2] = new PhoneCallstacksCallstacksCollector();
            ((PhoneCallstacksCallstacksCollector)objectArray[i2]).callListEntry = callStackEntryArray[i2];
            ((PhoneCallstacksCallstacksCollector)objectArray[i2]).entryType = PhoneUtil.convertEntryTypeDSI2ASLCallType(callStackEntryArray[i2].clEntryType);
            PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[i2]);
        }
        ListManager.getGenericASLList(1172).updateList(objectArray);
        this.updateMissed((PhoneCallstacksCallstacksCollector[])objectArray);
        this.updateMixedCalls();
    }

    public void dsiMobileEquipmentUpdateIsReverted(boolean bl, int n) {
        ASLPhoneData.getInstance().isCallstacksInverted = bl;
        TargetASLPhoneCallStacks.writeBooleanToDatapool(1215, ASLPhoneData.getInstance().isCallstacksInverted);
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        return (DSIMobileEquipmentListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = TargetASLPhoneCallStacks.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener);
    }

    private ArrayList convertToServiceEntries(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            arrayList2.add(new CallstackEntryImpl((PhoneCallstacksCallstacksCollector)arrayList.get(i2)));
        }
        return arrayList2;
    }

    @Override
    public void registerCallstackUpdates(CallstackUpdates callstackUpdates) {
        callstackUpdates = (CallstackUpdates)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(callstackUpdates);
        this.listeners.add(callstackUpdates);
        if (this.acceptedServiceEntries != null) {
            callstackUpdates.onUpdateAccepted(this.acceptedServiceEntries);
        }
        if (this.dialedServiceEntries != null) {
            callstackUpdates.onUpdateDialed(this.dialedServiceEntries);
        }
        if (this.missedServiceEntries != null) {
            callstackUpdates.onUpdateMissed(this.missedServiceEntries);
        }
        if (this.mixedServiceEntries != null) {
            callstackUpdates.onUpdateMixed(this.mixedServiceEntries);
        }
    }

    private void updateAccepted(PhoneCallstacksCallstacksCollector[] phoneCallstacksCallstacksCollectorArray) {
        this.answeredEntries.clear();
        this.answeredEntries.addAll(Arrays.asList(phoneCallstacksCallstacksCollectorArray));
        this.acceptedServiceEntries = this.convertToServiceEntries(this.answeredEntries);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((CallstackUpdates)this.listeners.get(i2)).onUpdateAccepted(this.acceptedServiceEntries);
        }
    }

    private void updateDialed(PhoneCallstacksCallstacksCollector[] phoneCallstacksCallstacksCollectorArray) {
        this.dialedEntries.clear();
        this.dialedEntries.addAll(Arrays.asList(phoneCallstacksCallstacksCollectorArray));
        this.dialedServiceEntries = this.convertToServiceEntries(this.dialedEntries);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((CallstackUpdates)this.listeners.get(i2)).onUpdateDialed(this.dialedServiceEntries);
        }
    }

    private void updateMissed(PhoneCallstacksCallstacksCollector[] phoneCallstacksCallstacksCollectorArray) {
        this.missedEntries.clear();
        this.missedEntries.addAll(Arrays.asList(phoneCallstacksCallstacksCollectorArray));
        this.missedServiceEntries = this.convertToServiceEntries(this.missedEntries);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((CallstackUpdates)this.listeners.get(i2)).onUpdateMissed(this.missedServiceEntries);
        }
    }

    private void updateMixed(ArrayList arrayList) {
        this.mixedServiceEntries = this.convertToServiceEntries(arrayList);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((CallstackUpdates)this.listeners.get(i2)).onUpdateMixed(this.mixedServiceEntries);
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
}

