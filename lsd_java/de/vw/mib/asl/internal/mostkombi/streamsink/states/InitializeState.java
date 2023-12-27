/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.states;

import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkHsmContext;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkState;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public class InitializeState
extends StreamSinkState {
    private boolean _initialized;
    private boolean _mainControllerInformed;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$states$InitializeState;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener;

    public InitializeState(StreamSinkHsmContext streamSinkHsmContext, HsmState hsmState) {
        super(streamSinkHsmContext, (class$de$vw$mib$asl$internal$mostkombi$streamsink$states$InitializeState == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$states$InitializeState = InitializeState.class$("de.vw.mib.asl.internal.mostkombi.streamsink.states.InitializeState")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$states$InitializeState).getName(), hsmState);
    }

    private boolean isMainControllerInformed() {
        return this._mainControllerInformed;
    }

    private void setMainControllerInformed(boolean bl) {
        this._mainControllerInformed = bl;
    }

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
    }

    private void _initialize() {
        int[] nArray = new int[]{1112230912, 1129008128, 1095453696};
        this.getContextDelegate().addObservers(nArray);
        int[] nArray2 = new int[]{1};
        DSIKOMOGfxStreamSink dSIKOMOGfxStreamSink = (DSIKOMOGfxStreamSink)this.getContextDelegate().getDsiServiceProvider().getDsiService(this.getHsmContext().getHsm(), class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = InitializeState.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink);
        this.getContextDelegate().getDsiServiceProvider().addDsiServiceResponder(this.getHsmContext().getHsm(), (DSIBase)dSIKOMOGfxStreamSink, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = InitializeState.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, nArray2);
    }

    private void informThatMostKombiControllerStarted(Controller controller) {
        if (!this.isMainControllerInformed()) {
            this.sendSafe(1078676480, controller);
            this.setMainControllerInformed(true);
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = super.handle(eventGeneric);
        if (eventGeneric.getReceiverEventId() != 1112230912) {
            if (eventGeneric.getReceiverEventId() == 1129008128) {
                hsmState = null;
                this.goToState(this.getHsmContext().getWaitForServicesState());
            } else if (eventGeneric.getReceiverEventId() == 1095453696) {
                this.setMainControllerInformed(false);
                this.informThatMostKombiControllerStarted(this.getContextDelegate().getController());
            }
        }
        return hsmState;
    }

    @Override
    protected void stateEntry() {
    }

    @Override
    protected void stateStart() {
        if (!this.isInitialized()) {
            this._initialize();
            this.setInitialized(true);
        }
    }

    @Override
    protected void stateExit() {
    }

    @Override
    public void dsiKOMOGfxStreamSinkUpdateGfxState(int n, int n2) {
        super.dsiKOMOGfxStreamSinkUpdateGfxState(n, n2);
        if (n == 1) {
            this.informThatMostKombiControllerStarted(this.getContextDelegate().getController());
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

