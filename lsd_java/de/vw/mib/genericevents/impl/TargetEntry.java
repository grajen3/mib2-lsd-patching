/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.TaskInterface;

final class TargetEntry {
    Target mTarget;
    private TaskInterface mTask;
    private int mTargetId;

    TargetEntry(int n, Target target, TaskInterface taskInterface) {
        this.mTarget = target;
        this.mTask = taskInterface;
    }

    int getTargetId() {
        return this.mTargetId;
    }

    Target getTarget() {
        return this.mTarget;
    }

    TaskInterface getTask() {
        return this.mTask;
    }
}

