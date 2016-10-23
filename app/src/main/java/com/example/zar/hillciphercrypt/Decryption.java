package com.example.zar.hillciphercrypt;

import java.util.ArrayList;

/**
 * Created by Zar on 10/22/2016.
 */
public class Decryption {

    private String cipherString,decryptedString;
    private char[] cipherChar;
    private int[] cipherInt;
    private int[][] inverseKey=new int[][]{{3,-3}, {-2,5}};
    private int[] cipherPair=new int[2];
    private int[] plainPair=new int[2];
    private ArrayList<Integer> plainList=new ArrayList<Integer>();

    public Decryption(String cipherString)
    {
        this.cipherString=cipherString;
    }

    public int[] cipherTextInt(String cipherString)
    {

        cipherChar=new char[cipherString.length()];
        cipherChar=cipherString.toCharArray();
        cipherInt=new int[cipherChar.length];
        for (int i=0; i<cipherInt.length; i++)
        {
            cipherInt[i]=(int)cipherChar[i]-97;
        }
        cipherPair[0]=cipherInt[0];
        cipherPair[1]=cipherInt[1];
        return cipherInt;

    }

    public String decryption()
    {
        cipherTextInt(cipherString);
        int count=0;
        do {
            for (int i=0; i<inverseKey.length; i++)
            {
                for (int j=0; j<cipherPair.length; j++)
                {
                    plainPair[i]=plainPair[i]+(inverseKey[i][j]*cipherPair[j]);
                }
                plainList.add(plainPair[i]);
                plainPair[i]=0;
            }

            if(count+2<cipherInt.length)
            {
                cipherPair[0]=cipherInt[count+2];
                cipherPair[1]=cipherInt[count+3];
            }
            count=count+2;
        }while (count!=cipherInt.length);

        for(int i=0; i<plainList.size(); i++)
        {
            if(plainList.get(i)<0)
            {

                cipherChar[i] = (char) ((26+(3*(plainList.get(i)) % 26)) + 97);
            }
            else {

                cipherChar[i] = (char) ((3*(plainList.get(i)) % 26) + 97);
            }
        }
        return decryptedString=new String(cipherChar);
    }
}
