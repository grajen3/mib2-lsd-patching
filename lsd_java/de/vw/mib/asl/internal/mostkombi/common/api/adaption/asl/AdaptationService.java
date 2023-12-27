/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.Adaptation;

public interface AdaptationService
extends Adaptation {
    default public int getMostCapabilityForMap() {
    }

    default public int getMostCapabilityForKdk() {
    }

    default public boolean isNavigationMapSwitchSupported() {
    }
}

