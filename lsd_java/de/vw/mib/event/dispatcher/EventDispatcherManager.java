/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.dispatcher;

public interface EventDispatcherManager {
    default public void startMainDispatchingThread() {
    }

    default public void startStartupDispatchingThread() {
    }

    default public void stopMainDispatchingThread() {
    }

    default public void stopStartupDispatchingThread() {
    }
}

