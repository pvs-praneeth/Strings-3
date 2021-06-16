// Time Complexity : O(N)
//                   - Ideally we can say that time complexity is constant since the length of the number can reach upto trillion.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class IntegerToEnglishWord {
    String[] below20 = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = new String[]{"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] thousands = new String[]{"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        // Base case.
        if(num == 0) return "Zero";
        int index = 0;
        StringBuilder result = new StringBuilder();
        while(num > 0){
            // Breaking down the given number into triplet.
            int triplet = num % 1000;
            // If the triplet is equal to zero then we skip that triplet and its equivalent string representation.
            if(triplet != 0){
                // If the triplet is not equal to zero then we call the helper function to fetch the corresponding string representation.
                // Append the appropriate thousand notation to the triplet.
                result.insert(0, thousands[index]).insert(0, helper(triplet));
            }
            // Increment the thousand's representation index and remove the corresponding triplet from the number.
            index++;
            num = num/1000;
        }
        // Finally trim the string to handle the additional space that is added at the end of the string.
        return result.toString().trim();
    }
    
    // Function to convert the triplet(3 digit number) into string representation.
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return below20[num];
        else if(num < 100) return tens[num/10] + helper(num%10);
        else return below20[num/100] + "Hundred " + helper(num%100); 
    }
}
