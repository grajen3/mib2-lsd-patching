/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.AudioRoute;

public class AudioRouteSerializer {
    public static void putOptionalAudioRoute(ISerializer iSerializer, AudioRoute audioRoute) {
        boolean bl = audioRoute == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = audioRoute.getRoutingInput();
            iSerializer.putInt32(n);
            int n2 = audioRoute.getRoutingOutput();
            iSerializer.putInt32(n2);
            int n3 = audioRoute.getRouteStatus();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalAudioRouteVarArray(ISerializer iSerializer, AudioRoute[] audioRouteArray) {
        boolean bl = audioRouteArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(audioRouteArray.length);
            for (int i2 = 0; i2 < audioRouteArray.length; ++i2) {
                AudioRouteSerializer.putOptionalAudioRoute(iSerializer, audioRouteArray[i2]);
            }
        }
    }

    public static AudioRoute getOptionalAudioRoute(IDeserializer iDeserializer) {
        AudioRoute audioRoute = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            audioRoute = new AudioRoute();
            audioRoute.routingInput = n3 = iDeserializer.getInt32();
            audioRoute.routingOutput = n2 = iDeserializer.getInt32();
            audioRoute.routeStatus = n = iDeserializer.getInt32();
        }
        return audioRoute;
    }

    public static AudioRoute[] getOptionalAudioRouteVarArray(IDeserializer iDeserializer) {
        AudioRoute[] audioRouteArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            audioRouteArray = new AudioRoute[n];
            for (int i2 = 0; i2 < n; ++i2) {
                audioRouteArray[i2] = AudioRouteSerializer.getOptionalAudioRoute(iDeserializer);
            }
        }
        return audioRouteArray;
    }
}

