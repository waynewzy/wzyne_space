package com.wayne.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @author wayne
 * @date 2018/5/18 0018 上午 11:12
 * <p>
 * description: MD5Util工具类
 */
public class MD5Util {

    private static final String HEX_NUMS_STR = "0123456789ABCDEF";
    private static final Integer SALT_LENGTH = 12;

    /**
     * 将16进制字符串转换成字节数组
     *
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4
                    | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
        }
        return result;
    }


    /**
     * 将指定byte数组转换成16进制字符串
     *
     * @param b
     * @return
     */
    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    /**
     * 验证口令是否合法
     *
     * @param password
     * @param passwordInDb
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean validPassword(String password, String passwordInDb) {
        //将16进制字符串格式口令转换成字节数组
        byte[] pwdInDb = hexStringToByte(passwordInDb);
        byte[] salt = new byte[SALT_LENGTH];
        System.arraycopy(pwdInDb, 0, salt, 0, SALT_LENGTH);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(salt);
            md.update(password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest();
        byte[] digestInDb = new byte[pwdInDb.length - SALT_LENGTH];
        System.arraycopy(pwdInDb, SALT_LENGTH, digestInDb, 0, digestInDb.length);
        if (Arrays.equals(digest, digestInDb)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获得加密后的16进制形式口令
     *
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getEncryptedPwd(String password) {
        //声明加密后的口令数组变量
        byte[] pwd = null;
        //随机数生成器
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        MessageDigest md = null;
        //创建消息摘要
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(salt);
            md.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //获得消息摘要的字节数组
        byte[] digest = md.digest();
        pwd = new byte[digest.length + SALT_LENGTH];
        System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
        System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
        //将字节数组格式加密后的口令转化为16进制字符串格式的口令
        return byteToHexString(pwd);
    }

    public static void main(String[] args) {
        String s = new String("13067926186");
        String encryptedPwd = getEncryptedPwd(s);
        System.out.println(encryptedPwd);
        System.out.println(validPassword("13067926186", "D49D6A41DF1A224BEB75E7185DAAFCF5A834FFAC4DB191CD102BF6AF"));
    }
}
