/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.memory.IEntriesResultListener;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver$Handler;

class NavMemoryDataRetriver$2
implements NavMemoryDataRetriver$Handler {
    private final /* synthetic */ IEntriesResultListener val$listener;
    private final /* synthetic */ long[] val$ids;
    private final /* synthetic */ int val$viewType;
    private final /* synthetic */ Object val$arg;
    private final /* synthetic */ NavMemoryDataRetriver this$0;

    NavMemoryDataRetriver$2(NavMemoryDataRetriver navMemoryDataRetriver, IEntriesResultListener iEntriesResultListener, long[] lArray, int n, Object object) {
        this.this$0 = navMemoryDataRetriver;
        this.val$listener = iEntriesResultListener;
        this.val$ids = lArray;
        this.val$viewType = n;
        this.val$arg = object;
    }

    @Override
    public Object getHandler() {
        return this.val$listener;
    }

    @Override
    public void doRequest() {
        NavMemoryDataRetriver.access$100(this.this$0).getEntries(this.val$ids, this.val$viewType, 0);
    }

    @Override
    public Object getArg() {
        return this.val$arg;
    }

    @Override
    public void handleError() {
    }
}

