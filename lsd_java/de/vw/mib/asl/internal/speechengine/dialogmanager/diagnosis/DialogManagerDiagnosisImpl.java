/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosis;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisImpl$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisImpl$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStack;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStackListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import java.util.ArrayList;
import java.util.List;

public class DialogManagerDiagnosisImpl
implements DialogManagerDiagnosis {
    protected static DialogManagerLogger logger = new DialogManagerLogger("[DialogManagerDiagnosis] ");
    private final BackStack backStack;
    private final DialogManagerInternal dialogManager;
    protected List dialogManagerDiagnosisListeners;
    protected int dialogManagerState;
    private BackStackListener backstackListener = new DialogManagerDiagnosisImpl$1(this);
    private DialogManagerStateListener dialogManagerStateListener = new DialogManagerDiagnosisImpl$2(this);

    public DialogManagerDiagnosisImpl(DialogManagerInternal dialogManagerInternal, BackStack backStack) {
        this.dialogManager = dialogManagerInternal;
        this.backStack = backStack;
        this.dialogManagerDiagnosisListeners = new ArrayList();
    }

    @Override
    public void registerDialogManagerDiagnosisListener(DialogManagerDiagnosisListener dialogManagerDiagnosisListener) {
        if (logger.isTraceEnabled()) {
            logger.trace("DialogManager diagnosis listener registered");
        }
        this.dialogManagerDiagnosisListeners.add(dialogManagerDiagnosisListener);
        if (this.dialogManagerDiagnosisListeners.size() == 1) {
            this.backStack.addBackStackListener(this.backstackListener);
            this.dialogManager.registerDialogManagerStateListener(this.dialogManagerStateListener);
        } else {
            dialogManagerDiagnosisListener.changedBackStack(this.backStack.toString());
            dialogManagerDiagnosisListener.changedDialogManagerState(this.dialogManagerState);
        }
    }

    @Override
    public void unregisterDialogManagerDiagnosisListener(DialogManagerDiagnosisListener dialogManagerDiagnosisListener) {
        if (logger.isTraceEnabled()) {
            logger.trace("DialogManager diagnosis listener unregistered");
        }
        this.dialogManagerDiagnosisListeners.remove(dialogManagerDiagnosisListener);
        if (this.dialogManagerDiagnosisListeners.size() == 0) {
            this.backStack.removeBackStackListener(this.backstackListener);
            this.dialogManager.unregisterDialogManagerStateListener(this.dialogManagerStateListener);
        }
    }
}

