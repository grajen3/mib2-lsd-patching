/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.MIF;
import de.vw.mib.tools.mif.MultiImageFileCreator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MultiImageFileCreatorImpl
implements MultiImageFileCreator {
    MultiImageFileCreatorImpl() {
    }

    @Override
    public void loadDll() {
        System.loadLibrary("mifinator");
    }

    @Override
    public boolean createMIF(String string) {
        return MIF.createMIF(string) > 0;
    }

    @Override
    public boolean addMetaData(int n, String string, String string2) {
        return MIF.addMetaData(n, string, string2) > 0;
    }

    @Override
    public boolean addImage(int n, String string) {
        return MIF.addImage(n, string) > 0;
    }

    @Override
    public void saveMIF() {
        MIF.saveMIF();
    }

    public static void main(String[] stringArray) {
        MultiImageFileCreatorImpl multiImageFileCreatorImpl = new MultiImageFileCreatorImpl();
        if (stringArray.length < 2) {
            System.out.println("Usage: MultiImageFileCreatorImpl imagelistfile outputfile\n\tMultiImageFileCreatorImpl -x miffile id");
            return;
        }
        multiImageFileCreatorImpl.loadDll();
        if (stringArray[0].equals("-x")) {
            System.out.println("Image extraction currently not implemented in this tool (use native tool named createMIF)");
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            String string;
            bufferedReader = new BufferedReader(new FileReader(stringArray[0]));
            if (!multiImageFileCreatorImpl.createMIF(stringArray[1])) {
                System.out.println(new StringBuffer().append("Creation of output file ").append(stringArray[1]).append(" failed\n").toString());
                return;
            }
            while ((string = bufferedReader.readLine()) != null) {
                int n = string.indexOf(32);
                String string2 = string.substring(0, n);
                String string3 = string.substring(n + 1);
                int n2 = Integer.parseInt(string2);
                if (n2 < 0) continue;
                System.out.print(".");
                if (multiImageFileCreatorImpl.addImage(n2, string3)) continue;
                System.out.println(new StringBuffer().append("adding image ").append(string3).append(" (id ").append(string2).append(") failed - skipping...").toString());
            }
            bufferedReader.close();
        }
        catch (IOException iOException) {
            System.out.println(new StringBuffer().append("Cannot open input file ").append(stringArray[0]).toString());
            try {
                bufferedReader.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        multiImageFileCreatorImpl.addMetaData(4711, "version 1.0", "created by MultiImageFileCreatorImpl");
        multiImageFileCreatorImpl.saveMIF();
    }
}

