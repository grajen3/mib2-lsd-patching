/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneMissedCallsElement;
import java.util.NoSuchElementException;

public class MissedCallsASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements PhoneMissedCallsElement {
    public MissedCallsASLDataPoolIterator() {
        super(1105);
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
    public String getMissedCallContactName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(0, object);
    }

    @Override
    public long getMissedCallEntryId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getLong(1, object);
    }

    @Override
    public int getMissedCallNumberType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(7, object);
    }

    @Override
    public String getMissedCallTelNumber() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(6, object);
    }

    @Override
    public int getMissedCallDay() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(4, object);
    }

    @Override
    public int getMissedCallMonth() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getMissedCallYear() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(9, object);
    }

    @Override
    public int getMissedCallHour() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getMissedCallMinute() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(3, object);
    }

    @Override
    public int getMissedCallSecond() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(8, object);
    }
}

