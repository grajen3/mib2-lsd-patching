/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.homescreen.reflection.generated.mma;

import de.vw.mib.asl.internal.homescreen.HomeScreenStartupTarget;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenMainTarget;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenSpaceGesturesTarget;
import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionServiceImpl;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR2ef52d502
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
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
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 598678267: {
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

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1385013952: {
                if (bl) {
                    if (n2 != 1918723414) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1395473561: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
            case -1725444479: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case -170590455: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 174710406: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 1111387092: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 1341549194: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return ((HomeScreenStartupTarget)object).getLogger();
            }
            case 1: {
                return ((HomeScreenInfoTarget)object).getLogger();
            }
            case 2: {
                return ((HomeScreenMainTarget)object).getLogger();
            }
            case 3: {
                return ((HomeScreenSpaceGesturesTarget)object).getLogger();
            }
            case 4: {
                ((TileSelectionServiceImpl)object).activateTileSelection((Tile)objectArray[0]);
                return null;
            }
            case 5: {
                ((TileSelectionServiceImpl)object).cancelTileSelection();
                return null;
            }
            case 6: {
                return ((TileSelectionServiceImpl)object).getLogger();
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

