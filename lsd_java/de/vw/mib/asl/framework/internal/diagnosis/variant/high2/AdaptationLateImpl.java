/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.high2;

import de.vw.mib.asl.framework.api.diagnosis.config.AdaptationLate;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class AdaptationLateImpl
extends AccessImpl
implements AdaptationLate {
    public AdaptationLateImpl(byte[] byArray) {
        super(byArray, new int[]{256}, -536825343, 0);
        this.mConfiguration = new int[]{2029, 2, 0, 1, 1, 0, 10037, 1, 0, 0, 0, 4, 10037, 1, 0, 1, 0, 4, 10037, 1, 0, 2, 0, 4, 10037, 1, 0, 3, 0, 4, 10037, 1, 0, 4, 0, 4, 10037, 1, 0, 5, 0, 4, 10037, 1, 0, 6, 0, 4, 10037, 1, 0, 7, 0, 4, 10037, 1, 1, 0, 0, 4, 10037, 1, 1, 1, 0, 4, 10037, 1, 1, 2, 0, 4, 20051, 24, 2, 0, 0, 4, 813183024, 30029, 2008, 5, 0, 78, -1, 34, 1241, 18, 128, 128, 1250, 24, 1246, 48, 128, 128, 128, 128, 128, 128, 1247, 54, 1243, 30, 1239, 6, 1252, 72, 1248, 60, 1244, 36, 1240, 12, 1213, 79, 1249, 66, 1245, 42, 85};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

