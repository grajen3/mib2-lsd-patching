/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.MultiTask;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.log4mib.Logger;

public class RecognitionWithBackgroundPrompts
extends MultiTask {
    public RecognitionWithBackgroundPrompts(Logger logger) {
        super(logger);
    }

    @Override
    protected void onMasterTaskFinished(Task task) {
        super.onMasterTaskFinished(task);
        this.servantTaskInvoker.lock();
    }

    @Override
    protected void onFinished() {
        if (this.servantTaskInvoker.isIdle() && this.isMasterFinished) {
            this.runFinishResult.run();
        }
    }

    @Override
    protected int getMask() {
        return 32;
    }
}

