/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.service;

import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsServiceImpl;
import java.util.Comparator;

class PresetsServiceImpl$1
implements Comparator {
    private final /* synthetic */ PresetsServiceImpl this$0;

    PresetsServiceImpl$1(PresetsServiceImpl presetsServiceImpl) {
        this.this$0 = presetsServiceImpl;
    }

    @Override
    public int compare(Object object, Object object2) {
        int n;
        Preset preset = (Preset)object;
        Preset preset2 = (Preset)object2;
        int n2 = preset.getModel().getType();
        if (n2 > (n = preset2.getModel().getType())) {
            return -1;
        }
        if (n2 < n) {
            return 1;
        }
        return 0;
    }
}

