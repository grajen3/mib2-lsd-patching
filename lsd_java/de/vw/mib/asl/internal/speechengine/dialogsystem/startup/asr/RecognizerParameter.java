/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.startup.asr;

import de.vw.mib.asl.internal.speechengine.Settings;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;

public class RecognizerParameter
extends AbstractTask {
    public final AsrController asr;

    public RecognizerParameter(Logger logger, AsrController asrController) {
        super(logger);
        this.asr = asrController;
    }

    @Override
    public void execute() {
        this.asr.getSpeechRec().setUnambiguousResultRange(Settings.getDefaultUnambiguousResultRange());
        this.asr.getSpeechRec().setFirstLevelSize(Settings.getDefaultFirstLevelSize());
        this.asr.getSpeechRec().setUnambiguousResultThreshold(Settings.getDefaultUnambiguousResultThreshold());
        this.asr.getSpeechRec().setMaxSlotNBestListSize(Settings.getDefaultMaxSlotNBestListSize());
        this.asr.getSpeechRec().setMaxCommandNBestListSize(Settings.getDefaultMaxCommandNBestListSize());
        this.notifyFinishedSuccessful();
    }

    @Override
    public void terminate() {
    }

    @Override
    public void abort() {
    }
}

