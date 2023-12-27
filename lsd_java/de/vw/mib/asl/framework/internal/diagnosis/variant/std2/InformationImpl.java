/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.std2;

import de.vw.mib.asl.framework.api.diagnosis.config.Information;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class InformationImpl
extends AccessImpl
implements Information {
    public InformationImpl(byte[] byArray) {
        super(byArray, new int[]{4}, -1945800920, 0);
        this.mConfiguration = new int[]{20051, 4, 0, 0, 0, -1, 20051, 2, 1, 0, 0, -1, 10037, 1, 2, 0, 0, -1, 10, 128, 128, 128, 128, 1193, 6, 1192, 0, 1201, 12, 18};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

