/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.BAP_Config_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPConfigVersionCheck;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class BAPConfig
extends ENIFunction
implements PropertyListener,
BAPConfigVersionCheck {
    private boolean _versionCheckSucceded;

    private boolean isVersionCheckSucceeded() {
        return this._versionCheckSucceded;
    }

    private void setVersionCheckSucceeded(boolean bl) {
        this._versionCheckSucceded = bl;
    }

    private void _checkBapConfig(BAP_Config_Status bAP_Config_Status) {
        this.setVersionCheckSucceeded(bAP_Config_Status.bap_Version_major == 3 && bAP_Config_Status.lsg_Version_major == 3);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        }
    }

    @Override
    public void uninitialize() {
        this.setVersionCheckSucceeded(false);
    }

    @Override
    public int getFunctionId() {
        return 2;
    }

    @Override
    public boolean checkVersion(BAPEntity bAPEntity) {
        return this.isVersionCheckSucceeded();
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        this.didGotError(n);
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        this._checkBapConfig((BAP_Config_Status)bAPEntity);
        this.didChangeValue(bAPEntity);
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }
}

