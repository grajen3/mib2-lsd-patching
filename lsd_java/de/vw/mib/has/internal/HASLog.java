/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.has.HASListControl;
import de.vw.mib.has.HASListProperty;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;

final class HASLog {
    private static ClassifiedLogger clogger;

    private HASLog() {
    }

    static void init(ClassifiedLogger classifiedLogger) {
        clogger = classifiedLogger;
    }

    static boolean isTraceEnabled() {
        return null != clogger && clogger.isTraceEnabled();
    }

    static LogMessage trace() {
        return HASLog.isTraceEnabled() ? clogger.trace() : null;
    }

    static LogMessage info() {
        return null != clogger ? clogger.info() : null;
    }

    static LogMessage warn() {
        return null != clogger ? clogger.warn() : null;
    }

    static LogMessage error() {
        return null != clogger ? clogger.error() : null;
    }

    static LogMessage appendPrefixAndMethod(LogMessage logMessage, String string, String string2, boolean bl) {
        logMessage.append(string).append("#").append(string2);
        if (bl) {
            logMessage.append(": ");
        }
        return logMessage;
    }

    static LogMessage appendIntProperty(LogMessage logMessage, String string, int n, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        return logMessage.append(string).append("=").append(n);
    }

    static LogMessage appendStringProperty(LogMessage logMessage, String string, String string2, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        return logMessage.append(string).append("=\"").append(string2).append("\"");
    }

    static LogMessage appendBooleanProperty(LogMessage logMessage, String string, boolean bl, boolean bl2) {
        if (bl2) {
            logMessage.append(", ");
        }
        return logMessage.append(string).append("=").append(String.valueOf(bl));
    }

    static LogMessage appendActionId(LogMessage logMessage, int n, boolean bl) {
        return HASLog.appendIntProperty(logMessage, "actionId", n, bl);
    }

    static LogMessage appendCallId(LogMessage logMessage, int n, boolean bl) {
        return HASLog.appendIntProperty(logMessage, "callId", n, bl);
    }

    static LogMessage appendContainerId(LogMessage logMessage, int n, boolean bl) {
        return HASLog.appendIntProperty(logMessage, "containerId", n, bl);
    }

    static LogMessage appendElementId(LogMessage logMessage, int n, boolean bl) {
        return HASLog.appendIntProperty(logMessage, "elementId", n, bl);
    }

    static LogMessage appendPropertyId(LogMessage logMessage, int n, boolean bl) {
        return HASLog.appendIntProperty(logMessage, "propertyId", n, bl);
    }

    static LogMessage appendRequestId(LogMessage logMessage, int n, boolean bl) {
        return HASLog.appendIntProperty(logMessage, "requestId", n, bl);
    }

    static LogMessage appendHASInvocation(LogMessage logMessage, HASInvocation hASInvocation, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        logMessage.append("invocation=[");
        HASLog.appendRequestId(logMessage, hASInvocation.getRequestId(), false);
        HASLog.appendHASContext(logMessage, hASInvocation.getContext(), true);
        HASLog.appendActionId(logMessage, hASInvocation.getActionId(), true);
        HASLog.appendStringProperty(logMessage, "resultCode", HASLog.resultCodeToString(hASInvocation.getResultCode()), true);
        HASLog.appendStringProperty(logMessage, "state", HASLog.invocationStateToString(hASInvocation.getState()), true);
        logMessage.append("]");
        return logMessage;
    }

    static LogMessage appendHASContext(LogMessage logMessage, HASContext hASContext, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        if (null == hASContext) {
            logMessage.append("context=null");
        } else {
            logMessage.append("context=[");
            HASLog.appendStringProperty(logMessage, "name", hASContext.getContextName(), false);
            HASLog.appendStringProperty(logMessage, "ready", String.valueOf(hASContext.isContextReady()), true);
            logMessage.append("]");
        }
        return logMessage;
    }

    static LogMessage appendHASList(LogMessage logMessage, HASListControl hASListControl, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        HASListProperty hASListProperty = hASListControl.getListProperty();
        logMessage.append("list=[");
        HASLog.appendIntProperty(logMessage, "listId", hASListProperty.getListId(), false);
        HASLog.appendIntProperty(logMessage, "size", hASListControl.getStrategy().getSize(), true);
        HASLog.appendIntProperty(logMessage, "state", hASListProperty.getState(), true);
        logMessage.append("]");
        return logMessage;
    }

    static String resultCodeToString(int n) {
        String string;
        switch (n) {
            case -3: {
                string = "TIMED_OUT";
                break;
            }
            case -2: {
                string = "NOT_IMPLEMENTED";
                break;
            }
            case -1: {
                string = "NOT_READY";
                break;
            }
            case 0: {
                string = "OK";
                break;
            }
            case 1: {
                string = "ERROR";
                break;
            }
            case 2: {
                string = "NOT_ALLOWED";
                break;
            }
            default: {
                string = new StringBuffer().append("unknown(").append(String.valueOf(n)).append(")").toString();
            }
        }
        return string;
    }

    static String invocationStateToString(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "EXECUTE_ACTION";
                break;
            }
            case 1: {
                string = "SEND_RESULT";
                break;
            }
            case 2: {
                string = "DROP";
                break;
            }
            default: {
                string = "?unknown";
            }
        }
        return string;
    }
}

