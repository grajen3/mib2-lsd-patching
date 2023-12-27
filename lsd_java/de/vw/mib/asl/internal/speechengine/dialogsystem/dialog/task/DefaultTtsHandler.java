/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.log4mib.Logger;

public abstract class DefaultTtsHandler
extends DefaultDialogTask
implements TtsHandler {
    public DefaultTtsHandler(Logger logger) {
        super(logger);
    }

    @Override
    public void responseSpeakPrompt(short s, int n) {
    }

    @Override
    public void responseAudioTrigger(short s, int n) {
    }

    @Override
    public void responsePlayTone(short s, int n) {
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
    }

    @Override
    protected int getMask() {
        return 2;
    }
}

