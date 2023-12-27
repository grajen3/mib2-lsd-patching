/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.high2;

import de.vw.mib.asl.framework.api.diagnosis.config.LoadSpeedThreshold;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class LoadSpeedThresholdImpl
extends AccessImpl
implements LoadSpeedThreshold {
    public LoadSpeedThresholdImpl(byte[] byArray) {
        super(byArray, new int[]{30}, 906042371, 0);
        this.mConfiguration = new int[]{1091, 0, 255, 1, 0, 20051, 8, 0, 0, 30, 3, 20051, 8, 1, 0, 10, -1, 20051, 8, 2, 0, 30, 3, 20051, 8, 3, 0, 10, -1, 20051, 8, 4, 0, 30, 3, 20051, 8, 5, 0, 10, -1, 1091, 0, -65536, 1, 41, 20051, 16, 6, 0, 0, 44, 20051, 16, 8, 0, 0, 44, 20051, 8, 10, 0, 30, 3, 20051, 8, 11, 0, 10, -1, 20051, 8, 12, 0, 30, 3, 20051, 8, 13, 0, 10, -1, 20051, 8, 14, 0, 30, 3, 20051, 8, 15, 0, 10, -1, 20051, 8, 16, 0, 30, 3, 20051, 8, 17, 0, 10, -1, 20051, 8, 18, 0, 30, 3, 20051, 8, 19, 0, 10, -1, 20051, 8, 20, 0, 30, 3, 20051, 8, 21, 0, 10, -1, 20051, 8, 22, 0, 30, 3, 20051, 8, 23, 0, 10, -1, 1091, 0, -16842752, 1, 142, 20051, 16, 24, 0, 0, 145, 58, 128, 128, 602, 106, 595, 64, 588, 17, 128, 128, 603, 112, 596, 70, 589, 23, 128, 128, 604, 118, 597, 76, 590, 29, 128, 128, 605, 124, 598, 82, 591, 35, 128, 128, 606, 130, 599, 88, 592, 46, 128, 128, 607, 136, 600, 94, 593, 52, 586, 5, 608, 147, 601, 100, 594, 58, 587, 11, 153};
        this.mEngine = new Engine(this.mConfiguration);
    }

    @Override
    public boolean isBoardbookCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isBoardbookCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isBroadcastWebsiteCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isBroadcastWebsiteCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isBtBondingCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isBtBondingCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isCarmenuCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isCarmenuCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isDestinationInputCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isDestinationInputCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isMessagingTextEditorCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isMessagingTextEditorCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isRadiotextTooltipCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isRadiotextTooltipCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isRadiotextTooltipDisplayDurationNoLimit(int n) {
        return n == 0;
    }

    @Override
    public boolean isSlideshowCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isSlideshowCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isSlideshowDisplayDuration1NoLimit(int n) {
        return n == 0;
    }

    @Override
    public boolean isSlideshowDisplayDuration1Off(int n) {
        return n == -65536;
    }

    @Override
    public boolean isSlideshowDisplayDuration2NoLimit(int n) {
        return n == 0;
    }

    @Override
    public boolean isSlideshowDisplayDuration2Off(int n) {
        return n == -65536;
    }

    @Override
    public boolean isTravelGuideCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isTravelGuideCutoffThresholdOff(int n) {
        return n == 255;
    }

    @Override
    public boolean isVideoCutoffThresholdAlwaysActive(int n) {
        return n == 254;
    }

    @Override
    public boolean isVideoCutoffThresholdOff(int n) {
        return n == 255;
    }
}

