/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.events.framework;

import de.vw.mib.asl.internal.speechgeneral.events.framework.EventHandler;

public interface EventDispatcher {
    default public void registerHandler(EventHandler eventHandler) {
    }
}

