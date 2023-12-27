/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

public final class OptimizedListLUT$ItemBlock {
    public int absIndexFirst;
    public int absIndexLast;
    public int relIndexFirst;
    public int itemID;
    public int[] layoutValueStart;
    public int[] layoutValueGap;

    public OptimizedListLUT$ItemBlock(int n, int n2, int n3, int n4, int n5) {
        this.itemID = n;
        this.absIndexFirst = n2;
        this.absIndexLast = n3;
        this.relIndexFirst = n4;
        this.layoutValueStart = new int[n5];
        this.layoutValueGap = new int[n5];
    }
}

