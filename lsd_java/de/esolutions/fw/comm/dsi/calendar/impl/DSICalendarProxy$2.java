/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.CalendarConfig;

class DSICalendarProxy$2
implements ISerializable {
    private final /* synthetic */ CalendarConfig val$config;
    private final /* synthetic */ DSICalendarProxy this$0;

    DSICalendarProxy$2(DSICalendarProxy dSICalendarProxy, CalendarConfig calendarConfig) {
        this.this$0 = dSICalendarProxy;
        this.val$config = calendarConfig;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CalendarConfigSerializer.putOptionalCalendarConfig(iSerializer, this.val$config);
    }
}

