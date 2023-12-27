/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import java.util.HashMap;

class ImageServerAbstractBaseService$AttributesBitMapProvider
implements IAttributeBitMapProvider {
    private final HashMap map = new HashMap();

    public ImageServerAbstractBaseService$AttributesBitMapProvider() {
        this.map.put(new Long(0), new Integer(0));
    }

    @Override
    public int getAttributeBit(long l) {
        Integer n = (Integer)this.map.get(new Long(l));
        return n;
    }

    @Override
    public int getAttributesCount() {
        return 1;
    }
}

