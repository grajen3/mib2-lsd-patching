/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCardParserReplyProxy$7
implements ISerializable {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ long[] val$failedEntryIDs;
    private final /* synthetic */ int val$listMode;
    private final /* synthetic */ String val$pathToVCards;
    private final /* synthetic */ int val$dsiInstanceID;
    private final /* synthetic */ VCardParserReplyProxy this$0;

    VCardParserReplyProxy$7(VCardParserReplyProxy vCardParserReplyProxy, int n, long[] lArray, int n2, String string, int n3) {
        this.this$0 = vCardParserReplyProxy;
        this.val$success = n;
        this.val$failedEntryIDs = lArray;
        this.val$listMode = n2;
        this.val$pathToVCards = string;
        this.val$dsiInstanceID = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$success);
        iSerializer.putOptionalInt64VarArray(this.val$failedEntryIDs);
        iSerializer.putInt32(this.val$listMode);
        iSerializer.putOptionalString(this.val$pathToVCards);
        iSerializer.putInt32(this.val$dsiInstanceID);
    }
}

