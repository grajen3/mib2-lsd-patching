/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.AudioRoute;

public interface DSIMediaRouter
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_STREAMINGSTATUS;
    public static final int ATTR_ACTIVEAUDIOROUTES;
    public static final int RT_REGISTERCLIENT;
    public static final int RT_UNREGISTERCLIENT;
    public static final int RT_REQUESTCONFIGURATION;
    public static final int RT_STARTSTREAMING;
    public static final int RT_STOPSTREAMING;
    public static final int RT_SETAUDIOROUTES;
    public static final int RP_RESPONSECONFIGURATION;
    public static final int RP_RESPONSECLIENTSTATUS;
    public static final int SINKFLAG_NONE;
    public static final int SINKFLAG_HEADUNIT;
    public static final int SINKFLAG_NETWORK;
    public static final int AUDIOSOURCE_NONE;
    public static final int AUDIOSOURCE_INTERNAL;
    public static final int AUDIOSOURCE_EXTERNAL;
    public static final int AUDIOSOURCE_NETWORK;
    public static final int VIDEOSOURCE_NONE;
    public static final int VIDEOSOURCE_INTERNAL;
    public static final int VIDEOSOURCE_EXTERNAL;
    public static final int CLIENTSTATUS_UNKNOWN;
    public static final int CLIENTSTATUS_REGISTRATION_SUCCESS;
    public static final int CLIENTSTATUS_REGISTRATION_FAILED;
    public static final int CLIENTSTATUS_DEREGISTRATION_SUCCSSS;
    public static final int CLIENTSTATUS_DEREGISTRATION_FAILED;
    public static final int STREAMINGSTATUS_UNKNOWN;
    public static final int STREAMINGSTATUS_STARTED;
    public static final int STREAMINGSTATUS_STOPPED;
    public static final int STREAMINGSTATUS_STOPPED_WITH_ERROR;
    public static final int STREAMINGSTATUS_STREAM_CHANGED;
    public static final int CONFIGURATIONRESULT_OK;
    public static final int CONFIGURATIONRESULT_NOK;
    public static final int VIRTUALCHANNEL_NONE;
    public static final int VIRTUALCHANNEL_ENT_INTMEDIA;
    public static final int VIRTUALCHANNEL_ENT_A2LS;
    public static final int VIRTUALCHANNEL_ENT_ML;
    public static final int VIRTUALCHANNEL_ENT_MIRRORLINK;
    public static final int VIRTUALCHANNEL_ENT_DIO;
    public static final int VIRTUALCHANNEL_ENT_GAL;
    public static final int VIRTUALCHANNEL_ENT_RSVD1;
    public static final int VIRTUALCHANNEL_ENT_RSVD2;
    public static final int VIRTUALCHANNEL_ENT_RSVD3;
    public static final int VIRTUALCHANNEL_ANN_INT_NAV;
    public static final int VIRTUALCHANNEL_ANN_INT_SPEECH;
    public static final int VIRTUALCHANNEL_ANN_DIO_ALT;
    public static final int VIRTUALCHANNEL_ANN_DIO_VOICE;
    public static final int VIRTUALCHANNEL_ANN_GAL_UI;
    public static final int VIRTUALCHANNEL_ANN_GAL_GUIDANCE;
    public static final int VIRTUALCHANNEL_ANN_GAL_VOICE;
    public static final int VIRTUALCHANNEL_ANN_ML_VOICE;
    public static final int VIRTUALCHANNEL_ANN_ML_GUIDANCE;
    public static final int VIRTUALCHANNEL_TEL_INT;
    public static final int VIRTUALCHANNEL_TEL_DIO;
    public static final int VIRTUALCHANNEL_TEL_GAL;
    public static final int VIRTUALCHANNEL_TEL_ML;
    public static final int VIRTUALCHANNEL_MIC;
    public static final int VIRTUALCHANNEL_MIC_DIO;
    public static final int VIRTUALCHANNEL_MIC_GAL;
    public static final int VIRTUALCHANNEL_MIC_ML;
    public static final int VIRTUALCHANNEL_SSE_INPUT;
    public static final int VIRTUALCHANNEL_INPUT_ENT1;
    public static final int VIRTUALCHANNEL_INPUT_ENT2;
    public static final int VIRTUALCHANNEL_INPUT_ENT3;
    public static final int VIRTUALCHANNEL_INPUT_ENT4;
    public static final int VIRTUALCHANNEL_ANN_BCL_ALT;
    public static final int VIRTUALCHANNEL_ANN_BCL_VOICE;
    public static final int VIRTUALCHANNEL_ENT_BCL;
    public static final int VIRTUALCHANNEL_MIC_BCL;
    public static final int VIRTUALCHANNEL_TEL_BCL;
    public static final int PHYSICALCHANNEL_NONE;
    public static final int PHYSICALCHANNEL_MPL1;
    public static final int PHYSICALCHANNEL_MPL2;
    public static final int PHYSICALCHANNEL_ANN1;
    public static final int PHYSICALCHANNEL_ANN2;
    public static final int PHYSICALCHANNEL_TEL;
    public static final int PHYSICALCHANNEL_INPUT_ENT1;
    public static final int PHYSICALCHANNEL_INPUT_ENT2;
    public static final int ROUTINGRESULT_OK;
    public static final int ROUTINGRESULT_NOK;
    public static final int ROUTINGRESULT_INVALID_SOURCE;
    public static final int ROUTINGRESULT_INVALID_SINK;

    default public void registerClient(int n, String string, String string2) {
    }

    default public void unregisterClient(int n) {
    }

    default public void startStreaming(int n) {
    }

    default public void stopStreaming(int n) {
    }

    default public void requestConfiguration(int n, int n2, int n3, int n4) {
    }

    default public void setAudioRoutes(AudioRoute[] audioRouteArray) {
    }
}

