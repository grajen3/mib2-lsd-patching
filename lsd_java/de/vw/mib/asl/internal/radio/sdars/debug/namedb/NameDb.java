/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.debug.namedb;

import de.vw.mib.asl.internal.radio.sdars.debug.namedb.INameDb;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public final class NameDb
implements INameDb {
    private final IntObjectMap mMap = new IntObjectOptHashMap(100);

    @Override
    public String getName(int n, int n2) {
        String string;
        IntObjectMap intObjectMap = (IntObjectMap)this.mMap.get(n);
        if (intObjectMap != null && (string = (String)intObjectMap.get(n2)) != null) {
            return string;
        }
        return Integer.toString(n2);
    }

    @Override
    public void putName(int n, int n2, String string) {
        IntObjectMap intObjectMap = (IntObjectMap)this.mMap.get(n);
        if (intObjectMap == null) {
            intObjectMap = new IntObjectOptHashMap(10);
            this.mMap.put(n, intObjectMap);
        }
        intObjectMap.put(n2, string);
    }
}

