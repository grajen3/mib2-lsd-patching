/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.homescreen.api.impl;

import de.vw.mib.asl.api.homescreen.ASLHomeScreenAPI;
import de.vw.mib.asl.api.homescreen.HomeScreenPages;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppService;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenPagesImpl;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenServicesProvider;

public class ASLHomeScreenAPIImpl
implements ASLHomeScreenAPI {
    private HomeScreenPages homeScreenPages;

    @Override
    public TileSelectionAppService getTileSelectionAppService() {
        return this.services().getTileSelectionAppService();
    }

    @Override
    public HomeScreenPages getHomeScreenPages() {
        if (this.homeScreenPages == null) {
            this.homeScreenPages = new HomeScreenPagesImpl(this.services());
        }
        return this.homeScreenPages;
    }

    private HomeScreenServices services() {
        return HomeScreenServicesProvider.getHomeScreenServices();
    }
}

