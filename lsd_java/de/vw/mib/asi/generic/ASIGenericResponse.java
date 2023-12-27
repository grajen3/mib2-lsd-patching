/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.generic;

import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.vw.mib.asi.ASIResponse;

public interface ASIGenericResponse
extends ASIResponse {
    default public void sendDataFromUnit(GenericPacket genericPacket) {
    }
}

