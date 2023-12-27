/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.system;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.contexts.system.SystemServices;

public class SystemServicesAdapter
implements SystemServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            default: 
        }
        throw HASException.invalidActionRequest(n2);
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            case 2: {
                this.getGMTOffset();
                break;
            }
            case 3: {
                this.getDrivingState();
                break;
            }
            case 4: {
                this.getDayNightState();
                break;
            }
            case 5: {
                this.getSkinInfo();
                break;
            }
            case 6: {
                this.getLanguageInfo();
                break;
            }
            case 9: {
                this.getVehicleIdentificationNumber();
                break;
            }
            case 10: {
                this.getSoftwareRevision();
                break;
            }
            case 11: {
                this.getOriginalEquipmentManufacturer();
                break;
            }
            case 12: {
                this.getMainDisplayDimension();
                break;
            }
            case 13: {
                this.getUnitDistance();
                break;
            }
            case 14: {
                this.getUnitVelocity();
                break;
            }
            case 15: {
                this.getUnitTemperature();
                break;
            }
            case 16: {
                this.getUnitPressure();
                break;
            }
            case 17: {
                this.getUnitFuelConsumption();
                break;
            }
            case 18: {
                this.getFormatTime();
                break;
            }
            case 19: {
                this.getFormatDate();
                break;
            }
            case 44: {
                this.getMainDisplayApproximity();
                break;
            }
            case 51: {
                this.getEncodedVehicleType();
                break;
            }
            case 59: {
                this.getAmbientLight();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void getGMTOffset() {
    }

    @Override
    public void getDrivingState() {
    }

    @Override
    public void getDayNightState() {
    }

    @Override
    public void getSkinInfo() {
    }

    @Override
    public void getLanguageInfo() {
    }

    @Override
    public void getVehicleIdentificationNumber() {
    }

    @Override
    public void getSoftwareRevision() {
    }

    @Override
    public void getOriginalEquipmentManufacturer() {
    }

    @Override
    public void getMainDisplayDimension() {
    }

    @Override
    public void getUnitDistance() {
    }

    @Override
    public void getUnitVelocity() {
    }

    @Override
    public void getUnitTemperature() {
    }

    @Override
    public void getUnitPressure() {
    }

    @Override
    public void getUnitFuelConsumption() {
    }

    @Override
    public void getFormatTime() {
    }

    @Override
    public void getFormatDate() {
    }

    @Override
    public void getMainDisplayApproximity() {
    }

    @Override
    public void getEncodedVehicleType() {
    }

    @Override
    public void getAmbientLight() {
    }
}

