/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.internal.media.common.MediaTimer;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand$1;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand$2;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand$3;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand$4;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandStateListener;
import de.vw.mib.asl.internal.media.controller.commands.CommandTracer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.util.Util;
import java.util.Arrays;

public abstract class AbstractCommand
implements Command {
    private static final int SHORT_COMMAND_NAME_LENGTH;
    private final String mCommandNameShort;
    private final String mCommandNameFull;
    private static IntObjectOptHashMap mCommandNamesFull;
    private static IntObjectOptHashMap mCommandNamesShort;
    private long mSequenceNumber;
    private final int mInitialStepIndex;
    private final int mFinalStepIndex;
    private final MediaTimer mAbortCommandTimer;
    private static final int COMMAND_STATE_WAIT;
    private static final int COMMAND_STATE_EXECUTE;
    private static final int COMMAND_STATE_SUCCESS;
    private static final int COMMAND_STATE_ERROR;
    private static final int COMMAND_STATE_TIMEOUT;
    private static final int COMMAND_STATE_ABORTED;
    private int mCommandState = 0;
    private int mCurrentStepIndex;
    private int mExecutionDepth = 0;
    protected final CommandTracer mTracer;
    Command mExecutedSubCommand = null;
    private final int mRequiredComponents;
    protected final ResponseHandler NEXT_STEP = new AbstractCommand$1(this);
    protected final ResponseHandler NO_OPERATION = new AbstractCommand$2(this);
    private CommandStateListener mListener = null;
    private CommandCallback mCallback = null;
    private boolean mAbortRequested = false;
    private String mAbortRequestedDetailsStr = "";

    public AbstractCommand(int n, int n2, int n3, int n4) {
        this.mRequiredComponents = n;
        this.mInitialStepIndex = n2;
        this.mFinalStepIndex = n3;
        this.mCurrentStepIndex = this.mInitialStepIndex;
        AbstractCommand$3 abstractCommand$3 = new AbstractCommand$3(this);
        this.mAbortCommandTimer = new MediaTimer(abstractCommand$3, n4, "abort_command");
        int n5 = super.getClass().hashCode();
        String string = "";
        String string2 = "";
        if (mCommandNamesFull.containsKey(n5)) {
            string = (String)mCommandNamesFull.get(n5);
        } else {
            string = this.getClassName();
            mCommandNamesFull.put(n5, string);
        }
        if (mCommandNamesShort.containsKey(n5)) {
            string2 = (String)mCommandNamesShort.get(n5);
        } else {
            string2 = AbstractCommand.shortenizeCommandName(string, 4);
            mCommandNamesShort.put(n5, string2);
        }
        this.mCommandNameFull = string;
        String string3 = AbstractCommand.getUsedBrowserStr(n);
        this.mCommandNameShort = new StringBuffer().append(string2).append(" ").append(string3).toString();
        this.mTracer = new CommandTracer(this);
    }

    @Override
    public Class getCommandType() {
        return super.getClass();
    }

    @Override
    public int getRequiredComponents() {
        return this.mRequiredComponents;
    }

    @Override
    public long getSequenceNumber() {
        return this.mSequenceNumber;
    }

    @Override
    public void setSequenceNumber(long l) {
        this.mSequenceNumber = l;
    }

    public int getExecutionDepth() {
        return this.mExecutionDepth;
    }

    @Override
    public void setExecutionDepth(int n) {
        this.mExecutionDepth = n;
    }

    @Override
    public void setCommandStateListener(CommandStateListener commandStateListener) {
        this.mListener = commandStateListener;
    }

    @Override
    public void setCommandCallback(CommandCallback commandCallback) {
        this.mCallback = commandCallback;
    }

    private void setCommandState(int n) {
        if (this.mCommandState != n) {
            this.mCommandState = n;
            if (this.mListener != null) {
                this.mListener.notifyCommandStateChanged(this);
            }
        }
    }

    @Override
    public boolean isWaiting() {
        return this.mCommandState == 0;
    }

    @Override
    public boolean isExecuting() {
        return this.mCommandState == 1;
    }

    @Override
    public boolean isCompleted() {
        return this.mCommandState == 2;
    }

    @Override
    public boolean isAbortedByError() {
        return this.mCommandState == 3;
    }

    @Override
    public boolean isAbortedByTimeout() {
        return this.mCommandState == 4;
    }

    @Override
    public boolean isAbortedByCall() {
        return this.mCommandState == 5;
    }

    @Override
    public boolean isTerminated() {
        return this.isCompleted() || this.isAbortedByError() || this.isAbortedByTimeout() || this.isAbortedByCall();
    }

    @Override
    public Command getCommand() {
        return this;
    }

    @Override
    public void execute() {
        if (this.isWaiting() && this.mCurrentStepIndex == this.mInitialStepIndex) {
            this.setCommandState(1);
            this.mAbortCommandTimer.start();
            this.mTracer.logStart();
            this.executeStep(this.mCurrentStepIndex);
        } else {
            this.commandFailed("execute called in illegal state/step (state=WAIT / step=initialStep expected)");
        }
    }

    private void executeStep(int n) {
        try {
            if (!this.isTerminated()) {
                if (this.isExecuting()) {
                    if (this.mAbortRequested) {
                        this.commandAborted(this.mAbortRequestedDetailsStr, true);
                        return;
                    }
                    this.mCurrentStepIndex = n;
                    if (n < this.mInitialStepIndex) {
                        this.commandFailed("step smaller than initial step index");
                        return;
                    }
                    if (n > this.mFinalStepIndex) {
                        this.commandCompleted(null);
                        return;
                    }
                    this.mTracer.logStep(this.mCurrentStepIndex, this.mInitialStepIndex, this.mFinalStepIndex);
                    this.execute(n);
                } else {
                    this.commandFailed(new StringBuffer().append("executeStep(").append(n).append(") called in illegal state (state=EXECUTE expected)").toString());
                }
            }
        }
        catch (Exception exception) {
            this.error(exception);
            this.commandFailed(new StringBuffer().append("executeStep(").append(n).append(") failed with Exception ").append(exception).toString());
            return;
        }
    }

    protected void nextStep() {
        this.executeStep(this.mCurrentStepIndex + 1);
    }

    protected void skipTo(int n) {
        this.executeStep(n);
    }

    @Override
    public void abort(String string) {
        if (this.mExecutedSubCommand != null) {
            this.mExecutedSubCommand.abort(string);
        } else {
            this.commandAborted(string, false);
        }
    }

    @Override
    public void cancel(String string) {
        if (this.isTerminated() || this.mAbortRequested) {
            return;
        }
        if (this.mExecutedSubCommand != null) {
            this.mExecutedSubCommand.cancel(string);
        } else {
            if (!this.isExecuting()) {
                this.commandAborted(string, true);
                return;
            }
            if (!this.mAbortCommandTimer.isRunning()) {
                this.warn("cancel requested: abort now as current step has infinite timeout");
                this.abort(string);
            } else {
                this.warn("cancel requested: abort after current step");
                this.mAbortRequested = true;
                this.mAbortRequestedDetailsStr = string;
            }
        }
    }

    @Override
    public void enter() {
        this.onEnter();
    }

    @Override
    public void exit() {
        try {
            this.onExit();
        }
        catch (Exception exception) {
            this.error(new StringBuffer().append("Exception caught during onExit():").append(exception).toString());
        }
        if (this.mCallback != null) {
            this.mCallback.onCommandExecutionFinished(this);
        }
    }

    protected void commandCompleted(String string) {
        if (!this.isTerminated()) {
            this.mAbortCommandTimer.stop();
            this.mTracer.logSuccess(this.mCurrentStepIndex, string);
            this.setCommandState(2);
        }
    }

    protected void commandFailed(String string) {
        if (!this.isTerminated()) {
            this.mAbortCommandTimer.stop();
            this.mTracer.logFailed(this.mCurrentStepIndex, string);
            this.setCommandState(3);
        }
    }

    protected void commandTimedOut() {
        if (!this.isTerminated()) {
            this.mAbortCommandTimer.stop();
            this.mTracer.logTimeout(this.mCurrentStepIndex, this.mAbortCommandTimer.getTimeout());
            this.setCommandState(4);
        }
    }

    protected void commandAborted(String string, boolean bl) {
        if (!this.isTerminated()) {
            this.mAbortCommandTimer.stop();
            this.mTracer.logAborted(this.mCurrentStepIndex, bl, string, this.isWaiting());
            this.setCommandState(5);
        }
    }

    protected void rqExecuteCmd(Command command, ResponseHandler responseHandler) {
        this.mExecutedSubCommand = command;
        AbstractCommand$4 abstractCommand$4 = new AbstractCommand$4(this, responseHandler);
        command.setExecutionDepth(this.mExecutionDepth + 1);
        command.setSequenceNumber(this.mSequenceNumber);
        command.setCommandStateListener(abstractCommand$4);
        command.getTracer().setParentTracer(this.mTracer);
        command.enter();
        this.mAbortCommandTimer.pause();
        command.execute();
    }

    private String getClassName() {
        String string = "";
        try {
            int n;
            String string2 = super.getClass().getName();
            if (!Util.isNullOrEmpty(string2) && (n = string2.lastIndexOf(".")) + 1 < string2.length()) {
                string = string2.substring(n + 1);
            }
        }
        catch (Exception exception) {
            string = "error";
        }
        return string;
    }

    private static String shortenizeCommandName(String string, int n) {
        String string2 = "";
        try {
            char[] cArray;
            if (string.startsWith("Cmd") && string.length() > 3) {
                string = string.substring(3);
            }
            if (string.length() <= n) {
                string2 = string;
            } else {
                cArray = string.toCharArray();
                boolean bl = false;
                for (int i2 = 0; i2 < cArray.length; ++i2) {
                    char c2 = cArray[i2];
                    boolean bl2 = bl;
                    boolean bl3 = bl = c2 >= 'A' && c2 <= 'Z';
                    if (bl ^ bl2) {
                        string2 = new StringBuffer().append(string2).append(c2).toString();
                    }
                    if (string2.length() >= n) break;
                }
            }
            if (string2.length() > n) {
                string2 = string2.substring(0, n - 1);
            } else if (string2.length() < n) {
                cArray = new char[n - string2.length()];
                Arrays.fill(cArray, ' ');
                string2 = new StringBuffer().append(string2).append(new String(cArray)).toString();
            }
        }
        catch (Exception exception) {
            string2 = "error";
        }
        return string2;
    }

    public static String getUsedBrowserStr(int n) {
        String string = "";
        if (n == -1) {
            return "*";
        }
        if (Util.isBitSet(32, n)) {
            string = new StringBuffer().append(string).append("|M").toString();
        }
        if (Util.isBitSet(64, n)) {
            string = new StringBuffer().append(string).append("|C").toString();
        }
        if (Util.isBitSet(1024, n)) {
            string = new StringBuffer().append(string).append("|R").toString();
        }
        if (Util.isBitSet(256, n)) {
            string = new StringBuffer().append(string).append("|B").toString();
        }
        if (Util.isBitSet(512, n)) {
            string = new StringBuffer().append(string).append("|H").toString();
        }
        if (Util.isBitSet(128, n)) {
            string = new StringBuffer().append(string).append("|S").toString();
        }
        if (string.trim().length() == 0) {
            return "   ";
        }
        return new StringBuffer().append("[").append(string.substring(1)).append("]").toString();
    }

    protected String getCommandNameShort() {
        return this.mCommandNameShort;
    }

    protected String getCommandNameFull() {
        return this.mCommandNameFull;
    }

    public String toString() {
        return this.getCommandStr(true, true, true, true);
    }

    @Override
    public String getCommandStr(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        String string = this.getCommandNameFull();
        if (bl || bl2 || bl3 || bl4) {
            String string2;
            String string3;
            String string4 = "";
            if (bl) {
                string4 = new StringBuffer().append("|").append(Long.toString(this.mSequenceNumber)).toString();
            }
            String string5 = "";
            if (bl2) {
                string5 = new StringBuffer().append("|").append(this.getCurrentStateStr(this.mCommandState)).toString();
            }
            String string6 = "";
            if (bl3) {
                string3 = null;
                try {
                    string3 = this.getParameterStr();
                }
                catch (Exception exception) {
                    string3 = "Exception occured";
                }
                if (!Util.isNullOrEmpty(string3)) {
                    string6 = new StringBuffer().append("|").append(string3).toString();
                }
            }
            string3 = "";
            if (bl4) {
                string3 = new StringBuffer().append(", requiredComponents: ").append(MediaComponents.getComponentsStr(this.mRequiredComponents)).toString();
            }
            if ((string2 = new StringBuffer().append(string4).append(string5).append(string6).append(string3).toString()).length() > 0) {
                return new StringBuffer().append(string).append(" [").append(string2.substring(1)).append("]").toString();
            }
        }
        return string;
    }

    public String getCurrentStateStr(int n) {
        String string = "null";
        switch (n) {
            case 0: {
                string = "wait";
                break;
            }
            case 1: {
                string = "exec";
                break;
            }
            case 2: {
                string = "succ";
                break;
            }
            case 3: {
                string = "erro";
                break;
            }
            case 4: {
                string = "time";
                break;
            }
            case 5: {
                string = "abrt";
                break;
            }
        }
        return string;
    }

    protected boolean isTraceEnabled() {
        return this.mTracer.isTraceEnabled();
    }

    protected void info(String string) {
        this.mTracer.logInfo(string);
    }

    protected void trace(String string) {
        this.mTracer.logTrace(string);
    }

    protected void warn(String string) {
        this.mTracer.logWarning(string);
    }

    protected void error(String string) {
        this.mTracer.logError(string);
    }

    private void error(Exception exception) {
        this.mTracer.logException(exception);
    }

    protected abstract String getParameterStr() {
    }

    protected abstract String getStepStr(int n) {
    }

    protected abstract void execute(int n) {
    }

    public void onEnter() {
    }

    public void onExit() {
    }

    @Override
    public CommandTracer getTracer() {
        return this.mTracer;
    }

    protected void suspendTimer(String string) {
        this.trace(new StringBuffer().append("timeout: ").append(this.mAbortCommandTimer.getTimeout()).append(" -> infinite (").append(string).append(")").toString());
        this.mAbortCommandTimer.pause();
    }

    protected void resumeTimer() {
        if (!this.mAbortCommandTimer.isRunning()) {
            this.trace(new StringBuffer().append("timeout: infinite -> ").append(this.mAbortCommandTimer.getTimeout()).toString());
            this.mAbortCommandTimer.resume();
        }
    }

    static /* synthetic */ MediaTimer access$000(AbstractCommand abstractCommand) {
        return abstractCommand.mAbortCommandTimer;
    }

    static {
        mCommandNamesFull = new IntObjectOptHashMap(50);
        mCommandNamesShort = new IntObjectOptHashMap(50);
    }
}

