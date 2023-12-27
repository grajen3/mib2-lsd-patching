/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone;

import de.vw.mib.asl.api.media.AlphabeticalScrollBarInfo;
import de.vw.mib.asl.api.phone.PhonePersistence;
import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public interface ASLPhoneAPI {
    public static final int EV_ASL_INT_GET_ENTRY;
    public static final int ASL_PHONE_GET_ENTRY_P0_ENTRYID_LONG;
    public static final int ASL_PHONE_GET_ENTRY_P1_ENTRY_ADBENTRY;
    public static final int EV_ASL_INT_GET_ENTRIES;
    public static final int ASL_PHONE_GET_ENTRIES_P0_ENTRYIDS_LONG_ARRAY;
    public static final int ASL_PHONE_GET_ENTRIES_P1_VIEWTYPE_INT;
    public static final int ASL_PHONE_GET_ENTRIES_P2_LISTMODE_INT;
    public static final int ASL_PHONE_GET_ENTRIES_P3_ENTRIES_ADBENTRY_ARRAY;

    default public AddressData[] ripADBAddressData(AddressData[] addressDataArray) {
    }

    default public int convertPhoneTypeDSI2ASLCombined(int n) {
    }

    default public EventGeneric createSingleEntryEvent(int n, int n2, long l) {
    }

    default public PhoneData[] ripADBPhoneData(PhoneData[] phoneDataArray) {
    }

    default public int getRequestedPhoneAudioConnection() {
    }

    default public int getTelMode() {
    }

    default public int getTelModeNad() {
    }

    default public ActivationStateStruct getActivationStateNad() {
    }

    default public int getLockState() {
    }

    default public int getPhoneFetcherSpellerHandle() {
    }

    default public boolean isCallsActive() {
    }

    default public boolean isToggleOtherPINRequested() {
    }

    default public PhonePersistence getPersistence() {
    }

    default public AlphabeticalScrollBarInfo getDefaultCharacterInfo() {
    }

    default public AlphabeticalScrollBarInfo getCharacterInfos() {
    }

    default public ResourceLocator contactPictureFromSelectedContacts(long l) {
    }

    default public boolean isPhoneReminderPopupRequired() {
    }

    default public PhoneService getPhoneService() {
    }
}

