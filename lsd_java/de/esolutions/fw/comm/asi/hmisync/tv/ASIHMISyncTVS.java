/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;

public interface ASIHMISyncTVS {
    default public void setActiveStation(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void logonToTV(ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void logoffFromTV(ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void sendPressedPanelKey(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void searchChannel(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void setTerminalMode(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void setNotification(ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void setNotification(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void clearNotification(ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void clearNotification(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncTVReply aSIHMISyncTVReply) {
    }
}

