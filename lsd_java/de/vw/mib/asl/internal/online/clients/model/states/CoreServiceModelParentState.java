/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelParentState$1;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;

public class CoreServiceModelParentState
extends AbstractHsmState {
    private final CoreServiceModelTarget _target;
    private final String _classname = super.getClass().getName();

    public CoreServiceModelParentState(CoreServiceModelTarget coreServiceModelTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = coreServiceModelTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".OnlineCSParentState()").log();
        }
    }

    private CoreServiceModelTarget getTarget() {
        return this._target;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                StartupStateService startupStateService = ASLStartupv7rFactory.getStartupv7rApi().getStartupStateService();
                startupStateService.addListener(new CoreServiceModelParentState$1(this));
                this.trans(this.getTarget().getActiveState());
                break;
            }
            case 4: {
                break;
            }
            case 4800009: {
                break;
            }
            case 2100016: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLCarServiceIds.ASL_CAR_VIN)").log();
                }
                String string = Util.isNullOrEmpty(eventGeneric.getString(0)) ? "NULL" : eventGeneric.getString(0);
                this.getTarget().info(new StringBuffer().append("VIN Number -> ").append(string).toString());
                break;
            }
            case 4300062: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLSystemServiceIds.RELOAD_PERSISTABLES)").log();
                break;
            }
            case 4800011: {
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().setOCURuntimeStatus(n);
                break;
            }
            case 100015: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(CoreServiceModelEvents.EV_CORE_SERVICE_DEVICE_TYPE)").log();
                }
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().setOCURuntimeStatus(n);
                break;
            }
            case 100013: {
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getPropertyManager().setAvailableDevices(n);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().setOCUAvailability(CoreServiceModelFactory.getPropertyManager().isDeviceAvailable(1));
                break;
            }
            case 100012: {
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).updateAuthenticationStatus(n);
                break;
            }
            case 4800012: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceIds.ASL_ONLINE_UOTA_SERVICE_READY)").log();
                }
                boolean bl = eventGeneric.getBoolean(0);
                CoreServiceModelMap.setUotAServiceReady(bl);
                break;
            }
            case 100016: {
                Object object;
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(CoreServiceModelEvents.EV_CORE_SERVICE_TRACKINGSERVICES_ACTIVATION)").log();
                }
                OnlineTrackingService[] onlineTrackingServiceArray = (object = eventGeneric.getObject(1)) != null ? (OnlineTrackingService[])object : new OnlineTrackingService[]{};
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().sendOnlineServiceTrackingList(onlineTrackingServiceArray);
                break;
            }
            case 100017: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(CoreServiceModelEvents.EV_CORE_SERVICE_PRIMARYUSER_POPUP_ACTIVATION)").log();
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) break;
                this.getTarget().sendHMIEvent(1308431104);
                break;
            }
            case 1075041883: {
                CoreServiceFactory.getCoreService().setTrackingServicesValidity(false);
                break;
            }
            case 100021: {
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().sendServiceListStatus(eventGeneric.getInt(0));
                break;
            }
            case 1073744697: {
                break;
            }
            case 1075041824: {
                break;
            }
            case 1075041846: {
                break;
            }
            case 1075041844: {
                break;
            }
            case 1075041845: {
                break;
            }
            case 1075041847: {
                break;
            }
            case 1075041848: {
                break;
            }
            case 1073744720: {
                break;
            }
            case 1073744719: {
                break;
            }
            case 1073744721: {
                break;
            }
            case 1073744722: {
                break;
            }
            case 1073744734: {
                break;
            }
            case 1073744733: {
                break;
            }
            case 2200001: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLConnectivityServiceIds.ASL_CONNECTIVITY_IS_DATA_CONNECTION_AVAILABLE)").log();
                break;
            }
            case 2200006: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLConnectivityServiceIds.ASL_CONNECTIVITY_GSM_ROAMING_ACTIVE)").log();
                break;
            }
            case 2200010: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLConnectivityServiceIds.ASL_CONNECTIVITY_GSM_ROAMING_ENABLED)").log();
                }
                boolean bl = eventGeneric.getBoolean(0);
                CoreServiceFactory.getCoreService().setRoamingEnabled(bl);
                break;
            }
            case 4800007: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceIds.ASL_ONLINE_CAR_NET_ERROR)").log();
                break;
            }
            case 4800010: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLCarServiceIds.ASL_ONLINE_WIZARD_ACTIVATION)").log();
                }
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().deactivateWizard(n);
                break;
            }
            case 100020: {
                this.trans(this._target.getAuthenticationState());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

