/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Map;

public final class ExifInfo
implements de.vw.mib.graphics.image.ExifInfo,
Cacheable {
    private final IntObjectMap map;
    private final int ifd;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$internal$ExifInfo;

    public ExifInfo(int n, int[] nArray, Map map) {
        this.map = new IntObjectOptHashMap(nArray.length);
        this.ifd = n;
        this.addAllExifValues(map, nArray);
    }

    @Override
    public int getByteSize() {
        return 0;
    }

    @Override
    public Object getExifValue(int n) {
        return this.map.get(n);
    }

    public boolean containsExifValue(int n) {
        return this.map.containsKey(n);
    }

    public boolean containsExifValues(int[] nArray) {
        if (!$assertionsDisabled && nArray == null) {
            throw new AssertionError();
        }
        boolean bl = true;
        for (int i2 = 0; bl && i2 < nArray.length; ++i2) {
            bl = this.containsExifValue(nArray[i2]);
        }
        return bl;
    }

    public void addAllExifValues(Map map, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.map.put(nArray[i2], map.get(new Integer(nArray[i2])));
        }
    }

    @Override
    public int getIfd() {
        return this.ifd;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$image$internal$ExifInfo == null ? (class$de$vw$mib$graphics$image$internal$ExifInfo = ExifInfo.class$("de.vw.mib.graphics.image.internal.ExifInfo")) : class$de$vw$mib$graphics$image$internal$ExifInfo).desiredAssertionStatus();
    }
}

