/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.data;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkUser$UserType;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.mapping.ServiceMapping;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.UserList_Data;

public class OnlineNetworkUser
implements de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkUser {
    private final String userName;
    private final OnlineNetworkUser$UserType userType;

    public OnlineNetworkUser(UserList_Data userList_Data) {
        this.userName = userList_Data.userName.toString();
        this.userType = ServiceMapping.mapBapUserType(userList_Data.userType);
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public OnlineNetworkUser$UserType getUserType() {
        return this.userType;
    }
}

