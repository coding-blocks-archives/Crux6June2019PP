package L22_July23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import L25_July26.GenericsFxn.IntegerComparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Jul-2019
 *
 */

public class BinaryTree {

	private Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = construct(null, false);
	}

	private Node construct(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = construct(nn, false);
		}

		return nn;

	}

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
		}

		int nel = si - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;

	}

	public void display() {
		System.out.println("------------------------");
		display(root);
		System.out.println("------------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	int ans = 0;

	public int diameter1() {
		diameter1(root);

		return ans;
	}

	private int diameter1(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = diameter1(node.left);
		int rh = diameter1(node.right);

		int presentNodeDiameterRootNode = lh + rh + 2;
		if (presentNodeDiameterRootNode > ans) {
			ans = presentNodeDiameterRootNode;
		}

		return Math.max(lh, rh) + 1;

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter2(node.left);
		int rd = diameter2(node.right);
		int sp = ht(node.left) + ht(node.right) + 2;

		return Math.max(sp, Math.max(ld, rd));

	}

	private class DiaPair {
		int d = 0;
		int h = -1;
	}

	public int diameter3() {
		return diameter3(root).d;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		int ld = ldp.d;
		int rd = rdp.d;
		int sp = ldp.h + rdp.h + 2;

		sdp.d = Math.max(sp, Math.max(ld, rd));
		sdp.h = Math.max(ldp.h, rdp.h) + 1;

		return sdp;

	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);

		if ((bf == -1 || bf == 0 || bf == 1) && lb && rb) {
			return true;
		} else {
			return false;
		}

	}

	private class BalPair {
		boolean b = true;
		int h = -1;
	}

	public boolean isBalanced2() {
		return isBalanced2(root).b;
	}

	private BalPair isBalanced2(Node node) {

		if (node == null) {
			return new BalPair();
		}

		BalPair lbp = isBalanced2(node.left);
		BalPair rbp = isBalanced2(node.right);

		BalPair sbp = new BalPair();

		boolean lb = lbp.b;
		boolean rb = rbp.b;

		int bf = lbp.h - rbp.h;

		if ((bf == -1 || bf == 0 || bf == 1) && lb && rb) {
			sbp.b = true;
		} else {
			sbp.b = false;
		}

		sbp.h = Math.max(lbp.h, rbp.h) + 1;

		return sbp;

	}

	public boolean flipEquivalent(BinaryTree other) {
		return flipEquivalent(this.root, other.root);
	}

	private boolean flipEquivalent(Node n1, Node n2) {

		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 == null || n2 == null) {
			return false;
		}

		if (n1.data != n2.data) {
			return false;
		}

		boolean o1 = flipEquivalent(n1.left, n2.left);
		boolean o2 = flipEquivalent(n1.right, n2.right);

		boolean o3 = flipEquivalent(n1.left, n2.right);
		boolean o4 = flipEquivalent(n1.right, n2.left);

		return (o1 && o2) || (o3 && o4);

	}

	// NLR : preorder
	// NRL : postorder rev
	// LNR : inorder
	// RNL : inorder rev
	// LRN : postorder
	// RLN : preoder rev
	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	private class Pair {
		Node n;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderI() {

		Stack<Pair> stack = new Stack<>();

		Pair sp = new Pair();
		sp.n = root;
		stack.push(sp);

		while (!stack.isEmpty()) {

			Pair tp = stack.peek();

			if (tp.sd == false) {
				System.out.print(tp.n.data + " ");
				tp.sd = true;
			} else if (tp.ld == false) {
				Pair np = new Pair();
				np.n = tp.n.left;

				if (np.n != null)
					stack.push(np);

				tp.ld = true;
			} else if (tp.rd == false) {
				Pair np = new Pair();
				np.n = tp.n.right;

				if (np.n != null)
					stack.push(np);

				tp.rd = true;
			} else {
				stack.pop();
			}

		}

		System.out.println();

	}

	int maxsum = Integer.MIN_VALUE;

	public int maxSubtreeSum() {
		maxSubtreeSum(root);

		return maxsum;
	}

	private int maxSubtreeSum(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = maxSubtreeSum(node.left);
		int rs = maxSubtreeSum(node.right);

		int ans = ls + rs + node.data;

		if (ans > maxsum)
			maxsum = ans;

		return ans;

	}

	private class SubtreePair {
		int entireSum = 0;
		int maxsum = Integer.MIN_VALUE;
	}

	public int maxSubtreeSum2() {
		return maxSubtreeSum2(root).maxsum;
	}

	private SubtreePair maxSubtreeSum2(Node node) {

		if (node == null) {
			return new SubtreePair();
		}

		SubtreePair lsp = maxSubtreeSum2(node.left);
		SubtreePair rsp = maxSubtreeSum2(node.right);

		SubtreePair ssp = new SubtreePair();

		ssp.entireSum = lsp.entireSum + rsp.entireSum + node.data;

		ssp.maxsum = Math.max(ssp.entireSum, Math.max(lsp.maxsum, rsp.maxsum));

		return ssp;

	}

	private class BSTPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		Node largestBSTRoot;
		int size;
	}

	public boolean isTreeBST() {
		BSTPair res = isTreeBST(root);

		System.out.println(res.largestBSTRoot.data);
		System.out.println(res.size);

		return res.isBST;
	}

	private BSTPair isTreeBST(Node node) {

		if (node == null) {
			return new BSTPair();
		}

		BSTPair lbp = isTreeBST(node.left);
		BSTPair rbp = isTreeBST(node.right);

		BSTPair sbp = new BSTPair();

		if (lbp.isBST && rbp.isBST && node.data > lbp.max && node.data < rbp.min) {
			sbp.isBST = true;

			sbp.largestBSTRoot = node;
			sbp.size = lbp.size + rbp.size + 1;
		} else {
			sbp.isBST = false;

			if (lbp.size >= rbp.size) {
				sbp.largestBSTRoot = lbp.largestBSTRoot;
				sbp.size = lbp.size;
			} else {
				sbp.largestBSTRoot = rbp.largestBSTRoot;
				sbp.size = rbp.size;
			}

		}

		sbp.max = Math.max(node.data, Math.max(lbp.max, rbp.max));
		sbp.min = Math.min(node.data, Math.min(lbp.min, rbp.min));

		return sbp;

	}

	private class VOPair implements Comparable<VOPair>{
		int val;
		int hlevel;
		int vlevel;

		public VOPair(int val, int hlevel, int vlevel) {
			this.val = val;
			this.hlevel = hlevel;
			this.vlevel = vlevel;
		}

		@Override
		public String toString() {
			return val + "";
		}

		@Override
		public int compareTo(VOPair o) {
			return this.hlevel - o.hlevel ;
		}
	}

	public void verticalDisplay() {

		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();

		verticalDisplay(root, map, 0, 0);

		ArrayList<Integer> allkeys = new ArrayList<>(map.keySet()) ;
		Collections.sort(allkeys);
		
		for(int key : allkeys) {
			ArrayList<VOPair> list = map.get(key) ;
			Collections.sort(list);
			
			System.out.println(key + " -> " + list);
		}
		
		System.out.println(map);
	}

	private void verticalDisplay(Node node, HashMap<Integer, ArrayList<VOPair>> map, int vl, int hl) {

		if (node == null) {
			return;
		}

		if (!map.containsKey(vl)) {
			map.put(vl, new ArrayList<>());
		}

		VOPair np = new VOPair(node.data, hl, vl);
		map.get(vl).add(np);

		verticalDisplay(node.left, map, vl - 1, hl + 1);
		verticalDisplay(node.right, map, vl + 1, hl + 1);

	}

	
	
}
