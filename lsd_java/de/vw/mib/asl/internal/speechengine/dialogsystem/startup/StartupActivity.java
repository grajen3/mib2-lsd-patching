/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.startup;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.Activity;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.observer.InitialLscObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.observer.InitialLscObserverCallback;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class StartupActivity
implements Activity,
InitialLscObserverCallback {
    private static final int TRACE_CLASS;
    private static final String TRACE_PREFIX;
    private final Logger logger;
    private final ActivityManager activityManager;
    private final InitialLscObserver firstLscObserver;
    private boolean isFirstLscFinished;
    private boolean areDevicesReady;

    public StartupActivity(Logger logger, ActivityManager activityManager) {
        this.activityManager = activityManager;
        this.logger = logger;
        this.isFirstLscFinished = false;
        this.areDevicesReady = false;
        this.firstLscObserver = new InitialLscObserver(this.activityManager, this);
        this.firstLscObserver.startObserving();
    }

    public void start() {
        if (this.logger.isTraceEnabled(8)) {
            LogMessage logMessage = this.logger.trace(8);
            logMessage.append("[StartupActivity] ");
            logMessage.append("start");
            logMessage.log();
        }
        this.activityManager.onActive(this);
    }

    private void finish() {
        if (this.areDevicesReady && this.isFirstLscFinished) {
            if (this.logger.isTraceEnabled(8)) {
                LogMessage logMessage = this.logger.trace(8);
                logMessage.append("[StartupActivity] ");
                logMessage.append("finish ");
                logMessage.log();
            }
            this.activityManager.onFinished(this);
        }
    }

    public void onDevicesReady() {
        if (this.logger.isTraceEnabled(8)) {
            LogMessage logMessage = this.logger.trace(8);
            logMessage.append("[StartupActivity] ");
            logMessage.append("onDevicesReady");
            logMessage.log();
        }
        this.areDevicesReady = true;
        this.finish();
    }

    @Override
    public ActivityType getType() {
        return ActivityType.STARTUP;
    }

    @Override
    public void onLanguageSet() {
        if (this.logger.isTraceEnabled(8)) {
            LogMessage logMessage = this.logger.trace(8);
            logMessage.append("[StartupActivity] ");
            logMessage.append("onLanguageSet");
            logMessage.log();
        }
        this.isFirstLscFinished = true;
        this.finish();
    }
}

