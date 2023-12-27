/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.prompt;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultTtsHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.AsyncExceptionLogger;
import de.vw.mib.log4mib.Logger;

public class RequestAudioTrigger
extends DefaultTtsHandler
implements AsyncExceptionHandler {
    private final TtsController ttsController;
    private final short sourceId;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public RequestAudioTrigger(Logger logger, TtsController ttsController, short s) {
        super(logger);
        this.ttsController = ttsController;
        this.sourceId = s;
        this.isAborted = false;
    }

    @Override
    public void execute() {
        this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = RequestAudioTrigger.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
        this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = RequestAudioTrigger.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.ttsController.getTts().requestAudioTrigger(this.sourceId, 0);
    }

    @Override
    public void terminate() {
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = RequestAudioTrigger.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = RequestAudioTrigger.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
    }

    @Override
    public void abort() {
        this.isAborted = true;
    }

    @Override
    public short getSourceId() {
        return this.sourceId;
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        if (n == 7) {
            this.notifyFinishedFlawed();
        }
        if (n == 0) {
            if (this.isAborted) {
                this.notifyFinishedAborted();
            } else {
                this.notifyFinishedSuccessful();
            }
        }
    }

    @Override
    public void responseAudioTrigger(short s, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1008) {
            AsyncExceptionLogger.logAsyncException(this.taskLogger, 1024, "RequestAudioTriggerTask", n, string, n2);
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

