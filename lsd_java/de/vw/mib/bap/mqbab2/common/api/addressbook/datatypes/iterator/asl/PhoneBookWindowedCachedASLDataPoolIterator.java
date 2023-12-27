/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.PhoneBookWindowedASLDataPoolIterator;

public class PhoneBookWindowedCachedASLDataPoolIterator
extends PhoneBookWindowedASLDataPoolIterator {
    public static final int INVALID_LONG_VALUE;
    public static final int INVALID_INTEGER_VALUE;
    public static final String EMPTY_STRING_VALUE;

    public PhoneBookWindowedCachedASLDataPoolIterator(int[] nArray) {
        super(nArray);
    }

    @Override
    public long getContactEntryId() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactEntryId() : -1L;
    }

    @Override
    public String getContactName() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactName() : "";
    }

    @Override
    public int getContactEntryPos() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactEntryPos() : -1;
    }

    @Override
    public int getContactStorageType() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactStorageType() : -1;
    }

    @Override
    public int getContactAnyVoiceTag() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactAnyVoiceTag() : -1;
    }

    @Override
    public int getContactTelNumberCount() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactTelNumberCount() : -1;
    }

    @Override
    public int getContactEntryMetaData() {
        Object object = this.aslList.getRowItemCacheOnly(this.getCurrentIndex());
        return this.aslList.isValidItem(object) ? super.getContactEntryMetaData() : -1;
    }
}

