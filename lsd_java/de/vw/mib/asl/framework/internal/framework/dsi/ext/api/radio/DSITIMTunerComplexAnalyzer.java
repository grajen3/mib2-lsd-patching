/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.radio;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.radio.DSITIMTunerListener;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public final class DSITIMTunerComplexAnalyzer
extends ComplexAnalyzer
implements DSITIMTunerListener {
    @Override
    public void playback(int n) {
        if (n == 2 || n == 3 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void updateTIMAvailable(int n, int n2) {
    }

    @Override
    public void updateTIMMemoUsage(TIMMemoUsage tIMMemoUsage, int n) {
    }

    @Override
    public void updateTIMMessageList(TIMMessage[] tIMMessageArray, int n) {
    }

    @Override
    public void updateTIMStatus(TIMStatus tIMStatus, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }
}

