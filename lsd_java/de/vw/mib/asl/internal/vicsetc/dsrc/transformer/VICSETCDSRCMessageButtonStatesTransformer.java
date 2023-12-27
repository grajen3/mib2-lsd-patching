/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.dsrc.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.dsrc.transformer.AbstractVICSETCDSRCMessageButtonStatesTransformer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCDSRCMessageButtonStatesTransformer
extends AbstractVICSETCDSRCMessageButtonStatesTransformer {
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

