/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.thinkbluetiles;

import de.vw.mib.appadapter.thinkbluetiles.CarTBTConsumptionService;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListenerAdapter;
import java.util.ArrayList;

public class TBTBordComputerServiceListenerAdapter
extends BordComputerServiceListenerAdapter {
    private CarTBTConsumptionService client;

    public TBTBordComputerServiceListenerAdapter(CarTBTConsumptionService carTBTConsumptionService) {
        this.client = carTBTConsumptionService;
    }

    @Override
    public void updateBCMenu1(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() == 8) {
            int[] nArray = (int[])arrayList.get(2);
            this.client.updateCurrentConsumptionUnit(nArray[2]);
        }
    }

    void start() {
        ASLCarFactory.getBordComputerAPI().addServiceListener(this);
    }
}

