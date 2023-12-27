/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.PrivacySetup_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public class PrivacySetup
extends ENIFunction
implements PropertyListener,
InternalServiceProvider {
    private PrivacySetup_Status _privacySetup_Status;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener;

    public PrivacySetupServiceListener getPrivacySetupServiceListener() {
        return (PrivacySetupServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener = PrivacySetup.class$("de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener);
    }

    private PrivacySetup_Status getPrivacySetupStatus() {
        if (this._privacySetup_Status == null) {
            this._privacySetup_Status = new PrivacySetup_Status();
        }
        return this._privacySetup_Status;
    }

    private void _informServices() {
        PrivacySetup_Status privacySetup_Status = this.getPrivacySetupStatus();
        this.getPrivacySetupServiceListener().updateEniPrivacySetup(privacySetup_Status.setup.privacyModeIsActive);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("PrivacySetup: set privacy mode to: ").append(privacySetup_Status.setup.privacyModeIsActive);
        }
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener = PrivacySetup.class$("de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener, PrivacySetupServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 24;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        PrivacySetup_Status privacySetup_Status = (PrivacySetup_Status)bAPEntity;
        this.getPrivacySetupStatus().setup.privacyModeIsActive = privacySetup_Status.setup.privacyModeIsActive;
        this.didChangeValue(bAPEntity);
        this._informServices();
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (PrivacySetupServiceListener.SERVICE_CONSTANTS[0] == n) {
            this._informServices();
        }
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

