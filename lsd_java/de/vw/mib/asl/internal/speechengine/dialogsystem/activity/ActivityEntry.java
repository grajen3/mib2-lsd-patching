/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.activity;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.Activity;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityObserver;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ActivityEntry {
    private HashSet activities = new HashSet();
    private HashSet observers = new HashSet();

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void addAllActivities(Collection collection) {
        this.activities.addAll(collection);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
    }

    public void removeAllActivities(Collection collection) {
        this.activities.removeAll(collection);
    }

    public void addObserver(ActivityObserver activityObserver) {
        this.observers.add(activityObserver);
    }

    public void addAllObservers(Collection collection) {
        this.observers.addAll(collection);
    }

    public void removeAllObservers(Collection collection) {
        this.observers.removeAll(collection);
    }

    public void removeObserver(ActivityObserver activityObserver) {
        this.observers.remove(activityObserver);
    }

    public void notifyIdle(Activity activity) {
        HashSet hashSet = (HashSet)this.observers.clone();
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            ActivityObserver activityObserver = (ActivityObserver)iterator.next();
            activityObserver.onActivityIdle(activity.getType());
        }
    }

    public void notifyActive(Activity activity) {
        HashSet hashSet = (HashSet)this.observers.clone();
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            ActivityObserver activityObserver = (ActivityObserver)iterator.next();
            activityObserver.onActivityActive(activity.getType());
        }
    }

    public Set getActivities() {
        return this.activities;
    }
}

