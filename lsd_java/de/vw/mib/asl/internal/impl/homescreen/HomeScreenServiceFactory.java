/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenServicesImpl;
import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import java.util.ArrayList;

class HomeScreenServiceFactory {
    HomeScreenServiceFactory() {
    }

    HomeScreenServices createHomeScreenServices() {
        ConfigurationManagerDiag configurationManagerDiag = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getConfigurationManagerDiag();
        Tile[] tileArray = this.createDescriptors(configurationManagerDiag);
        HomeScreenServicesImpl homeScreenServicesImpl = new HomeScreenServicesImpl(tileArray);
        return homeScreenServicesImpl;
    }

    private Tile[] createDescriptors(ConfigurationManagerDiag configurationManagerDiag) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Tile("BigTile", 0, 0));
        arrayList.add(new Tile("SmallTile", 0, 1));
        arrayList.add(new Tile("SmallTile", 1, 2));
        if (configurationManagerDiag.isFeatureFlagSet(69)) {
            arrayList.add(new Tile("SmallTile", 2, 3));
            arrayList.add(new Tile("SmallTile", 3, 4));
        }
        return (Tile[])arrayList.toArray(new Tile[arrayList.size()]);
    }
}

