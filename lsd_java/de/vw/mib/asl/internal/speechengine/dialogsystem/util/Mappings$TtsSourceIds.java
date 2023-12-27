/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.util;

public class Mappings$TtsSourceIds {
    public static final short DSI_TTS_SOURCE_ID_UNDEF;
    public static final short DSI_TTS_SOURCE_ID_SDS;
    public static final short DSI_TTS_SOURCE_ID_SMS;
    public static final short DSI_TTS_SOURCE_ID_TMC_USER;
    public static final short DSI_TTS_SOURCE_ID_NAV_MENU;
    public static final short DSI_TTS_SOURCE_ID_TMC_SYSTEM;
    public static final short DSI_TTS_SOURCE_ID_SDS_MENU;
    public static final short DSI_TTS_SOURCE_ID_NAV;

    public static short getSourceIdByInstanceId(int n) {
        short s = -1;
        switch (n) {
            case 0: {
                s = 1;
                break;
            }
            case 1: {
                s = -1;
                break;
            }
            default: {
                s = 1;
            }
        }
        return s;
    }
}

