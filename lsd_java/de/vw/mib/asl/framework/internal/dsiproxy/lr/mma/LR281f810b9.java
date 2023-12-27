/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.phonetic.DSIPhoneticConverter;
import org.dsi.ifc.picturehandling.DSIPictureHandling;

public final class LR281f810b9
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1726633219: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1441056693: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 2;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 3;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 4;
                    break;
                }
                n3 = 2;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 5;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 6;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 7;
                    break;
                }
                n3 = 5;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 12;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 13;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 14;
                    break;
                }
                n3 = 12;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 15;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 16;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 17;
                    break;
                }
                n3 = 15;
                break;
            }
            case -680325273: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 745434009: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1858903385: {
                if (bl) {
                    if (n2 != -1773024349) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1948564243: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
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
            case -2052785629: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -233826961: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIPhoneticConverter)object).hanziToPinYin((String)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIPhoneticConverter)object).hanziToZhuYin((String)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIPhoneticConverter)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIPhoneticConverter)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIPhoneticConverter)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIPhoneticConverter)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIPhoneticConverter)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIPhoneticConverter)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIPictureHandling)object).setPictureConfig(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIPictureHandling)object).requestPictures(((Number)objectArray[0]).intValue(), (ResourceLocator[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIPictureHandling)object).cancelPicture(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIPictureHandling)object).freePicture((ResourceLocator)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIPictureHandling)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIPictureHandling)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIPictureHandling)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIPictureHandling)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIPictureHandling)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIPictureHandling)object).clearNotification((DSIListener)objectArray[0]);
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

