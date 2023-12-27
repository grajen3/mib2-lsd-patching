/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.FavoriteDestinationsWindowedASLDataPoolIterator;

public class FavoriteDestinationsWindowedCachedASLDataPoolIterator
extends FavoriteDestinationsWindowedASLDataPoolIterator {
    public static final int INVALID_LONG_VALUE;
    public static final int INVALID_INTEGER_VALUE;
    public static final String EMPTY_STRING_VALUE;

    public FavoriteDestinationsWindowedCachedASLDataPoolIterator(int[] nArray) {
        super(nArray);
    }

    @Override
    public long getContactEntryId() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactEntryId() : -1L;
    }

    @Override
    public int getPoiType() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getPoiType() : -1;
    }

    @Override
    public String getDescription() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getDescription() : "";
    }

    @Override
    public int getEntryPosition() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getEntryPosition() : -1;
    }
}

