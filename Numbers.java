package numberrangesummarizer;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Thobani
 * A class that implements NumberRangeSummarizer to summarize input string
 * String input is obtained from the user and it's separated by a comma 
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 *
 */
 public class Numbers{ 
 
   NumberRangeSummarizer numbers = new NumberRangeSummarizer(){
   
   public Collection<Integer> collect(String input){
      String numbers[] = input.split(",");
      return Arrays.stream(numbers)
             .map(Integer::parseInt)
             .collect(Collectors.toList());          
   }
   
   public String summarizeCollection(Collection<Integer> input){
        String st = "";
        ArrayList<Integer>elements = input.stream()
                                          .collect(Collectors.toCollection(ArrayList::new));
        Stack<Integer> temp = new Stack<>(); 
        for(int i = 0;i < elements.size();i++){
            try {
               if(elements.get(i+1) - elements.get(i) == 1){
                  if(temp.empty())
                     temp.push(elements.get(i));
                  continue;
               }
            }catch(Exception e) {}
            if(!temp.empty())
               st += temp.pop()+"-"+elements.get(i)+",";
            else
               st += elements.get(i)+",";   
        }
        return st.substring(0,st.length()-1);
        }

   };
    
   public static void main(String[] args) {
        System.out.print("Enter the input string of integers separated by a comma: "); 
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        Numbers numbers = new Numbers();
        Collection<Integer> numbersCollected = numbers.numbers.collect(input);
        System.out.println("input: "+numbersCollected);
        String summarized = numbers.numbers.summarizeCollection(numbersCollected);
        System.out.println(" summarized results: "+summarized);       
   }
}
