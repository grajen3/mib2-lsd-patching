/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.picturestore.reflection.generated.mma;

import de.vw.mib.asl.internal.picturestore.TargetPictureStore;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;

public final class LR27be30d7f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -932243735: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -903659569: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 175060422: {
                if (bl) {
                    if (n2 != -591118422) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 627101265: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 925747438: {
                if (bl) {
                    if (n2 != 1025655565) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
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
            case 2078477695: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TargetPictureStore)object).dsiPictureStoreImportPictureResult(((Number)objectArray[0]).intValue(), (ResourceLocator)objectArray[1], (ResourceLocator)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 1: {
                ((TargetPictureStore)object).dsiPictureStoreDeletedPictures((ResourceLocator[])objectArray[0]);
                return null;
            }
            case 2: {
                ((TargetPictureStore)object).copyProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((TargetPictureStore)object).resetProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((TargetPictureStore)object).resetAllProfiles();
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

