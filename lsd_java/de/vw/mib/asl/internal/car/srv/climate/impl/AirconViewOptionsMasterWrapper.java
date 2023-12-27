/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.climate.impl;

import de.vw.mib.asl.api.car.vo.climate.AirconViewOptionsMasterData;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;

public class AirconViewOptionsMasterWrapper
implements AirconViewOptionsMasterData {
    private AirconMasterViewOptions vo;

    public AirconViewOptionsMasterWrapper(AirconMasterViewOptions airconMasterViewOptions) {
        this.vo = airconMasterViewOptions;
    }

    @Override
    public AirconMasterViewOptions getAirconMasterVO() {
        return this.vo;
    }
}

