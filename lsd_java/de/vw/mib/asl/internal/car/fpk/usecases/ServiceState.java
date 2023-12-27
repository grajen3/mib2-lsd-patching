/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases;

import de.vw.mib.asl.internal.car.fpk.usecases.ServiceStateListener;
import de.vw.mib.asl.internal.car.fpk.usecases.ServiceStateListener$ServiceStateResult;

public interface ServiceState
extends ServiceStateListener$ServiceStateResult {
    default public void subscribeServiceState(ServiceStateListener serviceStateListener) {
    }

    default public void unsubscribeServiceState(ServiceStateListener serviceStateListener) {
    }
}

