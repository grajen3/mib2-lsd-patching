/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookPhoneBookElement;
import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import java.util.NoSuchElementException;

public class PhoneBookASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements AddressbookPhoneBookElement {
    public PhoneBookASLDataPoolIterator() {
        super(1109);
    }

    @Override
    public Object next() {
        if (this.currentIndex >= this.size || this.size == 0) {
            throw new NoSuchElementException();
        }
        ++this.currentIndex;
        return this;
    }

    @Override
    public long getContactEntryId() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getLong(1, object);
    }

    @Override
    public String getContactName() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getString(4, object);
    }

    @Override
    public int getContactEntryPos() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(3, object);
    }

    @Override
    public int getContactStorageType() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getContactAnyVoiceTag() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getContactTelNumberCount() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(6, object);
    }

    @Override
    public int getContactEntryMetaData() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(2, object);
    }
}

