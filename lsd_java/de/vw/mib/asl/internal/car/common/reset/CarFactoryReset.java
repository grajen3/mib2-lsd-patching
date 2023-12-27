/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.common.reset;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.internal.car.api.reset.CarFactoryResetInterface;
import de.vw.mib.asl.internal.car.api.reset.CarFactoryResetListener;
import de.vw.mib.asl.internal.car.common.reset.CarFactoryReset$1;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;

public final class CarFactoryReset
implements FactoryResetListener,
CarFactoryResetInterface {
    private static final CarFactoryReset INSTANCE = new CarFactoryReset();
    private FactoryResetService service;
    private boolean resetIsDirty;
    ObjectArrayList listeners = new ObjectArrayList();

    private CarFactoryReset() {
        this.service = ASLSystemFactory.getSystemApi().getFactoryResetService();
        this.service.addParticipant(new CarFactoryReset$1(this), FactoryResetComponents.CAR);
        this.service.addListener(this);
    }

    public static CarFactoryReset getInstance() {
        return INSTANCE;
    }

    public void resetCarComponent() {
        if (this.service.getFactoryResetState() == 0) {
            this.service.reset(FactoryResetComponents.CAR, 0);
        } else {
            this.resetIsDirty = true;
        }
    }

    @Override
    public void onFactoryResetStateChanged(int n) {
        if (n == 0 && this.resetIsDirty) {
            this.resetIsDirty = false;
        }
    }

    void resetListeners() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            CarFactoryResetListener carFactoryResetListener = (CarFactoryResetListener)iterator.next();
            carFactoryResetListener.reset();
        }
    }

    @Override
    public void addListener(CarFactoryResetListener carFactoryResetListener) {
        this.listeners.add(carFactoryResetListener);
    }

    @Override
    public void removeListener(CarFactoryResetListener carFactoryResetListener) {
        this.listeners.removeValue(carFactoryResetListener);
    }
}

