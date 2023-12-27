/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.std2;

import de.vw.mib.asl.framework.api.diagnosis.config.Identification;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class IdentificationImpl
extends AccessImpl
implements Identification {
    public IdentificationImpl(byte[] byArray) {
        super(byArray, new int[]{29}, 553765890, 0);
        this.mConfiguration = new int[]{0, 0, 0, 30029, 88, 0, 0, 0, -1, 30029, 88, 11, 0, 0, -1, 0, 30029, 32, 22, 0, 15, -1, 0, 30029, 24, 26, 0, 22, -1, 10, 840, 9, 839, 3, 128, 128, 842, 23, 841, 16, 29};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

