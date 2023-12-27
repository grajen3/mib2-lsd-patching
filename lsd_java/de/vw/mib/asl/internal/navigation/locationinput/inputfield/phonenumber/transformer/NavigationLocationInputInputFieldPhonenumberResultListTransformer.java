/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer.AbstractNavigationLocationInputInputFieldPhonenumberResultListTransformer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldPhonenumberResultListTransformer
extends AbstractNavigationLocationInputInputFieldPhonenumberResultListTransformer
implements CacheClient {
    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        if (n == 1) {
            LIValueListElement lIValueListElement = (LIValueListElement)object;
            LIExtData[] lIExtDataArray = lIValueListElement.getExtendedData();
            String string = "";
            String string2 = "";
            for (int i2 = 0; i2 < lIExtDataArray.length; ++i2) {
                if (lIExtDataArray[i2].type == 10000) {
                    string = lIExtDataArray[i2].data;
                }
                if (lIExtDataArray[i2].type != 10001) continue;
                string2 = lIExtDataArray[i2].data;
            }
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(lIValueListElement.latitude, lIValueListElement.longitude);
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper, lIValueListElement.data, string, string2);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 2) {
            LIValueListElement lIValueListElement = (LIValueListElement)object;
            NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
            int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(navLocation.getLongitude(), navLocation.getLatitude(), lIValueListElement.longitude, lIValueListElement.latitude);
            return n2;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 0) {
            LIValueListElement lIValueListElement = (LIValueListElement)object;
            ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(lIValueListElement.getIconIndex(), lIValueListElement.getSubIconIndex(), 0, this, object);
            return resourceLocator;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        ListManager.getGenericASLList(-839905280).updateListItem(((LIValueListElement)object).listIndex, object);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

