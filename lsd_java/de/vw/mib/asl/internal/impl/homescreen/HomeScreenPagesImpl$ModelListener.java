/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.api.homescreen.HomeScreenPages$Page;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenPagesImpl;
import de.vw.mib.asl.internal.impl.homescreen.PageUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

final class HomeScreenPagesImpl$ModelListener
implements Target {
    private final int targetId;
    private final /* synthetic */ HomeScreenPagesImpl this$0;

    HomeScreenPagesImpl$ModelListener(HomeScreenPagesImpl homeScreenPagesImpl, int n) {
        this.this$0 = homeScreenPagesImpl;
        this.targetId = n;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() != -1547417024) {
            return;
        }
        HomeScreenPages$Page homeScreenPages$Page = PageUtil.getPage(eventGeneric);
        if (homeScreenPages$Page == HomeScreenPages$Page.LEFT || homeScreenPages$Page == HomeScreenPages$Page.RIGHT) {
            this.this$0.setDatapoolToPage(homeScreenPages$Page);
        }
        this.this$0.setPage(homeScreenPages$Page);
    }

    @Override
    public GenericEvents getMainObject() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public int getTargetId() {
        return this.targetId;
    }

    @Override
    public void setTargetId(int n) {
    }
}

