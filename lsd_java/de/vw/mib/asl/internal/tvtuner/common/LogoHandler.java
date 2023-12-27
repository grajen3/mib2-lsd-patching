/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.LogoInfo;

public class LogoHandler {
    private LogoInfo[] logoList = null;

    public void updateLogoList(LogoInfo[] logoInfoArray) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("LogoHandler#updateLogoList called");
        }
        this.logoList = logoInfoArray;
    }

    public ResourceLocator getStationLogo(long l) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("LogoHandler#getStationLogo called - namePID = ").append(l).toString());
        }
        if (this.logoList != null) {
            for (int i2 = 0; i2 < this.logoList.length; ++i2) {
                if (l != this.logoList[i2].getNamePID()) continue;
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace(new StringBuffer().append("LogoHandler#getStationLogo - stationLogo = ").append(this.logoList[i2].getChannelLogo().getUrl()).toString());
                }
                return this.logoList[i2].getChannelLogo();
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("LogoHandler#getStationLogo - no stationLogo for namePID ").append(l).append(" found - return null").toString());
        }
        return null;
    }
}

