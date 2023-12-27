/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.std2;

import de.vw.mib.asl.framework.api.diagnosis.config.DashboardDisplayConfig;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class DashboardDisplayConfigImpl
extends AccessImpl
implements DashboardDisplayConfig {
    public DashboardDisplayConfigImpl(byte[] byArray) {
        super(byArray, new int[]{10}, -536825343, 0);
        this.mConfiguration = new int[]{1091, 0, 5, 1, 0, 20051, 8, 0, 0, 0, 3, 1091, 0, 2, 1, 11, 20051, 8, 1, 0, 0, 14, 1091, 0, 3, 1, 22, 20051, 8, 2, 0, 0, 25, 20051, 8, 3, 0, 0, 3, 20051, 8, 4, 0, 0, 14, 20051, 8, 5, 0, 0, 25, 2029, 2, 0, 1, 1, 51, 10037, 1, 6, 0, 0, 55, 10037, 1, 6, 1, 0, 55, 10037, 1, 6, 2, 0, 55, 10037, 1, 6, 3, 0, 55, 10037, 1, 6, 4, 0, 55, 20051, 4, 7, 0, 0, -1, 26, 1173, 33, 1175, 75, 1176, 81, 1174, 57, 1218, 87, 128, 128, 177, 63, 174, 39, 1172, 5, 171, 16, 178, 69, 175, 45, 172, 27, 93};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

