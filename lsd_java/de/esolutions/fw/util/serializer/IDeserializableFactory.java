/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IDeserializable;
import de.esolutions.fw.util.serializer.IDeserializer;

public interface IDeserializableFactory {
    default public IDeserializable createDeserializable(IDeserializer iDeserializer) {
    }
}

