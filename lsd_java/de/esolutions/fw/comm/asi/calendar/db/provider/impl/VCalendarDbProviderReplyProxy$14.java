/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy;
import de.esolutions.fw.comm.dsi.calendar.impl.VEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VEvent;

class VCalendarDbProviderReplyProxy$14
implements ISerializable {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ VEvent[] val$summaries;
    private final /* synthetic */ VCalendarDbProviderReplyProxy this$0;

    VCalendarDbProviderReplyProxy$14(VCalendarDbProviderReplyProxy vCalendarDbProviderReplyProxy, int n, VEvent[] vEventArray) {
        this.this$0 = vCalendarDbProviderReplyProxy;
        this.val$success = n;
        this.val$summaries = vEventArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$success);
        VEventSerializer.putOptionalVEventVarArray(iSerializer, this.val$summaries);
    }
}

