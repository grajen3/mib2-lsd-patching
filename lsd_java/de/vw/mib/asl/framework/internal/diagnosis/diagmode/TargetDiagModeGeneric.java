/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode;

import de.vw.mib.asl.framework.internal.diagnosis.api.impl.DiagnosisServicesProvider;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.TargetDiagModeGeneric$StateInitial;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.TargetDiagModeGeneric$StateTop;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModeDeleteMemory;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModeDiagnosticValueChanged;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModePmlPassword;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModeSourceSwitchGeneric;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModeTestPicture;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.diagnose.DSIDiagnoseSystem;

public final class TargetDiagModeGeneric
extends AbstractASLHsmTarget {
    DiagModeSourceSwitchGeneric diagModeGenSourceSwitch = new DiagModeSourceSwitchGeneric(DiagnosisServicesProvider.getServices());
    DiagModeTestPicture diagModeGenTestPicture = new DiagModeTestPicture(this);
    DiagModePmlPassword diagModeGenPmlPassword = new DiagModePmlPassword(this);
    DiagModeDeleteMemory diagModeGenDeleteMemory = new DiagModeDeleteMemory(this);
    DiagModeDiagnosticValueChanged diagModeGenDiagnosticValueChanged = new DiagModeDiagnosticValueChanged(this);
    DSIDiagnoseSystem dsiDiagnoseSystem;
    int resultDeleteMemory = 2;
    int stateDeleteMemory = 2;
    final TargetDiagModeGeneric$StateTop stateTopDiagModeGen = new TargetDiagModeGeneric$StateTop(this, this.hsm, "DiagModeTop", this.getWorkStateParent());
    final TargetDiagModeGeneric$StateInitial stateInitial = new TargetDiagModeGeneric$StateInitial(this, this.hsm, "DiagModeInitial", this.stateTopDiagModeGen);
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIDiagnoseSystem;
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener;

    public TargetDiagModeGeneric(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public TargetDiagModeGeneric(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 7303;
    }

    void registerObservers() {
        this.dsiDiagnoseSystem = (DSIDiagnoseSystem)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$diagnose$DSIDiagnoseSystem == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystem = TargetDiagModeGeneric.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystem")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystem);
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener = TargetDiagModeGeneric.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystemListener")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener);
        ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener = TargetDiagModeGeneric.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystemListener")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener, dSIListener);
        this.dsiDiagnoseSystem.setNotification(new int[]{20}, dSIListener);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateTopDiagModeGen;
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

