/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.memory.ITbmResultListener;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver$Handler;
import org.dsi.ifc.navigation.TryBestMatchData;

class NavMemoryDataRetriver$3
implements NavMemoryDataRetriver$Handler {
    private final /* synthetic */ ITbmResultListener val$listener;
    private final /* synthetic */ TryBestMatchData val$tbmData;
    private final /* synthetic */ Object val$arg;
    private final /* synthetic */ NavMemoryDataRetriver this$0;

    NavMemoryDataRetriver$3(NavMemoryDataRetriver navMemoryDataRetriver, ITbmResultListener iTbmResultListener, TryBestMatchData tryBestMatchData, Object object) {
        this.this$0 = navMemoryDataRetriver;
        this.val$listener = iTbmResultListener;
        this.val$tbmData = tryBestMatchData;
        this.val$arg = object;
    }

    @Override
    public Object getHandler() {
        return this.val$listener;
    }

    @Override
    public void doRequest() {
        NavMemoryDataRetriver.access$200(this.this$0).liTryBestMatch(this.val$tbmData);
    }

    @Override
    public Object getArg() {
        return this.val$arg;
    }

    @Override
    public void handleError() {
    }
}

