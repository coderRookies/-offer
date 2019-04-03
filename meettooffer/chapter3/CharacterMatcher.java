package meettooffer.chapter3;

public class CharacterMatcher {
    public static void main(String[] args) {
        char[] strings = {'a','b', 'b'}, pattern = {'a','b'};
        boolean matched = match(strings, pattern);
        System.out.println(matched);
    }

    private static boolean match(char[] strings, char[] pattern) {
        if (strings == null || pattern == null) {
            return false;
        }
        return matchCore(strings, pattern, 0, 0);
    }
    // si means stringsindex to simulate point
    private static boolean matchCore(char[] strings, char[] pattern, int si, int pi) {
        if (strings.length == si && pattern.length == pi) {
            return true;
        }
        if (strings.length != si && pattern.length == pi) {
            return false;
        }
        if (pi + 1 < pattern.length && pattern[pi + 1] == '*' ) {
            if (strings[si] == pattern[pi] || (pattern[pi] == '.' && strings.length != si)) {
                return matchCore(strings, pattern, si + 1, pi + 2) || 
                        matchCore(strings, pattern, si + 1, pi) || 
                        matchCore(strings, pattern, si, pi + 2);
            }
            return matchCore(strings, pattern, si, pi + 2);
        }
        if (strings[si] == pattern[pi] || ((pattern[pi] == '.' && strings.length != si))) {
            return matchCore(strings, pattern, si + 1, pi + 1);
        }
        return false;
    }
    
}
