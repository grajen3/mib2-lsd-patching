/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.serializer.factory.ISerializerFactory;

public interface ISerializerFactoryProvider {
    default public ISerializerFactory createSerializerFactory(String string, String string2) {
    }

    default public ISerializerFactory createMySerializerFactory(String string, String string2) {
    }
}

