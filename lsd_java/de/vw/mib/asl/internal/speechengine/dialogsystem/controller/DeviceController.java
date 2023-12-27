/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller;

import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemInitializer;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;

public abstract class DeviceController {
    protected final DialogSystemInitializer dialogSystemInitializer;
    protected final DialogSystemParameter dialogSystemParameter;
    protected final DialogSystemDiagnosisListener diagnosisListener;
    protected final ActivityManager activityManager;
    protected final ApplicationStateTracker applicationStateTracker;

    public DeviceController(DialogSystemParameter dialogSystemParameter, DialogSystemInitializer dialogSystemInitializer, DialogSystemDiagnosisListener dialogSystemDiagnosisListener, ActivityManager activityManager, ApplicationStateTracker applicationStateTracker) {
        this.dialogSystemParameter = dialogSystemParameter;
        this.dialogSystemInitializer = dialogSystemInitializer;
        this.diagnosisListener = dialogSystemDiagnosisListener;
        this.activityManager = activityManager;
        this.applicationStateTracker = applicationStateTracker;
    }

    public DialogSystemPublisher getDialogSystemPublisher() {
        return this.dialogSystemParameter.getDialogSystemPublisher();
    }

    public DialogSystemDiagnosisListener getDiagnosisListener() {
        return this.diagnosisListener;
    }

    public ActivityManager getActivityManager() {
        return this.activityManager;
    }

    public ApplicationStateTracker getApplicationStateTracker() {
        return this.applicationStateTracker;
    }

    public abstract void start() {
    }

    public abstract void onDeviceShutdown() {
    }

    public abstract void onDeviceRestart() {
    }
}

