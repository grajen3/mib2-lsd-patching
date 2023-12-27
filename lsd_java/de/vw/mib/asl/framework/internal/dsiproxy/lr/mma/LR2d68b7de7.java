/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.DSIRadioTaggingListener;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.messaging.Template;

public final class LR2d68b7de7
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1171895274: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1705564876: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1991358444: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1761711307: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1725995288: {
                if (bl) {
                    if (n2 != 674953789) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1615489850: {
                if (bl) {
                    if (n2 != -1976980843) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1369339511: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1078813766: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -692514469: {
                if (bl) {
                    if (n2 != 2025746114) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -558990247: {
                if (bl) {
                    if (n2 != -1730033871) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -488247417: {
                if (bl) {
                    if (n2 != -2018418629) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -352895453: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -332968398: {
                if (bl) {
                    if (n2 != 1535763889) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -179066954: {
                if (bl) {
                    if (n2 != 84514416) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -155507424: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -111810795: {
                if (bl) {
                    if (n2 != 2132702180) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -110562008: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 119537749: {
                if (bl) {
                    if (n2 != 738365589) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 192694962: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 198525211: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 854313702: {
                if (bl) {
                    if (n2 != -1008715669) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 921915550: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1719523809: {
                if (bl) {
                    if (n2 != 1877749075) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1729361172: {
                if (bl) {
                    if (n2 != 1210030801) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1784864922: {
                if (bl) {
                    if (n2 != 1238458065) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1798144039: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1937257963: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1970173377: {
                if (bl) {
                    if (n2 != -979540257) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
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
            case -2137653373: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1088262765: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIRadioTaggingListener)object).tagResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIRadioTaggingListener)object).updateCompatibleDevAvail(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIRadioTaggingListener)object).groupTagsResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIRadioTaggingListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIMessagingListener)object).indicateMessageStatus((StatusInformation)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIMessagingListener)object).indicateFolderInformation((FolderEntry)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIMessagingListener)object).indicateListChanged((ListChangedInformation)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIMessagingListener)object).updateSynchInProgress((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMessagingListener)object).updateMessagingAccounts((MessagingAccount[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIMessagingListener)object).indicateNewMessage((Boolean)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 10: {
                ((DSIMessagingListener)object).listEntriesResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ListEntry[])objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 11: {
                ((DSIMessagingListener)object).getPositionOfMessageResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIMessagingListener)object).getPositionOfFolderResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIMessagingListener)object).changeFolderResponse((FolderEntry)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIMessagingListener)object).deleteMessageResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIMessagingListener)object).sendMessageResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIMessagingListener)object).getMessageContentsResponse(((Number)objectArray[0]).intValue(), (MessageDetails)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIMessagingListener)object).setMessageReadStatusResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIMessagingListener)object).parseVCardResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIMessagingListener)object).saveAsDraftResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIMessagingListener)object).extractInformationResponse(((Number)objectArray[0]).intValue(), (ExtractedItem[])objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIMessagingListener)object).changeTemplateResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIMessagingListener)object).getTemplateResponse(((Number)objectArray[0]).intValue(), (Template)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIMessagingListener)object).getTemplatesResponse(((Number)objectArray[0]).intValue(), (Template[])objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIMessagingListener)object).deleteTemplateResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSIMessagingListener)object).indicatePushMessageFailed(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 26: {
                ((DSIMessagingListener)object).indicateSendMessage((int[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (RecipientList)objectArray[3], (String)objectArray[4], (String)objectArray[5], (AttachmentInformation[])objectArray[6], ((Number)objectArray[7]).intValue());
                return null;
            }
            case 27: {
                ((DSIMessagingListener)object).deleteSimCardMessagesResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIMessagingListener)object).decodeAttachmentResponse(((Number)objectArray[0]).intValue(), (ResourceLocator)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIMessagingListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

