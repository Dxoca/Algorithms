package cf;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package learning;

/**
 *
 * @author sokumar
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Tamp
{



    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;

        public InputReader(InputStream st) {
            this.stream = st;
        }

        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int ni() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nl() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nia(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public String rs() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }





    static long mod=1000000007;
    static BigInteger bigInteger = new BigInteger("1000000007");
    static int n = (int)1e6;
    static boolean[] prime;
    static ArrayList<Integer> as;
    static ArrayList<Integer> []as1;
    static void sieve() {
        Arrays.fill(prime	, true);
        prime[0] = prime[1] = false;
        for(int i = 2 ; i * i <= n ; ++i) {
            if(prime[i]) {
                for(int k = i * i; k< n ; k+=i) {
                    prime[k] = false;
                }
            }
        }

    }
    static PrintWriter w = new PrintWriter(System.out);
    static int p = 0;
    static char [][]sol;
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    public static void main(String[] args)
    {

        InputReader sc = new InputReader(System.in);
        //PrintWriter w = new PrintWriter(System.out);


        prime  = new boolean[n + 1];
        sieve();
        prime[1] = false;
        int x = sc.ni();
        long []a = new long[x];
        for(int i=0;i<x;i++)
        {
            a[i] = sc.nl();
        }
        long g = 0;
        if(x==1)
        {
            g = a[0];

        }
        else
        {
            g = gcd(a[0],a[1]);
            for(int i=2;i<x;i++)
            {
                g = gcd(g,a[i]);

            }
        }
        long res = 0;
        for(long i=1;i*i<=g;i++)
        {
            if(g%i==0 && g/i != i)
                res += 2;
            else if(g%i==0 && g/i==i)
                res += 1;
        }
        w.println(res);



       /*

	long a = sc.nl();

            BigInteger ans = new BigInteger("1");
            for (long i = 1; i < Math.sqrt(a); i++) {
                if (a % i == 0) {
                    if (a / i == i) {
                        ans = ans.multiply(BigInteger.valueOf(phi(i)));

                    } else {
                        ans = ans.multiply(BigInteger.valueOf(phi(i)));
                        ans = ans.multiply(BigInteger.valueOf(phi(a / i)));


                    }



                }
            }
            w.println(ans.mod(bigInteger));
            */

        // MergeSort ob = new MergeSort();
        // ob.sort(arr, 0, arr.length-1);

        // Student []st = new Student[x];
        // st[i] = new Student(i,d[i]);
        //Arrays.sort(st,(p,q)->p.diff-q.diff);
//BigDecimal x = new BigDecimal(b[i]).multiply(new BigDecimal("-1")).divide(new BigDecimal(a[i]),100,RoundingMode.HALF_UP);
        // PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new multipliers());

        w.close();



    }

    static int []a;
    static long a1,b;
    public static int searchlow(int x) {
        int lo=0, hi=a.length-1;
        int res=Integer.MIN_VALUE;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(a[mid]==x){
                res = mid;
                hi = mid - 1;
            }
            else if(a[mid]>x){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return res==Integer.MIN_VALUE?lo:res;
    }
    public static int searchhigh(int x) {
        int lo=0, hi=a.length-1;
        int res=Integer.MIN_VALUE;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(a[mid]==x){
                res = mid;
                lo=mid+1;
            }
            else if(a[mid]>x){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return res==Integer.MIN_VALUE?hi:res;
    }
    public static long ct(int l, int r) {
        int lo=searchlow(l), hi=searchhigh(r);
        return hi-lo+1;
    }
    static long log2(long value) {
        return Long.SIZE-Long.numberOfLeadingZeros(value);
    }

    static class Student
    {
        int id;
        //int x;

        int y;
        int z;

        Student(int id,int y,int z)
        {
            this.id = id;
            //this.x = x;
            //this.s = s;
            this.y = y;
            this.z = z;


        }

    }


    public static long modMultiply(long one, long two) {

        return (one % mod * two % mod) % mod;
    }
    static long fx(int m)
    {
        long re = 0;
        for(int i=1;i<=m;i++)
        {
            re += (long) (i / gcd(i,m));
        }
        return re;
    }
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }



    static long phi(long nx)
    {
        // Initialize result as n
        double result = nx;


        // Consider all prime factors of n and for
        // every prime factor p, multiply result
        // with (1 - 1/p)
        for (int p = 0; as.get(p) * as.get(p) <= nx; ++p)
        {
            // Check if p is a prime factor.
            if (nx % as.get(p) == 0)
            {
                // If yes, then update n and result
                while (nx % as.get(p) == 0)
                    nx /= as.get(p);
                result *= (1.0 - (1.0 / (double) as.get(p)));
            }
        }

        // If n has a prime factor greater than sqrt(n)
        // (There can be at-most one such prime factor)
        if (nx > 1)
            result *= (1.0 - (1.0 / (double) nx));

        return (long)result;


        //return(phi((long)result,k-1));

    }

    public static void primeFactors(int n,int x)
    {
        as = new ArrayList<>();

        // Print the number of 2s that divide n
        while (n%2==0)
        {


            as.add(2);
            //System.out.print(2 + " ");
            n /= 2;

        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {

                // System.out.print(i + " ");

                as.add(i);
                n /= i;


            }

        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n >= 2)
        {

            as.add(n);
        }

    }
    static int digitsum(int x)

    {

        int sum = 0;
        while(x > 0)
        {
            int temp = x % 10;
            sum += temp;
            x /= 10;
        }
        return sum;

    }
    static int countDivisors(int n)
    {
        int cnt = 0;
        for (int i = 1; i*i <=n; i++)
        {
            if (n % i == 0 && i<=1000000)
            {
                // If divisors are equal,
                // count only one
                if (n / i == i)
                    cnt++;

                else // Otherwise count both
                    cnt = cnt + 2;
            }
        }
        return cnt;
    }

    static boolean isprime(long n)
    {

        if(n == 2)
            return true;
        if(n == 3)
            return true;
        if(n % 2 == 0)
            return false;
        if(n % 3 == 0)
            return false;

        long i = 5;
        long w = 2;

        while(i * i <= n)
        {
            if(n % i == 0)
                return false;


            i += w;
            w = 6 - w;
        }

        return true;
    }






    static boolean binarysearch(int []arr,int p,int n)
    {
        //ArrayList<Integer> as = new ArrayList<>();
        //as.addAll(0,at);
        //Collections.sort(as);
        boolean re = false;
        int st = 0;
        int end = n-1;



        while(st <= end)
        {
            int mid = (st+end)/2;

            if(p > arr[mid])
            {
                st = mid+1;

            }
            else if(p < arr[mid])
            {
                end = mid-1;

            }
            else if(p == arr[mid])
            {

                re = true;
                break;
            }



        }
        return re;

    }



    /* Java program for Merge Sort */
    static class MergeSort
    {
        // Merges two subarrays of arr[].
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        void merge(int arr[], int l, int m, int r)
        {
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;

            /* Create temp arrays */
            int L[] = new int [n1];
            int R[] = new int [n2];

            /*Copy data to temp arrays*/
            for (int i=0; i<n1; ++i)
                L[i] = arr[l + i];
            for (int j=0; j<n2; ++j)
                R[j] = arr[m + 1+ j];


            /* Merge the temp arrays */

            // Initial indexes of first and second subarrays
            int i = 0, j = 0;

            // Initial index of merged subarry array
            int k = l;
            while (i < n1 && j < n2)
            {
                if (L[i] <= R[j])
                {
                    arr[k] = L[i];
                    i++;
                }
                else
                {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1)
            {
                arr[k] = L[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2)
            {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        // Main function that sorts arr[l..r] using
        // merge()
        void sort(int arr[], int l, int r)
        {
            if (l < r)
            {
                // Find the middle point
                int m = (l+r)/2;

                // Sort first and second halves
                sort(arr, l, m);
                sort(arr , m+1, r);

                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }

        /* A utility function to print array of size n */



    }





    public static int ip(String s){
        return Integer.parseInt(s);
    }
    public static String ips(int s){
        return Integer.toString(s);
    }

    // Java program to print all permutations using
// Heap's algorithm
    static class HeapAlgo
    {
        //static ArrayList<Integer> []ad;
        //Prints the array
        void printArr(int a[], int n)
        {


            for (int i=0; i<n; i++)
            {
                System.out.print(a[i] + " ");
                as1[p].add(a[i]);
            }
            p++;

            //System.out.println();
        }

        //Generating permutation using Heap Algorithm
        void heapPermutation(int a[], int size, int n)
        {
            // if size becomes 1 then prints the obtained
            // permutation

            if (size == 1)
            {
                printArr(a,n);

            }

            for (int i=0; i<size; i++)
            {
                heapPermutation(a, size-1, n);
                p++;

                // if size is odd, swap first and last
                // element
                if (size % 2 == 1)
                {
                    int temp = a[0];
                    a[0] = a[size-1];
                    a[size-1] = temp;
                }

                // If size is even, swap ith and last
                // element
                else
                {
                    int temp = a[i];
                    a[i] = a[size-1];
                    a[size-1] = temp;
                }
            }
        }
        public static int lowerBound(int[] array, int length, int value) {
            int low = 0;
            int high = length-1;
            while (low < high) {
                final int mid = (low + high) / 2;
                if (value <= array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
        public static int upperBound(int[] array, int length, int value) {
            int low = 0;
            int high = length-1;
            while (low < high) {
                final int mid = (low + high) / 2;
                if (value >= array[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        // Driver code



    }

// This code has been contributed by Amit Khandelwal.
// JAVA program for implementation of KMP pattern
// searching algorithm

    static class KMP_String_Matching {
        boolean KMPSearch(String pat, String txt)
        {
            int f = 0;
            int M = pat.length();
            int N = txt.length();

            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M];
            int j = 0; // index for pat[]

            // Preprocess the pattern (calculate lps[]
            // array)
            computeLPSArray(pat, M, lps);

            int i = 0; // index for txt[]
            while (i < N) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                            /*
				System.out.println("Found pattern "
								+ "at index " + (i - j));
                            */
                    f = 1;
                    // return true;
                    j = lps[j - 1];
                }

                // mismatch after j matches
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
            if(f==0)
                return false;
            else
                return true;
        }

        void computeLPSArray(String pat, int M, int lps[])
        {
            // length of the previous longest prefix suffix
            int len = 0;
            int i = 1;
            lps[0] = 0; // lps[0] is always 0

            // the loop calculates lps[i] for i = 1 to M-1
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                }
                else // (pat[i] != pat[len])
                {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar
                    // to search step.
                    if (len != 0) {
                        len = lps[len - 1];

                        // Also, note that we do not increment
                        // i here
                    }
                    else // if (len == 0)
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }

        // Driver program to test above function
        /*
	public static void main(String args[])
	{
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		new KMP_String_Matching().KMPSearch(pat, txt);
	}
        */
    }
    // This code has been contributed by Amit Khandelwal.
    static class multipliers implements Comparator<Integer>{

        public int compare(Integer a,Integer b) {
            if(a<b)
                return 1;
            else if(b<a)
                return -1;
            else
                return 0;
        }
    }

    static class multipliers1 implements Comparator<Student>{
        public int compare(Student a, Student b)
        {
            if(a.y < b.y)
                return -1;
            else if(a.y > b.y)
                return 1;
            else
            {
                if(a.z < b.z)
                    return -1;
                else
                    return 1;

            }
        }
    }
    static void checkCollision(int a, int b, int c,
                               int x, int y, int radius)
    {
        // Finding the distance of line from center.
        double dist = (Math.abs(a * x + b * y + c)) /
                Math.sqrt(a * a + b * b);

        // Checking if the distance is less than,
        // greater than or equal to radius.
        if (radius == dist)
        {
            double dis = (double)Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
            DecimalFormat df = new DecimalFormat("0.000000");
            w.println(df.format(dis));
            int p = 2/0;
            //System.out.println(df.format(364565.1454));
        }
        else if (radius > dist)
        {

            double x11 = (double)x1;
            double y11 = (double)y1;
            double x22 = (double)x2;
            double y22 = (double)y2;
            double up = 2*x11*y11/(((x11*x11) - ((double)radius*(double)radius)));
            up *= up;

            double denm = ((y11*y11) - ((double)radius*(double)radius))/((x11*x11) - ((double)radius*(double)radius));
            up -= (4*denm);
            up = Math.sqrt(up);
            double theta = 0.0;

            denm += 1.0;
            if(denm!=0.00000000)
                theta = Math.atan(up/denm);
            else
                theta = Math.PI/(double)2;
            //w.println(up);
            //w.println(denm);

            up = 2*x22*y22/(((x22*x22) - ((double)radius*(double)radius)));
            up *= up;
            denm = ((y22*y22) - ((double)radius*(double)radius))/((x22*x22) - ((double)radius*(double)radius));
            up -= (4*denm);
            up = Math.sqrt(up);
            denm += 1.0;
            double theta1 = 0.0;

            // denm += 1.0;
            if(denm!=0.00000000)
                theta1 = Math.atan(up/denm);
            else
                theta1 = Math.PI/(double)2;
            theta /= 2;
            theta1 /= 2;
            double re = theta +theta1;
            re = re * (double) radius;
            double eq1 = (x11*x11) + (y11*y11) - ((double)radius*(double)radius);
            double eq2 = (x22*x22) + (y22*y22) - ((double)radius*(double)radius);
            double t1 = Math.sqrt(eq1);
            double t2 = Math.sqrt(eq2);
            double res = re + t1 + t2;
            // w.println(theta1);
            //w.println(theta);


            DecimalFormat df = new DecimalFormat("0.000000");
            w.println(df.format(res));






        }
        else
        {
            double x11 = (double)x1;
            double y11 = (double)y1;
            double x22 = (double)x2;
            double y22 = (double)y2;
            if(Math.abs(x11) > Math.abs(x22))
            {
                double temp = x11;
                x11 = x22;
                x22 = temp;
                temp = y11;
                y11 = y22;
                y22 = temp;
            }
            double dis = (double)Math.sqrt(((x11-0.0)*(x11-0.0)) + ((y11-0.0)*(y11-0.0)));
            dis -= (double) radius;
            double m = (y22-y11)/(x22-x11);
            double r = (double)radius*(double)radius;
            double px = Math.sqrt(r/(1+(m*m)));
            double tx = (-1.0)*px;
            double py = m*px;
            double ty = m*tx;
            double dis1 = (double)Math.sqrt(((x22-px)*(x22-px)) + ((y22-py)*(y22-py)));
            double dis2 = (double)Math.sqrt(((x22-tx)*(x22-tx)) + ((y22-ty)*(y22-ty)));
            double min = Math.min(dis1,dis2);
            double res = dis+min;

            DecimalFormat df = new DecimalFormat("0.000000");

            w.println(df.format(res));


        }
    }

}