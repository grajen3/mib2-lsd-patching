/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;

public class StateDsiReadyForProfileChanges
extends State {
    @Override
    public void onEnter(Context context) {
        String string = DsiUtil.getSimpleClassName(context.getDsiAdapter().getDsiClass());
        context.logTrace(new StringBuffer().append("DSI >").append(string).append("< is ready for profile changes.").toString());
    }

    @Override
    public boolean isFinalState() {
        return true;
    }
}

