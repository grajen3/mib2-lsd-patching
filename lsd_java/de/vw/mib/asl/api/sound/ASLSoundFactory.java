/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.sound;

import de.vw.mib.asl.api.sound.ASLSoundAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLSoundFactory
extends ASLFactoryBase {
    private static ASLSoundAPI soundApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$sound$ASLSoundAPI;

    public static ASLSoundAPI getSoundApi() {
        if (soundApiInstance == null) {
            soundApiInstance = (ASLSoundAPI)ASLSoundFactory.createServiceInstance(class$de$vw$mib$asl$api$sound$ASLSoundAPI == null ? (class$de$vw$mib$asl$api$sound$ASLSoundAPI = ASLSoundFactory.class$("de.vw.mib.asl.api.sound.ASLSoundAPI")) : class$de$vw$mib$asl$api$sound$ASLSoundAPI, "de.vw.mib.asl.internal.sound.api.impl.ASLSoundAPIImpl");
        }
        return soundApiInstance;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

