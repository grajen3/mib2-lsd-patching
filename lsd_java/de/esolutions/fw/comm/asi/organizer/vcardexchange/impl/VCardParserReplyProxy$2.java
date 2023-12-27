/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.AdbEntry;

class VCardParserReplyProxy$2
implements ISerializable {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ AdbEntry[] val$entries;
    private final /* synthetic */ int val$dsiInstanceID;
    private final /* synthetic */ int val$destinationProfile;
    private final /* synthetic */ VCardParserReplyProxy this$0;

    VCardParserReplyProxy$2(VCardParserReplyProxy vCardParserReplyProxy, int n, AdbEntry[] adbEntryArray, int n2, int n3) {
        this.this$0 = vCardParserReplyProxy;
        this.val$success = n;
        this.val$entries = adbEntryArray;
        this.val$dsiInstanceID = n2;
        this.val$destinationProfile = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$success);
        AdbEntrySerializer.putOptionalAdbEntryVarArray(iSerializer, this.val$entries);
        iSerializer.putInt32(this.val$dsiInstanceID);
        iSerializer.putInt32(this.val$destinationProfile);
    }
}

