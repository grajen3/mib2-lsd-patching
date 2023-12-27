/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;

public class CoreServiceModelStateAppActivation
extends AbstractHsmState {
    private final CoreServiceModelTarget _target;
    private final String _classname = super.getClass().getName();
    private int _subCategoryID;

    public CoreServiceModelStateAppActivation(CoreServiceModelTarget coreServiceModelTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = coreServiceModelTarget;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".CoreServiceModelStateAppActivation()").log();
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
            case 1075041850: {
                break;
            }
            case 1075041854: {
                int n = eventGeneric.getInt(0);
                if (this._subCategoryID == 1) {
                    if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
                        NavigationOnlinePoiService navigationOnlinePoiService = ASLNavigationFactory.getNavigationApi().getNavigationOnlinePoiService(this._target.getNavigationOnlinePoiListenerAdapter());
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
            case 1075041869: {
                break;
            }
            case 1075041865: {
                break;
            }
            case 1075041866: {
                break;
            }
            case 1075041868: {
                break;
            }
            case 1073744720: {
                if (CoreServiceFactory.getCoreService() == null) break;
                CoreServiceFactory.getCoreService().validatePin(CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getMainUser(), CoreServiceModelFactory.getSpellerHandler().spellerOK(), this.getTarget());
                break;
            }
            case 1073744719: {
                CoreServiceModelFactory.getSpellerHandler().spellerDeleteChar();
                break;
            }
            case 1073744721: {
                CoreServiceModelFactory.getSpellerHandler().spellerAddChar(eventGeneric.getString(0));
                break;
            }
            case 1073744722: {
                CoreServiceModelFactory.getSpellerHandler().spellerSetCursorPosition(eventGeneric.getInt(0));
                break;
            }
            case 1073744733: {
                CoreServiceModelFactory.getSpellerHandler().spellerEntered();
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
                if (!CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).isRemainingServicesForActivationEmpty()) break;
                this.trans(this.getTarget().getActiveState());
                break;
            }
            case 100010: {
                break;
            }
            case 100019: {
                boolean bl = eventGeneric.getBoolean(0);
                int n = eventGeneric.getInt(1);
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).handlePrivacyModeResult(n, bl);
                this.trans(this.getTarget().getActiveState());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

