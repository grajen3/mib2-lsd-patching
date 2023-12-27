/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IDeserializable;
import de.esolutions.fw.util.serializer.IDeserializableFactory;

public interface IDeserializableArrayFactory
extends IDeserializableFactory {
    default public IDeserializable[] createDeserializableArray(int n) {
    }
}

