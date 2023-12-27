/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.target;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.asl.internal.ocu.common.api.BAPDisplayControlUnit;
import de.vw.mib.asl.internal.ocu.eni.target.ENIFunctionListenerRegistry;
import de.vw.mib.asl.internal.ocu.eni.target.ENIFunctionRegistry;
import de.vw.mib.asl.internal.ocu.generated.eni.ENIDemarshaller;
import de.vw.mib.asl.internal.ocu.generated.eni.ENIMarshaller;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPRequestMarshaller;
import de.vw.mib.bap.marshalling.BAPService;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.stream.BitStreamTransformer;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.bap.DSIBAPListener;

class ENIControlUnit
implements BAPDisplayControlUnit {
    private final HsmContextDelegate _contextDelegate;
    private DSIBAP _serviceProvider;
    private ENIFunctionRegistry _eniFunctionRegistry;
    private ENIFunctionListenerRegistry _eniFunctionListenerRegistry;
    private BitStreamTransformer _bitStreamTransformer;
    private ENIDemarshaller _eniDemarshaller;
    private ENIMarshaller _eniMarshaller;
    private boolean _initialized;

    public ENIControlUnit(HsmContextDelegate hsmContextDelegate) {
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
        this.getENIFunctionListenerRegistry().reinitialize();
    }

    @Override
    public void uninitialize() {
        this.getENIFunctionListenerRegistry().uninitialize();
    }

    @Override
    public void setService(DSIBAP dSIBAP) {
        if (this._serviceProvider != dSIBAP && dSIBAP != null) {
            this._serviceProvider = dSIBAP;
            this._initialized = true;
            this.getENIFunctionListenerRegistry().initialize();
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
        return this.getENIFunctionListenerRegistry();
    }

    @Override
    public int getLogicalControlUnitID() {
        return 55;
    }

    @Override
    public boolean isDisplayControlUnit() {
        return true;
    }

    @Override
    public String getLogicalControlUnitName() {
        return "Extended Network Interface";
    }

    @Override
    public BAPFunctionListenerRegistry getFunctionListenerRegistry() {
        if (!this.isInitialized()) {
            this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier(), "Tried to access the function listener registry, although the ENI control unit is not initialized");
        }
        return this.getENIFunctionListenerRegistry();
    }

    private ENIFunctionListenerRegistry getENIFunctionListenerRegistry() {
        if (this._eniFunctionListenerRegistry == null) {
            this._eniFunctionListenerRegistry = new ENIFunctionListenerRegistry(this.getContextDelegate());
        }
        return this._eniFunctionListenerRegistry;
    }

    @Override
    public BAPFunctionRegistry getFunctionRegistry() {
        if (this._eniFunctionRegistry == null) {
            this._eniFunctionRegistry = new ENIFunctionRegistry(this.getContextDelegate());
        }
        return this._eniFunctionRegistry;
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
        if (this._eniDemarshaller == null) {
            this._eniDemarshaller = new ENIDemarshaller(this.getFunctionListenerRegistry(), this.getFunctionRegistry(), this.getBitStreamTransformer());
        }
        return this._eniDemarshaller;
    }

    @Override
    public BAPRequestMarshaller getBAPMarshaller() {
        if (this._eniMarshaller == null) {
            this._eniMarshaller = new ENIMarshaller(this.getBAPService(), this.getBitStreamTransformer());
        }
        return this._eniMarshaller;
    }

    @Override
    public BAPService getBAPService() {
        return this.getContextDelegate().getOCUService();
    }
}

