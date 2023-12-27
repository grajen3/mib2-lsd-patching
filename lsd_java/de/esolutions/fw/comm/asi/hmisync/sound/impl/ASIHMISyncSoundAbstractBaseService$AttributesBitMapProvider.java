/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import java.util.HashMap;

class ASIHMISyncSoundAbstractBaseService$AttributesBitMapProvider
implements IAttributeBitMapProvider {
    private final HashMap map = new HashMap();

    public ASIHMISyncSoundAbstractBaseService$AttributesBitMapProvider() {
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
        this.map.put(new Long(0), new Integer(16));
        this.map.put(new Long(0), new Integer(17));
        this.map.put(new Long(0), new Integer(18));
        this.map.put(new Long(0), new Integer(19));
        this.map.put(new Long(0), new Integer(20));
        this.map.put(new Long(0), new Integer(21));
        this.map.put(new Long(0), new Integer(22));
        this.map.put(new Long(0), new Integer(23));
        this.map.put(new Long(0), new Integer(24));
    }

    @Override
    public int getAttributeBit(long l) {
        Integer n = (Integer)this.map.get(new Long(l));
        return n;
    }

    @Override
    public int getAttributesCount() {
        return 25;
    }
}

