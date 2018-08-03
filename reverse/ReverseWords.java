package reverse;

class ReverseWords {
    public static void reverseWords(char[] str) {
        reverse(0, str.length - 1, str);
        int start = 0;
        int end = 0;
        while(end <= str.length){
        		if(end == str.length) {
        			reverse(start, end -1, str);
        			break;
        		}
            if(str[end] == ' '){
                reverse(start, end -1, str);
                start = end + 1;
            }
            end ++;
        }
        System.out.println("done");
    }
    public static void reverse(int start, int end, char[] str){
        while(start < end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start ++;
            end --;
        }
    }
    
    public static void main(String args[]) {
    		// reverseWords(new char[] {' ', 't','h', 'e', ' ', 's','k', 'y',' ','i','s',' ','b','l','u','e'});
    		reverseWords(new char[] {'t', ' ', 'b', ' ', 'a'});
    }
}