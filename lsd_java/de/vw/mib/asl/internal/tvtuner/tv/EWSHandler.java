/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.tv;

import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerEWSMessageCollector;
import java.util.ArrayList;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.Time;

public class EWSHandler {
    private ArrayList ewsInfoList = new ArrayList();

    public void updateEWSInfoList(EWSInfo[] eWSInfoArray) {
        if (TVTunerObjectAccessor.getTvTunerSettings().isShowEWSMessages()) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("EWSHandler#updateEWSInfoList called - show ews option - activated");
            }
            if (eWSInfoArray == null || eWSInfoArray.length == 0) {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("EWSHandler#updateEWSInfoList called - list is null or empty - do nothing");
                }
                return;
            }
            if (this.ewsInfoList.size() > 0) {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace(new StringBuffer().append("EWSHandler#updateEWSInfoList called - there are still ").append(this.ewsInfoList.size()).append(" ews messages").toString());
                    TVTunerHelper.trace(new StringBuffer().append("EWSHandler#updateEWSInfoList - append ").append(eWSInfoArray.length).append(" new message(s) to list").toString());
                }
                this.addEWSToList(eWSInfoArray);
            } else {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace(new StringBuffer().append("EWSHandler#updateEWSInfoList called - ").append(eWSInfoArray.length).append(" message(s) arrived").toString());
                }
                this.addEWSToList(eWSInfoArray);
                this.showFirstEWSMessage();
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("EWSHandler#updateEWSInfoList called - show ews option - deactivated");
        }
    }

    private void addEWSToList(EWSInfo[] eWSInfoArray) {
        for (int i2 = 0; i2 < eWSInfoArray.length; ++i2) {
            this.ewsInfoList.add(eWSInfoArray[i2]);
        }
    }

    private void showFirstEWSMessage() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("EWSHandler#showFirstEWSMessage called ");
        }
        if (this.ewsInfoList.size() > 0) {
            this.showEWSMessage((EWSInfo)this.ewsInfoList.get(0));
        }
    }

    public void lastEWSMessageClosed() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("EWSHandler#lastEWSMessageClosed called - user canceled last ews msg");
        }
        if (this.ewsInfoList.size() > 0) {
            this.deleteFirstEWSMessage();
            if (this.ewsInfoList.size() > 0) {
                this.showEWSMessage((EWSInfo)this.ewsInfoList.get(0));
            }
        }
    }

    private void deleteFirstEWSMessage() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("EWSHandler#deleteFirstEWSMessage() called");
            if (this.ewsInfoList.size() == 1) {
                TVTunerHelper.trace("EWSHandler#deleteFirstEWSMessage() - no more ews msgs available");
            } else {
                TVTunerHelper.trace(new StringBuffer().append("EWSHandler#deleteFirstEWSMessage() - still ").append(this.ewsInfoList.size()).append(" ews msg(s) available").toString());
            }
        }
        this.ewsInfoList.remove(0);
    }

    private void showEWSMessage(EWSInfo eWSInfo) {
        Time time;
        Time time2;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("EWSHandler#showEWSMessage called set msg to hmi: ").append(eWSInfo.toString()).toString());
        }
        TVTunerEWSMessageCollector tVTunerEWSMessageCollector = new TVTunerEWSMessageCollector();
        String string = TVTunerObjectAccessor.getStationListHandler().getStationName(eWSInfo.getNamePID(), eWSInfo.getServicePID());
        if (string != null) {
            tVTunerEWSMessageCollector.tvtuner_ews_message_station_name = string;
        }
        if ((time2 = eWSInfo.getWarningTime()) != null && !eWSInfo.getWarningTime().equals(new Time(99, 99, 99))) {
            tVTunerEWSMessageCollector.tvtuner_ews_message_warning_time_hour = TVTunerHelper.convertBcdToInt(time2.getHour());
            tVTunerEWSMessageCollector.tvtuner_ews_message_warning_time_minute = TVTunerHelper.convertBcdToInt(time2.getMinute());
        }
        if ((time = eWSInfo.getReceivingTime()) != null && !eWSInfo.getReceivingTime().equals(new Time(99, 99, 99))) {
            tVTunerEWSMessageCollector.tvtuner_ews_message_issuance_time_hour = TVTunerHelper.convertBcdToInt(time.getHour());
            tVTunerEWSMessageCollector.tvtuner_ews_message_issuance_time_minute = TVTunerHelper.convertBcdToInt(time.getMinute());
        }
        tVTunerEWSMessageCollector.tvtuner_ews_message_type = eWSInfo.getWarningType();
        tVTunerEWSMessageCollector.tvtuner_ews_message_affected_area = eWSInfo.getAffectedArea();
        tVTunerEWSMessageCollector.tvtuner_ews_message_warning_prio = eWSInfo.getWarningPrio();
        tVTunerEWSMessageCollector.tvtuner_ews_message_source_classification = eWSInfo.getWarningSrcClass();
        tVTunerEWSMessageCollector.tvtuner_ews_message_country_of_origin = eWSInfo.getOriginCountry();
        tVTunerEWSMessageCollector.tvtuner_ews_message_short_message_text = eWSInfo.getMessageText();
        ListManager.getGenericASLList(3231).updateListItem(0, tVTunerEWSMessageCollector);
        String[] stringArray = eWSInfo.getAreaCodeListNames();
        if (stringArray != null) {
            ListManager.getGenericASLList(-1236523520).updateList(EWSHandler.parseCodes(stringArray));
        } else {
            ListManager.getGenericASLList(-1236523520).updateList(new String[0]);
        }
        TVTunerObjectAccessor.getTargetTVTuner().sendHMIEvent(484);
    }

    public static String[] parseCodes(String[] stringArray) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            int n = 0;
            int n2 = 1;
            for (int i3 = stringArray[i2].length() - 1; i3 >= 0; --i3) {
                if (stringArray[i2].charAt(i3) == '1') {
                    n += n2;
                }
                n2 = (short)(n2 * 2);
            }
            stringArray[i2] = String.valueOf(n);
        }
        return stringArray;
    }
}

