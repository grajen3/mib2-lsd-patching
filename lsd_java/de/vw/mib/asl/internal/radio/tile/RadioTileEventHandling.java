/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.tile;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;

public final class RadioTileEventHandling {
    public void registerObservers(AbstractTarget abstractTarget) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("EventHandling - registerObservers()").log();
            }
            if (null != abstractTarget) {
                abstractTarget.addObserver(295642176);
                abstractTarget.addObserver(312419392);
                abstractTarget.addObserver(329196608);
                abstractTarget.addObserver(345973824);
                abstractTarget.addObserver(362751040);
                abstractTarget.addObserver(379528256);
                abstractTarget.addObserver(396305472);
                abstractTarget.addObserver(413082688);
                abstractTarget.addObserver(429859904);
                abstractTarget.addObserver(446637120);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void gotEvent(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioTileEventHandling : Event ID = ").append(this.getEventName(eventGeneric.getReceiverEventId())).log();
            }
            switch (eventGeneric.getReceiverEventId()) {
                case 1076141844: {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(true, 1170613248, -1);
                    break;
                }
                case 1076141842: {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(false, 1170613248, -1);
                    break;
                }
                case 1076141843: {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(true, 1153836032, -1);
                    break;
                }
                case 1076141841: {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(false, 1153836032, -1);
                    break;
                }
                case 1076141845: {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(eventGeneric, 1170613248);
                    break;
                }
                case 1076141846: {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(eventGeneric, 1153836032);
                    break;
                }
                case 1076141847: {
                    RadioServiceManager.getServiceManager().getTileStationList().setTileLVisible(true);
                    RadioServiceManager.getServiceManager().getTileStationList().initTiles();
                    break;
                }
                case 1076141848: {
                    RadioServiceManager.getServiceManager().getTileStationList().setTileLVisible(false);
                    break;
                }
                case 1076141849: {
                    if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append("TileS - Visible").log();
                    }
                    RadioServiceManager.getServiceManager().getTileStationList().setTileSVisible(true);
                    RadioServiceManager.getServiceManager().getTileStationList().initTiles();
                    break;
                }
                case 1076141850: {
                    RadioServiceManager.getServiceManager().getTileStationList().setTileSVisible(false);
                    RadioServiceManager.getServiceManager().getTileStationList().stopFreezeTileListTimer();
                    RadioServiceManager.getServiceManager().getTileStationList().stopUpdateTileListTimer();
                    break;
                }
                case 100264: {
                    RadioServiceManager.getServiceManager().getTileStationList().freezeTileListTimerExpired();
                    break;
                }
                case 100265: {
                    RadioServiceManager.getServiceManager().getTileStationList().updatedTileListTimerExpired();
                    break;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private String getEventName(int n) {
        switch (n) {
            case 1076141844: {
                return "ASLRadioServiceConstants.TILE_S_ACTIVATE_NEXT_STATION";
            }
            case 1076141842: {
                return "ASLRadioServiceConstants.TILE_S_ACTIVATE_PREVIOUS_STATION";
            }
            case 1076141843: {
                return "ASLRadioServiceConstants.TILE_L_ACTIVATE_NEXT_STATION";
            }
            case 1076141841: {
                return "ASLRadioServiceConstants.TILE_L_ACTIVATE_PREVIOUS_STATION";
            }
            case 1076141845: {
                return "ASLRadioServiceConstants.TILE_S_ACTIVATE_STATION_PRESET";
            }
            case 1076141846: {
                return "ASLRadioServiceConstants.TILE_L_ACTIVATE_STATION_PRESET";
            }
            case 1076141847: {
                return "ASLRadioServiceConstants.TILE_L_VISIBLE";
            }
            case 1076141848: {
                return "ASLRadioServiceConstants.TILE_L_INVISIBLE";
            }
            case 1076141849: {
                return "ASLRadioServiceConstants.TILE_S_VISIBLE";
            }
            case 1076141850: {
                return "ASLRadioServiceConstants.TILE_S_INVISIBLE";
            }
        }
        return String.valueOf(n);
    }
}

