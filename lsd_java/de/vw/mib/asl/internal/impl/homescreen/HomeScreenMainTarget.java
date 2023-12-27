/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceService;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.AbstractHomeScreenTarget;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenMainTarget$1;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenMainTarget$2;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileInstaller;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class HomeScreenMainTarget
extends AbstractHomeScreenTarget {
    private CioDispatcher cioDispatcher;
    private TileInstaller tileInstaller;
    private boolean areTilesInitialized;
    private HomescreenPersistenceService persistence;

    public HomeScreenMainTarget(HomeScreenServices homeScreenServices) {
        super(homeScreenServices.getGenericEvents(), homeScreenServices.getLogger(), -1273554432);
        this.cioDispatcher = homeScreenServices.getCioDispatcher();
        this.tileInstaller = homeScreenServices.getTileInstaller();
        this.persistence = homeScreenServices.getHomeScreenPersistenceService();
        this.registerObservers(homeScreenServices.getServiceRegister());
        this.registerFactoryResetParticipant(homeScreenServices.getFactoryResetService());
        this.registerProfileChangeListener();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1078641824: {
                this.activateTiles();
                break;
            }
            case 1078641826: {
                int n = this.getTileId(eventGeneric);
                this.activateBigStage(n);
                break;
            }
            case 1078641825: {
                int n = this.getTileId(eventGeneric);
                this.tileInstaller.activateSelectionTile(n);
                break;
            }
            case 1078641831: {
                this.tileInstaller.deactivateSelectionTile();
                break;
            }
        }
    }

    void refreshTileApps() {
        this.tileInstaller.activateTiles();
    }

    void resetTileApps() {
        this.tileInstaller.resetTiles();
    }

    private void activateTiles() {
        if (this.areTilesInitialized) {
            return;
        }
        this.areTilesInitialized = true;
        this.tileInstaller.activateTiles();
    }

    private int getTileId(EventGeneric eventGeneric) {
        return eventGeneric.getInt(0);
    }

    private void activateBigStage(int n) {
        CioIntent cioIntent = this.tileInstaller.findCurrentHeaderAction(n);
        this.cioDispatcher.dispatch(cioIntent);
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(-1597748672, this.getTargetId());
        serviceRegister.addObserver(-1564194240, this.getTargetId());
        serviceRegister.addObserver(-1580971456, this.getTargetId());
        serviceRegister.addObserver(-1480308160, this.getTargetId());
    }

    private void registerFactoryResetParticipant(FactoryResetService factoryResetService) {
        HomeScreenMainTarget$1 homeScreenMainTarget$1 = new HomeScreenMainTarget$1(this);
        factoryResetService.addParticipant(homeScreenMainTarget$1, FactoryResetComponents.SYSTEM);
    }

    private void registerProfileChangeListener() {
        HomeScreenMainTarget$2 homeScreenMainTarget$2 = new HomeScreenMainTarget$2(this);
        this.persistence.addProfileChangeListener(homeScreenMainTarget$2);
    }
}

