/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.car;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.contexts.car.CarServices;

public class CarServicesAdapter
implements CarServices {
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
            case 42: {
                this.getCurrentThinkBlue();
                break;
            }
            case 52: {
                this.getThinkBlueEvent();
                break;
            }
            case 56: {
                this.getVehicleStates();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void getCurrentThinkBlue() {
    }

    @Override
    public void getThinkBlueEvent() {
    }

    @Override
    public void getVehicleStates() {
    }
}

