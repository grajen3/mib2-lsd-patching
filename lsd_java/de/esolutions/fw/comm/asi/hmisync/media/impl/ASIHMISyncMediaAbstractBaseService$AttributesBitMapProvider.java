/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import java.util.HashMap;

class ASIHMISyncMediaAbstractBaseService$AttributesBitMapProvider
implements IAttributeBitMapProvider {
    private final HashMap map = new HashMap();

    public ASIHMISyncMediaAbstractBaseService$AttributesBitMapProvider() {
        this.map.put(new Long(0), new Integer(0));
        this.map.put(new Long(0), new Integer(1));
        this.map.put(new Long(0), new Integer(2));
        this.map.put(new Long(0), new Integer(3));
        this.map.put(new Long(0), new Integer(4));
        this.map.put(new Long(0), new Integer(5));
        this.map.put(new Long(0), new Integer(6));
        this.map.put(new Long(0), new Integer(7));
        this.map.put(new Long(0), new Integer(8));
        this.map.put(new Long(0), new Integer(9));
        this.map.put(new Long(0), new Integer(10));
        this.map.put(new Long(0), new Integer(11));
        this.map.put(new Long(0), new Integer(12));
        this.map.put(new Long(0), new Integer(13));
        this.map.put(new Long(0), new Integer(14));
        this.map.put(new Long(0), new Integer(15));
    }

    @Override
    public int getAttributeBit(long l) {
        Integer n = (Integer)this.map.get(new Long(l));
        return n;
    }

    @Override
    public int getAttributesCount() {
        return 16;
    }
}

