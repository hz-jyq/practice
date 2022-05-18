package algorithm;

/**
 * @Author jyq
 * @Date 2022/4/29 15:32
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AES常用解密加密工具类
 * https://github.com/ourlang
 * @author 小林
 */
public class AesUtil {

    /**
     * 默认的字符编码
     */
    private static final String DEFAULT_CHARSET = "utf-8";

    /**
     * 算法
     */
    private static String ALGORITHM = "AES";


    /**
     * 算法/模式/填充
     **/
    private static final String CipherMode = "AES/ECB/PKCS5Padding";


    /**
     * 记录日志
     **/
 //   private final static Logger logger = LoggerFactory.getLogger(AesUtil.class);

    private AesUtil() {
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "100000000000000000";
        for (int i = 0; i < 200000; i++) {
            list.add(str + i);
        }
        String content = list.stream().collect(Collectors.joining(","));

        String encptStr = encrypt("1", content);
        System.out.println(encptStr);

        String decptStr = decrypt("1", encptStr);
        System.out.println(decptStr);
    }

    /**
     * 解密AES 32位
     *
     * @param sSrc      解密的内容
     * @param secretKey 秘钥
     * @return 解密后的明文 数据
     */
    public static String decrypt(String sSrc, String secretKey) {

        if (secretKey == null) {
          //  logger.error("需要加密的秘钥为空");
            return null;
        }
        try {
            byte[] raw = secretKey.getBytes(DEFAULT_CHARSET);
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            // 先用base64解密
            byte[] encryptedArr = Base64.getDecoder().decode(sSrc);
            byte[] original = cipher.doFinal(encryptedArr);
            return new String(original, DEFAULT_CHARSET);
        } catch (Exception ex) {
           // logger.error("AES解密失败", ex);
            return null;
        }
    }


    /**
     * 加密32位
     *
     * @param sSrc 需要加密的内容
     * @param sKey 秘钥
     * @return 加密的内容
     */
    public static String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
          //  logger.error("需要加密的秘钥为空");
            return null;
        }
        try {
            byte[] raw = sKey.getBytes(DEFAULT_CHARSET);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGORITHM);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes(DEFAULT_CHARSET));

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
           // logger.error("AES加密失败", ex);
            return null;
        }
    }

}
