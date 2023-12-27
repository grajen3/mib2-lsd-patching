/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.ASIServiceProvider;
import de.vw.mib.asi.instance.ASIInstanceResponse;

public interface ASIInstanceHandler {
    public static final int NO_INSTANCE;
    public static final String ALL_DEVICES_ID;

    default public void registerService(int n, String string, ASIService aSIService, ASIProperties aSIProperties) {
    }

    default public void requestInstanceId(String string, ASIInstanceResponse aSIInstanceResponse) {
    }

    default public void setServiceProvider(ASIServiceProvider aSIServiceProvider) {
    }

    default public void unregisterService(int n) {
    }
}

