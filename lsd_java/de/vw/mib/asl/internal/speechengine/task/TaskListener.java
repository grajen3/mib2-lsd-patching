/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.Task;

public interface TaskListener {
    default public void taskFinishedSuccessful(Task task) {
    }

    default public void taskFinishedFlawed(Task task) {
    }

    default public void taskFinishedAborted(Task task) {
    }
}

