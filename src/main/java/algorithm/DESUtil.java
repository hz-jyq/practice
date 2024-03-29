package algorithm;

/**
 * @Author jyq
 * @Date 2022/4/29 15:28
 */

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
public class DESUtil {
    /**
     * 偏移变量，固定占8位字节
     */
    private final static String IV_PARAMETER = "12345678";
    /**
     * 加密算法
     */
    private static final String ALGORITHM = "DES";
    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
    /**
     * 默认编码
     */
    private static final String CHARSET = "utf-8";
    /**
     * 秘钥
     */
    private static final String KEY = "key12345678";


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "100000000000000000";
        for (int i = 0; i < 200000; i++) {
            list.add(str + i);
        }
        String content = list.stream().collect(Collectors.joining(","));

        String encptStr = encrypt(KEY, content);
        System.out.println(encptStr);

        String decptStr = decrypt(KEY, encptStr);
        System.out.println(decptStr);
    }

    /**
     * 生成key
     *
     * @param password
     * @return
     * @throws Exception
     */
    private static Key generateKey(String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(password.getBytes(CHARSET));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }


    /**
     * DES加密字符串
     *
     * @param password 加密密码，长度不能够小于8位
     * @param data     待加密字符串
     * @return 加密后内容
     */
    public static String encrypt(String password, String data) {
        if (password == null || password.length() < 8) {
            throw new RuntimeException("加密失败，key不能小于8位");
        }
        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            // 加密
            byte[] bytes = cipher.doFinal(data.getBytes(CHARSET));

            // base64编码  JDK1.8及以上可直接使用Base64，JDK1.7及以下可以使用BASE64Encoder
            byte[] encode = Base64.getEncoder().encode(bytes);

            return new String(encode);

        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * DES解密字符串
     *
     * @param password 解密密码，长度不能够小于8位
     * @param data     待解密字符串
     * @return 解密后内容
     */
    public static String decrypt(String password, String data) {
        if (password == null || password.length() < 8) {
            throw new RuntimeException("加密失败，key不能小于8位");
        }
        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

            // base64解码
            byte[] decode = Base64.getDecoder().decode(data.getBytes(CHARSET));

            // 解密
            byte[] decrypt = cipher.doFinal(decode);

            return new String(decrypt, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
}