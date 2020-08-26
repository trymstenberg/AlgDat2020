package UkesOppgaver;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    private Tabell() {}
    public static void main(String ... args){
        /*    int[] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        int[] a = Tabell.randPerm(20);
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);
        skriv(a);
        skriv(a, 2, 4);

        System.out.println(maks(a, 2, 2));

        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skriv(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("\nStørst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);*/

        int[] a = randPerm(20);
        skriv(a);
        System.out.println("\n");
        nestMaks(a);
        //sortering(a);

        //skriv(a);
    }


    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n){
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a){
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    static int maks(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);

        int max = a[fra];
        for(int i = fra; i<til; i++){
            if(a[i]<max){
                max=i;
            }
        }
        return max;
    }

    static int maks(int[] a){
        int max = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i]>a[max]){
                max = i;
            }
        }
        return max;
    }

    static int min(int[] a){
        int min = 0;
        for(int i = 0; i < a.length; i++){
            if (a[i]<a[min]){
                min = i;
            }
        }
        return min;
    }

    static int min (int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        int min = a[fra];
        for(int i = fra; i<til; i++){
            if(a[i]>min){
                min=i;
            }
        }
        return min;
    }

    public static int[] minmaks(int[] a){
        int m1 = min(a);
        int m2 = maks(a);

        return new int[]{m1, m2};
    }

    static void skriv(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        for(int i=fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void skriv(int[] a){
        for(int b:a){
            System.out.print(b + " ");
        }
    }

    static void skrivln(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        for(int i=fra; i < til; i++) {
            System.out.println(a[i] + " ");
        }
    }

    static void skrivln(int[] a){
        for(int b:a){
            System.out.println(b + " ");
        }
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        if (tablengde == 0)
            throw new NullPointerException
                    ("lengden på tabellen er Null + " + tablengde);
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static void nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else
        {
            bytt(a, 0, m);
        }
        skriv(a);
    } // nestMaks

    public static void sortering(int[] a){

        for(int i=0; i+1 < a.length; i++){
            //if(i==19){
            int n = a.length-1-i;

            bytt(a, maks(a, 0, n), n);
        }
        skriv(a);
    }
}
