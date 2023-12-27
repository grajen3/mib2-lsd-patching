/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.AbstractTaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.log4mib.Logger;

public class TaskInvokerIgnoringErrors
extends AbstractTaskInvoker {
    public TaskInvokerIgnoringErrors(int n, Logger logger, String string) {
        super(n, logger, string);
    }

    @Override
    public void taskFinishedFlawed(Task task) {
        this.logger.warn(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("task finished FLAWED (ignoring this): ").append(task.toString()).toString());
        this.taskFinishedSuccessful(task);
    }

    @Override
    public boolean hasErrors() {
        return false;
    }
}

