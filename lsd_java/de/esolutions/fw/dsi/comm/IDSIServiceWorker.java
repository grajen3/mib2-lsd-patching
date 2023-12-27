/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.comm;

import de.esolutions.fw.comm.core.IServiceWorker;

public interface IDSIServiceWorker
extends IServiceWorker {
    default public void start() {
    }

    default public void stop() {
    }

    default public int getUseCount() {
    }

    default public String getName() {
    }
}

