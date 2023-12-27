/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager.core;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.Deactivation;

public interface ActivationRequest {
    default public Deactivation granted(Runnable runnable) {
    }

    default public void rejected() {
    }

    default public void cancel() {
    }

    default public int getContext() {
    }
}

