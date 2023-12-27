/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.cio;

import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.framework.diag.CioDiagListener;
import de.vw.mib.cio.framework.diag.CioDiagService;
import de.vw.mib.cio.framework.diag.CioIntentDiag;
import de.vw.mib.debug.service.probes.app.cio.CioCodec;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import java.util.Iterator;
import java.util.List;

public final class CioProbe
extends AbstractDebugProbe
implements CioDiagListener {
    private CioDiagService cioDiagService;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$diag$CioDiagService;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$diag$CioDiagListener;

    public CioProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.cioDiagService = (CioDiagService)this.probeSystemServices.getService((class$de$vw$mib$cio$framework$diag$CioDiagService == null ? (class$de$vw$mib$cio$framework$diag$CioDiagService = CioProbe.class$("de.vw.mib.cio.framework.diag.CioDiagService")) : class$de$vw$mib$cio$framework$diag$CioDiagService).getName());
        return true;
    }

    @Override
    protected boolean activateProbe() {
        List list = this.cioDiagService.getRegisteredCioIntents();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.onCioIntentRegistered((CioIntentDiag)iterator.next());
        }
        this.probeSystemServices.registerService((class$de$vw$mib$cio$framework$diag$CioDiagListener == null ? (class$de$vw$mib$cio$framework$diag$CioDiagListener = CioProbe.class$("de.vw.mib.cio.framework.diag.CioDiagListener")) : class$de$vw$mib$cio$framework$diag$CioDiagListener).getName(), this);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$cio$framework$diag$CioDiagListener == null ? (class$de$vw$mib$cio$framework$diag$CioDiagListener = CioProbe.class$("de.vw.mib.cio.framework.diag.CioDiagListener")) : class$de$vw$mib$cio$framework$diag$CioDiagListener).getName(), this);
        return true;
    }

    @Override
    protected boolean configureProbe() {
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
    }

    @Override
    public void onCioIntentChanged(CioIntentDiag cioIntentDiag) {
        CioCodec cioCodec = (CioCodec)this.probeSystemServices.borrowCodec();
        cioCodec.sendCioChanged((CioIntentClassData)this.cioDiagService.getCioIntentClasses().get(cioIntentDiag.getCioIntentClass()), cioIntentDiag);
        this.probeSystemServices.releaseCodec(cioCodec);
    }

    @Override
    public void onCioIntentExecute(CioIntentDiag cioIntentDiag, CioActionParameters cioActionParameters) {
        CioCodec cioCodec = (CioCodec)this.probeSystemServices.borrowCodec();
        cioCodec.sendCioExecute((CioIntentClassData)this.cioDiagService.getCioIntentClasses().get(cioIntentDiag.getCioIntentClass()), cioIntentDiag, cioActionParameters);
        this.probeSystemServices.releaseCodec(cioCodec);
    }

    @Override
    public void onCioIntentRegistered(CioIntentDiag cioIntentDiag) {
        CioCodec cioCodec = (CioCodec)this.probeSystemServices.borrowCodec();
        cioCodec.sendCioRegistered((CioIntentClassData)this.cioDiagService.getCioIntentClasses().get(cioIntentDiag.getCioIntentClass()), cioIntentDiag);
        this.probeSystemServices.releaseCodec(cioCodec);
    }

    @Override
    public void onCioIntentUnregistered(CioIntentDiag cioIntentDiag) {
        CioCodec cioCodec = (CioCodec)this.probeSystemServices.borrowCodec();
        cioCodec.sendCioUnregistered((CioIntentClassData)this.cioDiagService.getCioIntentClasses().get(cioIntentDiag.getCioIntentClass()), cioIntentDiag);
        this.probeSystemServices.releaseCodec(cioCodec);
    }

    @Override
    public void onCioVisualizationChanged(CioIntentDiag cioIntentDiag) {
        CioCodec cioCodec = (CioCodec)this.probeSystemServices.borrowCodec();
        cioCodec.sendCioChanged((CioIntentClassData)this.cioDiagService.getCioIntentClasses().get(cioIntentDiag.getCioIntentClass()), cioIntentDiag);
        this.probeSystemServices.releaseCodec(cioCodec);
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

