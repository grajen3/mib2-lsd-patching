/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneCallForwardingsElement;
import java.util.NoSuchElementException;

public class CallForwardingsASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements PhoneCallForwardingsElement {
    public CallForwardingsASLDataPoolIterator() {
        super(1210);
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
    public int getCallForwardingId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getCallForwardingState() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(2, object);
    }
}

