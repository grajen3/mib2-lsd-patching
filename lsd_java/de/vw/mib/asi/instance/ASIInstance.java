/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.instance;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.instance.ASIInstanceListener;
import de.vw.mib.asi.instance.ASIInstanceResponse;

public interface ASIInstance
extends ASIService {
    default public ASIInstanceListener getASIInstanceListener() {
    }

    default public void setASIInstanceListener(ASIInstanceListener aSIInstanceListener) {
    }

    default public void requestInstanceId(String string, String string2, ASIInstanceResponse aSIInstanceResponse) {
    }
}

