/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import org.dsi.ifc.speechrec.NBestList;

public class DialogWatchdog
implements DialogListener,
Runnable {
    private static final int TRACE_CLASS;
    private static final String TRACE_PREFIX;
    private boolean isDialogActive;
    private Dialog dialog;
    private final Logger logger;
    private final TimerManager timerManager;
    private final Timer timer;
    private static final String TIMER_NAME;
    private static final long TIMER_DELAY;

    public DialogWatchdog(Logger logger, Dialog dialog, TimerManager timerManager, ThreadSwitchingTarget threadSwitchingTarget) {
        this.logger = logger;
        this.dialog = dialog;
        this.isDialogActive = false;
        this.timerManager = timerManager;
        this.timer = this.timerManager.createTimer("DialogWatchdogTimer", 0, false, this, threadSwitchingTarget);
    }

    void startWatching() {
        this.logger.trace(8, "[DIALOG_WATCHDOG] Watchdog starts observing a dialog. ");
        this.isDialogActive = true;
        this.dialog.addDialogListener(this);
    }

    @Override
    public void run() {
        this.countDownExpired();
    }

    private void countDownExpired() {
        if (this.isDialogActive) {
            this.logger.error(8, "[DIALOG_WATCHDOG] Watchdog will terminate dialog! ");
            this.dialog.terminate();
        }
    }

    void startCountDown() {
        this.logger.trace(8, "[DIALOG_WATCHDOG] count down started");
        if (this.isDialogActive && !this.timer.isStarted()) {
            this.timer.start();
        }
    }

    @Override
    public void onTerminated(Dialog dialog, int n) {
        this.isDialogActive = false;
        if (this.timer.isStarted()) {
            this.logger.trace(8, "[DIALOG_WATCHDOG] Watchdog timer stopped (because dialog terminated).");
            this.timer.stop();
        }
    }

    @Override
    public void onStarted(Dialog dialog, int n) {
    }

    @Override
    public void onIdle(Dialog dialog) {
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

