/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mca;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.carcomfort.DSICarComfortComplexAnalyzer;
import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation.DSINavigationComplexAnalyzer;
import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.online.DSIPoiOnlineSearchComplexAnalyzer;
import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.picturehandling.DSIPictureHandlingComplexAnalyzer;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR465ea1ef3
extends MultipleConstructorAccessibleObject {
    private int a0(int n) {
        switch (n) {
            case 17: {
                return 0;
            }
        }
        return -1;
    }

    private int a1(int n) {
        switch (n) {
            case 17: {
                return 1;
            }
        }
        return -1;
    }

    private int a2(int n) {
        switch (n) {
            case 17: {
                return 2;
            }
        }
        return -1;
    }

    private int a3(int n) {
        switch (n) {
            case 17: {
                return 3;
            }
        }
        return -1;
    }

    @Override
    public int getIndex(String string, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case -97544817: {
                if (bl) {
                    n2 = this.a3(n);
                    break;
                }
                n2 = 3;
                break;
            }
            case 158522573: {
                if (bl) {
                    n2 = this.a1(n);
                    break;
                }
                n2 = 1;
                break;
            }
            case 232354853: {
                if (bl) {
                    n2 = this.a0(n);
                    break;
                }
                n2 = 0;
                break;
            }
            case 431003469: {
                if (bl) {
                    n2 = this.a2(n);
                    break;
                }
                n2 = 2;
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object[] objectArray) {
        switch (n) {
            case 0: {
                return new DSICarComfortComplexAnalyzer();
            }
            case 1: {
                return new DSINavigationComplexAnalyzer();
            }
            case 2: {
                return new DSIPictureHandlingComplexAnalyzer();
            }
            case 3: {
                return new DSIPoiOnlineSearchComplexAnalyzer();
            }
        }
        return null;
    }

    @Override
    public Object newInstance(int n, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

