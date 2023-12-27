/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.target;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentContext;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerUpdates;
import de.vw.mib.asl.framework.internal.entertainmentmanager.api.impl.EntertainmentManagerServiceImpl;
import de.vw.mib.asl.framework.internal.entertainmentmanager.target.EntertainmentManagerTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class TopState
extends AbstractHsmState
implements HsmState {
    private final EntertainmentManagerTarget target;

    public TopState(EntertainmentManagerTarget entertainmentManagerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = entertainmentManagerTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1400010: {
                int n = this.handleRegister("", eventGeneric, false);
                this.target.getController().sendRestoreLsmStartup(n, eventGeneric.getSenderTargetId());
                break;
            }
            case 1400015: {
                int n = this.handleRegister("2", eventGeneric, true);
                this.target.getController().sendStartup2(n);
                break;
            }
            case 1400023: {
                EntertainmentContext entertainmentContext = (EntertainmentContext)eventGeneric.getObject(0);
                int n = entertainmentContext.contextId();
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append(this.target.getHsm().getState().getName()).append(" TopState: Received REGISTER3_TARGET targetId: ").append(entertainmentContext.targetId()).append(", context: ").append(n).log();
                }
                this.target.getController().getTargetRegistry().register(entertainmentContext, true);
                this.target.getController().sendStartup2(n);
                break;
            }
            case 100002: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("TopState: Received STARTUP2_ANSWER, targetId = ").append(eventGeneric.getSenderTargetId()).log();
                }
                this.target.getController().startup2Answer(eventGeneric);
                break;
            }
            case 100003: {
                EntertainmentManagerUpdates entertainmentManagerUpdates = (EntertainmentManagerUpdates)eventGeneric.getObject(0);
                this.target.getController().addUpdates(entertainmentManagerUpdates);
                break;
            }
            case 1400011: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("TopState: Received DEREGISTER_TARGET, targetId = ").append(eventGeneric.getSenderTargetId()).log();
                }
                if (eventGeneric.getParamType(0) != 1) {
                    this.target.getController().getTargetRegistry().deregisterByTargetId(eventGeneric.getSenderTargetId());
                    break;
                }
                this.target.getController().getTargetRegistry().deregisterByContext(eventGeneric.getInt(0));
                break;
            }
            case 3: {
                this.target.addObservers(this.target.getController().getActivationEvents());
                this.target.getController().initPersistence();
                EntertainmentManagerServiceImpl.getInstance().register();
                this.trans(this.target.stateIdle);
                break;
            }
            case 4: {
                this.target.info().append("EntertainmentManager/POWER_OFF ").append(this.target.getController()).log();
                break;
            }
            case 1400000: 
            case 0x155CC1: 
            case 1400002: {
                this.target.appendEvent(this.target.warn().append("Unexpected Message in "), eventGeneric).log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private int handleRegister(String string, EventGeneric eventGeneric, boolean bl) {
        boolean bl2;
        int n = eventGeneric.getSenderTargetId();
        int n2 = eventGeneric.getInt(0);
        int n3 = eventGeneric.getInt(1);
        boolean bl3 = bl2 = eventGeneric.getParamType(2) == 2 && eventGeneric.getBoolean(2);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(this.target.getHsm().getState().getName()).append(" TopState: Received REGISTER").append(string).append("_TARGET targetId: ").append(n).append(", context: ").append(n2).log();
        }
        int n4 = -1;
        if (eventGeneric.getParamType(3) == 1) {
            n4 = eventGeneric.getInt(3);
        }
        this.target.getController().getTargetRegistry().register(n, n2, n3, bl2, n4, bl);
        return n2;
    }
}

