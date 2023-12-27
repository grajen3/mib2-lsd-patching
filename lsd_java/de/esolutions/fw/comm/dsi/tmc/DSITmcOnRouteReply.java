/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSITmcOnRouteReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
    }

    default public void updateUrgentMessages(TmcMessage[] tmcMessageArray, int n) {
    }

    default public void tmcMessage(TmcMessage tmcMessage) {
    }

    default public void updateTmcMessagesAheadCalculationHorizon(long l, int n) {
    }

    default public void setTmcWarningModeResult(int n) {
    }

    default public void updateCurrentlyBlockedTMCMessages(long[] lArray, int n) {
    }

    default public void blockTMCMessagesResult(long[] lArray, long[] lArray2) {
    }

    default public void unblockTMCMessagesResult(long[] lArray, long[] lArray2) {
    }

    default public void unblockAllTMCMessagesResult(int n) {
    }

    default public void updateNaviCoreAvailableToChangeTMCBlockings(int n, int n2) {
    }

    default public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
    }

    default public void updateSpeedAndFlowAhead(SpeedAndFlowSegment[] speedAndFlowSegmentArray, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

