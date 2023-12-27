/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterTextEntry;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public class TeleprompterDataManagerLogger {
    public static final String LOGGER_PRE_PREFIX;
    public static final int CLASSIFIER;
    private static Logger logger;
    private int loggerClassifier;
    private String loggerPrefix;

    public static void setStaticLogger(Logger logger) {
        TeleprompterDataManagerLogger.logger = logger;
    }

    public TeleprompterDataManagerLogger(int n, String string) {
        this.loggerClassifier = n;
        this.loggerPrefix = new StringBuffer().append("[[TDM]]").append(string).toString();
    }

    public TeleprompterDataManagerLogger(String string) {
        this(512, string);
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled(this.loggerClassifier);
    }

    public void trace(String string) {
        if (!logger.isTraceEnabled(this.loggerClassifier)) {
            return;
        }
        LogMessage logMessage = logger.trace(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public void error(String string) {
        LogMessage logMessage = logger.error(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public void warn(String string) {
        LogMessage logMessage = logger.warn(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public void info(String string) {
        LogMessage logMessage = logger.info(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public LogMessage trace() {
        LogMessage logMessage = logger.trace(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    public LogMessage info() {
        LogMessage logMessage = logger.info(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    public LogMessage warn() {
        LogMessage logMessage = logger.warn(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    public void logTeleprompterData(TeleprompterData teleprompterData) {
        if (!this.isTraceEnabled()) {
            return;
        }
        this.trace("*******   TeleprompterData   ******");
        if (teleprompterData == null) {
            this.trace("NULL");
        } else {
            StringBuffer stringBuffer = new StringBuffer("Type     : ");
            int n = teleprompterData.getTeleprompterType();
            switch (n) {
                case 2: {
                    stringBuffer.append("Main Menu");
                    break;
                }
                case 4: {
                    stringBuffer.append("Use Case");
                    break;
                }
                case 3: {
                    stringBuffer.append("Topic");
                    break;
                }
                case 5: {
                    stringBuffer.append("Dialog");
                    break;
                }
                case 1: {
                    stringBuffer.append("Idle / Not Active");
                    break;
                }
                default: {
                    stringBuffer.append("Unknown");
                }
            }
            stringBuffer.append("[");
            stringBuffer.append(n);
            stringBuffer.append("]");
            this.trace(stringBuffer.toString());
            stringBuffer = new StringBuffer("Headline : ");
            if (teleprompterData.getHeadlineTitle() == null) {
                stringBuffer.append("null");
            } else {
                stringBuffer.append(teleprompterData.getHeadlineTitle().getText());
            }
            this.trace(stringBuffer.toString());
            stringBuffer = new StringBuffer("Examples : ");
            List list = teleprompterData.getCommandExamples();
            if (list == null) {
                stringBuffer.append("null");
            } else {
                stringBuffer.append("[");
                String string = "";
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    TeleprompterTextEntry teleprompterTextEntry = (TeleprompterTextEntry)list.get(i2);
                    stringBuffer.append(string);
                    if (teleprompterTextEntry == null) {
                        stringBuffer.append("null");
                    } else {
                        stringBuffer.append("\"");
                        stringBuffer.append(teleprompterTextEntry.getText());
                        stringBuffer.append("\"");
                    }
                    string = ", ";
                }
                stringBuffer.append("]");
            }
            this.trace(stringBuffer.toString());
        }
        this.trace("***********************************");
    }

    static {
        logger = null;
    }
}

