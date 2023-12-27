/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkUser$UserType;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class UserType
extends GenericEnumValue
implements OnlineNetworkUser$UserType {
    public static final UserType ENUM_MAIN_USER = new UserType(0);
    public static final UserType ENUM_SUB_USER = new UserType(1);

    private UserType(int n) {
        super(n);
    }
}

