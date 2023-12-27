/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

import de.vw.mib.asl.internal.car.api.climate.modelclient.ClimateModelAdapter;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.caraircondition.DSICarAirCondition;

public interface ClimateTargetServices {
    public static final int LOGKEY_APPEND;
    public static final int LOGKEY_WARN;
    public static final int LOGKEY_LOG;
    public static final int LOGKEY_INFO;

    default public void writeToLog(int n, Object object) {
    }

    default public void registerOnUpdates(int n) {
    }

    default public void unregisterOnUpdates(int n) {
    }

    default public void triggerObserver(int n, EventGeneric eventGeneric) {
    }

    default public DSICarAirCondition getCarAirconDSI() {
    }

    default public ClimateModelAdapter getClimateModelAdapter() {
    }

    default public void sendHMIEvent(int n) {
    }
}

