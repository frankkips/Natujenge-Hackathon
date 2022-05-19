package com.frankkips;

public class Main {

    public static void main(String[] args) {
	byte[] bytes = new byte[]{0x13, 0x55, (byte)0xb6, 0x76,
            0x79, (byte)0x88, 0x29, 0x5e,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x03, 0x00, 0x34,//here
            0x7e, 0x58, 0x1e, 0x36,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00};
// Source Port
        int source = 0;
        source |= (bytes[0]& 0xff) << 8;
        source|= (bytes[1] & 0xff);
        System.out.println("source port "+ source);

//        Destination port
        int dest = 0;
        dest |= (bytes[2]& 0xff) << 8;
        dest|= (bytes[3] & 0xff);
        System.out.println("Destination port "+ dest);


//        Verification Tag
//        0x79, 0x88, 0x29, 0x5e
        int verificate = 0;
        verificate |= (bytes[4]& 0xff) << 32;
        verificate |= (bytes[5]& 0xff) << 16;
        verificate |= (bytes[6]& 0xff) << 8;
        verificate|= (bytes[7] & 0xff);
        System.out.println("verificate  "+ verificate);


//        Type
        int type = bytes[12];
        System.out.println("type: " + type);

//        B flag
//        0x03 0000 0011 0000 0010
        boolean flag = (bytes[14] & 0b000000010) > 0;
        System.out.println("B flag " + flag);





//        length
//        0x00, 0x34
        int length = 0;
        length |= (bytes[14]& 0xff) << 8;
        length|= (bytes[15] & 0xff);
        System.out.println("length "+ length);





    }
}
