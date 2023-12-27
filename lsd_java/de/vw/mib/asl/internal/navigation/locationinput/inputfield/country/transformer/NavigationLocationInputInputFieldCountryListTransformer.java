/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.country.transformer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.country.transformer.AbstractNavigationLocationInputInputFieldCountryListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldCountryListTransformer
extends AbstractNavigationLocationInputInputFieldCountryListTransformer
implements CacheClient {
    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 1) {
            LIValueListElement lIValueListElement = (LIValueListElement)object;
            ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForCountryIcon(lIValueListElement.getIconIndex(), 1, this, object);
            return resourceLocator;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        ListManager.getGenericASLList(3027).updateListItem(((LIValueListElement)object).listIndex, object);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

