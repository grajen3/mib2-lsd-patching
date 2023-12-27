/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.Activity;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarUtils;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.GrammarInfoTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.GrammarTask;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerIgnoringErrors;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class CommandLoaderImpl
implements CommandLoader,
TaskInvokerListener,
Activity {
    private static final String TRACE_PREFIX;
    private static final int TRACE_CLASSIFIER;
    private Logger logger;
    private AsrController asrController;
    private ActivityManager activityManager;
    private TaskInvoker taskInvoker;

    CommandLoaderImpl(ActivityManager activityManager, AsrController asrController, Logger logger) {
        this.logger = logger;
        this.asrController = asrController;
        this.activityManager = activityManager;
        this.taskInvoker = new TaskInvokerIgnoringErrors(128, this.logger, "CommandLoaderImpl-Invoker");
        this.taskInvoker.setInvokerListener(this);
    }

    private void logLoad(Grammar[] grammarArray) {
        if (this.logger.isTraceEnabled(128)) {
            StringBuffer stringBuffer = new StringBuffer("[CommandLoaderImpl] load ");
            for (int i2 = 0; i2 < grammarArray.length; ++i2) {
                stringBuffer.append(grammarArray[i2].toString());
                stringBuffer.append(", ");
            }
            this.logger.trace(128, stringBuffer.toString());
        }
    }

    private Grammar getSlotGrammar(int n, String[] stringArray, long[] lArray) {
        Grammar grammar = new Grammar();
        grammar.commandHierarchy = 5;
        grammar.grammarId = n;
        grammar.grammarType = 8;
        grammar.listData = stringArray;
        grammar.listIdData = lArray;
        grammar.publicGrammar = false;
        return grammar;
    }

    void deviceShutdown() {
        if (!this.taskInvoker.isIdle()) {
            this.taskInvoker.abort();
            this.activityManager.onFinished(this);
        }
    }

    @Override
    public void registerObserver(CommandLoaderObserver commandLoaderObserver) {
    }

    @Override
    public Grammar wrapToGrammar(Command command) {
        return new Grammar(4, GrammarUtils.commandModeToGrammarHierarchy(command.getMode()), command.isPublic(), null, null, -1, command.getSdsId(), null, -1, -1);
    }

    @Override
    public GrammarInfo wrapToGrammarInfo(Command command) {
        return new GrammarInfo(command.getSdsId(), GrammarUtils.commandModeToGrammarHierarchy(command.getMode()));
    }

    @Override
    public void load(Grammar[] grammarArray) {
        this.activityManager.onActive(this);
        this.taskInvoker.add(new GrammarTask(this.logger, grammarArray, this.asrController.getDiagnosisListener(), this.asrController.getHandlerRegistry(), this.asrController));
        this.taskInvoker.invoke();
        this.logLoad(grammarArray);
    }

    @Override
    public void unload(GrammarInfo[] grammarInfoArray) {
        if (this.logger.isTraceEnabled(128)) {
            StringBuffer stringBuffer = new StringBuffer("[CommandLoaderImpl] unload ");
            for (int i2 = 0; i2 < grammarInfoArray.length; ++i2) {
                if (grammarInfoArray[i2] != null) {
                    stringBuffer.append(grammarInfoArray[i2].toString());
                } else {
                    this.logger.warn(128, new StringBuffer().append("[CommandLoaderImpl] Found null object at index ").append(i2).toString());
                    stringBuffer.append("GrammarInfo=null");
                }
                stringBuffer.append(", ");
            }
            this.logger.trace(128, stringBuffer.toString());
        }
        this.activityManager.onActive(this);
        this.taskInvoker.add(new GrammarInfoTask(this.logger, grammarInfoArray, this.asrController.getDiagnosisListener(), this.asrController.getHandlerRegistry(), this.asrController));
        this.taskInvoker.invoke();
    }

    @Override
    public void loadSlot(int n, String[] stringArray, long[] lArray) {
        Grammar grammar = this.getSlotGrammar(n, stringArray, lArray);
        Grammar[] grammarArray = new Grammar[]{grammar};
        this.activityManager.onActive(this);
        this.taskInvoker.add(new GrammarTask(this.logger, grammarArray, this.asrController.getDiagnosisListener(), this.asrController.getHandlerRegistry(), this.asrController));
        this.taskInvoker.invoke();
        this.logLoad(grammarArray);
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        this.activityManager.onFinished(this);
    }

    @Override
    public ActivityType getType() {
        return ActivityType.GRAMMAR_UPDATE;
    }
}

