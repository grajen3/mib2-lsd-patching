/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.system.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;
import generated.de.vw.mib.has.contexts.system.SystemProperties;

public class SystemPropertiesImpl
extends AbstractContextProperties
implements SystemProperties {
    public SystemPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateGMTOffset(int n) {
        this.updateProperty(2, 2, n);
    }

    @Override
    public void updateDrivingState(boolean bl) {
        this.updateProperty(3, 3, bl);
    }

    @Override
    public void updateDayNightState(int n) {
        this.updateProperty(4, 4, n);
    }

    @Override
    public void updateSkinInfo(String string) {
        this.updateProperty(5, 5, string);
    }

    @Override
    public void updateLanguageInfo(String string) {
        this.updateProperty(6, 6, string);
    }

    @Override
    public void updateVehicleIdentificationNumber(String string) {
        this.updateProperty(9, 10, string);
    }

    @Override
    public void updateSoftwareRevision(String string) {
        this.updateProperty(10, 11, string);
    }

    @Override
    public void updateOriginalEquipmentManufacturer(String string) {
        this.updateProperty(11, 12, string);
    }

    @Override
    public void updateMainDisplayDimension(DisplayDimensionContainer displayDimensionContainer) {
        this.updateProperty(12, displayDimensionContainer);
    }

    @Override
    public void updateUnitDistance(String string) {
        this.updateProperty(13, 14, string);
    }

    @Override
    public void updateUnitVelocity(String string) {
        this.updateProperty(14, 15, string);
    }

    @Override
    public void updateUnitTemperature(String string) {
        this.updateProperty(15, 16, string);
    }

    @Override
    public void updateUnitPressure(String string) {
        this.updateProperty(16, 17, string);
    }

    @Override
    public void updateUnitFuelConsumption(String string) {
        this.updateProperty(17, 18, string);
    }

    @Override
    public void updateFormatTime(int n) {
        this.updateProperty(18, 19, n);
    }

    @Override
    public void updateFormatDate(String string) {
        this.updateProperty(19, 20, string);
    }

    @Override
    public void updateMainDisplayApproximity(boolean bl) {
        this.updateProperty(44, 47, bl);
    }

    @Override
    public void updateEncodedVehicleType(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
        this.updateProperty(51, encodedVehicleTypeContainer);
    }

    @Override
    public void updateAmbientLight(AmbientLightContainer ambientLightContainer) {
        this.updateProperty(59, ambientLightContainer);
    }
}

