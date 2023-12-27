/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.controller;

import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationServiceListener;
import de.vw.mib.bap.mqbab2.common.controller.GenericFunctionControlUnit;
import de.vw.mib.bap.mqbab2.generated.telephone.BAPTelephoneDataPool;
import de.vw.mib.bap.mqbab2.generated.telephone.TelephoneBindingFactory;
import de.vw.mib.bap.mqbab2.generated.telephone.TelephoneDemarshaller;
import de.vw.mib.bap.mqbab2.generated.telephone.TelephoneMarshaller;
import de.vw.mib.bap.mqbab2.telephone.controller.TelephoneFunctionControlUnit$1;
import de.vw.mib.bap.mqbab2.telephone.functions.TelephoneBindingFactoryAll;
import de.vw.mib.bap.mqbab2.telephone.functions.TelephoneBindingFactoryArabic;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.TelephoneBindingFactoryCarPlay;
import de.vw.mib.bap.mqbab2.telephone.states.TelephoneHsmContextDelegate;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

class TelephoneFunctionControlUnit
extends GenericFunctionControlUnit
implements BAPFunctionControlUnitExt,
SmartphoneIntegrationServiceListener {
    private final HsmContextDelegate _contextDelegate;
    private BAPIndicationMarshaller _telephoneMarhaller;
    private BAPServiceListener _telephoneDemarshaller;
    private BAPTelephoneDataPool _dataPool;
    private TelephoneBindingFactory _telephoneBindingFactory;
    private boolean _isCarPlayActive;
    protected static final int[] SMARTPHONE_INTEGRATION_LISTENER_IDS = new int[]{1114057728};

    public TelephoneFunctionControlUnit(TelephoneHsmContextDelegate telephoneHsmContextDelegate) {
        super(telephoneHsmContextDelegate);
        this._contextDelegate = telephoneHsmContextDelegate;
    }

    @Override
    protected HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    void checkCarPlayActive() {
        boolean bl;
        boolean bl2 = bl = APIFactory.getAPIFactory().getSmartphoneIntegrationService().getSmarphoneIntegrationActiveConnectionType() == 2;
        if (this._isCarPlayActive != bl) {
            this._isCarPlayActive = bl;
            this.resetBindingFactory();
            this.getContextDelegate().getFsgService().variantChanged();
        }
    }

    private boolean isCarPlayActive() {
        return this._isCarPlayActive;
    }

    private TelephoneBindingFactory getBindingFactory() {
        if (this._telephoneBindingFactory == null) {
            this._telephoneBindingFactory = this.isCarPlayActive() ? new TelephoneBindingFactoryCarPlay() : (this.isArabic() ? new TelephoneBindingFactoryArabic() : new TelephoneBindingFactoryAll());
        }
        return this._telephoneBindingFactory;
    }

    @Override
    protected void resetBindingFactory() {
        this._telephoneBindingFactory = null;
        if (this.isInitialized()) {
            this.getTelephoneFunctionRegistry().uninitialize();
            this.getTelephoneFunctionRegistry().setFactory(this.getBindingFactory());
            this.getTelephoneFunctionRegistry().initialize();
        } else {
            this.getTelephoneFunctionRegistry().setFactory(this.getBindingFactory());
        }
    }

    @Override
    protected void registerForVariantChecking() {
        super.registerForVariantChecking();
        APIFactory.getAPIFactory().getSmartphoneIntegrationService().addSmartphoneIntegrationServiceListener(this, SMARTPHONE_INTEGRATION_LISTENER_IDS);
        this.checkCarPlayActive();
    }

    @Override
    public BAPIndicationMarshaller getBAPMarshaller() {
        if (this._telephoneMarhaller == null) {
            this._telephoneMarhaller = new TelephoneMarshaller(this.getBAPServiceProxy(), this.getBitStreamTransformer());
        }
        return this._telephoneMarhaller;
    }

    @Override
    public AbstractBAPDataPool getContextDataPool() {
        return this.getTelephoneFunctionRegistry();
    }

    @Override
    public BAPServiceListener getBAPDemarshaller() {
        if (this._telephoneDemarshaller == null) {
            this._telephoneDemarshaller = new TelephoneDemarshaller(this.getContextDataPool(), this.getContextDataPool(), this.getBitStreamTransformer());
        }
        return this._telephoneDemarshaller;
    }

    @Override
    public BAPFunctionRegistry getFunctionRegistry() {
        return this.getTelephoneFunctionRegistry();
    }

    private BAPTelephoneDataPool getTelephoneFunctionRegistry() {
        if (this._dataPool == null) {
            this._dataPool = new BAPTelephoneDataPool(this.getContextDelegate());
            this._dataPool.setFactory(this.getBindingFactory());
        }
        return this._dataPool;
    }

    @Override
    public void reinitialize() {
        this.getTelephoneFunctionRegistry().reinitialize();
    }

    @Override
    public void uninitialize() {
        APIFactory.getAPIFactory().getSmartphoneIntegrationService().removeSmartphoneIntegrationServiceListener(this, SMARTPHONE_INTEGRATION_LISTENER_IDS);
    }

    @Override
    public String getLogicalControlUnitName() {
        return "Telephone";
    }

    @Override
    public int getLogicalControlUnitID() {
        return 40;
    }

    @Override
    public void updateSmartphoneIntegrationData(SmartphoneIntegrationService smartphoneIntegrationService, int n) {
        ThreadSwitchingTarget threadSwitchingTarget = APIFactory.getAPIFactory().getThreadSwitchingService();
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            threadSwitchingTarget.enqueue(new TelephoneFunctionControlUnit$1(this));
        } else {
            this.checkCarPlayActive();
        }
    }
}

