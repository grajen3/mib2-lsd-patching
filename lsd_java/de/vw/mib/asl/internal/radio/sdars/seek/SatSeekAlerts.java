/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.internal.radio.sat.transformer.AlertCollector;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekModel;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.TrafficApi;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATAlertInfoCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.StationInfo;

final class SatSeekAlerts {
    private final SatDb mDb;
    private final IAslPool mPool;
    private final SatSeekModel mModel;
    private final Vector mSeekAlerts;
    private int mChannelNoInAlertPopup;

    SatSeekAlerts(SatDb satDb, SatSeekModel satSeekModel) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mModel = satSeekModel;
        this.mSeekAlerts = new Vector(20);
    }

    void appendAlert(SeekAlert seekAlert) {
        StationInfo stationInfo;
        Object object;
        if (TrafficApi.jumpCancelled || this.mDb.getTrafficApi().notifyStartSeekAlert(seekAlert)) {
            // empty if block
        }
        Iterator iterator = this.mSeekAlerts.iterator();
        while (iterator.hasNext()) {
            object = (SeekAlert)iterator.next();
            if (((SeekAlert)object).sID != seekAlert.sID) continue;
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("alert is ignored, since").append("alertInList.sID =").append(((SeekAlert)object).sID).append("aAlertToAppend.sID =").append(seekAlert.sID).log();
            }
            return;
        }
        object = this.mDb.getChannels();
        if (null != object && null != (stationInfo = ((ChannelListFromSouth)object).getChannelBySID(seekAlert.sID)) && null != this.mSeekAlerts && this.mDb.isChannelAvailableInChannelList(stationInfo)) {
            this.mSeekAlerts.add(seekAlert);
        }
        if (this.mPool.getBoolean(152)) {
            this.updateAlertPopup(seekAlert);
        }
        this.updateAlertList();
    }

    void removeAlert(SeekAlert seekAlert) {
        if (this.mDb.getTrafficApi().notifyStopSeekAlert(seekAlert)) {
            Iterator iterator = this.mSeekAlerts.iterator();
            while (iterator.hasNext()) {
                SeekAlert seekAlert2 = (SeekAlert)iterator.next();
                if (seekAlert2.seekID != seekAlert.seekID || seekAlert.sID != 0 && seekAlert2.sID != seekAlert.sID) continue;
                iterator.remove();
            }
            return;
        }
        Iterator iterator = this.mSeekAlerts.iterator();
        while (iterator.hasNext()) {
            SeekAlert seekAlert3 = (SeekAlert)iterator.next();
            if (seekAlert3.seekID != seekAlert.seekID || seekAlert.sID != 0 && seekAlert3.sID != seekAlert.sID) continue;
            iterator.remove();
            this.updateAlertList();
        }
    }

    public void updateAlertList() {
        Object object;
        Object object2;
        Object[] objectArray = new AlertCollector[this.mSeekAlerts.size()];
        Vector vector = new Vector(this.mSeekAlerts.size());
        Iterator iterator = this.mSeekAlerts.iterator();
        while (iterator.hasNext()) {
            object2 = (SeekAlert)iterator.next();
            object = this.mDb.getChannels().getChannelBySID(((SeekAlert)object2).getSID());
            if (object == null) continue;
            RadioText radioText = this.mDb.getRadioTextHandler().get(((StationInfo)object).getSID());
            String string = ((StationInfo)object).getFullLabel();
            short s = ((StationInfo)object).getStationNumber();
            ResourceLocator resourceLocator = this.mDb.getImageDb().getImage(((StationInfo)object).sID);
            SeekEntry seekEntry = this.mModel.getSeekEntries().getBySeekID(((SeekAlert)object2).getSeekID());
            if (seekEntry == null) continue;
            switch (seekEntry.typeOfContent) {
                case 1: {
                    AlertCollector alertCollector = radioText != null ? new AlertCollector(string, s, resourceLocator, false, "", "", "", "", radioText.getLongArtistName(), radioText.getLongProgramTitle()) : new AlertCollector(string, s, resourceLocator, false, "", "", "", "", seekEntry.getTitle1(), "");
                    vector.add(alertCollector);
                    break;
                }
                case 2: {
                    AlertCollector alertCollector = new AlertCollector(string, s, resourceLocator, true, "", "", "", "", "", "");
                    vector.add(alertCollector);
                    break;
                }
                case 3: {
                    AlertCollector alertCollector = radioText != null ? new AlertCollector(string, s, resourceLocator, false, "", "", "", "", radioText.getLongArtistName(), radioText.getLongProgramTitle()) : new AlertCollector(string, s, resourceLocator, true, "", "", "", "", seekEntry.getTitle2(), seekEntry.getTitle2());
                    vector.add(alertCollector);
                    break;
                }
                case 4: {
                    AlertCollector alertCollector = new AlertCollector(string, s, resourceLocator, false, "", "", "", "", "", "");
                    vector.add(alertCollector);
                    break;
                }
            }
        }
        objectArray = (AlertCollector[])vector.toArray(objectArray);
        object2 = this.mDb.getModelApi();
        object = new ArrayList();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] == null) continue;
            ((ArrayList)object).add(objectArray[i2]);
        }
        Object[] objectArray2 = (AlertCollector[])((ArrayList)object).toArray(new AlertCollector[((ArrayList)object).size()]);
        if (objectArray2.length != 0) {
            this.mPool.setBoolean(190, true);
        } else {
            this.mPool.setBoolean(190, false);
        }
        ((SatModelApi)object2).updateAlertList((AlertCollector[])objectArray2);
        this.mPool.setObjectArray(211, objectArray2);
        int n = objectArray2.length;
        this.mPool.setInt(200, n);
        if (n <= 0) {
            this.mDb.sendHmiEvent(432415744);
        }
    }

    void tuneAlertByIndex(int n) {
        StationInfo stationInfo;
        int n2;
        AlertCollector[] alertCollectorArray;
        if (n >= 0 && (alertCollectorArray = (AlertCollector[])this.mPool.getObjectArray(211)).length != 0 && (n2 = alertCollectorArray[n].getChannelNumber()) > 0 && (stationInfo = this.mDb.getChannels().getChannel(n2)) != null) {
            this.mDb.getTuneHandler().tuneChannel(15, stationInfo, false);
        }
    }

    private void updateAlertPopup(SeekAlert seekAlert) {
        Object object;
        RadioSATSATAlertInfoCollector[] radioSATSATAlertInfoCollectorArray = null;
        boolean bl = false;
        StationInfo stationInfo = this.mDb.getChannels().getChannelBySID(seekAlert.getSID());
        if (stationInfo != null && stationInfo.stationNumber != this.mPool.getChannel((int)23).stationNumber && this.mDb.isChannelAvailableInChannelList(stationInfo)) {
            object = this.mDb.getRadioTextHandler().get(stationInfo.getSID());
            radioSATSATAlertInfoCollectorArray = new RadioSATSATAlertInfoCollector[]{new RadioSATSATAlertInfoCollector()};
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__album_name = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__artist_name = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__category_name = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__channel_name = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__channel_number = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__logo = null;
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__sport_program = false;
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__team_a = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__team_b = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__title_name = "";
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__channel_name = stationInfo.getFullLabel();
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__channel_number = Integer.toString(stationInfo.getStationNumber());
            radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__logo = this.mDb.getImageDb().getImage(stationInfo.sID);
            SeekEntry seekEntry = this.mModel.getSeekEntries().getBySeekID(seekAlert.getSeekID());
            if (seekEntry != null) {
                this.mChannelNoInAlertPopup = stationInfo.getStationNumber();
                if (seekEntry.getTypeOfContent() == 3) {
                    radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__artist_name = seekEntry.getTitle2();
                } else {
                    radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__artist_name = seekEntry.getTitle1();
                    radioSATSATAlertInfoCollectorArray[0].radio_sat_sat_alert_info__title_name = seekEntry.getTitle2();
                }
                bl = true;
            }
        }
        if (radioSATSATAlertInfoCollectorArray != null && bl) {
            object = this.mDb.getModelApi();
            ((SatModelApi)object).updateAlertInfo(radioSATSATAlertInfoCollectorArray);
            this.mDb.sendHmiEvent(208);
        }
    }

    int getChannelNoInAlertPopup() {
        return this.mChannelNoInAlertPopup;
    }

    public Vector getSeekAlerts() {
        return this.mSeekAlerts;
    }
}

