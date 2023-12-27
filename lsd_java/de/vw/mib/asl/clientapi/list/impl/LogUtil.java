/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.log4mib.LogMessage;

final class LogUtil {
    private LogUtil() {
    }

    static LogMessage appendPrefixAndMethod(LogMessage logMessage, String string, String string2, boolean bl) {
        logMessage.append(string).append("#").append(string2);
        if (bl) {
            logMessage.append(": ");
        }
        return logMessage;
    }

    static LogMessage appendListKey(LogMessage logMessage, Object object) {
        logMessage.append(" (key=").append(String.valueOf(object)).append(")");
        return logMessage;
    }

    static LogMessage appendListConfig(LogMessage logMessage, ASLClientListImpl aSLClientListImpl, boolean bl) {
        return LogUtil.appendListKey(logMessage, aSLClientListImpl.getKey());
    }

    static LogMessage appendCount(LogMessage logMessage, int n, boolean bl) {
        return LogUtil.appendIntProperty(logMessage, "count", n, bl);
    }

    static LogMessage appendIndex(LogMessage logMessage, int n, boolean bl) {
        return LogUtil.appendIntProperty(logMessage, "index", n, bl);
    }

    static LogMessage appendModCount(LogMessage logMessage, int n, boolean bl) {
        return LogUtil.appendIntProperty(logMessage, "modCount", n, bl);
    }

    static LogMessage appendSize(LogMessage logMessage, int n, boolean bl) {
        return LogUtil.appendIntProperty(logMessage, "size", n, bl);
    }

    static LogMessage appendRange(LogMessage logMessage, int n, int n2, boolean bl) {
        if (0 < n2) {
            LogUtil.appendRangeProperty(logMessage, "range", n, n + n2 - 1, bl);
        } else {
            LogUtil.appendIndex(logMessage, n, bl).append(", empty range");
        }
        return logMessage;
    }

    static LogMessage appendString(LogMessage logMessage, String string, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        return logMessage.append(string);
    }

    static LogMessage appendIntProperty(LogMessage logMessage, String string, int n, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        return logMessage.append(string).append("=").append(n);
    }

    static LogMessage appendBooleanProperty(LogMessage logMessage, String string, boolean bl, boolean bl2) {
        if (bl2) {
            logMessage.append(", ");
        }
        return logMessage.append(string).append("=").append(bl);
    }

    static LogMessage appendRangeProperty(LogMessage logMessage, String string, int n, int n2, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        return logMessage.append(string).append("=[").append(n).append("..").append(n2).append("]");
    }
}

