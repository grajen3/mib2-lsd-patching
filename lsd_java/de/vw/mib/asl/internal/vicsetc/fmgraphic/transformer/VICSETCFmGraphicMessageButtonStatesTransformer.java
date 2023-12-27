/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.AbstractVICSETCFmGraphicMessageButtonStatesTransformer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCFmGraphicMessageButtonStatesTransformer
extends AbstractVICSETCFmGraphicMessageButtonStatesTransformer {
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

