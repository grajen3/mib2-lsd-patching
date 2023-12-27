/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarExchangeProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSICalendarExchangeProxy$1
implements ISerializable {
    private final /* synthetic */ ResourceLocator[] val$destLocation;
    private final /* synthetic */ DSICalendarExchangeProxy this$0;

    DSICalendarExchangeProxy$1(DSICalendarExchangeProxy dSICalendarExchangeProxy, ResourceLocator[] resourceLocatorArray) {
        this.this$0 = dSICalendarExchangeProxy;
        this.val$destLocation = resourceLocatorArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$destLocation);
    }
}

