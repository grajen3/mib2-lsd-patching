/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.api.impl;

import de.vw.mib.asl.internal.car.fpk.api.CarFPKSetupAPI;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionService;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionServiceImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.service.DisplaySetupService;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.service.DisplaySetupServiceImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsService;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsServiceImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.settings.service.FactorySettings;
import de.vw.mib.asl.internal.car.fpk.usecases.settings.service.FactorySettingsImpl;

public class CarFPKSetupAPIImpl
implements CarFPKSetupAPI {
    DisplaySetupService displaySetupService = new DisplaySetupServiceImpl(this);
    ContentSelectionService contentSelectionService = new ContentSelectionServiceImpl(this);
    PresetsService presetService = new PresetsServiceImpl(this);
    FactorySettings factorySettings = new FactorySettingsImpl(this);

    @Override
    public DisplaySetupService getDisplaySetupService() {
        return this.displaySetupService;
    }

    @Override
    public PresetsService getPresetsService() {
        return this.presetService;
    }

    @Override
    public ContentSelectionService getContentSelectionService() {
        return this.contentSelectionService;
    }

    @Override
    public FactorySettings getFactorySettings() {
        return this.factorySettings;
    }
}

