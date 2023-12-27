/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.Lifecycle;

public interface ILifecycleListener {
    default public void lifecycleChanged(Lifecycle lifecycle, Object object) {
    }
}

