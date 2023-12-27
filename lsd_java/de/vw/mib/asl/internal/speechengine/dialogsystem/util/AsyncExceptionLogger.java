/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.util;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class AsyncExceptionLogger {
    public static void logAsyncException(Logger logger, int n, String string, int n2, String string2, int n3) {
        LogMessage logMessage = logger.error(n);
        logMessage.append("[");
        logMessage.append(string);
        logMessage.append("] ");
        logMessage.append("asyncException( errorCode='");
        logMessage.append(n2);
        logMessage.append("', ");
        logMessage.append("requestType='");
        logMessage.append(n3);
        logMessage.append("', ");
        logMessage.append("errorMsg='");
        logMessage.append(string2);
        logMessage.append("' ");
        logMessage.append(" )");
        logMessage.log();
    }
}

