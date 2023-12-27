/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.states;

import de.vw.mib.asl.api.bap.BAPInterfaceProvider;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.ocu.eni.states.ENIHsmContext;
import de.vw.mib.asl.internal.ocu.eni.states.ENIState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;

final class InitializeState
extends ENIState {
    private boolean _initialized = false;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$states$InitializeState;

    public InitializeState(ENIHsmContext eNIHsmContext, HsmState hsmState) {
        super(eNIHsmContext, (class$de$vw$mib$asl$internal$ocu$eni$states$InitializeState == null ? (class$de$vw$mib$asl$internal$ocu$eni$states$InitializeState = InitializeState.class$("de.vw.mib.asl.internal.ocu.eni.states.InitializeState")) : class$de$vw$mib$asl$internal$ocu$eni$states$InitializeState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
        this.performInitialization();
        this.goToState(this.getHsmContext().getWaitForLcuStartState());
    }

    @Override
    public void stateExit() {
    }

    private void performInitialization() {
        try {
            if (!this.isInitialized()) {
                this.getContextDelegate().registerObservers();
                this.getContextDelegate().getOCUServiceProxy().setMarshallingEnabled(true);
                BAPInterfaceProvider bAPInterfaceProvider = new BAPInterfaceProvider(ServiceManager.bundleContext);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.getContextDelegate().getLogicalControlUnit());
                bAPInterfaceProvider.getBapDispatcher().registerLogicalControlUnits(arrayList, false);
                this.setInitialized(true);
            }
        }
        catch (Exception exception) {
            this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier(), "Error during registrating of logical control unit", exception);
        }
    }

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
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

