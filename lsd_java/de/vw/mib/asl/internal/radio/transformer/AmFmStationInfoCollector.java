/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.HdStationInfo;

public abstract class AmFmStationInfoCollector
implements Loggable {
    public static final int NO_PTY_GROUP_TITLE;
    private int ptyGroupTitleId = -1;
    public int autocompare;
    public int selectedIndex;
    public boolean hasPresetImage;
    public ResourceLocator imageResourceLocator;
    public AmFmStation station;
    public HdStationInfo hdStation;

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("autocompare: ").append(this.autocompare).append("  selecetd index: ").append(this.selectedIndex);
        logMessage.append("  ASL station: ");
        logMessage = this.station.toLogString(logMessage);
    }

    public LogMessage toLogString(LogMessage logMessage) {
        this.toString(logMessage);
        return logMessage;
    }

    public int getPtyGroupTitleId() {
        return this.ptyGroupTitleId;
    }

    public void setPtyGroupTitleId(int n) {
        this.ptyGroupTitleId = n;
    }
}

