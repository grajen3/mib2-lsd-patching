/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.BEMiniIntDeserializer;
import de.esolutions.fw.util.serializer.stream.DefaultDeserializerBase;

public class BEDefaultDeserializer
extends DefaultDeserializerBase {
    public BEDefaultDeserializer() {
        super(new BEMiniIntDeserializer(), (byte)1);
    }
}

