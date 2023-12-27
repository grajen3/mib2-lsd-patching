/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.modelapi;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.ModelApiTracer;
import de.vw.mib.debug.service.probes.app.modelapi.ModelApiCodec;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.ModelApiUpEvent;

public class ModelApiProbe
extends AbstractDebugProbe
implements ModelApiTracer {
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$ModelApiTracer;

    public ModelApiProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        return true;
    }

    @Override
    protected boolean configureProbe() {
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.probeSystemServices.registerService((class$de$vw$mib$app$framework$diag$ModelApiTracer == null ? (class$de$vw$mib$app$framework$diag$ModelApiTracer = ModelApiProbe.class$("de.vw.mib.app.framework.diag.ModelApiTracer")) : class$de$vw$mib$app$framework$diag$ModelApiTracer).getName(), this);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$app$framework$diag$ModelApiTracer == null ? (class$de$vw$mib$app$framework$diag$ModelApiTracer = ModelApiProbe.class$("de.vw.mib.app.framework.diag.ModelApiTracer")) : class$de$vw$mib$app$framework$diag$ModelApiTracer).getName(), this);
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
    }

    @Override
    public void traceModelApiDownCall(AppDiag appDiag, ModelApiDownEvent modelApiDownEvent, int n) {
        ModelApiCodec modelApiCodec = (ModelApiCodec)this.probeSystemServices.borrowCodec();
        modelApiCodec.encodeModelApiDownCall(appDiag, modelApiDownEvent, n);
        this.probeSystemServices.releaseCodec(modelApiCodec);
    }

    @Override
    public void traceModelApiUnboundDownCall(AppDiag appDiag, String string) {
        ModelApiCodec modelApiCodec = (ModelApiCodec)this.probeSystemServices.borrowCodec();
        modelApiCodec.encodeModelApiUnboundDownCall(appDiag, string);
        this.probeSystemServices.releaseCodec(modelApiCodec);
    }

    @Override
    public void traceModelApiUnboundUpCall(AppDiag appDiag, String string) {
        ModelApiCodec modelApiCodec = (ModelApiCodec)this.probeSystemServices.borrowCodec();
        modelApiCodec.encodeModelApiUnboundUpCall(appDiag, string);
        this.probeSystemServices.releaseCodec(modelApiCodec);
    }

    @Override
    public void traceModelApiUpCall(AppDiag appDiag, ModelApiUpEvent modelApiUpEvent, int n) {
        ModelApiCodec modelApiCodec = (ModelApiCodec)this.probeSystemServices.borrowCodec();
        modelApiCodec.encodeModelApiUpCall(appDiag, modelApiUpEvent, n);
        this.probeSystemServices.releaseCodec(modelApiCodec);
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

