/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.setup.service;

import de.vw.mib.asl.internal.car.fpk.usecases.ServiceState;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElements;

public interface DisplaySetupService
extends ServiceState {
    default public DisplayElements getDisplayElements(int n) {
    }
}

