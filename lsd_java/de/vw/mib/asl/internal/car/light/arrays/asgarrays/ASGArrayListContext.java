/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.asgarrays;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.bap.datatypes.ArrayHeader;

public interface ASGArrayListContext
extends CarLogger {
    default public void requestGetArray(int n, ArrayHeader arrayHeader, int n2) {
    }
}

