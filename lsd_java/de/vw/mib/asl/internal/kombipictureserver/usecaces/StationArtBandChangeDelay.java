/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.common.services.KombiPictureServerServices;
import de.vw.mib.asl.internal.kombipictureserver.common.services.LoggerFacade;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtBandChangeDelay$1;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtBandChangeDelay$2;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtData;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.datapool.ASLDatapoolObserver;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;

class StationArtBandChangeDelay {
    private static final long TIMEOUT_AFTER_BANDCHANGE;
    private final ASLDatapool dataPool;
    private final LoggerFacade logger;
    private final ThreadSwitchingTarget threadSwitchingTarget;
    private final TimerManager timerManager;
    private DSIKombiPictureServer dsiService;
    private byte counter = 0;
    private StationArtData dataCache = null;
    private Timer timer;

    StationArtBandChangeDelay(KombiPictureServerServices kombiPictureServerServices) {
        Preconditions.checkNotNull(kombiPictureServerServices, "KombiPictureServerServices must not be null.");
        this.logger = kombiPictureServerServices.createLoggerFacade(super.getClass(), 2);
        this.dataPool = kombiPictureServerServices.getDataPool();
        this.timerManager = kombiPictureServerServices.getTimerManager();
        this.threadSwitchingTarget = kombiPictureServerServices.getThreadSwitchingTarget();
    }

    public void initialize(DSIKombiPictureServer dSIKombiPictureServer) {
        Preconditions.checkNotNull(dSIKombiPictureServer, "DSIKombiPictureServer must not be null.");
        this.dsiService = dSIKombiPictureServer;
        this.dataPool.registerObserver(1324, this.createDatapoolListener());
    }

    public void processLastReceivedData(StationArtData stationArtData) {
        if (stationArtData == null) {
            this.logger.error("Received invaid null argument for sending.");
            return;
        }
        if (this.dsiService == null) {
            this.logger.error("Wanted to send station art before class is initialized.");
            return;
        }
        if (this.timer != null) {
            this.dataCache = stationArtData;
            this.enableDelayTimer();
            this.logger.trace("Extend delay because of activity.");
        } else {
            this.sendStationArtToDsi(stationArtData);
        }
    }

    void enableDelayTimer() {
        this.counter = (byte)(this.counter + 1);
        this.timer = this.timerManager.createTimer("Station art band change delay.", 0, false, this.createTimeoutRunnable(this.counter), this.threadSwitchingTarget);
        this.timer.start();
    }

    void processTimeout(byte by) {
        if (by == this.counter) {
            this.timer = null;
            if (this.dataCache != null) {
                this.sendStationArtToDsi(this.dataCache);
                this.dataCache = null;
            }
        }
    }

    private ASLDatapoolObserver createDatapoolListener() {
        return new StationArtBandChangeDelay$1(this);
    }

    private Runnable createTimeoutRunnable(byte by) {
        return new StationArtBandChangeDelay$2(this, by);
    }

    private void sendStationArtToDsi(StationArtData stationArtData) {
        if (stationArtData.getResourceLocator() != null) {
            this.dsiService.responseStationArt(stationArtData.getBapPresetID(), 0, stationArtData.getSourceType(), 1, stationArtData.getResourceLocator());
        } else {
            this.dsiService.responseStationArt(stationArtData.getBapPresetID(), 0, stationArtData.getSourceType(), 0, null);
        }
    }
}

