/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.util.ExtLogger;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Field;

public class ExtLoggerImpl
implements ExtLogger {
    private static final boolean LOG_TARGET_NAME;
    private boolean LOG_PREFIX = false;
    private final AbstractTarget target;
    private final String msgPrefix;
    private final int classifier;
    private Hsm hsm;
    private HsmState handlingState;
    private boolean traceDetails;
    private Logger mibLogger;

    private LogMessage prepareLogMessage(LogMessage logMessage) {
        if (this.LOG_PREFIX && this.msgPrefix != null) {
            logMessage.append(this.msgPrefix);
        }
        if (this.hsm != null) {
            logMessage.append(this.hsm.getName());
            HsmState hsmState = this.hsm.getState();
            if (hsmState != null) {
                logMessage.append("(");
                if (hsmState == this.handlingState) {
                    logMessage.append("H=");
                    logMessage.append(hsmState.getName());
                } else if (hsmState != this.handlingState) {
                    if (this.handlingState != null) {
                        logMessage.append(hsmState.getName());
                        logMessage.append("/H=");
                        logMessage.append(this.handlingState.getName());
                    } else {
                        logMessage.append(hsmState.getName());
                        logMessage.append("/");
                        logMessage.append("callback");
                    }
                }
                logMessage.append(") ");
            } else {
                logMessage.append("(nostate)");
            }
        }
        return logMessage;
    }

    private void traceConstruction() {
        String string;
        int n = 16384;
        String string2 = string = this.traceDetails ? "ENABLED" : "disabled";
        if (this.mibLogger.isTraceEnabled(16384)) {
            String string3 = this.mibLogger.isTraceEnabled(this.classifier) ? "ENABLED" : "disabled";
            this.mibLogger.trace(16384).append("speller: detail tracing ").append(string).log();
            this.mibLogger.trace(16384).append("speller: tracing of classifier ").append(this.classifier).append(" ").append(string3).log();
        }
    }

    public ExtLoggerImpl(AbstractTarget abstractTarget, Hsm hsm) {
        this.target = abstractTarget;
        this.hsm = hsm;
        this.classifier = abstractTarget.getClassifier();
        this.msgPrefix = null;
        this.handlingState = null;
        this.mibLogger = ServiceManager.logger;
        this.traceDetails = System.getProperty("NavLogDetails") != null;
        this.traceConstruction();
    }

    public ExtLoggerImpl(int n, String string, boolean bl) {
        this.LOG_PREFIX = true;
        this.msgPrefix = new StringBuilder(string).append(" ").toString();
        this.classifier = n;
        this.target = null;
        this.hsm = null;
        this.mibLogger = bl ? ServiceManager.logger2 : ServiceManager.logger;
        this.traceDetails = System.getProperty("NavLogDetails") != null;
        this.traceConstruction();
    }

    public ExtLoggerImpl(int n, String string) {
        this.LOG_PREFIX = true;
        this.msgPrefix = new StringBuilder(string).append(" ").toString();
        this.classifier = n;
        this.target = null;
        this.hsm = null;
        this.handlingState = null;
        this.mibLogger = ServiceManager.logger;
        this.traceDetails = System.getProperty("NavLogDetails") != null;
        this.traceConstruction();
    }

    public void removeHsm() {
        this.hsm = null;
    }

    @Override
    public void setHandlingState(HsmState hsmState) {
        this.handlingState = hsmState;
    }

    @Override
    public void removeHandlingState() {
        this.handlingState = null;
    }

    @Override
    public boolean traceEnabled(int n) {
        boolean bl = this.mibLogger.isTraceEnabled(this.classifier);
        return bl;
    }

    @Override
    public LogMessage makeError() {
        LogMessage logMessage = this.mibLogger.error(this.classifier);
        return this.prepareLogMessage(logMessage);
    }

    @Override
    public LogMessage makeWarn() {
        LogMessage logMessage = this.mibLogger.warn(this.classifier);
        return this.prepareLogMessage(logMessage);
    }

    @Override
    public LogMessage makeTrace() {
        LogMessage logMessage = this.mibLogger.trace(this.classifier);
        return this.prepareLogMessage(logMessage);
    }

    @Override
    public void trace(String string) {
        if (!this.isTraceEnabled()) {
            return;
        }
        LogMessage logMessage = this.makeTrace();
        logMessage.append(string);
        logMessage.log();
    }

    @Override
    public void info(String string) {
        LogMessage logMessage = this.makeInfo();
        logMessage.append(string);
        logMessage.log();
    }

    @Override
    public void warn(String string) {
        LogMessage logMessage = this.makeWarn();
        logMessage.append(string);
        logMessage.log();
    }

    @Override
    public void error(String string) {
        LogMessage logMessage = this.makeError();
        logMessage.append(string);
        logMessage.log();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.mibLogger.isTraceEnabled(this.classifier);
    }

    @Override
    public LogMessage makeInfo() {
        LogMessage logMessage = this.mibLogger.info(this.classifier);
        return this.prepareLogMessage(logMessage);
    }

    public void traceObjectAttributes(int n, Object object) {
        if (this.traceEnabled(n)) {
            Field[] fieldArray = object.getClass().getFields();
            LogMessage logMessage = this.makeInfo();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                try {
                    logMessage.append(fieldArray[i2].getName());
                    logMessage.append("=");
                    Object object2 = fieldArray[i2].get(object);
                    if (object2 != null) {
                        logMessage.append(object2.toString());
                    } else {
                        logMessage.append("null");
                    }
                    logMessage.append("; ");
                    continue;
                }
                catch (Exception exception) {
                    logMessage.append(exception.toString());
                }
            }
            logMessage.log();
        }
    }
}

