/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.fmtext.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.fmtext.transformer.AbstractVICSETCFmTextMessageTopicsTransformer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCFmTextMessageTopicsTransformer
extends AbstractVICSETCFmTextMessageTopicsTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            TrafficMessage trafficMessage = (TrafficMessage)object;
            return trafficMessage.value;
        }
        throw new IllegalArgumentException();
    }
}

