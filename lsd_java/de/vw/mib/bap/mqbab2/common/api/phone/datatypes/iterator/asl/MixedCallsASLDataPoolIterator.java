/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneMixedCallsElement;
import java.util.NoSuchElementException;

public class MixedCallsASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements PhoneMixedCallsElement {
    public MixedCallsASLDataPoolIterator() {
        super(1107);
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
    public long getMixedCallEntryId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getLong(3, object);
    }

    @Override
    public int getMixedCallCallType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public String getMixedCallContactName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(1, object);
    }

    @Override
    public int getMixedCallNumberType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(8, object);
    }

    @Override
    public String getMixedCallTelNumber() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(7, object);
    }

    @Override
    public int getMixedCallDay() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getMixedCallMonth() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(6, object);
    }

    @Override
    public int getMixedCallYear() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(10, object);
    }

    @Override
    public int getMixedCallHour() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(4, object);
    }

    @Override
    public int getMixedCallMinute() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getMixedCallSecond() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(9, object);
    }
}

