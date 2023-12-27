/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api.online;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import java.util.List;

public interface ServiceListServiceListener {
    public static final int[] SERVICE_CONSTANTS = new int[]{-2091364608, -2108141824};

    default public void updateBlockedService(BAPArrayElement bAPArrayElement) {
    }

    default public void updateServiceListData(int n, List list) {
    }
}

