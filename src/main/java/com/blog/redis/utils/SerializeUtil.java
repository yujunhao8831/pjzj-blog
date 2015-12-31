package com.blog.redis.utils;

import java.io.*;

/**
 * 序列化工具
 */
public abstract class SerializeUtil {

    /**
     * 序列化对象成byte数组
     * @param object
     * @return
     */
    public static byte[] serialize (Object object) throws IOException {
        ByteArrayOutputStream byteOut;
        ObjectOutputStream objectOut;
        try {
            byteOut = new ByteArrayOutputStream();
            objectOut = new ObjectOutputStream(byteOut);
            objectOut.writeObject(object);
            objectOut.flush();
            return byteOut.toByteArray();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 反序列化byte数组成Object对象
     * @param bytes
     * @return
     */
    public static Object deserialize (byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteInput;
        try {
            byteInput = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInput = new ObjectInputStream(byteInput);
            return objectInput.readObject();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 反序列化byte数组成指定对象
     * @param bytes
     * @param <T>
     * @return
     */
    public static <T> T deserializeToPojo (byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteInput;
        try {
            byteInput = new ByteArrayInputStream(bytes);
            ObjectInputStream ObjectInput = new ObjectInputStream(byteInput);
            ObjectInput.reset();
            return (T) ObjectInput.readObject();
        } catch (Exception e) {
            throw e;
        }
    }


}
