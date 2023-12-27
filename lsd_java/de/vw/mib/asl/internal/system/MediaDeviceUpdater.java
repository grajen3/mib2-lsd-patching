/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.internal.system.MediaListAdapter;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.log4mib.Logger;

public class MediaDeviceUpdater
extends MediaListAdapter {
    public static final int USB_SLOT_1;
    public static final int USB_SLOT_2;
    public static final int USB_SLOT_3;
    public static final int USB_SLOT_4;
    public static final int USB_SLOT_5;
    public static final int USB_SLOT_6;
    private static final String LOG_PREFIX;
    private final ASLPropertyManager propertyManager;
    private final SystemEventDispatcher systemEventDispatcher;
    private final Logger logger;

    public MediaDeviceUpdater(ASLPropertyManager aSLPropertyManager, SystemEventDispatcher systemEventDispatcher, Logger logger) {
        this.propertyManager = aSLPropertyManager;
        this.systemEventDispatcher = systemEventDispatcher;
        this.logger = logger;
    }

    @Override
    public void onSourceChanged(Source source, Source source2) {
        this.traceSourceStateUpdate(source);
        SourceId sourceId = source.getSourceId();
        if (sourceId.getDeviceType() == 2) {
            this.updateUsbSlotAndStorage(source, sourceId);
            switch (source.getInsertion()) {
                case 0: {
                    this.updateUsbDeviceError(sourceId);
                    break;
                }
                case 11: {
                    this.updateUsbReadError(sourceId);
                    break;
                }
                case 12: {
                    this.updateUsbLoading(sourceId);
                    break;
                }
                case 7: {
                    this.updateUsbLoadingFinished(sourceId);
                    break;
                }
                case 10: {
                    this.updateUsbUnmountFinished(sourceId);
                    break;
                }
            }
        }
    }

    private void updateUsbUnmountFinished(SourceId sourceId) {
        switch (sourceId.getSlot()) {
            case 0: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(384);
                break;
            }
            case 1: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(548);
                break;
            }
            case 2: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(2066882560);
                break;
            }
            case 3: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(2100436992);
                break;
            }
        }
    }

    private void traceSourceStateUpdate(Source source) {
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("[MediaDeviceUpdater] ").append("onSourceChanged: current deviceType: ").append(source.getSourceId().getDeviceType()).append(", current insertion: ").append(source.getInsertion()).log();
        }
    }

    private void updateUsbLoading(SourceId sourceId) {
        switch (sourceId.getSlot()) {
            case 0: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(381);
                break;
            }
            case 1: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(545);
                break;
            }
            case 2: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1546788864);
                break;
            }
            case 3: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1563566080);
                break;
            }
            case 4: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1580343296);
                break;
            }
            case 5: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1597120512);
                break;
            }
        }
    }

    private void updateUsbLoadingFinished(SourceId sourceId) {
        switch (sourceId.getSlot()) {
            case 0: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(382);
                break;
            }
            case 1: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(546);
                break;
            }
            case 2: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1613897728);
                break;
            }
            case 3: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1630674944);
                break;
            }
            case 4: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1647452160);
                break;
            }
            case 5: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1664229376);
                break;
            }
        }
    }

    private void updateUsbDeviceError(SourceId sourceId) {
        switch (sourceId.getSlot()) {
            case 0: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(380);
                break;
            }
            case 1: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(544);
                break;
            }
            case 2: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1479680000);
                break;
            }
            case 3: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1496457216);
                break;
            }
            case 4: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1513234432);
                break;
            }
            case 5: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1530011648);
                break;
            }
        }
    }

    private void updateUsbReadError(SourceId sourceId) {
        switch (sourceId.getSlot()) {
            case 0: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(383);
                break;
            }
            case 1: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(547);
                break;
            }
            case 2: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1681006592);
                break;
            }
            case 3: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1697783808);
                break;
            }
            case 4: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1714561024);
                break;
            }
            case 5: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(1731338240);
                break;
            }
        }
    }

    private void updateUsbSlotAndStorage(Source source, SourceId sourceId) {
        boolean bl = source.getInsertion() == 7;
        switch (sourceId.getSlot()) {
            case 0: {
                this.reportDeviceAvailability(3016, 1712, bl);
                break;
            }
            case 1: {
                this.reportDeviceAvailability(3815, 3816, bl);
                break;
            }
            case 2: {
                this.reportDeviceAvailability(1278353408, 1345462272, bl);
                break;
            }
            case 3: {
                this.reportDeviceAvailability(1295130624, 1362239488, bl);
                break;
            }
            case 4: {
                this.reportDeviceAvailability(1311907840, 1379016704, bl);
                break;
            }
            case 5: {
                this.reportDeviceAvailability(1328685056, 1395793920, bl);
                break;
            }
        }
    }

    private void reportDeviceAvailability(int n, int n2, boolean bl) {
        this.propertyManager.valueChangedBoolean(n, true);
        this.propertyManager.valueChangedBoolean(n2, bl);
    }
}

