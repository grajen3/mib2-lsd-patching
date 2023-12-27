/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;

public class StateDsiUnavailableError
extends State {
    private final String cause;

    public StateDsiUnavailableError(String string) {
        this.cause = string;
    }

    @Override
    public void onEnter(Context context) {
        String string = DsiUtil.getSimpleClassName(context.getDsiAdapter().getDsiClass());
        context.logError(new StringBuffer().append("DSI >").append(string).append("< is not ready for profil changes cause: ").append(this.cause).toString());
    }

    @Override
    public boolean isFinalState() {
        return true;
    }
}

