/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserProxy;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.AdbEntry;

class VCardParserProxy$1
implements ISerializable {
    private final /* synthetic */ AdbEntry val$entry;
    private final /* synthetic */ String val$vcdFile;
    private final /* synthetic */ int val$dsiInstanceID;
    private final /* synthetic */ VCardParserProxy this$0;

    VCardParserProxy$1(VCardParserProxy vCardParserProxy, AdbEntry adbEntry, String string, int n) {
        this.this$0 = vCardParserProxy;
        this.val$entry = adbEntry;
        this.val$vcdFile = string;
        this.val$dsiInstanceID = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AdbEntrySerializer.putOptionalAdbEntry(iSerializer, this.val$entry);
        iSerializer.putOptionalString(this.val$vcdFile);
        iSerializer.putInt32(this.val$dsiInstanceID);
    }
}

