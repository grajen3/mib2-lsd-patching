/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Point;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.BaseAlphabet$ByteBuffer;
import de.vw.mib.widgets.speller.SeparatorElement;
import de.vw.mib.widgets.speller.SpellerElement;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class BaseAlphabet
implements Alphabet {
    public static final String VERSION;
    private final ArrayList spellerElements;
    private final ArrayList separatorElements;
    private int elementCount;
    private static int id;
    private SpellerElement parent;
    private Point location;
    private Dimension size;
    private Point offset;
    private String name;
    private String fileName;

    public BaseAlphabet() {
        this("", "");
    }

    public BaseAlphabet(String string, String string2) {
        this.name = string == null ? "" : string;
        this.fileName = string2 == null ? "" : string2;
        this.spellerElements = new ArrayList(0);
        this.separatorElements = new ArrayList(0);
        this.init();
    }

    @Override
    public void addElement(SpellerElement spellerElement) {
        this.spellerElements.add(spellerElement);
        if (spellerElement != null) {
            spellerElement.setAlphabet(this);
        }
    }

    @Override
    public SpellerElement getElement(int n) {
        return (SpellerElement)this.spellerElements.get(n);
    }

    @Override
    public int getElementCount() {
        return this.getElementCount(false);
    }

    @Override
    public int getElementCount(boolean bl) {
        if (!bl) {
            return this.spellerElements.size();
        }
        return this.elementCount;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addSeparator(SeparatorElement separatorElement) {
        this.separatorElements.add(separatorElement);
        if (separatorElement != null) {
            separatorElement.setAlphabet(this);
        }
    }

    @Override
    public SeparatorElement getSeparator(int n) {
        return (SeparatorElement)this.separatorElements.get(n);
    }

    @Override
    public int getSeparatorCount() {
        return this.separatorElements.size();
    }

    @Override
    public void init() {
    }

    @Override
    public void setLocation(Point point) {
        this.location = point;
    }

    @Override
    public void setLocation(int n, int n2) {
        this.location = new Point(n, n2);
    }

    @Override
    public Point getLocation() {
        if (this.location == null) {
            this.location = new Point();
        }
        return this.location;
    }

    @Override
    public void setSize(Dimension dimension) {
        this.getSize().setSize(dimension);
    }

    @Override
    public Dimension getSize() {
        if (this.size == null) {
            this.size = new Dimension();
        }
        return this.size;
    }

    @Override
    public SpellerElement getParent() {
        return this.parent;
    }

    public void setOffset(Point point) {
        this.offset = point;
    }

    public Point getOffset() {
        if (this.offset == null) {
            this.offset = new Point();
        }
        return this.offset;
    }

    @Override
    public void setParent(SpellerElement spellerElement) {
        this.parent = spellerElement;
    }

    public void serialize(OutputStream outputStream) {
        BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer = new BaseAlphabet$ByteBuffer();
        this.printAlphabet(baseAlphabet$ByteBuffer, this);
        baseAlphabet$ByteBuffer.write(outputStream);
    }

    private void printAlphabet(BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer, Alphabet alphabet) {
        Object object;
        int n;
        baseAlphabet$ByteBuffer.write2ByteInt(alphabet.getElementCount());
        for (n = 0; n < alphabet.getElementCount(); ++n) {
            object = alphabet.getElement(n);
            this.printSpellerElement(baseAlphabet$ByteBuffer, (SpellerElement)object);
            if (((SpellerElement)object).getSubAlphabet() != null) {
                this.printAlphabet(baseAlphabet$ByteBuffer, ((SpellerElement)object).getSubAlphabet());
                continue;
            }
            baseAlphabet$ByteBuffer.write2ByteInt(0);
        }
        baseAlphabet$ByteBuffer.write2ByteInt(alphabet.getSeparatorCount());
        for (n = 0; n < alphabet.getSeparatorCount(); ++n) {
            object = alphabet.getSeparator(n);
            this.printSeparatorElement(baseAlphabet$ByteBuffer, (SeparatorElement)object);
        }
    }

    private void printSpellerElement(BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer, SpellerElement spellerElement) {
        baseAlphabet$ByteBuffer.write2ByteInt(spellerElement.getX());
        baseAlphabet$ByteBuffer.write2ByteInt(spellerElement.getY());
        baseAlphabet$ByteBuffer.write2ByteInt(spellerElement.getWidth());
        baseAlphabet$ByteBuffer.write2ByteInt(spellerElement.getHeight());
        String string = spellerElement.getTemplateId().trim();
        baseAlphabet$ByteBuffer.writeUTF16String(string);
        String string2 = spellerElement.getGraphRep() != null && spellerElement.getGraphRep().trim().length() > 0 ? spellerElement.getGraphRep().trim() : " ";
        baseAlphabet$ByteBuffer.writeUTF16String(string2);
        String string3 = spellerElement.getGraphRep2() != null && spellerElement.getGraphRep2().trim().length() > 0 ? spellerElement.getGraphRep2().trim() : " ";
        baseAlphabet$ByteBuffer.writeUTF16String(string3);
        String string4 = spellerElement.getReturnValue() != null && spellerElement.getReturnValue().trim().length() > 0 ? spellerElement.getReturnValue().trim() : " ";
        baseAlphabet$ByteBuffer.writeUTF16String(string4);
        String string5 = spellerElement.getReturnFunction() != null && spellerElement.getReturnFunction().trim().length() > 0 ? spellerElement.getReturnFunction().trim() : " ";
        baseAlphabet$ByteBuffer.writeUTF16String(string5);
    }

    private void printSeparatorElement(BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer, SeparatorElement separatorElement) {
        baseAlphabet$ByteBuffer.write2ByteInt(separatorElement.getX());
        baseAlphabet$ByteBuffer.write2ByteInt(separatorElement.getY());
        baseAlphabet$ByteBuffer.write2ByteInt(separatorElement.getWidth());
        baseAlphabet$ByteBuffer.write2ByteInt(separatorElement.getHeight());
        baseAlphabet$ByteBuffer.write2ByteInt(separatorElement.getImageId());
    }

    public void deserialize(InputStream inputStream) {
        BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer = new BaseAlphabet$ByteBuffer();
        this.spellerElements.clear();
        this.separatorElements.clear();
        this.elementCount = 0;
        id = 0;
        baseAlphabet$ByteBuffer.read(inputStream);
        this.readAlphabet(baseAlphabet$ByteBuffer);
    }

    private void readAlphabet(BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer) {
        Object object;
        int n;
        SpellerElement spellerElement = null;
        int n2 = 0;
        int n3 = baseAlphabet$ByteBuffer.read2ByteInt();
        if (n3 == 0) {
            return;
        }
        this.spellerElements.ensureCapacity(n3);
        for (n = 0; n < n3; ++n) {
            SpellerElement spellerElement2 = this.readElement(baseAlphabet$ByteBuffer, id, n2);
            this.addElement(spellerElement2);
            ++n2;
            ++id;
            if (spellerElement != null) {
                spellerElement.setRightSpellerElement(spellerElement2);
                spellerElement2.setLeftSpellerElement(spellerElement);
            }
            ++this.elementCount;
            object = new BaseAlphabet(this.name, this.fileName);
            super.readAlphabet(baseAlphabet$ByteBuffer);
            if (((BaseAlphabet)object).getElementCount() > 0) {
                spellerElement2.setSubAlphabet((Alphabet)object);
                ((BaseAlphabet)object).setParent(spellerElement2);
                this.initializeSubAlphabet((Alphabet)object, spellerElement2);
                this.elementCount += ((BaseAlphabet)object).getElementCount(true);
            }
            spellerElement = spellerElement2;
        }
        this.spellerElements.trimToSize();
        n = baseAlphabet$ByteBuffer.read2ByteInt();
        this.separatorElements.ensureCapacity(n);
        for (int i2 = 0; i2 < n; ++i2) {
            object = this.readSeparator(baseAlphabet$ByteBuffer, i2);
            this.addSeparator((SeparatorElement)object);
        }
        this.separatorElements.trimToSize();
    }

    private SpellerElement readElement(BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer, int n, int n2) {
        int n3 = baseAlphabet$ByteBuffer.read2ByteInt();
        int n4 = baseAlphabet$ByteBuffer.read2ByteInt();
        int n5 = baseAlphabet$ByteBuffer.read2ByteInt();
        int n6 = baseAlphabet$ByteBuffer.read2ByteInt();
        String string = this.specialTrim(baseAlphabet$ByteBuffer.readUTF16String());
        String string2 = this.specialTrim(baseAlphabet$ByteBuffer.readUTF16String());
        String string3 = this.specialTrim(baseAlphabet$ByteBuffer.readUTF16String());
        String string4 = this.specialTrim(baseAlphabet$ByteBuffer.readUTF16String());
        String string5 = this.specialTrim(baseAlphabet$ByteBuffer.readUTF16String());
        SpellerElement spellerElement = new SpellerElement(n, n2, n3, n4, n5, n6, string, string2, string3, string4, string5);
        return spellerElement;
    }

    private SeparatorElement readSeparator(BaseAlphabet$ByteBuffer baseAlphabet$ByteBuffer, int n) {
        int n2 = baseAlphabet$ByteBuffer.read2ByteInt();
        int n3 = baseAlphabet$ByteBuffer.read2ByteInt();
        int n4 = baseAlphabet$ByteBuffer.read2ByteInt();
        int n5 = baseAlphabet$ByteBuffer.read2ByteInt();
        int n6 = baseAlphabet$ByteBuffer.read2ByteInt();
        return new SeparatorElement(n, n2, n3, n4, n5, n6);
    }

    private String specialTrim(String string) {
        if (string.length() <= 0) {
            return string;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (' ' == string.charAt(i2)) continue;
            return string.trim();
        }
        return " ";
    }

    private void initializeSubAlphabet(Alphabet alphabet, SpellerElement spellerElement) {
        int n = -129;
        int n2 = -129;
        int n3 = 0;
        int n4 = 0;
        for (int i2 = alphabet.getElementCount() - 1; i2 >= 0; --i2) {
            SpellerElement spellerElement2 = alphabet.getElement(i2);
            int n5 = spellerElement2.getX();
            int n6 = spellerElement2.getY();
            int n7 = spellerElement2.getWidth();
            int n8 = spellerElement2.getHeight();
            n = Math.min(n, n5);
            n2 = Math.min(n2, n6);
            n3 = Math.max(n3, n5 + n7);
            n4 = Math.max(n4, n6 + n8);
        }
        alphabet.setSize(new Dimension(n3 - n, n4 - n2));
        this.adjustSubAlphabet(alphabet, spellerElement, n, n2);
    }

    public void adjustSubAlphabet(Alphabet alphabet, SpellerElement spellerElement, int n, int n2) {
        Object object;
        int n3;
        for (n3 = alphabet.getElementCount() - 1; n3 >= 0; --n3) {
            object = alphabet.getElement(n3);
            ((SpellerElement)object).setX(((SpellerElement)object).getX() - n + this.getOffset().x);
            ((SpellerElement)object).setY(((SpellerElement)object).getY() - n2 + this.getOffset().y);
        }
        for (n3 = alphabet.getSeparatorCount() - 1; n3 >= 0; --n3) {
            object = alphabet.getSeparator(n3);
            ((SeparatorElement)object).setX(((SeparatorElement)object).getX() - n + this.getOffset().x);
            ((SeparatorElement)object).setY(((SeparatorElement)object).getY() - n2 + this.getOffset().y);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[");
        stringBuilder.append("name='").append(this.name).append("', ");
        stringBuilder.append("fileName='").append(this.fileName).append("', ");
        if (this.spellerElements != null) {
            stringBuilder.append("spellerElements=[");
            for (int i2 = 0; i2 < this.spellerElements.size(); ++i2) {
                stringBuilder.append("[").append(((SpellerElement)this.spellerElements.get(i2)).getGraphRep()).append("]");
            }
            stringBuilder.append("], ");
        }
        stringBuilder.append("elementCount=").append(this.elementCount);
        if (this.parent != null) {
            stringBuilder.append(", ");
            stringBuilder.append("parent=").append(this.parent.getGraphRep());
        }
        if (this.location != null) {
            stringBuilder.append(", ");
            stringBuilder.append("location=").append(this.location);
        }
        if (this.size != null) {
            stringBuilder.append(", ");
            stringBuilder.append("size=").append(this.size);
        }
        if (this.offset != null) {
            stringBuilder.append(", ");
            stringBuilder.append("offset=").append(this.offset);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

