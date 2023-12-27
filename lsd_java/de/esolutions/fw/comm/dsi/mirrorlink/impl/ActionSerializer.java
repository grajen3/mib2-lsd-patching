/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mirrorlink.Action;

public class ActionSerializer {
    public static void putOptionalAction(ISerializer iSerializer, Action action) {
        boolean bl = action == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = action.getActionId();
            iSerializer.putInt32(n);
            String string = action.getActionName();
            iSerializer.putOptionalString(string);
            boolean bl2 = action.isLaunchApp();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalActionVarArray(ISerializer iSerializer, Action[] actionArray) {
        boolean bl = actionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(actionArray.length);
            for (int i2 = 0; i2 < actionArray.length; ++i2) {
                ActionSerializer.putOptionalAction(iSerializer, actionArray[i2]);
            }
        }
    }

    public static Action getOptionalAction(IDeserializer iDeserializer) {
        Action action = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            int n;
            action = new Action();
            action.actionId = n = iDeserializer.getInt32();
            action.actionName = string = iDeserializer.getOptionalString();
            action.launchApp = bl2 = iDeserializer.getBool();
        }
        return action;
    }

    public static Action[] getOptionalActionVarArray(IDeserializer iDeserializer) {
        Action[] actionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            actionArray = new Action[n];
            for (int i2 = 0; i2 < n; ++i2) {
                actionArray[i2] = ActionSerializer.getOptionalAction(iDeserializer);
            }
        }
        return actionArray;
    }
}

