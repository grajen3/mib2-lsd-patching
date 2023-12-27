/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.startupv7r.dynamic;

import de.vw.mib.asl.framework.api.startupv7r.dynamic.DynamicWorkUnitStarterCallback;

public interface DynamicWorkUnitStarter {
    default public void startDynamicWorkUnit(String string, DynamicWorkUnitStarterCallback dynamicWorkUnitStarterCallback) {
    }

    default public boolean checkDynamicWorkUnitExists(String string) {
    }
}

