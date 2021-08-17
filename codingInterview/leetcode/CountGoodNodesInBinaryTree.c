/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 */
void recursiveFindGoodNodes(struct TreeNode* current, int maxValue, int* count) {
    if (current == NULL)
    {
        return;
    }
    else
    {
        if (current -> val > maxValue) 
        {
            (*count)++;
            maxValue = current -> val;
        }
        else if(current -> val == maxValue)
        {
            (*count)++;
        }
        else
        {
            ;
        }
        recursiveFindGoodNodes(current -> left, maxValue, count);
        recursiveFindGoodNodes(current -> right, maxValue, count); 
    }
}

int goodNodes(struct TreeNode* root){
    int count = 0;
    recursiveFindGoodNodes(root, root -> val, &count);
    return count;
}
