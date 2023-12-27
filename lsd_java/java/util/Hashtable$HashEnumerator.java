/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Hashtable$Entry;
import java.util.NoSuchElementException;

final class Hashtable$HashEnumerator
implements Enumeration {
    boolean key;
    int start;
    Hashtable$Entry entry;
    final /* synthetic */ Hashtable this$0;

    Hashtable$HashEnumerator(Hashtable hashtable, boolean bl) {
        this.this$0 = hashtable;
        this.key = bl;
        this.start = hashtable.lastSlot + 1;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean hasMoreElements() {
        if (this.entry == null) ** GOTO lbl6
        return true;
lbl-1000:
        // 1 sources

        {
            if (this.this$0.elementData[this.start] == null) continue;
            this.entry = this.this$0.elementData[this.start];
            return true;
lbl6:
            // 2 sources

            ** while (--this.start >= this.this$0.firstSlot)
        }
lbl7:
        // 1 sources

        return false;
    }

    @Override
    public Object nextElement() {
        if (this.hasMoreElements()) {
            Object object = this.key ? this.entry.key : this.entry.value;
            this.entry = this.entry.next;
            return object;
        }
        throw new NoSuchElementException();
    }
}

