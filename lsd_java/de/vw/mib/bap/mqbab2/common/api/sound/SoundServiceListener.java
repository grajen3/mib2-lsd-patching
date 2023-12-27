/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.sound;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;

public interface SoundServiceListener
extends HMIEventListener {
    public static final int SOUND_SERVICE__VOLUME_NAVI;
    public static final int SOUND_SERVICE__CURRENT_DDS_VOLUME_FOCUS;
    public static final int SOUND_SERVICE__CURRENT_AMPLIFIER_STATE;
    public static final int SOUND_SERVICE__VOLUME_ENTERTAINMENT;
    public static final int SOUND_SERVICE__VOLUME_TRAFFIC_ANNOUNCEMENT;
    public static final int SOUND_SERVICE__VOLUME_PHONE;
    public static final int SOUND_SERVICE__VOLUMNE_SPEECH;
    public static final int SOUND_SERVICE__CURRENT_AUDIO_COMPONENT;
    public static final int SOUND_SERVICE__MUTE_STATE;
    public static final int SOUND_SERVICE__VOLUME_LIMITS_NAVI;
    public static final int SOUND_SERVICE__VOLUME_LIMITS_ENTERTAINMENT;
    public static final int SOUND_SERVICE__VOLUME_LIMITS_TRAFFIC_ANNOUNCEMENT;
    public static final int SOUND_SERVICE__VOLUME_LIMITS_PHONE;
    public static final int SOUND_SERVICE__VOLUME_LIMITS_SPEECH;
    public static final int SOUND_SERVICE__HMI_EVENT__VOLUME_CHANGE_THROUGH_MFL;

    default public void updateSoundData(SoundService soundService, int n) {
    }
}

