package com.company.DynamicProgramming;

import java.util.Arrays;

public class DistinctOccurrences {
    /*Given two strings S and T of length n and m respectively.
     find count of distinct occurrences of T in S as a sub-sequence.
     Input:
     S = "banana" , T = "ban"
     Output: 3
     Explanation: There are 3 sub-sequences:
     [ban], [ba n], [b an].
    */
    public static void main(String[] args){
        subsequenceCount("qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmqdcyzjeeuhmsrqcozijipfioneeddpszrnavymmtatbdzqsoemuvnpppsuacbazuxmhecthlegrpunkdmbppweqtgjoparmowzdqyoxytjbbhawdydcprjbxphoohpkwqyuhrqzhnbnfuvqnqqlrzjpxiogvliexdzuzosrkrusvojbrzmwzpowkjilefraamdigpnpuuhgxpqnjwjmwaxxmnsnhhlqqrzudltfzotcjtnzxuglsdsmzcnockvfajfrmxothowkbjzwucwljfrimpmyhchzriwkbarxbgfcbceyhjugixwtbvtrehbbcpxifbxvfbcgkcfqckcotzgkubmjrmbsztsshfroefwsjrxjhguzyupzwweiqurpixiqflduuveoowqcudhnefnjhaimuczfskuiduburiswtbrecuykabfcvkdzeztoidukuhjzefczzzbfkqdpqzikfobucdhthxdjgkjelrlpaxamceroswitdptpcclifkeljytihrcqaybnefxnxvgzedyyhngycdrudmphmeckotrwospofghfozqvlqfxwwkmfxdyygmdcaszsgovsodkjghcwmbmxrmhuyfyqgajqkcklznayxqkqoyzwmyubzazcpkhktkydzivcuypurfmbisgekyrgzvxdhpoamvafyrarxsvkhtqdihersigbhzjzujxmmyspnaraewkegjccvhhrjvbjtsqdjootgpknfpfycgfieowqrwwwpzsqmetogepspxnvjiupalyynmkmnuvklhsecdwracgfmzkgipdfodkjmjqwiqpuoqhimvfvuzwyvijgfullkjduhsjafbtlkmfqrmyjfjnhhssqctydteamdcjbprhtnegyiwxgcjwlgrsmeaearwtvjsjbaoiojlwhypnvruihoswkifygtydhacwyhsgewzmtgonzltjhgauhnihreqgjfwkjsmtpjhaefqzaauldrchjccdyrfvvrivuyeegfivdrcygurqdredakubnfguproqylobcwqxkzmausjgmhcmhgdnmphnqkamhurktrffaclvgrzkkldacllteojomonxrqyjzginrnnzwacxxaedrwudxzrfusewjtboxvynfhkstcenaumnddxfdmvzcautdcckxaaydzsxttobbgqngvvpjgojoglmkxgbfcpypckqchbddzwrxbzmqrlxvobtwhxginfgfrcclmznmjugwwbsqfcihubsjollmsqsghmcphelsotflbgsfnpcuzsrupchynvzhcpqugriwniqxdfjpwpxfblkpnpeelfjmtkuqpzomwnlmbupmktlptndmpdsydsgvfpenemwborifsuqhceskmkhssmvnonwafxwhgbibabvqopqfoviussqfqwehtxdzujtlntxmrjxxwtlggkytbiolydnilqadojskkvfxahhjmbocljarintdwcldvdxropbyjzwyyojuothwmlvrglfzdzdbtubxuoffvncrswsaznmoijoivvgobqpnckwvnhkebmtdhvygkjisuxhatmuudqbhmknhfxaxqxkjlzzqtsjfaeedfuujkolxjoqkdvfepvlhvhrwtfdukxffjpsswyxlijjhevryxozbafpfmowgrgonuatdqlahyggyljddjhmltedzlodsrkeutgtnkntarjkpxinovgzdthunwooxvjjmpsvknhkwjopmmlebksucvzqlyqnwcmbvbhrmlowpjbwyvwtgtoqnmicxapzarknnxtuufarzrosdqwsmtcjghecqudosrtjxyaaykqrxycrxuwjxnpqjnbkcpdmokalxapemvbqlzsvxzkutappwgzpdpyzkzcvbntcvfxsxpjaoxtfhvxxytgokrcxaetauqgndmphwzyiayabjrqgeppxyjsttyzuvldvybsuxkbmfzvrtnovidznpghozvafmsnsnqivmvubcwtfsrqtmknepbhowejazhkwcmmtpixxxlzqysxtwwtaidyaxyqleprxibexxyfvsddygthcuyyfwpjsfybglgzmbintattnhodtonpyzwotkgnguphpkxeatowzabsdnvqhkfcmofisfrfqgvpmvorpjfzslzmpjjnehrykxjzubuacclfkcyzobghtuoxrajvprecwgxxpswcgmmvedewdmfnqwcuqdsciliqecihluilgmfcswtwkkxlcbhqkvcswjebkrjlpgfgratzbsguvzifnhyxwjsjavwauxpannamxjdvzuhnaczyhepwzolhuslrkvwpnvgzmiizwudwdfzlktbqdxgyyiudsjvezkmesbjlkyertahnexhuqmjicbmusqdklasolwjxptxxeumzfwyucpabqseffunqpkfnnbecbbcjpdyjlibitllplxelrdkexdtquvptteyhtlqlbbbvoqozkynayyrbaqmyjhzxndsiyfsexwbioewqvqrtcdlpqmvjifvgymkgotzjmnzqtmrpndevnmthjitsspaqnjrdoyjwpyatmleyqsvkpamsvbmvxrllivfedkjigavyxjveqvrbacuigaipyhbbxipbzncwhrblirizxoqptqqweaafjeqiozpyfauuqmvhxkmnxmsyamptlzanotlslwuhtfqjrrwbwhmqhzkhdkcrfvbeiyipvfvpzhyujabtqwwtbkdogkemhibyxrnxsxrzletbqexkrqoiernaplqyjpqoubvjsebalwnksvloidzfpirwycztwzzvewxotakudkpedupkczlhwuskdnevdcplbklpjmpfdcyqtrcvvvtrffvpekkqmcupryjauteuvczvicthrxsxclprgdlwxfaigayrueicufdiamhtkbxotdirxxgvzqmeyrovfichqnivfjzauqfdftgmopsrgpugxtuhlcvspihazrssfszwxbqm",
                "rwmxcdbhumrgjqmvnkyrtn");
    }

    static int answer;
    static int[][] dp;
    
    static int subsequenceCount(String S, String T)
    {
        dp=new int[9000][300];
        for(int[] each: dp){
            Arrays.fill(each,-1);
        }
        int x=compute(S, T, 0, 0);
        return x;
    }
    
    static int compute(String s,String t,int ptr1,int ptr2){
        if(dp[ptr1][ptr2]!=-1){
            return dp[ptr1][ptr2];
        }
        if(ptr2>=t.length()){
            return 1;
        }
        else if(ptr1>=s.length() && ptr2<t.length()){
            return 0;
        }
        int sum=0;
        sum=(sum+compute(s,t,ptr1+1,ptr2) )%1000000007;
        dp[ptr1][ptr2]=sum;
        if(s.charAt(ptr1)==t.charAt(ptr2)){
            sum=(sum+compute(s,t,ptr1+1,ptr2+1) )%1000000007;
        }
        dp[ptr1][ptr2]=sum;
        return sum;
    }

}
