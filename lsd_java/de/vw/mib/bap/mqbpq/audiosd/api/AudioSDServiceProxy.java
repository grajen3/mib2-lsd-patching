/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api;

import de.vw.mib.bap.mqbpq.audiosd.api.AudioSDServices;
import de.vw.mib.bap.mqbpq.common.api.FSGServiceProxy;
import de.vw.mib.genericevents.EventGeneric;

public interface AudioSDServiceProxy
extends FSGServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, AudioSDServices audioSDServices) {
    }
}

