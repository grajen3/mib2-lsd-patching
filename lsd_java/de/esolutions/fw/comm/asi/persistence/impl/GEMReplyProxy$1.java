/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.impl.GEMReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class GEMReplyProxy$1
implements ISerializable {
    private final /* synthetic */ boolean val$gem_is_active;
    private final /* synthetic */ GEMReplyProxy this$0;

    GEMReplyProxy$1(GEMReplyProxy gEMReplyProxy, boolean bl) {
        this.this$0 = gEMReplyProxy;
        this.val$gem_is_active = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$gem_is_active);
    }
}

