/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.impl.ComponentProtectionReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ComponentProtectionReplyProxy$1
implements ISerializable {
    private final /* synthetic */ String val$challenge;
    private final /* synthetic */ String val$password;
    private final /* synthetic */ byte val$authResult;
    private final /* synthetic */ ComponentProtectionReplyProxy this$0;

    ComponentProtectionReplyProxy$1(ComponentProtectionReplyProxy componentProtectionReplyProxy, String string, String string2, byte by) {
        this.this$0 = componentProtectionReplyProxy;
        this.val$challenge = string;
        this.val$password = string2;
        this.val$authResult = by;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$challenge);
        iSerializer.putOptionalString(this.val$password);
        iSerializer.putInt8(this.val$authResult);
    }
}

