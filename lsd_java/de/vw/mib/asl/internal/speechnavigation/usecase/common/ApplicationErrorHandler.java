/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

public interface ApplicationErrorHandler {
    default public void onActionNotAvailable() {
    }

    default public void onActionFailed() {
    }
}

