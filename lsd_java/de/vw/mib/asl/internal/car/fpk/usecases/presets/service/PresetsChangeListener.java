/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.service;

import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;

public interface PresetsChangeListener {
    default public void onPresetsUpdated(Preset[] presetArray) {
    }
}

