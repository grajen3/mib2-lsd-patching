/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.commands;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.Util;
import java.text.DecimalFormat;
import java.util.Arrays;

public class CommandTracer {
    private static final Logger DEFAULT_COMMAND_LOGGER = ServiceManager.logger;
    private static final int DEFAULT_COMMAND_CLASSIFIER;
    private CommandTracer mParentTracer;
    private Logger mLogger;
    private int mClassifier;
    private static final boolean USE_DEPTH_LINES;
    private static final DecimalFormat STEP_NUMBER_FORMAT;
    private final AbstractCommand mCommand;

    public CommandTracer(AbstractCommand abstractCommand) {
        this.mCommand = abstractCommand;
        this.mLogger = DEFAULT_COMMAND_LOGGER;
        this.mClassifier = 8;
        this.mParentTracer = null;
    }

    public CommandTracer(AbstractCommand abstractCommand, Logger logger, int n) {
        this.mCommand = abstractCommand;
        this.mLogger = logger;
        this.mClassifier = n;
        this.mParentTracer = null;
    }

    public void setParentTracer(CommandTracer commandTracer) {
        this.mParentTracer = commandTracer;
    }

    public void setLogger(Logger logger, int n) {
        this.mLogger = logger;
        this.mClassifier = n;
    }

    public Logger getLogger() {
        if (this.mParentTracer == null) {
            return this.mLogger;
        }
        Logger logger = this.mParentTracer.getLogger();
        int n = this.mParentTracer.getClassifier();
        if (logger == DEFAULT_COMMAND_LOGGER && n == 8) {
            return this.mLogger;
        }
        return logger;
    }

    public int getClassifier() {
        if (this.mParentTracer == null) {
            return this.mClassifier;
        }
        Logger logger = this.mParentTracer.getLogger();
        int n = this.mParentTracer.getClassifier();
        if (logger == DEFAULT_COMMAND_LOGGER && n == 8) {
            return this.mClassifier;
        }
        return n;
    }

    protected boolean isTraceEnabled() {
        return this.getLogger().isTraceEnabled(this.getClassifier());
    }

    private void trace(String string) {
        this.getLogger().trace(this.getClassifier(), new StringBuffer().append(this.getLoggingPrefix()).append(string).toString());
    }

    private void warn(String string) {
        this.getLogger().warn(this.getClassifier(), new StringBuffer().append(this.getLoggingPrefix()).append(string).toString());
    }

    private void error(String string) {
        this.getLogger().error(this.getClassifier(), new StringBuffer().append(this.getLoggingPrefix()).append(string).toString());
    }

    private void info(String string) {
        this.getLogger().info(this.getClassifier(), new StringBuffer().append(this.getLoggingPrefix()).append(string).toString());
    }

    private String getLoggingPrefix() {
        long l = this.mCommand.getSequenceNumber();
        int n = this.mCommand.getExecutionDepth();
        String string = "";
        char[] cArray = new char[n * 5];
        Arrays.fill(cArray, ' ');
        if (this.isTraceEnabled()) {
            for (int i2 = 0; i2 < n; ++i2) {
                cArray[i2 * 5 + 1] = 124;
            }
        }
        string = new String(cArray);
        String string2 = this.mCommand.getCommandNameShort();
        return new StringBuffer().append(string2).append(" - CMD #").append(l).append(" ").append(string).toString();
    }

    private String getHeadlineFormat(String string, String string2) {
        String string3 = "";
        if (!Util.isNullOrEmpty(string2)) {
            string3 = new StringBuffer().append(": ").append(string2).toString();
        }
        return new StringBuffer().append(" |----| ").append(string).append(string3).toString();
    }

    private String getOptionalDetails(String string) {
        String string2 = "";
        if (!Util.isNullOrEmpty(string)) {
            string2 = new StringBuffer().append(" [").append(string).append("]").toString();
        }
        return string2;
    }

    private String getStepStr(int n, boolean bl, boolean bl2) {
        String string;
        String string2 = "";
        if (bl) {
            string2 = STEP_NUMBER_FORMAT.format(n);
        }
        if (bl2 && !Util.isNullOrEmpty(string = this.mCommand.getStepStr(n))) {
            if (bl) {
                string2 = new StringBuffer().append(string2).append("_").toString();
            }
            string2 = new StringBuffer().append(string2).append(string).toString();
        }
        return string2;
    }

    protected void logStart() {
        if (this.isTraceEnabled()) {
            this.trace(this.getHeadlineFormat("START", this.mCommand.getCommandStr(false, false, true, true)));
        }
    }

    protected void logSuccess(int n, String string) {
        if (this.isTraceEnabled()) {
            this.trace(this.getHeadlineFormat("ENDED", new StringBuffer().append("SUCCESS").append(this.getOptionalDetails(string)).toString()));
        }
    }

    protected void logFailed(int n, String string) {
        if (this.isTraceEnabled()) {
            this.error(this.getHeadlineFormat("ENDED", new StringBuffer().append("FAILED in step ").append(this.getStepStr(n, true, false)).append(this.getOptionalDetails(string)).toString()));
        } else {
            this.error(new StringBuffer().append("ERROR IN:  ").append(this.mCommand.getCommandStr(false, false, true, false)).toString());
            this.error(new StringBuffer().append("           FAILED in step ").append(this.getStepStr(n, true, true)).append(this.getOptionalDetails(string)).toString());
        }
    }

    public void logAborted(int n, boolean bl, String string, boolean bl2) {
        if (bl2) {
            if (this.isTraceEnabled()) {
                this.warn(new StringBuffer().append("ABORTED prior to execution: ").append(this.mCommand.getCommandStr(false, false, true, false)).append(this.getOptionalDetails(string)).toString());
            }
        } else {
            this.warn(this.getHeadlineFormat("ENDED", new StringBuffer().append("ABORTED").append(bl ? " after step " : " during step ").append(this.getStepStr(n, true, false)).append(this.getOptionalDetails(string)).toString()));
        }
    }

    protected void logTimeout(int n, int n2) {
        String string = new StringBuffer().append("timeout = ").append(n2).append(" ms").toString();
        if (this.isTraceEnabled()) {
            this.error(this.getHeadlineFormat("ENDED", new StringBuffer().append("TIMEOUT in step ").append(this.getStepStr(n, true, false)).append(this.getOptionalDetails(string)).toString()));
        } else {
            this.error(new StringBuffer().append("ERROR IN:  ").append(this.mCommand.getCommandStr(false, false, true, false)).toString());
            this.error(new StringBuffer().append("           TIMEOUT in step ").append(this.getStepStr(n, true, true)).append(this.getOptionalDetails(string)).toString());
        }
    }

    protected void logStep(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            String string = "| ";
            if (n == n2) {
                string = "> ";
            } else if (n == n3) {
                string = "< ";
            }
            String string2 = " |";
            this.trace(new StringBuffer().append(" ").append(string).append(this.getStepStr(n, true, false)).append(string2).append(" ").append(this.getStepStr(n, false, true)).toString());
        }
    }

    private String getAdditionalInfoFormat(String string) {
        return new StringBuffer().append(" |    |  ").append(string).toString();
    }

    protected void logTrace(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.trace(this.getAdditionalInfoFormat(string));
        }
    }

    protected void logInfo(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (this.isTraceEnabled()) {
                this.info(this.getAdditionalInfoFormat(string));
            } else {
                this.info(string);
            }
        }
    }

    protected void logWarning(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (this.isTraceEnabled()) {
                this.warn(this.getAdditionalInfoFormat(string));
            } else {
                this.warn(string);
            }
        }
    }

    protected void logError(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (this.isTraceEnabled()) {
                this.error(this.getAdditionalInfoFormat(string));
            } else {
                this.error(string);
            }
        }
    }

    protected void logError(Exception exception) {
        if (exception != null) {
            this.getLogger().error(this.getClassifier()).attachThrowable(exception).log();
        }
    }

    static {
        STEP_NUMBER_FORMAT = new DecimalFormat("00");
    }
}

