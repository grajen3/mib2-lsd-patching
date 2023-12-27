/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.api.impl;

import de.vw.mib.asl.api.carplay.ASLCarplayServicesTelephonyState;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;

public class ASLCarplayServicesTelephonyStateImpl
implements ASLCarplayServicesTelephonyState {
    CarPlayGlobalProperies properties;

    public void setGlobalProperties(CarPlayGlobalProperies carPlayGlobalProperies) {
        this.properties = carPlayGlobalProperies;
    }

    @Override
    public boolean isTelephonyDataValid() {
        return this.properties != null && this.properties.isTelephonyStateValid();
    }

    @Override
    public String getMobileOperator() {
        if (this.properties != null && this.properties.getCurrentTelephonyState() != null) {
            return this.properties.getCurrentTelephonyState().getMobileOperator();
        }
        return null;
    }

    @Override
    public int getSignalStrength() {
        if (this.properties != null && this.properties.getCurrentTelephonyState() != null) {
            return this.properties.getCurrentTelephonyState().getSignalStrength();
        }
        return -1;
    }
}

