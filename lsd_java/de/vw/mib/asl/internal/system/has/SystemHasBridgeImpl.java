/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.has;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;
import generated.de.vw.mib.has.containers.impl.AmbientLightContainerImpl;
import generated.de.vw.mib.has.containers.impl.DisplayDimensionContainerImpl;
import generated.de.vw.mib.has.containers.impl.EncodedVehicleTypeContainerImpl;
import generated.de.vw.mib.has.contexts.system.SystemProperties;
import generated.de.vw.mib.has.contexts.system.SystemServicesAdapter;

public final class SystemHasBridgeImpl
extends SystemServicesAdapter
implements SystemHasBridge {
    private static SystemHasBridge myInstance;
    private SystemProperties systemProperties = null;
    private DisplayDimensionContainer propertyResolutionContainer = new DisplayDimensionContainerImpl();
    private EncodedVehicleTypeContainer encodedVehicleTypeContainer = new EncodedVehicleTypeContainerImpl();
    private AmbientLightContainer ambientLightContainer = new AmbientLightContainerImpl();

    public static SystemHasBridge getInstance() {
        if (myInstance == null) {
            myInstance = new SystemHasBridgeImpl();
        }
        return myInstance;
    }

    private SystemHasBridgeImpl() {
        HASContext hASContext = HAS.getInstance().getEngine().getRegistry().getContextByName("System");
        this.systemProperties = (SystemProperties)hASContext.getPropertiesImpl();
        hASContext.setServicesImpl(this);
    }

    @Override
    public void setPropertyDayNightState(int n) {
        int n2 = n == 0 ? 0 : 1;
        if (this.systemProperties != null) {
            this.systemProperties.updateDayNightState(n2);
        }
    }

    @Override
    public void setPropertyDrivingState(boolean bl) {
        if (this.systemProperties != null) {
            this.systemProperties.updateDrivingState(bl);
        }
    }

    @Override
    public void setPropertyGMTOffset(int n) {
        if (this.systemProperties != null) {
            this.systemProperties.updateGMTOffset(n);
        }
    }

    @Override
    public void setPropertyLanguageInfo(String string) {
        if (this.systemProperties != null) {
            this.systemProperties.updateLanguageInfo(string);
        }
    }

    @Override
    public void setPropertySkinInfo(String string) {
        if (this.systemProperties != null) {
            this.systemProperties.updateSkinInfo(string);
        } else {
            ServiceManager.logger.error(2048, "Local instance of class SystemProperties is null. No call of method updateSkinInfo.");
        }
    }

    @Override
    public void setPropertyDateFormat(int n) {
        String string = "dd.mm.yyyy";
        String string2 = "yyyy.mm.dd";
        String string3 = "mm.dd.yyyy";
        String string4 = "";
        switch (n) {
            case 0: {
                string4 = "dd.mm.yyyy";
                break;
            }
            case 1: {
                string4 = "yyyy.mm.dd";
                break;
            }
            case 2: {
                string4 = "mm.dd.yyyy";
                break;
            }
        }
        if (this.systemProperties != null) {
            this.systemProperties.updateFormatDate(string4);
        }
    }

    @Override
    public void setPropertyTimeFormat(int n) {
        int n2 = 12;
        int n3 = 24;
        int n4 = n == 0 ? 12 : 24;
        if (this.systemProperties != null) {
            this.systemProperties.updateFormatTime(n4);
        }
    }

    @Override
    public void setPropertyLiquidConsumptionUnit(int n) {
        String string = "l/100km";
        String string2 = "km/l";
        String string3 = "mpg_US";
        String string4 = "mpg_UK";
        String string5 = "";
        switch (n) {
            case 0: {
                string5 = "l/100km";
                break;
            }
            case 1: {
                string5 = "km/l";
                break;
            }
            case 2: {
                string5 = "mpg_US";
                break;
            }
            case 3: {
                string5 = "mpg_UK";
                break;
            }
        }
        if (this.systemProperties != null) {
            this.systemProperties.updateUnitFuelConsumption(string5);
        }
    }

    @Override
    public void setPropertyPressureUnit(int n) {
        String string = "kPa";
        String string2 = "bar";
        String string3 = "psi";
        String string4 = "";
        switch (n) {
            case 0: {
                string4 = "kPa";
                break;
            }
            case 1: {
                string4 = "bar";
                break;
            }
            case 2: {
                string4 = "psi";
                break;
            }
        }
        if (this.systemProperties != null) {
            this.systemProperties.updateUnitPressure(string4);
        }
    }

    @Override
    public void setPropertyTemperatureUnit(int n) {
        String string = "C";
        String string2 = "F";
        String string3 = "";
        switch (n) {
            case 0: {
                string3 = "C";
                break;
            }
            case 1: {
                string3 = "F";
                break;
            }
        }
        if (this.systemProperties != null) {
            this.systemProperties.updateUnitTemperature(string3);
        }
    }

    @Override
    public void setPropertyDistanceUnit(int n) {
        String string = "km";
        String string2 = "mi";
        String string3 = "";
        switch (n) {
            case 0: {
                string3 = "km";
                break;
            }
            case 1: {
                string3 = "mi";
                break;
            }
        }
        if (this.systemProperties != null) {
            this.systemProperties.updateUnitDistance(string3);
        }
    }

    @Override
    public void setPropertySpeedUnit(int n) {
        String string = "km/h";
        String string2 = "mph";
        String string3 = "";
        switch (n) {
            case 0: {
                string3 = "km/h";
                break;
            }
            case 1: {
                string3 = "mph";
                break;
            }
        }
        if (this.systemProperties != null) {
            this.systemProperties.updateUnitVelocity(string3);
        }
    }

    @Override
    public void setPropertyOriginalEquipmentManufacturer(int n) {
        String string = "vw";
        String string2 = "seat";
        String string3 = "skoda";
        String string4 = "";
        switch (n) {
            case 2: {
                string4 = "vw";
                break;
            }
            case 4: {
                string4 = "seat";
                break;
            }
            case 3: {
                string4 = "skoda";
                break;
            }
            default: {
                string4 = "vw";
            }
        }
        if (this.systemProperties != null) {
            this.systemProperties.updateOriginalEquipmentManufacturer(string4);
        }
    }

    @Override
    public void setPropertyXRes(int n) {
        this.propertyResolutionContainer.setHorizontalResolution(n);
        this.setMainDisplayDimensionInterally();
    }

    @Override
    public void setPropertyYRes(int n) {
        this.propertyResolutionContainer.setVerticalResolution(n);
        this.setMainDisplayDimensionInterally();
    }

    @Override
    public void setPropertySoftwareRevision(String string) {
        if (this.systemProperties != null) {
            this.systemProperties.updateSoftwareRevision(string);
        }
    }

    @Override
    public void setPropertyVIN(String string) {
        if (this.systemProperties != null) {
            this.systemProperties.updateVehicleIdentificationNumber(string);
        }
    }

    @Override
    public void setPropertyEncodedVehicleType(String string) {
        this.encodedVehicleTypeContainer.setType(string);
    }

    @Override
    public EncodedVehicleTypeContainer getEncodedVehicleTypeContainer() {
        return this.encodedVehicleTypeContainer;
    }

    @Override
    public void refreshEncodedVehicleTypeContainer() {
        if (this.systemProperties != null) {
            this.systemProperties.updateEncodedVehicleType(this.encodedVehicleTypeContainer);
        }
    }

    @Override
    public void setPropertyMainDisplayApproximity(boolean bl) {
        if (this.systemProperties != null) {
            this.systemProperties.updateMainDisplayApproximity(bl);
        }
    }

    @Override
    public void setPropertyColorSRGB(String string) {
        this.ambientLightContainer.setColorSRGB(string);
        this.setAmbientLightInterally();
    }

    @Override
    public void setPropertyColorHMI(String string) {
        this.ambientLightContainer.setColorHMI(string);
        this.setAmbientLightInterally();
    }

    private void setMainDisplayDimensionInterally() {
        if (this.propertyResolutionContainer.isValid()) {
            this.systemProperties.updateMainDisplayDimension(this.propertyResolutionContainer);
        }
    }

    private void setAmbientLightInterally() {
        if (this.ambientLightContainer.isValid()) {
            this.systemProperties.updateAmbientLight(this.ambientLightContainer);
        }
    }
}

