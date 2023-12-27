/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeService;

public interface PropagatingValetParkingTestmodeService
extends ValetParkingTestmodeService {
    default public void onValetParkingChanged() {
    }
}

