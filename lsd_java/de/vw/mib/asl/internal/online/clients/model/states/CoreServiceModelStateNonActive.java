/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public class CoreServiceModelStateNonActive
extends AbstractHsmState {
    private final CoreServiceModelTarget _target;
    private final String _classname = super.getClass().getName();

    public CoreServiceModelStateNonActive(CoreServiceModelTarget coreServiceModelTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = coreServiceModelTarget;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".CoreServiceModelStateNonActive()").log();
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
                this.getTarget().setCurrentState(this);
                break;
            }
            case 4: {
                break;
            }
            case 1075041851: {
                break;
            }
            case 1073744697: {
                break;
            }
            case 1075041854: {
                CoreServiceModelFactory.getCoreServiceModelController(this.getTarget()).getModelHandler().sendSystemEvent(1107104512);
                break;
            }
            case 1075041856: {
                break;
            }
            case 1075041824: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(".handle(ASLSystemServiceIds.SET_POPUP_ONLINE_HANDLING_SKIP) : ").append(bl).log();
                }
                if (bl) break;
                this.trans(this.getTarget().getParentState());
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
            case 100001: {
                break;
            }
            case 100002: {
                break;
            }
            case 4800013: {
                break;
            }
            case 100004: {
                break;
            }
            case 100005: {
                break;
            }
            case 100006: {
                break;
            }
            case 100007: {
                break;
            }
            case 100008: {
                break;
            }
            case 100009: {
                break;
            }
            case 100010: {
                break;
            }
            case 100019: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

