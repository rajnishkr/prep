package ctci;

public class StringEncode {

    public static void main(String[] args) {
        String input="Mr John Smith    ";
        int lenght=13;
        char []arr= input.toCharArray();
        //TODO validate if solution possible
        encoder(arr,input.length());
        System.out.println(new String(arr));
    }

    private static void encoder(char[] arr, int length) {

        int itr=length-1;
        while(arr[itr--]==' '){}
        int replacementItr=length-1;
        for(int i= itr+1;i>=0;i--){
            System.out.println(arr);
            if(arr[i]!=' '){
                arr[replacementItr]=arr[i];
                replacementItr--;
            }else{
                arr[replacementItr--]='0';
                arr[replacementItr--]='2';
                arr[replacementItr--]='%';
            }
        }
        return;
    }
}
