/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.api;

import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionService;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.service.DisplaySetupService;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsService;
import de.vw.mib.asl.internal.car.fpk.usecases.settings.service.FactorySettings;

public interface CarFPKSetupAPI {
    default public DisplaySetupService getDisplaySetupService() {
    }

    default public PresetsService getPresetsService() {
    }

    default public ContentSelectionService getContentSelectionService() {
    }

    default public FactorySettings getFactorySettings() {
    }
}

