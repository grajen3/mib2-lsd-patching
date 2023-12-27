/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.AbstractTaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.log4mib.Logger;

public class TaskInvokerStopOnFailure
extends AbstractTaskInvoker {
    private boolean hasErrors = false;

    public TaskInvokerStopOnFailure(int n, Logger logger, String string) {
        super(n, logger, string);
    }

    @Override
    public void taskFinishedFlawed(Task task) {
        this.logger.warn(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("task finished FLAWED (stop invoking): ").append(task.toString()).toString());
        this.hasErrors = true;
        if (this.getInvokerListener() != null) {
            this.getInvokerListener().invokingStopped(this);
        }
    }

    @Override
    public boolean hasErrors() {
        return this.hasErrors;
    }
}

