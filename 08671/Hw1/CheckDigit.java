/**
 * CheckDigit:
 *
 * This class is designed for check 12-digit UPC numbers.
 * It includes two helper functions - calculateLastDigit
 * and getNthDigit.
 *
 * @author Jiaming Xiao     AndrewID: jiamingx
 */
public class CheckDigit {
    /**
     * Print out first 11 digits and the last digit.
     * @param args Commandline arguments
     */
    public static void main(String[] args) {
        long firstElevenDigits = Long.parseLong(args[0]);
        System.out.println(args[0]);
        System.out.println(calculateLastDigit(firstElevenDigits));
    }
    /**
     * Calculate the last digit of UPC number.
     * @param previousDigits the first 11 digits
     * @return the 12th digit
     */
    private static long calculateLastDigit(long previousDigits) {
        int i = 0;
        long sum = 0;
        while (i < 11) {
            if (i % 2 == 0) {
               sum += 3 * getNthDigit(previousDigits, i);
            } else {
                sum += getNthDigit(previousDigits, i);
            }
            i++;
        }
        return (10 - sum % 10) % 10;
    }
    /**
     * Get the nth digit from the first 11 digits.
     * @param digits the first 11 digits
     * @param n the index of digit
     * @return the nth digit
     */
    private static long getNthDigit(long digits, int n) {
        while (n < 10) {
            digits = digits / 10;
            n++;
        }
        return digits % 10;
    }
}
