/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenServiceFactory;

public class HomeScreenServicesProvider {
    private static HomeScreenServices homeScreenServices;

    public static HomeScreenServices getHomeScreenServices() {
        if (homeScreenServices == null) {
            homeScreenServices = new HomeScreenServiceFactory().createHomeScreenServices();
        }
        return homeScreenServices;
    }

    public static void setHomeScreenServices(HomeScreenServices homeScreenServices) {
        HomeScreenServicesProvider.homeScreenServices = homeScreenServices;
    }
}

