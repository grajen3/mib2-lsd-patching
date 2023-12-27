/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.master.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.common.controller.ControllerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceProvider;
import de.vw.mib.asl.internal.mostkombi.common.services.DsiServiceProvider;
import de.vw.mib.asl.internal.mostkombi.master.states.MostKombiHsmContext;
import de.vw.mib.asl.internal.mostkombi.master.states.MostKombiHsmContextDelegate;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MostKombiMasterController
extends AbstractASLHsmTarget
implements MostKombiHsmContextDelegate,
Controller,
ControllerDelegate {
    private static final int MOST_KOMBI_NUMBER_OF_CONTROLLERS_TO_START;
    private MostKombiHsmContext _hsmContext;
    private boolean _initialized;
    private Set _childControllers;

    public MostKombiMasterController(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    private Set getChildControllers() {
        if (this._childControllers == null) {
            this._childControllers = new HashSet();
        }
        return this._childControllers;
    }

    @Override
    public int getClassifier() {
        return 16;
    }

    @Override
    protected HsmState getDefaultState() {
        if (!this.isInitialized()) {
            this.setInitialized(true);
            this.registerObservers();
        }
        return this.getHsmContext().getRunningState();
    }

    @Override
    public int getDefaultTargetId() {
        return 1404835328;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event received: ").append(eventGeneric.getReceiverEventId()).append(" arguments: ").append(eventGeneric.getParamString()).log();
        }
        super.gotEvent(eventGeneric);
    }

    private MostKombiHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new MostKombiHsmContext(this.getHsm(), this.getWorkStateParent());
            this._hsmContext.setDelegate(this);
        }
        return this._hsmContext;
    }

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
    }

    private void registerObservers() {
        this.registerService(1078676480, true);
        this.triggerObserver(1095453696, null);
    }

    @Override
    public Category getCategory(Controller controller, int n) {
        Iterator iterator = this.getChildControllers().iterator();
        Category category = null;
        while (category == null && iterator.hasNext()) {
            Controller controller2 = (Controller)iterator.next();
            if (controller2 == controller) continue;
            category = controller2.getCategory(n);
        }
        return category;
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
    public Controller getController() {
        return this;
    }

    public Target getTarget() {
        return this;
    }

    @Override
    public AslServiceProvider getServiceProvider() {
        return null;
    }

    @Override
    public void addStartedKombiController(Controller controller) {
        this.getChildControllers().add(controller);
        controller.setControllerDelegate(this);
        if (this.getChildControllers().size() == 3) {
            this.triggerObserver(1112230912, null);
            this.triggerObserver(1129008128, null);
        }
    }

    @Override
    public void initialize() {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void setControllerDelegate(ControllerDelegate controllerDelegate) {
    }

    @Override
    public Category getCategory(int n) {
        return null;
    }

    @Override
    public DsiServiceProvider getDsiServiceProvider() {
        return null;
    }
}

