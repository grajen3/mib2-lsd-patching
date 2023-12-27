/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.homescreen;

import de.vw.mib.asl.api.homescreen.HomeScreenPages;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppService;

public interface ASLHomeScreenAPI {
    default public TileSelectionAppService getTileSelectionAppService() {
    }

    default public HomeScreenPages getHomeScreenPages() {
    }
}

