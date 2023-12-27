/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt.activator;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.AbstractDialogActivator;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;

public class StandAloneApplicant
extends AbstractDialogActivator {
    private final SpeechGeneralLogger logger;
    private boolean ignoreFirstPttRelease;

    public StandAloneApplicant(DialogSession dialogSession, Services services) {
        super("StandAloneApplicant", dialogSession, services);
        this.logger = new SpeechGeneralLogger(new StringBuffer().append("[").append(this.name).append("]: ").toString(), 4096);
        this.ignoreFirstPttRelease = false;
    }

    @Override
    public void onSinglePressed(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onPressed(n);
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Activate new speech session.").log();
            }
            this.dialogSession.activate();
            this.ignoreFirstPttRelease = true;
        }
    }

    @Override
    public void onSingleReleased(int n) {
        if (this.dialogSession.isActive()) {
            if (this.ignoreFirstPttRelease) {
                this.ignoreFirstPttRelease = false;
            } else {
                this.dialogSession.onReleased(n);
            }
        }
    }
}

