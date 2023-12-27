/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;

class VCalendarDbProviderProxy$4
implements ISerializable {
    private final /* synthetic */ DateTime val$fromDate;
    private final /* synthetic */ DateTime val$toDate;
    private final /* synthetic */ VCalendarDbProviderProxy this$0;

    VCalendarDbProviderProxy$4(VCalendarDbProviderProxy vCalendarDbProviderProxy, DateTime dateTime, DateTime dateTime2) {
        this.this$0 = vCalendarDbProviderProxy;
        this.val$fromDate = dateTime;
        this.val$toDate = dateTime2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DateTimeSerializer.putOptionalDateTime(iSerializer, this.val$fromDate);
        DateTimeSerializer.putOptionalDateTime(iSerializer, this.val$toDate);
    }
}

