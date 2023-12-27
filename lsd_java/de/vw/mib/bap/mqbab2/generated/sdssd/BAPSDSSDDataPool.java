/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.generated.sdssd.SDSSDBindingFactory;

public class BAPSDSSDDataPool
extends AbstractBAPDataPool {
    private SDSSDBindingFactory _factory;

    public BAPSDSSDDataPool(HsmContextDelegate hsmContextDelegate) {
        super(hsmContextDelegate);
    }

    public SDSSDBindingFactory getFactory() {
        return this._factory;
    }

    public void setFactory(SDSSDBindingFactory sDSSDBindingFactory) {
        this._factory = sDSSDBindingFactory;
    }

    @Override
    public final void initialize() {
        this.initializeInternal(this._factory);
        super.initialize();
        this._factory = null;
    }

    public final void reinitialize(SDSSDBindingFactory sDSSDBindingFactory) {
        super.uninitialize();
        this.initializeInternal(sDSSDBindingFactory);
        super.initialize();
        this._factory = null;
    }

    private void initializeInternal(SDSSDBindingFactory sDSSDBindingFactory) {
        this.addStage(sDSSDBindingFactory.createNewFunctionListStage(), 3, 1, "FunctionList");
        this.addStage(sDSSDBindingFactory.createNewFSGOperationStateStage(), 0, 1, "FSGOperationState");
        this.addStage(sDSSDBindingFactory.createNewFSGSetupStage(), 3, 1, "FSGSetup");
        this.addStage(sDSSDBindingFactory.createNewASGCapabilitiesStage(), 3, 1, "ASGCapabilities");
        this.addStage(sDSSDBindingFactory.createNewSDSContextStateStage(), 3, 1, "SDS_ContextState");
        this.addStage(sDSSDBindingFactory.createNewCommandListStage(), 3, 2, "CommandList");
        this.addStage(sDSSDBindingFactory.createNewResultListStage(), 3, 2, "ResultList");
        this.addStage(sDSSDBindingFactory.createNewInfoStatesStage(), 3, 1, "InfoStates");
    }
}

