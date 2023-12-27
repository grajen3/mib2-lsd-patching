/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.TaskListener;

public interface Task {
    public static final int MASK_ALL;
    public static final int MASK_NONE;
    public static final int MASK_RECOGNITION;
    public static final int MASK_PROMPT;
    public static final int MASK_PAUSE;
    public static final int MASK_END;
    public static final int MASK_BEGIN;
    public static final int MASK_LSC;
    public static final int MASK_BACKGROUND_PROMT;

    default public void addListener(TaskListener taskListener) {
    }

    default public void removeListener(TaskListener taskListener) {
    }

    default public void execute() {
    }

    default public void terminate() {
    }

    default public void abort() {
    }

    default public boolean matchMask(int n) {
    }
}

