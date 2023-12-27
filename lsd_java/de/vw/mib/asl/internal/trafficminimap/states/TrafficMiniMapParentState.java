/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.states;

import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapController;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapManager;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapParentState$1;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public class TrafficMiniMapParentState
extends AbstractHsmState {
    private final TrafficMiniMapTarget _target;
    private final String _classname;

    public TrafficMiniMapParentState(TrafficMiniMapTarget trafficMiniMapTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._classname = "TrafficMiniMapParentState";
        this._target = trafficMiniMapTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapParentState").append(".TrafficMiniMapParentState()").log();
        }
    }

    private TrafficMiniMapTarget getTarget() {
        return this._target;
    }

    private TrafficMiniMapController getController() {
        return TrafficMiniMapManager.getTrafficMiniMapController();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 4800009: {
                boolean bl = ASLOnlineFactory.getOnlineCoreServices().isServiceConfigured(new TrafficMiniMapParentState$1(this));
                if (bl) {
                    this.trans(this.getTarget().getStateActive());
                    break;
                }
                this.trans(this.getTarget().getStateNotActive());
                break;
            }
            case 4300062: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapParentState").append(".handle(ASLSystemServiceIds.RELOAD_PERSISTABLES)").log();
                }
                this.getTarget().initPersistence();
                break;
            }
            case 40003: {
                Object object;
                String string = eventGeneric.getString(1);
                this.getController().handleSettingInfo(0, string, false);
                if (this.getTarget().isTraceEnabled()) {
                    object = this.getTarget().trace();
                    object.append("TrafficMiniMapParentState").append(" .handle(LscTNGEventDeclaration.LSCTNG_CHANGE_LANGUAGE)-> Language ").append(string).log();
                }
                object = ServiceManager.mGenericEventFactory.newEvent(1151074304);
                ((EventGeneric)object).setInt(0, eventGeneric.getInt(0));
                ((EventGeneric)object).setBoolean(1, true);
                ((EventGeneric)object).setString(2, string);
                this.getTarget().sendSafe((EventGeneric)object);
                break;
            }
            case 2200001: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("TrafficMiniMapParentState").append(".handle(ASLConnectivityServiceIds.ASL_CONNECTIVITY_IS_DATA_CONNECTION_AVAILABLE)").log();
                break;
            }
            case 1076541824: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapParentState").append(".handle(ASLTrafficMiniMapServiceConstants.TOGGLE_HOT_SPOT_MAP_AUTOMATIC_RECEPTION)").log();
                }
                this.getController().handleHotSpotMiniMapSetupStatus();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAsiaTrafficInfoMenuUpdatePrefecture(String string, int n) {
        if (n == 1) {
            this.getController().updatePrefecture(string);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateProbeDataSetting(boolean bl, int n) {
        if (n == 1) {
            this.getController().updateProbeDataSetting(bl);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateFrequency(int n, int n2) {
        if (n2 == 1) {
            this.getController().updateFrequency(n);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateReceptionDate(DateTime dateTime, int n) {
        if (n == 1) {
            this.getController().updateReceptionDate(dateTime);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateReceivableStations(TunerData[] tunerDataArray, int n) {
        if (n == 1) {
            this.getController().updateReceivableStations(tunerDataArray);
        }
    }

    public void dsiAsiaTrafficInfoMenuSetLanguageResponse(boolean bl) {
        this.getController().responseSetLanguage(bl);
    }

    public void dsiAsiaTrafficInfoMenuAsyncException(int n, String string, int n2) {
        LogMessage logMessage = this.getTarget().warn();
        logMessage.append("TrafficMiniMapParentState").append(".dsiAsiaTrafficInfoMenuAsyncException(Code=").append(n).append(", Message=").append(string).append(", Type=").append(n2).append(")").log();
        this.getController().asyncException(n, n2);
    }
}

