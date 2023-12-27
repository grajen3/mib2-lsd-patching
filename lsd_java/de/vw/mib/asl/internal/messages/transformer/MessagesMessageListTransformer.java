/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.transformer;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.messages.MessageListItem;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.messages.transformer.AbstractMessagesMessageListTransformer;
import java.util.GregorianCalendar;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.global.ResourceLocator;

public class MessagesMessageListTransformer
extends AbstractMessagesMessageListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl;
        MessageListItem messageListItem = (MessageListItem)object;
        if (messageListItem.listEntry.getType() == 2) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(messageListItem.listEntry.getMessageListEntry().getDateTime());
            switch (n) {
                case 12: {
                    bl = true;
                    break;
                }
                case 13: {
                    bl = messageListItem.listEntry.getMessageListEntry().getMessageStatus() == 8;
                    break;
                }
                case 14: {
                    bl = messageListItem.listEntry.getMessageListEntry().getDateTime() != 0L && messageListItem.listEntry.getMessageListEntry().getDateTime() != -1L;
                    break;
                }
                case 15: {
                    bl = messageListItem.listEntry.getMessageListEntry().getMessageStatus() == 1;
                    break;
                }
                case 16: {
                    ClockDate clockDate = ASLSystemFactory.getSystemApi().getCurrentDate();
                    byte by = clockDate.getDay();
                    byte by2 = clockDate.getMonth();
                    short s = clockDate.getYear();
                    bl = by == gregorianCalendar.get(5) && by2 == gregorianCalendar.get(2) + 1 && s == gregorianCalendar.get(1);
                    break;
                }
                case 18: {
                    bl = messageListItem.listEntry.getMessageListEntry().getMessageStatus() == 5;
                    break;
                }
                case 17: {
                    bl = messageListItem.listEntry.getMessageListEntry().getMessageStatus() == 4;
                    break;
                }
                case 19: {
                    bl = this.messageReadable(messageListItem);
                    break;
                }
                case 22: {
                    bl = this.messageReadable(messageListItem) && !messageListItem.listEntry.getMessageListEntry().getSubject().startsWith("BEGIN:VCAR");
                    break;
                }
                case 23: {
                    bl = messageListItem.listEntry.getMessageListEntry().getSubject().startsWith("BEGIN:VCAR");
                    break;
                }
                case 21: {
                    bl = messageListItem.listEntry.getMessageListEntry().getRecipients().length > 1;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
                }
            }
        } else {
            switch (n) {
                case 12: {
                    bl = false;
                    break;
                }
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 21: 
                case 22: 
                case 23: {
                    bl = false;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
                }
            }
        }
        return bl;
    }

    private boolean messageReadable(MessageListItem messageListItem) {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(83) ? messageListItem.listEntry.getMessageListEntry().getType() != 4 : messageListItem.listEntry.getMessageListEntry().getType() == 1;
    }

    @Override
    public int getInt(int n, Object object) {
        int n2;
        MessageListItem messageListItem = (MessageListItem)object;
        if (messageListItem.listEntry.getType() == 2) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(messageListItem.listEntry.getMessageListEntry().getDateTime());
            block0 : switch (n) {
                case 10: {
                    switch (messageListItem.listType) {
                        case 0: {
                            n2 = 0;
                            break block0;
                        }
                        case 1: {
                            n2 = 1;
                            break block0;
                        }
                        case 2: {
                            n2 = 2;
                            break block0;
                        }
                        case 3: {
                            n2 = 3;
                            break block0;
                        }
                    }
                    n2 = 0;
                    break;
                }
                case 3: {
                    n2 = gregorianCalendar.get(5);
                    break;
                }
                case 6: {
                    n2 = gregorianCalendar.get(11);
                    break;
                }
                case 7: {
                    n2 = gregorianCalendar.get(12);
                    break;
                }
                case 8: {
                    n2 = gregorianCalendar.get(2) + 1;
                    break;
                }
                case 11: {
                    n2 = gregorianCalendar.get(1);
                    break;
                }
                case 20: {
                    n2 = 0;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
                }
            }
        } else {
            switch (n) {
                case 20: {
                    n2 = this.dsiFolderType2ASL(messageListItem.listEntry.folderEntry.getFolderType());
                    break;
                }
                case 3: 
                case 6: 
                case 7: 
                case 8: 
                case 10: 
                case 11: {
                    n2 = 0;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
                }
            }
        }
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        MessageListItem messageListItem = (MessageListItem)object;
        if (messageListItem.listEntry.getType() == 2) {
            switch (n) {
                case 0: {
                    Object[] objectArray;
                    if (messageListItem.listEntry.getMessageListEntry().getMatchedAddress().getAdbEntryID() != 0L) {
                        return messageListItem.listEntry.getMessageListEntry().getMatchedAddress().getName();
                    }
                    Object object2 = messageListItem.listType == 0 ? messageListItem.listEntry.getMessageListEntry().getSender() : (!Util.isNullOrEmpty(objectArray = messageListItem.listEntry.getMessageListEntry().getRecipients()) ? objectArray[0] : "");
                    return !Util.isNullOrEmpty((String)object2) ? object2 : "";
                }
                case 1: {
                    return messageListItem.listEntry.getMessageListEntry().getMatchedAddress().getAddress();
                }
                case 9: {
                    return messageListItem.listEntry.getMessageListEntry().getSubject();
                }
                case 4: {
                    return "";
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
        }
        switch (n) {
            case 4: {
                return messageListItem.listEntry.folderEntry.getFolderName();
            }
            case 0: 
            case 1: 
            case 9: {
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        MessageListItem messageListItem = (MessageListItem)object;
        if (messageListItem.listEntry.getType() == 2) {
            switch (n) {
                case 2: {
                    return messageListItem.listEntry.getMessageListEntry().getMatchedAddress().getAdbPictureID();
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
        }
        switch (n) {
            case 2: {
                return null;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    int dsiFolderType2ASL(int n) {
        int n2;
        switch (n) {
            case 3: {
                n2 = 3;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 2;
                break;
            }
            case 7: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 5;
            }
        }
        return n2;
    }
}

