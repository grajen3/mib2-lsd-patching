/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.callstack;

import java.util.List;

public interface CallstackUpdates {
    default public void onUpdateMissed(List list) {
    }

    default public void onUpdateAccepted(List list) {
    }

    default public void onUpdateDialed(List list) {
    }

    default public void onUpdateMixed(List list) {
    }
}

