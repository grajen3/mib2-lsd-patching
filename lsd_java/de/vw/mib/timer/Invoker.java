/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer;

import de.vw.mib.threads.MIBInvoker;

public interface Invoker
extends MIBInvoker {
    @Override
    default public void invoke(Runnable runnable) {
    }
}

