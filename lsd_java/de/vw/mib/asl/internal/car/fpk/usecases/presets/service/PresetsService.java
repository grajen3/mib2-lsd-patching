/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.service;

import de.vw.mib.asl.internal.car.fpk.usecases.ServiceState;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;

public interface PresetsService
extends ServiceState {
    default public Preset getSelectedPreset() {
    }

    default public Preset[] getPresets() {
    }

    default public void selectPresetById(int n) {
    }

    default public void selectPresetByIndex(int n) {
    }

    default public void savePreset(int n, ContentSelection[] contentSelectionArray) {
    }

    default public boolean isPredefinedPresetSelected() {
    }
}

