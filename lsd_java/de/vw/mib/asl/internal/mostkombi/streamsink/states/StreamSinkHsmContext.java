/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.states;

import de.vw.mib.asl.internal.mostkombi.streamsink.states.InitializeState;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.RunningState;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkHsmContextDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.WaitForServices;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StreamSinkHsmContext {
    private final Hsm _hsm;
    private final HsmState _defaultParentState;
    private StreamSinkHsmContextDelegate _delegate;
    private HsmState _initializeState;
    private HsmState _runningState;
    private WaitForServices _waitForServices;
    private int _gfxState;

    public StreamSinkHsmContext(Hsm hsm, HsmState hsmState) {
        this._hsm = hsm;
        this._defaultParentState = hsmState;
    }

    public Hsm getHsm() {
        return this._hsm;
    }

    public StreamSinkHsmContextDelegate getContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(StreamSinkHsmContextDelegate streamSinkHsmContextDelegate) {
        this._delegate = streamSinkHsmContextDelegate;
    }

    private HsmState getDefaultParentState() {
        return this._defaultParentState;
    }

    public HsmState getStartState() {
        return this.getInitializeState();
    }

    public HsmState getInitializeState() {
        if (this._initializeState == null) {
            this._initializeState = new InitializeState(this, this.getDefaultParentState());
        }
        return this._initializeState;
    }

    public HsmState getRunningState() {
        if (this._runningState == null) {
            this._runningState = new RunningState(this, this.getDefaultParentState());
        }
        return this._runningState;
    }

    public HsmState getWaitForServicesState() {
        if (this._waitForServices == null) {
            this._waitForServices = new WaitForServices(this, this.getDefaultParentState());
        }
        return this._waitForServices;
    }

    int getGfxState() {
        return this._gfxState;
    }

    void setGfxState(int n) {
        this._gfxState = n;
    }
}

