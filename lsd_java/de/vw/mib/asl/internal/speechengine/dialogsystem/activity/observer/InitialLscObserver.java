/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.activity.observer;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.observer.InitialLscObserverCallback;

public class InitialLscObserver
implements ActivityObserver {
    private final ActivityManager activityManager;
    private final InitialLscObserverCallback callback;

    public InitialLscObserver(ActivityManager activityManager, InitialLscObserverCallback initialLscObserverCallback) {
        this.activityManager = activityManager;
        this.callback = initialLscObserverCallback;
    }

    public void startObserving() {
        this.activityManager.addObserver(this, ActivityType.LANGUAGE_CHANGE);
    }

    @Override
    public void onActivityIdle(ActivityType activityType) {
        if (ActivityType.LANGUAGE_CHANGE.equals(activityType)) {
            this.activityManager.removeObserver(this, ActivityType.LANGUAGE_CHANGE);
            this.callback.onLanguageSet();
        }
    }

    @Override
    public void onActivityActive(ActivityType activityType) {
    }
}

