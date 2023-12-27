/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.arrays;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;

public interface ASLCarBAPArrayConverter {
    default public BAPChangedArray convertChangedArrayUpdateInfo(int n, int n2, int n3, int n4, boolean bl) {
    }

    default public BAPStatusArray convertStatusArrayResponse(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    default public int toArrayContent(BAPGetArray bAPGetArray) {
    }
}

