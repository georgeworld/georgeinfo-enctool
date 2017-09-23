/*
 * A George software product.
 * Copyright (C) George (http://www.georgeinfo.com), All Rights Reserved..
 */
package test;

import com.georgeinfo.enctool.util.DESedeTool;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DES加解密单元测试
 *
 * @author George <Georgeinfo@163.com>
 */
public class DESTest {

    public DESTest() {
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

    // DES对称加解密 开始
    @Test
    public void doDes() throws DecoderException, Exception {
        //3DES秘钥内容
        String keyString = "7m3TbPsZnaBxeQu5BHagwDQn";
        //String keyString = "4746714359586a41564b483851345749696d45444e4f7967";
        //等待被加密的数据
        String content = "{\"account\":[{\"payeeAccount\":\"600373612\",\"money\":\"1.1\"},{\"payeeAccount\":\"0200209409000052367\",\"money\":\"2.1\"}]}";
        //String content = "[{\"accountId\":\"4\",\"payeeAccount\":\"111111111112\",\"money\":\"30\"},{\"accountId\":\"1\",\"payeeAccount\":\"11111111111\",\"money\":\"20\"}]";
        //String content = "{'accountCode':'18519192410','password':'26dace419e859af8c2bbfef39449b789'}";
        //String content = "{}";
        System.out.println("加密前的数据是：" + content);

        //获得3DES秘钥的二进制数据
        byte[] desKey = keyString.getBytes();
        //byte[] desKey = Hex.decodeHex("72614459527639386e4556774e3939623976755356455936".toCharArray());
        //使用DES秘钥，加密数据
        byte[] enc_content_data = DESedeTool.encrypt(content.getBytes("utf-8"), DESedeTool.convertKey(desKey), DESedeTool.ISO_CIPHER_ALGORITHM);
        char[] ca = Hex.encodeHex(enc_content_data);
        String enc_content = new String(ca);
        System.out.println("加密后的内容是：" + enc_content);
        //----------------------------------------------------------------------    3bd2e784cc7a7709b5378114fa0d6cd3
        //byte[] enc_content_data = Hex.decodeHex("b38ad5fe93f143a5ed7d79e0a2fc74d98b4c9c73f4d03639978ff08a5440969aa549dba195b25e6e9cecf867f73bf72ed5191331cef1b2971f58132ae470aa980b51c4b29fd2179e0e2d97e457d05bb570e0c9c9b8444c2e4725d22089788bb318239150d2014f25dc28ebad20dedcddc9083325dc6dff269e864dc8d54536d45b7642f7fc067f1942f4ef7b4688afaa8eb1185c4db83120eed27c6c133aae4984b7f52b00e8b0b5a14cbbe786d5847f5276b730cbd2ebb0ebec697d1a2d99d9".toCharArray());
        //byte[] enc_content_data = "cH66/5CeGe70SWcaUsCUe3hazVDjiKYm".getBytes();
        //5e87589744632324f756e41d0dcaf7d6369c4375d3358571fd3f0b88eeeadd9840783acc046a85c0c3e7fb8fc6fa30c29aef3a89691e4d38d5671ef4261f0dfd2a6f31620d0cd8c8c1b845d47e4a733fcb474dda82bfcbe5b4ee1e852b908ac7e2f53258a30630712c0dcaff44aeb4ac2ca6cc874307614af9c768aeb60cecb2c5eda0b4d795991d8d5949b1bd3c08583f8331fd49be1f8fd831b639dc782183c83916e0dcf359f15e1a738eae75a606558237bb005cbb8fe1d791ae1525fc77ddc402b7993f19cb3d4746cd9bffca0bd743e75c0b2d6b74e0e4af3a5f51563f84480cca905f74146c4eedb10c6955d35617edaa137aa6139e53825d101413e400937d8bfacde76965147e2251f02885d6aac230f5848733dc5c12371b77d9086fa7c98c0a95f60fccc16eaabce10fe1adaa03a7d34f63243133e3cbd0014cdb337475a6bcbb3b5bfe9f6c416b242c621116cf7bf5e54f6bac7668f00fe9eadd84e41f7b45d8f1f3a126e1edb684695624981595431bcfed0d3fa64d2813907e1c48fb78631366c6d5671ef4261f0dfdb419df6889e37b3e20be002d9c7b505a3c949752ec7c51effbd557795a1b4b02a546660de44d0f40b13c3ad51a0dcdcfb3d8789f1f44a9b82562244fbd3a50e80f2c8f1606c4abf6f6664391dc6416d1b3d8789f1f44a9b890ebff45e717accca3d0fdf3553f2fe8918fa87375f78d38e0f2c9903a277d8d8bf973fbd3d4c0c8c324044b4d1d33f4d2cb431f3d9ea48780994122c3adaa0ee1e1247b7d545e315deea9b7f6227f05f1a77ec8e94746bb9acb1b95ee53684d42d98299e9eb9cf2210e89807621349975422ab3e0704289e457fda6b5f757096a366d0ce5f6562b1c7f9346d0dceccb85ed919b37b907afaf586deaffbbdf7768730e155dd10b023affea8fb79e50b66dd6b361d6898b8beb93fce506f79352b502ed37613712b3f8a309ad2f222279b878b89ae221cb334f504e33591a4ffc0186e0950c4408b6a9a1e7a0cfc28679115514fa5dac0ca16c4eedb10c6955d35617edaa137aa613af7dd724b65147e600937d8bfacde76965147e2251f02885d6aac230f5848733f3bae3871f4a8ddf6fa7c98c0a95f60fccc16eaabce10fe1adaa03a7d34f63243133e3cbd0014cdb337475a6bcbb3b5bfe9f6c416b242c621116cf7bf5e54f6bac7668f00fe9eadd84e41f7b45d8f1f3a126e1edb684695624981595431bcfed881ae89ea86a84231c48fb78631366c6d5671ef4261f0dfdb419df6889e37b3e20be002d9c7b505a3c949752ec7c51effbd557795a1b4b02a546660de44d0f40b13c3ad51a0dcdcfb3d8789f1f44a9b82562244fbd3a50e841ac810713091814f6664391dc6416d1b3d8789f1f44a9b890ebff45e717acccbff924e1f195b8be918fa87375f78d38e0f2c9903a277d8d8bf973fbd3d4c0c8c324044b4d1d33f4d2cb431f3d9ea48780994122c3adaa0ee1e1247b7d545e315deea9b7f6227f05f1a77ec8e94746bb703f84770feb7e4042d98299e9eb9cf2210e89807621349975422ab3e0704289e457fda6b5f757096a366d0ce5f6562b1c7f9346d0dceccb85ed919b37b907afaf586deaffbbdf7768730e155dd10b023affea8fb79e50b68023b0f15309cbf3eb93fce506f79352b502ed37613712b3f8a309ad2f2222798726af7e932dbe3b4f504e33591a4ffc53ee23a1d3ede1ed3bf40c149ac6522646a70b7142b92661daed5bb34098c2f8369c4375d3358571fd3f0b88eeeadd981c48fb78631366c66640519d66575affb6553a9f9097faafdac0df47b55d6a17fd986931c4ec6b2ae32e4f63b2e109b918106c098d8d10e87b8c3013b8834c51ddbf602e94651b1832ceeb04d0e4f18d4591246ba06e31cca0e58284b52605af88d95ba19836af695775caca1aabf7d2d6aac230f5848733d03d50f2293170c4fff60b520ba3d2ad5deea9b7f6227f057418094fd6fd8e0cb005f05ad6cf6bed80fc65eb3b923bab0b54d43a2e40be78f941497c2ff702ca7e50f78e6b44a1bf518b23592c03b8852e4d71cb391af7a98637fa3b2cde1ec2572898a7c7a29a8f518b23592c03b8855e8cf094c0ec344e28e5f2130b8fd80b89ec9a1b7b40059aadb34692a0cd04b631ca16a8c14e2b48451f4670cb1f4a7a2fa06c6e87b9bd2f477429afc394f2ad5dac27841ab86e6616cd871dd18300738f906051dd3700da31404da6b33211ac6565f13cb1d960c3305303f6c54a333a3c949752ec7c51efc4fa5fdb88e071b65604c1f15316d6fac37ef98737d85186c987a7e77c74621be9e350c2fc93ed9dd16148d1507af11352a9a423ea5f7841d1b4bfac574e6b4599d8d197c8af2cb9373e9b9cd7d25c6aa17afc15f4b23f8442b102ee9b6d1b2831d64ff7d9f5f6230299fede6809a0d650288d2f1ecc220946a70b7142b92661daed5bb34098c2f8369c4375d33585712d3738baab77ee591c48fb78631366c66640519d66575affb6553a9f9097faafbe0673e0e1a03f57fd986931c4ec6b2ae32e4f63b2e109b918106c098d8d10e87b8c3013b8834c51ddbf602e94651b1832ceeb04d0e4f18d4591246ba06e31cca0e58284b52605af88d95ba19836af695775caca1aabf7d2d6aac230f58487339e33759b285bf5fbfff60b520ba3d2ad5deea9b7f6227f057418094fd6fd8e0cb005f05ad6cf6bed80fc65eb3b923bab0b54d43a2e40be78f941497c2ff702ca7e50f78e6b44a1bf518b23592c03b8852e4d71cb391af7a96afe7db00015fbd5572898a7c7a29a8f518b23592c03b8855e8cf094c0ec344e3afdb1430df9fae0a419eac8379d1e003046c888c9a465016d6a15e0133934cbec5fd2ac868a555a0f792953530d32a7c27cfbd18a53212741fdca3d6333ccd021b5ab7b06e2ff58cb744a1e3bf728b46b41b14f2a7567a251ac97f117fb4a6a
        //解密
        byte[] content_data = DESedeTool.decrypt(enc_content_data, DESedeTool.convertKey(desKey), DESedeTool.ISO_CIPHER_ALGORITHM);
        String content2 = new String(content_data);
        System.out.println("解密后的内容是：" + content2);

        /*String str="p~��悶铘IgR罃{xZ蚉銏�&";
        try {
            byte[] temp=str.getBytes("gb2312");//这里写原编码方式
            String newStr=new String(temp,"utf-8");//这里写转换后的编码方式
            System.out.println(newStr);
            System.out.println(new String("p~��悶铘IgR罃{xZ蚉銏�&".getBytes("gb2312"),"utf-8"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        String str = "30333031303030302020203439303030303030202020";
        byte[] ba = Hex.decodeHex(str.toCharArray());
        System.out.println(new String(ba, "gbk"));
    }
}
