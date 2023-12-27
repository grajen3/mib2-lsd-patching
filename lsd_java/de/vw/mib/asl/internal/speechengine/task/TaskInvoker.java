/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;

public interface TaskInvoker {
    default public void setInvokerListener(TaskInvokerListener taskInvokerListener) {
    }

    default public void invoke() {
    }

    default public void halt() {
    }

    default public void abort() {
    }

    default public void abort(int n) {
    }

    default public void terminate() {
    }

    default public void add(Task task) {
    }

    default public void lock() {
    }

    default public void unlock() {
    }

    default public boolean isIdle() {
    }

    default public boolean isRunning() {
    }

    default public boolean hasErrors() {
    }

    default public Task getRunningTask() {
    }
}

