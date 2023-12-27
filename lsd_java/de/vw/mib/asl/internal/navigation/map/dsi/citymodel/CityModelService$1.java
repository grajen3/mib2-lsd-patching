/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.citymodel;

import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.navigation.map.dsi.citymodel.CityModelService;

class CityModelService$1
implements DriverDistractionPreventionThresholdListener {
    private final /* synthetic */ CityModelService this$0;

    CityModelService$1(CityModelService cityModelService) {
        this.this$0 = cityModelService;
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        this.this$0.updateCityModelMode(bl);
    }
}

