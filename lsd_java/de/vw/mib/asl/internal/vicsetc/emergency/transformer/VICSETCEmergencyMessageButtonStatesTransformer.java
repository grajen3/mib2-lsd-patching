/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.emergency.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.emergency.transformer.AbstractVICSETCEmergencyMessageButtonStatesTransformer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCEmergencyMessageButtonStatesTransformer
extends AbstractVICSETCEmergencyMessageButtonStatesTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            TrafficMessage trafficMessage = (TrafficMessage)object;
            if (!trafficMessage.isValid) {
                return 1;
            }
            return 2;
        }
        throw new IllegalArgumentException();
    }
}

