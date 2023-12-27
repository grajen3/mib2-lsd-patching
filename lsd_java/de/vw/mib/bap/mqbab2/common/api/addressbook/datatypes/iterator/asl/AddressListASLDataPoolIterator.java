/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookAddressListElement;
import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import java.util.NoSuchElementException;

public class AddressListASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements AddressbookAddressListElement {
    public AddressListASLDataPoolIterator() {
        super(739);
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
    public String getFirstName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(6, object);
    }

    @Override
    public String getLastName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(7, object);
    }

    @Override
    public String getStreet() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(12, object);
    }

    @Override
    public String getCity() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(2, object);
    }

    @Override
    public String getRegion() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(11, object);
    }

    @Override
    public String getPostalCode() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(10, object);
    }

    @Override
    public String getCountry() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(4, object);
    }

    @Override
    public String getCoordinates() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(3, object);
    }

    @Override
    public String getPoiDescriptions() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(8, object);
    }

    @Override
    public int getPoiType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(9, object);
    }

    @Override
    public int getAddressType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getEntryPosition() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public long getContactEntryId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(1, object);
    }
}

