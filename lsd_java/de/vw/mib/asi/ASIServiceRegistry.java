/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi;

import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.ASIService;

public interface ASIServiceRegistry {
    default public void registerService(Class clazz, int n, String string, ASIService aSIService, ASIProperties aSIProperties) {
    }

    default public void registerAllDevicesService(Class clazz, int n, ASIService aSIService, ASIProperties aSIProperties) {
    }

    default public void unregisterService(Class clazz, int n) {
    }
}

