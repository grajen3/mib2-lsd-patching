/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import java.util.HashMap;

class ASIHMISyncMediaBrowserAbstractBaseService$AttributesBitMapProvider
implements IAttributeBitMapProvider {
    private final HashMap map = new HashMap();

    public ASIHMISyncMediaBrowserAbstractBaseService$AttributesBitMapProvider() {
        this.map.put(new Long(0), new Integer(0));
        this.map.put(new Long(0), new Integer(1));
        this.map.put(new Long(0), new Integer(2));
        this.map.put(new Long(0), new Integer(3));
        this.map.put(new Long(0), new Integer(4));
        this.map.put(new Long(0), new Integer(5));
        this.map.put(new Long(0), new Integer(6));
        this.map.put(new Long(0), new Integer(7));
        this.map.put(new Long(0), new Integer(8));
    }

    @Override
    public int getAttributeBit(long l) {
        Integer n = (Integer)this.map.get(new Long(l));
        return n;
    }

    @Override
    public int getAttributesCount() {
        return 9;
    }
}

