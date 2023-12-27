/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.presets;

import de.vw.mib.asl.api.phone.callback.SpecialNumbersUpdate;
import de.vw.mib.asl.api.phone.model.SpecialNumbers;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.phone.presets.HsmPhonePresetsHandling;
import de.vw.mib.asl.internal.phone.presets.StatePresetHandling$1;
import de.vw.mib.asl.internal.phone.presets.transformer.PhonePresetCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class StatePresetHandling
extends AbstractHsmState
implements SpecialNumbersUpdate {
    private final HsmPhonePresetsHandling target;
    private static int presetCount = 9;
    private String selectedPresetNumber;
    private int selectedPresetNumberType;
    private boolean operationPending = false;
    private boolean sosVisiblity = false;
    private int sosButtonIndex = -1;
    private String emergencyNumber = "";
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$PhoneService;

    private PhonePresetCollector[] createEmptyPresets() {
        PhonePresetCollector[] phonePresetCollectorArray = new PhonePresetCollector[presetCount];
        for (int i2 = 0; i2 < phonePresetCollectorArray.length; ++i2) {
            phonePresetCollectorArray[i2] = new PhonePresetCollector();
            phonePresetCollectorArray[i2].adbEntry = new AdbEntry();
            if (i2 != this.sosButtonIndex) continue;
            phonePresetCollectorArray[i2].sosButtonPreset = this.sosVisiblity && !Util.isNullOrEmpty(this.emergencyNumber);
        }
        return phonePresetCollectorArray;
    }

    public StatePresetHandling(HsmPhonePresetsHandling hsmPhonePresetsHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhonePresetsHandling;
        Object[] objectArray = this.createEmptyPresets();
        ListManager.getGenericASLList(1194).updateList(objectArray);
        ListManager.getGenericASLList(-94214656).updateList(objectArray);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$phone$PhoneService == null ? (class$de$vw$mib$asl$api$phone$PhoneService = StatePresetHandling.class$("de.vw.mib.asl.api.phone.PhoneService")) : class$de$vw$mib$asl$api$phone$PhoneService, new StatePresetHandling$1(this));
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073744707: 
            case 0x40000B44: {
                this.target.spellerPresetNumber.initSpeller("");
                break;
            }
            case 1075141837: {
                boolean bl = eventGeneric.getBoolean(0);
                AbstractASLHsmTarget.writeBooleanToDatapool(1127358464, bl);
                break;
            }
            case 1073742809: 
            case 1080441833: {
                int n = eventGeneric.getInt(0);
                if (n == presetCount) break;
                presetCount = n;
                this.clearPresets();
                this.target.getSpeedDials();
                break;
            }
            case 100302: {
                if (eventGeneric.getResult() != 0) break;
                AdbEntry[] adbEntryArray = (AdbEntry[])eventGeneric.getObject(3);
                this.prepareentries(adbEntryArray);
                break;
            }
            case 1073742808: 
            case 1080441845: {
                this.target.selectedPresetKey = eventGeneric.getInt(0);
                break;
            }
            case 1073742807: {
                int n = eventGeneric.getInt(0);
                PhonePresetCollector phonePresetCollector = (PhonePresetCollector)ListManager.getGenericASLList(1194).getRowItem(n);
                if (phonePresetCollector.sosButtonPreset) {
                    this.target.dsiAdbUserProfile.setSOSButton(false);
                    phonePresetCollector.sosButtonPreset = false;
                    ListManager.getGenericASLList(1194).updateListItem(n, phonePresetCollector);
                    ListManager.getGenericASLList(-94214656).updateListItem(n, phonePresetCollector);
                }
                if (this.operationPending) break;
                this.operationPending = true;
                this.target.dsiAdbEditTelephone.deleteSpeedDial(n);
                break;
            }
            case 1073744362: {
                this.target.dsiAdbEditTelephone.deleteEntries(new long[0], 4, 1);
                break;
            }
            case 1075141863: {
                long l = eventGeneric.getLong(0);
                this.selectedPresetNumber = eventGeneric.getString(1);
                this.selectedPresetNumberType = eventGeneric.getInt(3);
                int n = this.target.selectedPresetKey;
                PhonePresetCollector phonePresetCollector = (PhonePresetCollector)ListManager.getGenericASLList(1194).getRowItem(n);
                if (phonePresetCollector.sosButtonPreset) {
                    this.target.dsiAdbUserProfile.setSOSButton(false);
                    phonePresetCollector.sosButtonPreset = false;
                    ListManager.getGenericASLList(1194).updateListItem(n, phonePresetCollector);
                    ListManager.getGenericASLList(-94214656).updateListItem(n, phonePresetCollector);
                }
                if (l != 0L) {
                    if (this.operationPending) break;
                    this.operationPending = true;
                    this.target.send(PhoneUtil.createSingleEntryEvent(5264, -846790400, l));
                    break;
                }
                this.createNewSpeedDial(this.selectedPresetNumber);
                break;
            }
            case 1075141861: 
            case 1080441832: {
                int n = eventGeneric.getInt(0);
                if (n != this.sosButtonIndex) {
                    this.target.info("emergency call index: ", n);
                }
                this.sosButtonIndex = n;
                if (this.sosButtonIndex >= presetCount) {
                    this.target.warn("emergency call index out of range, resetting to 0: ", this.sosButtonIndex);
                    this.sosButtonIndex = 0;
                }
                this.setSOSButton(this.emergencyNumber);
                break;
            }
            case 100301: {
                if (eventGeneric.getResult() != 0) break;
                AdbEntry adbEntry = (AdbEntry)eventGeneric.getObject(1);
                if (PhoneUtil.ripADBPhoneData(adbEntry.getPhoneData()).length == 1 && adbEntry.getPhoneData()[0].getNumber().equals(this.selectedPresetNumber)) {
                    this.selectedPresetNumberType = adbEntry.getPhoneData()[0].getNumberType();
                }
                this.createAndSetSpeedDialFromAdbEntry(adbEntry);
                break;
            }
            case 3600002: {
                this.clearPresets();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void setSOSButton(String string) {
        if (this.sosButtonIndex > -1) {
            PhonePresetCollector phonePresetCollector = (PhonePresetCollector)ListManager.getGenericASLList(1194).getRowItem(this.sosButtonIndex);
            phonePresetCollector.sosButtonPreset = this.sosVisiblity && !Util.isNullOrEmpty(string);
            ListManager.getGenericASLList(1194).updateListItem(this.sosButtonIndex, phonePresetCollector);
        }
    }

    @Override
    public void onUpdate(SpecialNumbers specialNumbers) {
        this.target.info().append("StatePresetHandling.onUpdate()").append(specialNumbers.getEmergency()).log();
        this.emergencyNumber = specialNumbers.getEmergency();
        this.setSOSButton(this.emergencyNumber);
    }

    private void prepareentries(AdbEntry[] adbEntryArray) {
        AbstractASLHsmTarget.writeBooleanToDatapool(3535, adbEntryArray.length == 0);
        Object[] objectArray = this.createEmptyPresets();
        for (int i2 = 0; i2 < adbEntryArray.length; ++i2) {
            AdbEntry adbEntry = adbEntryArray[i2];
            for (int i3 = 0; i3 < adbEntry.phoneData.length; ++i3) {
                PhoneData phoneData = adbEntry.phoneData[i3];
                if (phoneData.speedDialKey < 0 || phoneData.speedDialKey >= objectArray.length) continue;
                ((PhonePresetCollector)objectArray[phoneData.speedDialKey]).adbEntry = adbEntry;
                ((PhonePresetCollector)objectArray[phoneData.speedDialKey]).phoneDataIdx = i3;
            }
        }
        ListManager.getGenericASLList(1194).updateList(objectArray);
        ListManager.getGenericASLList(-94214656).updateList(objectArray);
        this.operationPending = false;
    }

    private void createAndSetSpeedDialFromAdbEntry(AdbEntry adbEntry) {
        AdbEntry adbEntry2 = new AdbEntry();
        adbEntry2.personalData = new PersonalData();
        adbEntry2.personalData.firstName = adbEntry.getPersonalData().getFirstName();
        adbEntry2.personalData.lastName = adbEntry.getPersonalData().getLastName();
        adbEntry2.personalData.contactPicture = adbEntry.getPersonalData().getContactPicture();
        adbEntry2.phoneData = new PhoneData[]{new PhoneData(this.selectedPresetNumber, this.selectedPresetNumberType, this.target.selectedPresetKey)};
        this.target.setSpeedDial(adbEntry2);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("[PHONE]StatePresetHandling > Stored new entry with params: ").append(new StringBuffer().append("selected preset number: ").append(this.selectedPresetNumber).toString()).append(" , ").append(new StringBuffer().append("selected preset numbertype: ").append(this.selectedPresetNumberType).toString()).append(" , ").append(new StringBuffer().append("selected preset key: ").append(this.target.selectedPresetKey).toString()).log();
        }
    }

    private void createNewSpeedDial(String string) {
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.personalData = new PersonalData();
        adbEntry.personalData.lastName = string;
        adbEntry.phoneData = new PhoneData[]{new PhoneData(string, 0, this.target.selectedPresetKey)};
        this.target.setSpeedDial(adbEntry);
    }

    public void dsiAdbListInvalidData(int n) {
        if (n == 1) {
            this.clearPresets();
        }
        this.target.getSpeedDials();
    }

    public void dsiAdbEditSetSpeedDialResult(int n) {
        this.target.getSpeedDials();
        this.operationPending = false;
    }

    public void dsiAdbEditDeleteSpeedDialResult(int n) {
        this.operationPending = false;
    }

    public void dsiAdbUserProfileUpdateSOSButton(boolean bl, int n) {
        this.sosVisiblity = bl;
        this.target.info().append("StatePresetHandling.dsiAdbUserProfileUpdateSOSButton()").append(bl).log();
        this.setSOSButton(this.emergencyNumber);
    }

    public void dsiAdbUserProfileSetSOSButtonResult(int n) {
        if (n != 0) {
            this.target.warn("Result of SetSOSButtonResult != OK");
        }
    }

    private void clearPresets() {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("Clear the Phone Presets").log();
        }
        Object[] objectArray = this.createEmptyPresets();
        ListManager.getGenericASLList(1194).updateList(objectArray);
        ListManager.getGenericASLList(-94214656).updateList(objectArray);
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

