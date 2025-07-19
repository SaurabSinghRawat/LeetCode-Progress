class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // Step 1: Sort the folders
        List<String> result = new ArrayList<>();
        String prev = ""; // Track last added root folder
        
        for (String f : folder) {
            if (prev.isEmpty() || !f.startsWith(prev + "/")) {
                result.add(f);
                prev = f; // Update the current root
            }
        }
        return result;
    }
}
