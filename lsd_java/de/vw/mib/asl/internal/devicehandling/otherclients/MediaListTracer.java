/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling.otherclients;

import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.MediumState;
import de.vw.mib.asl.api.devicehandling.clients.MediumChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.log4mib.LogMessage;

public class MediaListTracer
extends MediumChangeListener {
    @Override
    protected void onChange(Medium medium) {
        int n;
        int n2 = medium.getPreviousInfo().getMediaType();
        if (n2 != (n = medium.getCurrentInfo().getMediaType()) || !StringUtil.equals(medium.getPreviousInfo().getUniqueMediaID(), medium.getCurrentInfo().getUniqueMediaID())) {
            ServiceManager.logger.info(128).append(medium.getParent().toString()).append('/').append(medium.getPartitionIndex()).append(": DeviceID=").append(medium.getCurrentInfo().getDeviceID()).append(" MediaID=").append(medium.getPreviousInfo().getMediaID()).append("->").append(medium.getCurrentInfo().getMediaID()).append(" MEDIATYPE change from ").append(MediumState.getMediaTypeStr(n2)).append("  to  ").append(MediumState.getMediaTypeStr(n)).append(" ,  uniqueMediaId ").append(medium.getPreviousInfo().getUniqueMediaID()).append("->").append(medium.getCurrentInfo().getUniqueMediaID()).log();
        }
        int n3 = medium.getPreviousInfo().getFlags();
        int n4 = medium.getCurrentInfo().getFlags();
        if (ServiceManager.logger.isTraceEnabled(1024) && n3 != n4) {
            LogMessage logMessage = ServiceManager.logger.trace(1024).append(medium).append(" flag changes. 0x").append(Integer.toHexString(n3)).append(" to 0x").append(Integer.toHexString(n4));
            this.append(logMessage, " added ", n4 & ~n3);
            this.append(logMessage, " removed ", ~n4 & n3);
            logMessage.log();
        }
    }

    private void append(LogMessage logMessage, String string, int n) {
        if (n != 0) {
            logMessage.append(string).append(MediumState.getMediaFlagsStr(n));
        }
    }
}

