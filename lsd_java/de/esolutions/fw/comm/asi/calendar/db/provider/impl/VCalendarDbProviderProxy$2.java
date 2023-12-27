/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.CalendarConfig;

class VCalendarDbProviderProxy$2
implements ISerializable {
    private final /* synthetic */ CalendarConfig val$config;
    private final /* synthetic */ VCalendarDbProviderProxy this$0;

    VCalendarDbProviderProxy$2(VCalendarDbProviderProxy vCalendarDbProviderProxy, CalendarConfig calendarConfig) {
        this.this$0 = vCalendarDbProviderProxy;
        this.val$config = calendarConfig;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CalendarConfigSerializer.putOptionalCalendarConfig(iSerializer, this.val$config);
    }
}

