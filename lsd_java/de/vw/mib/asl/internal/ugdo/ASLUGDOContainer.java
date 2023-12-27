/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.internal.ugdo.transformer.UgdoFunctionCollector;

public final class ASLUGDOContainer {
    private static final ASLUGDOContainer DATAPOOL = new ASLUGDOContainer();
    private DSIProxy dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private DSIProxyAdapterFactory adapterFactory = DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getAdapterFactory();
    public static DSIServiceLocator locator = ServiceManager.dsiServiceLocator;
    public static boolean[] functionExistent = new boolean[7];
    public static UgdoFunctionCollector[] collector = new UgdoFunctionCollector[7];
    public static UgdoFunctionCollector[] tempCollector = new UgdoFunctionCollector[7];
    public static UgdoFunctionCollector[] oldSettings = new UgdoFunctionCollector[7];
    private boolean[] menuCoding = new boolean[1];
    private boolean[] speedThreshold = new boolean[1];
    private boolean[] standstill = new boolean[1];

    public static ASLUGDOContainer getInstance() {
        return DATAPOOL;
    }

    private ASLUGDOContainer() {
    }

    public void setMenuCoding(int n, boolean bl) {
        this.menuCoding[n] = bl;
    }

    public boolean[] getMenuCoding() {
        return this.menuCoding;
    }

    public boolean isMenuCoded(int n) {
        return this.menuCoding[n];
    }

    public int getMenuCodingLength() {
        return this.menuCoding.length;
    }

    public void setMenuSpeedThreshold(int n, boolean bl) {
        this.speedThreshold[n] = bl;
    }

    public boolean[] getMenuSpeedThreshold() {
        return this.speedThreshold;
    }

    public void setMenuStandStill(int n, boolean bl) {
        this.standstill[n] = bl;
    }

    public boolean[] getMenuStandStill() {
        return this.standstill;
    }

    public DSIProxy getDSIProxy() {
        return this.dsiProxy;
    }

    public DSIProxyAdapterFactory getAdapterFactory() {
        return this.adapterFactory;
    }
}

