/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.transformer;

import de.vw.mib.asl.internal.online.clients.model.transformer.CoreServiceModelApplicationTransformer;
import generated.de.vw.mib.asl.internal.online.transformer.AbstractOnlineOnlineApplicationTransformer;

public class OnlineOnlineApplicationTransformer
extends AbstractOnlineOnlineApplicationTransformer {
    CoreServiceModelApplicationTransformer transformer = new CoreServiceModelApplicationTransformer();

    @Override
    public boolean getBoolean(int n, Object object) {
        return this.transformer.getBoolean(n, object);
    }

    @Override
    public String getString(int n, Object object) {
        return this.transformer.getString(n, object);
    }

    @Override
    public int getInt(int n, Object object) {
        return this.transformer.getInt(n, object);
    }
}

