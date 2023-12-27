/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.CalendarConfig;

class VCalendarDbProviderReplyProxy$11
implements ISerializable {
    private final /* synthetic */ int val$res;
    private final /* synthetic */ CalendarConfig val$config;
    private final /* synthetic */ VCalendarDbProviderReplyProxy this$0;

    VCalendarDbProviderReplyProxy$11(VCalendarDbProviderReplyProxy vCalendarDbProviderReplyProxy, int n, CalendarConfig calendarConfig) {
        this.this$0 = vCalendarDbProviderReplyProxy;
        this.val$res = n;
        this.val$config = calendarConfig;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$res);
        CalendarConfigSerializer.putOptionalCalendarConfig(iSerializer, this.val$config);
    }
}

