class Solution {
    public String maskPII(String s) {
        s = s.trim();
        
        // Case 1: Email
        if (s.contains("@")) {
            s = s.toLowerCase();
            String[] parts = s.split("@");
            String name = parts[0];
            String domain = parts[1];
            
            // First and last letters remain, middle replaced with 5 asterisks
            return "" + name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
        }
        
        // Case 2: Phone number
        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) digits.append(c);
        }
        
        String local = digits.substring(digits.length() - 10);
        String maskedLocal = "***-***-" + local.substring(6);
        
        int countryLen = digits.length() - 10;
        if (countryLen == 0) return maskedLocal;
        
        StringBuilder countryMask = new StringBuilder("+");
        for (int i = 0; i < countryLen; i++) countryMask.append("*");
        return countryMask + "-" + maskedLocal;
    }
}
