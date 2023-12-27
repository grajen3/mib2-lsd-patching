/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.startup.tts;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsStartupHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;

public class InitDsiTts
extends AbstractTask
implements TtsStartupHandler {
    private final TtsController ttsController;
    private final short sourceId;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler;

    public InitDsiTts(Logger logger, TtsController ttsController, short s) {
        super(logger);
        this.ttsController = ttsController;
        this.sourceId = s;
    }

    @Override
    public void execute() {
        this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler = InitDsiTts.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsStartupHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler, this);
        this.ttsController.getTts().init(this.sourceId);
    }

    @Override
    public void terminate() {
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler = InitDsiTts.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsStartupHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    public short getSourceId() {
        return this.sourceId;
    }

    @Override
    public void responseInit(short s, int n) {
        if (n == 0) {
            this.notifyFinishedSuccessful();
        } else {
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

