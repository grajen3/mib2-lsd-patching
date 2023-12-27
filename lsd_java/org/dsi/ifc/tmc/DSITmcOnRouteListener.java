/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSITmcOnRouteListener
extends DSIListener {
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
}

