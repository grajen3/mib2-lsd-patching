/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.api.car.pso.PersonalizationAdapter;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget;

class HomeScreenInfoTarget$1
extends PersonalizationAdapter {
    private final /* synthetic */ HomeScreenInfoTarget this$0;

    HomeScreenInfoTarget$1(HomeScreenInfoTarget homeScreenInfoTarget) {
        this.this$0 = homeScreenInfoTarget;
    }

    @Override
    public void updateActiveProfile(String string, int n) {
        this.this$0.updateProfileNameDatapool(string);
    }
}

