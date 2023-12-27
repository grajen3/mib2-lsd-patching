/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.kombipictureserver.common.category.Category;
import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryManagerDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.controller.Controller;
import de.vw.mib.asl.internal.kombipictureserver.common.sequence.Sequence;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceProvider;
import de.vw.mib.asl.internal.kombipictureserver.common.services.DsiServiceProvider;
import de.vw.mib.asl.internal.kombipictureserver.controller.PictureServerCategoryManager;
import de.vw.mib.asl.internal.kombipictureserver.states.PictureServerHsmContext;
import de.vw.mib.asl.internal.kombipictureserver.states.PictureServerHsmContextDelegate;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class PictureServerController
extends AbstractASLHsmTarget
implements PictureServerHsmContextDelegate,
Controller,
CategoryManagerDelegate {
    private PictureServerHsmContext _hsmContext;
    private PictureServerCategoryManager _categoryManager;

    public PictureServerController(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    private PictureServerHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new PictureServerHsmContext(this.getHsm(), this.getWorkStateParent());
            this._hsmContext.setDelegate(this);
        }
        return this._hsmContext;
    }

    private PictureServerCategoryManager getCategoryManager() {
        if (this._categoryManager == null) {
            this._categoryManager = new PictureServerCategoryManager(this);
        }
        return this._categoryManager;
    }

    @Override
    public int getClassifier() {
        return 2;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.getHsmContext().getInitializeState();
    }

    @Override
    public int getDefaultTargetId() {
        return 1083512320;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event received: ").append(eventGeneric.getReceiverEventId()).append(" arguments: ").append(eventGeneric.getParamString()).log();
        }
        super.gotEvent(eventGeneric);
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
    public Category findCategory(int n) {
        return null;
    }

    @Override
    public Target getTarget() {
        return this;
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
    public Controller getController() {
        return this;
    }

    @Override
    public AslServiceProvider getServiceProvider() {
        return this.getCategoryManager();
    }

    @Override
    public DsiServiceProvider getDsiServiceProvider() {
        return this.getCategoryManager();
    }
}

