/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.std2;

import de.vw.mib.asl.framework.api.diagnosis.config.RegionCode;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public class RegionCodeImpl
extends AccessImpl
implements RegionCode {
    public RegionCodeImpl(byte[] byArray) {
        super(byArray, new int[]{0}, 0, 0);
        this.mConfiguration = new int[]{4, 128, 128, 128, 128, 0};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

