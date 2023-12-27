/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.messenger.backstack;

import de.vw.mib.asl.api.speechengine.messenger.backstack.BackstackStateConsumer;

public interface BackstackStateRouter {
    default public void register(BackstackStateConsumer backstackStateConsumer) {
    }

    default public void unregister(BackstackStateConsumer backstackStateConsumer) {
    }
}

