/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.LEMiniIntSerializer;
import de.esolutions.fw.util.serializer.stream.DefaultSerializerBase;

public class LEDefaultSerializer
extends DefaultSerializerBase {
    public LEDefaultSerializer() {
        super(new LEMiniIntSerializer(), (byte)0);
    }
}

