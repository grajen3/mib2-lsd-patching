/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.generic;

import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.vw.mib.asi.generic.ASIGeneric;
import de.vw.mib.asi.generic.ASIGenericListener;
import de.vw.mib.asi.generic.ASIGenericResponse;

public class ASIGenericAdapter
implements ASIGeneric {
    protected ASIGenericListener listener;

    @Override
    public ASIGenericListener getASIGenericListener() {
        return this.listener;
    }

    @Override
    public void setASIGenericListener(ASIGenericListener aSIGenericListener) {
        this.listener = aSIGenericListener;
    }

    @Override
    public void sendDataToUnit(GenericPacket genericPacket, ASIGenericResponse aSIGenericResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

