/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homebutton;

import de.vw.mib.asl.api.homescreen.HomeScreenPages$Page;
import de.vw.mib.asl.api.homescreen.HomescreenPageListener;
import de.vw.mib.asl.internal.impl.homebutton.HomeButtonMainTarget;

class HomeButtonMainTarget$1
implements HomescreenPageListener {
    private final /* synthetic */ HomeButtonMainTarget this$0;

    HomeButtonMainTarget$1(HomeButtonMainTarget homeButtonMainTarget) {
        this.this$0 = homeButtonMainTarget;
    }

    @Override
    public void onHomescreenPageChanged(HomeScreenPages$Page homeScreenPages$Page) {
        this.this$0.setButtonState(homeScreenPages$Page);
    }
}

