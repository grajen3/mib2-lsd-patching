/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc.api.impl;

import de.vw.mib.asl.framework.api.lsc.ASLLscAPI;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;
import de.vw.mib.asl.framework.internal.lsc.PersistableLsc;
import de.vw.mib.genericevents.GenericEvents;

public class ASLLscAPIImpl
implements ASLLscAPI {
    private int defaultVoiceType = 0;

    public static void registerIds(GenericEvents genericEvents) {
    }

    @Override
    public void setVoice(int n) {
        PersistableLsc.getInstance().setVoice(n);
    }

    @Override
    public int getVoice() {
        return PersistableLsc.getInstance().getVoice();
    }

    @Override
    public int getDefaultVoice() {
        return this.defaultVoiceType;
    }

    public void setDefaultVoice(int n) {
        Preconditions.checkArgument(n == 0 || n == 1, new StringBuffer().append("Invalid voice type: ").append(n).append("! Expected VoiceTypes.FEMALE or VoiceTypes.MALE.").toString());
        this.defaultVoiceType = n;
    }

    @Override
    public String getPersistantLanguage() {
        return PersistableLsc.getInstance().getPersistantLanguage();
    }

    @Override
    public void setCodedCarBrand(int n) {
        AslTargetLscTNGBullhorn.codedCarBrand = n;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, 5150, 755703872);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5150, 755703872);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5150, 1443168320);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5290, 537600064);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5150, 6952960, false);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5150, 23730176, true);
    }
}

