/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.light;

import de.vw.mib.asl.api.car.vo.light.ExtLightViewOptionsData;
import de.vw.mib.asl.api.car.vo.light.IntLightViewOptionsData;

public interface LightViewOptionListener {
    default public void updateIntLightViewOptions(IntLightViewOptionsData intLightViewOptionsData, int n) {
    }

    default public void updateExtLightViewOptions(ExtLightViewOptionsData extLightViewOptionsData, int n) {
    }

    default public void updateAmbienceLightIsCoded() {
    }

    default public void updateIntLightDevice(int n) {
    }

    default public void updateExtLightDevice(int n) {
    }
}

