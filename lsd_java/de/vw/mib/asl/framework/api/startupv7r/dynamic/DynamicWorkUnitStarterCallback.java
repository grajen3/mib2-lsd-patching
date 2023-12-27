/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.startupv7r.dynamic;

import de.vw.mib.asl.framework.api.startupv7r.dynamic.DynamicWorkUnitStarterCallback$1;

public interface DynamicWorkUnitStarterCallback {
    public static final DynamicWorkUnitStarterCallback NO_CALLBACK = new DynamicWorkUnitStarterCallback$1();

    default public void onFinish() {
    }
}

