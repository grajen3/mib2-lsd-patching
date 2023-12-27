/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.target;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.asl.internal.ocu.common.api.BAPDisplayControlUnit;
import de.vw.mib.asl.internal.ocu.ecall.target.ECallFunctionListenerRegistry;
import de.vw.mib.asl.internal.ocu.ecall.target.ECallFunctionRegistry;
import de.vw.mib.asl.internal.ocu.generated.ecall.ECallDemarshaller;
import de.vw.mib.asl.internal.ocu.generated.ecall.ECallMarshaller;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPRequestMarshaller;
import de.vw.mib.bap.marshalling.BAPService;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.stream.BitStreamTransformer;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.bap.DSIBAPListener;

class ECallControlUnit
implements BAPDisplayControlUnit {
    private final HsmContextDelegate _contextDelegate;
    private DSIBAP _serviceProvider;
    private ECallFunctionRegistry _eCallFunctionRegistry;
    private ECallFunctionListenerRegistry _eCallFunctionListenerRegistry;
    private BitStreamTransformer _bitStreamTransformer;
    private ECallDemarshaller _eCallDemarshaller;
    private ECallMarshaller _eCallMarshaller;
    private boolean _initialized;

    public ECallControlUnit(HsmContextDelegate hsmContextDelegate) {
        this._contextDelegate = hsmContextDelegate;
    }

    private HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    @Override
    public void initialize() {
    }

    @Override
    public boolean isInitialized() {
        return this._initialized;
    }

    @Override
    public void reinitialize() {
        this.getECallFunctionListenerRegistry().reinitialize();
    }

    @Override
    public void uninitialize() {
        this.getECallFunctionListenerRegistry().uninitialize();
    }

    @Override
    public void setService(DSIBAP dSIBAP) {
        if (this._serviceProvider != dSIBAP && dSIBAP != null) {
            this._serviceProvider = dSIBAP;
            this._initialized = true;
            this.getECallFunctionListenerRegistry().initialize();
            this.getContextDelegate().getOCUService().initialize();
        }
    }

    @Override
    public DSIBAP getService() {
        return this._serviceProvider;
    }

    @Override
    public DSIBAPListener getServiceListener() {
        return this.getContextDelegate().getOCUService();
    }

    @Override
    public BAPObserverRegistry getBapObserverRegistry() {
        return this.getECallFunctionListenerRegistry();
    }

    @Override
    public int getLogicalControlUnitID() {
        return 51;
    }

    @Override
    public boolean isDisplayControlUnit() {
        return true;
    }

    @Override
    public String getLogicalControlUnitName() {
        return "Extern Call";
    }

    @Override
    public BAPFunctionListenerRegistry getFunctionListenerRegistry() {
        if (!this.isInitialized()) {
            this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier(), "Tried to access the function listener registry, although the eCall control unit is not initialized");
        }
        return this.getECallFunctionListenerRegistry();
    }

    private ECallFunctionListenerRegistry getECallFunctionListenerRegistry() {
        if (this._eCallFunctionListenerRegistry == null) {
            this._eCallFunctionListenerRegistry = new ECallFunctionListenerRegistry(this.getContextDelegate());
        }
        return this._eCallFunctionListenerRegistry;
    }

    @Override
    public BAPFunctionRegistry getFunctionRegistry() {
        if (this._eCallFunctionRegistry == null) {
            this._eCallFunctionRegistry = new ECallFunctionRegistry(this.getContextDelegate());
        }
        return this._eCallFunctionRegistry;
    }

    @Override
    public BitStreamTransformer getBitStreamTransformer() {
        if (this._bitStreamTransformer == null) {
            this._bitStreamTransformer = new BitStreamTransformer();
        }
        return this._bitStreamTransformer;
    }

    @Override
    public BAPServiceListener getBAPDemarshaller() {
        if (this._eCallDemarshaller == null) {
            this._eCallDemarshaller = new ECallDemarshaller(this.getFunctionListenerRegistry(), this.getFunctionRegistry(), this.getBitStreamTransformer());
        }
        return this._eCallDemarshaller;
    }

    @Override
    public BAPRequestMarshaller getBAPMarshaller() {
        if (this._eCallMarshaller == null) {
            this._eCallMarshaller = new ECallMarshaller(this.getBAPService(), this.getBitStreamTransformer());
        }
        return this._eCallMarshaller;
    }

    @Override
    public BAPService getBAPService() {
        return this.getContextDelegate().getOCUService();
    }
}

