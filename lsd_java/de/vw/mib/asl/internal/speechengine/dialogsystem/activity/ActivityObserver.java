/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.activity;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;

public interface ActivityObserver {
    default public void onActivityIdle(ActivityType activityType) {
    }

    default public void onActivityActive(ActivityType activityType) {
    }
}

