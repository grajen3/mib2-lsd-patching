/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateAwaitDsiReadyForProfileChanges$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateDsiUnavailableError;

public class StateAwaitDsiReadyForProfileChanges
extends State {
    private static final long TIMEOUT;
    private PersonalizedAppListener listener;

    @Override
    public void onEnter(Context context) {
        DsiAdapterProvider dsiAdapterProvider = context.getServices().getDsiAdapterProvider();
        AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = context.getDsiAdapter();
        this.listener = this.createDsiReadyListener(context);
        try {
            dsiAdapterProvider.addDsiListener(abstractPersonalizedAppDsiAdapter, this.listener);
        }
        catch (Exception exception) {
            String string = DsiUtil.getSimpleClassName(abstractPersonalizedAppDsiAdapter.getDsiClass());
            String string2 = new StringBuffer().append("Failed to add dsi listener for adapter of dsi >").append(string).append("< cause: ").append(exception.getMessage()).toString();
            context.logError(string2, exception);
            context.transitionToState(new StateDsiUnavailableError(string2));
            return;
        }
        context.startTimer(0);
    }

    @Override
    public void onExit(Context context) {
        AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = context.getDsiAdapter();
        DsiAdapterProvider dsiAdapterProvider = context.getServices().getDsiAdapterProvider();
        dsiAdapterProvider.removeDsiListener(abstractPersonalizedAppDsiAdapter, this.listener);
    }

    @Override
    public void onTimeout(Context context) {
        context.transitionToState(new StateDsiUnavailableError("waiting for signal 'ready for profil changes' timedout after 5000ms."));
    }

    private PersonalizedAppListener createDsiReadyListener(Context context) {
        return new StateAwaitDsiReadyForProfileChanges$1(this, context);
    }

    @Override
    public boolean isFinalState() {
        return false;
    }
}

