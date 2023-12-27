/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.transformer;

import generated.de.vw.mib.asl.internal.connectivity.transformer.AbstractConnectivityConfigurationListTransformer;
import org.dsi.ifc.networking.CDataProfile;

public class ConnectivityConfigurationListTransformer
extends AbstractConnectivityConfigurationListTransformer {
    @Override
    public String getString(int n, Object object) {
        CDataProfile cDataProfile = (CDataProfile)object;
        switch (n) {
            case 0: {
                return cDataProfile.dataProfileName;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

