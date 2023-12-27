/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.reflection.generated.mma;

import de.vw.mib.asl.api.messages.services.detail.MessageKey;
import de.vw.mib.asl.api.messages.services.detail.MessageResponse;
import de.vw.mib.asl.api.messages.services.status.MessagesUpdates;
import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling;
import de.vw.mib.asl.internal.messages.TargetASLMessagesService;
import de.vw.mib.asl.internal.messages.contacts.HsmMessagingContactsSearchHandling;
import de.vw.mib.asl.internal.messages.contacts.TargetASLMessagingContactsHandling;
import de.vw.mib.asl.internal.messages.setup.TargetASLPhoneMessagesSetup;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.speller.filter.SpellerFilterListener;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;

public final class LR274ae3826
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1764366308: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -806392590: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -743845075: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -195873946: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -901220115: {
                if (bl) {
                    if (n2 == 1983973400) {
                        n3 = 10;
                        break;
                    }
                    if (n2 != 1295662696) break;
                    n3 = 11;
                    break;
                }
                n3 = 10;
                break;
            }
            case -690212584: {
                if (bl) {
                    if (n2 != -1241595760) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -34465077: {
                if (bl) {
                    if (n2 != 2132702180) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 555452395: {
                if (bl) {
                    if (n2 != 1877749075) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 574916800: {
                if (bl) {
                    if (n2 != -1241595760) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 583329970: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 649235113: {
                if (bl) {
                    if (n2 != -1835876800) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 836015793: {
                if (bl) {
                    if (n2 != -1241595760) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1240029279: {
                if (bl) {
                    if (n2 != 738365589) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1491961336: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1953285029: {
                if (bl) {
                    if (n2 == 1909456715) {
                        n3 = 8;
                        break;
                    }
                    if (n2 != -324729100) break;
                    n3 = 9;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1960939949: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 2006647084: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1522761516: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -123530467: {
                if (bl) {
                    if (n2 != -1588844962) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 805854839: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1080060518: {
                if (bl) {
                    if (n2 != 815571355) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 392034375: {
                if (bl) {
                    if (n2 != 1420063289) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 889816265: {
                if (bl) {
                    if (n2 != -550871682) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1561474208: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1287516057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -775299336: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 527823443: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1075409404: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1488272994: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
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
            case -1937518726: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -955406555: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 607635106: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 977109142: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 1504845603: {
                n2 = this.a4(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((HsmPhoneSMSHandling)object).importContactResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((HsmPhoneSMSHandling)object).updateContactCapacity(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((HsmPhoneSMSHandling)object).updateGuidanceActive((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((HsmPhoneSMSHandling)object).updateServiceAvailable((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((TargetASLMessagesService)object).register((MessagesUpdates)objectArray[0]);
                return null;
            }
            case 5: {
                ((TargetASLMessagesService)object).unregister((MessagesUpdates)objectArray[0]);
                return null;
            }
            case 6: {
                return ((TargetASLMessagesService)object).registerWithHistory((MessagesUpdates)objectArray[0]);
            }
            case 7: {
                return ((TargetASLMessagesService)object).getMessageHistory();
            }
            case 8: {
                ((TargetASLMessagesService)object).markMessageRead(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 9: {
                ((TargetASLMessagesService)object).markMessageRead((MessageKey)objectArray[0]);
                return null;
            }
            case 10: {
                ((TargetASLMessagesService)object).requestMessage(((Number)objectArray[0]).intValue(), (String)objectArray[1], (MessageResponse)objectArray[2]);
                return null;
            }
            case 11: {
                ((TargetASLMessagesService)object).requestMessage((MessageKey)objectArray[0], (MessageResponse)objectArray[1]);
                return null;
            }
            case 12: {
                ((TargetASLMessagesService)object).dsiMessagingSetMessageReadStatusResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((TargetASLMessagesService)object).dsiMessagingIndicateMessageStatus((StatusInformation)objectArray[0]);
                return null;
            }
            case 14: {
                ((TargetASLMessagesService)object).dsiAdbVCardExchangeParseVCardResult(((Number)objectArray[0]).intValue(), (AdbEntry[])objectArray[1]);
                return null;
            }
            case 15: {
                ((TargetASLMessagesService)object).dsiAdbVCardExchangeAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((TargetASLMessagesService)object).dsiMessagingIndicateNewMessage((Boolean)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 17: {
                ((TargetASLMessagesService)object).dsiMessagingGetMessageContentsResponse(((Number)objectArray[0]).intValue(), (MessageDetails)objectArray[1]);
                return null;
            }
            case 18: {
                ((TargetASLMessagesService)object).dsiMessagingAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((HsmMessagingContactsSearchHandling)object).filterCharacters((String[])objectArray[0]);
                return null;
            }
            case 20: {
                ((HsmMessagingContactsSearchHandling)object).initFilter((SpellerFilterListener)objectArray[0]);
                return null;
            }
            case 21: {
                ((HsmMessagingContactsSearchHandling)object).releaseFilter();
                return null;
            }
            case 22: {
                ((TargetASLMessagingContactsHandling)object).dsiAdbListGetViewWindowResult(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((TargetASLMessagingContactsHandling)object).dsiAdbListGetSpellerViewWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 24: {
                ((TargetASLMessagingContactsHandling)object).dsiAdbListUpdateViewSize((AdbViewSize)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((TargetASLMessagingContactsHandling)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((TargetASLPhoneMessagesSetup)object).dsiMessagingServiceConfigurationUpdateStoreSmsOnSent((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((TargetASLPhoneMessagesSetup)object).dsiMessagingServiceConfigurationUpdateShortMessageValidityPeriod(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((TargetASLPhoneMessagesSetup)object).dsiMessagingServiceConfigurationUpdateSMSCNumber((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((TargetASLPhoneMessagesSetup)object).dsiMessagingServiceConfigurationUpdateSmsDeliveryReport((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((TargetASLPhoneMessagesSetup)object).dsiMessagingServiceConfigurationRestoreFactorySettingsResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((TargetASLPhoneMessagesSetup)object).dsiMessagingServiceConfigurationAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

