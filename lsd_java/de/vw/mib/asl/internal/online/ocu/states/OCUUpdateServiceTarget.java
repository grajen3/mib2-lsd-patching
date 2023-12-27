/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.states;

import de.vw.mib.asl.api.ocu.OCUServiceProvider;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceListener;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceProvider;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.internal.online.ocu.OCUUpdateServiceFactory;
import de.vw.mib.asl.internal.online.ocu.impl.OCUUpdateServiceListener;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;

public class OCUUpdateServiceTarget
extends AbstractTarget {
    private final String _classname = super.getClass().getName();
    private OnlineUpdateServiceListener _updateServiceListener;
    final int[] OBSERVED_EVENTS = new int[]{806035456, 1557533504, 1574310720, 1758860096, 1591087936, 1607865152, 1624642368, 1641419584, 1742082880, 1775637312, 1658196800, 1674974016, 1691751232, 1708528448, 1725305664};

    public OCUUpdateServiceTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    private void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startUp()").log();
        }
        ClampSignalService clampSignalService = ASLSystemFactory.getSystemApi().getClampSignalService();
        OCUUpdateServiceFactory.getClampSignalManager(this).onClamp15ValueChanged(clampSignalService.isCurrentClamp15Activated());
        clampSignalService.addListener(OCUUpdateServiceFactory.getClampSignalManager(this));
        this.addObservers(this.OBSERVED_EVENTS);
        this._updateServiceListener = new OCUUpdateServiceListener(this);
        this.getUpdateServiceProvider().registerOnlineUpdateServiceListener(this._updateServiceListener);
        if (this.getUpdateService().getOnlineUpdateState().getUpdateState().value() != 0) {
            if (this.isTraceEnabled()) {
                this.trace().append(this._classname).append("Update remote services are valid for processing").log();
            }
            OCUUpdateServiceFactory.getController(this).updateOCURemoteService(this.getUpdateService(), this.getUpdateService().getOnlineUpdateState(), this.getUpdateService().getOnlineUpdateList());
        }
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.addParticipant(OCUUpdateServiceFactory.getResetFactorySettings(this), FactoryResetComponents.ONLINE);
        ASLOnlineFactory.getAuthenticationService().registerForMainUserEnrollment(OCUUpdateServiceFactory.getController(this));
    }

    private void shutdown() {
        this.removeObservers(this.OBSERVED_EVENTS);
        this.getUpdateServiceProvider().unRegisterOnlineUpdateServiceListener(this._updateServiceListener);
    }

    public OnlineUpdateServiceProvider getUpdateServiceProvider() {
        return OCUServiceProvider.getServiceProvider().getOnlineUpdateServiceProvider(OCUServiceProvider.UPDATE_SERVICE_VERSION_1_0);
    }

    public OnlineUpdateService getUpdateService() {
        return this.getUpdateServiceProvider().getOnlineUpdateService();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
                this.startup();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_OFF)").log();
                }
                this.shutdown();
                break;
            }
            case 2100016: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLCarServiceIds.ASL_CAR_VIN)").log();
                }
                String string = Util.isNullOrEmpty(eventGeneric.getString(0)) ? "NULL" : eventGeneric.getString(0);
                this.info(new StringBuffer().append("VIN Number -> ").append(string).toString());
                OCUUpdateServiceFactory.getController(this).setVINNumber(string);
                break;
            }
            case 1075041884: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.OCU_UPDATE_USER_NOT_ENROLLED_ACKNOWLEDGED)").log();
                }
                OCUUpdateServiceFactory.getController(this).setState(0);
                OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(1, OCUUpdateServiceFactory.getController(this).getCurrentService());
                break;
            }
            case 1075041885: 
            case 1075041886: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.OCU_UPDATE_DOWNLOAD_ERROR_CONFIRMED)").log();
                }
                OCUUpdateServiceFactory.getController(this).setState(0);
                if (OCUUpdateServiceFactory.getController(this).getCurrentService().getUpdateState() == 7) {
                    OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(9, OCUUpdateServiceFactory.getController(this).getCurrentService());
                    break;
                }
                OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(7, OCUUpdateServiceFactory.getController(this).getCurrentService());
                break;
            }
            case 1075041896: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.OCU_UPDATE_INSTALLATION_ERROR_CONFIRMED)").log();
                }
                OCUUpdateServiceFactory.getController(this).setState(0);
                OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(7, OCUUpdateServiceFactory.getController(this).getCurrentService());
                break;
            }
            case 1075041887: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.OCU_UPDATE_INSTALLATION_SUCCESSFUL_CONFIRMED)").log();
                }
                OCUUpdateServiceFactory.getController(this).setState(0);
                OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(8, OCUUpdateServiceFactory.getController(this).getCurrentService());
                break;
            }
            case 1075041888: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.OCU_UPDATE_POSTPONE_INSTALLATION)").log();
                }
                OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(4, OCUUpdateServiceFactory.getController(this).getCurrentService());
                break;
            }
            case 1075041889: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.OCU_UPDATE_POSTPONE_DOWNLOAD)").log();
                }
                OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(1, OCUUpdateServiceFactory.getController(this).getCurrentService());
                break;
            }
            case 1075041895: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.OCU_UPDATE_START_INSTALLATION)").log();
                }
                OCUUpdateServiceFactory.getServiceHandler(this).sendUpdateServiceStatus(5, OCUUpdateServiceFactory.getController(this).getCurrentService());
                break;
            }
            case 1075041897: {
                OCUUpdateServiceFactory.getSpeller().spellerEntered();
                OCUUpdateServiceFactory.getController(this).setState(15);
                break;
            }
            case 1075041890: {
                OCUUpdateServiceFactory.getSpeller().spellerAddChar(eventGeneric.getString(0));
                break;
            }
            case 1075041891: {
                OCUUpdateServiceFactory.getController(this).setNumericSPin(OCUUpdateServiceFactory.getSpeller().spellerOK());
                break;
            }
            case 1075041892: {
                OCUUpdateServiceFactory.getSpeller().spellerSetCursorPosition(eventGeneric.getInt(0));
                break;
            }
            case 1075041893: {
                OCUUpdateServiceFactory.getSpeller().spellerDeleteChar();
                break;
            }
            case 1075041894: {
                OCUUpdateServiceFactory.getSpeller().spellerCancel();
                break;
            }
        }
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }
}

