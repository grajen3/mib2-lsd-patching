/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.dsrc.transformer;

import de.vw.mib.asl.api.vicsetc.ASLVICSETCFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.vicsetc.dsrc.transformer.AbstractVICSETCDSRCButtonInformationTransformer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCDSRCButtonInformationTransformer
extends AbstractVICSETCDSRCButtonInformationTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            TrafficMessage trafficMessage = (TrafficMessage)object;
            if (!trafficMessage.isValid) {
                return 1;
            }
            return 2;
        }
        if (n == 1) {
            TrafficMessage trafficMessage = (TrafficMessage)object;
            long l = ASLVICSETCFactory.getVICSETCApi().getCurrentSystemTime();
            long l2 = trafficMessage.getDate().getTime();
            if (ServiceManager.logger.isTraceEnabled(16)) {
                ServiceManager.logger.trace(16, new StringBuffer().append("Current time: ").append(l).append(", receiving time of message: ").append(l2).toString());
            }
            long l3 = l - l2;
            Date date = new Date(l3);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
            String string = simpleDateFormat.format(date);
            return Integer.parseInt(string);
        }
        throw new IllegalArgumentException();
    }
}

