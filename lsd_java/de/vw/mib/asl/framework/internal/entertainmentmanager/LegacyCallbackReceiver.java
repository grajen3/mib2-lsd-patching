/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;

public interface LegacyCallbackReceiver {
    default public void setOnActivated(Runnable runnable, AbsoluteActivation absoluteActivation) {
    }

    default public void setOnDeactivated(Runnable runnable) {
    }
}

