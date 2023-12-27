/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.TileAppPersistence;
import de.vw.mib.asl.internal.impl.homescreen.TileInstallerImpl$1;
import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileInstaller;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionAppProvider;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionService;
import de.vw.mib.asl.internal.impl.homescreen.util.HostedAppBinder;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;

class TileInstallerImpl
implements TileInstaller {
    private static final Long NO_HEADLINE = new Long(-1L);
    private final HostedAppBinder hostedAppBinder;
    private final Tile[] tiles;
    private final CioDictionary cioDictionary;
    private final ASLListManager listManager;
    private final HomeScreenServices services;
    private final TileAppPersistence persistence;
    private final SystemEventDispatcher systemEventDispatcher;
    private Tile tileWithActiveSelectionApp;

    public TileInstallerImpl(HomeScreenServices homeScreenServices) {
        this.services = homeScreenServices;
        this.hostedAppBinder = homeScreenServices.getHostedAppBinder();
        this.tiles = homeScreenServices.getTiles();
        this.cioDictionary = homeScreenServices.getCioDictionary();
        this.listManager = homeScreenServices.getASLListManager();
        this.systemEventDispatcher = homeScreenServices.getSystemEventDispatcher();
        this.persistence = new TileAppPersistence(homeScreenServices.getHomeScreenPersistenceService());
        this.registerCioRegistrationListener();
        this.updateHeaders();
    }

    @Override
    public void installTile(Tile tile, CioIntent cioIntent) {
        this.resetTileSelectionApp(tile);
        Tile tile2 = this.findOtherTileWithSameApp(tile, cioIntent);
        if (tile2 != null) {
            this.hostedAppBinder.disposeHostedApp(tile2.getApp());
            CioIntent cioIntent2 = tile.getApp();
            this.bindTileApp(tile2, cioIntent2);
        }
        this.bindTileApp(tile, cioIntent);
        this.updateHeaders();
    }

    @Override
    public void activateTiles() {
        this.bindTileApps();
        this.updateHeaders();
    }

    @Override
    public void activateSelectionTile(int n) {
        this.deactivateSelectionTile();
        this.doActivateSelectionTile(n);
        this.updateHeaders();
    }

    @Override
    public void deactivateSelectionTile() {
        if (this.tileWithActiveSelectionApp != null) {
            this.installTile(this.tileWithActiveSelectionApp, this.tileWithActiveSelectionApp.getApp());
        }
    }

    @Override
    public CioIntent findCurrentHeaderAction(int n) {
        for (int i2 = 0; i2 < this.tiles.length; ++i2) {
            Tile tile = this.tiles[i2];
            if (tile.getTileId() != n) continue;
            return this.getHeaderButtonAction(tile.getApp());
        }
        return null;
    }

    @Override
    public void resetTiles() {
        this.persistence.dropTileApps();
        this.activateTiles();
    }

    void updateHeaders() {
        Object[] objectArray = this.createInformationAppList();
        this.listManager.getASLList(-1309980160).updateList(objectArray);
    }

    private void bindTileApps() {
        for (int i2 = 0; i2 < this.tiles.length; ++i2) {
            Tile tile = this.tiles[i2];
            CioIntent cioIntent = this.findAppForTile(tile);
            this.bindTileApp(tile, cioIntent);
        }
    }

    private Tile findOtherTileWithSameApp(Tile tile, CioIntent cioIntent) {
        for (int i2 = 0; i2 < this.tiles.length; ++i2) {
            Tile tile2 = this.tiles[i2];
            CioIntent cioIntent2 = tile2.getApp();
            if (tile2 == tile || !this.isSameApp(cioIntent2, cioIntent)) continue;
            return tile2;
        }
        return null;
    }

    private boolean isSameApp(CioIntent cioIntent, CioIntent cioIntent2) {
        return cioIntent != null && cioIntent2 != null && cioIntent.getCioIntentId() == cioIntent2.getCioIntentId();
    }

    private void doActivateSelectionTile(int n) {
        Tile tile = this.findTile(n);
        TileSelectionAppProvider tileSelectionAppProvider = this.services.getTileSelectionAppProvider();
        if (tileSelectionAppProvider.hasTileSelectionService(tile)) {
            TileSelectionService tileSelectionService = tileSelectionAppProvider.retrieveTileSelectionService(tile);
            tileSelectionService.activateTileSelection(tile);
            this.tileWithActiveSelectionApp = tile;
        }
    }

    private void resetTileSelectionApp(Tile tile) {
        if (this.tileWithActiveSelectionApp != null && tile == this.tileWithActiveSelectionApp) {
            this.tileWithActiveSelectionApp = null;
            this.systemEventDispatcher.createAndSubmitHMIEvent(-1309980160);
        }
    }

    private void bindTileApp(Tile tile, CioIntent cioIntent) {
        if (cioIntent == null) {
            return;
        }
        tile.setApp(cioIntent);
        this.hostedAppBinder.bindHostedApp(cioIntent, tile);
        this.persistence.saveTileApp(tile.getUsage(), tile.getUsageIndex(), cioIntent.getCioIntentId());
    }

    private CioIntent findAppForTile(Tile tile) {
        CioIntent[] cioIntentArray = this.retrieveAvailableApps(tile);
        if (cioIntentArray == null) {
            return null;
        }
        CioIntent cioIntent = this.findUserDefinedAppForTile(tile, cioIntentArray);
        if (cioIntent != null) {
            return cioIntent;
        }
        int n = tile.getUsageIndex();
        if (cioIntentArray.length <= n) {
            return null;
        }
        CioIntent cioIntent2 = cioIntentArray[n];
        return cioIntent2;
    }

    private CioIntent[] retrieveAvailableApps(Tile tile) {
        String string = "BigTile".equals(tile.getUsage()) ? "DefaultBigTileConfiguration" : "DefaultSmallTileConfiguration";
        CioIntent[] cioIntentArray = this.cioDictionary.getCioIntentsByFilter(string);
        return cioIntentArray;
    }

    private CioIntent findUserDefinedAppForTile(Tile tile, CioIntent[] cioIntentArray) {
        Long l = this.persistence.getTileApp(tile.getUsage(), tile.getUsageIndex());
        if (l == null) {
            return null;
        }
        return this.findApp(l, cioIntentArray);
    }

    private CioIntent findApp(long l, CioIntent[] cioIntentArray) {
        for (int i2 = 0; i2 < cioIntentArray.length; ++i2) {
            CioIntent cioIntent = cioIntentArray[i2];
            if (cioIntent.getCioIntentId() != l) continue;
            return cioIntent;
        }
        return null;
    }

    private Long[] createInformationAppList() {
        Long[] longArray = new Long[this.tiles.length];
        for (int i2 = 0; i2 < this.tiles.length; ++i2) {
            CioIntent cioIntent = null;
            Tile tile = this.tiles[i2];
            if (this.tileWithActiveSelectionApp != tile && tile != null) {
                cioIntent = tile.getApp();
            }
            CioIntent cioIntent2 = this.getHeaderButtonAction(cioIntent);
            longArray[i2] = this.getCioIntendId(cioIntent2);
        }
        return longArray;
    }

    private Long getCioIntendId(CioIntent cioIntent) {
        if (cioIntent == null) {
            return NO_HEADLINE;
        }
        return new Long(cioIntent.getCioIntentId());
    }

    private CioIntent getHeaderButtonAction(CioIntent cioIntent) {
        return this.cioDictionary.getCioIntent("TileHeaderButtonAction", cioIntent);
    }

    private void registerCioRegistrationListener() {
        TileInstallerImpl$1 tileInstallerImpl$1 = new TileInstallerImpl$1(this);
        this.cioDictionary.addCioRegistrationListener("TileHeaderButtonAction", tileInstallerImpl$1);
    }

    private Tile findTile(int n) {
        for (int i2 = 0; i2 < this.tiles.length; ++i2) {
            Tile tile = this.tiles[i2];
            if (n != tile.getTileId()) continue;
            return tile;
        }
        return null;
    }
}

