package com.cflewis.jpfools.peers;

import gov.nasa.jpf.jvm.MJIEnv;
import java.io.IOException;
import java.util.zip.ZipFile;


public class JPF_java_util_zip_ZipFile {

    static ZipFile getZipFile(MJIEnv env, int objRef) {
        try {
            int fileNameRef = env.getReferenceField(objRef, "filename");
            String fileName = env.getStringObject(fileNameRef);

            try {
                return new ZipFile(fileName);
            } catch (IOException e) {
                env.throwException("java.io.IOException", e.getMessage());
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void $clinit(MJIEnv env, int rcls) {
        // Do nothing
    }

    public static void finalize____V(MJIEnv env, int objRef) {
        // Don't do anything
    }

    public static int getName____Ljava_lang_String_2(MJIEnv env, int objRef) {
        ZipFile zipFile = getZipFile(env, objRef);
        return env.newString(zipFile.getName());
    }

    public static int size____I(MJIEnv env, int objRef) {
        ZipFile zipFile = getZipFile(env, objRef);
        return zipFile.size();
    }

    public static void close__J__V(MJIEnv env, int rcls, long v0) {
        // Do nothing
    }

    public static void close____V(MJIEnv env, int objRef) {
        // Do nothing
    }

    public static long getSize__J__J(MJIEnv env, int rcls, long v0) {
        // Do nothing
        return (long)0;
    }

    public static int getEntry__Ljava_lang_String_2__Ljava_util_zip_ZipEntry_2(MJIEnv env, int objRef, int rString0) {
        ZipFile zipFile = getZipFile(env, objRef);
        String s = env.getStringObject(rString0);

        return env.newObject("java.util.zip.ZipEntry");
    }

    public static long getEntry__JLjava_lang_String_2Z__J(MJIEnv env, int rcls, long v0, int rString1, boolean v2) {
        // Do nothing
        return (long)0;
    }

    public static int entries____Ljava_util_Enumeration_2(MJIEnv env, int objRef) {
        int rEnumeration = MJIEnv.NULL;
        return rEnumeration;
    }

    public static int getInputStream__Ljava_util_zip_ZipEntry_2__Ljava_io_InputStream_2(MJIEnv env, int objRef, int rZipEntry0) {
        int rInputStream = MJIEnv.NULL;
        return rInputStream;
    }

    public static int getInputStream__Ljava_lang_String_2__Ljava_io_InputStream_2(MJIEnv env, int objRef, int rString0) {
        int rInputStream = MJIEnv.NULL;
        return rInputStream;
    }

    public static long open__Ljava_lang_String_2IJ__J(MJIEnv env, int rcls, int rString0, int v1, long v2) {
        long v = (long) 0;
        return v;
    }

    public static int getTotal__J__I(MJIEnv env, int rcls, long v0) {
        int v = (int) 0;
        return v;
    }

  public static void initIDs____V (MJIEnv env, int rcls) {
  }

}
