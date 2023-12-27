/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$8
implements ISerializable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ int val$authScheme;
    private final /* synthetic */ String val$realm;
    private final /* synthetic */ String val$user;
    private final /* synthetic */ String val$passwd;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$8(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n, int n2, String string, String string2, String string3) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$result = n;
        this.val$authScheme = n2;
        this.val$realm = string;
        this.val$user = string2;
        this.val$passwd = string3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$result);
        iSerializer.putEnum(this.val$authScheme);
        iSerializer.putOptionalString(this.val$realm);
        iSerializer.putOptionalString(this.val$user);
        iSerializer.putOptionalString(this.val$passwd);
    }
}

