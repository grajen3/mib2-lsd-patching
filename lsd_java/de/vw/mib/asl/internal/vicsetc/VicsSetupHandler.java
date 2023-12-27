/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.util.HashMap;
import java.util.Map;

public class VicsSetupHandler {
    protected static final Map PREFECTURE_MAPPING_ID2ISO = VicsSetupHandler.createPrefectureId2IsoMapping();
    private final VicsTarget target;
    protected final GenericASLList prefectureList;

    private static Map createPrefectureId2IsoMapping() {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < 47; ++i2) {
            hashMap.put(Integer.toString(i2), i2 + 1 < 10 ? new StringBuffer().append("JP-0").append(i2 + 1).toString() : new StringBuffer().append("JP-").append(i2 + 1).toString());
        }
        return hashMap;
    }

    public VicsSetupHandler(VicsTarget vicsTarget, GenericASLList genericASLList) {
        this.target = vicsTarget;
        this.prefectureList = genericASLList;
    }

    protected void handleToggleEventNoticeMap() {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.target.vicsEtcDP.setVicsEventNoticeMapChecked(!this.target.vicsEtcDP.isVicsEventNoticeMapChecked());
        this.target.traceMsg("changed event notice map setting.", this);
    }

    protected void handleToggleBeaconMessages() {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.target.vicsEtcDP.setVicsBeaconMessageChecked(!this.target.vicsEtcDP.isVicsBeaconMessageChecked());
        this.target.traceMsg("changed popup beacon messages setting.", this);
    }

    protected void handleToggleBeaconGraphics() {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.target.vicsEtcDP.setVicsBeaconGraphicsChecked(!this.target.vicsEtcDP.isVicsBeaconGraphicsChecked());
        this.target.traceMsg("changed popup beacon graphics setting.", this);
    }

    protected void handleToggleDataUpload() {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.target.setProbeDataSetting(!this.target.vicsEtcDP.isDataUploadChecked());
        this.target.traceMsg("changed data upload setting.", this);
    }

    protected void handleToggleTrafficInformation() {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.target.vicsEtcDP.setPopupEtcTrafficInformationChecked(!this.target.vicsEtcDP.isPopupEtcTrafficInformationChecked());
        this.target.traceMsg("changed popup traffic information setting.", this);
    }

    protected void handleToggleTrafficAnnouncement() {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.target.vicsEtcDP.setPopupEtcTrafficAnnouncementChecked(!this.target.vicsEtcDP.isPopupEtcTrafficAnnouncementChecked());
        this.target.traceMsg("changed popup traffic announcements setting.", this);
    }

    protected void handleToggleDrivingSupport() {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.target.vicsEtcDP.setPopupEtcDrivingSupportChecked(!this.target.vicsEtcDP.isPopupEtcDrivingSupportChecked());
        this.target.traceMsg("changed popup driving support setting.", this);
    }

    protected void handleSetupPrefectureSelect(EventGeneric eventGeneric) {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        int n = eventGeneric.getInt(0);
        boolean bl = this.target.vicsEtcDP.getStationSelectMode() == 0;
        String string = (String)PREFECTURE_MAPPING_ID2ISO.get(Integer.toString(n));
        this.target.vicsEtcDP.setPrefectureString(string);
        this.target.setPrefectureSetting(string, bl);
        this.target.traceMsg(new StringBuffer().append("changed prefecture to: ").append(n).toString(), this);
    }

    protected void handleSetupDurationTimeSelect(EventGeneric eventGeneric) {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        int n = eventGeneric.getInt(0);
        this.target.vicsEtcDP.setPopupDurationTime(n);
        this.target.traceMsg(new StringBuffer().append("changed duration time to: ").append(n).toString(), this);
    }

    protected void handleSetupStationSelect(EventGeneric eventGeneric) {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        int n = eventGeneric.getInt(0);
        this.target.vicsEtcDP.setStationSelectMode(n);
        boolean bl = this.target.vicsEtcDP.getStationSelectMode() == 0;
        String string = "";
        if (!bl) {
            string = this.target.vicsEtcDP.getPrefectureString();
        }
        this.target.setPrefectureSetting(string, bl);
        this.target.traceMsg(new StringBuffer().append("changed selection mode to: ").append(n).toString(), this);
    }
}

