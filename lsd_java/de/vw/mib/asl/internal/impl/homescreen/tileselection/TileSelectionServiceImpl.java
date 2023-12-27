/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppDescription;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.AbstractHomeScreenTarget;
import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileAppDescriptor;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileInstaller;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionService;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionServiceImpl$1;
import de.vw.mib.asl.internal.impl.homescreen.util.HostedAppBinder;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class TileSelectionServiceImpl
extends AbstractHomeScreenTarget
implements TileSelectionService {
    private static final int SELECTION_DELAY;
    private static final String LOG_PREFIX;
    private static final CioIntent[] NO_APPS;
    private final ASLListManager listManager;
    private final CioDictionary cioDictionary;
    private final ServiceRegister serviceRegister;
    private final TileInstaller tileInstaller;
    private final Timer timer;
    private HostedAppBinder hostedAppBinder;
    private ASLPropertyManager aslPropertyManager;
    private final String usage;
    private final int selectionListId;
    private final int selectAppAslDownEventId;
    private final int selectAppAslDownEventParameterIndex;
    private final String tileSelectionAppUsage;
    private final int selectedListindexDatapoolId;
    private TileAppDescriptor[] appDescriptors = new TileAppDescriptor[0];
    private Tile currentTile;
    private int currentSelectedTileApp;
    private int persistedAppListIndex;

    TileSelectionServiceImpl(HomeScreenServices homeScreenServices, int n, TileInstaller tileInstaller, TileSelectionAppDescription tileSelectionAppDescription) {
        super(homeScreenServices.getGenericEvents(), homeScreenServices.getLogger(), n);
        this.tileInstaller = tileInstaller;
        this.listManager = homeScreenServices.getASLListManager();
        this.cioDictionary = homeScreenServices.getCioDictionary();
        this.serviceRegister = homeScreenServices.getServiceRegister();
        this.hostedAppBinder = homeScreenServices.getHostedAppBinder();
        this.aslPropertyManager = homeScreenServices.getASLPropertyManager();
        this.usage = tileSelectionAppDescription.getUsage();
        this.selectionListId = tileSelectionAppDescription.getSelectionListId();
        this.selectAppAslDownEventId = tileSelectionAppDescription.getSelectAppAslDownEventId();
        this.selectAppAslDownEventParameterIndex = tileSelectionAppDescription.getSelectAppAslDownEventParameterIndex();
        this.tileSelectionAppUsage = tileSelectionAppDescription.getTileSelectionAppUsage();
        this.selectedListindexDatapoolId = tileSelectionAppDescription.getSelectedListIndexDataPoolId();
        this.timer = this.createTimer(homeScreenServices);
        this.addObservers();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.selectAppAslDownEventId == eventGeneric.getReceiverEventId()) {
            int n = eventGeneric.getInt(this.selectAppAslDownEventParameterIndex);
            this.selectTileApp(n);
        }
    }

    @Override
    public void activateTileSelection(Tile tile) {
        this.currentTile = tile;
        CioIntent[] cioIntentArray = this.retrieveTileApps();
        this.appDescriptors = this.transformToAppDescriptors(tile, cioIntentArray);
        this.updateSelectionList();
        this.aslPropertyManager.valueChangedInteger(this.selectedListindexDatapoolId, this.persistedAppListIndex);
        this.showTileSelectionApp(tile);
    }

    @Override
    public void cancelTileSelection() {
        if (this.timer.isStarted()) {
            this.timer.stop();
        }
    }

    void installCurrentlySelectedTile() {
        CioIntent cioIntent = this.appDescriptors[this.currentSelectedTileApp].getTileApp();
        this.tileInstaller.installTile(this.currentTile, cioIntent);
    }

    private void showTileSelectionApp(Tile tile) {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("CreateHostedApp", this.tileSelectionAppUsage);
        if (cioIntent != null) {
            this.hostedAppBinder.bindHostedApp(cioIntent, tile);
        } else {
            this.getLogger().error(2048, new StringBuffer().append("[TileSelectionServiceImpl] Cannot show tile selection app since no CreateHostedApp intent is available for usage ").append(this.tileSelectionAppUsage).toString());
        }
    }

    private void addObservers() {
        this.serviceRegister.addObserver(this.selectAppAslDownEventId, this.getTargetId());
    }

    private Timer createTimer(HomeScreenServices homeScreenServices) {
        TimerManager timerManager = homeScreenServices.getTimerManager();
        ThreadSwitchingTarget threadSwitchingTarget = homeScreenServices.getThreadSwitchingTarget();
        TileSelectionServiceImpl$1 tileSelectionServiceImpl$1 = new TileSelectionServiceImpl$1(this);
        return timerManager.createTimer("SelectionTileAppTimer", 0, false, tileSelectionServiceImpl$1, threadSwitchingTarget);
    }

    private void selectTileApp(int n) {
        if (n >= 0 && n < this.appDescriptors.length && this.appDescriptors.length > 0) {
            this.updateTileSelection(n);
            this.updateSelectionList();
            if (this.timer.isRunning()) {
                this.timer.setDelayFromNow(0);
            } else {
                this.timer.start();
            }
        } else {
            this.getLogger().error(2048, new StringBuffer().append("[TileSelectionServiceImpl] Cannot change to tile app with index ").append(n).append(" since it is not available.").toString());
        }
    }

    private void updateTileSelection(int n) {
        this.currentSelectedTileApp = n;
        for (int i2 = 0; i2 < this.appDescriptors.length; ++i2) {
            this.appDescriptors[i2].setSelected(false);
        }
        this.appDescriptors[n].setSelected(true);
    }

    private void updateSelectionList() {
        this.listManager.getASLList(this.selectionListId).updateList(this.appDescriptors);
    }

    private TileAppDescriptor[] transformToAppDescriptors(Tile tile, CioIntent[] cioIntentArray) {
        TileAppDescriptor[] tileAppDescriptorArray = new TileAppDescriptor[cioIntentArray.length];
        for (int i2 = 0; i2 < cioIntentArray.length; ++i2) {
            boolean bl = cioIntentArray[i2] == tile.getApp();
            tileAppDescriptorArray[i2] = new TileAppDescriptor(cioIntentArray[i2], bl);
            if (!bl) continue;
            this.persistedAppListIndex = i2;
        }
        return tileAppDescriptorArray;
    }

    private CioIntent[] retrieveTileApps() {
        CioIntent[] cioIntentArray = this.cioDictionary.getCioIntents("CreateHostedApp", this.usage);
        if (cioIntentArray == null) {
            cioIntentArray = NO_APPS;
        }
        return cioIntentArray;
    }

    static {
        NO_APPS = new CioIntent[0];
    }
}

