/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppDescription;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppService;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionListItemTransformer;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileInstaller;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionAppProvider;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionListItemTransformerImpl;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionService;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class TileSelectionAppServiceImpl
implements TileSelectionAppService,
TileSelectionAppProvider {
    private final TileSelectionListItemTransformerImpl listTransfromer;
    private final Map mapUsageToSelectionAppService = new HashMap();
    private final HomeScreenServices services;
    private TileInstaller tileInstaller;

    public TileSelectionAppServiceImpl(HomeScreenServices homeScreenServices, TileInstaller tileInstaller) {
        this.services = homeScreenServices;
        this.tileInstaller = tileInstaller;
        this.listTransfromer = new TileSelectionListItemTransformerImpl();
    }

    @Override
    public void registerTileSelectionApp(TileSelectionAppDescription tileSelectionAppDescription) {
        this.verifyAppDescription(tileSelectionAppDescription);
        TileSelectionService tileSelectionService = this.createTileSelectionService(tileSelectionAppDescription);
        this.mapUsageToSelectionAppService.put(tileSelectionAppDescription.getUsage(), tileSelectionService);
    }

    @Override
    public TileSelectionListItemTransformer getTransformer() {
        return this.listTransfromer;
    }

    @Override
    public TileSelectionService retrieveTileSelectionService(Tile tile) {
        String string = tile.getUsage();
        if (this.mapUsageToSelectionAppService.containsKey(string)) {
            return (TileSelectionService)this.mapUsageToSelectionAppService.get(string);
        }
        throw new IllegalArgumentException(new StringBuffer().append("No tile seleciton service registered for usage ").append(string).toString());
    }

    @Override
    public boolean hasTileSelectionService(Tile tile) {
        String string = tile.getUsage();
        return this.mapUsageToSelectionAppService.containsKey(string);
    }

    private TileSelectionService createTileSelectionService(TileSelectionAppDescription tileSelectionAppDescription) {
        int n = 370678272 + this.mapUsageToSelectionAppService.size();
        TileSelectionServiceImpl tileSelectionServiceImpl = new TileSelectionServiceImpl(this.services, n, this.tileInstaller, tileSelectionAppDescription);
        return tileSelectionServiceImpl;
    }

    private void verifyAppDescription(TileSelectionAppDescription tileSelectionAppDescription) {
        if (tileSelectionAppDescription == null) {
            throw new IllegalArgumentException("App description must not be null");
        }
        if (this.mapUsageToSelectionAppService.containsKey(tileSelectionAppDescription.getUsage())) {
            throw new IllegalArgumentException(new StringBuffer().append("An other selection tile app for usage '").append(tileSelectionAppDescription.getUsage()).append("' was already registered.").toString());
        }
    }
}

