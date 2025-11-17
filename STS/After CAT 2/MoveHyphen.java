public class MoveHyphen {
    public static String moveHyphensToFront(String str){
    StringBuilder word = new StringBuilder();
    int hyphenCount = 0;

    // ONE PASS — traverse once
    for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);

        if(ch == '-') {
            hyphenCount++;    // count hyphens
        } else {
            word.append(ch);    // collect non-hyphens
        }
    }

    // Build final result
    StringBuilder result = new StringBuilder();

    for(int i=0; i<hyphenCount; i++){
        result.append('-');
    }

    result.append(word.toString());
    return result.toString();
}

    public static void main(String[] args) {
        String s = "I - love--Java";
        System.out.println(moveHyphensToFront(s));
    }
}
