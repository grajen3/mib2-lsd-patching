/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.high2;

import de.vw.mib.asl.framework.api.diagnosis.config.RegionCode;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public class RegionCodeImpl
extends AccessImpl
implements RegionCode {
    public RegionCodeImpl(byte[] byArray) {
        super(byArray, new int[]{4}, 0, 0);
        this.mConfiguration = new int[]{20051, 8, 0, 0, 0, -1, 20051, 8, 1, 0, 0, -1, 20051, 8, 2, 0, 5, -1, 20051, 8, 3, 0, 5, -1, 10, 845, 12, 844, 6, 843, 0, 128, 128, 846, 18, 24};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

