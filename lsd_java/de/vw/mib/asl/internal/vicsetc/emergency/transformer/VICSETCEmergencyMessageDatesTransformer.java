/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.emergency.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.emergency.transformer.AbstractVICSETCEmergencyMessageDatesTransformer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCEmergencyMessageDatesTransformer
extends AbstractVICSETCEmergencyMessageDatesTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            TrafficMessage trafficMessage = (TrafficMessage)object;
            long l = new Date().getTime() - trafficMessage.getDate().getTime();
            Date date = new Date(l);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
            String string = simpleDateFormat.format(date);
            return Integer.parseInt(string);
        }
        throw new IllegalArgumentException();
    }
}

