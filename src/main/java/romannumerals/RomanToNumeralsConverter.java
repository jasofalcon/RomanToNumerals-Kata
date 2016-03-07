package romannumerals;import java.util.HashMap;public class RomanToNumeralsConverter {    private HashMap<Character, Integer> romanToNumeralsMap;    private char[] duplicates = new char[]{'I', 'X', 'C'};    private char[] inputCharacters;    public RomanToNumeralsConverter() {        romanToNumeralsMap = new HashMap<Character, Integer>();        {            romanToNumeralsMap.put('I', 1);            romanToNumeralsMap.put('V', 5);            romanToNumeralsMap.put('X', 10);            romanToNumeralsMap.put('L', 50);            romanToNumeralsMap.put('C', 100);            romanToNumeralsMap.put('D', 500);            romanToNumeralsMap.put('M', 1000);        }    }    private void validateInput() throws IllegalAccessException {        for (int i = inputCharacters.length - 1; i >= 0; i--) {            for (char duplicate : duplicates) {                if ((i >= 3) && (duplicate == inputCharacters[i]) &&                        (duplicate == inputCharacters[i - 1]) &&                        (duplicate == inputCharacters[i - 2]) &&                        (duplicate == inputCharacters[i - 3])) {                    throw new IndexOutOfBoundsException();                }            }        }    }    public int convert(String input) throws IllegalAccessException {        int result = 0, previous = 0;        inputCharacters = input.toCharArray();        validateInput();        for (int i = inputCharacters.length - 1; i >= 0; i--) {            int current = romanToNumeralsMap.get(inputCharacters[i]);            if (current >= previous) {                result += current;            } else {                result -= current;            }            previous = current;        }        return result;    }}