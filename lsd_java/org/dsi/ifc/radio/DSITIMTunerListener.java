/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public interface DSITIMTunerListener
extends DSIListener {
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
}

