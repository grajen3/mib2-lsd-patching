/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASContainer;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public interface HASContainerMarshaller {
    default public HASDataContainer marshal(HASContainer hASContainer) {
    }

    default public HASContainer unmarshal(HASDataContainer hASDataContainer) {
    }

    default public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
    }

    default public void getChildren(HASContainer hASContainer, List list) {
    }
}

