/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;

public interface ASIHMISyncRadioS {
    default public void selectStation(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void selectBand(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void seekStation(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void enableStationDetails(boolean bl, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void setNotification(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void setNotification(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void clearNotification(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void clearNotification(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
    }
}

