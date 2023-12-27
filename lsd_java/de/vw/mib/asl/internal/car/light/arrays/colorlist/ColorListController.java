/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListClientsUpdater;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListContext;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListDsiAdapter;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListDsiListener;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListElementAdapter;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public final class ColorListController
implements ASGArrayListFactory,
ASGArrayListDelegate,
Logger {
    private ColorListContext context;
    private ASGArrayList colorListArrayList;
    private ColorListDsiAdapter colorListDsiAdapter;
    private static final int MAX_ELEMENTS_PER_REQUEST;
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final long HIGH_LEVEL_RETRY_RETRY_TIME;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo;

    public ColorListController(ColorListContext colorListContext) {
        this.context = colorListContext;
    }

    private ColorListContext getContext() {
        return this.context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    public ColorListDsiListener getColorListDsiListener() {
        if (this.colorListDsiAdapter == null) {
            this.colorListDsiAdapter = new ColorListDsiAdapter(this.getContext(), this.getColorListArrayList());
        }
        return this.colorListDsiAdapter;
    }

    private ASGArrayList getColorListArrayList() {
        if (this.colorListArrayList == null) {
            this.colorListArrayList = new ArrayListFactory().createCompleteArrayList(this, new ColorListClientsUpdater(this.getContext()), this, 1, 0, true, 4, 0);
        }
        return this.colorListArrayList;
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return null;
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new ColorListElementAdapter();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        return new ColorListElementAdapter((ColorListElementAdapter)bAPArrayElement);
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return BapArrayFactory.getInstance().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPGetArray);
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        DSICarLight dSICarLight = this.getContext().getDsiCarLight();
        Method[] methodArray = super.getClass().getMethods();
        Method method = null;
        try {
            for (int i2 = 0; i2 < methodArray.length; ++i2) {
                if (!methodArray[i2].getName().equals("requestIntLightRGBColorList")) continue;
                method = methodArray[i2];
                if (method.getParameterTypes()[0].equals(class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo == null ? (class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo = ColorListController.class$("org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo")) : class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo)) {
                    IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo(n, arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPGetArray.getTransactionId());
                    method.invoke(dSICarLight, new Object[]{intLightRGBColorListUpdateInfo});
                } else {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = new CarArrayListUpdateInfo(0, bAPGetArray.getTransactionId(), arrayHeader.getRecordAddress(), n, arrayHeader.start, arrayHeader.elements);
                    method.invoke(dSICarLight, new Object[]{carArrayListUpdateInfo});
                }
                break;
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.getContextLoger().error(new StringBuffer().append("IllegalArgumentException: ").append(illegalArgumentException.getMessage()).toString());
        }
        catch (IllegalAccessException illegalAccessException) {
            this.getContextLoger().error(new StringBuffer().append("IllegalAccessException: ").append(illegalAccessException.getMessage()).toString());
        }
        catch (InvocationTargetException invocationTargetException) {
            this.getContextLoger().error(new StringBuffer().append("InvocationTargetException: ").append(invocationTargetException.getMessage()).toString());
        }
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getContextLoger().error("Request array time out");
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 10;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append("color list: ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContextLoger().fatal(string2);
                break;
            }
            case 2: {
                this.getContextLoger().error(string2);
                break;
            }
            case 4: {
                this.getContextLoger().warn(string2);
                break;
            }
            case 8: {
                this.getContextLoger().info(string2);
                break;
            }
            case 12: {
                this.getContextLoger().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContextLoger().isTraceEnabled()) break;
                this.getContextLoger().trace(string2);
                break;
            }
            default: {
                this.getContextLoger().error("Unknown log message called");
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

