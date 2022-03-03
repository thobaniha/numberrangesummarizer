package numberrangesummarizer;
import java.util.*;

/**
 * @author Thobani
 * A class that implements NumberRangeSummarizer to summarize input string
 * String input is obtained from the user and it's separated by a comma 
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 *
 */

public class Numbers implements NumberRangeSummarizer {
   public Collection<Integer> collect(String input){
        String nums[] = input.split(",");
        Collection<Integer> nums1 = new ArrayList<>();
        for(String a: nums)
        nums1.add(Integer.parseInt(a));
        return nums1;
    }
   public String summarizeCollection(Collection<Integer> input){
        String st = "";
        ArrayList<Integer>elements = new ArrayList<>();
        elements.addAll(input);
        Stack<Integer> temp = new Stack<>(); 
        for(int i = 0;i < elements.size()-1;i++){
          if(elements.get(i+1) - elements.get(i) == 1){
              if(temp.empty())
                  temp.push(elements.get(i));
              continue;
          }
          else
            if(!temp.empty())
            st += temp.pop()+"-"+elements.get(i)+",";
            else
            st += elements.get(i)+",";
            
        }
        if(elements.get(elements.size()-1) - elements.get(elements.size()-2) == 1){
              if(temp.empty() && !st.contains(Integer.toString(elements.get(elements.size()-2))))
                  st += elements.get(elements.size()-2)+"-"+ elements.get(elements.size()-1);
                  
              if(st.contains(Integer.toString(elements.get(elements.size()-2))))
                 st.replace(Integer.toString(elements.get(elements.size()-2)),Integer.toString(elements.get(elements.size()-1)));
              
              if(!temp.empty())
                 st += temp.pop()+"-"+elements.get(elements.size()-1);   
                 } 
               else{
                   st += elements.get(elements.size()-1);
                   }
        
        return st;
    }
    
    public static void main(String[] args) {
        System.out.print("Enter the input string of integers separated by a comma: "); 
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        Numbers numbers = new Numbers();
        System.out.println("input: "+numbers.collect(input));
        System.out.println("Summarized input: "+numbers.summarizeCollection(numbers.collect(input)));        
    }
}

