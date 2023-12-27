/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public interface DSITIMTunerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateTIMMessageList(TIMMessage[] tIMMessageArray, int n) {
    }

    default public void updateTIMStatus(TIMStatus tIMStatus, int n) {
    }

    default public void updateTIMMemoUsage(TIMMemoUsage tIMMemoUsage, int n) {
    }

    default public void updateTIMAvailable(int n, int n2) {
    }

    default public void playback(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

