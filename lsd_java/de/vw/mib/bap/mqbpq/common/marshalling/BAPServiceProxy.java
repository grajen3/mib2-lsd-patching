/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.marshalling;

import de.vw.mib.asl.api.bap.lcu.BAPLogicalControlUnit;
import de.vw.mib.bap.marshalling.BAPService;

public class BAPServiceProxy
implements BAPService {
    private final BAPLogicalControlUnit _logicalControlUnit;

    private BAPLogicalControlUnit getLogicalControlUnit() {
        return this._logicalControlUnit;
    }

    public BAPServiceProxy(BAPLogicalControlUnit bAPLogicalControlUnit) {
        this._logicalControlUnit = bAPLogicalControlUnit;
    }

    @Override
    public void request(int n, int n2, int n3, int n4) {
        this.getLogicalControlUnit().getService().request(this.getLogicalControlUnit().getLogicalControlUnitID(), n, n2, n3, n4);
    }

    @Override
    public void requestVoid(int n, int n2) {
        this.getLogicalControlUnit().getService().requestVoid(this.getLogicalControlUnit().getLogicalControlUnitID(), n, n2);
    }

    @Override
    public void requestByteSequence(int n, int n2, byte[] byArray) {
        this.getLogicalControlUnit().getService().requestByteSequence(this.getLogicalControlUnit().getLogicalControlUnitID(), n, n2, byArray);
    }

    @Override
    public void requestError(int n, int n2) {
        this.getLogicalControlUnit().getService().requestError(this.getLogicalControlUnit().getLogicalControlUnitID(), n, n2);
    }
}

