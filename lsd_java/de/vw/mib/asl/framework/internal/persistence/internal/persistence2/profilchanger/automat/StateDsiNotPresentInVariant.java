/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;

public class StateDsiNotPresentInVariant
extends State {
    @Override
    public void onEnter(Context context) {
        Class clazz = context.getDsiAdapter().getDsiClass();
        String string = DsiUtil.getSimpleClassName(clazz);
        context.logTrace(new StringBuffer().append("DSI >").append(string).append("< is not present in this variant.").toString());
    }

    @Override
    public boolean isFinalState() {
        return true;
    }
}

