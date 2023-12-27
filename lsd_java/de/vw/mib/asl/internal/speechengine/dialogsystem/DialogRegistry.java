/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.speechrec.NBestList;

public class DialogRegistry
implements ActivityObserver,
DialogListener {
    private final int TRACE_CLASS;
    private final String TRACE_PREFIX;
    private final Logger logger;
    private final ActivityManager activityManager;
    private List dialogs;

    DialogRegistry(Logger logger, ActivityManager activityManager) {
        this.TRACE_CLASS = 8;
        this.TRACE_PREFIX = "[DialogRegistry] ";
        this.logger = logger;
        this.activityManager = activityManager;
        this.dialogs = new LinkedList();
        this.activityManager.addObserver(this, ActivityType.RESTART_ASR);
        this.activityManager.addObserver(this, ActivityType.RESTART_TTS);
    }

    void addDialog(Dialog dialog) {
        if (dialog != null) {
            this.dialogs.add(dialog);
        }
    }

    private void removeDialog(Dialog dialog) {
        if (dialog != null) {
            this.dialogs.remove(dialog);
        }
    }

    public void killDialogs() {
        LogMessage logMessage = this.logger.warn(8);
        logMessage.append("[DialogRegistry] ");
        logMessage.append("killing all dialogs ...");
        logMessage.append(this.toString());
        logMessage.log();
        ArrayList arrayList = new ArrayList(this.dialogs);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((Dialog)iterator.next()).terminate();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("DialogRegistry( ");
        stringBuffer.append(" dialogs:[ ");
        Iterator iterator = this.dialogs.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next().toString());
            if (!iterator.hasNext()) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(" ]");
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }

    @Override
    public void onActivityIdle(ActivityType activityType) {
    }

    @Override
    public void onActivityActive(ActivityType activityType) {
        if (ActivityType.RESTART_ASR.equals(activityType) || ActivityType.RESTART_TTS.equals(activityType)) {
            this.killDialogs();
        }
    }

    @Override
    public void onIdle(Dialog dialog) {
    }

    @Override
    public void onStarted(Dialog dialog, int n) {
    }

    @Override
    public void onTerminated(Dialog dialog, int n) {
        this.removeDialog(dialog);
    }

    @Override
    public void onUtteranceFinished() {
    }

    @Override
    public void onRecognitionFinished(int n, NBestList nBestList) {
    }

    @Override
    public void onPromptStarted(int n) {
    }

    @Override
    public void onPromptSpoken(int n) {
    }

    @Override
    public void onPauseStarted() {
    }

    @Override
    public void onPauseFinished() {
    }

    @Override
    public void onEndStarted(Dialog dialog) {
    }
}

