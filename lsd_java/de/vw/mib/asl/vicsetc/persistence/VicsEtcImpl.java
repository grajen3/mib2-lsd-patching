/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.vicsetc.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.vicsetc.persistence.VicsEtc;

class VicsEtcImpl
extends AbstractPersistable
implements VicsEtc {
    private final PersistenceModule module;
    private int popupDurationTime;
    private String prefectureString;
    private int stationSelectMode;
    private boolean dataUploadChecked;
    private boolean etcCardNotInsertedChecked;
    private boolean etcCardReminderChecked;
    private boolean popupEtcDrivingSupportChecked;
    private boolean popupEtcTrafficAnnouncementChecked;
    private boolean popupEtcTrafficInformationChecked;
    private boolean tollFeeAnnouncementChecked;
    private boolean tollFeePopupChecked;
    private boolean vicsEventNoticeMapChecked;
    private boolean vicsBeaconMessagesChecked;
    private boolean vicsBeaconGraphicsChecked;
    private boolean shortcutMessageChecked;
    private String shortcutMessageValue;

    VicsEtcImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public int getPopupDurationTime() {
        return this.popupDurationTime;
    }

    @Override
    public void setPopupDurationTime(int n) {
        this.popupDurationTime = n;
        this.markDirty();
    }

    @Override
    public String getPrefectureString() {
        return this.prefectureString;
    }

    @Override
    public void setPrefectureString(String string) {
        this.prefectureString = string;
        this.markDirty();
    }

    @Override
    public int getStationSelectMode() {
        return this.stationSelectMode;
    }

    @Override
    public void setStationSelectMode(int n) {
        this.stationSelectMode = n;
        this.markDirty();
    }

    @Override
    public boolean isDataUploadChecked() {
        return this.dataUploadChecked;
    }

    @Override
    public void setDataUploadChecked(boolean bl) {
        this.dataUploadChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isEtcCardNotInsertedChecked() {
        return this.etcCardNotInsertedChecked;
    }

    @Override
    public void setEtcCardNotInsertedChecked(boolean bl) {
        this.etcCardNotInsertedChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isEtcCardReminderChecked() {
        return this.etcCardReminderChecked;
    }

    @Override
    public void setEtcCardReminderChecked(boolean bl) {
        this.etcCardReminderChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isPopupEtcDrivingSupportChecked() {
        return this.popupEtcDrivingSupportChecked;
    }

    @Override
    public void setPopupEtcDrivingSupportChecked(boolean bl) {
        this.popupEtcDrivingSupportChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isPopupEtcTrafficAnnouncementChecked() {
        return this.popupEtcTrafficAnnouncementChecked;
    }

    @Override
    public void setPopupEtcTrafficAnnouncementChecked(boolean bl) {
        this.popupEtcTrafficAnnouncementChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isPopupEtcTrafficInformationChecked() {
        return this.popupEtcTrafficInformationChecked;
    }

    @Override
    public void setPopupEtcTrafficInformationChecked(boolean bl) {
        this.popupEtcTrafficInformationChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isTollFeeAnnouncementChecked() {
        return this.tollFeeAnnouncementChecked;
    }

    @Override
    public void setTollFeeAnnouncementChecked(boolean bl) {
        this.tollFeeAnnouncementChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isTollFeePopupChecked() {
        return this.tollFeePopupChecked;
    }

    @Override
    public void setTollFeePopupChecked(boolean bl) {
        this.tollFeePopupChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isVicsEventNoticeMapChecked() {
        return this.vicsEventNoticeMapChecked;
    }

    @Override
    public void setVicsEventNoticeMapChecked(boolean bl) {
        this.vicsEventNoticeMapChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isVicsBeaconMessagesChecked() {
        return this.vicsBeaconMessagesChecked;
    }

    @Override
    public void setVicsBeaconMessagesChecked(boolean bl) {
        this.vicsBeaconMessagesChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isVicsBeaconGraphicsChecked() {
        return this.vicsBeaconGraphicsChecked;
    }

    @Override
    public void setVicsBeaconGraphicsChecked(boolean bl) {
        this.vicsBeaconGraphicsChecked = bl;
        this.markDirty();
    }

    @Override
    public boolean isShortcutMessageChecked() {
        return this.shortcutMessageChecked;
    }

    @Override
    public void setShortcutMessageChecked(boolean bl) {
        this.shortcutMessageChecked = bl;
        this.markDirty();
    }

    @Override
    public String getShortcutMessageValue() {
        return this.shortcutMessageValue;
    }

    @Override
    public void setShortcutMessageValue(String string) {
        this.shortcutMessageValue = string;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

