/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.light;

import de.vw.mib.asl.api.car.vo.light.LightViewOptionListener;

public interface LightViewOptionService {
    default public void addListener(LightViewOptionListener lightViewOptionListener) {
    }

    default public void removeListener(LightViewOptionListener lightViewOptionListener) {
    }
}

