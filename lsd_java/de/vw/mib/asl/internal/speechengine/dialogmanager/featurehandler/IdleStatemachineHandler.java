/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.IdleStatemachineHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;
import de.vw.mib.asl.internal.speechengine.features.client.context.IdleStatemachineContextFeature;
import java.util.ArrayList;
import java.util.List;

public class IdleStatemachineHandler
implements DialogManagerStateListener {
    protected DialogManagerLogger logger = new DialogManagerLogger("[IdleStatemachineHandler] ");
    private DialogManagerInternal dialogManager;
    private int dialogManagerState;
    private List activeStatemachines;
    private FeatureHandler idleFeatureHandler = new IdleStatemachineHandler$1(this);

    public IdleStatemachineHandler(DialogManagerInternal dialogManagerInternal) {
        this.dialogManager = dialogManagerInternal;
        this.activeStatemachines = new ArrayList();
        this.dialogManager.registerFeatureHandler(202, this.idleFeatureHandler);
        this.dialogManager.registerDialogManagerStateListener(this);
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        this.dialogManagerState = n2;
        if (n2 == 1) {
            this.setAllIdle();
        }
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
        this.dialogManagerState = n;
    }

    void handleIdleFeature(int n, IdleStatemachineContextFeature idleStatemachineContextFeature) {
        if (idleStatemachineContextFeature.isIdleValid()) {
            if (idleStatemachineContextFeature.isIdle()) {
                this.setIdle(n);
            } else {
                this.setActive(n);
            }
        }
    }

    private void setIdle(int n) {
        int n2 = this.indexOfStatemachine(n);
        if (n2 < 0) {
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("triggered setIdle() on client : ").append(SpeechClientIdentifiersUtil.toString(n)).toString());
        }
        this.activeStatemachines.remove(n2);
        this.dialogManager.fireIdleEvent(n);
    }

    private void setActive(int n) {
        int n2 = this.indexOfStatemachine(n);
        if (n2 >= 0) {
            return;
        }
        if (!this.activeStatemachines.isEmpty()) {
            this.setAllIdle();
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("triggered setActive() on client : ").append(SpeechClientIdentifiersUtil.toString(n)).toString());
        }
        this.activeStatemachines.add(new Integer(n));
        if (this.dialogManagerState == 1) {
            this.logger.warn("triggered setActive() on an IDLE session -> setAllIdle()");
            this.setAllIdle();
        }
    }

    private int indexOfStatemachine(int n) {
        for (int i2 = 0; i2 < this.activeStatemachines.size(); ++i2) {
            if ((Integer)this.activeStatemachines.get(i2) != n) continue;
            return i2;
        }
        return -1;
    }

    private void setAllIdle() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("triggered setAllIdle()");
        }
        ArrayList arrayList = new ArrayList(this.activeStatemachines);
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            this.setIdle((Integer)arrayList.get(i2));
        }
        this.activeStatemachines.clear();
    }
}

