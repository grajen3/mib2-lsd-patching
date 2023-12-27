/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

class PerfectSlotHashFactory$Item
implements Comparable {
    final PerfectSlotHashFactory$Item next;
    final int key;
    final int count;

    public PerfectSlotHashFactory$Item() {
        this.next = this;
        this.key = 0;
        this.count = 0;
    }

    public PerfectSlotHashFactory$Item(int n, PerfectSlotHashFactory$Item perfectSlotHashFactory$Item) {
        this.next = perfectSlotHashFactory$Item;
        this.key = n;
        this.count = perfectSlotHashFactory$Item != null ? perfectSlotHashFactory$Item.count + 1 : 1;
    }

    @Override
    public int compareTo(Object object) {
        PerfectSlotHashFactory$Item perfectSlotHashFactory$Item = (PerfectSlotHashFactory$Item)object;
        return perfectSlotHashFactory$Item.count - this.count;
    }
}

