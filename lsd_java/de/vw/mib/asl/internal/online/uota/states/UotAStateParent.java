/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.states;

import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.uota.UotAFactory;
import de.vw.mib.asl.internal.online.uota.sequence.UotAPacketController;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;

public class UotAStateParent
extends AbstractHsmState
implements ASLOnlineServiceListener {
    private final UotATarget _target;
    private final String _classname = super.getClass().getName();
    private boolean _setNotifications;
    private boolean _startup;

    public UotAStateParent(UotATarget uotATarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = uotATarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".UotAStateParent()").log();
        }
    }

    private UotATarget getTarget() {
        return this._target;
    }

    private UotAPacketController getPacketController() {
        return UotAFactory.getPacketController(this.getTarget());
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".updateServiceStatusOnChange(").append(n).append(")").toString()).log();
        }
        if (n != 2 || n != 6) {
            ASLOnlineCoreServices aSLOnlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
            this.getTarget().getPropertyManager().setPPOIConfigurationOnly(ASLOnlineFactory.getOnlineCoreServices().isServiceAvailable(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(3)));
            this.getTarget().getPropertyManager().setUOTAPPOIConfigurationOnly(ASLOnlineFactory.getOnlineCoreServices().isServiceAvailable(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(20)));
            this.getTarget().getPropertyManager().setNavDBConfigurationOnly(ASLOnlineFactory.getOnlineCoreServices().isServiceAvailable(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(19)));
            if (this.getTarget().getPropertyManager().isUOTAPPOIConfigurationOnly()) {
                this.getTarget().getPropertyManager().setPPOIConfigurationOnly(false);
            }
            if (n == 0 && !this._startup) {
                this._startup = true;
                if (this.getTarget().getPropertyManager().isPPOIConfigurationOnly() || this.getTarget().getPropertyManager().isNavDBConfigurationOnly() || this.getTarget().getPropertyManager().isUOTAPPOIConfigurationOnly()) {
                    if (this.getTarget().getCurrentStateName().equalsIgnoreCase(this.getTarget().getStateNotActive().getName())) {
                        if (this.getTarget().getPropertyManager().isSWDLActive()) {
                            if (!this.getTarget().getCurrentStateName().equalsIgnoreCase(this.getTarget().getStateActiveSWDL().getName())) {
                                try {
                                    this.trans(this.getTarget().getStateActiveSWDL());
                                }
                                catch (Exception exception) {
                                    this.getTarget().error(exception);
                                }
                            }
                        } else if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                            if (this.getTarget().getPropertyManager().getDownloadState() == 4 || this.getTarget().getPropertyManager().getDownloadState() == 1) {
                                if (!this.getTarget().getCurrentStateName().equalsIgnoreCase(this.getTarget().getStateActiveDownload().getName())) {
                                    try {
                                        this.trans(this.getTarget().getStateActiveDownload());
                                    }
                                    catch (Exception exception) {
                                        this.getTarget().error(exception);
                                    }
                                }
                            } else {
                                if (this._target.getPropertyManager().isNaviDestinationsSetForLater() && UotAFactory.getNavigationGuidanceService(this._target).isRgActive() && !this._target.getPropertyManager().isNaviDestinationsTillNextRevision()) {
                                    this.getPacketController().requestForCurrentDestinationPackets();
                                    this.getTarget().getPropertyManager().setNaviDestinationsForLater(false);
                                } else if (this.getTarget().getPropertyManager().isDownloadForLater() && !this.getTarget().getPropertyManager().isDownloadTillNextRevision()) {
                                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1207767808);
                                    this.getTarget().getPropertyManager().setDownloadForLater(false);
                                }
                                if (!this.getTarget().getCurrentStateName().equalsIgnoreCase(this.getTarget().getStateActive().getName())) {
                                    try {
                                        this.trans(this.getTarget().getStateActive());
                                    }
                                    catch (Exception exception) {
                                        this.getTarget().error(exception);
                                    }
                                }
                            }
                        } else if (!this.getTarget().getCurrentStateName().equalsIgnoreCase(this.getTarget().getStateNotActive().getName())) {
                            try {
                                this.trans(this.getTarget().getStateNotActive());
                            }
                            catch (Exception exception) {
                                this.getTarget().error(exception);
                            }
                        }
                    } else {
                        this.getTarget().info().append(this._classname).append(new StringBuffer().append(".updateServiceStatusOnChange(").append(n).append(")--> already Active").toString()).log();
                    }
                }
            }
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append("->STARTED").log();
                }
                ASLOnlineCoreServices aSLOnlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
                aSLOnlineCoreServices.registerForServiceUpdate(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(3), this);
                aSLOnlineCoreServices.registerForServiceUpdate(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(20), this);
                aSLOnlineCoreServices.registerForServiceUpdate(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(19), this);
                this.trans(this.getTarget().getStateNotActive());
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append("->EXITED").log();
                break;
            }
            case 40003: {
                Object object;
                String string = eventGeneric.getString(1);
                this.getTarget().getPropertyManager().setCurrentLanguage(string);
                if (this.getTarget().getDSIUotA() != null) {
                    this.getTarget().getDSIUotA().setLanguage(string);
                }
                if (this.getTarget().isTraceEnabled()) {
                    object = this.getTarget().trace();
                    object.append(this._classname).append(" .handle(LscTNGEventDeclaration.LSCTNG_CHANGE_LANGUAGE)-> setLanguage = ").append(string).log();
                }
                object = ServiceManager.mGenericEventFactory.newEvent(1151074304);
                ((EventGeneric)object).setInt(0, eventGeneric.getInt(0));
                ((EventGeneric)object).setBoolean(1, true);
                ((EventGeneric)object).setString(2, string);
                this.getTarget().sendSafe((EventGeneric)object);
                break;
            }
            case 2300000: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLDownloadServiceIds.ASL_SWDL_CUSTOMER_SWDL_IS_STARTED_OR_RUNNING)").log();
                }
                this.getTarget().getPropertyManager().setSWDLActive(true);
                break;
            }
            case 2300001: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLDownloadServiceIds.ASL_SWDL_CUSTOMER_SWDL_HAS_ENDED)").log();
                }
                this.getTarget().getPropertyManager().setSWDLActive(false);
                break;
            }
            case 1075041861: {
                int n;
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.SET_ONLINE_UPDATES_AVAILABLE_INDICATION_TIME)").log();
                }
                if ((n = eventGeneric.getInt(0)) == 0) {
                    this.getTarget().getPropertyManager().setDownloadForLater(true);
                    break;
                }
                this.getTarget().getPropertyManager().setDownloadTillNextRevision(true);
                break;
            }
            case 1075041862: {
                int n;
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.SET_ONLINE_MAP_UPDATES_AVAILABLE_INDICATION_TIME)").log();
                }
                if ((n = eventGeneric.getInt(0)) == 0) {
                    this.getTarget().getPropertyManager().setNaviDestinationsForLater(true);
                    break;
                }
                this.getTarget().getPropertyManager().setNaviDestinationsTillNextRevision(true);
                break;
            }
            case 1075041852: {
                int n = eventGeneric.getInt(0);
                this.getPacketController().activateFilterBasedList(n);
                break;
            }
            case 2300005: {
                this.getTarget().getDSIUotA().triggerAction(UotAFactory.getSessionManager().getSessionID(), 5, "");
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiUotAUpdateServcieReady(int n, boolean bl, int n2) {
        UotAFactory.getSessionManager().setSessionID(n);
        this.getTarget().updateUOTAServiceStatus(bl);
        if (!this._setNotifications) {
            this.getTarget().setRemainingNotifications();
            this._setNotifications = true;
        }
        if (bl && !this.getTarget().getPropertyManager().isUotAServiceReady()) {
            this.getTarget().getPropertyManager().setUotAServiceReady(bl);
            if (this.getTarget().getDSIUotA() != null) {
                this.getTarget().getDSIUotA().getServerList();
            }
            if (!this.getTarget().getPropertyManager().isSWDLActive()) {
                try {
                    if (this.getTarget().getPropertyManager().getDownloadState() == 4 || this.getTarget().getPropertyManager().getDownloadState() == 1) {
                        this.trans(this.getTarget().getStateActiveDownload());
                    } else {
                        if (this._target.getPropertyManager().isNaviDestinationsSetForLater() && UotAFactory.getNavigationGuidanceService(this._target).isRgActive() && !this._target.getPropertyManager().isNaviDestinationsTillNextRevision()) {
                            this.getPacketController().requestForCurrentDestinationPackets();
                            this.getTarget().getPropertyManager().setNaviDestinationsForLater(false);
                        } else if (this.getTarget().getPropertyManager().isDownloadForLater() && !this.getTarget().getPropertyManager().isDownloadTillNextRevision()) {
                            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1207767808);
                            this.getTarget().getPropertyManager().setDownloadForLater(false);
                        }
                        this.trans(this.getTarget().getStateActive());
                    }
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append("->INITIALIZTION FINISHED").log();
            }
        }
    }

    public void dsiUotAGetServerList(int n, String[] stringArray) {
        this.getTarget().getPropertyManager().setServerList(stringArray);
    }

    public void dsiUotATriggerAction(int n, int n2, int n3, String string) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append("triggerActionResponse(").append(n).append(", ").append(n2).append(", ").append(n3).append(")").toString()).log();
        }
        switch (n3) {
            case 1: {
                this.getPacketController().notifyResetDone();
                break;
            }
            case 4: {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(238962944);
                eventGeneric.setBoolean(0, !Util.isNullOrEmpty(string) && string.equalsIgnoreCase("succ"));
                this.getTarget().sendSafe(eventGeneric);
                try {
                    if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                        this.trans(this.getTarget().getStateActive());
                        break;
                    }
                    this.trans(this.getTarget().getStateNotActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
                break;
            }
        }
    }

    public void dsiUotAAsyncException(int n, String string, int n2) {
        LogMessage logMessage = this.getTarget().warn();
        logMessage.append(this._classname).append(".dsiUotAAsyncException(Code=").append(n).append(", Message=").append(string).append(", Type=").append(n2).append(")").log();
        this.getPacketController().timeOutError(n, n2);
        try {
            if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                this.trans(this.getTarget().getStateActive());
            } else {
                this.trans(this.getTarget().getStateNotActive());
            }
        }
        catch (Exception exception) {
            this.getTarget().error(exception);
        }
    }
}

