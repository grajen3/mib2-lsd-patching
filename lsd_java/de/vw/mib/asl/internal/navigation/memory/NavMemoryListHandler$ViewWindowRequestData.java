/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryListHandler;

class NavMemoryListHandler$ViewWindowRequestData {
    ASLCachedWindowList list;
    int index;
    int count;
    private final /* synthetic */ NavMemoryListHandler this$0;

    public NavMemoryListHandler$ViewWindowRequestData(NavMemoryListHandler navMemoryListHandler, ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        this.this$0 = navMemoryListHandler;
        this.list = aSLCachedWindowList;
        this.index = n;
        this.count = n2;
    }

    public ASLCachedWindowList getList() {
        return this.list;
    }

    public int getIndex() {
        return this.index;
    }

    public int getCount() {
        return this.count;
    }
}

