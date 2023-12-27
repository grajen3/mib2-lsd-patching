/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.Favorite;

public class FavoriteSerializer {
    public static void putOptionalFavorite(ISerializer iSerializer, Favorite favorite) {
        boolean bl = favorite == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = favorite.getName();
            iSerializer.putOptionalString(string);
            String string2 = favorite.getNumber();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalFavoriteVarArray(ISerializer iSerializer, Favorite[] favoriteArray) {
        boolean bl = favoriteArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(favoriteArray.length);
            for (int i2 = 0; i2 < favoriteArray.length; ++i2) {
                FavoriteSerializer.putOptionalFavorite(iSerializer, favoriteArray[i2]);
            }
        }
    }

    public static Favorite getOptionalFavorite(IDeserializer iDeserializer) {
        Favorite favorite = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            favorite = new Favorite();
            favorite.name = string2 = iDeserializer.getOptionalString();
            favorite.number = string = iDeserializer.getOptionalString();
        }
        return favorite;
    }

    public static Favorite[] getOptionalFavoriteVarArray(IDeserializer iDeserializer) {
        Favorite[] favoriteArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            favoriteArray = new Favorite[n];
            for (int i2 = 0; i2 < n; ++i2) {
                favoriteArray[i2] = FavoriteSerializer.getOptionalFavorite(iDeserializer);
            }
        }
        return favoriteArray;
    }
}

