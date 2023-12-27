/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import de.vw.mib.collections.multi.AbstractUnlinkedMultiValueMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortedMultiValueMap
extends AbstractUnlinkedMultiValueMap {
    public SortedMultiValueMap(int n) {
        super(n);
    }

    public SortedMultiValueMap(int n, Comparator comparator, Comparator comparator2) {
        super(n, comparator, comparator2);
    }

    @Override
    protected Map createMap(Comparator comparator) {
        if (comparator == null) {
            return new TreeMap();
        }
        return new TreeMap(comparator);
    }
}

