/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.states;

import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.asl.internal.ocu.common.api.BAPDisplayControlUnit;
import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.asl.internal.ocu.common.api.OcuServiceProxy;
import de.vw.mib.asl.internal.ocu.common.states.CommonHsmContext;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.bap.util.BAPErrorCodes;

abstract class AsgControlUnitState
extends AbstractHsmState
implements OCUService {
    private final CommonHsmContext _hsmContext;

    public AsgControlUnitState(CommonHsmContext commonHsmContext, String string, HsmState hsmState) {
        super(commonHsmContext.getHsm(), string, hsmState);
        this._hsmContext = commonHsmContext;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        return this.getProxyMarshaller().deMarshallEvent(eventGeneric, this) ? null : this.getParent();
    }

    private OcuServiceProxy getProxyMarshaller() {
        return this.getContextDelegate().getOCUServiceProxy();
    }

    protected CommonHsmContext getHsmContext() {
        return this._hsmContext;
    }

    protected HsmContextDelegate getContextDelegate() {
        return this.getHsmContext().getContextDelegate();
    }

    protected LogMessage getLogErrorMessage(int n, String string) {
        BAPDisplayControlUnit bAPDisplayControlUnit = this.getContextDelegate().getLogicalControlUnit();
        return this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier()).append("State = ").append(this.getName()).append("::").append(string).append(", lsgID = ").append(bAPDisplayControlUnit.getLogicalControlUnitID()).append(", fctID = ").append(n);
    }

    protected void goToState(HsmState hsmState) {
        try {
            this.trans(hsmState);
        }
        catch (Exception exception) {
            this.getContextDelegate().getLogger().error(2, "Error during transition", exception);
        }
    }

    @Override
    public void initialize() {
    }

    @Override
    public void bapStateStatus(int n, int n2) {
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().acknowledge(n2, n3)) {
            this.getLogErrorMessage(n2, "acknowledge").append(" not processed, acknowledgeType = ").append(n3).log();
        }
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indication(n2, n3, n4, n5)) {
            this.getLogErrorMessage(n2, "indication").append(" not processed, indicationType = ").append(n4).log();
        }
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indication(n2, n3, byArray)) {
            this.getLogErrorMessage(n2, "indicationByteSequence").append(" not processed, indicationType = ").append(n3).log();
        }
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indication(n2, n3)) {
            this.getLogErrorMessage(n2, "indicationVoid").append(" not processed, indicationType = ").append(n3).log();
        }
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indicationError(n2, n3)) {
            this.getLogErrorMessage(n2, "indicationError").append(", errorCode = ").append(n3).append(", meaning = ").append(BAPErrorCodes.stringFromErrorCode(n3)).log();
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier()).append("asyncException errorMsg = ").append(string).log();
    }

    public void getBAPState() {
        BAPDisplayControlUnit bAPDisplayControlUnit = this.getContextDelegate().getLogicalControlUnit();
        bAPDisplayControlUnit.getService().getBAPState(bAPDisplayControlUnit.getLogicalControlUnitID());
    }

    public void setHMIState(int n) {
        BAPDisplayControlUnit bAPDisplayControlUnit = this.getContextDelegate().getLogicalControlUnit();
        bAPDisplayControlUnit.getService().setHMIState(bAPDisplayControlUnit.getLogicalControlUnitID(), n);
    }

    @Override
    public void requestVoid(int n, int n2) {
        BAPDisplayControlUnit bAPDisplayControlUnit = this.getContextDelegate().getLogicalControlUnit();
        bAPDisplayControlUnit.getService().requestVoid(bAPDisplayControlUnit.getLogicalControlUnitID(), n, n2);
    }

    @Override
    public void request(int n, int n2, int n3, int n4) {
        BAPDisplayControlUnit bAPDisplayControlUnit = this.getContextDelegate().getLogicalControlUnit();
        bAPDisplayControlUnit.getService().request(bAPDisplayControlUnit.getLogicalControlUnitID(), n, n2, n3, n4);
    }

    @Override
    public void requestByteSequence(int n, int n2, byte[] byArray) {
        BAPDisplayControlUnit bAPDisplayControlUnit = this.getContextDelegate().getLogicalControlUnit();
        bAPDisplayControlUnit.getService().requestByteSequence(bAPDisplayControlUnit.getLogicalControlUnitID(), n, n2, byArray);
    }

    @Override
    public void requestError(int n, int n2) {
        BAPDisplayControlUnit bAPDisplayControlUnit = this.getContextDelegate().getLogicalControlUnit();
        bAPDisplayControlUnit.getService().requestError(bAPDisplayControlUnit.getLogicalControlUnitID(), n, n2);
    }
}

