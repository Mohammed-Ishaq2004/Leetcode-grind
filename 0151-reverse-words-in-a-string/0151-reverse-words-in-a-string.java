class Solution {
    public String reverseWords(String s) {

      StringBuilder sb= new StringBuilder();
      char[] arr=s.toCharArray();

      int end=-1;

      for(int ch=arr.length-1 ; ch>=0 ; ch--){
        //skip spaces
        if(arr[ch]==' ') {
            continue;
        }
        end = ch;//if we encounter a char which is not a space

        // move left until we find the start of the word use a while loop
        while(ch>=0 && arr[ch] != ' '){
            ch--;
        }
        int start=ch+1; 

        sb.append(s.substring(start, end + 1));
        sb.append(' ');

        end=-1;
        
      }  
      return sb.toString().trim();
    }
}