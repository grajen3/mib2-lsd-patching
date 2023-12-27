/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator;

import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements.CarPlayCall;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CarPlayCallIterator
implements Iterator,
CarPlayCall {
    ASLCarplayServicesCallState[] callStates;
    String[] mappedCallIds;
    private int currentIndex = -1;

    public CarPlayCallIterator(ASLCarplayServicesCallState[] aSLCarplayServicesCallStateArray, String[] stringArray) {
        this.callStates = aSLCarplayServicesCallStateArray;
        this.mappedCallIds = stringArray;
    }

    @Override
    public boolean hasNext() {
        return this.callStates != null && this.currentIndex + 1 < this.callStates.length;
    }

    @Override
    public Object next() {
        if (this.callStates == null || this.currentIndex + 1 >= this.callStates.length) {
            throw new NoSuchElementException();
        }
        ++this.currentIndex;
        return this;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getUniqueCarPlayCallID() {
        return this.callStates[this.currentIndex].getUniqueCallID();
    }

    @Override
    public int getMappedCallID() {
        int n = -1;
        for (int i2 = 0; i2 < this.mappedCallIds.length; ++i2) {
            if (this.mappedCallIds[i2] == null || !this.mappedCallIds[i2].equals(this.getUniqueCarPlayCallID())) continue;
            n = i2;
            break;
        }
        return n;
    }

    @Override
    public String getPhoneNumber() {
        return this.callStates[this.currentIndex].getPhoneNumber();
    }

    @Override
    public String getCallerName() {
        return this.callStates[this.currentIndex].getCallerName();
    }

    @Override
    public int getStatus() {
        return this.callStates[this.currentIndex].getStatus();
    }

    @Override
    public int getDirection() {
        return this.callStates[this.currentIndex].getDirection();
    }
}

