/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import de.vw.mib.collections.multi.AbstractUnlinkedMultiValueMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HashMultiValueMap
extends AbstractUnlinkedMultiValueMap {
    public HashMultiValueMap(int n) {
        super(n);
    }

    @Override
    protected Map createMap(Comparator comparator) {
        return new HashMap();
    }
}

