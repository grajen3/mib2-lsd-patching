/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryManagerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.common.controller.ControllerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceProvider;
import de.vw.mib.asl.internal.mostkombi.common.services.DsiServiceProvider;
import de.vw.mib.asl.internal.mostkombi.streamsink.controller.StreamSinkCategoryManager;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkHsmContext;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkHsmContextDelegate;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class GfxStreamSinkController
extends AbstractASLHsmTarget
implements StreamSinkHsmContextDelegate,
Controller,
CategoryManagerDelegate {
    private ControllerDelegate _delegate;
    private StreamSinkHsmContext _hsmContext;
    private StreamSinkCategoryManager _categoryManager;
    private boolean _initialized;

    public GfxStreamSinkController(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public int getClassifier() {
        return 16;
    }

    @Override
    public int getSubClassifier() {
        return 4;
    }

    @Override
    protected HsmState getDefaultState() {
        if (!this.isInitialized()) {
            this.setInitialized(true);
            this.registerObservers();
        }
        return this.getHsmContext().getStartState();
    }

    @Override
    public int getDefaultTargetId() {
        return 1388058112;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event received: ").append(eventGeneric.getReceiverEventId()).append(" arguments: ").append(eventGeneric.getParamString()).log();
        }
        super.gotEvent(eventGeneric);
    }

    private StreamSinkHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new StreamSinkHsmContext(this.getHsm(), this.getWorkStateParent());
            this._hsmContext.setDelegate(this);
        }
        return this._hsmContext;
    }

    private StreamSinkCategoryManager getCategoryManager() {
        if (this._categoryManager == null) {
            this._categoryManager = new StreamSinkCategoryManager(this);
        }
        return this._categoryManager;
    }

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
    }

    private void registerObservers() {
        this.registerService(1095453696, true);
    }

    private ControllerDelegate getDelegate() {
        return this._delegate;
    }

    @Override
    public void setControllerDelegate(ControllerDelegate controllerDelegate) {
        this._delegate = controllerDelegate;
    }

    @Override
    public Category getCategory(int n) {
        return this.getCategoryManager().findCategory(n);
    }

    @Override
    public Sequence getSequence(int n) {
        return (Sequence)((Object)this.getCategory(n));
    }

    @Override
    public Logger getLogger() {
        return this.getTextLogger();
    }

    @Override
    public void initialize() {
        this.getCategoryManager().initialize();
    }

    @Override
    public void uninitialize() {
        this.getCategoryManager().uninitialize();
    }

    @Override
    public Controller getController() {
        return this;
    }

    @Override
    public AslServiceProvider getServiceProvider() {
        return this.getCategoryManager();
    }

    @Override
    public Category findCategory(int n) {
        return this.getDelegate().getCategory(this, n);
    }

    @Override
    public Target getTarget() {
        return this;
    }

    @Override
    public DsiServiceProvider getDsiServiceProvider() {
        return this.getCategoryManager();
    }
}

