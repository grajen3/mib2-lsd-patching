/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.generic;

import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.generic.ASIGenericListener;
import de.vw.mib.asi.generic.ASIGenericResponse;

public interface ASIGeneric
extends ASIService {
    default public ASIGenericListener getASIGenericListener() {
    }

    default public void setASIGenericListener(ASIGenericListener aSIGenericListener) {
    }

    default public void sendDataToUnit(GenericPacket genericPacket, ASIGenericResponse aSIGenericResponse) {
    }
}

