/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.internal.journal.DebugNames;
import de.vw.mib.sm.internal.journal.SmJournalEx;
import de.vw.mib.sm.internal.statemachine.StatemachinesResDataAccess;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class TextualInfoSmJournal
extends SmJournalEx {
    public static final String STRING_UNKNOWN_REASON;
    public static final String STRING_EVENT_IS_A_SPECIAL_EVENT_LIKE_A_VERY_IMPORTANT_POPUP_OR_DRIVER_DISTRACTION_PREVENTION;
    public static final String STRING_EVENT_CAME_FROM_AN_EXPIRED_WAIT_STATE;
    public static final String STRING_EVENT_CAME_FROM_THE_POPUP_MANAGER;
    public static final String STRING_EVENT_CAME_FROM_STATEMACHINE_EVENT_DISPATCHER;
    public static final String REASON;
    public static final String HANDLED_FOCUS_LOST_ACTION;
    public static final String HANDLING_FOCUS_LOST_ACTION;
    public static final String HANDLED_FOCUS_GAINED_ACTION;
    public static final String HANDLING_FOCUS_GAINED_ACTION;
    public static final String LEFT;
    public static final String LEAVING;
    public static final String ENTERED;
    public static final String EMPTY_STRING;
    public static final String BY_DOWN_TRANSITION;
    public static final String ENTERING;
    public static final String SM_STATE;
    public static final String SM_SUB_STATEMACHINE;
    public static final String PERFORMED;
    public static final String CLOSED_BRACKET_PERFORMING;
    public static final String SM_UNTRIGGERED_TRANSITION;
    public static final String SM_TRIGGERED_TRANSITION;
    public static final String BEEN_CONSUMED;
    public static final String NOT;
    public static final String HAS;
    public static final String PERFORMED_EVENT;
    public static final String ACTED;
    public static final String ACTING;
    public static final String PERFORMING;
    public static final String TRIGGER;
    public static final String ARROW;
    public static final String SM_INTERNAL_TRANSITION;
    public static final String DEACTIVATED;
    public static final String DEACTIVATING;
    public static final String ACTIVATED;
    public static final String ACTIVATING;
    public static final String SM_STATEMACHINE;
    public static final String SM_DEACTIVATOR;
    public static final String CHECKED;
    public static final String CHECKING;
    public static final String SM_ACTIVATOR;
    public static final String CLOSED_BRACKET_COLON;
    public static final String SLASH;
    public static final String SM_FATAL_ERROR_IN_STATE;
    public static final String CLOSED_BRACKET_DOT;
    public static final String FORWARDING_TO_STATEMACHINE;
    public static final String SKIPPED;
    public static final String NOT_CONSUMED;
    public static final String CONSUMED;
    public static final String PROCESSED_AND;
    public static final String PROCESSING;
    public static final String CONSUMING;
    public static final String CLASS;
    public static final String TYPE;
    public static final String ID;
    public static final String SM_EVENT;
    public static final String SM_MANAGER_FINISHED;
    public static final String SM_MANAGER_STARTED;
    public static final String SYSTEM_PROPERTY;
    private final Logger logger;
    private final DebugNames debugNames;
    private short[] subStatemachines_SOffset = new short[0];
    private short[] subStatemachines_ItOffset = new short[0];
    private short[] subStatemachines_TtOffset = new short[0];
    private short[] subStatemachines_UtOffset = new short[0];
    private short[] internals_Trigger = new short[0];
    private short[] triggereds_Target = new short[0];
    private short[] triggereds_Trigger = new short[0];
    private short[] untriggereds_Target = new short[0];

    public TextualInfoSmJournal(Class clazz, int n, int n2, StatemachinesResDataAccess statemachinesResDataAccess) {
        this.logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
        this.debugNames = new DebugNames();
        try {
            this.loadDebugInfo(n, n2);
            if (statemachinesResDataAccess != null) {
                this.subStatemachines_SOffset = statemachinesResDataAccess.getSubStatemachines_SOffset();
                this.subStatemachines_ItOffset = statemachinesResDataAccess.getSubStatemachines_ItOffset();
                this.subStatemachines_TtOffset = statemachinesResDataAccess.getSubStatemachines_TtOffset();
                this.subStatemachines_UtOffset = statemachinesResDataAccess.getSubStatemachines_UtOffset();
                this.internals_Trigger = statemachinesResDataAccess.getInternals_Trigger();
                this.triggereds_Target = statemachinesResDataAccess.getTriggereds_Target();
                this.triggereds_Trigger = statemachinesResDataAccess.getTriggereds_Trigger();
                this.untriggereds_Target = statemachinesResDataAccess.getUntriggereds_Target();
            }
        }
        catch (Exception exception) {
            this.errorMsg().append("No debug info: ").append(exception.getMessage()).attachThrowable(exception).log();
        }
    }

    private void loadDebugInfo(int n, int n2) {
        String string = System.getProperty("vw.mib.debuginfo", "hmi.debuginfo.zip");
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(string);
        if (inputStream == null) {
            throw new FileNotFoundException(new StringBuffer().append("Resource ").append(string).append(" not found.").toString());
        }
        this.debugNames.load(inputStream, n, n2);
    }

    private static int $(short[] sArray, int n) {
        return n < 0 || n >= sArray.length ? 128 : sArray[n];
    }

    @Override
    public void managerStarted() {
        this.infoMsg().append("SM:manager started").log();
    }

    @Override
    public void managerFinished() {
        this.infoMsg().append("SM:manager finished").log();
    }

    @Override
    public void eventProcessing(int n, short s) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:event '");
            logMessage.append(this.debugNames.resolveEventNameByPublicId(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(", Type ");
            logMessage.append(this.debugNames.resolveEventType(n));
            logMessage.append(") processing");
            logMessage.append(" Reason: ");
            switch (s) {
                case 0: {
                    logMessage.append("Event came from statemachine event dispatcher.");
                    break;
                }
                case 1: {
                    logMessage.append("Event came from the popup manager.");
                    break;
                }
                case 2: {
                    logMessage.append("Event is a special event like a very important popup or driver distraction prevention.");
                    break;
                }
                default: {
                    logMessage.append("Unknown reason");
                }
            }
            logMessage.log();
        }
    }

    @Override
    public void eventProcessed(int n, boolean bl) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:event '");
            logMessage.append(this.debugNames.resolveEventNameByPublicId(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") processed and ");
            logMessage.append(bl ? "consumed" : "not consumed");
            logMessage.log();
        }
    }

    @Override
    public void eventSkipped(int n) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:event '");
            logMessage.append(this.debugNames.resolveEventNameByPublicId(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") skipped");
            logMessage.log();
        }
    }

    @Override
    public void eventForwardingToStatemachine(int n, int n2) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:event '");
            logMessage.append(this.debugNames.resolveEventNameByPublicId(n2));
            logMessage.append("' (Id ");
            logMessage.append(n2);
            logMessage.append(", Type ");
            logMessage.append(this.debugNames.resolveEventType(n2));
            logMessage.append(") forwarding to statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(").");
            logMessage.log();
        }
    }

    @Override
    public void checkpoint(char c2) {
    }

    @Override
    public void fatalError(int n, int n2, short s, RuntimeException runtimeException) {
        int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
        LogMessage logMessage = this.fatalMsg();
        logMessage.append("SM:fatal error in state '");
        logMessage.append(this.debugNames.resolveTopStatemachineName(n));
        logMessage.append("/");
        logMessage.append(this.debugNames.resolveSubStatemachineName(n2));
        logMessage.append("/");
        logMessage.append(this.debugNames.resolveStateName(s + n3));
        logMessage.append("' (Id ");
        logMessage.append(n);
        logMessage.append("/");
        logMessage.append(n2);
        logMessage.append("/");
        logMessage.append(s);
        logMessage.append("): ");
        logMessage.append(runtimeException.getMessage());
        logMessage.attachThrowable(runtimeException);
        logMessage.log();
    }

    @Override
    public void activatorChecking(int n) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:activator '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") checking");
            logMessage.log();
        }
    }

    @Override
    public void activatorChecked(int n) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:activator '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") checked");
            logMessage.log();
        }
    }

    @Override
    public void deactivatorChecking(int n) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:deactivator '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") checking");
            logMessage.log();
        }
    }

    @Override
    public void deactivatorChecked(int n) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:deactivator '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") checked");
            logMessage.log();
        }
    }

    @Override
    public void statemachineActivating(int n) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") activating");
            logMessage.log();
        }
    }

    @Override
    public void statemachineActivated(int n) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") activated");
            logMessage.log();
        }
    }

    @Override
    public void statemachineDeactivating(int n) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") deactivating");
            logMessage.log();
        }
    }

    @Override
    public void statemachineDeactivated(int n) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append(") deactivated");
            logMessage.log();
        }
    }

    @Override
    public void internalTransitionPerforming(int n, int n2, short s, short s2) {
        if (this.isInfoEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_ItOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:internal transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append(", Trigger '");
            logMessage.append(this.debugNames.resolveEventNameByCompactId(TextualInfoSmJournal.$(this.internals_Trigger, s2 + n3)));
            logMessage.append("') performing");
            logMessage.log();
        }
    }

    @Override
    public void internalTransitionActing(int n, int n2, short s, short s2) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:internal transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") acting");
            logMessage.log();
        }
    }

    @Override
    public void internalTransitionActed(int n, int n2, short s, short s2) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:internal transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") acted");
            logMessage.log();
        }
    }

    @Override
    public void internalTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_ItOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:internal transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") performed. Event '");
            logMessage.append(this.debugNames.resolveEventNameByCompactId(TextualInfoSmJournal.$(this.internals_Trigger, s2 + n3)));
            logMessage.append("' has ");
            if (!bl) {
                logMessage.append("not ");
            }
            logMessage.append("been consumed.");
            logMessage.log();
        }
    }

    @Override
    public void triggeredTransitionPerforming(int n, int n2, short s, short s2) {
        if (this.isInfoEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_TtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:triggered transition '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.triggereds_Target, s2 + n3)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(", Trigger '");
            int n5 = TextualInfoSmJournal.$(this.triggereds_Trigger, s2 + n3);
            logMessage.append(this.debugNames.resolveEventNameByCompactId(n5));
            logMessage.append("') performing");
            logMessage.log();
        }
    }

    @Override
    public void triggeredTransitionActing(int n, int n2, short s, short s2) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_TtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:triggered transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.triggereds_Target, s2 + n3)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") acting");
            logMessage.log();
        }
    }

    @Override
    public void triggeredTransitionActed(int n, int n2, short s, short s2) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_TtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:triggered transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.triggereds_Target, s2 + n3)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") acted");
            logMessage.log();
        }
    }

    @Override
    public void triggeredTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        if (this.isInfoEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_TtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:triggered transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.triggereds_Target, n3 + s2)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") performed. Event '");
            logMessage.append(this.debugNames.resolveEventNameByCompactId(TextualInfoSmJournal.$(this.triggereds_Trigger, s2 + n3)));
            logMessage.append("' has ");
            if (!bl) {
                logMessage.append("not ");
            }
            logMessage.append("been consumed.");
            logMessage.log();
        }
    }

    @Override
    public void untriggeredTransitionPerforming(int n, int n2, short s, short s2) {
        if (this.isInfoEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_UtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:untriggered transition '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.untriggereds_Target, s2 + n3)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") performing");
            logMessage.log();
        }
    }

    @Override
    public void untriggeredTransitionActing(int n, int n2, short s, short s2) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_UtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:untriggered transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.untriggereds_Target, s2 + n3)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") acting");
            logMessage.log();
        }
    }

    @Override
    public void untriggeredTransitionActed(int n, int n2, short s, short s2) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_UtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:untriggered transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.untriggereds_Target, s2 + n3)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") acted");
            logMessage.log();
        }
    }

    @Override
    public void untriggeredTransitionPerformed(int n, int n2, short s, short s2) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_UtOffset, n2);
            int n4 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:untriggered transition '");
            logMessage.append(this.debugNames.resolveStateName(s + n4));
            logMessage.append("'->'");
            logMessage.append(this.debugNames.resolveStateName(TextualInfoSmJournal.$(this.untriggereds_Target, s2 + n3)));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s2);
            logMessage.append(") performed");
            logMessage.log();
        }
    }

    @Override
    public void subStatemachineActivating(int n, int n2) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:sub statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveSubStatemachineName(n2));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append(") activating");
            logMessage.log();
        }
    }

    @Override
    public void subStatemachineActivated(int n, int n2) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:sub statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveSubStatemachineName(n2));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append(") activated");
            logMessage.log();
        }
    }

    @Override
    public void subStatemachineDeactivating(int n, int n2) {
        if (this.isInfoEnable()) {
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:sub statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveSubStatemachineName(n2));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append(") deactivating");
            logMessage.log();
        }
    }

    @Override
    public void subStatemachineDeactivated(int n, int n2) {
        if (this.isDebugEnable()) {
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:sub statemachine '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveSubStatemachineName(n2));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append(") deactivated");
            logMessage.log();
        }
    }

    @Override
    public void stateEntryActing(int n, int n2, short s, boolean bl) {
        if (this.isInfoEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveSubStatemachineName(n2));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") entering");
            logMessage.append(bl ? " by down-transition" : "");
            logMessage.log();
        }
    }

    @Override
    public void stateEntryActed(int n, int n2, short s) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") entered");
            logMessage.log();
        }
    }

    @Override
    public void stateExitActing(int n, int n2, short s) {
        if (this.isInfoEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.infoMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveTopStatemachineName(n));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveSubStatemachineName(n2));
            logMessage.append("/");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") leaving");
            logMessage.log();
        }
    }

    @Override
    public void stateExitActed(int n, int n2, short s) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") left");
            logMessage.log();
        }
    }

    @Override
    public void stateFocusGainedActing(int n, int n2, short s) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") handling focus gained action");
            logMessage.log();
        }
    }

    @Override
    public void stateFocusGainedActed(int n, int n2, short s) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") handled focus gained action");
            logMessage.log();
        }
    }

    @Override
    public void stateFocusLostActing(int n, int n2, short s) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") handling focus lost action");
            logMessage.log();
        }
    }

    @Override
    public void stateFocusLostActed(int n, int n2, short s) {
        if (this.isDebugEnable()) {
            int n3 = TextualInfoSmJournal.$(this.subStatemachines_SOffset, n2);
            LogMessage logMessage = this.debugMsg();
            logMessage.append("SM:state '");
            logMessage.append(this.debugNames.resolveStateName(s + n3));
            logMessage.append("' (Id ");
            logMessage.append(n);
            logMessage.append("/");
            logMessage.append(n2);
            logMessage.append("/");
            logMessage.append(s);
            logMessage.append(") handled focus lost action");
            logMessage.log();
        }
    }

    private LogMessage fatalMsg() {
        return this.logger.fatal(1);
    }

    private LogMessage errorMsg() {
        return this.logger.error(1);
    }

    private LogMessage infoMsg() {
        return this.logger.info(1);
    }

    private boolean isInfoEnable() {
        return this.logger.isTraceEnabled(1);
    }

    private LogMessage debugMsg() {
        return this.logger.trace(3);
    }

    private boolean isDebugEnable() {
        return this.logger.isTraceEnabled(3);
    }
}

