/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task;

import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.AsyncExceptionLogger;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;

public class GrammarInfoTask
extends DefaultDialogTask
implements GrammarHandler,
AsyncExceptionHandler {
    private GrammarInfo[] grammarInfoObjects;
    private DialogSystemDiagnosisListener diagnosisListener;
    private final AdapterHandlerRegistry handlerRegistry;
    private final AsrController asrController;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public GrammarInfoTask(Logger logger, GrammarInfo[] grammarInfoArray, DialogSystemDiagnosisListener dialogSystemDiagnosisListener, AdapterHandlerRegistry adapterHandlerRegistry, AsrController asrController) {
        super(logger);
        this.grammarInfoObjects = grammarInfoArray;
        this.diagnosisListener = dialogSystemDiagnosisListener;
        this.handlerRegistry = adapterHandlerRegistry;
        this.asrController = asrController;
    }

    @Override
    public void execute() {
        if (this.grammarInfoObjects != null && this.grammarInfoObjects.length != 0) {
            this.handlerRegistry.addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler = GrammarInfoTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler, this);
            this.handlerRegistry.addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = GrammarInfoTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
            this.asrController.getSpeechRec().unloadGrammar(this.grammarInfoObjects);
            this.diagnosisListener.unloadGrammar(this.grammarInfoObjects);
        } else {
            this.notifyFinishedSuccessful();
        }
    }

    @Override
    public void terminate() {
        this.handlerRegistry.removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler = GrammarInfoTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler, this);
        this.handlerRegistry.removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = GrammarInfoTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.taskLogger.warn(512, "unexpected responseLoadGrammar");
    }

    @Override
    public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        if (n == 0) {
            this.notifyFinishedSuccessful();
        } else {
            this.notifyFinishedFlawed();
        }
    }

    @Override
    public void updateGrammarState(GrammarStateInfo grammarStateInfo) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1004) {
            AsyncExceptionLogger.logAsyncException(this.taskLogger, 128, "GrammarInfoTask", n, string, n2);
            this.notifyFinishedFlawed();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

