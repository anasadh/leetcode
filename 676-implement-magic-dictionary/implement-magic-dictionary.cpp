struct Node {
    Node* links[26] = {NULL};
    bool end = false;

    bool contain(char ch) {
        return links[ch - 'a'] != NULL;
    }

    void put(char ch, Node* node) {
        links[ch - 'a'] = node;
    }

    Node* get(char ch) {
        return links[ch - 'a'];
    }

    bool isEnd() {
        return end;
    }

    void setEnd() {
        end = true;
    }
};

class MagicDictionary {
public:
    Node* root;

    MagicDictionary() {
        root = new Node();
    }

    void insert(string& s) {
        Node* node = root;
        for (char c : s) {
            if (!node->contain(c)) {
                node->put(c, new Node());
            }
            node = node->get(c);
        }
        node->setEnd();
    }

    void buildDict(vector<string> dictionary) {
        for (auto& word : dictionary) {
            insert(word);
        }
    }

    bool dfs(Node* node, string& word, int index, bool changed) {
        if (!node) return false;
        if (index == word.size()) return changed && node->isEnd();

        char curr = word[index];
        for (char c = 'a'; c <= 'z'; c++) {
            if (node->contain(c)) {
                
                if (c == curr) {
                    if (dfs(node->get(c), word, index + 1, changed)) {
                        return true;
                    }
                } else if (!changed) {
                    if (dfs(node->get(c), word, index + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    bool search(string searchWord) {
        return dfs(root, searchWord, 0, false);
    }
};