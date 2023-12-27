/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy;
import de.esolutions.fw.comm.dsi.calendar.impl.VEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VEvent;

class VCalendarDbProviderReplyProxy$13
implements ISerializable {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ VEvent val$calendarEntry;
    private final /* synthetic */ VCalendarDbProviderReplyProxy this$0;

    VCalendarDbProviderReplyProxy$13(VCalendarDbProviderReplyProxy vCalendarDbProviderReplyProxy, int n, VEvent vEvent) {
        this.this$0 = vCalendarDbProviderReplyProxy;
        this.val$success = n;
        this.val$calendarEntry = vEvent;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$success);
        VEventSerializer.putOptionalVEvent(iSerializer, this.val$calendarEntry);
    }
}

