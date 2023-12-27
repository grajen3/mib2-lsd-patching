/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.vw.mib.asi.car.climate.ASICarClimateResponse;

class ASICarClimateBaseServiceImpl$ResponseProxy
implements ASICarClimateResponse {
    private final ASIHMISyncCarClimateReply delegate;

    static ASICarClimateBaseServiceImpl$ResponseProxy get(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        return new ASICarClimateBaseServiceImpl$ResponseProxy(aSIHMISyncCarClimateReply);
    }

    private ASICarClimateBaseServiceImpl$ResponseProxy(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        this.delegate = aSIHMISyncCarClimateReply;
    }
}

