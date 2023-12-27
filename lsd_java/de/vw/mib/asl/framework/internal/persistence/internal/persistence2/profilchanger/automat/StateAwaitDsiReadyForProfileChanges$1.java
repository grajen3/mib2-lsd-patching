/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.PersonalizedAppAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateAwaitDsiReadyForProfileChanges;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateDsiReadyForProfileChanges;

class StateAwaitDsiReadyForProfileChanges$1
extends PersonalizedAppAdapter {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ StateAwaitDsiReadyForProfileChanges this$0;

    StateAwaitDsiReadyForProfileChanges$1(StateAwaitDsiReadyForProfileChanges stateAwaitDsiReadyForProfileChanges, Context context) {
        this.this$0 = stateAwaitDsiReadyForProfileChanges;
        this.val$context = context;
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if (n != 2) {
            Class clazz = this.val$context.getDsiAdapter().getDsiClass();
            String string = DsiUtil.getSimpleClassName(clazz);
            String string2 = DsiUtil.getNameOfProfileState(n);
            String string3 = new StringBuffer().append("StateAwaitDsiReadyForProfileChanges.updateProfilState state was:").append(string2).append("\n  dsi=").append(string).toString();
            this.val$context.logTrace(string3);
            return;
        }
        if (n3 != 1) {
            return;
        }
        this.val$context.transitionToState(new StateDsiReadyForProfileChanges());
    }
}

