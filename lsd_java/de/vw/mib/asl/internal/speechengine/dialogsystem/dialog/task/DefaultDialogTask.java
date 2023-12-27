/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task;

import de.vw.mib.asl.internal.speechengine.dialogsystem.task.DialogTask;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;

public abstract class DefaultDialogTask
extends AbstractTask
implements DialogTask {
    public DefaultDialogTask(Logger logger) {
        super(logger);
    }

    @Override
    public void onPttBargeIn() {
    }
}

