

/**
* Created by Yang on 1/23/20.
*/
public class StringArrayUtils {
/**
* @param array array of String objects
* @return first element of specified array
*/ // TODO
public static String getFirstElement(String[] array) {
if (array == null || array.length == 0) {
return null;
}
return array[0];
}

/**
* @param array array of String objects
* @return second element in specified array
*/
public static String getSecondElement(String[] array) {
if (array == null || array.length == 0) {
return null;
}
return array[1];
}

/**
* @param array array of String objects
* @return last element in specified array
*/ // TODO
public static String getLastElement(String[] array) {
if (array == null || array.length == 0) {
return null;
}
return array[array.length - 1];
}

/**
* @param array array of String objects
* @return second to last element in specified array
*/ // TODO
public static String getSecondToLastElement(String[] array) {
if (array == null || array.length <= 1) {
return null;
}
return array[array.length - 2];
}

/**
* @param array array of String objects
* @param value value to check array for
* @return true if the array contains the specified `value`
*/ // TODO
public static boolean contains(String[] array, String value) {
if (array == null || array.length == 0) {
return false;
}
for (int i = 0 ; i < array.length; i++) {
if (array[i] == value) {
    return true;
}
}
return false;
}   

/**
* @param array of String objects
* @return an array with identical contents in reverse order
*/ // TODO
public static String[] reverse(String[] array) {
if (array == null || array.length == 0) {
return array;
}
int left = 0;
int right = array.length - 1;
while (left  < right ) {
   swap(array, left++, right--);
}
return array;
}

/**
* @param array array of String objects
* @return true if the order of the array is the same backwards and forwards
*/ // TODO
public static boolean isPalindromic(String[] array) {
if (array == null || array.length == 0) {
        return true;
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
        if (array[left++] != array[right--]) {
            return false;
        }
    }
    return true;
}

/**
 * @param array array of String objects
 * @return true if each letter in the alphabet has been used in the array
 */ // TODO
public static boolean isPangramic(String[] array) {
    if (array == null || array.length == 0) {
        return false;
    }
    boolean[] check = new boolean[26];
    for (String s : array) {
         for (int i = 0 ; i < s.length(); i++) {
            s = s.toLowerCase();
            if (s.charAt(i) != ' ') {
                check[s.charAt(i) - 'a'] = true;
            }    
        }
    }
    for (int i = 0 ; i < check.length; i++) {
        if (check[i] == false) {
            return false;
        }
    }
    return true;
   }
    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }
        for (int i = 0 ; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        return count;
    }
    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        if (array == null || array.length == 0) {
            return null;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != valueToRemove) {
                array[slow++] = array[fast];
            }
        }
        String[] res = new String[slow];
        for (int i = 0 ; i < slow; i++) {
            res[i] = array[i];
        }
        return res;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                array[slow++] = array[fast];
            }
        }
        String[] res = new String[slow];
        for (int i = 0 ; i < slow; i++) {
            res[i] = array[i];
        }
        return res;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        StringBuilder sb = new StringBuilder();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            while (fast < array.length - 1 && array[fast] == array[fast + 1]) {
                sb.append(array[fast]);
                fast++;
            }
            sb.append(array[fast]);
            array[slow++] = sb.toString();
            sb.delete(0, sb.length());
        } 
        String[] res = new String[slow];
        for (int i = 0 ; i < slow; i++) {
            res[i] = array[i];
        }
        return res;
    }
    
    private static void swap(String[] array, int left, int right) {
        String temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


}
