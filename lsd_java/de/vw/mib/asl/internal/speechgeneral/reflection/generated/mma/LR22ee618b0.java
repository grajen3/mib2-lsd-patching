/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.reflection.generated.mma;

import de.vw.mib.asl.internal.speechgeneral.events.framework.EventHandler;
import de.vw.mib.asl.internal.speechgeneral.startup.SpeechGeneralStartTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR22ee618b0
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -61828532: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 546805148: {
                if (bl) {
                    if (n2 != -1379115468) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1469558727: {
                if (bl) {
                    if (n2 != 941556127) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    @Override
    public int getIndex(String string, String string2, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        int n4 = RuntimeUtil.buildKey(string2);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case 786831536: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((SpeechGeneralStartTarget)object).registerHandler((EventHandler)objectArray[0]);
                return null;
            }
            case 1: {
                return ((SpeechGeneralStartTarget)object).getHandleEvents();
            }
            case 2: {
                ((SpeechGeneralStartTarget)object).handleEvent((EventGeneric)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

