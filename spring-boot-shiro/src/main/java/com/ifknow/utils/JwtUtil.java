package com.ifknow.utils;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/27  11:15 <br>
 * @Description: NO Description
 */
public class JwtUtil {
    /**
     * 生成签名是所使用的秘钥
     */

    private final String base64EncodedSecretKey;
    /**
     * 生成签名的时候所使用的加密算法
     */
    private final SignatureAlgorithm signatureAlgorithm;


    public JwtUtil(String base64EncodedSecretKey, SignatureAlgorithm signatureAlgorithm) {
        this.base64EncodedSecretKey = base64EncodedSecretKey;
        this.signatureAlgorithm = signatureAlgorithm;
    }
}
