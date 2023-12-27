/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.activity;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.Activity;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityEntry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import java.util.HashMap;
import java.util.Set;

public class ActivityManager {
    private HashMap activityEntryMap = new HashMap();

    private ActivityEntry getEntry(ActivityType activityType) {
        ActivityEntry activityEntry = (ActivityEntry)this.activityEntryMap.get(activityType);
        if (activityEntry == null) {
            activityEntry = new ActivityEntry();
            this.activityEntryMap.put(activityType, activityEntry);
        }
        return activityEntry;
    }

    public void onActive(Activity activity) {
        if (activity == null) {
            return;
        }
        ActivityEntry activityEntry = this.getEntry(activity.getType());
        activityEntry.addActivity(activity);
        activityEntry.notifyActive(activity);
    }

    public void onFinished(Activity activity) {
        ActivityEntry activityEntry = (ActivityEntry)this.activityEntryMap.get(activity.getType());
        if (activityEntry != null) {
            activityEntry.removeActivity(activity);
            if (!this.isRunning(activity.getType())) {
                activityEntry.notifyIdle(activity);
            }
        }
    }

    public boolean isRunning(ActivityType activityType) {
        ActivityEntry activityEntry = this.getEntry(activityType);
        Set set = activityEntry.getActivities();
        return !set.isEmpty();
    }

    public void addObserver(ActivityObserver activityObserver, ActivityType activityType) {
        if (activityObserver == null || activityType == null) {
            return;
        }
        ActivityEntry activityEntry = this.getEntry(activityType);
        activityEntry.addObserver(activityObserver);
        if (this.isRunning(activityType)) {
            activityObserver.onActivityActive(activityType);
        }
    }

    public void removeObserver(ActivityObserver activityObserver, ActivityType activityType) {
        if (activityObserver == null || activityType == null) {
            return;
        }
        ActivityEntry activityEntry = (ActivityEntry)this.activityEntryMap.get(activityType);
        if (activityEntry != null) {
            activityEntry.removeObserver(activityObserver);
        }
    }
}

