package com.lfs.binarysearchtree;

/*
    二叉搜索树
    根节点值 大于 左子树节点  小于 右子树节点
 */
public class BSTTree {
    BSTNode root; // 根节点

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;


        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /*    public Object get(int key) {
            return doGet(root, key);
        }

        private Object doGet(BSTNode node, int key) {
            if (node == null) return null;

            if (key < node.key) {
                return doGet(node.left, key);
            } else if (key > node.key) {
                return doGet(node.right, key);
            } else {
                return node.value;
            }
        }*/
    // 根据key找到对应的值-当前key与root key相比大了向右,小了向左
    public Object get(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null; // 没找到
    }

    // 找最小关键字对应的值-向左走走到头 看是否有左孩子
    public Object min() {
        return min(root);
    }

    private Object min(BSTNode node) {
        BSTNode p = node;
        if (p == null) return null;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    // 找最大值
    public Object max() {
        return max(root);
    }

    // 代码更通用,找任意节点作为起点的最大值
    private Object max(BSTNode node) {
        BSTNode p = node;
        if (p == null) return null;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }


    // 存储关键字和对应的值
    /*
        1、更新
        2、添加 需要知道父节点
     */
    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node;// 记录走过的路
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;

            } else {
                // 1、key存在 更新
                node.value = value;
                return;
            }
        }
        // 空树
        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }

        // 2、key不存在 新增
        // 判断是左孩子还是右孩子
        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }

    // 找节点的前任值
    /*
        1、节点有左子树，前任为左子树的最大值
        2、节点没有左子树，若离它最近的、自左而来的祖先就是前任(自左而来就是向右走)
     */
    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                ancestorFromLeft = p;//向右走就记录路径
                p = p.right;
            } else {
                break;// 找到了退出循环进入下面的代码
            }
        }
        if (p == null) return null;

        // 1、节点有左子树，前任为左子树的最大值
        if (p.left != null) {
            return max(p.left);
        }

        // 2、节点没有左子树，若离它最近的、自左而来的祖先就是前任
        return ancestorFromLeft != null ?
                ancestorFromLeft.value : null;
    }

    // 找节点的后任值 和求前任同理
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;//向左走就记录路径
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                break;// 找到了退出循环进入下面的代码
            }
        }
        if (p == null) return null;

        // 1、节点有右子树，前任为右子树的最小值
        if (p.right != null) {
            return min(p.right);
        }

        // 2、节点没有右子树，若离它最近的、自右而来的祖先就是前任
        return ancestorFromRight != null ?
                ancestorFromRight.value : null;
    }

    // 删除操作
    public Object delete(int key) {
        BSTNode p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                break;// 找到了

            }
        }
        return null;
    }
}
