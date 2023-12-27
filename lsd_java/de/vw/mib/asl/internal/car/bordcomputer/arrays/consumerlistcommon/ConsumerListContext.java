/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import org.dsi.ifc.careco.DSICarEco;

public interface ConsumerListContext {
    public static final int CONTROLLER_CONSUMER_LIST;
    public static final int CONTROLLER_CONSUMER_LIST_CONSUMPTION;
    public static final int CONTROLLER_CONSUMER_LIST_RANGE;

    default public CarLogger getCarLogger() {
    }

    default public DSICarEco getDsiCarEco() {
    }

    default public ConsumerListController getConsumerListController(int n) {
    }
}

