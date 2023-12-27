/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhonePresetsElement;
import java.util.NoSuchElementException;

public class PhonePresetsASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements PhonePresetsElement {
    public PhonePresetsASLDataPoolIterator() {
        super(1194);
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
    public long getPhonePresetEntryId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getLong(1, object);
    }

    @Override
    public int getPhonePresetNumberType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(7, object);
    }

    @Override
    public String getPhonePresetName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(2, object);
    }

    @Override
    public String getPhonePresetNumber() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(3, object);
    }

    @Override
    public boolean isPhonePresetEmpty() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getBoolean(5, object);
    }
}

