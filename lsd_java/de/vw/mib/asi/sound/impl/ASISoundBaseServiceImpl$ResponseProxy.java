/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.vw.mib.asi.sound.ASISoundResponse;

class ASISoundBaseServiceImpl$ResponseProxy
implements ASISoundResponse {
    private final ASIHMISyncSoundReply delegate;

    static ASISoundBaseServiceImpl$ResponseProxy get(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        return new ASISoundBaseServiceImpl$ResponseProxy(aSIHMISyncSoundReply);
    }

    private ASISoundBaseServiceImpl$ResponseProxy(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.delegate = aSIHMISyncSoundReply;
    }
}

