/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.transformer;

import de.vw.mib.asl.internal.online.clients.model.transformer.CoreServiceModelServicePackageTransformer;
import generated.de.vw.mib.asl.internal.online.transformer.AbstractOnlineOnlineServicePackageTransformer;

public class OnlineOnlineServicePackageTransformer
extends AbstractOnlineOnlineServicePackageTransformer {
    CoreServiceModelServicePackageTransformer transformer = new CoreServiceModelServicePackageTransformer();

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

