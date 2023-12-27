/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class PoiAbstractHsmState
extends AbstractNavGatewayHsmState {
    public PoiAbstractHsmState(Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
    }
}

