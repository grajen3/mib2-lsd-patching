/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.datapool;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.vicsetc.datapool.ASLVicsEtcDatapoolBooleanWrapper;
import de.vw.mib.asl.vicsetc.persistence.VicsEtc;
import de.vw.mib.asl.vicsetc.persistence.VicsEtcPersistenceServiceImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupSetupVicsStationInformationCollector;

public final class ASLVicsEtcDatapool {
    private static ASLVicsEtcDatapool instance = new ASLVicsEtcDatapool();
    private final VicsEtc vicsEtcPersistence = VicsEtcPersistenceServiceImpl.getInstance().loadVicsEtc();
    private String prefectureInfoString = "";
    private String frequencyInfoString = "";
    private int vicsReceptionState = 0;
    private boolean isTrafficOnline;

    public static ASLVicsEtcDatapool getInstance() {
        return instance;
    }

    private ASLVicsEtcDatapool() {
    }

    public String getPrefectureString() {
        return this.vicsEtcPersistence.getPrefectureString();
    }

    public int getPopupDurationTime() {
        return this.vicsEtcPersistence.getPopupDurationTime();
    }

    public int getStationSelectMode() {
        return this.vicsEtcPersistence.getStationSelectMode();
    }

    public boolean isDataUploadChecked() {
        return this.vicsEtcPersistence.isDataUploadChecked();
    }

    public boolean isEtcCardNotInsertedChecked() {
        return this.vicsEtcPersistence.isEtcCardNotInsertedChecked();
    }

    public boolean isEtcCardReminderChecked() {
        return this.vicsEtcPersistence.isEtcCardReminderChecked();
    }

    public boolean isPopupEtcDrivingSupportChecked() {
        return this.vicsEtcPersistence.isPopupEtcDrivingSupportChecked();
    }

    public boolean isPopupEtcTrafficAnnouncementChecked() {
        return this.vicsEtcPersistence.isPopupEtcTrafficAnnouncementChecked();
    }

    public boolean isPopupEtcTrafficInformationChecked() {
        return this.vicsEtcPersistence.isPopupEtcTrafficInformationChecked();
    }

    public boolean isTollFeeAnnouncementChecked() {
        return this.vicsEtcPersistence.isTollFeeAnnouncementChecked();
    }

    public boolean isTollFeePopupChecked() {
        return this.vicsEtcPersistence.isTollFeePopupChecked();
    }

    public boolean isVicsEventNoticeMapChecked() {
        return this.vicsEtcPersistence.isVicsEventNoticeMapChecked();
    }

    public boolean isVicsBeaconMessageChecked() {
        return this.vicsEtcPersistence.isVicsBeaconMessagesChecked();
    }

    public boolean isVicsBeaconGraphicsChecked() {
        return this.vicsEtcPersistence.isVicsBeaconGraphicsChecked();
    }

    public boolean isShortcutMessageChecked() {
        return this.vicsEtcPersistence.isShortcutMessageChecked();
    }

    public String getShortcutMessageValue() {
        return this.vicsEtcPersistence.getShortcutMessageValue();
    }

    public static void setInstance(ASLVicsEtcDatapool aSLVicsEtcDatapool) {
        instance = aSLVicsEtcDatapool;
    }

    public void setPrefectureString(String string) {
        this.vicsEtcPersistence.setPrefectureString(string);
    }

    public void setPopupDurationTime(int n) {
        this.vicsEtcPersistence.setPopupDurationTime(n);
        ServiceManager.aslPropertyManager.valueChangedInteger(1436177664, n);
    }

    public void setStationSelectMode(int n) {
        this.vicsEtcPersistence.setStationSelectMode(n);
        this.updateVicsSetupReceptionInformationInGuideModel();
    }

    public void setDataUploadChecked(boolean bl) {
        this.vicsEtcPersistence.setDataUploadChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isDataUploadChecked(), 395990272, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setEtcCardNotInsertedChecked(boolean bl) {
        this.vicsEtcPersistence.setEtcCardNotInsertedChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isEtcCardNotInsertedChecked(), 446321920, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setEtcCardReminderChecked(boolean bl) {
        this.vicsEtcPersistence.setEtcCardReminderChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isEtcCardReminderChecked(), 463099136, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setPopupEtcDrivingSupportChecked(boolean bl) {
        this.vicsEtcPersistence.setPopupEtcDrivingSupportChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isPopupEtcDrivingSupportChecked(), 748311808, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setPopupEtcTrafficAnnouncementChecked(boolean bl) {
        this.vicsEtcPersistence.setPopupEtcTrafficAnnouncementChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isPopupEtcTrafficAnnouncementChecked(), 781866240, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setPopupEtcTrafficInformationChecked(boolean bl) {
        this.vicsEtcPersistence.setPopupEtcTrafficInformationChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isPopupEtcTrafficInformationChecked(), 765089024, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setTollFeeAnnouncementChecked(boolean bl) {
        this.vicsEtcPersistence.setTollFeeAnnouncementChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isTollFeeAnnouncementChecked(), 429544704, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setTollFeePopupChecked(boolean bl) {
        this.vicsEtcPersistence.setTollFeePopupChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isTollFeePopupChecked(), 412767488, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setVicsEventNoticeMapChecked(boolean bl) {
        this.vicsEtcPersistence.setVicsEventNoticeMapChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isVicsEventNoticeMapChecked(), 379213056, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setVicsBeaconMessageChecked(boolean bl) {
        this.vicsEtcPersistence.setVicsBeaconMessagesChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isVicsBeaconMessageChecked(), 714757376, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setVicsBeaconGraphicsChecked(boolean bl) {
        this.vicsEtcPersistence.setVicsBeaconGraphicsChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isVicsBeaconGraphicsChecked(), 731534592, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setTrafficOnline(boolean bl) {
        this.isTrafficOnline = bl;
        this.updateVicsSetupReceptionInformationInGuideModel();
    }

    public boolean getTrafficOnline() {
        return this.isTrafficOnline;
    }

    public void setPrefectureInfoString(String string) {
        this.prefectureInfoString = string;
        this.updateVicsSetupReceptionInformationInGuideModel();
    }

    public void setFrequencyInfoString(String string) {
        this.frequencyInfoString = string;
        this.updateVicsSetupReceptionInformationInGuideModel();
    }

    public void setReceptionStatus(int n) {
        this.vicsReceptionState = n;
        this.updateVicsSetupReceptionInformationInGuideModel();
    }

    public void setShortcutMessageChecked(boolean bl) {
        this.vicsEtcPersistence.setShortcutMessageChecked(bl);
        ASLVicsEtcDatapoolBooleanWrapper aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isShortcutMessageChecked(), 899306752, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
        aSLVicsEtcDatapoolBooleanWrapper = new ASLVicsEtcDatapoolBooleanWrapper(this.isShortcutMessageChecked(), 647648512, true, false);
        aSLVicsEtcDatapoolBooleanWrapper.writeToASLDatapool();
    }

    public void setShortcutMessageValue(String string) {
        this.vicsEtcPersistence.setShortcutMessageValue(string);
    }

    private void updateVicsSetupReceptionInformationInGuideModel() {
        Object[] objectArray = new VICSETCSetupSetupVicsStationInformationCollector[]{new VICSETCSetupSetupVicsStationInformationCollector()};
        objectArray[0].vicsetc_setup_setup_vics_station_information_selected_prefecture = this.prefectureInfoString;
        objectArray[0].vicsetc_setup_setup_vics_station_information_received_frequency = this.frequencyInfoString;
        objectArray[0].vicsetc_setup_setup_vics_station_information_online_vics_status = this.isTrafficOnline ? 0 : 1;
        objectArray[0].vicsetc_setup_setup_vics_station_information_reception_mode = this.getStationSelectMode();
        objectArray[0].vicsetc_setup_setup_vics_station_information_reception_status = this.vicsReceptionState;
        ListManager.getGenericASLList(798643456).updateList(objectArray);
    }

    public void initASLDatapool() {
        this.setEtcCardNotInsertedChecked(this.isEtcCardNotInsertedChecked());
        this.setEtcCardReminderChecked(this.isEtcCardReminderChecked());
        this.setTollFeeAnnouncementChecked(this.isTollFeeAnnouncementChecked());
        this.setTollFeePopupChecked(this.isTollFeePopupChecked());
        this.setVicsEventNoticeMapChecked(this.isVicsEventNoticeMapChecked());
        this.setDataUploadChecked(this.isDataUploadChecked());
        this.setPopupDurationTime(this.getPopupDurationTime());
        this.setPopupEtcDrivingSupportChecked(this.isPopupEtcDrivingSupportChecked());
        this.setPopupEtcTrafficAnnouncementChecked(this.isPopupEtcTrafficAnnouncementChecked());
        this.setPopupEtcTrafficInformationChecked(this.isPopupEtcTrafficInformationChecked());
        this.setPrefectureString(this.getPrefectureString());
        this.setStationSelectMode(this.getStationSelectMode());
        this.setVicsBeaconGraphicsChecked(this.isVicsBeaconGraphicsChecked());
        this.setVicsBeaconMessageChecked(this.isVicsBeaconMessageChecked());
        this.setShortcutMessageChecked(this.isShortcutMessageChecked());
        this.setShortcutMessageValue(this.getShortcutMessageValue());
    }
}

