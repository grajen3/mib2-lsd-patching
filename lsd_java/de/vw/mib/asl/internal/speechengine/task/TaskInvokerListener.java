/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;

public interface TaskInvokerListener {
    default public void invokingStopped(TaskInvoker taskInvoker) {
    }
}

