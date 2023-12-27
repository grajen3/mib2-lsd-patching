/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api.online;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;

public interface ServiceListService
extends InternalServiceProvider {
    public static final int[] SERVICE_CONSTANTS = new int[]{-1098514176, -1081736960};

    default public void blockService(String string, boolean bl) {
    }

    default public void blockServices(boolean bl) {
    }
}

