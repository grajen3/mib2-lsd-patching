/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.util.serializer.ISerializer;

public interface ICallMethodSerializeCallback {
    default public void beginSerializeCallMethodPayload(short s, short s2, ISerializer iSerializer) {
    }

    default public void endSerializeCallMethodPayload(short s, short s2, ISerializer iSerializer) {
    }
}

