/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCalendarDbProviderReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$res;
    private final /* synthetic */ VCalendarDbProviderReplyProxy this$0;

    VCalendarDbProviderReplyProxy$1(VCalendarDbProviderReplyProxy vCalendarDbProviderReplyProxy, int n) {
        this.this$0 = vCalendarDbProviderReplyProxy;
        this.val$res = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$res);
    }
}

