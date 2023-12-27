/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.controller;

import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.controller.GenericFunctionControlUnit;
import de.vw.mib.bap.mqbab2.generated.navsd.BAPNavSDDataPool;
import de.vw.mib.bap.mqbab2.generated.navsd.NavSDBindingFactory;
import de.vw.mib.bap.mqbab2.generated.navsd.NavSDDemarshaller;
import de.vw.mib.bap.mqbab2.generated.navsd.NavSDMarshaller;
import de.vw.mib.bap.mqbab2.navsd.functions.NavSDBindingFactoryAll;
import de.vw.mib.bap.mqbab2.navsd.functions.NavSDBindingFactoryArabic;
import de.vw.mib.bap.mqbab2.navsd.functions.NavSDBindingFactoryChina;
import de.vw.mib.bap.mqbab2.navsd.functions.NavSDBindingFactoryNarNoNavi;
import de.vw.mib.bap.mqbab2.navsd.states.NavSdHsmContextDelegate;

class NavSDFunctionControlUnit
extends GenericFunctionControlUnit
implements BAPFunctionControlUnitExt {
    private final HsmContextDelegate _contextDelegate;
    private BAPIndicationMarshaller _navSdMarhaller;
    private BAPServiceListener _navSdDemarshaller;
    private BAPNavSDDataPool _dataPool;
    private NavSDBindingFactory _navSdBindingFactory;

    public NavSDFunctionControlUnit(NavSdHsmContextDelegate navSdHsmContextDelegate) {
        super(navSdHsmContextDelegate);
        this._contextDelegate = navSdHsmContextDelegate;
    }

    @Override
    protected HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    private NavSDBindingFactory getBindingFactory() {
        if (this._navSdBindingFactory == null) {
            ConfigurationService configurationService = APIFactory.getAPIFactory().getConfigurationService();
            this._navSdBindingFactory = this.isArabic() ? new NavSDBindingFactoryArabic() : (configurationService.isNARVariantSelected() && !configurationService.isNavigationFeatureSelected() ? new NavSDBindingFactoryNarNoNavi() : (configurationService.isChinaVariantSelected() ? new NavSDBindingFactoryChina() : new NavSDBindingFactoryAll()));
        }
        return this._navSdBindingFactory;
    }

    @Override
    protected void resetBindingFactory() {
        this._navSdBindingFactory = null;
        if (this.isInitialized()) {
            this.getNavSdFunctionRegistry().uninitialize();
            this.getNavSdFunctionRegistry().setFactory(this.getBindingFactory());
            this.getNavSdFunctionRegistry().initialize();
        } else {
            this.getNavSdFunctionRegistry().setFactory(this.getBindingFactory());
        }
    }

    @Override
    public BAPIndicationMarshaller getBAPMarshaller() {
        if (this._navSdMarhaller == null) {
            this._navSdMarhaller = new NavSDMarshaller(this.getBAPServiceProxy(), this.getBitStreamTransformer());
        }
        return this._navSdMarhaller;
    }

    @Override
    public AbstractBAPDataPool getContextDataPool() {
        return this.getNavSdFunctionRegistry();
    }

    @Override
    public BAPServiceListener getBAPDemarshaller() {
        if (this._navSdDemarshaller == null) {
            this._navSdDemarshaller = new NavSDDemarshaller(this.getContextDataPool(), this.getContextDataPool(), this.getBitStreamTransformer());
        }
        return this._navSdDemarshaller;
    }

    @Override
    public BAPFunctionRegistry getFunctionRegistry() {
        return this.getNavSdFunctionRegistry();
    }

    private BAPNavSDDataPool getNavSdFunctionRegistry() {
        if (this._dataPool == null) {
            this._dataPool = new BAPNavSDDataPool(this.getContextDelegate());
            this._dataPool.setFactory(this.getBindingFactory());
        }
        return this._dataPool;
    }

    @Override
    public void reinitialize() {
        this.getNavSdFunctionRegistry().reinitialize();
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public String getLogicalControlUnitName() {
        return "NavSD";
    }

    @Override
    public int getLogicalControlUnitID() {
        return 50;
    }
}

