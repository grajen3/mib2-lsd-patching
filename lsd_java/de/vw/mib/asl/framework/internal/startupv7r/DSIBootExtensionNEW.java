/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class DSIBootExtensionNEW
implements ServiceAdmin {
    private ServiceAdmin jdsi;

    @Override
    public boolean startService(String string, int n) {
        if (ServiceManager.logger.isTraceEnabled(1)) {
            ServiceManager.logger.trace(1).append("Start service ").append(string).append(" (instance ").append(n).append(" )").log();
        }
        boolean bl = false;
        if (System.getProperty("useStartupBootExtension") != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append("(").append("objectClass").append("=").append(string).append(")");
            try {
                ServiceReference[] serviceReferenceArray = null;
                serviceReferenceArray = ServiceManager.bundleContext.getServiceReferences(null, stringBuffer.toString());
                for (int i2 = 0; !bl && serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
                    int n2 = -1;
                    if (serviceReferenceArray[i2].getProperty("DEVICE_INSTANCE") != null) {
                        n2 = (Integer)serviceReferenceArray[i2].getProperty("DEVICE_INSTANCE");
                    }
                    boolean bl2 = bl = n == n2;
                    if (!bl) continue;
                    ServiceManager.logger.info(1).append("Not starting service ").append(string).append(" (instance ").append(n).append(" ) again because already found in OSGi registry!").log();
                    return false;
                }
            }
            catch (InvalidSyntaxException invalidSyntaxException) {
                ServiceManager.logger.error(1, invalidSyntaxException.toString());
            }
        }
        if (!bl) {
            this.jdsi.startService(string, n);
        }
        return true;
    }

    @Override
    public boolean stopService(String string, int n) {
        this.jdsi.stopService(string, n);
        return true;
    }

    public DSIBootExtensionNEW(Object object) {
        this.jdsi = (ServiceAdmin)object;
    }
}

