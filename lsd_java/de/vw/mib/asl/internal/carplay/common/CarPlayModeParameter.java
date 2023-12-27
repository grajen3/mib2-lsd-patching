/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.Resource;

public class CarPlayModeParameter {
    static Resource resource_main_screen_device = new Resource(2, 2);
    static Resource resource_main_screen_hmi = new Resource(2, 1);
    static Resource resource_main_screen_undefined = new Resource(2, 0);
    static Resource resource_main_audio_device = new Resource(1, 2);
    static Resource resource_main_audio_hmi = new Resource(1, 1);
    static Resource resource_main_audio_undefined = new Resource(1, 0);
    static AppState appstate_default = new AppState(0, 0, 0);
    static AppState appstate_phonecall_device = new AppState(1, 2, 0);
    static AppState appstate_phonecall_hmi = new AppState(1, 1, 0);
    static AppState appstate_phonecall_unknown = new AppState(1, 0, 0);
    static AppState appstate_nav_device = new AppState(2, 2, 0);
    static AppState appstate_nav_hmi = new AppState(2, 1, 0);
    static AppState appstate_nav_unknown = new AppState(2, 0, 0);
    static AppState appstate_speech_devide_speak = new AppState(3, 2, 2);
    static AppState appstate_speech_devide_recognizing = new AppState(3, 2, 3);
    static AppState appstate_speech_hmi = new AppState(3, 1, 2);
    static AppState appstate_speech_unknown = new AppState(3, 0, 0);
    static AppState appstate_media_device = new AppState(4, 2, 0);
    static AppState appstate_media_hmi = new AppState(4, 1, 0);
    static AppState appstate_media_unknown = new AppState(4, 0, 0);
}

