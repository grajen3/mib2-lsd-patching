/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.task;

import de.vw.mib.asl.internal.speechengine.task.Task;

public interface DialogTask
extends Task {
    default public void onPttBargeIn() {
    }
}

