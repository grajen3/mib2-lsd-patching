/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIRadioTagging;
import org.dsi.ifc.media.TagInformation;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessaging;
import org.dsi.ifc.messaging.RecipientList;

public final class LR2516e6557
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2084933286: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1470259079: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1260016649: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 16;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 17;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 18;
                    break;
                }
                n3 = 16;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 19;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 20;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 21;
                    break;
                }
                n3 = 19;
                break;
            }
            case -848740845: {
                if (bl) {
                    if (n2 != -1375448439) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -746556172: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -549492225: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -452149376: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -19738879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 194845043: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 305126940: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 754583705: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 912447122: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1112887688: {
                if (bl) {
                    if (n2 != -160227418) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1439552230: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1604031653: {
                if (bl) {
                    if (n2 != 1652632588) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 2072936530: {
                if (bl) {
                    if (n2 != -1475107342) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1549021628: {
                if (bl) {
                    if (n2 != -1746074298) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1482995283: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 25;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 26;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 27;
                    break;
                }
                n3 = 25;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 28;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 29;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 30;
                    break;
                }
                n3 = 28;
                break;
            }
            case 158639676: {
                if (bl) {
                    if (n2 != -180231836) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
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
            case -2145268327: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -863260497: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMessaging)object).changeFolderRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 1: {
                ((DSIMessaging)object).listEntriesRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIMessaging)object).getPositionOfMessageRequest((String)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIMessaging)object).getPositionOfFolderRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIMessaging)object).deleteMessageRequest((String[])objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIMessaging)object).sendMessageRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RecipientList)objectArray[2], (String)objectArray[3], (String)objectArray[4], (AttachmentInformation[])objectArray[5], ((Number)objectArray[6]).intValue());
                return null;
            }
            case 6: {
                ((DSIMessaging)object).getMessageContentsRequest(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIMessaging)object).setMessageReadStatusRequest((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIMessaging)object).saveAsDraftRequest((String)objectArray[0], ((Number)objectArray[1]).intValue(), (RecipientList)objectArray[2], (String)objectArray[3], (String)objectArray[4], ((Number)objectArray[5]).intValue(), (AttachmentInformation[])objectArray[6]);
                return null;
            }
            case 9: {
                ((DSIMessaging)object).extractInformationRequest((String)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIMessaging)object).changeTemplateRequest(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIMessaging)object).getTemplateRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIMessaging)object).getTemplatesRequest();
                return null;
            }
            case 13: {
                ((DSIMessaging)object).deleteTemplateRequest((int[])objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIMessaging)object).deleteSimCardMessagesRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIMessaging)object).decodeAttachmentRequest((AttachmentInformation)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIMessaging)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIMessaging)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIMessaging)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSIMessaging)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIMessaging)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIMessaging)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIRadioTagging)object).tagSong((TagInformation)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSIRadioTagging)object).tagAmbiguousSong((TagInformation)objectArray[0], (TagInformation)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIRadioTagging)object).groupTags(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSIRadioTagging)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIRadioTagging)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIRadioTagging)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIRadioTagging)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIRadioTagging)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIRadioTagging)object).clearNotification((DSIListener)objectArray[0]);
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

