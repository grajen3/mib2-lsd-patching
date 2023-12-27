/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.log4mib.Logger;

public class WaitForGrammarLoading
extends DefaultDialogTask
implements ActivityObserver {
    private final ActivityManager activityManager;

    public WaitForGrammarLoading(Logger logger, ActivityManager activityManager) {
        super(logger);
        this.activityManager = activityManager;
    }

    private void finish() {
        this.terminate();
        this.notifyFinishedSuccessful();
    }

    @Override
    public void execute() {
        if (this.activityManager.isRunning(ActivityType.GRAMMAR_UPDATE)) {
            this.activityManager.addObserver(this, ActivityType.GRAMMAR_UPDATE);
            this.taskLogger.info(512, "Recognition delayed by grammar activity (loads or unloads of rules or slots). ");
        } else {
            this.finish();
        }
    }

    @Override
    public void terminate() {
        this.activityManager.removeObserver(this, ActivityType.GRAMMAR_UPDATE);
    }

    @Override
    public void abort() {
    }

    @Override
    public void onActivityIdle(ActivityType activityType) {
        this.finish();
    }

    @Override
    public void onActivityActive(ActivityType activityType) {
    }
}

