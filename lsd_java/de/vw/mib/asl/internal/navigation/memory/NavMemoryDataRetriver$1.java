/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.memory.IListResultListener;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver$Handler;

class NavMemoryDataRetriver$1
implements NavMemoryDataRetriver$Handler {
    private final /* synthetic */ IListResultListener val$listener;
    private final /* synthetic */ int val$offset;
    private final /* synthetic */ int val$viewType;
    private final /* synthetic */ int val$count;
    private final /* synthetic */ Object val$arg;
    private final /* synthetic */ NavMemoryDataRetriver this$0;

    NavMemoryDataRetriver$1(NavMemoryDataRetriver navMemoryDataRetriver, IListResultListener iListResultListener, int n, int n2, int n3, Object object) {
        this.this$0 = navMemoryDataRetriver;
        this.val$listener = iListResultListener;
        this.val$offset = n;
        this.val$viewType = n2;
        this.val$count = n3;
        this.val$arg = object;
    }

    @Override
    public Object getHandler() {
        return this.val$listener;
    }

    @Override
    public void doRequest() {
        if (this.val$offset == 0) {
            NavMemoryDataRetriver.access$000(this.this$0).getViewWindow(this.val$offset, 4, this.val$viewType, this.val$count);
        } else {
            NavMemoryDataRetriver.access$000(this.this$0).getViewWindow(this.val$offset, 6, this.val$viewType, this.val$count);
        }
    }

    @Override
    public Object getArg() {
        return this.val$arg;
    }

    @Override
    public void handleError() {
    }
}

