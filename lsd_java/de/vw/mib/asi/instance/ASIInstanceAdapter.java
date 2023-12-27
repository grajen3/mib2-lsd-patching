/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.instance;

import de.vw.mib.asi.instance.ASIInstance;
import de.vw.mib.asi.instance.ASIInstanceListener;
import de.vw.mib.asi.instance.ASIInstanceResponse;

public class ASIInstanceAdapter
implements ASIInstance {
    protected ASIInstanceListener listener;

    @Override
    public ASIInstanceListener getASIInstanceListener() {
        return this.listener;
    }

    @Override
    public void setASIInstanceListener(ASIInstanceListener aSIInstanceListener) {
        this.listener = aSIInstanceListener;
    }

    @Override
    public void requestInstanceId(String string, String string2, ASIInstanceResponse aSIInstanceResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

