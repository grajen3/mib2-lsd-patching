/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.method;

import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.util.serializer.IDeserializer;

public interface IMethodHandler {
    default public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
    }
}

