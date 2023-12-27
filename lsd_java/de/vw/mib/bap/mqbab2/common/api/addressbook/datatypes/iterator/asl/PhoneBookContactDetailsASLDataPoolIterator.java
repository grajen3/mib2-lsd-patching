/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookPhoneBookContactDetailsElement;
import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import java.util.NoSuchElementException;

public class PhoneBookContactDetailsASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements AddressbookPhoneBookContactDetailsElement {
    public PhoneBookContactDetailsASLDataPoolIterator() {
        super(1110);
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
    public long getContactDetailsEntryId() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getLong(0, object);
    }

    @Override
    public boolean getContactDetailsVoiceTag() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getBoolean(1, object);
    }

    @Override
    public String getContactDetailsNumber() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getString(2, object);
    }

    @Override
    public int getContactDetailsNumberType() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(3, object);
    }
}

