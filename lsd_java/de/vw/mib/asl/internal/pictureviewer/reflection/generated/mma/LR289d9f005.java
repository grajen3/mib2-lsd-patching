/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer.reflection.generated.mma;

import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureSourceInfo;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR289d9f005
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1608730964: {
                if (bl) {
                    if (n2 != -171318398) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1546601420: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1251000665: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -795580436: {
                if (bl) {
                    if (n2 != 941556127) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -188473968: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 23200623: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1187801447: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1778864172: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -1982205947: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return ((HsmTargetPictureViewer)object).getPictureViewer();
            }
            case 1: {
                return ((HsmTargetPictureViewer)object).getBrowser();
            }
            case 2: {
                ((HsmTargetPictureViewer)object).transToIdle();
                return null;
            }
            case 3: {
                return RuntimeUtil.valueOf(((HsmTargetPictureViewer)object).isLastSource());
            }
            case 4: {
                ((HsmTargetPictureViewer)object).transToStateShowLastActivePicture((Boolean)objectArray[0], (PictureSourceInfo)objectArray[1]);
                return null;
            }
            case 5: {
                ((HsmTargetPictureViewer)object).resetRestorePicture();
                return null;
            }
            case 6: {
                ((HsmTargetPictureViewer)object).transToStateHMIBrowser();
                return null;
            }
            case 7: {
                ((HsmTargetPictureViewer)object).receiveEvent((EventGeneric)objectArray[0]);
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

