/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATTrafficMarketListTransformer;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class RadioSATTrafficMarketListTransformer
extends AbstractRadioSATTrafficMarketListTransformer {
    @Override
    public String getString(int n, Object object) {
        TrafficWxEntry trafficWxEntry = (TrafficWxEntry)object;
        switch (n) {
            case 0: {
                return trafficWxEntry.marketName;
            }
        }
        return "";
    }
}

