/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.TSDSystemMessages;

public class TSDSystemMessagesSerializer {
    public static void putOptionalTSDSystemMessages(ISerializer iSerializer, TSDSystemMessages tSDSystemMessages) {
        boolean bl = tSDSystemMessages == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = tSDSystemMessages.isDisclaimer();
            iSerializer.putBool(bl2);
            boolean bl3 = tSDSystemMessages.isRoadSignRecognition();
            iSerializer.putBool(bl3);
            boolean bl4 = tSDSystemMessages.isCameraBlind();
            iSerializer.putBool(bl4);
            boolean bl5 = tSDSystemMessages.isNavigationData();
            iSerializer.putBool(bl5);
            boolean bl6 = tSDSystemMessages.isSystem();
            iSerializer.putBool(bl6);
            boolean bl7 = tSDSystemMessages.isOperationArea();
            iSerializer.putBool(bl7);
            boolean bl8 = tSDSystemMessages.isRoadSignRecognitionInit();
            iSerializer.putBool(bl8);
            boolean bl9 = tSDSystemMessages.isSpeedWarning();
            iSerializer.putBool(bl9);
            boolean bl10 = tSDSystemMessages.isWrongWayWarningLevel1();
            iSerializer.putBool(bl10);
            boolean bl11 = tSDSystemMessages.isWrongWayWarningLevel2();
            iSerializer.putBool(bl11);
            boolean bl12 = tSDSystemMessages.isWrongWayWarningOperationArea();
            iSerializer.putBool(bl12);
            boolean bl13 = tSDSystemMessages.isWrongWayWarning();
            iSerializer.putBool(bl13);
        }
    }

    public static void putOptionalTSDSystemMessagesVarArray(ISerializer iSerializer, TSDSystemMessages[] tSDSystemMessagesArray) {
        boolean bl = tSDSystemMessagesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tSDSystemMessagesArray.length);
            for (int i2 = 0; i2 < tSDSystemMessagesArray.length; ++i2) {
                TSDSystemMessagesSerializer.putOptionalTSDSystemMessages(iSerializer, tSDSystemMessagesArray[i2]);
            }
        }
    }

    public static TSDSystemMessages getOptionalTSDSystemMessages(IDeserializer iDeserializer) {
        TSDSystemMessages tSDSystemMessages = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            tSDSystemMessages = new TSDSystemMessages();
            tSDSystemMessages.disclaimer = bl13 = iDeserializer.getBool();
            tSDSystemMessages.roadSignRecognition = bl12 = iDeserializer.getBool();
            tSDSystemMessages.cameraBlind = bl11 = iDeserializer.getBool();
            tSDSystemMessages.navigationData = bl10 = iDeserializer.getBool();
            tSDSystemMessages.system = bl9 = iDeserializer.getBool();
            tSDSystemMessages.operationArea = bl8 = iDeserializer.getBool();
            tSDSystemMessages.roadSignRecognitionInit = bl7 = iDeserializer.getBool();
            tSDSystemMessages.speedWarning = bl6 = iDeserializer.getBool();
            tSDSystemMessages.wrongWayWarningLevel1 = bl5 = iDeserializer.getBool();
            tSDSystemMessages.wrongWayWarningLevel2 = bl4 = iDeserializer.getBool();
            tSDSystemMessages.wrongWayWarningOperationArea = bl3 = iDeserializer.getBool();
            tSDSystemMessages.wrongWayWarning = bl2 = iDeserializer.getBool();
        }
        return tSDSystemMessages;
    }

    public static TSDSystemMessages[] getOptionalTSDSystemMessagesVarArray(IDeserializer iDeserializer) {
        TSDSystemMessages[] tSDSystemMessagesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tSDSystemMessagesArray = new TSDSystemMessages[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tSDSystemMessagesArray[i2] = TSDSystemMessagesSerializer.getOptionalTSDSystemMessages(iDeserializer);
            }
        }
        return tSDSystemMessagesArray;
    }
}

