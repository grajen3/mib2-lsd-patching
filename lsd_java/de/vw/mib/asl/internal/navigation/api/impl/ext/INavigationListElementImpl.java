/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LIValueListElement;

public class INavigationListElementImpl
implements INavigationListElement {
    private LDListElement ldElem;
    private LIValueListElement liValueListElement;

    public String toString() {
        if (this.liValueListElement != null) {
            return this.liValueListElement.toString();
        }
        if (this.ldElem != null) {
            return this.ldElem.toString();
        }
        return "null";
    }

    public INavigationListElementImpl(LDListElement lDListElement) {
        this.ldElem = lDListElement;
    }

    public INavigationListElementImpl(LIValueListElement lIValueListElement) {
        this.liValueListElement = lIValueListElement;
    }

    public LIValueListElement getValueListElement() {
        return this.liValueListElement;
    }

    public LDListElement getLdListElement() {
        return this.ldElem;
    }

    @Override
    public String getTitle() {
        if (this.liValueListElement != null) {
            return this.liValueListElement.data;
        }
        return this.ldElem.title;
    }

    @Override
    public long getId() {
        if (this.liValueListElement != null) {
            return this.liValueListElement.listIndex;
        }
        return this.ldElem.id;
    }
}

