/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.factoryReset;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.vicsetc.PersistenceDefaults;
import de.vw.mib.asl.internal.vicsetc.datapool.ASLVicsEtcDatapool;
import de.vw.mib.genericevents.EventGeneric;

public class VicsEtcFactoryReset
extends AbstractFactoryResetParticipant {
    private final ASLVicsEtcDatapool vicsEtcDP = ASLVicsEtcDatapool.getInstance();

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.info(16, "Resetting VicsEtc to factory settings");
        }
        this.writeDefaultValuesToPersistence();
        factoryResetCallback.notifyResetDone();
    }

    private void writeDefaultValuesToPersistence() {
        this.vicsEtcDP.setEtcCardNotInsertedChecked(PersistenceDefaults.isEtcCardNotInsertedChecked());
        this.vicsEtcDP.setEtcCardReminderChecked(PersistenceDefaults.isEtcCardReminderChecked());
        this.vicsEtcDP.setTollFeeAnnouncementChecked(PersistenceDefaults.isTollFeeAnnouncementChecked());
        this.vicsEtcDP.setTollFeePopupChecked(PersistenceDefaults.isTollFeePopupChecked());
        this.vicsEtcDP.setDataUploadChecked(PersistenceDefaults.isDataUploadChecked());
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(1686861824);
        eventGeneric.setBoolean(0, this.vicsEtcDP.isDataUploadChecked());
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        this.vicsEtcDP.setPopupDurationTime(PersistenceDefaults.getPopupDurationTime());
        this.vicsEtcDP.setPopupEtcDrivingSupportChecked(PersistenceDefaults.isPopupEtcDrivingSupportChecked());
        this.vicsEtcDP.setPopupEtcTrafficAnnouncementChecked(PersistenceDefaults.isPopupEtcTrafficAnnouncementChecked());
        this.vicsEtcDP.setPopupEtcTrafficInformationChecked(PersistenceDefaults.isPopupEtcTrafficInformationChecked());
        this.vicsEtcDP.setPrefectureString(PersistenceDefaults.getDefaultPrefectureString());
        this.vicsEtcDP.setStationSelectMode(PersistenceDefaults.getStationSelectMode());
        EventGeneric eventGeneric2 = ServiceManager.eventMain.getEventFactory().newEvent(1670084608);
        eventGeneric2.setInt(0, this.vicsEtcDP.getStationSelectMode());
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric2);
        this.vicsEtcDP.setVicsBeaconGraphicsChecked(PersistenceDefaults.isVicsBeaconGraphicsChecked());
        this.vicsEtcDP.setVicsBeaconMessageChecked(PersistenceDefaults.isVicsBeaconMessagesChecked());
        this.vicsEtcDP.setVicsEventNoticeMapChecked(PersistenceDefaults.isVicsEventNoticeMapChecked());
    }
}

