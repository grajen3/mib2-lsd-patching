/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.target;

import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.asl.internal.ocu.eni.target.ENIFunctionRegistry$ENIFunctionRegistryAdapter;
import de.vw.mib.asl.internal.ocu.eni.target.ENIFunctionRegistry$FunctionRegistryAdapter;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;

class ENIFunctionRegistry
implements BAPFunctionRegistry {
    private final HsmContextDelegate _contextDelegate;
    private ENIFunctionRegistry$ENIFunctionRegistryAdapter _registryAdapter;

    public ENIFunctionRegistry(HsmContextDelegate hsmContextDelegate) {
        this._contextDelegate = hsmContextDelegate;
    }

    private HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    private ENIFunctionRegistry$FunctionRegistryAdapter getRegistryAdapter(int n) {
        if (this._registryAdapter == null) {
            this._registryAdapter = new ENIFunctionRegistry$ENIFunctionRegistryAdapter(this.getContextDelegate().getLogicalControlUnit().getBAPMarshaller(), this.getContextDelegate().getLogicalControlUnit().getFunctionListenerRegistry().getFunctionList(), this.getContextDelegate().getLogger());
        }
        return this._registryAdapter.getRegistryAdapter(n);
    }

    @Override
    public BAPFunction getBAPFunction(int n) {
        return this.getRegistryAdapter(n);
    }

    @Override
    public Array getArray(int n) {
        return this.getRegistryAdapter(n);
    }

    @Override
    public Method getMethod(int n) {
        return this.getRegistryAdapter(n);
    }

    @Override
    public Property getProperty(int n) {
        return this.getRegistryAdapter(n);
    }

    @Override
    public FSGOperationState getBapFSGOperationStateFunction() {
        throw new UnsupportedOperationException("getBapFSGOperationStateFunction not supported in ASG");
    }
}

