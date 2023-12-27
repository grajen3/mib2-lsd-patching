/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioTrafficMessageElement;
import java.util.NoSuchElementException;

public class TrafficMessageListASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements RadioTrafficMessageElement {
    public TrafficMessageListASLDataPoolIterator() {
        super(1466);
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
    public int getTrafficMessageID() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(7, object);
    }

    @Override
    public String getTrafficMessageStationName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(0, object);
    }

    @Override
    public int getTrafficMessageHour() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(1, object);
    }

    @Override
    public int getTrafficMessageMinute() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(2, object);
    }
}

