/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.prompt;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultTtsHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.AsyncExceptionLogger;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.PromptUtil;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.tts.DynamicTTSPromptPart;
import org.dsi.ifc.tts.TTSPrompt;

public class SpeakPrompt
extends DefaultTtsHandler
implements AsyncExceptionHandler {
    private static final String TRACE_PREFIX;
    private final TtsController ttsController;
    private final short sourceId;
    private final Prompt[] ttsPrompts;
    private TTSPrompt dsiTtsPrompt;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public SpeakPrompt(Logger logger, TtsController ttsController, Prompt[] promptArray, short s) {
        super(logger);
        this.ttsController = ttsController;
        this.sourceId = s;
        this.ttsPrompts = promptArray;
    }

    private TTSPrompt convertPrompt(Prompt[] promptArray) {
        int[] nArray = PromptUtil.getPromptPartIds(this.ttsPrompts);
        DynamicTTSPromptPart[] dynamicTTSPromptPartArray = PromptUtil.getDynamicPromptParts(this.ttsPrompts);
        TTSPrompt tTSPrompt = new TTSPrompt(2, null, nArray, dynamicTTSPromptPartArray);
        return tTSPrompt;
    }

    @Override
    public void execute() {
        try {
            this.dsiTtsPrompt = this.convertPrompt(this.ttsPrompts);
            this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = SpeakPrompt.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
            this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = SpeakPrompt.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
            this.ttsController.getTts().speakPrompt(this.sourceId, this.dsiTtsPrompt);
            this.ttsController.getDiagnosisListener().speakPrompt(this.sourceId, this.dsiTtsPrompt);
        }
        catch (Exception exception) {
            this.taskLogger.fatal(1024, "[SpeakPrompt]: Exception when trying to speakPrompt. ", exception);
            this.notifyFinishedFlawed();
        }
    }

    @Override
    public void terminate() {
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = SpeakPrompt.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = SpeakPrompt.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    public short getSourceId() {
        return this.sourceId;
    }

    @Override
    public void responseSpeakPrompt(short s, int n) {
        if (n == 0) {
            this.notifyFinishedSuccessful();
        } else if (n == 1) {
            this.notifyFinishedAborted();
        } else {
            this.notifyFinishedFlawed();
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1010) {
            AsyncExceptionLogger.logAsyncException(this.taskLogger, 1024, "SpeakPromptTask", n, string, n2);
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

