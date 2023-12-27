/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.transformer;

import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.AbstractCarFPKAvailableModesTransformer;

public class CarFPKAvailableModesTransformer
extends AbstractCarFPKAvailableModesTransformer {
    @Override
    public int getInt(int n, Object object) {
        Preset preset = (Preset)object;
        return preset.getTypeId();
    }

    @Override
    public long getLong(int n, Object object) {
        Preset preset = (Preset)object;
        return preset.getModel().getPos();
    }
}

