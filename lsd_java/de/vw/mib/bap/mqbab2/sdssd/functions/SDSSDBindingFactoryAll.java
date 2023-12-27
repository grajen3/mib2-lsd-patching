/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.generated.sdssd.SDSSDBindingFactory;
import de.vw.mib.bap.mqbab2.sdssd.functions.ASGCapabilities;
import de.vw.mib.bap.mqbab2.sdssd.functions.CommandList;
import de.vw.mib.bap.mqbab2.sdssd.functions.FSGOperationStateHandling;
import de.vw.mib.bap.mqbab2.sdssd.functions.FSGSetup;
import de.vw.mib.bap.mqbab2.sdssd.functions.FunctionList;
import de.vw.mib.bap.mqbab2.sdssd.functions.InfoStates;
import de.vw.mib.bap.mqbab2.sdssd.functions.ResultList;
import de.vw.mib.bap.mqbab2.sdssd.functions.SDSContextState;

public class SDSSDBindingFactoryAll
implements SDSSDBindingFactory {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionList();
    }

    @Override
    public BAPStage createNewFSGSetupStage() {
        return new FSGSetup();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandling();
    }

    @Override
    public BAPStage createNewASGCapabilitiesStage() {
        return new ASGCapabilities();
    }

    @Override
    public BAPStage createNewSDSContextStateStage() {
        return new SDSContextState();
    }

    @Override
    public BAPStage createNewCommandListStage() {
        return new CommandList();
    }

    @Override
    public BAPStage createNewResultListStage() {
        return new ResultList();
    }

    @Override
    public BAPStage createNewInfoStatesStage() {
        return new InfoStates();
    }
}

