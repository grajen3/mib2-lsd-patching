/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.travellink;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.travellink.GenericProperty;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;
import org.dsi.ifc.travellink.Values;

public final class DSITravellinkTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_GENERICPROPERTY;
    private static final int ID_GENERICPROPERTYCONTAINER;
    private static final int ID_TRAVELLINKDATE;
    private static final int ID_VALUES;
    static /* synthetic */ Class class$org$dsi$ifc$travellink$GenericProperty;
    static /* synthetic */ Class class$org$dsi$ifc$travellink$GenericPropertyContainer;
    static /* synthetic */ Class class$org$dsi$ifc$travellink$TravelLinkDate;
    static /* synthetic */ Class class$org$dsi$ifc$travellink$Values;

    public DSITravellinkTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$travellink$GenericProperty == null ? (class$org$dsi$ifc$travellink$GenericProperty = DSITravellinkTracer.class$("org.dsi.ifc.travellink.GenericProperty")) : class$org$dsi$ifc$travellink$GenericProperty, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$travellink$GenericPropertyContainer == null ? (class$org$dsi$ifc$travellink$GenericPropertyContainer = DSITravellinkTracer.class$("org.dsi.ifc.travellink.GenericPropertyContainer")) : class$org$dsi$ifc$travellink$GenericPropertyContainer, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$travellink$TravelLinkDate == null ? (class$org$dsi$ifc$travellink$TravelLinkDate = DSITravellinkTracer.class$("org.dsi.ifc.travellink.TravelLinkDate")) : class$org$dsi$ifc$travellink$TravelLinkDate, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$travellink$Values == null ? (class$org$dsi$ifc$travellink$Values = DSITravellinkTracer.class$("org.dsi.ifc.travellink.Values")) : class$org$dsi$ifc$travellink$Values, 4);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceGenericProperty(printWriter, (GenericProperty)object);
                break;
            }
            case 2: {
                this.traceGenericPropertyContainer(printWriter, (GenericPropertyContainer)object);
                break;
            }
            case 3: {
                this.traceTravelLinkDate(printWriter, (TravelLinkDate)object);
                break;
            }
            case 4: {
                this.traceValues(printWriter, (Values)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceGenericProperty(PrintWriter printWriter, GenericProperty genericProperty) {
        int n;
        int n2;
        if (genericProperty == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(genericProperty.key);
        if (genericProperty.valuesString == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericProperty.valuesString.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(genericProperty.valuesString[n]);
            }
        }
        if (genericProperty.valuesInt == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericProperty.valuesInt.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(genericProperty.valuesInt[n]);
            }
        }
        if (genericProperty.valuesLong == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericProperty.valuesLong.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(genericProperty.valuesLong[n]);
            }
        }
        if (genericProperty.valuesFloat == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericProperty.valuesFloat.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(genericProperty.valuesFloat[n]);
            }
        }
        if (genericProperty.valuesBoolean == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericProperty.valuesBoolean.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(genericProperty.valuesBoolean[n]);
            }
        }
        if (genericProperty.valuesResourceLocator == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericProperty.valuesResourceLocator.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, genericProperty.valuesResourceLocator[n]);
            }
        }
        if (genericProperty.valuesDate == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericProperty.valuesDate.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, genericProperty.valuesDate[n]);
            }
        }
    }

    private void traceGenericPropertyContainer(PrintWriter printWriter, GenericPropertyContainer genericPropertyContainer) {
        int n;
        int n2;
        if (genericPropertyContainer == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (genericPropertyContainer.keys == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericPropertyContainer.keys.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(genericPropertyContainer.keys[n]);
            }
        }
        if (genericPropertyContainer.values == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = genericPropertyContainer.values.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, genericPropertyContainer.values[n]);
            }
        }
    }

    private void traceTravelLinkDate(PrintWriter printWriter, TravelLinkDate travelLinkDate) {
        if (travelLinkDate == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(travelLinkDate.year);
        printWriter.print(travelLinkDate.day);
        printWriter.print(travelLinkDate.month);
        printWriter.print(travelLinkDate.hour);
        printWriter.print(travelLinkDate.minute);
        printWriter.print(travelLinkDate.second);
    }

    private void traceValues(PrintWriter printWriter, Values values) {
        int n;
        int n2;
        if (values == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (values.valuesString == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesString.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(values.valuesString[n]);
            }
        }
        if (values.valuesInt == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesInt.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(values.valuesInt[n]);
            }
        }
        if (values.valuesLong == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesLong.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(values.valuesLong[n]);
            }
        }
        if (values.valuesFloat == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesFloat.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(values.valuesFloat[n]);
            }
        }
        if (values.valuesDouble == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesDouble.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(values.valuesDouble[n]);
            }
        }
        if (values.valuesBoolean == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesBoolean.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(values.valuesBoolean[n]);
            }
        }
        if (values.valuesResourceLocator == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesResourceLocator.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, values.valuesResourceLocator[n]);
            }
        }
        if (values.valuesDate == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = values.valuesDate.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, values.valuesDate[n]);
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

