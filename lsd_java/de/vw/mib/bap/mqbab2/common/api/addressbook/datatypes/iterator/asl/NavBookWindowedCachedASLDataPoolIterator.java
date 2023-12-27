/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.NavBookWindowedASLDataPoolIterator;

public class NavBookWindowedCachedASLDataPoolIterator
extends NavBookWindowedASLDataPoolIterator {
    public static final int INVALID_LONG_VALUE;
    public static final int INVALID_INTEGER_VALUE;
    public static final String EMPTY_STRING_VALUE;

    public NavBookWindowedCachedASLDataPoolIterator(int[] nArray) {
        super(nArray);
    }

    @Override
    public long getEntryId() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getEntryId() : -1L;
    }

    @Override
    public int getEntryPosition() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getEntryPosition() : -1;
    }

    @Override
    public String getFirstName() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getFirstName() : "";
    }

    @Override
    public String getLastName() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getLastName() : "";
    }
}

