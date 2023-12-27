/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.controller;

import de.vw.mib.asl.api.bap.lcu.ControlUnitState;
import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbpq.common.controller.ArabicVariantChecker;
import de.vw.mib.bap.mqbpq.common.controller.TemporyTargetDelegate;
import de.vw.mib.bap.mqbpq.common.marshalling.BAPServiceProxy;
import de.vw.mib.bap.stream.BitStreamTransformer;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.bap.DSIBAPListener;

public abstract class GenericFunctionControlUnit
implements BAPFunctionControlUnitExt {
    private BitStreamTransformer _bitStreamTransformer;
    private BAPServiceProxy _bapServiceProxy;
    private TemporyTargetDelegate _temporaryTargetDelegate;
    private boolean _initialized;
    private DSIBAP _service;
    private boolean _isArabic;

    public GenericFunctionControlUnit(TemporyTargetDelegate temporyTargetDelegate) {
        this._temporaryTargetDelegate = temporyTargetDelegate;
    }

    protected abstract HsmContextDelegate getContextDelegate() {
    }

    private TemporyTargetDelegate getTargetDelegate() {
        return this._temporaryTargetDelegate;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
    }

    protected BitStreamTransformer getBitStreamTransformer() {
        if (this._bitStreamTransformer == null) {
            this._bitStreamTransformer = new BitStreamTransformer();
        }
        return this._bitStreamTransformer;
    }

    protected BAPServiceProxy getBAPServiceProxy() {
        if (this._bapServiceProxy == null) {
            this._bapServiceProxy = new BAPServiceProxy(this);
        }
        return this._bapServiceProxy;
    }

    private void initializeHsm(HsmState hsmState) {
        Hsm hsm = this.getTargetDelegate().getHsm();
        hsm.init(this.getLogicalControlUnitName(), hsmState);
        hsm.onStart();
    }

    protected boolean isArabic() {
        return this._isArabic;
    }

    void setArabic(boolean bl) {
        if (!this._isArabic && bl) {
            this._isArabic = bl;
            this.resetBindingFactory();
            this.getContextDelegate().getFsgService().variantChanged();
        }
    }

    protected void registerForVariantChecking() {
        ArabicVariantChecker arabicVariantChecker = new ArabicVariantChecker(this);
        arabicVariantChecker.initialize();
    }

    protected abstract void resetBindingFactory() {
    }

    @Override
    public void activateTransition() {
    }

    @Override
    public ControlUnitState getcurrentState() {
        return (ControlUnitState)((Object)this.getTargetDelegate().getHsm().getState());
    }

    @Override
    public void initialize() {
        this.initializeHsm(this.getTargetDelegate().getDefaultState());
        this.registerForVariantChecking();
        this.getContextDataPool().initialize();
        this.setInitialized(true);
    }

    @Override
    public boolean isInitialized() {
        return this._initialized;
    }

    @Override
    public void setService(DSIBAP dSIBAP) {
        this._service = dSIBAP;
        this.getcurrentState().initialize();
    }

    @Override
    public DSIBAP getService() {
        return this._service;
    }

    @Override
    public DSIBAPListener getServiceListener() {
        return this.getcurrentState();
    }

    @Override
    public BAPObserverRegistry getBapObserverRegistry() {
        return this.getContextDataPool();
    }

    @Override
    public boolean isDisplayControlUnit() {
        return false;
    }
}

