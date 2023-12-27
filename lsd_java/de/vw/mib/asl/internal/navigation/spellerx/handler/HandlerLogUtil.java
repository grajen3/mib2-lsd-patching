/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;

public class HandlerLogUtil {
    public void logTrace(String string, String string2) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384).append(string).append(string2).log();
        }
    }

    public void logTraceWLocation(String string, String string2, NavLocation navLocation) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append(string).append(string2);
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
    }
}

