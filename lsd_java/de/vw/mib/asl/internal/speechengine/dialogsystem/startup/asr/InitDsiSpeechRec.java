/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.startup.asr;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrStartupHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;

public class InitDsiSpeechRec
extends AbstractTask
implements AsrStartupHandler {
    private AsrController asrController;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler;

    public InitDsiSpeechRec(Logger logger, AsrController asrController) {
        super(logger);
        this.asrController = asrController;
    }

    @Override
    public void terminate() {
        this.asrController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler = InitDsiSpeechRec.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrStartupHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler, this);
    }

    @Override
    public void execute() {
        this.asrController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler = InitDsiSpeechRec.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrStartupHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler, this);
        this.asrController.getSpeechRec().init();
    }

    @Override
    public void abort() {
    }

    @Override
    public void responseInit(int n) {
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

