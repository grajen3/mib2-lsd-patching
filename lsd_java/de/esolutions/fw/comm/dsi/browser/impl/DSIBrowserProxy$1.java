/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserProxy;
import de.esolutions.fw.comm.dsi.browser.impl.TimePeriodSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.TimePeriod;

class DSIBrowserProxy$1
implements ISerializable {
    private final /* synthetic */ TimePeriod val$timePeriod;
    private final /* synthetic */ DSIBrowserProxy this$0;

    DSIBrowserProxy$1(DSIBrowserProxy dSIBrowserProxy, TimePeriod timePeriod) {
        this.this$0 = dSIBrowserProxy;
        this.val$timePeriod = timePeriod;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TimePeriodSerializer.putOptionalTimePeriod(iSerializer, this.val$timePeriod);
    }
}

