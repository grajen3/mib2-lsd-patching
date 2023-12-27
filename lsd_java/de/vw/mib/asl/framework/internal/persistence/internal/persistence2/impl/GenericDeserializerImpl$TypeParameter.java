/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.GenericDeserializerImpl;

public class GenericDeserializerImpl$TypeParameter {
    private byte type;
    private int persistableId;
    private final /* synthetic */ GenericDeserializerImpl this$0;

    GenericDeserializerImpl$TypeParameter(GenericDeserializerImpl genericDeserializerImpl) {
        this.this$0 = genericDeserializerImpl;
    }

    byte getType() {
        return this.type;
    }

    void setType(byte by) {
        this.type = by;
    }

    int getPersistableId() {
        return this.persistableId;
    }

    void setPersistableId(int n) {
        this.persistableId = n;
    }
}

