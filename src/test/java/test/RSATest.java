/*
 * A George software product.
 * Copyright (C) George (http://www.georgeinfo.com), All Rights Reserved..
 */
package test;

import com.georgeinfo.enctool.util.RSAKey;
import com.georgeinfo.enctool.util.RSATool;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * RSA非对称加解密单元测试
 *
 * @author George <Georgeinfo@163.com>
 */
public class RSATest {

    public RSATest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // RSA 非对称加解密单元测试 开始
    @Test
    public void hello() throws DecoderException, Exception {
        RSAKey publicAndPrivateKeys = RSATool.genKeyPair();

        //私钥对象
        RSAPrivateKey privateKey = publicAndPrivateKeys.getPrivateKey();
        //私钥对象转变成二进制的秘钥数据
        //byte[] privateKeyData = privateKey.getEncoded();
        String privatekeys = "30820277020100300d06092a864886f70d0101010500048202613082025d02010002818100e30c0512d2a05f7681fe60267482499a319f9af0202f3bb8b0b81ca2d88f667220e9a69f61b378584c576354334fced21981a907f522682b9387b30bbdfa14f125c0eb7a33e60c994dd816d55253b8e5fa78b8677019162a7e9621289949aeea185db4c9a8c8e3031b2d7644208faed99a0cef6280210c1c98e7fe57b2ecc58f0203010001028180781f16dc1385779c2a405bbc5cadc5a507960a91fa6522f29ec4799a0a7b2bd73be4821c16c3adeb0150c6a3789643b4d27bcfe2fee55a399bcf128226db9591d4a00148debd3705df8908d2f4b997ba9fb81ffd2a7f5f09cd858df02d185540a5a0815cc2d6e65e7b00e2e5afb62ac74ba66e530cde8e27ea60f92773083751024100f610edf1b61ab89538f3fd8a792babfc5898a4337881bb21a97562b66ce72298cef9075d522ccf4a015cd7e15015af24e670b5481e1f8c6b429a73163df2d287024100ec368766de28f6eb70849da14f4517c5957b0c677457a2519362794812e11fd02d2895c9929db143ae97a853b7eda3ab874698954a678af0fbfbf65aaf26ceb9024100a5aa3238c90ce676f8d8343bf56674ad398cd308203adf9d4334d7d7d02c313bc6251d53340f1d244b1491f78cee7c73907e135ed181160de4d28d674d1fdda3024100bf996f751248fa187979287f1ad47976cc4c3600888f38dba08824c640821912fc3e4a5969b2bd819fd1e6389a1d893fee076666da2668be1637075a016ea20902404e8490e7898b4b465cfa114e7f69d680e7e6c1d5ea8525a3f2eaa5d2aad3ee0bf5725e1824b0a0464671161ae6e99696e55744ff453d5f6bf96851c7460c8a94";
        byte[] bb = Hex.decodeHex(privatekeys.toCharArray());
        //privatekeys = (new sun.misc.BASE64Encoder()).encode( privatekeys.getBytes() );
        //System.out.println(privatekeys);
        byte[] privateKeyData = bb;//privatekeys.getBytes();

        //公钥对象
        RSAPublicKey publicKey = publicAndPrivateKeys.getPublicKey();
        //公钥对象转变成二进制的秘钥数据
        //byte[] publicKeyData = publicKey.getEncoded();
        String publickeys = "30819f300d06092a864886f70d010101050003818d0030818902818100e30c0512d2a05f7681fe60267482499a319f9af0202f3bb8b0b81ca2d88f667220e9a69f61b378584c576354334fced21981a907f522682b9387b30bbdfa14f125c0eb7a33e60c994dd816d55253b8e5fa78b8677019162a7e9621289949aeea185db4c9a8c8e3031b2d7644208faed99a0cef6280210c1c98e7fe57b2ecc58f0203010001";

        byte[] aaa = Hex.decodeHex(publickeys.toCharArray());
        publickeys = Base64.encodeBase64String(publickeys.getBytes());
        System.out.println(publickeys);
        byte[] publicKeyData = aaa; //publickeys.getBytes();

        //String content = "我是待被加密的内容，I am the content.";
        String content = "dk2fg5gvdk2fg5gvF6D85F2H";
        System.out.println("待被加密的数据：" + content);

        //使用公钥进行加密
        byte[] enc_content_data = RSATool.encryptByPublicKey(content.getBytes(), publicKeyData);
        String enc_content = Hex.encodeHexString(enc_content_data);
        System.out.println("加密后的数据：" + enc_content);
        //byte[] enc_content_data = Hex.decodeHex("a09a73c477da152f1a200cee52e9f07b457e85239726bdf3be5dd369d61f200bc0d78dd1334fb826b5399130d8f73567bb5570555465562a3069b1ce3219368d7a8de97e21689dd574f39274a444ea3300a1b8a1c89310763c86cd22cab40f1b1ed33e917e5268f0e38f4474448c7a530edb1c7e456ef8b47c36567d89300677".toCharArray());
        //byte[] enc_content_data = Hex.decodeHex("286073b77e71a06920ea6c20e2dc483eb3d314a70b12e6ccab9701cf422673ca50e86339bc0c48c0e0c56e07a96bc4f87bcf26c963a65e7e290bea397bd6f9522b13572d00b48b1ac1d4559d1b680b7537af6a62298f64fe68d17ab896a312a24c3c31c5f744ca6cd97dbd3738e058142751df97c888e3f6ba1413d33f040ae0".toCharArray());

        //使用私钥进行解密
        byte[] content_data = RSATool.decryptByPrivateKey(enc_content_data, privateKeyData);
        String content2 = new String(content_data);
        System.out.println("解密后的数据：" + content2);
    }
}
