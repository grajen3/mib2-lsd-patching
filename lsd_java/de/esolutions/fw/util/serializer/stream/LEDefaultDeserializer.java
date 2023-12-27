/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.LEMiniIntDeserializer;
import de.esolutions.fw.util.serializer.stream.DefaultDeserializerBase;

public class LEDefaultDeserializer
extends DefaultDeserializerBase {
    public LEDefaultDeserializer() {
        super(new LEMiniIntDeserializer(), (byte)0);
    }
}

