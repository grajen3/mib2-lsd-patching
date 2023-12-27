/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneConferenceCallInformationsElement;
import java.util.NoSuchElementException;

public class ConferenceCallInformationsASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements PhoneConferenceCallInformationsElement {
    public ConferenceCallInformationsASLDataPoolIterator() {
        super(1160);
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
    public int getConferenceCallId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getConferenceTimeStamp() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(6, object);
    }

    @Override
    public int getConferenceNumberType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(4, object);
    }

    @Override
    public String getConferenceNumber() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(3, object);
    }

    @Override
    public String getConferenceName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(2, object);
    }

    @Override
    public int getConferenceCallState() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(12, object);
    }

    @Override
    public boolean getConferenceSplitAvailable() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getBoolean(10, object);
    }

    @Override
    public int getConferenceDisconnectReason() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(11, object);
    }
}

