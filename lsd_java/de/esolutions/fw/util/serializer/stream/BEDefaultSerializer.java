/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.BEMiniIntSerializer;
import de.esolutions.fw.util.serializer.stream.DefaultSerializerBase;

public class BEDefaultSerializer
extends DefaultSerializerBase {
    public BEDefaultSerializer() {
        super(new BEMiniIntSerializer(), (byte)1);
    }
}

