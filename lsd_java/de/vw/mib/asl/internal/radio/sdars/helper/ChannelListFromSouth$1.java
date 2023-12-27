/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ChannelListFromSouth$1
implements Iterator {
    private int mIndex = -1;
    private final /* synthetic */ ChannelListFromSouth this$0;

    ChannelListFromSouth$1(ChannelListFromSouth channelListFromSouth) {
        this.this$0 = channelListFromSouth;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object next() {
        if (this.mIndex < this.this$0.mArray.length - 1) {
            ++this.mIndex;
            return this.this$0.mArray[this.mIndex];
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        return this.mIndex < this.this$0.mArray.length - 1;
    }
}

