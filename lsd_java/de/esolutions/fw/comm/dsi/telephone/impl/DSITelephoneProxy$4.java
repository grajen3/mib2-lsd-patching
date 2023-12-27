/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.dsi.telephone.impl.DSITelephoneProxy;
import de.esolutions.fw.comm.dsi.telephone.impl.FavoriteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.Favorite;

class DSITelephoneProxy$4
implements ISerializable {
    private final /* synthetic */ Favorite[] val$favorites;
    private final /* synthetic */ DSITelephoneProxy this$0;

    DSITelephoneProxy$4(DSITelephoneProxy dSITelephoneProxy, Favorite[] favoriteArray) {
        this.this$0 = dSITelephoneProxy;
        this.val$favorites = favoriteArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        FavoriteSerializer.putOptionalFavoriteVarArray(iSerializer, this.val$favorites);
    }
}

