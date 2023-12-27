/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer;

import de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.VICSETCFmGraphicButtonInformationCollector;
import generated.de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.AbstractVICSETCFmGraphicButtonInformationTransformer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCFmGraphicButtonInformationTransformer
extends AbstractVICSETCFmGraphicButtonInformationTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            return ((VICSETCFmGraphicButtonInformationCollector)object).getIndex();
        }
        if (n == 0) {
            TrafficMessage trafficMessage = ((VICSETCFmGraphicButtonInformationCollector)object).getTrafficMessage();
            if (!trafficMessage.isValid) {
                return 1;
            }
            return 2;
        }
        throw new IllegalArgumentException();
    }
}

