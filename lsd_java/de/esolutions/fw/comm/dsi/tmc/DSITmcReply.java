/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public interface DSITmcReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateEventsOnRoute(long l, int n) {
    }

    default public void updateEventsTotal(int n, long l, long l2, int n2) {
    }

    default public void updateTmcState(int n, int n2) {
    }

    default public void updateActiveTrafficSources(int[] nArray, int n) {
    }

    default public void updateIsEngineeringMode(boolean bl, int n) {
    }

    default public void updateCurrentLanguage(String string, int n) {
    }

    default public void updateIsTmcProAvailable(boolean bl, int n) {
    }

    default public void windowChange(int n) {
    }

    default public void tmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
    }

    default public void setMessageFilterResult(int n, int n2) {
    }

    default public void getMessageIdsForListElementResult(long[] lArray) {
    }

    default public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
    }

    default public void updateAreaWarning(AreaWarningInfo areaWarningInfo, int n) {
    }

    default public void updateAreaWarnings(AreaWarningInfo[] areaWarningInfoArray, int n) {
    }

    default public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray, int n) {
    }

    default public void updateTrafficFlowStatisticsStatus(boolean bl, int n) {
    }

    default public void updateTrafficSourceInformation(TrafficSource[] trafficSourceArray, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

