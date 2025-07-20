class Solution {
    // Trie node structure
    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String name;
        boolean deleted = false;

        TrieNode(String name) {
            this.name = name;
        }
    }

    TrieNode root = new TrieNode("");
    Map<String, List<TrieNode>> subtreeMap = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Step 1: Build the Trie
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode(folder));
                curr = curr.children.get(folder);
            }
        }

        // Step 2: Serialize each subtree and track duplicates
        serialize(root);

        // Step 3: Mark all duplicates
        for (List<TrieNode> nodeList : subtreeMap.values()) {
            if (nodeList.size() > 1) {
                for (TrieNode node : nodeList) {
                    node.deleted = true;
                }
            }
        }

        // Step 4: DFS to collect valid paths
        List<List<String>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        // Sort keys to ensure consistent serialization
        List<String> keys = new ArrayList<>(node.children.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            TrieNode child = node.children.get(key);
            String serialized = serialize(child);
            sb.append("(").append(key).append(serialized).append(")");
        }

        String serialization = sb.toString();
        subtreeMap.computeIfAbsent(serialization, k -> new ArrayList<>()).add(node);
        return serialization;
    }

    private void dfs(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (!child.deleted) {
                path.add(child.name);
                result.add(new ArrayList<>(path));
                dfs(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
