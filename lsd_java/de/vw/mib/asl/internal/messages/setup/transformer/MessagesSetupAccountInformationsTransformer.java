/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.setup.transformer;

import de.vw.mib.asl.internal.messages.ASLMessagingData;
import generated.de.vw.mib.asl.internal.messages.setup.transformer.AbstractMessagesSetupAccountInformationsTransformer;
import org.dsi.ifc.messaging.MessagingAccount;

public class MessagesSetupAccountInformationsTransformer
extends AbstractMessagesSetupAccountInformationsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 1: {
                return false;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        MessagingAccount messagingAccount = (MessagingAccount)object;
        switch (n) {
            case 0: {
                return messagingAccount.getAccountName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        MessagingAccount messagingAccount = (MessagingAccount)object;
        switch (n) {
            case 2: {
                switch (messagingAccount.getAccountType()) {
                    case 2: {
                        return ASLMessagingData.newMessagesSetExternal.size();
                    }
                    case 1: {
                        return ASLMessagingData.newMessagesSetInternal.size();
                    }
                    case 3: {
                        return ASLMessagingData.newMessagesSetInternal.size();
                    }
                }
                throw new IllegalArgumentException("wrong account type");
            }
            case 3: {
                return this.accountTypeDSIToASL(messagingAccount.getAccountType());
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private int accountTypeDSIToASL(int n) {
        int n2 = 0;
        switch (n) {
            case 2: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return n2;
    }
}

