/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.states;

import de.vw.mib.asl.api.bap.lcu.ControlUnitState;
import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbpq.common.api.FSGService;
import de.vw.mib.bap.mqbpq.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbpq.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbpq.common.states.FsgHsmContext;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public abstract class AbstractControlUnitState
extends AbstractHsmState
implements ControlUnitState,
FSGService {
    private final FsgHsmContext _hsmContext;

    public AbstractControlUnitState(FsgHsmContext fsgHsmContext, String string, HsmState hsmState) {
        super(fsgHsmContext.getHsm(), string, hsmState);
        this._hsmContext = fsgHsmContext;
    }

    protected FsgHsmContext getHsmContext() {
        return this._hsmContext;
    }

    protected AbstractBAPDataPool getContextDataPool() {
        return this.getContextDelegate().getLogicalControlUnit().getContextDataPool();
    }

    protected BAPFunctionControlUnitExt getLogicalControlUnit() {
        return this.getHsmContext().getContextDelegate().getLogicalControlUnit();
    }

    protected HsmContextDelegate getContextDelegate() {
        return this.getHsmContext().getContextDelegate();
    }

    private FSGServiceProxy getProxyMarshaller() {
        return this.getContextDelegate().getFsgServiceProxy();
    }

    protected LogMessage getLogErrorMessage(int n, String string) {
        BAPFunctionControlUnitExt bAPFunctionControlUnitExt = this.getContextDelegate().getLogicalControlUnit();
        return this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier()).append("State = ").append(this.getName()).append("::").append(string).append(", lsgID = ").append(bAPFunctionControlUnitExt.getLogicalControlUnitID()).append(", fctID = ").append(n);
    }

    protected void goToState(HsmState hsmState) {
        try {
            this.trans(hsmState);
            this.getHsmContext().getHsm().activateTransition();
        }
        catch (Exception exception) {
            this.getContextDelegate().getLogger().error(2, "Error during transition", exception);
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        return this.getProxyMarshaller().deMarshallEvent(eventGeneric, this) ? null : this.getParent();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void allDataPoolValuesAreValid() {
    }
}

