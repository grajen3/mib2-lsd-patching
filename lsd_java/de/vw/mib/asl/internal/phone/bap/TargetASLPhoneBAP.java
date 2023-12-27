/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bap;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bap.BapContactsAdbListFetcher;
import de.vw.mib.asl.internal.phone.bap.LoggerDelegate;
import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.bap.contactsspeller.transformer.PhoneBAPContactsSpellerSpellerResultCollector;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;

public class TargetASLPhoneBAP
extends TripleMobileEquipment
implements LoggerDelegate {
    private static final int[] NOTIFICATIONS = new int[]{47, 48, 49};
    protected DSIAdbList dsiAdbListBAP;
    protected DSIAdbEdit dsiAdbEditBAP;
    private BapContactsAdbListFetcher _contactsFetcher;
    protected DSIListener dsiAdbListListener;
    protected DSIListener dsiAdbEditListener;
    ArrayList answeredEntries = new ArrayList();
    ArrayList dialedEntries = new ArrayList();
    ArrayList missedEntries = new ArrayList();
    private static final int VIEW_WINDOW_INITIAL_SIZE;
    private static final int INVALID_HANDLE;
    int bapSpellerHandle = -1;
    private String currentSpellerChars = "";
    private int numberOfCharactersToRemove = 0;
    private int numberOfCharactersToAdd = 0;
    private boolean spellerOperationCompleted = false;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;

    public TargetASLPhoneBAP(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5272;
    }

    protected void registerObservers() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbListBAP = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLPhoneBAP.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 3);
        this.dsiAdbEditBAP = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetASLPhoneBAP.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 3);
        this.dsiAdbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLPhoneBAP.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        this.dsiAdbEditListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetASLPhoneBAP.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLPhoneBAP.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 3, this.dsiAdbListListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetASLPhoneBAP.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 3, this.dsiAdbEditListener);
        this.dsiAdbListBAP.setNotification(1, this.dsiAdbListListener);
        this.addObserver(1778581568);
        this.addObserver(1761804352);
        this.addObserver(1828913216);
        this.addObserver(1795358784);
        this.addObserver(1812136000);
        this.addObserver(-1056767936);
        this._contactsFetcher = new BapContactsAdbListFetcher(this.dsiAdbListBAP, 1);
        this._contactsFetcher.setLogger(this);
    }

    @Override
    protected void powerOn() {
        this.registerObservers();
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742785: {
                ASLPhoneData.getInstance().localizedUnknownCall = eventGeneric.getString(0);
                ASLPhoneData.getInstance().localizedEmergencyCall = eventGeneric.getString(1);
                ASLPhoneData.getInstance().localizedInfoCall = eventGeneric.getString(2);
                ASLPhoneData.getInstance().localizedServiceCall = eventGeneric.getString(3);
                ASLPhoneData.getInstance().localizedMailboxCall = eventGeneric.getString(6);
                this.updateAllLists();
                break;
            }
            case 1073742698: {
                long l = eventGeneric.getLong(0);
                this.dsiAdbEditBAP.getEntries(new long[]{l}, 1, 0);
                break;
            }
            case 1073742699: {
                this.numberOfCharactersToRemove = 0;
                this.numberOfCharactersToAdd = 0;
                this.currentSpellerChars = "";
                this.spellerOperationCompleted = false;
                this.dsiAdbListBAP.startSpeller(1, 20, 0);
                break;
            }
            case 1073742701: {
                String string = eventGeneric.getString(0);
                if (this.bapSpellerHandle != -1) {
                    if (this.currentSpellerChars.length() != 0) {
                        this.removeSpellerChars(this.currentSpellerChars.length());
                    } else {
                        this.addSpellerChars(string);
                    }
                    this.currentSpellerChars = string;
                    break;
                }
                this.sendHMIEvent(127);
                break;
            }
            case 1073742700: {
                this.numberOfCharactersToRemove = 0;
                this.numberOfCharactersToAdd = 0;
                this.currentSpellerChars = "";
                if (this.bapSpellerHandle != -1) {
                    this.spellerOperationCompleted = false;
                    this.dsiAdbListBAP.stopSpeller(this.bapSpellerHandle);
                    this.bapSpellerHandle = -1;
                    break;
                }
                this.sendHMIEvent(127);
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
        ListManager.getGenericASLList(1107).updateList(arrayList.toArray(new PhoneCallstacksCallstacksCollector[arrayList.size()]));
    }

    public void dsiAdbListInvalidData(int n) {
        this._contactsFetcher.dsiAdbListInvalidData(n);
        this.sendHMIEvent(127);
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this._contactsFetcher.dsiAdbListGetViewWindowResult(n, dataSetArray, n2);
    }

    public void dsiAdbEditGetEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (n == 0 && adbEntryArray.length != 0 && adbEntryArray[0].getPhoneData().length != 0) {
            PhoneData[] phoneDataArray = adbEntryArray[0].getPhoneData();
            int n2 = phoneDataArray.length;
            Object[] objectArray = new AdbEntry[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                AdbEntry adbEntry = new AdbEntry(adbEntryArray[0].entryId, adbEntryArray[0].entryType, adbEntryArray[0].combinedName, adbEntryArray[0].preferredNumberIdx, adbEntryArray[0].voiceTagId, adbEntryArray[0].phoneData, adbEntryArray[0].addressData, adbEntryArray[0].emailData, adbEntryArray[0].urlData, adbEntryArray[0].personalData, "");
                objectArray[i2] = adbEntry;
                ((AdbEntry)objectArray[i2]).phoneData = new PhoneData[]{phoneDataArray[i2]};
                ((AdbEntry)objectArray[i2]).preferredNumberIdx = adbEntryArray[0].preferredNumberIdx == i2 ? 1 : 0;
            }
            ListManager.getGenericASLList(1110).updateList(objectArray);
            this.sendHMIEvent(123);
        }
    }

    private void addSpellerChars(String string) {
        this.numberOfCharactersToRemove = 0;
        this.numberOfCharactersToAdd = string.length();
        this.spellerOperationCompleted = false;
        for (int i2 = 0; i2 < this.numberOfCharactersToAdd; ++i2) {
            this.dsiAdbListBAP.addSpellerChars(this.bapSpellerHandle, new String(new char[]{string.charAt(i2)}));
        }
    }

    private boolean updateAddedSpellerCharacters(int n) {
        if (this.numberOfCharactersToAdd > 0) {
            --this.numberOfCharactersToAdd;
        }
        return this.numberOfCharactersToAdd > 0;
    }

    private void removeSpellerChars(int n) {
        this.numberOfCharactersToAdd = 0;
        this.numberOfCharactersToRemove = n;
        if (this.numberOfCharactersToRemove == 0) {
            this.addSpellerChars(this.currentSpellerChars);
        } else {
            this.spellerOperationCompleted = false;
            this.dsiAdbListBAP.removeSpellerChar(this.bapSpellerHandle);
        }
    }

    private boolean shouldRemoveSpellerChars() {
        return this.numberOfCharactersToRemove > 0;
    }

    public void dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (!this.spellerOperationCompleted) {
            if (n == 0) {
                this.bapSpellerHandle = n2;
                if (this.shouldRemoveSpellerChars()) {
                    this.removeSpellerChars(string2.length());
                } else if (n3 == 1 && string2.toLowerCase().startsWith(this.currentSpellerChars.toLowerCase()) || !this.updateAddedSpellerCharacters(string2.length())) {
                    PhoneBAPContactsSpellerSpellerResultCollector phoneBAPContactsSpellerSpellerResultCollector = new PhoneBAPContactsSpellerSpellerResultCollector();
                    if (!Util.isNullOrEmpty(dataSetArray)) {
                        phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_id_of_first_entry = (int)dataSetArray[0].getEntryId();
                        phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_position_of_first_entry = dataSetArray[0].getEntryPosition();
                    } else {
                        phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_id_of_first_entry = 0L;
                        phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_position_of_first_entry = -1;
                    }
                    phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_number_of_entries = n3;
                    phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_valid_chars = string == null ? "" : string;
                    ListManager.getGenericASLList(1111).updateList(new PhoneBAPContactsSpellerSpellerResultCollector[]{phoneBAPContactsSpellerSpellerResultCollector});
                    this.spellerOperationCompleted = true;
                    this.sendHMIEvent(125);
                }
            } else if (n == 2) {
                if (!this.updateAddedSpellerCharacters(string2.length())) {
                    PhoneBAPContactsSpellerSpellerResultCollector phoneBAPContactsSpellerSpellerResultCollector = new PhoneBAPContactsSpellerSpellerResultCollector();
                    phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_id_of_first_entry = 0L;
                    phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_position_of_first_entry = -1;
                    phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_number_of_entries = n3;
                    phoneBAPContactsSpellerSpellerResultCollector.phone_bap_contactsspeller_valid_chars = string == null ? "" : string;
                    ListManager.getGenericASLList(1111).updateList(new PhoneBAPContactsSpellerSpellerResultCollector[]{phoneBAPContactsSpellerSpellerResultCollector});
                    this.spellerOperationCompleted = true;
                    this.sendHMIEvent(125);
                }
            } else {
                this.spellerOperationCompleted = true;
                this.sendHMIEvent(127);
            }
        }
    }

    public void dsiAdbListStopSpellerResult(int n, int n2) {
        if (n == 0) {
            this.sendHMIEvent(126);
        }
    }

    public void dsiMobileEquipmentUpdateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
        Object[] objectArray = new PhoneCallstacksCallstacksCollector[callStackEntryArray.length];
        for (int i2 = callStackEntryArray.length - 1; i2 >= 0; --i2) {
            objectArray[i2] = new PhoneCallstacksCallstacksCollector();
            ((PhoneCallstacksCallstacksCollector)objectArray[i2]).callListEntry = callStackEntryArray[i2];
            PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[i2]);
        }
        ListManager.getGenericASLList(1106).updateList(objectArray);
        this.answeredEntries.clear();
        this.answeredEntries.addAll(Arrays.asList(objectArray));
        this.updateMixedCalls();
    }

    public void dsiMobileEquipmentUpdateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        Object[] objectArray = new PhoneCallstacksCallstacksCollector[callStackEntryArray.length];
        for (int i2 = callStackEntryArray.length - 1; i2 >= 0; --i2) {
            objectArray[i2] = new PhoneCallstacksCallstacksCollector();
            ((PhoneCallstacksCallstacksCollector)objectArray[i2]).callListEntry = callStackEntryArray[i2];
            PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[i2]);
        }
        ListManager.getGenericASLList(1104).updateList(objectArray);
        this.dialedEntries.clear();
        this.dialedEntries.addAll(Arrays.asList(objectArray));
        this.updateMixedCalls();
    }

    public void dsiMobileEquipmentUpdateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        Object[] objectArray = new PhoneCallstacksCallstacksCollector[callStackEntryArray.length];
        for (int i2 = callStackEntryArray.length - 1; i2 >= 0; --i2) {
            objectArray[i2] = new PhoneCallstacksCallstacksCollector();
            ((PhoneCallstacksCallstacksCollector)objectArray[i2]).callListEntry = callStackEntryArray[i2];
            PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[i2]);
        }
        ListManager.getGenericASLList(1105).updateList(objectArray);
        this.missedEntries.clear();
        this.missedEntries.addAll(Arrays.asList(objectArray));
        this.updateMixedCalls();
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        this._contactsFetcher.dsiAdbListUpdateViewSize(adbViewSize, n);
    }

    private PhoneCallstacksCallstacksCollector[] safeCast(Object[] objectArray) {
        if (objectArray.length != 0) {
            return (PhoneCallstacksCallstacksCollector[])objectArray;
        }
        return new PhoneCallstacksCallstacksCollector[0];
    }

    private void updateAllLists() {
        try {
            int n;
            Object[] objectArray = this.safeCast(ListManager.getGenericASLList(1106).getDSIObjects());
            for (n = objectArray.length - 1; n >= 0; --n) {
                PhoneUtil.checkForKnownNumber(objectArray[n]);
            }
            ListManager.getGenericASLList(1106).updateList(objectArray);
            this.answeredEntries.clear();
            this.answeredEntries.addAll(Arrays.asList(objectArray));
            objectArray = this.safeCast(ListManager.getGenericASLList(1104).getDSIObjects());
            for (n = objectArray.length - 1; n >= 0; --n) {
                PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[n]);
            }
            ListManager.getGenericASLList(1104).updateList(objectArray);
            this.dialedEntries.clear();
            this.dialedEntries.addAll(Arrays.asList(objectArray));
            objectArray = this.safeCast(ListManager.getGenericASLList(1105).getDSIObjects());
            for (n = objectArray.length - 1; n >= 0; --n) {
                PhoneUtil.checkForKnownNumber((PhoneCallstacksCallstacksCollector)objectArray[n]);
            }
            ListManager.getGenericASLList(1105).updateList(objectArray);
            this.missedEntries.clear();
            this.missedEntries.addAll(Arrays.asList(objectArray));
            this.updateMixedCalls();
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    @Override
    public void trace(String string) {
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        return NOTIFICATIONS;
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        return (DSIMobileEquipmentListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = TargetASLPhoneBAP.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener);
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

