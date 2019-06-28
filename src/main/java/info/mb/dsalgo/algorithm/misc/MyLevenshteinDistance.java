package info.mb.dsalgo.algorithm.misc;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * @author mukulbansal
 */
public class MyLevenshteinDistance {

    int[][] memo;
    int sourceLength;
    int destinationLength;

    public MyLevenshteinDistance(String source, String destination){
        this.memo = new int[source.length()+1][destination.length()+1];
        for(int i=0;i<=source.length();i++){
            for(int j=0;j<=destination.length();j++){
                memo[i][j]=Integer.MAX_VALUE;
            }
        }
        this.sourceLength = source.length();
        this.destinationLength=destination.length();
    }

    public static void main(String... s){
        String source = "Test";
        String destination = "Best";
        int distance = new MyLevenshteinDistance(source,destination).getLevenshteinDistance(source, destination);

        System.out.println(String.format("Levenshtein distance between %s and %s is- %d", source, destination, distance));
    }

    public int getLevenshteinDistance(String source, String destination) {
        if (null == source || source.length() == 0) {
            return null == destination ? 0 : destination.length();
        }

        if (null == destination || destination.length() == 0) {
            return source.length();
        }

        if(memo[source.length()][destination.length()] != Integer.MAX_VALUE){
            return memo[source.length()][destination.length()];
        }

        int costOfSubstitution = getLevenshteinDistance(source.substring(1), destination.substring(1)) + costOfSubstitution(source.charAt(0), destination.charAt(0));
        int costOfInsertion = getLevenshteinDistance(source, destination.substring(1)) + 1;
        int costOfDeletion = getLevenshteinDistance(source.substring(1), destination) + 1;

        int min = min(costOfSubstitution, costOfInsertion, costOfDeletion);

        memo[source.length()][destination.length()] = min;

        return min;
    }

    public int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
