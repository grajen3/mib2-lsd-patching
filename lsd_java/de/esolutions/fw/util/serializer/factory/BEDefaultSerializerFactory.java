/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedDeserializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedSerializer;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.serializer.stream.BEDefaultDeserializer;
import de.esolutions.fw.util.serializer.stream.BEDefaultSerializer;

public class BEDefaultSerializerFactory
implements ISerializerFactory {
    @Override
    public IStreamDeserializer createStreamDeserializer() {
        return new BEDefaultDeserializer();
    }

    @Override
    public IStreamSerializer createStreamSerializer() {
        return new BEDefaultSerializer();
    }

    @Override
    public ISerializer createExtendedSerializer() {
        return new DefaultExtendedSerializer(this.createStreamSerializer());
    }

    @Override
    public IDeserializer createExtendedDeserializer() {
        return new DefaultExtendedDeserializer(this.createStreamDeserializer());
    }
}

