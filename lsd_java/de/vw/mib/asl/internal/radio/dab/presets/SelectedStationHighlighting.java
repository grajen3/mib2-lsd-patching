/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.dab.DabDatabase;

public class SelectedStationHighlighting {
    private static boolean stationHighlightingIsActive = false;
    private static boolean newMuteStatusAvailable = false;

    public static void setSelectedStationHighlightingIsActive(boolean bl) {
        if (null != DabDatabase.mDabMainTarget) {
            DabDatabase.mDabMainTarget.stopTimer(-1735982848);
            if (bl) {
                GuiApiDab.updateServiceState(0);
                newMuteStatusAvailable = false;
                DabDatabase.mDabMainTarget.startTimer(-1735982848, (long)0, false);
            }
        }
        stationHighlightingIsActive = bl;
    }

    public static boolean getSelectedStationHighlightingIsActive() {
        return stationHighlightingIsActive;
    }

    public static void setNewMuteStatusAvailable(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append(new StringBuffer().append("SelectedStationHighlighting.setNewMuteStatusAvailable: ").append(bl).toString()).log();
        }
        newMuteStatusAvailable = bl;
    }

    public static boolean getNewMuteStatusAvailable() {
        return newMuteStatusAvailable;
    }
}

