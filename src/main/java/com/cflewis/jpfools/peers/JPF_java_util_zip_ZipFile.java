package com.cflewis.jpfools.peers;

import gov.nasa.jpf.jvm.MJIEnv;
import java.io.IOException;
import java.util.zip.ZipFile;

public class JPF_java_util_zip_ZipFile {
    static ZipFile getZipFile(MJIEnv env, int zipObjectReference) throws IOException {
        // You get this from the source itself, it's a private constructor
        // that JPF can read
        String fileName = env.getStringField(zipObjectReference, "name");
        return new ZipFile(fileName);
    }
    
    public static void $clinit (MJIEnv env, int rcls) {
        // Don't do this!
    }
    
    public static void $init__Ljava_io_File_2I__V(MJIEnv env, int objectReference, int file, int mode) {
        // Do nothing
        System.err.println("Something tried to init");
    }
    
    public static long open__Ljava_lang_String_2IJ__J(MJIEnv env, int objectReference, int nameString, int mode, long lastModified) {
        System.err.println("Something tried to open");
        return 0;
    }
    
    public static void close____V(MJIEnv env, int objectReference) {
        // Do nothing
    }
    
    public static int getEntry__Ljava_lang_String_2__Ljava_util_zip_ZipEntry_2(MJIEnv env, int objectReference, int nameString) {
        return MJIEnv.NULL;
    }
    
    public static int getInputStream__Ljava_util_zip_ZipEntry_2__Ljava_io_InputStream_2(MJIEnv env, int objectReference, int entryZipEntry) {
        return MJIEnv.NULL;
    }
    
    public static int getName____Ljava_lang_String_2(MJIEnv env, int objectReference) throws IOException {
        return env.newString(getZipFile(env, objectReference).getName());
    }
    
    public static int size____I(MJIEnv env, int objectReference) throws IOException {
        return getZipFile(env,objectReference).size();
    }
}
