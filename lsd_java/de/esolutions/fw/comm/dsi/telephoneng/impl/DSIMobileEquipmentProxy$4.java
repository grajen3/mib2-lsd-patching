/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentProxy;
import de.esolutions.fw.comm.dsi.telephoneng.impl.FavoriteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.Favorite;

class DSIMobileEquipmentProxy$4
implements ISerializable {
    private final /* synthetic */ Favorite[] val$favorites;
    private final /* synthetic */ DSIMobileEquipmentProxy this$0;

    DSIMobileEquipmentProxy$4(DSIMobileEquipmentProxy dSIMobileEquipmentProxy, Favorite[] favoriteArray) {
        this.this$0 = dSIMobileEquipmentProxy;
        this.val$favorites = favoriteArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        FavoriteSerializer.putOptionalFavoriteVarArray(iSerializer, this.val$favorites);
    }
}

