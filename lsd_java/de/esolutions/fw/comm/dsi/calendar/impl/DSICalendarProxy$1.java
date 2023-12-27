/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarProxy;
import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;

class DSICalendarProxy$1
implements ISerializable {
    private final /* synthetic */ DateTime val$fromDate;
    private final /* synthetic */ DateTime val$toDate;
    private final /* synthetic */ DSICalendarProxy this$0;

    DSICalendarProxy$1(DSICalendarProxy dSICalendarProxy, DateTime dateTime, DateTime dateTime2) {
        this.this$0 = dSICalendarProxy;
        this.val$fromDate = dateTime;
        this.val$toDate = dateTime2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DateTimeSerializer.putOptionalDateTime(iSerializer, this.val$fromDate);
        DateTimeSerializer.putOptionalDateTime(iSerializer, this.val$toDate);
    }
}

