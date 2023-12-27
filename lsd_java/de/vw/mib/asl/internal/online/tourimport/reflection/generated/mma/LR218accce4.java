/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.reflection.generated.mma;

import de.vw.mib.asl.internal.online.tourimport.states.TourImportTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR218accce4
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1702686102: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1583627656: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1300340030: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -652229751: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -648453066: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -122663274: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1688556790: {
                if (bl) {
                    if (n2 != 17) break;
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
            case 413977828: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TourImportTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((TourImportTarget)object).startTimer();
                return null;
            }
            case 2: {
                return ((TourImportTarget)object).getDSITourImport();
            }
            case 3: {
                return ((TourImportTarget)object).getNonActiveState();
            }
            case 4: {
                return ((TourImportTarget)object).getActiveIdleState();
            }
            case 5: {
                return ((TourImportTarget)object).getActiveState();
            }
            case 6: {
                return ((TourImportTarget)object).getDownloadActiveState();
            }
            case 7: {
                return ((TourImportTarget)object).getExportActiveState();
            }
            case 8: {
                ((TourImportTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
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

