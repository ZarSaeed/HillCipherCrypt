package com.example.zar.hillciphercrypt;

import java.util.ArrayList;

/**
 * Created by Zar on 10/22/2016.
 */
public class Encryption {

    private String plaintext,encryptedString;
    private  int[][] keyMatrix=new int[][]{{5,3},{2,3}};
    private  int[] plainTextInt,keyTextInt;
    private  char[] plainTextChar;
    private  int[] cipherPair=new int[2];
    private  int[] plainPair=new int[2];
    private ArrayList<Integer> cipherList=new ArrayList<Integer>();

    public  Encryption()
    {
        super();
    }
    public Encryption(String plaintext)
    {
        this.plaintext=plaintext;
    }


    public int[] plainTextInt(String plaintext)
    {

        plainTextChar=new char[plaintext.length()];
        plainTextChar=plaintext.toCharArray();
        plainTextInt=new int[plainTextChar.length];
        for (int i=0; i<plainTextInt.length; i++)
        {
            plainTextInt[i]=(int)plainTextChar[i]-97;
        }
        plainPair[0]=plainTextInt[0];
        plainPair[1]=plainTextInt[1];
        return plainTextInt;

    }


    public String encryption()
    {
        plainTextInt(plaintext);
        int count=0;
        do {
            for (int i=0; i<keyMatrix.length; i++)
            {
                for (int j=0; j<plainPair.length; j++)
                {
                    cipherPair[i]=cipherPair[i]+(keyMatrix[i][j]*plainPair[j]);
                }
                cipherList.add(cipherPair[i]);
                cipherPair[i]=0;
            }

            if(count+2<plainTextInt.length)
            {
                plainPair[0]=plainTextInt[count+2];
                plainPair[1]=plainTextInt[count+3];
            }
            count=count+2;
        }while (count!=plainTextInt.length);

        for(int i=0; i<cipherList.size(); i++)
        {
            plainTextChar[i]=(char)((cipherList.get(i)%26)+97);
        }
        return encryptedString=new String(plainTextChar);
    }
}
