/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VersionInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCalendarDbProviderReplyProxy$7
implements ISerializable {
    private final /* synthetic */ VersionInfo[] val$versions;
    private final /* synthetic */ VCalendarDbProviderReplyProxy this$0;

    VCalendarDbProviderReplyProxy$7(VCalendarDbProviderReplyProxy vCalendarDbProviderReplyProxy, VersionInfo[] versionInfoArray) {
        this.this$0 = vCalendarDbProviderReplyProxy;
        this.val$versions = versionInfoArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        VersionInfoSerializer.putOptionalVersionInfoVarArray(iSerializer, this.val$versions);
    }
}

