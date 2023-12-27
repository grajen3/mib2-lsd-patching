/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.internal.journal.SmJournalEx;

public final class NumericInfoSmJournal
extends SmJournalEx {
    private static final int INFO;
    private static final int DEBUG;
    private static final String TASK_STARTING;
    private static final String TASK_STARTED;
    private static final String TASK_FINISHING;
    private static final String TASK_FINISHED;
    private static final String TASK_HANDLING;
    private static final String TASK_HANDLED;
    private static final String TASK_ACTING;
    private static final String TASK_ACTED;
    private static final String TASK_PROBLEM;
    private static final String BLOCK_MANAGER;
    private static final String BLOCK_EVENT;
    private static final String BLOCK_STATEMACHINE;
    private static final String BLOCK_SUBSTATEMACHINE;
    private static final String BLOCK_STATE;
    private static final String BLOCK_INTERNAL;
    private static final String BLOCK_TRIGGERED;
    private static final String BLOCK_UNTRIGGERED;
    private static final String ACTION_ENTRY;
    private static final String ACTION_EXIT;
    private static final String ACTION_FOCUS_GAINED;
    private static final String ACTION_FOCUS_LOST;
    private static final String ACTIVATOR;
    private static final String DEACTIVATOR;
    private static final String NO_INFO;
    private final Logger logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);

    @Override
    public void managerStarted() {
        this.log(1, "SM:Started  ", "SMMID=", 0, "");
    }

    @Override
    public void managerFinished() {
        this.log(1, "SM:finished ", "SMMID=", 0, "");
    }

    @Override
    public void eventProcessing(int n, short s) {
        this.log(3, "SM:handled  ", "EID=", n, new StringBuffer().append(s).append("").toString());
    }

    @Override
    public void eventProcessed(int n, boolean bl) {
        this.log(3, "SM:handled  ", "EID=", n, bl ? " consumed" : " not consumed");
    }

    @Override
    public void eventSkipped(int n) {
        this.log(3, "SM:handled  ", "EID=", n, " skipped");
    }

    @Override
    public void eventForwardingToStatemachine(int n, int n2) {
        this.log(1, "SM:handle   ", "EID=", n2, "SMID=", n, " forwarding to SM");
    }

    @Override
    public void checkpoint(char c2) {
    }

    @Override
    public void fatalError(int n, int n2, short s, RuntimeException runtimeException) {
        LogMessage logMessage = this.logger.fatal(1);
        logMessage.append("SM:Problem  ");
        logMessage.append("SMID=");
        logMessage.append(n);
        logMessage.append(" ");
        logMessage.append("SSMID=");
        logMessage.append(n2);
        logMessage.append(" ");
        logMessage.append("SID=");
        logMessage.append(s);
        logMessage.attachThrowable(runtimeException);
        logMessage.log();
    }

    @Override
    public void activatorChecking(int n) {
        this.log(1, "SM:handle   ", "SMID=", n, " Activator");
    }

    @Override
    public void activatorChecked(int n) {
        this.log(1, "SM:handled  ", "SMID=", n, " Activator");
    }

    @Override
    public void deactivatorChecking(int n) {
        this.log(1, "SM:handle   ", "SMID=", n, " Deactivator");
    }

    @Override
    public void deactivatorChecked(int n) {
        this.log(1, "SM:handled  ", "SMID=", n, " Deactivator");
    }

    @Override
    public void statemachineActivating(int n) {
        this.log(1, "SM:start    ", "SMID=", n, "");
    }

    @Override
    public void statemachineActivated(int n) {
        this.log(3, "SM:Started  ", "SMID=", n, "");
    }

    @Override
    public void statemachineDeactivating(int n) {
        this.log(1, "SM:finish   ", "SMID=", n, "");
    }

    @Override
    public void statemachineDeactivated(int n) {
        this.log(3, "SM:finished ", "SMID=", n, "");
    }

    @Override
    public void internalTransitionPerforming(int n, int n2, short s, short s2) {
        this.log(1, "SM:handle   ", "SMID=", n, "SSMID=", n2, "SID=", s, "ITID=", s2);
    }

    @Override
    public void internalTransitionActing(int n, int n2, short s, short s2) {
        this.log(3, "SM:act      ", "SMID=", n, "SSMID=", n2, "SID=", s, "ITID=", s2);
    }

    @Override
    public void internalTransitionActed(int n, int n2, short s, short s2) {
        this.log(3, "SM:acted    ", "SMID=", n, "SSMID=", n2, "SID=", s, "ITID=", s2);
    }

    @Override
    public void internalTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        this.log(3, "SM:handled  ", "SMID=", n, "SSMID=", n2, "SID=", s, "ITID=", s2);
    }

    @Override
    public void triggeredTransitionPerforming(int n, int n2, short s, short s2) {
        this.log(1, "SM:handle   ", "SMID=", n, "SSMID=", n2, "SID=", s, "TTID=", s2);
    }

    @Override
    public void triggeredTransitionActing(int n, int n2, short s, short s2) {
        this.log(3, "SM:act      ", "SMID=", n, "SSMID=", n2, "SID=", s, "TTID=", s2);
    }

    @Override
    public void triggeredTransitionActed(int n, int n2, short s, short s2) {
        this.log(3, "SM:acted    ", "SMID=", n, "SSMID=", n2, "SID=", s, "TTID=", s2);
    }

    @Override
    public void triggeredTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        this.log(3, "SM:handled  ", "SMID=", n, "SSMID=", n2, "SID=", s, "TTID=", s2);
    }

    @Override
    public void untriggeredTransitionPerforming(int n, int n2, short s, short s2) {
        this.log(1, "SM:handle   ", "SMID=", n, "SSMID=", n2, "SID=", s, "UTID=", s2);
    }

    @Override
    public void untriggeredTransitionActing(int n, int n2, short s, short s2) {
        this.log(3, "SM:act      ", "SMID=", n, "SSMID=", n2, "SID=", s, "UTID=", s2);
    }

    @Override
    public void untriggeredTransitionActed(int n, int n2, short s, short s2) {
        this.log(3, "SM:acted    ", "SMID=", n, "SSMID=", n2, "SID=", s, "UTID=", s2);
    }

    @Override
    public void untriggeredTransitionPerformed(int n, int n2, short s, short s2) {
        this.log(3, "SM:handled  ", "SMID=", n, "SSMID=", n2, "SID=", s, "UTID=", s2);
    }

    @Override
    public void subStatemachineActivating(int n, int n2) {
        this.log(1, "SM:start    ", "SMID=", n, "SSMID=", n2, "");
    }

    @Override
    public void subStatemachineActivated(int n, int n2) {
        this.log(1, "SM:Started  ", "SMID=", n, "SSMID=", n2, "");
    }

    @Override
    public void subStatemachineDeactivating(int n, int n2) {
        this.log(1, "SM:finish   ", "SMID=", n, "SSMID=", n2, "");
    }

    @Override
    public void subStatemachineDeactivated(int n, int n2) {
        this.log(1, "SM:finished ", "SMID=", n, "SSMID=", n2, "");
    }

    @Override
    public void stateEntryActing(int n, int n2, short s, boolean bl) {
        this.log(1, "SM:act      ", "SMID=", n, "SSMID=", n2, "SID=", s, " Entry");
    }

    @Override
    public void stateEntryActed(int n, int n2, short s) {
        this.log(3, "SM:acted    ", "SMID=", n, "SSMID=", n2, "SID=", s, " Entry");
    }

    @Override
    public void stateExitActing(int n, int n2, short s) {
        this.log(1, "SM:act      ", "SMID=", n, "SSMID=", n2, "SID=", s, " Exit");
    }

    @Override
    public void stateExitActed(int n, int n2, short s) {
        this.log(3, "SM:acted    ", "SMID=", n, "SSMID=", n2, "SID=", s, " Exit");
    }

    @Override
    public void stateFocusGainedActing(int n, int n2, short s) {
        this.log(3, "SM:act      ", "SMID=", n, "SSMID=", n2, "SID=", s, " Focus-Gained");
    }

    @Override
    public void stateFocusGainedActed(int n, int n2, short s) {
        this.log(3, "SM:acted    ", "SMID=", n, "SSMID=", n2, "SID=", s, " Focus-Gained");
    }

    @Override
    public void stateFocusLostActing(int n, int n2, short s) {
        this.log(3, "SM:act      ", "SMID=", n, "SSMID=", n2, "SID=", s, " Focus-Lost");
    }

    @Override
    public void stateFocusLostActed(int n, int n2, short s) {
        this.log(3, "SM:acted    ", "SMID=", n, "SSMID=", n2, "SID=", s, " Focus-Lost");
    }

    private void log(int n, String string, String string2, int n2, String string3) {
        if (this.logger.isTraceEnabled(n)) {
            LogMessage logMessage = this.logger.trace(n);
            logMessage.append(string);
            logMessage.append(string2);
            logMessage.append(n2);
            if ("" != string3) {
                logMessage.append(string3);
            }
            logMessage.log();
        }
    }

    private void log(int n, String string, String string2, int n2, String string3, int n3, String string4) {
        if (this.logger.isTraceEnabled(n)) {
            LogMessage logMessage = this.logger.trace(n);
            logMessage.append(string);
            logMessage.append(string2);
            logMessage.append(n2);
            logMessage.append(" ");
            logMessage.append(string3);
            logMessage.append(n3);
            if ("" != string4) {
                logMessage.append(string4);
            }
            logMessage.log();
        }
    }

    private void log(int n, String string, String string2, int n2, String string3, int n3, String string4, int n4, String string5) {
        if (this.logger.isTraceEnabled(n)) {
            LogMessage logMessage = this.logger.trace(n);
            logMessage.append(string);
            logMessage.append(string2);
            logMessage.append(n2);
            logMessage.append(" ");
            logMessage.append(string3);
            logMessage.append(n3);
            logMessage.append(" ");
            logMessage.append(string4);
            logMessage.append(n4);
            if ("" != string5) {
                logMessage.append(string5);
            }
            logMessage.log();
        }
    }

    private void log(int n, String string, String string2, int n2, String string3, int n3, String string4, int n4, String string5, int n5) {
        if (this.logger.isTraceEnabled(n)) {
            LogMessage logMessage = this.logger.trace(n);
            logMessage.append(string);
            logMessage.append(string2);
            logMessage.append(n2);
            logMessage.append(" ");
            logMessage.append(string3);
            logMessage.append(n3);
            logMessage.append(" ");
            logMessage.append(string4);
            logMessage.append(n4);
            logMessage.append(" ");
            logMessage.append(string5);
            logMessage.append(n5);
            logMessage.log();
        }
    }
}

