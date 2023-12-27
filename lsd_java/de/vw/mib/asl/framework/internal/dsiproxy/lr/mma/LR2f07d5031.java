/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.phonetic.DSIPhoneticConverterListener;
import org.dsi.ifc.picturehandling.DSIPictureHandlingListener;

public final class LR2f07d5031
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -565726200: {
                if (bl) {
                    if (n2 != 1305175025) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2017057082: {
                if (bl) {
                    if (n2 != 1305175025) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -885159302: {
                if (bl) {
                    if (n2 != -1644528364) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 774607257: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
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
            case -1017604873: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -792091581: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIPhoneticConverterListener)object).hanziToPinYinResult((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 1: {
                ((DSIPhoneticConverterListener)object).hanziToZhuYinResult((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 2: {
                ((DSIPhoneticConverterListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIPictureHandlingListener)object).indicatePicture(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResourceLocator)objectArray[2], (ResourceLocator)objectArray[3]);
                return null;
            }
            case 4: {
                ((DSIPictureHandlingListener)object).finishPictureRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIPictureHandlingListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

