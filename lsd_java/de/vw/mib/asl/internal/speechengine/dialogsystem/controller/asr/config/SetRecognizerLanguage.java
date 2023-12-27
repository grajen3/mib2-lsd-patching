/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.Activity;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;

public class SetRecognizerLanguage
extends AbstractTask
implements AsrLanguageChangeHandler,
Activity {
    private static final int TRACE_CLASS;
    private final AsrController asrController;
    private final String languageCode;
    private final int skinId;
    private final ActivityManager activityManager;
    private final int transactionId;
    private final DialogSystemConfigCallback callbackListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler;

    public SetRecognizerLanguage(Logger logger, AsrController asrController, String string, int n, ActivityManager activityManager, int n2, DialogSystemConfigCallback dialogSystemConfigCallback) {
        super(logger);
        this.asrController = asrController;
        this.languageCode = string;
        this.skinId = n;
        this.activityManager = activityManager;
        this.transactionId = n2;
        this.callbackListener = dialogSystemConfigCallback;
    }

    @Override
    public void execute() {
        this.activityManager.onActive(this);
        this.asrController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler = SetRecognizerLanguage.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler, this);
        this.asrController.getSpeechRec().setLanguage(this.languageCode, this.skinId);
    }

    @Override
    public void terminate() {
        this.asrController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler = SetRecognizerLanguage.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    protected int getMask() {
        return 32;
    }

    @Override
    public void responseSetLanguage(int n) {
        boolean bl;
        boolean bl2 = bl = n == 0;
        if (!bl) {
            this.taskLogger.error(4096, new StringBuffer().append("Error (will be ignored) in response of DSISpeechRecListener#responseSetLanguage: ").append(n).toString());
        }
        if (this.callbackListener != null) {
            this.callbackListener.setLanguageCallback(this.transactionId, bl);
        }
        this.activityManager.onFinished(this);
        this.notifyFinishedSuccessful();
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray) {
    }

    @Override
    public ActivityType getType() {
        return ActivityType.LANGUAGE_CHANGE;
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

