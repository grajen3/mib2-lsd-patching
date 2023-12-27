/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi;

import de.vw.mib.asl.clientapi.ASLClientAPI;
import de.vw.mib.asl.clientapi.ASLClientAPIService;

public interface ASLClientAPIRegistry {
    public static final int DEFAULT_INSTANCE;

    default public void registerAPIService(Class clazz, int n, ASLClientAPIService aSLClientAPIService) {
    }

    default public ASLClientAPI getAPI(Class clazz, int n) {
    }
}

