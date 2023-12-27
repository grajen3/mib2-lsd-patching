/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.api.connectivity.services.datavolume.DataTrafficService;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelStateActive$1;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;

public class CoreServiceModelStateActive
extends AbstractHsmState {
    private final CoreServiceModelTarget _target;
    private final String _classname = super.getClass().getName();
    private int _subCategoryID;
    static /* synthetic */ Class class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService;

    public CoreServiceModelStateActive(CoreServiceModelTarget coreServiceModelTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = coreServiceModelTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".CoreServiceModelStateActive()").log();
        }
    }

    CoreServiceModelTarget getTarget() {
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
                this.getTarget().setCurrentState(this);
                break;
            }
            case 4: {
                break;
            }
            case 4300062: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLSystemServiceIds.RELOAD_PERSISTABLES)").log();
                break;
            }
            case 1075041869: {
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).handlePrivacyMode();
                break;
            }
            case 1075041865: {
                int n = eventGeneric.getInt(0);
                if (!CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).handlePackageActivation(n)) break;
                this.trans(this.getTarget().getAppActiveState());
                break;
            }
            case 1075041866: {
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).openServiceListOfPackage(n);
                break;
            }
            case 1075041868: {
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).handleServiceDetailView(n);
                break;
            }
            case 1075041870: {
                if (Util.isNullOrEmpty(CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getServiceList())) break;
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).submitCurrentServicesStateToBackend();
                break;
            }
            case 1075041871: {
                ((DataTrafficService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService == null ? (class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService = CoreServiceModelStateActive.class$("de.vw.mib.asl.api.connectivity.services.datavolume.DataTrafficService")) : class$de$vw$mib$asl$api$connectivity$services$datavolume$DataTrafficService)).resetDataVolume(2);
                break;
            }
            case 1075041851: {
                if (CoreServiceFactory.getCoreService() == null) break;
                CoreServiceFactory.getCoreService().resetToFactorySettingsWithServiceName("", this.getTarget());
                break;
            }
            case 100012: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".CoreServiceModelEvents.EV_CORE_SERVICE_REGISTRATION_STATUS").log();
                }
                int n = eventGeneric.getInt(0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).updateAuthenticationStatus(n);
                break;
            }
            case 1075041882: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".ASLOnlineServiceConstants.SET_INTERNAL_PRECHECK_ONLINE_SERVICE_ID").log();
                }
                int n = eventGeneric.getInt(0);
                String string = CoreServiceModelMap.getServiceIDWithPreCheckID(n, 0);
                if (CoreServiceFactory.getCoreService() != null && !Util.isNullOrEmpty(string)) {
                    CoreServiceFactory.getCoreService().checkServiceStatus(CoreServiceModelFactory.getPropertyManager().setPrecheckServiceID(string), CoreServiceModelFactory.getPropertyManager().setPrecheckUser(CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getMainUser()), this.getTarget());
                    this.trans(this.getTarget().getAuthenticationState());
                    break;
                }
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append("Either Coreservice interface is null or Service ID is null").log();
                }
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().setInternalPrecheckStatus(1);
                break;
            }
            case 1075041854: {
                int n = eventGeneric.getInt(0);
                if (this._subCategoryID == 1) {
                    if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
                        NavigationOnlinePoiService navigationOnlinePoiService = ASLNavigationFactory.getNavigationApi().getNavigationOnlinePoiService(new CoreServiceModelStateActive$1(this));
                        navigationOnlinePoiService.dynPoi2Service(n);
                    } else {
                        CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().sendSystemEvent(1107104512);
                    }
                } else {
                    String string = CoreServiceModelMap.getServiceIDWithPreCheckID(n, 0);
                    if (CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getServiceWithServiceID(string) == null) {
                        string = CoreServiceModelMap.getServiceIDWithPreCheckID(n, 1);
                    }
                    if (CoreServiceFactory.getCoreService() != null && !Util.isNullOrEmpty(string)) {
                        CoreServiceFactory.getCoreService().checkServiceStatus(CoreServiceModelFactory.getPropertyManager().setPrecheckServiceID(string), CoreServiceModelFactory.getPropertyManager().setPrecheckUser(CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getMainUser()), this.getTarget());
                        this.trans(this.getTarget().getAuthenticationState());
                    } else {
                        CoreServiceModelFactory.getPropertyManager().setPrecheckServiceID(string);
                        CoreServiceModelFactory.getPropertyManager().setPrecheckResult(59);
                        CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).serviceStatusResult(CoreServiceModelFactory.getPropertyManager().getPrecheckServiceID(), CoreServiceModelFactory.getPropertyManager().getPrecheckResult());
                    }
                }
                this._subCategoryID = 0;
                break;
            }
            case 1075041856: {
                this._subCategoryID = eventGeneric.getInt(0);
                break;
            }
            case 1073744697: {
                this.trans(this.getTarget().getSpellerState());
                break;
            }
            case 1075041824: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLSystemServiceIds.SET_POPUP_ONLINE_HANDLING_SKIP) : ").append(bl).log();
                }
                if (!bl) break;
                this.trans(this.getTarget().getNotActiveState());
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
                if (CoreServiceFactory.getCoreService() != null) {
                    CoreServiceFactory.getCoreService().validatePin(CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getMainUser(), CoreServiceModelFactory.getSpellerHandler().spellerOK(), this.getTarget());
                }
                this.trans(this.getTarget().getSpellerState());
                break;
            }
            case 1073744719: {
                CoreServiceModelFactory.getSpellerHandler().spellerDeleteChar();
                this.trans(this.getTarget().getSpellerState());
                break;
            }
            case 1073744721: {
                CoreServiceModelFactory.getSpellerHandler().spellerAddChar(eventGeneric.getString(0));
                this.trans(this.getTarget().getSpellerState());
                break;
            }
            case 1073744722: {
                CoreServiceModelFactory.getSpellerHandler().spellerSetCursorPosition(eventGeneric.getInt(0));
                this.trans(this.getTarget().getSpellerState());
                break;
            }
            case 1073744733: {
                CoreServiceModelFactory.getSpellerHandler().spellerEntered();
                this.trans(this.getTarget().getSpellerState());
                break;
            }
            case 1073744734: {
                CoreServiceModelFactory.getSpellerHandler().spellerCancel();
                break;
            }
            case 100001: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(4);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).notifyResetDone(n, n2);
                break;
            }
            case 100002: {
                int n = eventGeneric.getInt(1);
                if (n != -1 && n != 0) break;
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).updateUserList((OnlineUser[])eventGeneric.getObject(0));
                break;
            }
            case 4800013: {
                int n = CoreServiceModelMap.getModelResult(CoreServiceModelMap.convertToInternalOwnerVerificationResult(eventGeneric.getInt(1)), 0);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().setCarNetRegistrationState(n == 585 ? 1 : 2);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().sendSystemEvent(n);
                break;
            }
            case 100004: {
                int n = CoreServiceModelMap.getModelResult(eventGeneric.getInt(0), 1);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().setCarNetRegistrationState(n == 585 ? 1 : 2);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().sendSystemEvent(n);
                break;
            }
            case 100005: {
                String string = eventGeneric.getString(1);
                int n = eventGeneric.getInt(3);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).serviceStatusResult(string, n);
                break;
            }
            case 100006: {
                break;
            }
            case 100007: {
                break;
            }
            case 100008: {
                int n = eventGeneric.getInt(2);
                if (n != -1 && n != 0) break;
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).updateServiceList((OnlineService[])eventGeneric.getObject(1));
                break;
            }
            case 100009: {
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).handleRemainingServicesActivation(eventGeneric.getObject(4) != null ? (OnlineService)eventGeneric.getObject(4) : null);
                break;
            }
            case 100010: {
                break;
            }
            case 100019: {
                boolean bl = eventGeneric.getBoolean(0);
                int n = eventGeneric.getInt(1);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).handlePrivacyModeResult(n, bl);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

